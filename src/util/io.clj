(ns util.io
  "IO Util"
  (:use [clojure.java.io :only [reader as-relative-path]]))

(defn read-file [fname]
  (with-open [r (reader fname)]
    (doall (line-seq r))))

(defn read-file-int [fname]
  (map #(Integer/parseInt %) (read-file fname)))

(defn input-path [day]
  (format "resources/aoc/2020/%d-day/input.txt" day))

(defn read-input [day]
  (read-file (input-path day)))

(defn read-input-int [day]
  (read-file-int (input-path day)))
