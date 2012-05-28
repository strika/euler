(ns problem026)

(defn decimal-part-rem
  "calculates remainders in decimal part of a/b"
  [a b]
  (rest
    (map #(nth % 1)
         (iterate
           (fn [[x y]] [(quot (* y 10) b) (rem (* y 10) b)])
           [(quot a b) (rem a b)]))))

(defn repetition-length [decimal-part]
  (let [sig-part (drop 10 decimal-part)]
    (if (zero? (first sig-part))
      0
      (inc (count
             (take-while #(not= % (first sig-part)) (rest sig-part)))))))

(defn solve-26 []
  (let [dpart-rep-length (map #(repetition-length (decimal-part-rem 1 %)) (range 1 1001))
        m (apply max dpart-rep-length)]
    (inc (count (take-while #(not= % m) dpart-rep-length)))))

(println (solve-26))

