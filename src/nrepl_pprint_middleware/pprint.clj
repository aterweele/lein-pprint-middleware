(ns nrepl-pprint-middleware.pprint
  (:require nrepl.middleware
            clojure.pprint))

(defn nrepl-compatible-pprint
  "`clojure.pprint/pprint`, but with a signature/arity compatible with
  `:nrepl.middleware.print/print`."
  [value writer options]
  (clojure.pprint/pprint value writer))

(defn wrap-pprint
  "nREPL middleware that reformats output using
  `clojure.pprint/pprint`."
  [handler]
  (fn [message]
    (-> message
        (assoc :nrepl.middleware.print/print #'nrepl-compatible-pprint)
        handler)))

(nrepl.middleware/set-descriptor!
 #'wrap-pprint
 {:expects #{#'nrepl.middleware.print/wrap-print}})
