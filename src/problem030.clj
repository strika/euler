(ns problem030
  (:use [clojure.contrib.math :only (expt)]))

(defn highest-possible [n]
  (* (expt 9 n)
     (last (take-while
             #(< (expt 10 %) (* % (expt 9 n)))
             (iterate inc 1)))))

(defn is-sum-of-powers? [number exp]
  (= number
     (apply + (map #(expt (Integer. (str %)) exp)
                   (str number)))))

(defn solve-30 [n]
  (apply +
         (filter
           #(is-sum-of-powers? % n)
           (range 10 (highest-possible n)))))

(println (solve-30 5))

