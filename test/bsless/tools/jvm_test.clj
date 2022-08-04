(ns bsless.tools.jvm-test
  (:require
   [clojure.test :as t]
   [bsless.tools.jvm :as jvm]
   [clojure.java.io :as io]))

(t/deftest runtime-bean
  (->> (jvm/runtime-bean)
       (instance? java.lang.management.RuntimeMXBean)
       t/is))

(t/deftest input-arguments
  (let [args (jvm/input-arguments)]
    (t/is (every? string? args))
    (t/is vector? args)))

(t/deftest class-path
  (let [p (jvm/class-path)]
    (t/is (every? string? p))
    (t/is vector? p)))

(t/deftest java-home
  (let [p (jvm/java-home)
        f (io/file p)]
    (t/is (string? p))
    (t/is (.exists ^java.io.File f))
    (t/is (.isDirectory ^java.io.File f))))

(t/deftest properties
  (let [ps (jvm/properties)]
    (t/is (map? ps))
    (t/is (every? string? (keys ps)))
    (t/is (every? string? (vals ps)))))

(t/deftest pid
  (let [id (jvm/pid)]
    (t/is (string? id))
    (t/is (nat-int? (Long/valueOf id)))))

(t/deftest pid-long
  (let [id (jvm/pid-long)]
    (t/is (nat-int? id))))
