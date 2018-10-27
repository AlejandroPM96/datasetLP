(ns proyecto2.core
  (:require [cortex.nn.network :as network]
    [clojure.string :as string]
    [proyecto2.data :as data]
    [clojure.pprint :refer [pprint]])
  (:gen-class)
  )


(defn -main

  [& args]
  (println "main ejecutado")
  (println "cargando datos")
  
  (slurp "resources/obesidad.csv")
;;Open .csv files
(with-open 
  [rdr (clojure.java.io/reader "resources/obesidad.csv")]
  (def datasetO (reduce conj [] (line-seq rdr)))
)
;;clearing the dataset
(def cleanO (filter (fn [x] (not= x " ")) (drop 1 datasetO)) )



;;dividing the datasets
(defonce all-data (-> (data/load-data)
  (shuffle)
  (data/train-validation-split 0.70))
)
(all-data [])
(print "Datos de entrenamiento: ")
(println (count (:train all-data)))
(print "Datos de validacion: ")
(println (count (:validation all-data)))

)