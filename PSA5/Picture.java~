/* Filename: Picture.java 
* Created by:  Xinyi He (cs8aware) and Yiwen Li (cs8awals)
* Date: 2.10
*/

/*----------- Program Description: ------------
 * This program aims to change the background of a picture as well as a particular part of the picture.
 * It uses method chromakeyBackgroundChange to change the background of the picture.
 * It uses method chromakeyShirtChange to change the color of the shirt area.
 * PSA5.java is used to test the two methods:chromakeyBackgroundChange,chromakeyShirtChange. 
 */

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; 
import java.util.Arrays;// resolves problem with java.awt.List and java.util.List

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
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output; 
  }
  
  
  
  
  
  /**
   * Method name:chromakeyBackgroundChange
   * method changes the background of the picture
   * Input: background(a picture that you want to use as the background)
   *        replaceColor(a color of the original picture that should be replaced)
   * Returns: copy1(a modified picture after changing the background)
   */
  public Picture chromakeyBackgroundChange(Picture background, Color replaceColor)
  {
     Picture copy1 = this;
     Pixel[] sourcePixel = copy1.getPixels();
     //the loop goes through all the pixels of the picture
     for (int i = 0; i < sourcePixel.length; i++)
     {
       //sourceColor stores the color of each pixel of the original picture
       Color sourceColor=sourcePixel[i].getColor();
       
       //if the sourceColor is close to the color which needs to be replaced,
       //then replace it with the color of the backgound
       if (sourcePixel[i].colorDistance(replaceColor) < 100.0)
       {
         Pixel pixel = sourcePixel[i];
         Pixel bPixel = background.getPixel(pixel.getX(),pixel.getY());
         pixel.setColor(bPixel.getColor());
       }
     }
     //return the picture after modifying its background
     return copy1; 
  }
  
  
  
  
  /**
   * Method name:chromakeyShirtChange
   * method changes the color of the shirt area
   * Input: shirt(a picture that you want to show it at the shirt area)
   *        original(the original picture)  
   *        oldShirtColor(a color that your shirt displaces)
   *        startX(the start x coodinate)
   *        startY(the start y coodinate)
   *        width(the width of the shirt area)
   *        height(the height of the shirt area)
   * Returns: copy2(a modified picture after changing the shirt area)
   */
   public Picture chromakeyShirtChange(Picture shirt, Picture original, 
                                       Color oldShirtColor, int startX, 
                                       int startY, int width, int height)
  {
     Picture copy2 = this;
     //the loop starts at the startX, ends at startX+width
     for (int x = startX, tX = 0; x < startX+width; x++, tX++)
     {
       //the loop starts at the startY, ends at startY+height
       for (int y = startY, tY = 0; y < startY+height; y++, tY++)
       {
         Pixel sourcePixel = original.getPixel(x,y);
         Pixel shirtPixel = shirt.getPixel(tX,tY);
         Color sourceColor = sourcePixel.getColor();
         
         //if the sourceColor is close to the oldShirtColor,
         //then replace it with the color of the picture shirt
         if (sourcePixel.colorDistance(oldShirtColor) < 88.0)
         {
           this.getPixel(x,y).setColor(shirtPixel.getColor());
         }
       }
     }
     //return the picture after modifying the shirt area
     return copy2;  
   }
     /**
   * Add you comments here
   */
   public Picture resize( int width, int height)
   {
     
     Picture copy1 = new Picture(this);
    // System.out.println(this.getHeight());
     Pixel pX1,pX2,pY1,pY2;
     int eX,eY,min2,min1;
     int[] min = new int [this.getHeight()]; 
     Picture copy=null; 
     int[][] sum = new int[this.getWidth()][this.getHeight()];
     int[][] energy = new int[this.getWidth()][this.getHeight()] ;
     
     for (int index = this.getWidth() ;index > width ; index--)
    {
      
     for (int i = 0; i < index; i++)
     {
       for (int j = 0; j < height; j++)
       {
         if (i == 0 || i == index-1 || j == 0 || j == height-1)
         /*{ 
           pX1 = copy1.getPixel(i,j);
           pX2 = copy1.getPixel(index-1,j);
         } 
         else
         {
           pX1 = copy1.getPixel(i,j);
           pX2 = copy1.getPixel(i-1,j);
         }
         
         if (j == 0)
         { 
           pY1 = copy1.getPixel(i,j);
           pY2 = copy1.getPixel(i,height-1);
         }
         else
         {
           pY1 = copy1.getPixel(i,j);
           pY2 = copy1.getPixel(i,j-1);
         }*/
         {energy [i][j]=  195075;}
         else { 
           
           int redX=copy1.getPixel(i+1,j).getRed()-copy1.getPixel(i-1,j).getRed();
        int   greenX=copy1.getPixel(i+1,j).getGreen()-copy1.getPixel(i-1,j).getGreen();
        int    blueX=copy1.getPixel(i+1,j).getBlue()-copy1.getPixel(i-1,j).getBlue();
        int      redY=copy1.getPixel(i,j+1).getRed()-copy1.getPixel(i,j-1).getRed();
        int   greenY=copy1.getPixel(i,j+1).getGreen()-copy1.getPixel(i,j-1).getGreen();
        int    blueY=copy1.getPixel(i,j+1).getBlue()-copy1.getPixel(i,j-1).getBlue();
            
           energy[i][j] = redX*redX+greenX*greenX+blueX*blueX+
                           redY*redY+greenY*greenY+blueY*blueY;}
         
        /*eX = Math.abs((pX1.getRed()+pX1.getGreen()+pX1.getBlue())/3 - (pX2.getRed()+pX2.getGreen()+pX2.getBlue())/3);
        eY = Math.abs((pY1.getRed()+pY1.getGreen()+pY1.getBlue())/3 - (pY2.getRed()+pY2.getGreen()+pY2.getBlue())/3);
        
        energy[i][j] = eX+eY; */
       }
        
     }
    
   
     for(int i4 = 0;i4 < index;i4++)
     {
      
          sum[i4][0] = energy[i4][0];
         
     }
     
     
      for (int j2 = 1; j2 < height; j2++)  
        {
          for(int i2 = 0;i2 < index; i2++)
          {
            
            if (i2 == 0)
            { 
              if (sum[i2][j2-1] <= sum[i2+1][j2-1])
              { 
                sum[i2][j2] = energy[i2][j2] + sum[i2][j2-1];
              }
              else 
              { 
                sum[i2][j2] = energy[i2][j2] + sum[i2+1][j2-1];
              }
            }
         
            else if (i2 == index-1)
            { 
              if (sum[i2-1][j2-1] <= sum[i2][j2-1])
              { 
                sum[i2][j2] = energy[i2][j2] + sum[i2-1][j2-1];
              }
              else 
              { 
                sum[i2][j2] = energy[i2][j2] + sum[i2][j2-1];
              }
            }
          
           else 
           {
             if (sum[i2-1][j2-1] <= sum[i2][j2-1]) 
             { 
               if (sum[i2-1][j2-1] <= sum[i2+1][j2-1]) 
               {
                 sum[i2][j2] = energy[i2][j2] + sum[i2-1][j2-1];
               }
               else 
               {
                 sum[i2][j2] = energy[i2][j2] + sum[i2+1][j2-1];
               }
             }
          
             if (sum[i2-1][j2-1] > sum[i2][j2-1]) 
             { 
               if (sum[i2][j2-1] <= sum[i2+1][j2-1]) 
               {
                 sum[i2][j2] = energy[i2][j2] + sum[i2][j2-1];
               }
               else 
               {
                 sum[i2][j2] = energy[i2][j2] + sum[i2+1][j2-1];
               }
             }
           }
          }   
      }
      
      
      /*for (int i3 = 0 ;i3 < index; i3++)
     {System.out.println(sum[i3][height-1]);}
      System.out.println();
       
     for (int i3 = 1;i3 < index; i3++)
     {
       if (sum[i3][height-1] < min1){ min1 = sum[i3][height-1]; min[height-1] = i3;}
     }
    // System.out.print(min[height-1]+" ");*/
     
      min1 = sum[0][height-1];
      min[height-1] = 0;
     
     
     for (int i1 = 1; i1 < index; i1++)
       {
         if (sum[i1][height-1] < min1)
         {
           min1 = sum[i1][height-1];
           min[height-1] = i1;
         } 
       }
      //System.out.print(min[height-1]+" ");
    
     
     
     for (int j1 = height-2; j1 >= 0;j1--)
     {
        if (min[j1+1] == 0)
        { 
           if (energy[min[j1+1]][j1] <= energy[min[j1+1]+1][j1])
           { 
             min[j1] = min[j1+1];
           }
           else 
           { 
             min[j1] = min[j1+1]+1;
           }
        }
        
        else if (min[j1+1] == index-1)
        { 
          if (energy[min[j1+1]-1][j1] <= energy[min[j1+1]][j1])
          { 
            min[j1] = min[j1+1]-1;
          }
          else 
          { 
            min[j1] = min[j1+1];
          }
        }
     
        else
        { 
          if (energy[min[j1+1]-1][j1] <= energy[min[j1+1]][j1] )
          {  
            if (energy[min[j1+1]-1][j1] <= energy[min[j1+1]+1][j1])
            {
              min[j1] = min[j1+1]-1;
            }
            else 
            {
              min[j1] = min[j1+1]+1;
            }
         }
           
         if (energy[min[j1+1]][j1] < energy[min[j1+1]-1][j1] )
         {  
           if (energy[min[j1+1]][j1] <= energy[min[j1+1]+1][j1])
           {
             min[j1] = min[j1+1];
           }
           else 
           {
             min[j1] = min[j1+1]+1;
           }
         }
        }  
     }
     
     //System.out.println();
     
     copy = new Picture(index-1, height);
     for (int y = 0; y < height; y++)
     {
       for (int x = 0; x < index-1; x++)
       {
         if (x < min[y]) 
         {
           copy.getPixel(x,y).setColor(copy1.getPixel(x,y).getColor());
         }
         else if (x == min[y])
         {
           this.getPixel(x,y).setColor(Color.RED);
           if (x == 0)
           {
           Color color2 = new Color((copy1.getPixel(x,y).getRed()+copy1.getPixel(x+1,y).getRed())/2,(copy1.getPixel(x,y).getGreen()+copy1.getPixel(x+1,y).getGreen())/2,(copy1.getPixel(x,y).getBlue()+copy1.getPixel(x+1,y).getBlue())/2);
           copy.getPixel(x,y).setColor(color2);}
           
           else {
           Color color1 = new Color((copy1.getPixel(x-1,y).getRed()+copy1.getPixel(x,y).getRed())/2,(copy1.getPixel(x-1,y).getGreen()+copy1.getPixel(x,y).getGreen())/2,(copy1.getPixel(x-1,y).getBlue()+copy1.getPixel(x,y).getBlue())/2);
           copy.getPixel(x-1,y).setColor(color1);
           Color color2 = new Color((copy1.getPixel(x,y).getRed()+copy1.getPixel(x+1,y).getRed())/2,(copy1.getPixel(x,y).getGreen()+copy1.getPixel(x+1,y).getGreen())/2,(copy1.getPixel(x,y).getBlue()+copy1.getPixel(x+1,y).getBlue())/2);
           copy.getPixel(x,y).setColor(color2);}}
        
         else
         { copy.getPixel(x,y).setColor(copy1.getPixel(x+1,y).getColor());}
       } 
     }
     copy1 = copy;
     }
     return this;}
   
  
  
   
} // this } is the end of class Picture, put all new methods before this
 
