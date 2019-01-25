(ns app.system
  (:require
    [com.stuartsierra.component :as component]
    ;; [app.db.datomic :as datomic]
    [app.pedestal.component :as pcm]
    [app.pedestal.config :as pcf]))

(defn init-dev-system
  "Initialize system
  :config as config placeholder
  :datomic stores and grabs :datomic {:uri :part :migrator :seed} from the config
  :pedestal calls-start pedestal components using config, and injects the ports and cookie key"
  [config]
  (component/system-map
   :config config
   :mycomponent {:my :component}
   ;; :datomic (component/using
   ;;            (datomic/make (-> config :datomic))
   ;;            [:config])
   :pedestal (component/using
              (pcm/pedestal pcf/pedestal-config-fn config)
              [:config :mycomponent])))
