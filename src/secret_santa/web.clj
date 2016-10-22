(ns secret_santa.web
  (:use ring.middleware.reload)
  (:require [compojure.core :refer :all]
            [compojure.route :refer [resources files]]
            [ring.adapter.jetty :as ring]
            [ring.util.response :refer [resource-response]]
            [secret_santa.participant :as participant]
            [ring.middleware.json :refer [wrap-json-response]]))


(defroutes base
  (wrap-json-response participant/participant-routes)
  (GET "/" [] (resource-response "index.html" {:root ""}))
  (resources "/" {:root "javascripts"})
  (files "/" {:root "node_modules"}))





(defn -main []
  (ring/run-jetty (wrap-reload #'base) {:port 8080 :join? false}))

