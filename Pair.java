 1 // Aubrey Isaacman
  2 // alisaacm
  3 // CMPS012B
  4 // 12/8/2014
  5 // Simple Pair class for assignment4
  6
  7 package com.androchill.assignment4;
  8
  9 public class Pair<K, V>{
 10     private K key;
 11     private V value;
 12
 13     public Pair(K key, V value){
 14         this.key = key;
 15         this.value = value;
 16     }
 17
 18     public K getKey(){
 19         return key;
 20     }
 21
 22     public V getValue(){
 23         return value;
 24     }
 25 }
