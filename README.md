[![Clojars Project](https://img.shields.io/clojars/v/io.github.bsless/tools.jvm.svg)](https://clojars.org/io.github.bsless/tools.jvm)

# io.github.bsless/tools.jvm

Tools for introspecting the current JVM process.

Easily answer questions ranging from "what flags did my process start with?"
to "Which of those 10 processes do I need to attach VisualVM to?"

## API docs

See [API.md](./API.md)

## Dependency

### Deps

```clojure
io.github.bsless/tools.jvm {:mvn/version "0.0.15"}
```

### Leiningen

```clojure
[io.github.bsless/tools.jvm "0.0.15"]
```

## Development

Run the project's tests:

    $ clojure -T:build test

Run the project's CI pipeline and build a JAR:

    $ clojure -T:build ci

Install it locally (requires the `ci` task be run first):

    $ clojure -T:build install
    
Generate docs:

    $ clojure -M:quickdoc

## License

Copyright © 2022 Ben Sless

Distributed under the Eclipse Public License version 1.0.
