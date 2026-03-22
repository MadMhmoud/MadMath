package com.mycompany.madmath;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;


public class MadMath {

    public static void main(String[] args) {
        
        String problem = "1+2*(2-1)-12.1";
        
        ArrayList<String> list = tokenize(problem);
        
        System.out.println(problem);
        
        for(int i = 0 ; i < list.size(); i++) {
            
            System.out.print(list.get(i) + " , ");
            
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
    
     public static boolean isOperator(String s) {
        
            return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    
        }
    
        public static int precedence(String s) {
        
            if (s.equals("+") || s.equals("-")) return 1;
            if (s.equals("*") || s.equals("/")) return 2;
        
            return 0;
        }
    
    
    
    
}
