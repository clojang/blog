(ns clojang.blog.dev
  "Clojang blog development namespace

  This namespace is particularly useful when doing active development on the
  Clojang blog application."
  (:require [clojang.blog.cli :as cli]
            [clojang.blog.generator :as generator]
            [clojang.blog.main :as main]
            [clojang.blog.util :as util]
            [clojang.blog.web :as web]
            [clojang.blog.web.content.data :as data]
            [clojang.blog.web.content.page :as page]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [clojure.pprint :refer [pprint print-table]]
            [clojure.reflect :refer [reflect]]
            [clojure.string :as string]
            [clojure.tools.namespace.repl :as repl]
            [clojure.walk :refer [macroexpand-all]]
            [clojusc.twig :as logger]
            [selmer.parser :as selmer]
            [taoensso.timbre :as log]
            [trifl.java :as java]))

(logger/set-level! ['clojang.blog] :debug)

(def show-methods #'java/show-methods)

;;; Aliases

(def reload #'repl/refresh)
(def reset #'repl/refresh)
