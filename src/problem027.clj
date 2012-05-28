(ns problem027
  (:use [clojure.contrib.lazy-seqs :only [primes]]))

(defn prime? [n]
  (= n (first (drop-while #(< % n) primes))))

(defn quadratic [a b n]
  (+ (* n n) (* a n) b))

(def primes-for-coefficients
  (for [a (range -1000 1001)
        b (range -1000 1001)]
    (let [q (partial quadratic a b)]
      [(count (take-while prime? (map q (iterate inc 0)))) a b])))

(defn solve-27 []
  (let [max-primes (apply max (map first primes-for-coefficients))
        best-coefs (first (drop-while #(not= (first %) max-primes)
                                      primes-for-coefficients))]
    (* (nth best-coefs 1) (nth best-coefs 2))))

(println (solve-27))
