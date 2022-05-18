/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

/**
 *
 * @author 20101
 */
//Factory
public class Shapefactory{
    
    public Shape createShape(String name){
        Shape s=null;
        if(name.equals("Circle"))
            s= new Circle();
        else  if(name.equals("Line"))
            s= new Line();
        else  if(name.equals("Rectangle"))
            s= new Rectangle(); 
        else  if(name.equals("Square"))
            s= new Square();
        else  if(name.equals("Triangle"))
            s= new Triangle();
     
        return s;
    }
    
    
    
    
    
}
