 1 // Aubrey Isaacman
  2 // alisaacm
  3 // CMPS012B
  4 // 12/8/2014
  5 // Sets up the nodes for the tree.
  6 //
  7
  8 package com.androchill.assignment4;
  9
 10 import java.util.ArrayList;
 11
 12 public class Node {
 13     String label;
 14
 15     ArrayList<Pair<Node, String>> choices;
 16     ArrayList<String> descriptionText;
 17
 18     public Node(String label){
 19         this.label = label;
 20         choices = new ArrayList<Pair<Node, String>>();
 21         descriptionText = new ArrayList<String>();
 22     }
 23
 24     public void addChoice(Node choice, String choiceDescriptioin){
 25         choices.add(new Pair<Node, String>(choice, choiceDescription));
 26     }
 27
 28     public ArrayList<Pair<Node, String>> getChoices(){
 29         return choices;
 30     }
 31
 32     public void addDescriptionText(String text){
 33         descriptionText.add(text);
 34     }
 35
 36     public ArrayList<String> getDescriptionText(){
 37         return descriptionText;
 38     }
 39
 40     public String getLabel(){
 41         return label;
 42     }
 43
 44     @Override
 45         public boolean equals(Object other){
 46             if (other== null || !(other instanceof Node)) return false;
 47             Node o = (Node) other;
 48             return label.equals(o.label);
 49         }
 50
 51     @Override
 52         public String toString(){
 53             StringBuilder sb = new StringBuilder();
 54             sb.append(getLabel());
 55             sb.append(" :");
 56             for(Pair<Node, String> choice : getChoices()){
 57                 sb.append(" ");
 58                 sb.append(choice.getKey().getLabel());
 59             }
  60             return sb.toString();
 61         }
 62 }
