(ns problem004)

(defn is-palindrome? [number] 
	(let [n (str number)]
		(= n (apply str (reverse n)))))

(apply max (for [x (range 100 1000) 
								 y (range x 1000) 
								 :when (is-palindrome? (* x y))] 
								 (* x y)))
