(ns util.io
  "IO Util"
  (:use [clojure.java.io :only [reader]]))

(defn read-file [fname]
  (with-open [r (reader fname)]
    (doall (line-seq r))))

(defn read-file-int [fname]
  (map #(Integer/parseInt %) (read-file fname)))
