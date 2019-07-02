/* Filename: RandomTurtleTester.java 
* Created by: Xinyi He(cs8aware)  and  Kaixun Zhang(cs8awatp)
* Date: Jan.22.2017
*/ 
public class RandomTurtleTester {
    //The line below is magic, you don't have to understand it (yet)
    public static void main (String[] args) { 

     //Part 1
     World w1=new World();//create a new world 
     Turtle t1=new Turtle(320,480,w1);//create a new turtle at the bottom of the world
     t1.takeStep(-1);// -1 means turn a certain degree to left
     t1.takeStep(1); // 1 means turn a certain degree to right
     
     
     //Part 2 
     World w2=new World();
     Turtle t2=new Turtle(320,480,w2);
     System.out.println("Final signed displacemen "+ t2.rwPosition(7)); 
     //print out the return value of method rwPosition
      
     
     //Part 3 
     World w3=new World();
     Turtle t3=new Turtle(320,480,w3);
     System.out.println("Maximum unsigned displacement "+t3.countSteps(5));
     //print out the return value of method countSteps
     
    } 
}

