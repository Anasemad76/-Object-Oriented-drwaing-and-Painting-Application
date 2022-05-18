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
//Template
public abstract class Shape implements Cloneable{
     Color c=Color.BLACK;
 
   

    public Color getC() {
        return c;
    }

    public void setC(Color c) {
        this.c = c;
    }

    public Shape(Color c)
    {
        this.c=c;
    }
    public abstract boolean contains(int x,int y);

    
    
     public abstract void  draw(Graphics grphcs);
    
    
}
