(ns problem007b)

(defn div? [n d]
  (= 0 (rem n d)))
 
(defn smallest-prime-factor [number]
  (loop [n number d 2]
    (cond (> d (int (Math/sqrt number))) n
          (= n d) n
          (div? n d) d
          true (recur n (inc d)))))
 
(def primes (lazy-cat '(2 3)
                      (filter #(= %1 (smallest-prime-factor %1))
                              (take-nth 2 (iterate inc 5)))))
 
; (nth primes 10001)