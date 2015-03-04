(ns kata-mars-rover.core-test
  (:require
            [kata-mars-rover.core :refer :all])
  (:use [midje.sweet]))

(defn rover-at
  ([x y]  (rover-at x y \N))
  ([x y orientation ]  {:x x :y y :orientation orientation}))

(defn is-movement [movements]
  (or (= "f" movements) (= "b" movements)))

(defn accept [position movements]
  (let [x (:x position)]
  (if (= "" movements)
    position
    (if (is-movement movements)
    (rover-at 0 (if (= "f" movements) 1 -1))
    (rover-at x 0 (if (= "l" movements) \W \E))))))

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

   (fact
    "the rover should turn left"
    (let [position (rover-at 0 0 \N)
          expected (rover-at 0 0 \W)
          movements "l"]
      (accept position movements) => expected))

    (fact
    "the rover should turn right"
    (let [position (rover-at 1 0 \N)
          expected (rover-at 1 0 \E)
          movements "r"]
      (accept position movements) => expected))

 )
