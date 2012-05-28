(ns problem017)

(def words
  {1 "one" 2 "two" 3 "three" 4 "four" 5 "five" 6 "six" 7 "seven"
   8 "eight" 9 "nine" 10 "ten" 11 "eleven" 12 "twelve" 13 "thirteen"
   14 "fourteen" 15 "fifteen" 16 "sixteen" 17 "seventeen" 18 "eighteen"
   19 "nighteen" 20 "twenty" 30 "thirty" 40 "forty" 50 "fifty"
   60 "sixty" 70 "seventy" 80 "eighty" 90 "ninety" 1000 "one thousand"})

(defn to-words [n]
  (let [d3 (* (quot n 1000) 1000)
        w3 (words d3)
        d2 (quot (rem n 1000) 100)
        w2 (words d2)
        d1 (* (quot (rem n 100) 10) 10)
        w1 (words d1)
        d0 (rem n 10)
        w0 (words d0)
        w10 (words (+ d1 d0))]
    (filter
      #(not= % nil)
      [w3 w2 (if w2 "hundred") (if (and (or w3 w2) (or w1 w0)) "and") (if w10 w10 (str w1 "-" w0))])))

(defn count-letters [w]
  (count (filter #(Character/isLetter %) w)))

(defn count-letters-in-number [n]
  (reduce #(+ %1 (count-letters %2)) 0 (to-words n)))

(reduce + (map count-letters-in-number (range 1 1001)))
