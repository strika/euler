(ns problem025)

(def fibs
  (map first (iterate (fn [[a b]] [b (+ a b)]) [1 1])))

(defn solve-25 []
  (inc (count (take-while #(< (count (str %)) 1000) fibs))))

(println (solve-25))
