(ns secret_santa.sql
  (:require [hugsql.core :refer :all]))

(def-db-fns "secret_santa/sql/participants.sql")