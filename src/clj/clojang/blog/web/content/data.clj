(ns clojang.blog.web.content.data)

(defn base
  ([]
    (base {}))
  ([data]
    (merge
      data
      {:index "index"
       :about "about"
       :community "community"
       :archives "archives"
       :categories "categories"
       :tags "tags"
       :authors "authors"})))

(defn about
  []
  {:page-data (base {:active "about"})})

(defn community
  []
  {:page-data (base {:active "community"})})

(defn design
  []
  {:page-data (base {:active "design"})})

(defn post
  [data]
  {:page-data (base {:active "archives"})
   :post-data data})

(defn archives
  [data]
  {:page-data (base {:active "archives"})
   :posts-data data})

(defn index
  [data]
  {:page-data (base {:active "index"})
   :posts-data data})

(defn categories
  [data]
  {:page-data (base {:active "categories"})
   :posts-data data})

(defn tags
  [data]
  {:page-data (base {:active "tags"})
   :posts-data data})

(defn authors
  [data]
  {:page-data (base {:active "authors"})
   :posts-data data})
