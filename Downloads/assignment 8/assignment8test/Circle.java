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
public class Circle extends Shape{
    /**
     *  x holds the x coordinate of circle
     *  y holds the y coordinate of circle
     *  radius holds the value of radius of circle
     */    
    private double x,y,radius;
    /**
     * 
     * @param flag 
     */
    public Circle(int flag) {
        super(flag);
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
    public void setValues( double x1,double y1,double x2,double y2 , int lineWidth ,GraphicsContext gc , Color strokeColor , Color fillColor  ){
        setStrockWidth( lineWidth );
        setX1(x1);
        setX2(x2);
        setY1(y1);
        setY2(y2);
        setFillColor(fillColor);
        setStrockColor(strokeColor);
        //begin x and y coordinate of circle
        x = getX1() + (getX2() - getX1()) / 2;
        y = getY1() + (getY2() - getY1()) / 2;
        // middle point of circle
        setMidX((getX2() - getX1()) / 2);
       setMidY((getY2() - getY1()) / 2);
        radius = Math.sqrt(((getX2() - getX1()) * (getX2() - getX1())) + ((getY2() - getY1()) * (getY2() - getY1())));
        setRedius(radius / 2);
        setX(x);
        setY(y);
        draw(gc);
        
        
    }

    /**
     * 
     * @param gc 
     */
    public void draw( GraphicsContext gc ){
    gc.setLineWidth( getStrockWidth() );
    gc.setStroke( getStrockColor() );
    gc.setFill( getFillColor() );
    gc.strokeOval(getX() - getRedius() , getY() - getRedius(), getRedius() *2, getRedius() *2 );;
    gc.fillOval(getX() - getRedius() , getY() - getRedius() , getRedius() * 2, getRedius() * 2 );
    
    }
    

    
}

