(ns problem036)

(defn palindromic-base-10? [n]
  (= n (Integer. (apply str (reverse (str n))))))

(defn palindromic-base-2? [n]
  (let [nb (Integer/toBinaryString n)]
    (= nb (apply str (reverse nb)))))

(defn solve-36 []
  (apply +
         (filter
           #(and (palindromic-base-10? %) (palindromic-base-2? %))
           (range 1 1000001))))

