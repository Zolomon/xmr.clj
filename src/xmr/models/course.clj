(ns xmr.models.course
  (:require [clojure.java.jdbc :as sql]))

(def db
  {:classname "org.sqlite.JDBC"
   :subprotocol "sqlite"
   :subname "resources/database.db"
   })

(defn all []
  )

;; (defn all []
;;   (sql/with-connection db
;;     (sql/with-query-results results
;;       ["select * from courses order by id desc"]
;;       (into [] results))))

;; (defn create [name codename]
;;   (sql/with-connection db
;;     (sql/insert-values :courses [:name :codename] [name codename])))
