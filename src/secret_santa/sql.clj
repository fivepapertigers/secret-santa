(ns secret_santa.sql
  (:require [hugsql.core :refer :all]))

(def-db-fns "secret_santa/sql/participants.sql")

(defn collect-relations [from-key to-key coll & {:keys [res] :or {res {}}}]
  (if (empty? coll)
    (vals res)
    (let [coll (vec coll)
          row (last coll)
          id (row :id)
          new_coll (pop coll)
          rel_val (row from-key)
          new_row
            (if-let [curr (res id)]
              (merge curr {to-key (conj (curr to-key) (row from-key))})
              (merge (dissoc row from-key) {to-key (if rel_val [rel_val] [])}))]
      (collect-relations from-key to-key new_coll :res (merge res {id new_row})))))

(defn participants-all [db]
  (collect-relations :exclude_id :excludes (participants-with-excludes db)))