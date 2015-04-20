(ns xmr.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(def testdata
  {:name "Endimensionell analys"
   :codename "FMAA01"
   })

(def db
  {:classname "org.sqlite.JDBC"
   :subprotocol "sqlite"
   :subname "db/database.db"
   })

(defn create-db []
  (try (db-do-commands db
                       (create-table-ddl :courses
                                         [:id :int "PRIMARY KEY"]
                                         [:name "varchar(255)"]
                                         [:codename "varchar(255)"]
                                         [:created_at :timestamp "NOT NULL" "DEFAULT CURRENT_TIMESTAMP"])
                       (create-table-ddl :exams
                                         [:id :int "PRIMARY KEY"]
                                         [:title "varchar(255)"]
                                         [:codename "varchar(255)"]
                                         [:created_at :timestamp "NOT NULL" "DEFAULT CURRENT_TIMESTAMP"]
                                         [:course_id :serial "references courses (id) on delete set null on update cascade"]))
       (catch Exception e (
                           ;println e
                           ))))

(create-db)

(def output
  (query db "select * from courses"))

(defn -main
  (sql/insert! db :news testdata)
  (sql/keys (first output))
  (println (:name (first output)))
)

;; (defroutes app-routes
;;   (GET "/" [] "Hello World")
;;   (route/not-found "Not Found"))

;; (def app
;;   (wrap-defaults app-routes site-defaults))
