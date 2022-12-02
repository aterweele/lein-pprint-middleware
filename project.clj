(defproject name.atw/nrepl-pprint-middleware "0.1.3-SNAPSHOT"
  :description
  "An nREPL middleware that causes output to be pretty-printed."
  :url "https://github.com/aterweele/lein-pprint-middleware"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [nrepl "0.8.3"]]
  :deploy-repositories [["clojars" {:username "atw"
                                    :password :env/deploy_token
                                    :sign-releases false}]
                        ["releases" :clojars]
                        ["snapshots" :clojars]]
  
  ;; the default `:release-tasks`, but don't lein deploy (that is done
  ;; in CI) and don't VCS push (rather, do that manually)
  :release-tasks [["vcs" "assert-committed"]
                  ["change" "version" "leiningen.release/bump-version" "release"]
                  ["vcs" "commit"]
                  ["vcs" "tag"]
                  ["change" "version" "leiningen.release/bump-version"]
                  ["vcs" "commit"]])
