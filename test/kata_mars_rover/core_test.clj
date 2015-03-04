(ns kata-mars-rover.core-test
  (:require
            [kata-mars-rover.core :refer :all])
  (:use [midje.sweet]))

(defn accept [position movements]
  (if (= "" movements)
    position
    {:x 0 :y 1}))

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
    (accept position movements) => position))

  (fact
  "the rover should forward"
  (let [position {:x 0 :y 0}
        expected {:x 0 :y 1}
          movements "f"]
    (accept position movements) => expected))


 )
