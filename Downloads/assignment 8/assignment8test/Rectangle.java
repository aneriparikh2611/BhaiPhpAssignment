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
public class Rectangle extends Shape{
    /**
     * 
     * @param a 
     */
    public Rectangle(int a) {
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
    public void setValues( double x1,double y1,double x2,double y2, int lineWidth  ,GraphicsContext gc , Color strokeColor , Color fillColor ){
        setStrockWidth( lineWidth );
        
        setX1(x1);
        setX2(x2);
        setY1(y1);
        setY2(y2);
        setFillColor(fillColor);
        setStrockColor(strokeColor);
        // this logic stands for handle from where user starts to draw rectangle. like up and down or cross.
       if( getX2() < getX1() ){
           setX( getX2() );
       }
       else{
           setX( getX1() );
       }
       if( getY2() < getY1() ){
           setY( getY2() );
       }
       else{
           setY( getY1() );
       }
       
        setHeight( Math.abs( getY2() - getY1() ) );
        setWidth(  Math.abs( getX2() - getX1() )  );
        draw( gc );
        
    }
    /**
     * 
     * @param gc 
     */
    public void draw( GraphicsContext gc ){
    gc.setLineWidth( getStrockWidth() );
    gc.setStroke( getStrockColor() );
    gc.setFill( getFillColor() );
    gc.strokeRect(getX(), getY() , getWidth() , getHeight() );;
    gc.fillRect(getX(), getY() , getWidth() , getHeight() );
    
    }
    public boolean check(double selectX,double selectY){
        return false;
    }
}

