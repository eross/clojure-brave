(ns brave.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(-main)

(println "hi there")

(defn train
[]
(println "Choo choo!")
42)

(train)

(def a '(1 2 3))
(into a '(4 5 6))

(def emptya '())

(if a "yes" "no")
(if emptya "yes" "no")

(first emptya)

(not nil)
empty

(concat '(a b c) '(d e))

(first a)

(into '() a)

;; does into in order.

(loop [arg a
       result ()]
  (if (not (first arg))
    (do
      (println "final arg: " arg)
      (println "final result: " result)
      result)
    (do
      (println "r arg: " arg)
      (println "r result: " result)
      (recur (rest arg) (into result (conj () (first arg)) )))))

;;1) into reverse order
(into () a)
;; (3 2 1)

;;2) regular order


(loop [arg a
       result ()]
  (if (not (first arg))
    (do
      (println "final arg: " arg)
      (println "final result: " result)
      result)
    (do
      (println "r arg: " arg)
      (println "r result: " result)
      (recur (rest arg) (concat result (conj () (first arg)) )))))

;;(1 2 3)


;; Now make a function
(defn into-order [dest src]
  (loop [arg src
         result dest]
    (if (not (first arg))
      (do
        (println "final arg: " arg)
        (println "final result: " result)
        result)
      (do
        (println "r arg: " arg)
        (println "r result: " result)
        (recur (rest arg) (concat result (conj () (first arg)) ))))))

(into-order '(a b c) '(d e f))
;; (a b c d e f)

(into '(a b c) '(d e f))
;; (f e d a b c)
