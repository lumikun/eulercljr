(ns eulercljr.p1)

(def ans
  (reduce +(filter #(or (zero? (rem % 5)) (zero? (rem % 3))) (range 1000))))

(defn -main []
  (println "Problem 1: "(time ans)))
