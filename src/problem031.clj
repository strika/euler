(ns problem031)

(defn count-combinations [coins result]
  (apply +
         (for [i (range (count coins))]
           (let [r (- result (nth coins i))]
             (cond
               (zero? r) 1
               (neg? r) 0
               :else (count-combinations (drop i coins) r))))))


(defn solve-31 []
  (let [coins [1 2 5 10 20 50 100 200]
        result 200]
    (count-combinations coins result)))

(println (solve-31))
