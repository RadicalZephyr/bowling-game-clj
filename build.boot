(set-env!
 :resource-paths #{"src" "resources"}
 :source-paths #{"test"}
 :dependencies '[[org.clojure/clojure "1.7.0"]
                 [adzerk/boot-test "1.1.2" :scope "test"]
                 [metosin/boot-alt-test "0.3.0" :scope "test"]
                 [org.clojure/tools.namespace "0.3.0-alpha3" :scope "test"]])

(require '[adzerk.boot-test :refer [test]]
         '[metosin.boot-alt-test :refer [alt-test]])
