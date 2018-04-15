/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numerical;

import javafx.beans.property.SimpleStringProperty;


public class Row {
    private final SimpleStringProperty i;
    private final SimpleStringProperty a;
    private final SimpleStringProperty b;
    private final SimpleStringProperty c;
    private final SimpleStringProperty fa;
    private final SimpleStringProperty fb;
    private final SimpleStringProperty fc;
    private final SimpleStringProperty cnd;
    
    Row(String i , String a , String b , String c ,String fa ,String fb ,String fc,String cnd)
    {
    this.i = new SimpleStringProperty(i);
    this.a = new SimpleStringProperty(a);
    this.b = new SimpleStringProperty(b);
    this.c = new SimpleStringProperty(c);
    this.fa = new SimpleStringProperty(fa);
    this.fb = new SimpleStringProperty(fb);
    this.fc = new SimpleStringProperty(fc);
    this.cnd = new SimpleStringProperty(cnd);
    
        
    }
    
     public String getI(){
         return i.get();
     }
     
     public void setI(String I){
         i.set(I);
     }
     
     public String getA(){
         return a.get();
     }
     
      public void setA(String A){
         a.set(A);
     }
     
     public String getB(){
         return b.get();
     }
     
      public void setB(String B){
         b.set(B);
     }
     
     public String getC(){
         return c.get();
     }
     
      public void setC(String C){
         c.set(C);
     }
     
     public String getFA(){
         return fa.get();
     }
     
      public void setFA(String FA){
         fa.set(FA);
     }
     
     public String getFB(){
         return fb.get();
     }
     
      public void setFB(String FB){
         fb.set(FB);
     }
     
     public String getFC(){
         return fc.get();
     }
     
      public void setFC(String FC){
         fc.set(FC);
     }
      
       public String getCND(){
         return cnd.get();
     }
     
      public void setCND(String CND){
         cnd.set(CND);
     }
    
    
    
    
}
