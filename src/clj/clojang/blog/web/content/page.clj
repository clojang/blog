(ns clojang.blog.web.content.page
  (:require [clojang.blog.web.content.data :as data]
            [dragon.web.content :as content]))

(defn front-page
  [data]
  (content/render
    "templates/front-page.html"
    data/index))

(defn about
  []
  (content/render
    "templates/about.html"
    data/about))

(defn post
  [data]
  (content/render
    "templates/post.html"
    (merge data/archives data)))

(defn archives
  [data]
  (content/render
    "templates/archives.html"
    (merge data/archives data)))

(defn categories
  [data]
  (content/render
    "templates/categories.html"
    (merge data/categories data)))

(defn tags
  [data]
  (content/render
    "templates/tags.html"
    (merge data/tags data)))

(defn authors
  [data]
  (content/render
    "templates/authors.html"
    (merge data/authors data)))

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
