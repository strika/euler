(ns problem002)

(defn generate-fibonacci 
	"generates fibonacci numbers sequence up to maximum"
	[maximum]
	(loop [numbers [1 0]]
  	(if (> (first numbers) maximum)
    	numbers
    	(recur (cons (+ (nth numbers 0) (nth numbers 1)) numbers)))))
  
(apply + (filter even? (generate-fibonacci 4000000)))
