(ns leiningen.new.mockup
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "mockup"))


(defn mockup
  "Generate a skeleton for a new mockup"
  [name]
  (let [path (name-to-path name)
        data {:name name :path path :child "{{{ child-content }}}"}]

    (main/info (str "Generating your " name " mockup project..."))

    (->files data
             ["project.clj" (render "project.clj" data)]
             ["README.md" (render "README.md" data)]

             ; for local plugin development, remove before deploy...
             ; [".lein-classpath" (render ".lein-classpath")]

             ; assets
             ["ui/_assets/site.css"  (render "ui/_assets/site.css")]


             ; top level templates
             ["ui/master.tpl"           (render "ui/master.tpl")]
             ["ui/master-service.tpl"   (render "ui/master-service.tpl")]

             ; start page
             ["ui/index.tpl"      (render "ui/index.tpl" data)]


             ; site level pages
             [(str "ui/" path "/site.tpl")           (render "ui/example-site/site.tpl" data)]
             [(str "ui/" path "/site-public.tpl")    (render "ui/example-site/site-public.tpl")]
             [(str "ui/" path "/login.tpl")           (render "ui/example-site/login.tpl" data)]

             ; registration section pages
             [(str "ui/" path "/register/activate.tpl")          (render "ui/example-site/register/activate.tpl" data)]
             [(str "ui/" path "/register/activation-email.tpl")  (render "ui/example-site/register/activation-email.tpl" data)]
             [(str "ui/" path "/register/confirm.tpl")           (render "ui/example-site/register/confirm.tpl" data)]
             [(str "ui/" path "/register/index.tpl")             (render "ui/example-site/register/index.tpl" data)]

             ; password reset pages
             [(str "ui/" path "/reset/complete.tpl")   (render "ui/example-site/reset/complete.tpl" data)]
             [(str "ui/" path "/reset/confirm.tpl")    (render "ui/example-site/reset/confirm.tpl" data)]
             [(str "ui/" path "/reset/email.tpl")      (render "ui/example-site/reset/email.tpl" data)]
             [(str "ui/" path "/reset/index.tpl")      (render "ui/example-site/reset/index.tpl" data)]


             ; standard site pages
             [(str "ui/" path "/index.tpl")           (render "ui/example-site/index.tpl" data)]
             [(str "ui/" path "/index.tpl.edn")       (render "ui/example-site/index.tpl.edn" data)]
             [(str "ui/" path "/examples/index.tpl")  (render "ui/example-site/examples/index.tpl" data)]
             [(str "ui/" path "/examples/email.tpl")  (render "ui/example-site/examples/email.tpl" data)]
             [(str "ui/" path "/items/index.tpl")     (render "ui/example-site/items/index.tpl")]
             [(str "ui/" path "/items/index.tpl.edn") (render "ui/example-site/items/index.tpl.edn")]
             [(str "ui/" path "/items/detail.tpl")    (render "ui/example-site/items/detail.tpl" data)]


             ; background services
             ["ui/system/index.tpl"             (render "ui/system/index.tpl")]
             ["ui/system/some-service.tpl"      (render "ui/system/some-service.tpl")]

             )))
