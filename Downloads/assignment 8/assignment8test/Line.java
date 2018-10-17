/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment8test;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author Nehali Shah # 000770110
 * @author Aneri Parikh # 000770402
 */
public class Line extends Shape{
    /**
     * 
     * @param a 
     */
    public Line(int a) {
        super(a);
    }
    /**
     * 
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param lineWidth
     * @param gc
     * @param strokeColor
     * @param fillColor 
     */
    @Override
    public void setValues(double x1, double y1, double x2, double y2, int lineWidth, GraphicsContext gc  , Color strokeColor , Color fillColor) {
      
        setStrockColor(strokeColor);
        setX1(x1);
        setX2(x2);
        setY1(y1);
        setY2(y2);
       setFillColor(fillColor);
       setStrockWidth( lineWidth );
        draw(gc);
        
        
        
        
        
    }
    /**
     * 
     * @param gc 
     */
     public void draw(GraphicsContext gc){
      gc.setLineWidth(getStrockWidth());
        gc.setStroke(getStrockColor());
        gc.setFill(getStrockColor());
        gc.strokeLine(getX1(),getY1(),getX2(),getY2());
  }
   
    public boolean check(double selectX,double selectY){
        return false;
    }
}

