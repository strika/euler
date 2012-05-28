(ns problem024
  (:use clojure.contrib.combinatorics))

(defn solve-24 []
  (apply str (nth (lex-permutations (range 10)) 999999)))

(println (solve-24))

