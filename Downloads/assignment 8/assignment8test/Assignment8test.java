/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment8test;

/**
 *
 * @author Nehali Shah # 000770110
 * @author Aneri Parikh # 000770402
 */

/**
 * USER CAN DRAW THREE SHAPES : CIRCLE, RECTANGLE, LINE
 * USER CAN DRAW SHAPES VIA LEFT CLICK
 * USER CAN SELECT OBJECT VIA RIGHT CLICK
 * I tried a lot but can not select line shape. But I can select circle and rectangle successfully.
 * 
 * EXCEPTION:
 * 
 * IF YOU TRY TO DRAW WITHOUT SETTING STROKE WIDTH
 * IF YOU START DRAWING WITH RIGHT CLICK
 * IF YOU PRESS CLEAR AFTER SCNREEN IS CLEAR
 * IF YOU PRESS UNDO AFTER THERE IS NO SHAPE ON SCREEN
 */
import java.util.ArrayList;
import javafx.scene.control.TextField;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Assignment8test extends Application {
    /** 
     * declare variables 
     */
    int flag = 0; 
    boolean primaryKey = false;
    Shape shape, selectShape ;
    GraphicsContext gc;
    Canvas c;
    ArrayList<Shape> shapeList = new ArrayList<Shape>();
    ColorPicker colorPickerOne = null, colorPickerTwo = null;
    private double x1, x2, y1, y2, selectX, selectY2, selectX2, selectY;//cordinates
    TextField lineWidth;
    Label lable;
    Button buttonOfCircle, buttonOfRectangle, buttonOfLine, buttonOfClear, buttonOfUndo, buttonOfDelete;

    // TODO: Instance Variables for View Components and Model
    // TODO: Private Event Handlers and Helper Methods
    /**
     * 
     * @param me pressHandler  
     */
    private void PressHandler(MouseEvent me) {

        try {

            int a = Integer.parseInt(lineWidth.getText());// get line width
            // get cordinates of press event
            x1 = me.getX();
            y1 = me.getY();
            // chack if press done by right click or left click
            
            if (me.isPrimaryButtonDown()) {
                primaryKey = true;
                // call appropriate class using polymorphism
                switch (flag) {
                    case 1:
                        shape = new Circle(flag);
                        break;
                    case 2:
                        shape = new Rectangle(flag);
                        break;
                    default:
                        shape = new Line(flag);
                        break;
                } 
            }
            else if(shapeList.isEmpty()){
                new Alert(Alert.AlertType.WARNING, "Please draw object with left click").showAndWait();
            }
           
            
                     
                    
        } catch (NumberFormatException e) {
            // handle exception and print error
            new Alert(Alert.AlertType.WARNING, "Please give the value of stroke").showAndWait();

        }

    }
    /**
     * 
     * @param me release handler 
     */
    private void ReleseHandler(MouseEvent me) {
        // check that press and release cordinates are same or not
        
        
        
        
        if (x1 != me.getX()) {
            if (primaryKey) {
                // add shape object to list
                shapeList.add(shape);
            }
        }
        if (shapeList.size() >= 2) {
            // delete objects with same reference type in list 
            if (shapeList.get(shapeList.size() - 1).equals(shapeList.get(shapeList.size() - 2))) {
                shapeList.remove(shapeList.size() - 1);

            }
            
        }
    
    }
    /**
     * 
     * @param me dragged handle to draw shape live 
     */
    private void DraggedHandler(MouseEvent me) {

        try {
            // get every cordinates and save
            x2 = me.getX();
            y2 = me.getY();
            // check which button is pressed
            if (me.isPrimaryButtonDown()) {
                // draw shape
                shape.setValues(x1, y1, x2, y2, Integer.parseInt(lineWidth.getText()), gc, colorPickerOne.getValue(), colorPickerTwo.getValue());
                // clear screen
                gc.setFill(Color.ANTIQUEWHITE);
                gc.fillRect(0, 0, 1000, 500);
                // redraw screen
                for (Shape temp : shapeList) {
                    temp.setValues(temp.getX1(), temp.getY1(), temp.getX2(), temp.getY2(), temp.getStrockWidth(), gc, temp.getStrockColor(), temp.getFillColor());
                }
                // draw last shape object
                shape.setValues(x1, y1, x2, y2, Integer.parseInt(lineWidth.getText()), gc, colorPickerOne.getValue(), colorPickerTwo.getValue());

            }
           
                

          
        } catch (NumberFormatException e) {

        }

    }
    /**
     * 
     * @param me circle button handler set flag 
     */
    private void CircleHandler(MouseEvent me) {
        flag = 1;
       

    }
    /**
     * 
     * @param me rectangle button handler set flag
     */
    private void RectanglerHandler(MouseEvent me) {
        flag = 2;
        

    }
    /**
     * 
     * @param me line button handler set flag
     */
    private void LineHandler(MouseEvent me) {
        flag = 3;
        

    }
    /**
     * 
     * @param me clearHandler clear screen
     */
    private void ClearHandler(MouseEvent me) {
        if(shapeList.isEmpty()== false){
        gc.setFill(Color.ANTIQUEWHITE);
        gc.fillRect(0, 0, 1000, 500);
        shapeList.removeAll(shapeList);
        }else{
            new Alert(Alert.AlertType.WARNING, "Screen is clear already.").showAndWait();
        }
    }
        
    /**
     * 
     * @param me undo handler undo the object one by one
     */
    private void UndoHandler(MouseEvent me) {
        try {
            // remove last object in shapeList
            shapeList.remove(shapeList.size() - 1);
            // clear screen
            gc.setFill(Color.ANTIQUEWHITE);
            gc.fillRect(0, 0, 1000, 500);
            // re-draw all objects from list
            for (Shape temp : shapeList) {
                temp.setValues(temp.getX1(), temp.getY1(), temp.getX2(), temp.getY2(), temp.getStrockWidth(), gc, temp.getStrockColor(), temp.getFillColor());
            }
            

        } catch (ArrayIndexOutOfBoundsException e) {
            // exception handle and print msg in dialogbox
            new Alert(Alert.AlertType.WARNING, "Screen is clear, there are no more shapes.").showAndWait();
        }
    }
    /**
     * 
     * @param me selectHandler select object on right click
     */
    private void selectHandler(MouseEvent me) {
        // check if user press right click then it select the shape
        if (me.isPrimaryButtonDown() == false) {
            // selectShape is a object of Shape class
            selectShape = null;
           
            // parameters when rightclick pressed
            selectX = me.getX();
            selectY = me.getY();
            
            // check if selected point is in the shape 
            for (Shape temp : shapeList) {
                if (((selectX < temp.getX2() && selectX > temp.getX1()) || (selectX < temp.getX1() && selectX > temp.getX2())) && ((selectY < temp.getY2() && selectY > temp.getY1()) || (selectY < temp.getY1() && selectY > temp.getY2()) ) || (Math.sqrt(((temp.getMidX()- me.getX()) * (temp.getMidX()- me.getX())) + ((temp.getMidY()- me.getY()) * (temp.getMidY()- me.getY())))<temp.getRedius() )) {
                    
                        selectShape = temp;
                       
                    
                }
                
            }

            
            for (Shape temp : shapeList) {
                temp.setValues(temp.getX1(), temp.getY1(), temp.getX2(), temp.getY2(), temp.getStrockWidth(), gc, temp.getStrockColor(), temp.getFillColor());
            }
            
            // if selectShape is not empty then it draws border around selected shape
            if (selectShape != null) {
                
                gc.setStroke(Color.BLACK);
                
                if(selectShape instanceof Rectangle){
                if (selectShape.getX2() < selectShape.getX1()) {
                    selectShape.setX(selectShape.getX2());
                } else {
                    selectShape.setX(selectShape.getX1());
                }
                if (selectShape.getY2() < selectShape.getY1()) {
                    selectShape.setY(selectShape.getY2());
                } else {
                    selectShape.setY(selectShape.getY1());
                }
                gc.strokeRect(selectShape.getX(), selectShape.getY(), selectShape.getWidth(), selectShape.getHeight());

            }
                else if(selectShape instanceof Circle){
                    gc.strokeOval(selectShape.getX() - selectShape.getRedius() , selectShape.getY() - selectShape.getRedius(), selectShape.getRedius() *2, selectShape.getRedius() *2 );;
                    
                }
                
            }
                    
               
        }
                
    }
    /**
     * 
     * @param me delete handle delete selected object
     */
    private void deleteHandler(MouseEvent me) {
        
        shapeList.remove(selectShape);
        gc.setFill(Color.ANTIQUEWHITE);
        gc.fillRect(0, 0, 1000, 500);
        for (Shape temp : shapeList) {
            temp.setValues(temp.getX1(), temp.getY1(), temp.getX2(), temp.getY2(), temp.getStrockWidth(), gc, temp.getStrockColor(), temp.getFillColor());
        }

    }

    /**
     * This is where you create your components and the model and add event
     * handlers.
     *
     * @param stage The main stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();

        Scene scene = new Scene(root, 1000, 650);
        // Set canvas Size in Pixels
        stage.setTitle("Assignmet8"); // Set window title

        stage.setScene(scene);

        // TODO: Add your GUI-building code here
        // 1. Create the model
        colorPickerOne = new ColorPicker(Color.BLACK);
        colorPickerTwo = new ColorPicker(Color.WHITE);
        lineWidth = new TextField();
        lable = new Label("Stroke of shape");
        buttonOfCircle = new Button("Circle");
        buttonOfRectangle = new Button("Rectangle");
        buttonOfLine = new Button("Line");
        buttonOfClear = new Button("Clear");
        buttonOfUndo = new Button("Undo");
        buttonOfDelete = new Button("Delete");
        // 2. Create the GUI components
        c = new Canvas(1000, 500);
        gc = c.getGraphicsContext2D();
        // 3. Add components to the root
        root.getChildren().addAll(c, lineWidth,lable, buttonOfCircle, buttonOfDelete, buttonOfRectangle, buttonOfClear, buttonOfUndo, buttonOfLine, colorPickerOne, colorPickerTwo);

        // 4. Configure the components (colors, fonts, size, location)
        gc.setFill(Color.ANTIQUEWHITE);
        gc.fillRect(0, 0, 1000, 500);
        gc.setFill(Color.BLACK);
        gc.fillRect(300, 500, 2, 200);
        buttonOfCircle.relocate(20, 530);
        buttonOfCircle.setPrefWidth(100);
        buttonOfCircle.setPrefHeight(50);

        buttonOfRectangle.relocate(140, 530);
        buttonOfRectangle.setPrefWidth(100);
        buttonOfRectangle.setPrefHeight(50);

        buttonOfLine.relocate(260, 530);
        buttonOfLine.setPrefWidth(100);
        buttonOfLine.setPrefHeight(50);

        buttonOfClear.relocate(20, 590);
        buttonOfClear.setPrefWidth(100);
        buttonOfClear.setPrefHeight(50);

        buttonOfUndo.relocate(140, 590);
        buttonOfUndo.setPrefWidth(100);
        buttonOfUndo.setPrefHeight(50);

        buttonOfDelete.relocate(260, 590);
        buttonOfDelete.setPrefWidth(100);
        buttonOfDelete.setPrefHeight(50);
        
        lable.relocate(380, 590);
        lable.setFont(new Font(STYLESHEET_MODENA, 14));
        lable.setPrefHeight(40);
        
        lineWidth.relocate(500, 590);
        lineWidth.setPrefWidth(100);
        lineWidth.setPrefHeight(40);

        colorPickerOne.relocate(380, 530);
        colorPickerOne.setPrefWidth(100);
        colorPickerOne.setPrefHeight(50);

        colorPickerTwo.relocate(500, 530);
        colorPickerTwo.setPrefWidth(100);
        colorPickerTwo.setPrefHeight(50);

        // 5. Add Event Handlers and do final setup
        c.addEventHandler(MouseEvent.MOUSE_PRESSED, this::PressHandler);
        c.addEventHandler(MouseEvent.MOUSE_RELEASED, this::ReleseHandler);
        c.addEventHandler(MouseEvent.MOUSE_DRAGGED, this::DraggedHandler);
        c.addEventHandler(MouseEvent.MOUSE_PRESSED, this::selectHandler);
        buttonOfCircle.addEventHandler(MouseEvent.MOUSE_PRESSED, this::CircleHandler);
        buttonOfRectangle.addEventHandler(MouseEvent.MOUSE_PRESSED, this::RectanglerHandler);
        buttonOfLine.addEventHandler(MouseEvent.MOUSE_PRESSED, this::LineHandler);
        buttonOfClear.addEventHandler(MouseEvent.MOUSE_PRESSED, this::ClearHandler);
        buttonOfUndo.addEventHandler(MouseEvent.MOUSE_PRESSED, this::UndoHandler);
        buttonOfDelete.addEventHandler(MouseEvent.MOUSE_PRESSED, this::deleteHandler);
        // 6. Show the stage

        stage.show();
    }

    /**
     * Make no changes here.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }
}
