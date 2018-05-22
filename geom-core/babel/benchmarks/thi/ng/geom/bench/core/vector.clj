(ns thi.ng.geom.bench.core.vector
  (:require
   [thi.ng.geom.core :as g]
   [thi.ng.geom.core.utils :as gu]
   [thi.ng.geom.core.vector :as v :refer [vec2 vec3]]
   [thi.ng.math.core :as m :refer [*eps* HALF_PI PI]]
   [perforate-x.core :refer :all]))

(def A2 (vec2 1 2))
(def B2 (vec2 10 20))
(def C2 (vec2 100 200))
(def D2 (vec2 1000 2000))

(def A3 (vec3 1 2 3))
(def B3 (vec3 10 20 30))
(def C3 (vec3 100 200 300))
(def D3 (vec3 1000 2000 3000))

(def N 10.0)
(def M 100.0)
(def O 1000.0)

(defgoal :vec2-ops "vec2-ops")

(defcase :vec2-ops :add-v
  [] #(g/+ A2 B2))

(defcase :vec2-ops :add-vv
  [] #(g/+ A2 B2 C2))

(defcase :vec2-ops :add-n
  [] #(g/+ A2 N))

(defcase :vec2-ops :add-nn
  [] #(g/+ A2 N M))

(defcase :vec2-ops :add-s
  [] #(g/+ A2 [N M]))

(defcase :vec2-ops :scale-v
  [] #(g/* A2 B2))

(defcase :vec2-ops :scale-n
  [] #(g/* A2 N))

(defcase :vec2-ops :madd
  [] #(g/madd A2 N B2))

(defcase :vec2-ops :madd-op2
  [] #(g/* (g/+ A2 N) B2))

(defcase :vec2-ops :dot
  [] #(g/dot A2 B2))

(defcase :vec2-ops :normalize
  [] #(g/normalize A2))

(defcase :vec2-ops :mag
  [] #(g/mag A2))

(defcase :vec2-ops :mag-squared
  [] #(g/mag-squared A2))

(defcase :vec2-ops :mix
  [] #(g/mix A2 B2 0.5))

(defcase :vec2-ops :mix-bi
  [] #(g/mix A2 B2 C2 D2 0.5 0.5))

(defcase :vec2-ops :rotate
  [] #(g/rotate A2 HALF_PI))
(defgoal :vec2-ops-mut "vec2-ops-mutable")

(defcase :vec2-ops-mut :add-v-ctor
  [] #(g/+ (vec2 1 2) B2))

(defcase :vec2-ops-mut :add-v!
  [] #(g/+! (vec2 1 2) B2))

(defcase :vec2-ops-mut :madd-v-ctor
  [] #(g/madd (vec2 1 2) N B2))

(defcase :vec2-ops-mut :madd-v!
  [] #(g/madd! (vec2 1 2) N B2))
(defgoal :vec3-ops "vec3-ops")

(defcase :vec3-ops :add-v
  [] #(g/+ A3 B3))

(defcase :vec3-ops :add-vv
  [] #(g/+ A3 B3 C3))

(defcase :vec3-ops :add-n
  [] #(g/+ A3 N))

(defcase :vec3-ops :add-nnn
  [] #(g/+ A3 N M O))

(defcase :vec3-ops :add-s
  [] #(g/+ A3 [N M O]))

(defcase :vec3-ops :scale-v
  [] #(g/* A3 B3))

(defcase :vec3-ops :scale-n
  [] #(g/* A3 N))

(defcase :vec3-ops :madd
  [] #(g/madd A3 N B3))

(defcase :vec3-ops :madd-op2
  [] #(g/* (g/+ A3 N) B3))

(defcase :vec3-ops :dot
  [] #(g/dot A3 B3))

(defcase :vec3-ops :cross
  [] #(g/cross A3 B3))

(defcase :vec3-ops :ortho-normal
  [] #(gu/ortho-normal A3 B3 C3))

(defcase :vec3-ops :normalize
  [] #(g/normalize A3))

(defcase :vec3-ops :mag
  [] #(g/mag A3))

(defcase :vec3-ops :mag-squared
  [] #(g/mag-squared A3))

(defcase :vec3-ops :mix
  [] #(g/mix A3 B3 0.5))

(defcase :vec3-ops :mix-bi
  [] #(g/mix A3 B3 C3 D3 0.5 0.5))

(defcase :vec3-ops :rotate-x
  [] #(g/rotate-x A3 HALF_PI))

(defcase :vec3-ops :rotate-axis
  [] #(g/rotate-around-axis A3 v/V3Y HALF_PI))
