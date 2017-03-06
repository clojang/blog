(ns clojang.blog.web
  (:require [clojang.blog.config :as config]
            [clojang.blog.web.content.page :as page]
            [org.httpkit.server :as server]
            [stasis.core :as stasis]
            [taoensso.timbre :as log]))

(def routes
  {"/index.html" (page/front-page)
   "/about.html" (page/about)
   "/credits.html" (page/credits)
   "/starter.html" (page/starter)
   "/post.html" (page/post)
   "/design/index.html" (page/design)
   "/design/bootstrap-theme.html" (page/bootstrap-theme)
   "/design/example-blog.html" (page/blog-example)})

(def app (stasis/serve-pages routes))

(defn run
  [& args]
  (let [port (config/get-port)]
    (log/infof (str "Starting development HTTP server on port %s "
                    "using dynamic content ...")
               port)
    (server/run-server app {:port port})))
