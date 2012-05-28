(ns problem021)

(defn divisors [n]
  (filter #(zero? (rem n %)) (range 1 (inc (/ n 2)))))
					
(defn amicable? [n]
  (let [d1 (reduce + (divisors n))
        d2 (reduce + (divisors d1))]
    (and (= n d2) (not= n d1))))
						
(def amicable-numbers
  (filter amicable? (iterate inc 2)))

(defn solve-21 []
  (reduce + (take-while #(< % 10000) amicable-numbers)))

(println (solve-21))
