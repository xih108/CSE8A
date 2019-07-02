/*
 Xinyi He (cs8aware) 
 */

/*--------PROGRAM DESCRIPTION----------
*Picture.java file contains following methods：
*It uses the method complement to get the complement of the picture.
*It uses the method grayscale to convert the colorful picture to a gray one.
*It uses the method swap to swap colors every third index
 */



import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List;//resolves problem with java.awt.List and java.util.List
import java.util.Random;

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * Copyright Georgia Institute of Technology 2004-2005
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param width the width of the desired picture
   * @param height the height of the desired picture
   */
  public Picture(int width, int height)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   **/
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  
 public void complement()
   {
     Pixel pixel=null;
     Pixel[] pixelArray=this.getPixels();
     int i = 0;//i means the index
     while(i < pixelArray.length)//the loop starts from the start to the end
     {
       pixel=pixelArray[i];
       int red=pixel.getRed();//get the red,green,blue component
       int green=pixel.getGreen();
       int blue=pixel.getBlue();
       //create the complement of each pixel
       pixel.setColor(new Color(255-red,255-green,255-blue));
       i++;
     }
   }
  
    public void grayscale()
   {
     Pixel pixel=null;
     Pixel[] pixelArray=this.getPixels();
     int i=0;//i means the index
     while(i < pixelArray.length)//the loop starts from the start to the end
     {
       pixel=pixelArray[i];
       //compute the same value of components
       int value=(pixel.getRed()+pixel.getGreen()+pixel.getBlue())/3;
       //set pixel the new color
       pixel.setColor(new Color(value,value,value));
       i++;
     }    
   }
   
    public void swap()
   {
     Pixel[] pixelArray=this.getPixels();
     Pixel pixel=null;
     int i = 0;//i means the index
     while(i < pixelArray.length)//the loop starts from the start to the end
     {
       pixel=pixelArray[i];
       int red=pixel.getRed();//get the red,green,blue component
       int green=pixel.getGreen();
       int blue=pixel.getBlue();
       //swap the red,green and blue components
       pixel.setColor(new Color(green,blue,red));
       i+=3;
     }   
   }
   
  
} // this } is the end of class Picture, put all new methods before this
 
