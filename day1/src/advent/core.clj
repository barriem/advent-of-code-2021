(ns advent.core
  (:require [clojure.java.io :as io]
            [clojure.string :as string]))

(def data-file (io/resource "input.txt"))

(defn- read-lines [file]
    (clojure.string/split-lines 
      (slurp file)))

(defn- get-int-array [lines]
  (map #(Integer/parseInt %) lines))

(defn -main
  "Find the number of times the depth increases."
  []
  (-> data-file
    (read-lines)
    (get-int-array)
    (println)))
