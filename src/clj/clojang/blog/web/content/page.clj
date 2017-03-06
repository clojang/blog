(ns clojang.blog.web.content.page
  (:require [clojang.blog.web.content.data :as data]
            [selmer.parser :as selmer]))

(defn front-page
  ([]
    (front-page {}))
  ([req]
    (selmer/render-file
      "templates/front-page.html"
      (data/index req))))

(defn about
  ([]
    (about {}))
  ([req]
    (selmer/render-file
      "templates/about.html"
      (data/about req))))

(defn credits
  ([]
    (credits {}))
  ([req]
    (selmer/render-file
      "templates/credits.html"
      (data/credits req))))

(defn starter
  ([]
    (starter {}))
  ([req]
    (selmer/render-file
      "templates/starter.html"
      (data/starter req))))

(defn post
  ([]
    (post {}))
  ([req]
    (selmer/render-file
      "templates/post.html"
      (data/post req))))

(defn bootstrap-theme
  ([]
    (bootstrap-theme {}))
  ([req]
    (selmer/render-file
      "templates/bootstrap-theme.html"
      (data/base req))))

(defn blog-example
  ([]
    (blog-example {}))
  ([req]
    (selmer/render-file
      "templates/blog-example.html"
      (data/base req))))
