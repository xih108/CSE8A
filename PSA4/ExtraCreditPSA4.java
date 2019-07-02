/* Filename: ExtraCreditPSA4.java 
* Created by: Xinyi He (cs8aware)
* Date: Feb 5th 2017
*/ 

import java.util.Random;
public class ExtraCreditPSA4{
  public static void main(String [] args)
  {
    for(int i = 0 , j = 300; i < 3; i++, j+=300)//use a for loop to the same thing three times
    {
      Picture p = new Picture(FileChooser.pickAFile());// select a picture
      Picture canvas = new Picture(j,j);// create a canvas with width j and height j
      canvas.scramble(p);// call the method scramble 
      canvas.explore();// show the canvas   
    }
  }  
}