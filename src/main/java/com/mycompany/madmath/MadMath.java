package com.mycompany.madmath;

import java.util.ArrayList;


public class MadMath {

    public static void main(String[] args) {
        
        String problem = "12.3+2/33.1+11*2";
        
        ArrayList<String> list = tokenize(problem);
        
        for(int i = 0 ; i < list.size(); i++) {
            
            System.out.println(list.get(i));
            
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
            
            else if("/*-+()".indexOf(c) != -1) { // c is an op
                
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
                    
                    list.add(builder.toString()); // flush hte number
                    
                    builder.setLength(0);
                    
                    list.add(c + "");
                    
                    
                }
                
            }
            
            else {
                
                throw new RuntimeException("Wrong Syntax!");
                
            }
            
            
            
        }
        
        list.add(builder.toString());
        return list;
        
    }
    
}
