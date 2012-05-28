(ns problem023)

(defn divisors [n]
  (filter #(zero? (rem n %)) (range 1 (inc (/ n 2)))))

(defn abundant? [n]
  (> (apply + (divisors n)) n))

(def memo-abundant? (memoize abundant?))

(def abundants
  (filter abundant? (range 1 28123)))

(defn solve-23 []
  (apply +
         (filter
           (fn [n]
             (not (some
                    #(memo-abundant? %)
                    (map #(- n %) (take-while #(<= % (/ n 2)) abundants)))))
           (range 1 28123))))

(time (solve-23))

