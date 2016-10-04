(ns bowling-game.core-test
  (:require [clojure.test :refer :all]
            [bowling-game.core :refer :all]))

(deftest test-empty-game
  (is (= 0 (score-game (new-game)))))

(deftest test-singles-game
  (let [game (new-game)
        updated-game (reduce roll game (repeat 20 1))]
    (is (= 20 (score-game updated-game)))))

(deftest test-one-spare
  (let [game (new-game)
        rolls (concat [5 5] ;; spare
                      [3]
                      (repeat 17 0))
        updated-game (reduce roll game rolls)]
    (is (= 16 (score-game updated-game)))))

(deftest test-fibonacci
  (is (= [0]
         (take 1 (fibonacci-seq))))

  (is (= [0 1]
         (take 2 (fibonacci-seq))))

  (is (= [0 1 1]
         (take 3 (fibonacci-seq))))
  (is (= [0 1 1 2]
         (take 4 (fibonacci-seq))))

  #_(is (= [0 1 1 2 3 5 8 13 21]
           (take 9 (fibonacci-seq)))))
