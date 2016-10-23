(ns secret_santa.participant
  (:require [compojure.core :refer :all]
            [ring.util.response :refer [response]]
            [secret_santa.db :refer [db]]
            [secret_santa.sql :refer [participants-all participant-by-id]]))

(defn int-id [s] (Integer. s))

(defroutes participant-routes
  ; list
  (GET "/api/participants" []
    (response (participants-all db)))
  ; get by id
  (GET "/api/participants/:user_id" [user_id]
    (response
      (first
        (participant-by-id db
          {:id (int-id user_id)})))))


