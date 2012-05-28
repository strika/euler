(ns problem006)

(defn sum-of-squares
	"calculates sum of the squares of sequence of numbers"
	[numbers]
	(apply + (map #(* % %) numbers)))
	
(defn square-of-sum
	"calculates square of the sum of sequence of numbers"
	[numbers]
	(let [sum (apply + numbers)]
		(* sum sum)))

(let [numbers (range 1 101)]	
	(- (square-of-sum numbers) (sum-of-squares numbers)))
