(ns problem010)
					
(defn primes-bellow
	"calculates all primes bellow max"
	[max]
	(loop [numbers (vec (range 2 max)) primes [] last-p 0]
		(let [p (first (drop-while zero? (drop (dec last-p) numbers)))]
			(if (> p (. Math sqrt max))
				(concat primes (filter pos? numbers))
				(let [numbers (reduce #(assoc %1 %2 0) 
															numbers 
															(range (- p 2) (dec max) p)) 
							primes (conj primes p)]
					(recur numbers primes	p))))))

; (apply + (primes-bellow 2000000))
