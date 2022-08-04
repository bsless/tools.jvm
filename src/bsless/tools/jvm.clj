(ns bsless.tools.jvm
  (:require
   [clojure.string :as str])
  (:import
   (java.lang ProcessBuilder)
   (java.lang.management ManagementFactory RuntimeMXBean)))

(defonce ^:private +runtime-bean+ (delay (ManagementFactory/getRuntimeMXBean)))

(defn runtime-bean
  "Get the current RuntimeMXBean.
  Useful for getting information like process input arguments"
  ^RuntimeMXBean []
  @+runtime-bean+)

(comment
  (runtime-bean))

(defn input-arguments
  "Get the JVM's input arguments.
  Useful for making sure there are no surprises."
  []
  (into [] (.getInputArguments (runtime-bean))))

(comment
  (input-arguments))

(defonce ^:private +class-path+ (delay (System/getProperty "java.class.path")))

(defn class-path
  "Get the JVM's class path as a vector of strings."
  []
  (str/split @+class-path+ #":"))

(defonce ^:private +java-home+ (delay (System/getProperty "java.home")))

(defn java-home
  "Get current JVM's java.home.
  By default trims the jre directory from the path."
  ([]
   (java-home true))
  ([trim-jre?]
   (->
    +java-home+
    deref
    (cond-> trim-jre? (str/replace #"/jre" "")))))

(comment
  (java-home)
  (java-home false))

(defonce ^:private +properties+ (delay (into {} (System/getProperties))))

(defn properties
  "Get all of the current JVM's properties."
  []
  @+properties+)

(comment
  (properties))

(defonce ^:private +java-version+ (delay (get (properties) "java.version")))
(defn java-version [] @+java-version+)

(defn pid
  "Get current JVM's PID as a string."
  []
  (-> (runtime-bean)
      .getName
      (str/split #"@")
      first))

(defonce ^:private +vm-proc+ (atom nil))
(comment @+vm-proc+)

(defn- default-visual-vm-opts
  []
  {:jdkhome (java-home)
   :openpid (pid)})

(defn- build-visual-vm-args
  ([]
   (build-visual-vm-args {}))
  ([opts]
   (into
    ["visualvm"]
    (comp
     (map (fn [[k v]] [(str "--" (name k)) (str v)]))
     cat)
    (merge (default-visual-vm-opts) opts))))

(comment
  (build-visual-vm-args)
  (build-visual-vm-args {:openpid 1}))

(defn visual-vm!
  "Attach a visualvm process to the current JVM.
  Optionally takes a map of arguments which correspond to the visualvm flags:
  --jdkhome => `:jdkhome`
  `:openpid` - the PID to attach to, defaults to current process's PID."
  ([]
   (visual-vm! {}))
  ([opts]
   (locking +vm-proc+
     (let [args (build-visual-vm-args opts)
           pb (doto (ProcessBuilder. args)
                (.redirectErrorStream true)
                (.inheritIO))
           p (.start pb)]
       (reset! +vm-proc+ p)))))

(comment
  (visual-vm!))
