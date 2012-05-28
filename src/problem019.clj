(ns problem019)

(defn is-leap? [y]
  (or
    (zero? (rem y 400))
    (and (pos? (rem y 100)) (zero? (rem y 4)))))

(def days-seq
  (remove nil?
          (for [y (range 1900 2001)
                m (range 1 13)
                d (range 1 32)]
            (condp =
              29 (if (or (not= m 2) (is-leap? y)) d)
              30 (if (not= m 2) d)
              31 (if (some #(= m %) [1 3 5 7 8 10 12]) d)
              :else d))))

(defn solve-19 []
  (count
    (filter
      #(= % 1)
      (map last (drop 52 (partition 7 days-seq))))))

(println (solve-19))
