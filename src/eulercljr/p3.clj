(ns eulercljr.p3
  (:use [eulercljr.util.primes]))

(def ans (reduce max (prime-factors-of 600851475143)))

(defn -main []
  (println "Problem 3: " (time ans)))
