(ns clojang.blog.dev
  "Clojang blog development namespace

  This namespace is particularly useful when doing active development on the
  Clojang blog application."
  (:require [clojang.blog.cli :as cli]
            [clojang.blog.main :as main]
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

(logger/set-level! ['clojang.blog] :debug)

(def show-methods #'java/show-methods)

;;; Aliases

(def reload #'repl/refresh)
(def reset #'repl/refresh)
