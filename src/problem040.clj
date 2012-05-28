(ns problem040)

(def fractional-part
  (map #(Integer. (str %))
       (flatten (map #(seq (str %)) (iterate inc 1)))))

(defn solve-40 []
  (apply *
         (map #(nth fractional-part %)
              [0 9 99 999 9999 99999 999999])))

