(ns leiningen.checkall
  (:require [leinjacker.eval :refer [eval-in-project]]
            [leiningen.checkall-helper :refer :all]))

(defn- add-deps [project]
  (add-dep project '[lein-kibit "0.0.8"])
  (add-dep project '[jonase/eastwood "0.0.2"])
  (add-dep project '[lein-bikeshed "0.1.0"]))

(defn- do-checks []
  (println "[run lein check]")
  (lein "check")

  (println "[run lein kibit]")
  (lein "kibit")

  (println "[run lein eastwood]")
  (lein "eastwood")

  (println "[run lein bikeshed]")
  (lein "bikeshed"))

(defn checkall
  "lein check && lein kibit && lein eastwood && lein bikeshed"
  [project & args]
  (eval-in-project 
    (add-deps project)
    (do-checks)))
