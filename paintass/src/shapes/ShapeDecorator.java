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
 * @author 20101
 */
//decorator
public class ShapeDecorator extends Shape {
    Shape s;
    public ShapeDecorator(Shape s){
        super(s.c);
        this.s=s;
    }

    @Override
    public boolean contains(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void draw(Graphics grphcs) {
        System.out.println("decorated shape "+s.toString());
        if(s instanceof Circle){
            Circle c1 = (Circle)s;
                grphcs.setColor(c1.getC());
                grphcs.fillOval(c1.getX1(),c1.getY1(), c1.getRadius(),c1.getRadius());}
        
        else if(s instanceof Rectangle ){
          Rectangle r = (Rectangle)s;
                grphcs.setColor(r.getC());
                grphcs.fillRect(r.getX1(),r.getY1(), r.getLength(), r.getWidth());
     
        }
        else if(s instanceof Square){
            
              Square sq = (Square)s;
                grphcs.setColor(sq.getC());
                grphcs.fillRect(sq.getX1(),sq.getY1(), sq.getLength(),sq.getLength());
 
        }
        else if( s instanceof Triangle){
          Triangle t=(Triangle) s;
                int x[]={((Triangle) t).getX1(),((Triangle) t).getX2(),((Triangle) t).getX3()};
                int y[]={((Triangle) t).getY1(),((Triangle) t).getY2(),((Triangle) t).getY3()};
                Polygon tri=new Polygon(x,y,3);
                grphcs.setColor(t.getC());
                grphcs.fillPolygon(tri);
                //int x2[]={0,50,100};
                //int y2[]={0,50,200};
                //g.drawPolygon(x2, y2, 3);
        
        }
        else if( s instanceof Line){
          Line l = (Line) s;
                grphcs.setColor(l.getC());
                grphcs.drawLine(l.getX1(), l.getY1(), l.getX2(), l.getY2());
        
        
        }

    }


    
    
    
    
    
}
