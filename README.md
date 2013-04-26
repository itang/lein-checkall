# lein-checkall

A Leiningen plugin to do many wonderful things.

"lein check && lein kibit && lein eastwood && lein bikeshed"

## Usage

Use this for user-level plugins:

Put `[lein-checkall "0.1.0-SNAPSHOT"]` into the `:plugins` vector of your
`:user` profile, or if you are on Leiningen 1.x do `lein plugin install
lein-checkall 0.1.0-SNAPSHOT`.

Use this for project-level plugins:

Put `[lein-checkall "0.1.0-SNAPSHOT"]` into the `:plugins` vector of your project.clj.

and add an example usage that actually makes sense:

    $ lein checkall

## License

Copyright © 2013 itang

Distributed under the Eclipse Public License, the same as Clojure.
