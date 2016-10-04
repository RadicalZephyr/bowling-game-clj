(ns bowling-game.core
  (:require [clojure.tools.trace :as t]))

(defn new-game []
  [])

(defn roll [game pins]
  (conj game pins))

(defn- sum [coll]
  (apply + coll))

(defn- spare? [frame]
  (= 10 (sum frame)))

(defn- number-of-rolls-in-frame [frame]
  (if (spare? frame)
    3
    2))

(defn frameseq [game]
  (lazy-seq
   (let [frame (take 2 game)]
     (cons (take (number-of-rolls-in-frame)
                 game)
          (frameseq (drop 2 game))))))

(defn score-game [game]
  (->> game
       frameseq
       (take 10)
       (map sum)
       sum))

(defn- fibonacci-seq [n]
  (cond
    (= n 0) 0
    (= n 1) 1
    :else (+(fibonacci-seq (- n 1))
            (fibonacci-seq (- n 2)))))

(defn- fib-seq-iter [n1 n2]
  (lazy-seq
   (let [next (+ n1 n2)]
     (cons next
           (fib-seq-iter n2 next)))))

(defn fibonacci-seq []
  (concat [0 1]
          (fib-seq-iter 0 1)))
