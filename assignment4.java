 1 // Aubrey Isaacman
  2 // alisaacm
  3 // CMPS012B
  4 // 12/8/2014
  5 // Sets up the rooms and options for the player.
  6
  7 //import java.io.*;
  8 //import java.util.Scanner;
  9 //import static java.lang.System.*;
 10
 11 package com.androchill.assignment4;
 12
 13 import java.io.BufferedReader;
 14 import java.io.FileReader;
 15 import java.io.InputStreamReader;
 16 import java.util.ArrayList;
 17 import java.util.Stack;
 18
 19 public class Assignment4{
 20
 21     public static void main (String[] args){
 22         if (args.length < 1) System.exit(1);
 23
 24         ArrayList<Node> nodes = new ArrayList<Node>();
 25         Node firstNode = null;
 26         Stack <Node> history = new Stack<Node>();
 27
 28         try{
 29             //read in lines
 30             BufferedReader br = new BufferedReader(new FileReader(args[0]));
 31             String s;
 32             Node lastNode = null;
 33             String lastTest = null;
 34             while((s = br.readLine()) != null){
 35                 if(s.length()<1) continue;
 36
 37                 //get command
 38                 char c = s.charAt(0);
 39
 40                 switch(c){
 41                     case 'r':
 42                         //get node name and create new node
 43                         lastNode = new Node(s.substring(2));
 44                         //check to see if we already made this
 45                         if(!nodes.contains(lastNode)){
 46                             nodes.add(lastNode);
 47                         } else {
 48                             //the node already exists, get what's there
 49                             lastNode = nodes.get(nodes.indexOf(lastNode));
 50                         }
 51
 52                         //starting point for adventure
 53                         if(firstNode == null){
 54                             firstNode = lastNode;
 55                         }
 56                         break;
 57                     case 'd':
 58                         //description text
 59                         assert(lastNode != null);
60
 61                         lastNode.addDescriptionText(s.substring(2));
 62                         break;
 63                     case 'o':
 64                         //add a choice
 65                         lastText = s.string(2);
 66                         break;
 67                     case 't':
 68                         //add a node
 69                         //NODE MIGHT NOT EXIST YET!
 70                         Node newChoice = new Node(s.substring(2));
 71                         //check if we already created this node
 72                         if(!nodes.contains(newChoice)){
 73                             nodes.add(newChoice);
 74                         } else {
 75                             //node already exists --> make sure we get what's already there
 76                             newChoice = nodes.get(nodes.indexOf(newChoice));
 77                         }
 78
 79                          assert(lastText != null);
 80                          assert(lastNode != null);
 81
 82                          lastNode.addChoice(newChoice, lastText);
 83                          break;
 84                 }
 85             }
 86             br.close();
 87         } catch (Exception e){
 88             e.printStackTrace();
 89             System.exit(1);
 90         }
 91
 92         try {
 93             assert(firstNode != null);
 94             BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 95             String s;
 96             while(true){
 97                 //print stuff
 98                 System.out.println();
 99                 ArrayList<String> text = firstNode.getDescriptionText();
100                 for (String t : text) {
101                     System.out.println(t);
102                 }
103
104                 ArrayList<Pair<Node, String>> choices = firstNode.getChoices();
105                 for(int i = 0; i < choices.size(); i++){
106                     System.out.println((char)('a' + i) + " - " + choices.get(i).getValue());
107                 }
108
109
110                 //get user input
111                 s = br.readLine();
112                 if(s.length()<1) continue;
113                 char c = s.charAt(0);
114                 System.out.println();
115
116                 //determine what choice the user made
117                 if (c - 'a' >= 0 && c- 'a' < choices.size()){
118                     //choice made, save node to history
119                     history.push(firstNode);
120                     firstNode = choices.get(c - 'a').getKey();
121                     System.out.println("[" + choices.get(c - 'a').getValue() + "]");
122                 } else if (c == 'r'){
123                     //restart
124                     System.out.println("[Restarting]");
125                     //go back to first node
126                     firstNode = nodes.get(0);
127                     //clear undo history
128                     history.clear();
129                 } else if (c == 'q') {
130                     //exit
131                     System.out.println("[Exiting]");
132                     System.exit(0);
133                 } else if (c == 'y'){
134                     //info
135                     System.out.println("[Information]");
136                     for(Node n: nodes){
137                         System.out.println(n.toString());
138                     }
139                 } else if (c == 'z' && history.size() > 0) {
140                     //undo
141                     System.out.println("[Undo-ing]");
142                         //go back to previous room (last node added)
143                     firstNode = history.pop();
144                 }
145
146             }
147          } catch (Exception e){
148             //error
149             e.printStackTrace();
150             System.exit(1);
151          }
152     }
153 }
