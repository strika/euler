(ns problem016)

(defn solve-16 []
  (reduce +
          (map
            #(Integer. (str %))
            (str (.pow (BigInteger. "2") 1000)))))

(println (solve-16))
