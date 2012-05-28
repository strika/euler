(ns problem003)

(defn largest-prime-factor [number]
	(loop [x number, div 2]
		(if (> div (/ x 2))
			x
			(if (zero? (rem x div))
	   		(recur (/ x div) 2)
	   		(recur x (inc div))))))
	    
(largest-prime-factor 600851475143)
