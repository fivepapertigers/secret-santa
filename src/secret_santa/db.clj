(ns secret_santa.db
  (:require [secret_santa.env :refer :all]))

(def db
  {:classname "org.postgresql.Driver"
   :subprotocol "postgresql"
   :subname DB_SUBNAME
   })
