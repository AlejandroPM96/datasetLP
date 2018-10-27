(ns proyecto2.data
    (:require [clojure.string :as string]
      [cortex.nn.execute :as execute]))

;;Convierte String a Float
(defn parse-float [s]
      (Float/parseFloat s))
;;Carga el archivo
(defn load-data
    "Carga Archivo"
    []
    (as-> (slurp "resources/obesidad.csv") d
          (string/split d #"\n")
          (map #(string/split % #",") d)
          )
        
          )

(defn train-validation-split
"Parte el dataset"
[d percent]
(let [c (int (* percent (count d)))]
        {:train (take c d)
        :validation (drop c d)})
        
        )