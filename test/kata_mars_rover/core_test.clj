(ns kata-mars-rover.core-test
  (:require
            [kata-mars-rover.core :refer :all])
  (:use [midje.sweet]))

(defn rover-at [x y]
  {:x x :y y})

(defn accept [position movements]
  (if (= "" movements)
    position
    (rover-at 0 (if (= "f" movements) 1 -1))))

(facts
 "about midje"
  (fact
   "canary in midje"
   true => true))

(facts
 "about mars rover"
 (fact
  "the rover should not move on an empty movements"
  (let [position (rover-at 0 0)
          movements ""]
    (accept position movements) => position))

  (fact
  "the rover should forward"
  (let [position (rover-at 0 0)
        expected (rover-at 0 1)
          movements "f"]
    (accept position movements) => expected))

   (fact
  "the rover should backwards"
  (let [position (rover-at 0 0)
        expected (rover-at 0 -1)
          movements "b"]
    (accept position movements) => expected))

 )
