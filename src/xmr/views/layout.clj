(ns xmr.views.layout
  (:require [hiccup.page :as page]))

(defn common [title & body]
  (page/html5
   [:head
    [:meta {:charset "utf-8"}]
    [:meta {:http-equiv "X-UA-Compatible" :content "IE=edge,chrome=1"}]
    [:meta {:name "viewport" :content
            "width=device-width, initial-scale=1, maximum-scale=1"}]
    [:title title]
    (page/include-css "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css")
    (page/include-css "/css/starter-template.css")]
   [:body
    [:nav.navbar.navbar-inverse.navbar-fixed-top
     [:div.container
      [:div.navbar-header
       [:a.navbar-brand "xmr.clj"]]
      [:div#navbar.collapse.navbar-collapse
       [:ul.nav.navbar-nav
        [:li.active
         [:a {:href "#"} "Hello world"]]]]]]
    [:div.container body]]))

(defn index []
  (common "xmr.clj"
          [:div.starter-template
           [:h1 "Bootstrap starter template"]
           [:p.lead "Use this document as a way to quickly start any new project."]]))

(defn all [courses]
  (common "xmr.clj"
          [:div.starter-template
           [:h1 "all Bootstrap starter template"]
           [:ul
            [:li "test2"]
            (for [course courses]
              [:li course])]]))
