package com.mycompany.madmath;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;


public class MadMath {

    public static void main(String[] args) {
        
        String problem = "5+((1+2)*4)-3";
        
        ArrayList<String> list = tokenize(problem);
        
        ArrayList<String> rpn = toRPN(list);
        
        
        
        System.out.println(problem);
        
        for(int i = 0 ; i < list.size(); i++) {
            
            System.out.print(list.get(i) + " , ");
            
        }
        
        
        System.out.println(" ");
        
        
        
        for(int i = 0 ; i < rpn.size(); i++) {
            
            System.out.print(rpn.get(i));
            
        }
        
        
    }
    
    
    public static ArrayList<String> tokenize(String string) {
        
        ArrayList<String> list = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        
        boolean wasOperater = true;
        
        
        
        
        for(int i = 0 ; i < string.length() ; i++) { 
            
            char c = string.charAt(i);
            
            
            if(Character.isDigit(c) || c == '.') { // is a digit
                
                if(!wasOperater) { // the c before was NOT op
                    
                    builder.append(c);
                    
                    wasOperater = false;
                    
                    continue;
                    
                }
                else { // the c before was an op
                    
                    
                    builder.setLength(0);
                    builder.append(c);
                    
                    wasOperater = false;
                    
                    continue;
                    
                }
            }
            
            else if("/*-+".indexOf(c) != -1) { // c is an op
                
                if(wasOperater) { // c before was an op
                    
                    if(c == '-' && builder.length() == 0) {
                        
                        builder.setLength(0);
                        builder.append('c');
                        
                        continue;
                        
                    }
                    else {
                        throw new RuntimeException("Expected an opertater!");
                    }
                }
                
                else { // c before was a digit
                    
                    
                    if(builder.length() > 0) {
                        
                        list.add(builder.toString()); // flush hte number
                        builder.setLength(0);
                        
                    }
                    
                    list.add(c + "");
                    
                    
                }
                
            }
            
            else if(c == '(' || c == ')') {
                
                
                if(builder.length() > 0) {
                    
                    list.add(builder.toString());
                    builder.setLength(0);
                    
                }
                
                list.add(c + "");
                
            }
            
            else {
                
                throw new RuntimeException("Wrong Syntax!");
                
            }
            
            
            
        }
        
        if(builder.length() > 0) {
        list.add(builder.toString());
        }
        
        return list;
        
    }
    
    public static ArrayList<String> toRPN(ArrayList<String> src) {
        
        Deque<String> stack = new ArrayDeque<>();
        ArrayList<String> output = new ArrayList<>();
        
        
        for (int i = 0; i < src.size(); i++) {
            
            String token = src.get(i);
            char c = token.charAt(0);
            
            if (token.isEmpty()) continue;
            
            if(Character.isDigit(c)) {
                 output.add(token);
            }
            
            else if (c == '(') {
                 stack.push(token);
            }
            
            else if (c == ')') {

                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                     output.add(stack.pop());
                }

                stack.pop(); 
                
                }
            
            else if (isOperator(token)) {

            while (!stack.isEmpty()
                    && !stack.peek().equals("(")
                    && precedence(stack.peek()) >= precedence(token)) {

                    output.add(stack.pop());
               }

            stack.push(token);

             }

             

                

             }
        
                while (!stack.isEmpty()) {
                output.add(stack.pop());
                }

            return output;
        }
    
    
    
    
    
    
     public static boolean isOperator(String s) {
        
            return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    
        }
    
        public static int precedence(String s) {
        
            if (s.equals("+") || s.equals("-")) return 1;
            if (s.equals("*") || s.equals("/")) return 2;
        
            return 0;
        }
    
    
    
    
}
