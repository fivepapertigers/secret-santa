(ns secret_santa.participant
  (:require [compojure.core :refer :all]
            [ring.util.response :refer [response]]))

(def users [{:id 1 :name "Jake" :email "jacobagriswold@gmail.com"}
            {:id 2 :name "Amanda" :email "amanda.mckrell@gmail.com"}
            {:id 3 :name "Alex" :email "alex.griswold@gmail.com"}])

(defn get-one [id]
  (let [id (Integer. id)]
    (first
      (filter (fn [obj] (== id (obj :id))) users))))

(defroutes participant-routes
  (GET "/api/participants/:user_id" [user_id]
    (response (get-one user_id)))
  (GET "/api/participants" []
    (response users)))

