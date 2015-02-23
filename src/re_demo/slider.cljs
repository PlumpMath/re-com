(ns re-demo.slider
  (:require [re-com.core      :refer [slider slider-args-desc
                                      label checkbox input-text]]
            [re-com.box       :refer [h-box v-box box gap line]]
            [re-com.tabs      :refer [horizontal-bar-tabs vertical-bar-tabs]]
            [re-demo.utils    :refer [panel-title component-title args-table]]
            [reagent.core     :as    reagent]))


(defn slider-demo
  []
  (let [slider-val  (reagent/atom "0")
        slider-min  (reagent/atom "0")
        slider-max  (reagent/atom "100")
        slider-step (reagent/atom "1")
        disabled?   (reagent/atom false)]
    (fn
      []
      [v-box
       :gap "10px"
       :children [[panel-title "[slider ... ]"]

                  [h-box
                   :gap      "50px"
                   :children [[v-box
                               :gap      "10px"
                               :width    "450px"
                               :children [[args-table slider-args-desc]]]
                              [v-box
                               :gap      "10px"
                               :children [[component-title "Demo"]
                                          [h-box
                                           :gap "40px"
                                           :children [[v-box
                                                       :gap      "10px"
                                                       :children [[slider
                                                                   :model     slider-val
                                                                   :min       slider-min
                                                                   :max       slider-max
                                                                   :step      slider-step
                                                                   :width     "200px"
                                                                   :on-change #(reset! slider-val %)
                                                                   :disabled? disabled?]]]
                                                      [v-box
                                                       :gap      "15px"
                                                       :children [[label :label "parameters:"]
                                                                  [h-box
                                                                   :gap      "10px"
                                                                   :align    :center
                                                                   :children [[label
                                                                               :label ":model"
                                                                               :style {:width "60px"}]
                                                                              [input-text
                                                                               :model           slider-val
                                                                               :width           "70px"
                                                                               :height          "26px"
                                                                               :on-change       #(reset! slider-val %)
                                                                               :change-on-blur? false]]]
                                                                  [h-box
                                                                   :gap      "10px"
                                                                   :align    :center
                                                                   :children [[label
                                                                               :label ":min"
                                                                               :style {:width "60px"}]
                                                                              [input-text
                                                                               :model           slider-min
                                                                               :width           "70px"
                                                                               :height          "26px"
                                                                               :on-change       #(reset! slider-min %)
                                                                               :change-on-blur? false]]]
                                                                  [h-box
                                                                   :gap      "10px"
                                                                   :align    :center
                                                                   :children [[label
                                                                               :label ":max"
                                                                               :style {:width "60px"}]
                                                                              [input-text
                                                                               :model           slider-max
                                                                               :width           "70px"
                                                                               :height          "26px"
                                                                               :on-change       #(reset! slider-max %)
                                                                               :change-on-blur? false]]]
                                                                  [h-box
                                                                   :gap      "10px"
                                                                   :align    :center
                                                                   :children [[label
                                                                               :label ":step"
                                                                               :style {:width "60px"}]
                                                                              [input-text
                                                                               :model           slider-step
                                                                               :width           "70px"
                                                                               :height          "26px"
                                                                               :on-change       #(reset! slider-step %)
                                                                               :change-on-blur? false]]]
                                                                  [checkbox
                                                                   :label ":disabled?"
                                                                   :model disabled?
                                                                   :on-change (fn [val]
                                                                                (reset! disabled? val))]]]]]]]]]]])))


(defn panel   ;; Only required for Reagent to update panel2 when figwheel pushes changes to the browser
  []
  [slider-demo])