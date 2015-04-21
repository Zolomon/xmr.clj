(ns xmr.models.course
  (:require [clojure.java.jdbc :as sql]))

(def db-path
  "resources/database.db")

(defn all []
  (sql/with-connection db-path
    (sql/with-query-results results
      ["select * from courses order by id desc"]
      (into [] results))))

(defn create [name codename]
  (sql/with-connection db-path
    (sql/insert-values :courses [:name :codename] [name codename])))
