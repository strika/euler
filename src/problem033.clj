(ns problem033)

(defn can-be-non-trivially-canceled? [a b]
  (if (not= a b)
    (let [r (/ a b)
          a1 (rem a 10)
          a2 (quot a 10)
          b1 (rem b 10)
          b2 (quot b 10)]
      (and (pos? b1) (= a1 b2) (= (/ a2 b1) r)))))

(defn solve-33 []
  (.denominator
    (apply *
      (for [a (range 10 100)
            b (range a 100)
            :when (can-be-non-trivially-canceled? a b)]
        (/ a b)))))

(println (solve-33))

