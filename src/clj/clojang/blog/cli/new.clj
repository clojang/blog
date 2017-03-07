(ns clojang.blog.cli.new
  (:require [clojure.pprint :refer [pprint]]
            [clojusc.twig :as logger]
            [clojang.blog.cli.new.post :as post]
            [dragon.util :as util]
            [taoensso.timbre :as log]
            [trifl.docs :as docs]))

(defn help-cmd
  [& args]
  (docs/print-docstring 'clojang.blog.cli.new 'run))

(defn run
  "
  Usage:
  ```
    blog new [SUBCOMMAND | help]
  ```

  If no SUBCOMMAND is provided, the default 'post' will be used (with the
  default content type ':md').

  Subcommands:
  ```
    post    Create a new post stub; takes a subcommand for the type of
              content to create; see 'blog new post help' for usage
  ```"
  [[cmd & args]]
  (log/debug "Got cmd:" cmd)
  (log/debug "Got args:" args)
  (case cmd
    :post (post/run args)
    :help (help-cmd)
    (post/run [:md])))


