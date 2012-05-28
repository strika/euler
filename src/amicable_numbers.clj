(ns amicable-numbers)

(use 'clojure.contrib.lazy-seqs)

(defn divisors
	"finds all divisors of number lower than number"
	[number]
	(loop [x number
				 divs [1] 
				 prime-index 0]
		(let [p (nth primes prime-index)]
			(if (> p (/ number 2))
				divs
				(if (zero? (rem x p))
					(recur 
						(/ x p)
						(concat divs (filter 
														(fn [a] 
															(and (<= a (/ number 2)) (not-any? #(= a %) divs))) 
														(map #(* % p) divs)))
						prime-index)
					(recur x divs (inc prime-index)))))))
					
(defn sum-divisors
	"returns sum of number divisors"
	[number]
	(apply + (divisors number)))
						
(def amicable-numbers 
	(map #(vector % (sum-divisors %)) 
		(filter #(and (= % (sum-divisors (sum-divisors %))) (< % (sum-divisors %))) 
			(iterate inc 1))))
			
(println (take 5 amicable-numbers))
