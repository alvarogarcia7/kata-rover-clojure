(defproject kata-mars-rover "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]]
  :main ^:skip-aot kata-mars-rover.core
  :target-path "target/%s"
  :profiles {  :uberjar {:aot :all}
               :dev {
                     :dependencies [[midje "1.6.3"]]
                     :plugins      [
                                    [lein-midje "3.1.3"]
                                    [com.jakemccrary/lein-test-refresh "0.6.0"]
                                    ]
               }
            })
