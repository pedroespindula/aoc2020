(ns aoc.2020.2-day
  "Password Philosophy"
  (:use [util.io :only [read-input]])
  (:use [util.operators :only [xor]])
  (:use [clojure.string :only [split]]))

(defn format-line [line]
  (rest (re-find (re-matcher #"(\d+)-(\d+) ([aA-zZ])\: ([aA-zZ]+)" line))))

(defn format-report [report]
  (map format-line report))

(defn c-letter-interval? [min_c max_c letter password]
  (let [ocurrences (->> password
                        (re-seq (re-pattern letter))
                        count)]
    (and (>= ocurrences (Integer/parseInt min_c)) (<= ocurrences (Integer/parseInt max_c)))))

(defn get-position [index]
  (- (Integer/parseInt index) 1))

(defn letter-in-position? [index letter password]
  (= (str (nth password (get-position index))) letter))

(defn xor-letter-position? [position1 position2 letter password]
  (xor 
    (letter-in-position? position1 letter password) 
    (letter-in-position? position2 letter password)))

(defn solve [report verifier]
  (->> report
       (format-report)
       (filter verifier)
       (count)))

(defn solve-1 [report]
  (solve report #(apply c-letter-interval? %)))

(defn solve-2 [report]
  (solve report #(apply xor-letter-position? %)))

(defn main []
  (println (format "Part 1: %d", (solve-1 (read-input 2))))
  (println (format "Part 2: %d", (solve-2 (read-input 2)))))

(main)
