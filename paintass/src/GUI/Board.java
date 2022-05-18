/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import static javax.swing.SwingUtilities.paintComponent;
import javax.swing.text.Document;
import javax.swing.undo.UndoManager;
import shapes.*;

/**
 *
 * @author Roach
 */
public class Board extends JPanel implements MouseListener, MouseMotionListener {

    ArrayList<Shape> s = new ArrayList<Shape>();
    ArrayList<Shape> s2 = new ArrayList<Shape>();
    int x1;
    int x2;
    int y1;
    int y2;
    int mode;
    boolean fill = false;
    Shape selected = null;
    Shapefactory f;

    Color currentColor = Color.BLACK;
    protected UndoManager um = new UndoManager();

        
    public Board() {
        this.f = new Shapefactory();
        addMouseListener(this);
        addMouseMotionListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent me) {

        if (mode == 9 && selected != null) {
            //s.add(selected);
            System.out.println("inside copied");
            if (selected instanceof Rectangle) {

                Rectangle rect = (Rectangle) f.createShape("Rectangle");
                Rectangle temp = (Rectangle) selected;
                rect.setLength(0, temp.getLength());
                rect.setWidth(0, temp.getWidth());
                rect.setX1(x1);
                rect.setY1(y1);
                s.add(rect);

            } else if (selected instanceof Circle) {
                Circle c = (Circle) f.createShape("Circle");
                Circle temp = (Circle) selected;

                c.setRadius(0, temp.getRadius());
                c.setX1(x1);
                c.setY1(y1);
                s.add(c);
            } else if (selected instanceof Square) {
                Square sq = (Square) f.createShape("Square");
                Square temp = (Square) selected;
                sq.setLength(0, temp.getLength());
                sq.setX1(x1);
                sq.setY1(y1);
                s.add(sq);
            } else if (selected instanceof Triangle) {
                Triangle t = (Triangle) f.createShape("Triangle");
                Triangle temp = (Triangle) selected;
                int xtemp = temp.getX1();
                int ytemp = temp.getY1();
                t.setX1(x1);
                t.setY1(y1);
                t.setX2(temp.getX2() + (x1 - temp.getX1()));
                t.setY2(temp.getY2() + (y1 - temp.getY1()));
                t.setX3(temp.getX3() + (x1 - temp.getX1()));
                t.setY3(temp.getY3() + (y1 - temp.getY1()));
                //t.setY3(y1+(temp.getX3()-temp.getY1()));
                s.add(t);
            }
            repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        x1 = me.getX();
        y1 = me.getY();
        System.out.println("mouse pressed mode is "+mode);
        if (mode == 1) {
            Line l = (Line) f.createShape("Line");
            l.setLine(currentColor, x1, y1, x1, y1);
            s.add(l);
            repaint();
        } else if (mode == 2) {
            Rectangle r = (Rectangle) f.createShape("Rectangle");
            r.setRectangle(currentColor, x1, y1, x1, y1);
            s.add(r);
            repaint();
        } else if (mode == 3) {
            Circle c = (Circle) f.createShape("Circle");
            c.setCircle(currentColor, x1, y1, x1);
            s.add(c);
            repaint();
        } else if (mode == 4) {
            Square sq = (Square) f.createShape("Square");
            sq.setSquare(currentColor, x1, y1, x1);
            s.add(sq);
            repaint();
        } else if (mode == 5) {
            Triangle t = (Triangle) f.createShape("Triangle");
            t.setTriangle(currentColor, x1, y1);
            t.setX1(x1);
            t.setY1(y1);
            s.add(t);
            repaint();
        } else if (mode == 6 || mode == 7) {
            for (int i = s.size() - 1; i >= 0; i--) {
                if (s.get(i).contains(x1, y1)) {
                    selected = s.get(i);
                    System.out.println("seleted");
                    break;
                }
            }
        } else if (mode == 8) {
            for (int i = s.size() - 1; i >= 0; i--) {
                if (s.get(i).contains(x1, y1)) {
                    s.remove(i);
                    System.out.println("inside delete");
                    repaint();
                    break;
                }
            }
        } else if (mode == 9) {
            for (int i = s.size() - 1; i >= 0; i--) {
                if (s.get(i).contains(x1, y1)) {

                    selected = s.get(i);
                    System.out.println("copied");
                    break;

                }
            }
        }
        /*else if(mode==9&&selected!=null)
        {
            //s.add(selected);
            System.out.println("inside copied");
            if(selected instanceof Rectangle)
            {
                Rectangle rect=(Rectangle)selected;
                rect.setX1(x1);
                rect.setY1(y1);
                s.add(rect);
            }            
            else if(selected instanceof Circle)
            {
                Circle c=(Circle)selected;
                c.setX1(x1);
                c.setY1(y1);
                s.add(c);
            }
            else if(selected instanceof Square)
            {
                Square sq=(Square)selected;
                sq.setX1(x1);
                sq.setY1(y1);
                s.add(sq);
            }
            else if(selected instanceof Triangle)
            {
                Triangle t=(Triangle)selected;
                int xtemp=t.getX1();
                int ytemp=t.getY1();
                t.setX1(x1);
                t.setY1(y1);
                t.setX2(t.getX2()+(t.getX1()-xtemp));
                t.setY2(t.getY2()+(t.getY1()-ytemp));
                t.setX3(t.getX3()+(t.getX1()-xtemp));
                t.setY3(t.getY3()+(t.getY1()-ytemp));
                s.add(t);
            }
            repaint();
        }*/

    }

    @Override
    public void mouseReleased(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        if (mode == 1) {
            x2 = me.getX();
            y2 = me.getY();
            Shape so = s.get(s.size() - 1);
            if (so instanceof Line) {
                Line l = (Line) so;
                l.setX2(x2);
                l.setY2(y2);
            }
        }
        if (mode == 2) {
            x2 = me.getX();
            y2 = me.getY();
            Shape so = s.get(s.size() - 1);
            if (so instanceof Rectangle) {
                Rectangle r = (Rectangle) so;
                if (x2 < ((Rectangle) so).getX1()) {
                    ((Rectangle) so).setX1(x2);
                    ((Rectangle) so).setLength(x2, x1);
                } else {
                    r.setLength(x1, x2);
                }
                if (y2 < y1) {
                    ((Rectangle) so).setY1(y2);
                    ((Rectangle) so).setWidth(y2, y1);

                } else {
                    r.setWidth(y1, y2);
                }

            }
        }
        if (mode == 3) {
            x2 = me.getX();
            y2 = me.getY();
            Shape so = s.get(s.size() - 1);
            if (so instanceof Circle) {
                Circle c = (Circle) so;
                if (x2 < ((Circle) so).getX1()) {
                    ((Circle) so).setX1(x2);
                    ((Circle) so).setRadius(x2, x1);
                } else {
                    c.setRadius(x1, x2);
                }
                if (y2 < y1) {
                    ((Circle) so).setY1(y2);
                    ((Circle) so).setRadius(y2, y1);

                } else {
                    c.setRadius(y1, y2);
                }

            }
        }
        if (mode == 4) {
            x2 = me.getX();
            y2 = me.getY();
            Shape so = s.get(s.size() - 1);
            if (so instanceof Square) {
                Square sq = (Square) so;
                if (x2 < ((Square) so).getX1()) {
                    ((Square) so).setX1(x2);
                    ((Square) so).setLength(x2, x1);
                } else {
                    sq.setLength(x1, x2);
                }
                if (y2 < y1) {
                    ((Square) so).setY1(y2);

                }

            }
        }
        if (mode == 5) {
            x2 = me.getX();
            y2 = me.getY();
            Shape so = s.get(s.size() - 1);
            if (so instanceof Triangle) {
                ((Triangle) so).setX2(x2);
                ((Triangle) so).setY2(y2);
                ((Triangle) so).setX3(Math.abs(x1 - (x2 - x1)));
                ((Triangle) so).setY3(Math.abs(y2));
                //int x[]={((Triangle) so).getX1(),((Triangle) so).getX2(),((Triangle) so).getX3()};
                //int y[]={((Triangle) so).getY1(),((Triangle) so).getY2(),((Triangle) so).getY3()};

            }
        }

        if (mode == 6) {
            x2 = me.getX();
            y2 = me.getY();
            if (selected != null) {
                if (selected instanceof Rectangle) {
                    Rectangle rect = (Rectangle) selected;
                    if (x2 < x1) {
                        rect.setX1(x2);
                        // rect.setLength(x1, x2);
                    }
                    if (y2 < y1) {
                        rect.setY1(y2);
                    }
                    rect.setLength(x1, x2);
                    rect.setWidth(y1, y2);

                }
                if (selected instanceof Square) {
                    Square sq = (Square) selected;
                    if (x2 < x1) {
                        sq.setX1(x2);
                        sq.setLength(x1, x2);
                    }

                    if (y2 < y1) {
                        sq.setY1(y2);
                        sq.setLength(x1, x2);
                    }
                    if (y2 < y1 && x2 < x1) {
                        if (Math.abs(x1 - x2) >= Math.abs(y1 - y2)) {
                            sq.setLength(x1, x2);
                            sq.setY1(y1 - sq.getLength());
                        } else {
                            sq.setLength(y1, y2);
                            sq.setX1(x1 - sq.getLength());
                        }

                    }
                    if (Math.abs(x1 - x2) >= Math.abs(y1 - y2)) {
                        sq.setLength(x1, x2);
                    } else {
                        sq.setLength(y1, y2);
                    }

                }

                if (selected instanceof Triangle) {
                    Triangle tri = (Triangle) selected;
                    int xtemp = tri.getX1();
                    int ytemp = tri.getY1();
                    tri.setX1(x2);
                    tri.setY1(y2);
                    tri.setX2(tri.getX2() + (xtemp - tri.getX1()));
                    tri.setY2(tri.getY2() + (ytemp - tri.getY1()));
                    tri.setX3(tri.getX3() + (xtemp - tri.getX1()));
                    tri.setY3(tri.getY3() + (ytemp - tri.getY1()));
                }

                if (selected instanceof Circle) {
                    Circle c = (Circle) selected;
                    if (x2 < x1) {
                        c.setX1(x2);
                        c.setRadius(x1, x2);
                    }

                    if (y2 < y1) {
                        c.setY1(y2);
                        c.setRadius(y2, y1);
                    }
                    if (y2 < y1 && x2 < x1) {
                        if (Math.abs(x1 - x2) >= Math.abs(y1 - y2)) {
                            c.setRadius(x1, x2);
                            c.setY1(y1 - c.getRadius());
                        } else {
                            c.setRadius(y1, y2);
                            c.setX1(x1 - c.getRadius());
                        }

                    }
                    if (Math.abs(x1 - x2) >= Math.abs(y1 - y2)) {
                        c.setRadius(x1, x2);
                    } else {
                        c.setRadius(y1, y2);
                    }

                }
                /*if(selected instanceof Triangle)
                {
                    Triangle tri=(Triangle) selected;
                        int xtemp=tri.getX1();
                        int ytemp=tri.getY1();
                        tri.setX1(x2);
                        tri.setY1(y2);
                        tri.setX2(tri.getX2()+(xtemp-tri.getX1()));
                        tri.setY2(tri.getY2()+(ytemp-tri.getY1()));
                        tri.setX3(tri.getX3()+(xtemp-tri.getX1()));
                        tri.setY3(tri.getY3()+(ytemp-tri.getY1()));
                }*/
            }
        }
        if (mode == 7) {
            x2 = me.getX();
            y2 = me.getY();
            if (selected != null) {
                if (selected instanceof Rectangle) {
                    Rectangle rect = (Rectangle) selected;

                    rect.setX1(x2);
                    rect.setY1(y2);

                }
                if (selected instanceof Square) {
                    Square sq = (Square) selected;
                    sq.setX1(x2);
                    sq.setY1(y2);
                }
                if (selected instanceof Triangle) {
                    Triangle tri = (Triangle) selected;
                    int xtemp = tri.getX1();
                    int ytemp = tri.getY1();
                    tri.setX1(x2);
                    tri.setY1(y2);
                    tri.setX2(tri.getX2() + (-xtemp + tri.getX1()));
                    tri.setY2(tri.getY2() + (-ytemp + tri.getY1()));
                    tri.setX3(tri.getX3() + (-xtemp + tri.getX1()));
                    tri.setY3(tri.getY3() + (-ytemp + tri.getY1()));
                }
                if (selected instanceof Circle) {
                    Circle c = (Circle) selected;
                    c.setX1(x2);
                    c.setY1(y2);
                }
            }
        }

        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    //iterator
    protected void paintComponent(Graphics g) {
        Shape sh;
        super.paintComponent(g);
        Iterator<Shape> it = s.iterator();
        while (it.hasNext()) {
            sh = it.next();

            if (fill == false) {
                sh.draw(g);
            } else {
                ShapeDecorator decorator = new ShapeDecorator(sh);
                decorator.draw(g);
            }
        }

    }
}
