(ns xmr.models.migration
  (:require [clojure.java.jdbc :as sql]
            [xmr.models.course :as course]))

(defn migrated? []
  (not (zero?
        (sql/with-connection course/db-path
          (sql/with-query-results results
            ["select count(*) from information_schema.tables where table_name='courses'"]
            (:count (first results)))))))

(defn migrate []
  (when (not (migrated?))
    (print "Creating database structure..." (flush))
    (sql/with-connection course/db-path
      (sql/create-table :courses
                        [:id :int "PRIMARY KEY"]
                        [:name "varchar(255)"]
                        [:codename "varchar(255)"]
                        [:created_at :timestamp "NOT NULL" "DEFAULT CURRENT_TIMESTAMP"])
      (sql/create-table :exams
                        
                        [:id :int "PRIMARY KEY"]
                        [:title "varchar(255)"]
                        [:codename "varchar(255)"]
                        [:created_at :timestamp "NOT NULL" "DEFAULT CURRENT_TIMESTAMP"]
                        [:course_id :serial "references courses (id) on delete set null on update cascade"]))
    (println " done")))
    
