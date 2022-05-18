/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

/**
 *
 * @author Roach
 */
public class Triangle extends Shape implements Cloneable {
    
    int x1,x2,x3;
    int y1,y2,y3;
    int n =3;
    int filled;

     public Triangle() {
 super(null);
    }
     
         public void setTriangle(Color c,int x1,int y1)
    {
        super.setC(c);
        this.x1=x1;
        this.y1=y1;
    }

    

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getX3() {
        return x3;
    }

    public void setX3(int x3) {
        this.x3 = x3;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public int getY3() {
        return y3;
    }

    public void setY3(int y3) {
        this.y3 = y3;
    }

   
    public int getN() {
        return n;
    }


    @Override
    public boolean contains(int x, int y) {
        int xarr[]={x1,x2,x3};
        int yarr[]={y1,y2,y3};
        Polygon tri=new Polygon(xarr,yarr,3);
        return tri.contains(x, y);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Triangle t=(Triangle)super.clone();
        
        return t;
    }

    @Override
    public void draw(Graphics grphcs) {
       
                int x[]={x1,x2,x3};
                int y[]={y1,y2,y3};
                Polygon tri=new Polygon(x,y,3);
                grphcs.setColor(c);
                grphcs.drawPolygon(tri);
    }
    

    
    
}
