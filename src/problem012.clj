; for algorithm details see:
; http://stackoverflow.com/questions/110344/algorithm-to-calculate-the-number-of-divisors-of-a-given-number
; http://mathforum.org/library/drmath/view/55843.html

(ns problem012)

(use 'clojure.contrib.lazy-seqs)

(defn count-prime-factors
  "finds count of each prime factor of number" 
  [number]
  (loop 
    [x number
     factors {}
     prime-index 0]
    (let [p (nth primes prime-index)
          p-key (keyword (str p))]
      (if (> p (/ x 2))
        (assoc factors (keyword (str x)) 1)
        (if (zero? (rem x p))
          (recur 
            (/ x p)
            (if (p-key factors)
              (assoc factors p-key (inc (p-key factors)))
              (assoc factors p-key 1)) 
            prime-index)
          (recur x factors (inc prime-index)))))))

(defn count-factors
  "counts factors of number"
  [number]
  (apply * (map inc (vals (count-prime-factors number)))))
	

(def triple-numbers
 (map first (iterate (fn [[a b]] [(+ a b) (inc b)]) [1 2])))

; (first (drop-while #(< (count-factors %) 500) triple-numbers))

