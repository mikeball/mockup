(ns leiningen.mockup.mock
  (:require [clojure.tools.reader.edn :as edn]
            [clojure.java.io :as io]
            [clojure.string :as string]
            [taoclj.mustache :as mustache]
            [ring.server.standalone :as ring-server]
            ring.middleware.refresh)
  (:import (java.io FileInputStream)))



(defn wrap-ignored [handler]
  (fn [request]
    ; if the requested :uri is in the list of ignored paths, return 404
    (if (some #(= % (:uri request)) ["/favicon.ico" "/robots.txt"])
      {:status 404}
      (handler request))))



(defn get-id [path]
  (let [full-path (if (.endsWith path "/") (str path "index") path)]
    (keyword (subs (string/replace full-path "/" ".") 1))))

(defn get-path [id]
  (string/replace (name id) "." "/"))





(def content-types {"css"  "text/css"
                    "js"   "application/javascript"
                    "gif"  "image/gif"
                    "jpg"  "image/jpeg"
                    "png"  "image/png"
                    "pdf"  "application/pdf"
                    "txt"  "text/plain"
                    "woff" "font/woff"})

(defn infer-content-type [uri]
  (let [extension (last (string/split uri #"\."))
        content-type (content-types extension)]
    (if-not content-type
      (throw (Exception. (str "Unable to determine HTTP content-type for " uri)))
      content-type)))





(defn is-asset? [uri]
  (.startsWith uri "/_assets/"))



; not unit tested below this comment!!

(def ^:dynamic *templates-directory* "ui")
(def ^:dynamic *templates-extension* "tpl")
; (def ^:dynamic *assets-directory* "_assets")




(defn file-exists? [path]
  (.exists (io/as-file path)))

(defn asset-handler [uri]
  ;(println "asset: " uri)
  (let [path (str *templates-directory* uri)]
    (if-not (file-exists? path)
      {:status 404 :body (str path " not found")}
      {:status 200
       :headers {"Content-Type" (infer-content-type path)}
       :body (io/FileInputStream. path)})))

(defn wrap-assets [handler]
  (fn [request]
    (let [uri (:uri request)]
      ; if the path has an extension, return asset file
      (if (some #(.endsWith uri %) (keys content-types))
        (asset-handler uri)
        (handler request)))))



; (some #(.endsWith "/test.csx" %) (keys content-types))


(def renderer (mustache/gen-renderer *templates-directory*
                                     *templates-extension*
                                     false))

(defn get-template-path [id]
  (str *templates-directory* "/"
       (get-path id) "."
       *templates-extension*))

(defn load-data [id]
  (let [path (str (get-template-path id) ".edn")]
    (if (file-exists? path)
      (edn/read-string (slurp path)))))


(defn template-handler [request]
  (let [uri (:uri request)
        id (get-id uri)
        path (get-template-path id)]
    (println "template: " uri)
    (if-not (file-exists? path)
      {:status 404 :body (str "template " path " not found")}
      {:status 200
       :headers {"Content-Type" "text/html"}
       :body (renderer id (load-data id))}
      )))



(def dispatch
  (-> template-handler
      (wrap-assets)
      (wrap-ignored)))

(def dispatch-refreshed
  (-> dispatch
      (ring.middleware.refresh/wrap-refresh ["ui"])))

(defn start [handler]
  (println "now starting to serve mockup...")
  (ring-server/serve handler
                     {:join? true}))


(defn  live [project]
  (start dispatch-refreshed))


; perhaps serve should be in different namespace?
(defn  serve [project]
  (start dispatch))










