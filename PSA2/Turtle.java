/*Filename: RandomTurtleTester.java 
 * Created by: Xinyi He(cs8aware)  and  Kaixun Zhang(cs8awatp)
 * Date: Jan.22.2017
 * 
 * Program Description:
 * Generally, this program analyses the movement of a turtle by making it going left or right. 
 * It uses the method takeStep to stimulate a turtle's movement to left or right.
 * It uses the method rwPosition to calculate and print out its final displacement after going n Steps.
 * It uses the method countSteps to calculate and print out how many steps it will take to reach the maximum displacement.
 * And uses the method rwPositionPlain to test how the probability of going left and the number of steps affect the turtle's average displacement and average squared displacement.
 * 
 */ 
import java.util.*;
import java.awt.*;

/**
 * Class that represents a turtle which is similar to a Logo turtle.
 * This class inherts from SimpleTurtle and is for students
 * to add methods to.
 * <p>
 * Copyright Georgia Institute of Technology 2004
 *
 * @author Barb Ericson ericson@cc.gatech.edu
 *         <p>
 *         <p>
 *         Filename: Turtle.java
 *         Created by: Shuaiqi Xia, cs8a1 and Tony Xia, cs8a2
 *         Date:
 */

public class Turtle extends SimpleTurtle {
    ////////////////// constructors ///////////////////////

    /**
     * Constructor that takes the x and y and a picture to
     * draw on
     *
     * @param x       the starting x position
     * @param y       the starting y position
     * @param picture the picture to draw on
     */
    public Turtle(int x, int y, Picture picture) {
        // let the parent constructor handle it
        super(x, y, picture);
    }

    /**
     * Constructor that takes the x and y and a model
     * display to draw it on
     *
     * @param x              the starting x position
     * @param y              the starting y position
     * @param modelDisplayer the thing that displays the model
     */
    public Turtle(int x, int y,
                  ModelDisplay modelDisplayer) {
        // let the parent constructor handle it
        super(x, y, modelDisplayer);
    }

    /**
     * Constructor that takes the model display
     *
     * @param modelDisplay the thing that displays the model
     */
    public Turtle(ModelDisplay modelDisplay) {
        // let the parent constructor handle it
        super(modelDisplay);
    }

    /**
     * Constructor that takes a picture to draw on
     *
     * @param p the picture to draw on
     */
    public Turtle(Picture p) {
        // let the parent constructor handle it
        super(p);
    }

    /////////////////// methods ///////////////////////

    /**
     * Return whether or not the turtle should take a step to the left (-1)
     * or the right (+1)
     * Input: probabilityToLeft, the probability the tutle moving left. Should between 0-1.
     * Returns: -1 to represent a step to the left, 1 to represent a
     * step to the right.
     */
    public int getRandomStep(double probabilityToLeft) {
        Random numGenerator = new Random();
        // Choose either 0 or 1 (note that next int is NON inclusive 
        // of its argument).
        double choice = numGenerator.nextDouble();
        if (choice < probabilityToLeft) {
          return -1;
        } else {
          return 1;
        }
    }

    public static void main(String[] args) {
        World earth = new World();
        Turtle t1 = new Turtle(earth);
    }
    
    
    
     /** Display a random step of the turtle.  
    * inputs:
    *     direction: -1 for step to the left or 1 for step to the right
    * output: 
    *     Nothing.  Moves the calling turtle object.
    * */
    
   
    /* Part 1:method takeStep use the value of direction 
    * to make the turtle turn 45 degrees, walk forward 30 steps and then face up again.
    */
    public void takeStep( int direction )
    {
     this.turn(direction*45);//turn 45 degrees to right or left(decided by the value of direction)
     this.forward(30);//go forward 30 steps
     this.turn(-direction*45);//make the object face up again
    }

      
   
   /* Part 2:method rwPosition calculates and returns the displacement of the turtle after taking n steps.
    */
    public int rwPosition( int nSteps ) //get the value of nSteps
    { 
      int y=0;
      for (int i=0;i<nSteps;i++) //for loop
      {
       int x=this.getRandomStep(0.5);//x is the value returned by method getRandomStep
       this.takeStep(x);//the object use the value of x as its direction
       y=y+x;           //y is the displacement 
      }          
       return y;
    }
    
    
    /* Part 3:method counterSteps calculates and returns how many steps a turtle will take to reach the maxDisplacement.
    */
    public int countSteps(int maxDisplacement) //get the value of maxDisplacement
    { 
      int i=0;
      int z=0;
      int y=0;
      
        while(i<maxDisplacement) //when i(absolute value of displacement) is smaller than maxDisplacement,the loop run
        {
          int x=this.getRandomStep(0.5);//x is the value returned by method getRandomStep
          this.takeStep(x); //the object use the value of x as its direction
          y=y+x;            //y is the displacement 
          i=Math.abs(y);    //i is the absolute value of displacement
          z++;              //z is the number of steps the turtle take
         }                 
        
       return z; 
    }
    
    
    
    /* Part 4:method rwPositionPlain calculates and returns the displacement of the turtle after taking n steps 
     * without making the turtle move
     */
    public int rwPositionPlain(int nSteps,double prob) //get the value of nSteps,prob
    { 
      int y=0;
      for (int i=0;i<nSteps;i++)  //for loop
      {
        int x=this.getRandomStep(prob); //x is the value returned by method getRandomStep
       y=y+x;      //y is the displacement 
      }                   
       return y;   
    }

} // this } is the end of class Turtle, put all new methods before this
