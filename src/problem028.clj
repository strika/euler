(ns problem028)

(def size 1001)

(defn solve-28 []
  (apply +
         (loop [numbers (range 1 (* size size))
                i 1
                d '()]
           (if (empty? numbers)
             (conj (vec d) (* size size))
             (recur
               (drop (* 8 i) numbers)
               (inc i)
               (concat d (map first (partition (* 2 i) (take (* 8 i) numbers)))))))))

(println (solve-28))

