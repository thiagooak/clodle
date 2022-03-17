(ns clodle.core
  (:require [clojure.string])
  (:gen-class))

(def word-dict (sort (clojure.string/split-lines (slurp "https://raw.githubusercontent.com/thiagooak/greple/main/wordle.txt"))))

(defn filter-words [dict pattern]
  (filter #(re-find (re-pattern pattern) %) dict))

(def type-pattern-text "\nType the pattern? e.g. [^a].c..")

(defn -main
  "Clodle helps you solve Wordle."
  [& args]

  (println type-pattern-text)

  (while (true? true)
    (let [pattern (read-line)
          possible-words (filter-words word-dict pattern)]
      (println type-pattern-text)
      (println possible-words)
      (println "\nThere are" (count possible-words) "words that fit the pattern" pattern))))

