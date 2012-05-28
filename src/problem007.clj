(ns problem007)

(defn no-dividers?
	"checks if number can be divided with any of dividers"
	[number dividers]
	(let [sqrt-num (. Math sqrt number)
				divs (take-while #(<= % sqrt-num) dividers)]
		(every? #(pos? (rem number %)) divs)))
					
(defn find-primes [n]
	"finds first n primes"
	(loop [primes [2 3] x 1 f -]
		(if (= (count primes) n)
			primes
			(let [k (f (* 6 x) 1)]
				(recur
					(if (no-dividers? k primes) (conj primes k) primes)
					(if (= f -) x (inc x))
					(if (= f -) + -))))))
					
(nth (find-primes 10001) 10000)
