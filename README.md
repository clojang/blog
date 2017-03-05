# Clojang Blog

*The Official Blog for Clojure/BEAM Language Development*


## Prerequisites

```bash
$ make setup
```

Set the `PATH` to include the project's executable and setup auto-completion:

```bash
$ export PATH=$PATH:`pwd`/bin
$ source dev-resources/shell/blog-bash-autocompletion
```


## Creating Post Stubs

```bash
$ blog new post md
```

or, for example,

```bash
$ blog new post html
```

For more options see `blog new post help`.


## Generating Static Files

```bash
$ blog gen
```

If you'd like to run a dev web server with the generated content served at the
doc root, you can use this `make` target:

```
$ blog blog-dev-generated
```


## Checking Metadata and Content

TBD


## Publishing Content

TBD
