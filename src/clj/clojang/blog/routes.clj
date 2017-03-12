(ns clojang.blog.routes
  "The routes for the blog need to take into consideration the following:

   * Actual posts will be generated behind the scenes when processing on-disk
     content (e.g., when calling `process-all-by-year-and-month`).
   * The routes are only used durng development, when serving content
     dynamically.
   * Since the posts have already been generated and saved to disc, their
     routes should be generated dynamically as URI path / slurp call pairs.
  "
  (:require [clojang.blog.web.content.page :as page]
            [dragon.blog :as blog]))

(defn routes
  []
  (let [uri-base "/archives"
        data (blog/process uri-base)]
    (merge
      (blog/get-archive-routes
        data
        :gen-func page/post
        :uri-base uri-base)
      {"/index.html" (page/front-page data)
       "/about.html" (page/about)
       "/archives/index.html" (page/archives (blog/data-for-archives data))
       "/categories/index.html" (page/categories (blog/data-for-categories data))
       "/tags/index.html" (page/tags (blog/data-for-tags data))
       "/authors/index.html" (page/authors (blog/data-for-authors data))
       ;; The remaining pages are for design purposes only; no access to data needed
       "/design/index.html" (page/design)
       "/design/bootstrap-theme.html" (page/bootstrap-theme)
       "/design/example-blog.html" (page/blog-example)})))
