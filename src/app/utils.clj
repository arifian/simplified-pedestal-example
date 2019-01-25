(ns app.utils
  (:require
    [clj-time.core :as t]
    [clj-time.format :as f]
    ;; [clj-uuid :as uuid]
    [clojure.edn :as edn]
    [cheshire.core :refer [parse-string]]
    [clojure.string :as cs]
    [clojure.pprint :refer [pprint]]
    [clojure.java.io :as io]
    [datomic.api :as d]
    [me.raynes.fs :as fs]
    [io.pedestal.log :as log]))

(defn squuid
  []
  (d/squuid))

;; (def pres clojure.pprint/pprint)

;; (defn info [& body]
;;   (apply println "INFO :" body))

;; (defn error [& body]
;;   (apply println "ERROR :" body))

;; (defn warn [& body]
;;   (apply println "WARNING :" body))

;; (defmacro ex-msg
;;   "Try an expression and return the exception message"
;;   [exprs]
;;   (let [vare (gensym)]
;;     `(try ~exprs
;;           (catch Exception ~vare
;;             (.getMessage ~vare)))))

;; (defn get-os
;;   []
;;   (let [res (System/getProperty "os.name")]
;;     (if (cs/includes? res "Win") :win :posix)))

;; (defn create-path
;;   ([vec-path os]
;;    (if (= :win os)
;;      (->> vec-path
;;           (interpose "\\")
;;           (cons "\\")
;;           (apply str))
;;      (->> vec-path
;;           (interpose "/")
;;           (cons "/")
;;           (apply str))))
;;   ([vec-path]
;;    (create-path vec-path (get-os))))

(defn cslurp
  "Helper function to easily slurp and read-string a file"
  [fname]
  ((comp edn/read-string slurp) fname))

;; (defn cspit
;;   "Helper function to beautifully print clojure to file"
;;   [fname data]
;;   (->> data pprint with-out-str (spit fname)))

;; (defn now
;;   "Returns the current date and time"
;;   []
;;   (f/unparse (f/formatter "yyyyMMdd-hhmmss") (t/now)))

;; (defn today
;;   "Given zero argument, it returns YYYYMMDD, given one argument it returns YYYY-MM-DD"
;;   ([]
;;    (f/unparse (f/formatter "yyyyMMdd") (t/now)))
;;   ([_]
;;    (f/unparse (f/formatter "yyyy-MM-dd") (t/now))))

;; ;; (defn uuid
;; ;;   "When given zero argument, it returns a uuid/v1, given one arguments, it returns
;; ;;   a list of n uuids."
;; ;;   ([]
;; ;;    (cs/replace (str (uuid/v1)) #"-" ""))
;; ;;   ([n]
;; ;;    (repeatedly n uuid)))

;; ;; typically used for datomic to make things easier

;; (defn xkey
;;   "Extract keyword name from datomic namespaced keyword.
;;   (xkey :user/nama) => :nama"
;;   [namespaced-keyword]
;;   (keyword (name namespaced-keyword)))

;; (defn dkey
;;   "Create a datomic namespaced keyword from non-namespaced keyword.
;;   (dkey :user :nama) => :user/nama"
;;   [namespace xkey]
;;   (keyword (str (name namespace) "/" (name xkey))))

;; (defn nskey
;;   "Returns the ns part of a keyword
;;   (nskey :user/nama) => :user"
;;   [ns-keyword]
;;   (-> ns-keyword str
;;       (cs/split #"/")
;;       first read-string))

;; (defn dmap
;;   "Transform a map with ordinary keywords and returns the same map
;;   but with keywords namespaced.
;;   (dmap :user {:n :s :a :t}) => {:user/n :s :user/a :t}"
;;   [namespace xmapi]
;;   (-> (map #(dkey namespace %) (keys xmapi))
;;       (zipmap (vals xmapi))))

;; (defn xmap
;;   "Transform a map with datomic namespaced keywords into a map with
;;   extracted keywords.
;;   (xmap {:user/n :a :user/t :b}) => {:n :a :t :b}"
;;   [dmap]
;;   (-> (map xkey (keys dmap))
;;       (zipmap (vals dmap))))

;; ;kambing-debug-route
;; (defn route-debug-req []
;;   (require '[io.pedestal.test :refer [response-for]])
;;   (require '[cognitect.transit :as transit])
;;   (import '[java.io ByteArrayInputStream ByteArrayOutputStream]))

;; (defn str-debug-foo []
;;   "[(defn resp-get
;;     [route]
;;     (response-for (:io.pedestal.http/service-fn (:pedestal-server (:pedestal @dev-system))) :get route))
;;   (defn resp-get-headers
;;     [route headers]
;;     (response-for (:io.pedestal.http/service-fn (:pedestal-server (:pedestal @dev-system))) :get route :headers headers))
;;   (defn resp-post
;;     [route headers body]
;;     (response-for (:io.pedestal.http/service-fn (:pedestal-server (:pedestal @dev-system))) :post route :headers headers :body body))]")

;; (defn route-debug-foo []
;;   (map eval (read-string (str-debug-foo))))
