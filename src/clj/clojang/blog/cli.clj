(ns clojang.blog.cli
  (:require [clojure.pprint :refer [pprint]]
            [clojusc.twig :as logger]
            [clojang.blog.cli.new :as new]
            [clojang.blog.cli.show :as show]
            [clojang.blog.generator :as generator]
            [clojang.blog.util :as util]
            [clojang.blog.web :as web]
            [taoensso.timbre :as log]
            [trifl.core :refer [sys-prop]]
            [trifl.docs :as docs]))

(defn help-cmd
  [& args]
  (docs/print-docstring 'clojang.blog.cli 'run))

(defn version-cmd
  []
  (let [version (sys-prop "blog.version")
        build (util/get-build)]
    (print (format "Clojang blog tool version %s, build %s\n" version build))))

(defn run
  "
  Usage:
  ```
    blog COMMAND [help | arg...]
    blog [-h | --help | -v | --version]
  ```

  Commands:
  ```
    new      Create stubbed files for a new blog post
    show     Display various blog data in the terminal
    gen      Generate updated static content for blog
    run      Run the Clojang blog locally as a Ring app
    help     Display this usage message
    version  Display the current NOWA version
  ```

  More information:

    Each command takes an optional 'help' subcommand that will provide
    usage information about the particular command in question, e.g.:

  ```
    $ blog new help
  ```"
  [[cmd & args]]
  (log/debug "Got cmd:" cmd)
  (log/debug "Got args:" args)
  (case cmd
    :new (new/run args)
    :show (show/run args)
    :gen (generator/run args)
    :run (web/run)
    :help (help-cmd args)
    :version (version-cmd)
    ;; Aliases
    :--help (help-cmd args)
    :--version (version-cmd)
    :-h (help-cmd args)
    :-v (version-cmd))
  (shutdown-agents))
