(ns clojang.blog.generator
  (:require [clojang.blog.config :as config]
            [clojang.blog.web :as web]
            [stasis.core :as stasis]
            [taoensso.timbre :as log]))

(defn run
  [& args]
  (let [out-dir (config/get-output-dir)]
    (log/infof "Generating static content to %s ..." out-dir)
    (stasis/export-pages
      web/routes
      out-dir)
    (log/info "Static generation complete.")))
