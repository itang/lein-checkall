(ns leiningen.checkall
  (:require [clojure.string :as str]
            [leiningen.check :refer [check]]
            [leiningen.kibit :refer [kibit]]
            [leiningen.eastwood :refer [eastwood]]
            [leiningen.bikeshed :refer [bikeshed]]))

(defn- print-line [s ft]
  (println (str (when-not ft "\n\n\n")
             s
             (str/join "" (repeat (- 70 (count s)) "=")))))

(defn- do-check [project msg check-fn & {:keys [first?] :or {first? false}}]
  (print-line msg first?)
  (check-fn project)
  project)

(defn- do-checks [project]
  (-> project
    (do-check "[lein check]" check :first? true)
    (do-check "[lein kibit]" kibit)
    (do-check "[lein eastwood]" eastwood)
    (do-check "[lein bikeshed]" bikeshed)))

(defn checkall
  "lein check && lein kibit && lein eastwood && lein bikeshed"
  [project & args]
  (do-checks project))
