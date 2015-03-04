(ns kata-mars-rover.core-test
  (:require
            [kata-mars-rover.core :refer :all])
  (:use [midje.sweet]))

(defn rover-at
  ([x y]  (rover-at x y \N))
  ([x y orientation ]  {:x x :y y :orientation orientation}))

(defn is-movement [movements]
  (or (= "f" movements) (= "b" movements)))

(defn get-increment [movement orientation]
  (let [is-forward (= "f" movement)]
  (if (= orientation \N)
    (if is-forward 1 -1)
    (if is-forward -1 1))))

(defn accept [position movements]
  (let [x (:x position)
        y (:y position)
        pos (:orientation position)]
  (if (= "" movements)
    position
    (if (is-movement movements)
      (rover-at x
                (+ (get-increment movements pos) y)
                pos)
      (rover-at x y (if (= \N pos)
                      (if (= "l" movements) \W \E)
                      \E
                      ))))))

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
  (let [position (rover-at 1 1)
        expected (rover-at 1 2)
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
    (let [position (rover-at 1 1 \N)
          expected (rover-at 1 1 \E)
          movements "r"]
      (accept position movements) => expected))

   (fact
      "the rover should move forward when facing other directions"
      (let [position (rover-at 0 1 \S)
            expected (rover-at 0 0 \S)
            movements "f"]
        (accept position movements) => expected))

 (fact
      "the rover should move backwards when facing other directions"
      (let [position (rover-at 0 0 \S)
            expected (rover-at 0 1 \S)
            movements "b"]
        (accept position movements) => expected))

    (fact
        "the rover should turn left when facing other directions"
        (let [position (rover-at 0 0 \S)
              expected (rover-at 0 0 \E)
              movements "l"]
          (accept position movements) => expected))

 )
