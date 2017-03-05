(ns clojang.blog.cli.show
  (:require [clojure.pprint :refer [pprint]]
            [clojusc.twig :as logger]
            [clojang.blog.config :as config]
            [clojang.blog.meta :as meta]
            [clojang.blog.util :as util]
            [taoensso.timbre :as log]
            [trifl.docs :as docs])
  (:refer-clojure :exclude [meta]))

(defn help-cmd
  [& args]
  (docs/print-docstring 'clojang.blog.cli.show 'run))

(defn run
  "
  Usage:
  ```
    blog show [SUBCOMMAND | help]
  ```

  If no SUBCOMMAND is provided, the default 'config' will be used.

  Subcommands:
  ```
    config          Display the current blog configuration
    port            Display the HTTP port configuration
    metadata        Display the metadata for all posts
    metadata POST   Display the metadata for a given blog post
  ```"
  [[cmd & args]]
  (log/debug "Got cmd:" cmd)
  (log/debug "Got args:" args)
  (case cmd
    :all (pprint (config/blog))
    :port (pprint (config/get-port))
    :metadata (if-let [post (first args)]
                (pprint (meta/get post))
                (pprint (meta/get-all)))
    :help (help-cmd args)
    (pprint (config/blog))))
