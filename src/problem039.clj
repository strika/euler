(ns problem039)

(defn find-solutions [p]
  (for [a (range 1 (/ p 2))
        b (range a (/ p 2))
        :let [c (- p a b)]
        :when (= (+ (* a a) (* b b)) (* c c))]
    [a b c]))

(defn count-solutions [p]
  (count (find-solutions p)))

(defn solve-39 []
  (let [s (map count-solutions (range 1001))
        m (apply max s)]
    (count (take-while #(not= % m) s))))

