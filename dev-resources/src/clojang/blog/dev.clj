(ns clojang.blog.dev
  "Clojang blog development namespace

  This namespace is particularly useful when doing active development on the
  Clojang blog application."
  (:require [clojang.blog.cli :as cli]
            [clojang.blog.main :as main]
            [clojang.blog.routes :as routes]
            [clojang.blog.web.content.data :as page-data]
            [clojang.blog.web.content.page :as page]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [clojure.pprint :refer [pprint print-table]]
            [clojure.reflect :refer [reflect]]
            [clojure.string :as string]
            [clojure.tools.namespace.repl :as repl]
            [clojure.walk :refer [macroexpand-all]]
            [clojusc.twig :as logger]
            [dragon.blog :as blog]
            [dragon.blog.post :as blog-post]
            [dragon.config :as config]
            [dragon.content.rfc5322 :as rfc5322]
            [dragon.generator :as generator]
            [dragon.util :as util]
            [dragon.web :as web]
            [dragon.web.content :as content]
            [markdown.core :as md]
            [selmer.parser :as selmer]
            [taoensso.timbre :as log]
            [trifl.fs :as fs]
            [trifl.java :as java]))

(logger/set-level! '[clojang dragon] :trace)

(defonce server (atom nil))

(def show-methods #'java/show-methods)

(defn gen
  []
  (-> (config/posts-path)
      (routes/routes)
      (generator/run)))

(defn run
  []
  (-> (config/posts-path)
      (routes/routes)
      (web/run (config/port))))

(defn start
  []
  (reset! server (run))
  :started)

(defn stop
  []
  (when-not (nil? @server)
    (@server :timeout 100)
    (reset! server nil)
    :stopped))

;;; Aliases

(def reload #'repl/refresh)
(def reset #'repl/refresh)
