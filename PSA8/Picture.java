/*
 Xinyi He (cs8aware) and Yifan Wu (cs8awaqb)
*/

/*--------PROGRAM DESCRIPTION----------
*Picture.java file contains following methods：
*It uses the method flipHorizontal to flip a picture horizontally.
*It uses the method flipVertical to flip a picture horizontally (upside down).
*/

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List;// resolves problem with java.awt.List and java.util.List
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
  
  //Part A
  /**
   * Horizontal flip method
   * Input: nothing
   * Returns: nothing
   * This method flips the picture in the horizontal direction
   * (mirrored right to left)
   */
  public void flipHorizontal()
  {
    Color tempColor;
   
    // the limit1 is the midpoint of width
    int limit2 = this.getHeight();
    int limit1 = this.getWidth()/2;
    int width = this.getWidth();
    
    for(int i = 0; i < limit1; i++)
    {
      for(int j = 0; j < limit2; j++)
      {
        // exchange the rightPixel and the leftPixel color
        Pixel leftPixel = this.getPixel(i,j);
        Pixel rightPixel = this.getPixel(width-i-1,j);
        tempColor = leftPixel.getColor();
        leftPixel.setColor(rightPixel.getColor());
        rightPixel.setColor(tempColor);
      }
    } 
  }
  
  

  /**
   * Vertical flip method
   * Input: nothing
   * Returns: nothing
   * This method flips the picture in the vertical direction (upside down)
   **/
  public void flipVertical()
  {
    Color tempColor;
  
    int limit1 = this.getWidth();
    //limit2 is the midpoint of height
    int limit2 = this.getHeight()/2;
    int height = this.getHeight();
    
    for(int i = 0; i < limit1; i++)
    {
      for(int j = 0; j < limit2; j++)
      {
        // exchange the upPixel and the downPixel color
        Pixel upPixel = this.getPixel(i,j);
        Pixel downPixel = this.getPixel(i,height-j-1);
        tempColor = upPixel.getColor();
        upPixel.setColor(downPixel.getColor());
        downPixel.setColor(tempColor);
      }
    }
  }
  
} // this } is the end of class Picture, put all new methods before this
 
