(ns problem043
  (:use [clojure.contrib.lazy-seqs :only [primes]]
        [clojure.contrib.combinatorics :only [permutations]]))

(def pandigitals
  (filter
    #(not= (first %) \0)
    (map #(apply str %) (permutations (range 10)))))

(defn interesting? [n]
  (every?
    zero?
    (map mod
         (map #(Integer. (apply str %)) (partition 3 1 (rest n)))
         (take 7 primes))))

(defn solve-43 []
  (apply + (map #(BigInteger. %) (filter interesting? pandigitals))))

