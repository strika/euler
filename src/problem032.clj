(ns problem032)

(defn is-1-to-9-pandigital? [n]
  (= (apply str (sort (str n))) "123456789"))

(defn together-1-to-9-pandigital? [& numbers]
  (is-1-to-9-pandigital? (apply str numbers)))

(defn solve-32 []
  (apply +
         (distinct
           (for [a (range 1 100)
                 b (range 100 10000)
                 :let [c (* a b)]
                 :when (together-1-to-9-pandigital? a b c)]
             c))))

(println (solve-32))

