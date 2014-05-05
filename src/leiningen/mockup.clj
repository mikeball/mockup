(ns leiningen.mockup
  (:require [leiningen.mockup.mock :as mock]))

(defn show-help [subtask]
  (println "subtask " subtask "not found."))

(defn show-version []
  (println "lein-tao version xyz"))


(defn mockup ; ^:no-project-needed 
  "Helps work with taoclj projects."
  [project subtask & args]
  (println "subtask : " subtask)
  (case subtask
       "serve"      (mock/serve project)
       "run"        (mock/run project)
       "version"    (show-version)
                    (show-help subtask)))





