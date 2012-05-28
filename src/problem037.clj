(ns problem037
 (:use [clojure.contrib.lazy-seqs :only [primes]]))

(defn prime? [n]
  (if (< n 2)
    false
    (every? #(not (zero? %))
            (map #(rem n %)
                 (take-while #(< % (inc (Math/round (Math/sqrt n)))) primes)))))

(defn truncatable? [number trunc-function]
  (loop [n number]
    (if (< n 10)
      (prime? n)
      (if (prime? n)
        (recur (trunc-function n))
        false))))

(defn truncatable-from-left? [n]
  (truncatable? n #(Integer. (apply str (rest (str %))))))

(defn truncatable-from-right? [n]
  (truncatable? n #(quot % 10)))

(defn solve-37 []
  (apply +
         (take 11 (filter
                    #(and (truncatable-from-left? %) (truncatable-from-right? %))
                    (drop-while #(< % 10) primes)))))

