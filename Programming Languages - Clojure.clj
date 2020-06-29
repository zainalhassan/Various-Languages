;;Task 1 - Get Divisors of a Number
(defn get-divisors [n]
    (range 2 (inc (Math/floor (Math/sqrt n))))
    )
(println "task 1: " (get-divisors 101))


(println)

;;Task 2 - Number Divides?
(defn divides? [ x n]
   (if (zero? (rem n x))
   ;(if (= (/ x n )(quot x n)) alternative
       true
       false
       )
   )
(println "task2: (divides? 2 10): " (divides? 2 10))
(println "task2: (divides? 4 10): " (divides? 4 10))


(println)

;;Task 3 - Has No Divisors?
(defn no-divisors? [n]
(empty? (filter (fn [x] (divides? x n)) (range 2 (inc (long ( Math/sqrt n)))))))
(println "task3: (no-divisors? 9): "(no-divisors? 9))
(println "task3: (no-divisors? 7)"(no-divisors? 7))


(println)

;;Task 4 - Is Number Prime?
(defn is-prime? [n]
  (if (< 1 n)
    (empty? (filter #(= 0 (mod n %)) (range 2 n)))
    false
      )
    )
(println "task4: (is-prime? 1): " (is-prime? 1))
(println "task4: (is-prime? 2): "(is-prime? 2))
(println "task4: (is-prime? 3): "(is-prime? 3))
(println "task4: (is-prime? 4): "(is-prime? 4))
(println "task4: (is-prime? 10): "(is-prime? 101))


(println)

;;Task 5 - Prime Number Sequence In Range
(defn prime-seq [from to]
  (filter is-prime? (range from (inc to)))
    )
(println "task5: (prime-seq 50 100): " (prime-seq 50 100))
(println "task5: (prime-seq 7 11): " (prime-seq 7 11))


(println)

;;Task 6 - Top 10 Primes In Range
(defn print-top-primes [from to]
    (loop [primes (prime-seq from to)
           total 0]
        (let [lp (last primes)]
            (if lp 
                (do (println lp)
                    (recur (butlast primes) (+ total lp))
                    )
                (printf "Total - %d\n" total)
                )
            )
        )
    )
(println "Task 6: (print-top-primes 50 100): ")
(print-top-primes 50 100)
(println)
(println "Task 6: (print-top-primes 7 11): ")
(print-top-primes 7 11)
