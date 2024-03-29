(ns eulercljr.util.primes)

(def primes
  (concat
   [2 3 5 7]
   (lazy-seq
    (let [primes-from
      (fn primes-from [n [f & r]]
        (if (some #(zero? (rem n %))
                  (take-while #(<= (* % %) n) primes))
          (recur (+ n f) r)
          (lazy-seq (cons n (primes-from (+ n f) r)))))
      wheel (cycle [2 4 2 4 6 2 6 4 2 4 6 6 2 6  4  2
                    6 4 6 8 4 2 4 2 4 8 6 4 6 2  4  6
                    2 6 6 4 2 4 6 2 6 4 2 4 2 10 2 10])]
      (primes-from 11 wheel)))))


(defn prime-factors-of [^long n]
  (let [q (long (Math/sqrt n))]
  (loop [n n
         p primes
         res nil]
    (let [d (long (first p))]
      (cond
        (or (> d q) (= n d)) (cons n res)
        (zero? (rem n d))    (recur (quot n d) p (cons d res))
        :else                (recur n (next p) res))))))
