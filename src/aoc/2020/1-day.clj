(ns aoc.2020.1-day
  "Report repair"
  (:use [util.io :only [read-file-int]])
  (:use [clojure.math.combinatorics :only [combinations]]))

(defn sums-into-2020 [numbers]
  (= 2020 (reduce + numbers)))

(defn possibilities [elements report]
  (combinations report elements))

(defn solve [report]
  (->> report
       (possibilities 3)
       (filter sums-into-2020)
       (flatten)
       (reduce *)))

(defn main []
  (println (solve (read-file-int "resources/1-report-repair/input.txt"))))

(main)
