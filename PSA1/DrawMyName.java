/* File Name: DrawMyName.java
 * Created by:  Xinyi He--cs8aware--A13561164
 * Due Date:    Jan 17th, 2017
 */

import java.awt.Color;

public class DrawMyName//filename
{
  public static void main(String[] args)
  {
   World world1=new World(550,420); //create a 640 by 480 world named world1
   
   Turtle t=new Turtle(0,0,world1);
   t.setPenWidth(1000);
   t.setPenColor(Color.black);
   t.moveTo(640,480);
   //set the world black
   
   Turtle turtle1=new Turtle(150,180,world1);//create turtle1 in world1 at(150,180)
   turtle1.setPenWidth(4);//set the width of the trail to be 4
   turtle1.setPenColor(Color.pink);//set the color of the trail to be pink
   turtle1.turn(155);//turn turtle1 to right 155 degrees 
   turtle1.forward(69);//make turtle1 go forward 69 steps 
   turtle1.penUp();//stop showing the trail
   turtle1.moveTo(150,242);//move turtle1 to (150,242)
   turtle1.penDown();//start showing the trail
   turtle1.turn(50);
   turtle1.forward(-69);//make turtle1 go backward 69 steps
   turtle1.hide();//hide turtle1
   //Draw'X'
   
   Turtle turtle2=new Turtle(185,180,world1);//create turtle2 in world1 at(185,180)
   turtle2.setPenWidth(4);
   turtle2.setPenColor(Color.orange);
   turtle2.turnRight();//make turtle2 turn right
   turtle2.forward(20);
   turtle2.penUp();
   turtle2.moveTo(185,240);
   turtle2.penDown();
   turtle2.forward(20);
   turtle2.moveTo(195,240);
   turtle2.turnLeft();//make turtle2 turn left
   turtle2.forward(60);
   turtle2.hide();
   //Draw'I'
   
   Turtle turtle3=new Turtle(215,240,world1);//create turtle3 in world1 at(215,240)
   turtle3.setPenColor(Color.magenta);
   turtle3.setPenWidth(4);
   turtle3.forward(60);
   turtle3.turnRight();
   turtle3.turn(65);
   turtle3.forward(69);
   turtle3.turn(-155);//turn turtle3 to left 155 degrees
   turtle3.forward(62);
   turtle3.hide();
   //Draw'N'
 
   Turtle turtle4=new Turtle(300,180,world1);//create turtle4 in world1 at(300,180)
   turtle4.setPenWidth(4);
   turtle4.setPenColor(Color.green);
   turtle4.turn(155);
   turtle4.forward(34);
   turtle4.turn(-130);//turn turtle4 to left 130 degrees
   turtle4.forward(34);
   turtle4.penUp();
   turtle4.moveTo(314,210);
   turtle4.turn(155);
   turtle4.penDown();
   turtle4.forward(30);
   turtle4.hide();
   //Draw'Y'
   
   Turtle turtle5=new Turtle(335,180,world1);//create turtle5 in world1 at(335,180)
   turtle5.setPenWidth(4);
   turtle5.setPenColor(Color.yellow);
   turtle5.turnRight();
   turtle5.forward(20);
   turtle5.penUp();
   turtle5.moveTo(335,240);
   turtle5.penDown();
   turtle5.forward(20);
   turtle5.moveTo(345,240);
   turtle5.turnLeft();
   turtle5.forward(60);
   turtle5.hide();
   //Draw'I'
   
   Turtle turtle6=new Turtle(100,210,world1);
   turtle6.setColor(new Color(255,255,255));//create a white turtle
   
   Turtle turtle7=new Turtle(405,210,world1);
   turtle7.setColor(Color.white);
  }}