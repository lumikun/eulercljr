(ns eulercljr.p2)

(defn fibs
    ([] (fibs 0 1))
    ([first second]
        ((fn rfib [a b] (lazy-seq (cons a (rfib b (+' a b))))) first second)))

(def ans
  (reduce + (filter even? (take-while #(<= % 4000000) (fibs)))))

(defn -main []
  (println "Problem 2: " (time ans)))
