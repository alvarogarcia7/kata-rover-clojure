(ns kata-mars-rover.core-test
  (:require [clojure.test :refer :all]
            [kata-mars-rover.core :refer :all]))

(defn accept [position movements]
  position)

(deftest mars-rover
  (testing "the rover should not move on an empty movements"
    (let [position {:x 0 :y 0}
          movements ""]
    (is (= position (accept position movements))))))
