(ns aoc.2020.1-day
  "Report repair"
  (:use [util.io :only [read-input-int]])
  (:use [clojure.math.combinatorics :only [combinations]]))

(defn sums-into-2020 [numbers]
  (= 2020 (reduce + numbers)))

(defn possibilities [elements report]
  (combinations report elements))

(defn solve [report n]
  (->> report
       (possibilities n)
       (filter sums-into-2020)
       (flatten)
       (reduce *)))

(defn solve-1 [report]
  (solve report 2))

(defn solve-2 [report]
  (solve report 3))

(defn main []
  (println (format "Part 1: %d", (solve-1 (read-input-int 1))))
  (println (format "Part 2: %d", (solve-2 (read-input-int 1)))))

(main)
