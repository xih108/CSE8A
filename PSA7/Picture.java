/*
 Xinyi He (cs8aware) and Junyi Guo (cs8awakw)
 */

/*--------PROGRAM DESCRIPTION----------
*This program uses the method flipHorizontalSquare to 
*flip a square in the horizontal orientation within the boundary.
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
 

  
  /* The flipHorizontalSquare method
   * This method will flip a square of the given size 
   * in the horizontal orientation within the boundary.  
   * Input: x, y (bottom left corner of the square)
   *        size
   * Returns: p (a picture with part of it flipped)
   */
  public Picture flipHorizontalSquare(int x, int y, int size)
  {
    //create a copy of the calling object
    Picture p = new Picture(this);
    Color tempColor;
    
    //calculate the up left corner(x1,y1) of the flipping area
    //and the bottom right corner(x2,y2) of the flipping area
    int x1 = x;
    int x2 = x+size-1;
    int y1 = y-size+1;
    int y2 = y;
    if (x1 < 0)
    {
      x1 = 0;
    }
    
    if (x2 > this.getWidth()-1)
    {
      x2 = this.getWidth()-1;
    }
    
    if (y1 < 0)
    {
      y1 = 0;
    }
    
    if (y2 > this.getHeight()-1)
    {
      y2 = this.getHeight()-1;
    }
 
    //for loop:i starts from x1 and ends at midpoint of x1,x2(left to right)
    for(int i = x1; i <= 0.5*(x1+x2); i++)
    {
      //for loop:j starts from y1 and ends at y2(up to down)
      for(int j = y1; j <= y2; j++)
      {
        //i and i1 are symmetric about (x1+x2)/2
        int i1 = x1+x2-i; 
        Pixel leftPixel = p.getPixel(i,j);
        Pixel rightPixel = p.getPixel(i1,j);
        //exchange the color of leftPixel and rightPixel
        tempColor = leftPixel.getColor();
        leftPixel.setColor(rightPixel.getColor());
        rightPixel.setColor(tempColor);
        }
      }
    return p;
  }
  
  
  
  
} // this } is the end of class Picture, put all new methods before this
 
