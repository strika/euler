(ns problem020)

(defn factorial [n]
  (reduce * (range 2 (inc n))))

(defn solve-20 []
  (reduce + (map #(Integer. (str %)) (str (factorial 100)))))

(println (solve-20))
