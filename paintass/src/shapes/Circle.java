/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Roach
 */
public class Circle extends Shape  {
    
    int x1;
    int y1;
    int radius;
    int filled;
    
    public Circle() {
       super(null); 
    }
    
    public void setCircle(Color c,int x1,int y1,int radius) {
        super.setC(c);
        this.x1=x1;
        this.y1=y1;
        this.radius=radius;
    }
    
     

    
   

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int x1,int x2) {
        this.radius=Math.abs(x2-x1);
    }

    @Override
    public boolean contains(int x, int y) {
        javafx.scene.shape.Ellipse o=new javafx.scene.shape.Ellipse(x1,y1,radius,radius);
        return o.contains(x,y);
    }

   /* @Override
    protected Object clone() throws CloneNotSupportedException {
        Circle c=(Circle)super.clone(); 
       //c.setC()=super.getC().clone;
        Object clone = super.getC().clone();
        c.setC=clone;
        Object clone1=super.getC();
        c.set
        
        
   
        
        return c;
    }*/

    @Override
    public void draw(Graphics grphcs) {

                grphcs.setColor(c);
                grphcs.drawOval(x1,y1,radius,radius);


}
}