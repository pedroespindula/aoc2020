(ns util.operators
  "Operators Util")

(defn -boolean-to-bit [bool]
  (if (true? bool) 1 0))

(defn xor [a b]
  (pos? (bit-xor (-boolean-to-bit a) (-boolean-to-bit b))))

