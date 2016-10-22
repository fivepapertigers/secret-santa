(defproject secret_santa "0.0.1"
  :description "Secret Santa app"
  :url "https://github.com/fivepapertigers/secret-santa.git"
  :min-lein-version "2.0.0"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/java.jdbc "0.6.1"]
                 [org.postgresql/postgresql "9.4-1201-jdbc41"]
                 [ring/ring-jetty-adapter "1.4.0"]
                 [metosin/compojure-api "1.1.8"]
                 [compojure "1.4.0"]
                 [ring/ring-json "0.4.0"]
                 [ring "1.5.0"]]
  :main secret_santa.web)