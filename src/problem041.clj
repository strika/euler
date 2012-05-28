(ns problem041
  (:use [clojure.contrib.lazy-seqs :only [primes]]
        [clojure.contrib.combinatorics :only [permutations]]))

(defn prime? [n]
  (if (< n 2)
    false
    (every? #(not (zero? %))
            (map #(rem n %)
                 (take-while #(< % (inc (Math/round (Math/sqrt n)))) primes)))))

(defn coll-to-int [c]
  (Integer. (apply str c)))

(defn create-all-pandigitals []
  (map coll-to-int
       (apply concat (map #(permutations (range 1 (inc %)))
                          (range 1 10)))))

(defn solve-41 []
  (apply max (filter prime? (create-all-pandigitals))))

