(ns problem029
  (:use [clojure.contrib.math :only (expt)]))

(defn solve-29 [a-max b-max]
  (count (distinct
           (for [a (range 2 (inc a-max))
                 b (range 2 (inc b-max))]
             (expt a b)))))

(println (solve-29 100 100))

