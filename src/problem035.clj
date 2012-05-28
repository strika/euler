(ns problem035
  (:use [clojure.contrib.lazy-seqs :only [primes]]))

(def primes-below-million
  (set (take-while #(< % 1000000) primes)))

(defn prime? [n]
  (not= (primes-below-million n) nil))

(defn rotate-number [n]
  (let [s (str n)]
    (Integer. (apply str (conj (vec (rest s)) (first s))))))

(defn circular-prime? [n]
  (and
    (every? #(not= 0 (Integer. (str %))) (str n))
    (every? prime? (take (count (str n)) (iterate rotate-number n)))))

(defn solve-35 []
  (count
    (filter
      circular-prime?
      (filter prime? (range 1 1000000)))))

