(ns leiningen.mockup.mock-test
  (:use clojure.test
        leiningen.mockup.mock))

(deftest paths-are-converted-to-ids
  (are [path expected] (= (get-id path) expected)
       "/a" :a
       "/a/" :a.index
       "/a/b" :a.b ))

(deftest ids-are-converted-to-paths
  (are [id expected] (= (get-path id) expected)
       :a "a"
       :a.index "a/index"
       :a.b "a/b" ))

(deftest wrap-ignored-ignores
  (are [path expected]
       (= expected
          (-> {:uri path}
              ((wrap-ignored (fn [request] {:status 200})) )
              :status))

       "/" 200
       "/favicon.ico" 404
       "/robots.txt" 404
       "/somepage" 200 ))

(deftest unnecessary-requests-are-ignored
  (are [path] (= 404 (-> (dispatch {:uri "/favicon.ico"})
                         :status ))
       "/favicon.ico"
       "/robots.txt" ))

(deftest content-types-are-inferred
  (are [file expected] (= (infer-content-type file) expected)
       "a.css"  "text/css"
       "a.js"   "application/javascript"
       "a.jpg"  "image/jpeg"
       "a.gif"  "image/gif"
       "a.png"  "image/png"
       "a.pdf"  "application/pdf"
       "a.txt"  "text/plain"
       "a.woff" "font/woff" ))



;; load-data returns nil if file does not exists
;; load-data returns edn from file
;; load-data returns ??? if the edn isn't valid?

