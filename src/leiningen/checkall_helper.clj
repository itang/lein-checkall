(ns leiningen.checkall-helper 
  (:require [clojure.java.io :refer :all]
            [leinjacker.deps :as deps]
            [leinjacker.eval :refer [eval-in-project]]
            [me.raynes.conch.low-level :as sh]))

(defn- wrap-cmd [cmd]
  (let [^String os-name (get (System/getProperties) "os.name")]
    (if (.contains os-name "Windows")
      (str cmd ".bat")
      cmd)))

(defn- output [p]
  (doseq [line (line-seq (-> p :out input-stream reader))]
    (println line)))

(defn- sh [cmd & more]
  (output (apply sh/proc cmd more)))

(defn lein [& more]
  (apply sh (wrap-cmd "lein") more))

(defn- update-project
  "Update the project map using a function."
  [project func & args]
  (vary-meta
   (apply func project args)
   update-in [:without-profiles] #(apply func % args)))

(defn add-dep [project dep]
  (update-project project deps/add-if-missing dep))
