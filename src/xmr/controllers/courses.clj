(ns xmr.controllers.courses
  (:use [compojure.core :only (defroutes GET POST)])
  (:require [clojure.string :as str]
            [ring.util.response :as ring]
            [xmr.views.layout :as view]
            [xmr.models.course :as model]))

(defn index []
  (view/all (model/all)))

;; (defn create
;;   [course]
;;   (when-not (str/blank? course)
;;     (model/create course))
;;   (ring/redirect "/"))

(def routes
  (GET "/" [] (index))
  ;(POST "/" [course] (create course))
)
