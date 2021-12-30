(ns advent.core
  (:require [clojure.java.io :as io]
            [clojure.string :as string]))

(def data-file (io/resource "input.txt"))

(defn- read-lines [file]
    (clojure.string/split-lines 
      (slurp file)))

(defn- get-int-list [lines]
  (map #(Integer/parseInt %) lines))

(defn- number-of-increases [depths]
  (reduce 
    (fn [state d]
      (let 
        [previous (get state :previous Integer/MAX_VALUE)
         count    (get state :increase-count 0)]
        (if (> d previous) 
          {:previous d :increase-count (inc count)}
          {:previous d :increase-count count})))
    '{} 
    depths))

(defn- printy [{:keys [increase-count]}]
  (println (string/join " " ["The number of times the depth increases is" increase-count])))

(defn -main
  "Find the number of times the depth increases."
  []
  (-> data-file
    (read-lines)
    (get-int-list)
    (number-of-increases)
    (printy)))
