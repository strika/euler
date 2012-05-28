(ns problem034)

(defn factorial [n]
  (apply * (range 1 (inc n))))

(defn sum-fact [n]
  (reduce + (map #(factorial (Integer. (str %))) (str n))))

(defn solve-34 []
  (reduce +
          (filter #(= (sum-fact %) %)
                  (range 10 (* 7 (factorial 9))))))

