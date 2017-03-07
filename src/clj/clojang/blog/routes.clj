(ns clojang.blog.routes
  (:require [clojang.blog.web.content.page :as page]))

(def routes
  {"/index.html" (page/front-page)
   "/about.html" (page/about)
   "/credits.html" (page/credits)
   "/starter.html" (page/starter)
   "/post.html" (page/post)
   "/design/index.html" (page/design)
   "/design/bootstrap-theme.html" (page/bootstrap-theme)
   "/design/example-blog.html" (page/blog-example)})
