(ns problem042)

(def words
  (re-seq #"[A-Z]+" (slurp "src/words.txt")))

(defn triangle [n]
  (/ (* n (+ n 1)) 2))

(def triangle-numbers
  (map triangle (iterate inc 1)))

(defn triangle-number? [n]
  (= n (first (drop-while #(< % n) triangle-numbers))))

(defn word-value [word]
  (apply + (map #(- (int %) 64) word)))

(defn triangle-word? [word]
  (triangle-number? (word-value word)))

(defn solve-42 []
  (count (filter triangle-word? words)))

