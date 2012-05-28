(ns problem022)

(def names
  (sort
    (re-seq #"[A-Z]+" (slurp "src/names.txt"))))

(defn alpha-value [s]
  (reduce + (map #(- (int %) 64) s)))

(defn solve-21 []
  (reduce + (map
              #(* (alpha-value %1) %2)
              names
              (iterate inc 1))))

(println (solve-21))
