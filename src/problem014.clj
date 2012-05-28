(ns problem014)

(defn next-number [n]
  (if (even? n)
    (/ n 2)
    (+ (* 3 n) 1)))

(defn make-chain [n]
  (loop [chain (list n)]
    (let [x (first chain)]
      (if (= x 1)
        chain
        (recur (cons (next-number x) chain))))))

(def chain-lengths
  (map
    #(count (make-chain %))
    (range 1 1000000)))

(defn solve-14 []
  (let [m (apply max chain-lengths)]
    (inc (count (take-while #(not= % m) chain-lengths)))))
