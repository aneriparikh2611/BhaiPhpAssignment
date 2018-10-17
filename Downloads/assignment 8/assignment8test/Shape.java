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
public abstract class Shape {
    private double  x , y , radius , height , width , x1, x2 , y1, y2,midX,midY ;
     private int flag = 0;
      private int stroke;
    private Color strokeColor = Color.BLACK , fillColor = Color.WHITE;
    /**
     * 
     * @param midX 
     */
    public void setMidX(double midX) {
        this.midX = midX;
    }
    /**
     * 
     * @param midY 
     */
    public void setMidY(double midY) {
        this.midY = midY;
    }
    
   
    /**
     * 
     * @param flag 
     */
    public Shape(int flag){
    
    this.flag = flag;
    }
    /**
     * 
     * @return x1
     */
    public double getX1() {
        return x1;
    }
    /**
     * 
     * @param x1 
     */
    public void setX1(double x1) {
        this.x1 = x1;
    }
    /**
     * 
     * @return flag
     */
    public int getflag() {
        return flag;
    }
    /**
     * 
     * @param flag 
     */
    public void setA(int flag) {
        this.flag = flag;
    }
    /**
     * 
     * @return x2
     */
    public double getX2() {
        return x2;
    }
    /**
     * 
     * @param x2 
     */
    public void setX2(double x2) {
        this.x2 = x2;
    }
    /**
     * 
     * @return y1
     */
    public double getY1() {
        return y1;
    }
    /**
     * 
     * @param y1 
     */
    public void setY1(double y1) {
        this.y1 = y1;
    }
    /**
     * 
     * @return y2
     */
    public double getY2() {
        return y2;
    }
    /**
     * 
     * @param y2 
     */
    public void setY2(double y2) {
        this.y2 = y2;
    }
   
    /**
     * 
     * @return strokeColor
     */
    public Color getStrockColor() {
        return strokeColor;
    }
    /**
     * 
     * @param strokeColor 
     */
    public void setStrockColor(Color strokeColor) {
        this.strokeColor = strokeColor;
    }
    /**
     * 
     * @return fillColor
     */
    public Color getFillColor() {
        return fillColor;
    }
    /**
     * 
     * @param fillColor 
     */
    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }
    /**
     * 
     * @return x
     */
    public double getX() {
        return x;
    }
    /**
     * 
     * @param x 
     */
    public void setX(double x) {
        this.x = x;
    }
    /**
     * 
     * @return y
     */
    public double getY() {
        return y;
    }
    /**
     * 
     * @param y 
     */
    public void setY(double y) {
        this.y = y;
    }
    /**
     * 
     * @return radius
     */
    public double getRedius() {
        return radius;
    }
    /**
     * 
     * @param radius 
     */
    public void setRedius(double radius) {
        this.radius = radius;
    }
    /**
     * 
     * @return height
     */
    public double getHeight() {
        return height;
    }
    /**
     * 
     * @param height 
     */
    public void setHeight(double height) {
        this.height = height;
    }
    /**
     * 
     * @return width
     */
    public double getWidth() {
        return width;
    }
    /**
     * 
     * @param width 
     */
    public void setWidth(double width) {
        this.width = width;
    }
    /**
     * 
     * @return stroke
     */
    public int getStrockWidth() {
        return stroke;
    }
    /**
     * 
     * @param stroke 
     */
    public void setStrockWidth(int stroke) {
        this.stroke = stroke;
    }
    /**
     * 
     * @return midX
     */
    public double getMidX() {
        return midX;
    }
    /**
     * 
     * @return midY
     */
    public double getMidY() {
        return midY;
    }
    
    public abstract void setValues( double x1,double y1,double x2,double y2 , int Strock ,GraphicsContext gc, Color strokeColor , Color fillColor );
    public abstract void draw( GraphicsContext gc );
    
}

