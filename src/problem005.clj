(ns problem005)

(defn gcd
	"finds greatest common divisor for two numbers"
	[x y]
	(loop [a (min x y), b (max x y)]
		(if (zero? a)
			b
			(recur (rem b a) a))))
			
(defn lcm
	"finds least common multiple for two numbers"
	[x y]
	(/ (* x y) (gcd x y)))
			
(reduce lcm 1 (range 2 21))

