(ns clojang.blog.web.content.page
  (:require [clojang.blog.web.content.data :as data]
            [dragon.web.content :as content]))

(defn front-page
  []
  (content/render
    "templates/front-page.html"
    data/index))

(defn about
  []
  (content/render
    "templates/about.html"
    data/about))

(defn credits
  []
  (content/render
    "templates/credits.html"
    data/credits))

(defn starter
  []
  (content/render
    "templates/starter.html"
    data/starter))

(defn post
  []
  (content/render
    "templates/post.html"
    data/post))

(defn design
  []
  (content/render
    "templates/design.html"
    data/base))

(defn bootstrap-theme
  []
  (content/render
    "templates/bootstrap-theme.html"
    data/base))

(defn blog-example
  []
  (content/render
    "templates/blog-example.html"
    data/base))
