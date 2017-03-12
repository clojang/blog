(ns clojang.blog.web.content.data)

(defn base
  [req]
  (merge
    req
    {:index "index"
     :about "about"
     :archives "archives"
     :categories "categories"
     :tags "tags"
     :authors "authors"}))

(defn index
  [req]
  (merge
    (base req)
    {:active "index"}))

(defn about
  [req]
  (merge
    (base req)
    {:active "about"}))

(defn archives
  [req]
  (merge
    (base req)
    {:active "archives"}))

(defn categories
  [req]
  (merge
    (base req)
    {:active "categories"}))

(defn tags
  [req]
  (merge
    (base req)
    {:active "tags"}))

(defn authors
  [req]
  (merge
    (base req)
    {:active "authors"}))
