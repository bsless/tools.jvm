# io.github.bsless/tools.jvm

Tools for introspecting the current JVM process.

## API docs

See [API.md](./API.md)

## Usage

```clojure
(require '[bsless.tools.jvm :as jvm])
```

Run the project's tests (they'll fail until you edit them):

    $ clojure -T:build test

Run the project's CI pipeline and build a JAR (this will fail until you edit the tests to pass):

    $ clojure -T:build ci

This will produce an updated `pom.xml` file with synchronized dependencies inside the `META-INF`
directory inside `target/classes` and the JAR in `target`. You can update the version (and SCM tag)
information in generated `pom.xml` by updating `build.clj`.

Install it locally (requires the `ci` task be run first):

    $ clojure -T:build install

Deploy it to Clojars -- needs `CLOJARS_USERNAME` and `CLOJARS_PASSWORD` environment
variables (requires the `ci` task be run first):

    $ clojure -T:build deploy

Your library will be deployed to io.github.bsless/tools.jvm on clojars.org by default.

## License

Copyright © 2022 Ben Sless

Distributed under the Eclipse Public License version 1.0.
