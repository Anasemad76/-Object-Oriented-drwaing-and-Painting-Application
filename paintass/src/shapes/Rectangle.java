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
public class Rectangle extends Shape implements Cloneable {

    int x1;
    int y1;
    int length;
    int width;
    int filled;

    public Rectangle() {
        super(null);
    }

    public void setRectangle(Color c, int x1, int y1, int x2, int y2) {
        super.setC(c);
        this.x1 = x1;
        this.y1 = y1;
        this.length = x2 - x1;
        this.width = y2 - y1;
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

    public int getLength() {
        return length;
    }

    public void setLength(int x1, int x2) {
        this.length = Math.abs(x2 - x1);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int y1, int y2) {
        this.width = Math.abs(y2 - y1);
    }

    @Override
    public boolean contains(int x, int y) {
        java.awt.Rectangle ree = new java.awt.Rectangle(x1, y1, length, width);
        return ree.contains(x, y);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Rectangle Rect = (Rectangle) super.clone();
        Rect.c = super.getC();
        return Rect;
    }

    @Override
    public void draw(Graphics grphcs) {
        System.out.println("normal rectangle shape ");
        grphcs.setColor(c);
        grphcs.drawRect(x1, y1, length, width);
    }

}
