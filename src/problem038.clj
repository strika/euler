(ns problem038)

(defn pandigital? [n]
  (= (apply str (sort (str n))) "123456789"))

(defn together-pandigital? [& numbers]
  (pandigital? (apply str numbers)))

(defn create-pandigital [n]
  (loop [m 1
         s [n]]
    (if (> (count (apply str s)) 9)
      nil
      (if (apply together-pandigital? s)
        (Integer. (apply str s))
        (recur (inc m) (conj s (* n (inc m))))))))

(defn solve-38 []
  (apply max
         (filter (complement nil?)
                 (map create-pandigital (range 1 10000)))))

