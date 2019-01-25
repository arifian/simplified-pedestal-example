(defproject app "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies
  [[org.clojure/clojure "1.10.0"]
   [com.stuartsierra/component "0.4.0"]
   [com.datomic/datomic-free "0.9.5697"
    ;; :exclusions [org.slf4j/slf4j-nop
    ;;              com.fasterxml.jackson.core/jackson-annotations
    ;;              joda-time
    ;;              com.fasterxml.jackson.core/jackson-databind]
    ]
   [io.pedestal/pedestal.service "0.5.5"]
   [io.pedestal/pedestal.jetty "0.5.5"]
   ;; [com.cognitect/transit-clj "0.8.300"]
   [clj-time "0.15.0"]
   [datomic-schema "1.3.0"]
   [me.raynes/fs "1.4.6"]
   [clj-http "3.9.1"]
   [cheshire "5.8.1"]
   [dk.ative/docjure "1.13.0"]]
  
  ;; :clean-targets ^{:protect false} ["target"]

  :source-paths ["src"]
  :repl-options {:init-ns user}
  :main app.core
  :uberjar-name "wow.jar"
  :jvm-opts ["-Xms1G" "-Xmx4G" "-server" "-XX:-OmitStackTraceInFastThrow"]
  :profiles
  {:dev  {:dependencies [[org.clojure/tools.namespace "0.2.11"]]
          :source-paths ["dev"]}
   :test {:source-paths []}}
  :target-path "target/%s")
