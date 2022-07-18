# bsless.tools.jvm 





## `class-path`
``` clojure

(class-path)
```


Get the JVM's class path as a vector of strings.
<br><sub>[source](https://github.com/bsless/tools.jvm/blob/master/src/bsless/tools/jvm.clj#L30-L33)</sub>
## `input-arguments`
``` clojure

(input-arguments)
```


Get the JVM's input arguments.
  Useful for making sure there are no surprises.
<br><sub>[source](https://github.com/bsless/tools.jvm/blob/master/src/bsless/tools/jvm.clj#L19-L23)</sub>
## `java-home`
``` clojure

(java-home)
(java-home trim-jre?)
```


Get current JVM's java.home.
  By default trims the jre directory from the path.
<br><sub>[source](https://github.com/bsless/tools.jvm/blob/master/src/bsless/tools/jvm.clj#L37-L46)</sub>
## `pid`
``` clojure

(pid)
```


Get current JVM's PID as a string.
<br><sub>[source](https://github.com/bsless/tools.jvm/blob/master/src/bsless/tools/jvm.clj#L62-L68)</sub>
## `properties`
``` clojure

(properties)
```


Get all of the current JVM's properties.
<br><sub>[source](https://github.com/bsless/tools.jvm/blob/master/src/bsless/tools/jvm.clj#L54-L57)</sub>
## `runtime-bean`
``` clojure

(runtime-bean)
```


Get the current RuntimeMXBean.
  Useful for getting information like process input arguments
<br><sub>[source](https://github.com/bsless/tools.jvm/blob/master/src/bsless/tools/jvm.clj#L10-L14)</sub>
## `visual-vm!`
``` clojure

(visual-vm!)
(visual-vm! opts)
```


Attach a visualvm process to the current JVM.
  Optionally takes a map of arguments which correspond to the visualvm flags:
  --jdkhome => `:jdkhome`
  `:openpid` - the PID to attach to, defaults to current process's PID.
<br><sub>[source](https://github.com/bsless/tools.jvm/blob/master/src/bsless/tools/jvm.clj#L93-L107)</sub>
