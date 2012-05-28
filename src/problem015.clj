(ns problem015)

(defn grid [x y]
  (cons
    (cons 0 (repeat y 1))
    (repeat
      x
      (cons 1 (repeat y 0)))))

(defn process-rows [row-1 row-2]
  (reductions + (map + row-1 (cons 0 row-2))))

(defn solve-15 []
  (let [g (grid 20 20)]
    (last (reduce process-rows g))))

(println (solve-15))

