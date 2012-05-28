(ns problem009)

(defn is-pythagorean-triplet?
	"returns true if a^2 + b^2 = c^2"
	[a b c]
	(= (+ (* a a) (* b b)) (* c c)))
		
(for [a (range 1 332) 
			b (range a 499) 
			c [(- 1000 a b)]
			:when (is-pythagorean-triplet? a b c)] 
	(* a b c))
		