(ns kata-mars-rover.core-test
  (:require [clojure.test :refer :all]
            [kata-mars-rover.core :refer :all])
  (:use [midje.sweet]))

(defn accept [position movements]
  position)

(deftest mars-rover
  (testing "the rover should not move on an empty movements"
    (let [position {:x 0 :y 0}
          movements ""]
    (is (= position (accept position movements))))))

(facts
 "about midje"
  (fact
   "canary in midje"
   true => true))

(facts
 "about mars rover"
 (fact
  "the rover should not move on an empty movements"
  (let [position {:x 0 :y 0}
          movements ""]
    (accept position movements) => position)))
