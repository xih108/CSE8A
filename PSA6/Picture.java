/* Filename: Picture.java 
* Created by: Xinyi He (cs8aware) and Yiwen Li (cs8awals)
* Date: Feb 17
*/ 


/*----------- Program Description: ------------
 * This program aims to hide a picture in another picture and then recover the hidden picture.
 * It uses method hideSecretMessage2Bits, hideSecretMessageNBits to hide a picture in another picture.
 * It uses method recoverSecretMessage2Bits
 * change the background of the picture.
 * It uses method chromakeyShirtChange to change the color of the shirt area.
 * PSA6.java is used to test the two methods:chromakeyBackgroundChange,chromakeyShirtChange. 
 * Extra Credit:
 * It uses method extraCreditEmbed to hide two pictures with the same size at the same place in one picture
 * It uses method extraCreditExtract to extract the two hidden pictures 
 * ExtraCreditPSA6.java is used to test the tw methods:extraCreditEmbed ,extraCreditExtract
 */

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

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
  
  /*
   * This method  preserve the 2 most significant (i.e. leftmost) bits in each 8-bit number
   * Example: The most significant 2 bits of 250 (11111010) are 11 in binary which is equal to 3 in decimal. 
   */
  public static int mostSignificant2( int num )
  {
    return num >> 6;
  }  
   
  
  /* 
   * This method  preserve the N most significant (i.e. leftmost) bits in each 8-bit number
   * Example: If N=3 ,the most significant 3 bits of 250 (11111010) are 111 in binary which is equal to 7 in decimal. 
   */
  public static int mostSignificantN( int num, int N )
  {
    return num >> (8-N);  
  }
  
  public static int shift2BitsTo8( int num )
  {
    return num << 6;
  }
  
  /* 
   * This method  converts num with N bits into 8 bits
   * Example: If if num is 2 and N is 3, it means num is 010 in binary. This method will convert it into 01000000,
   * which is equal to 64 in decimal.
   */
  public static int shiftNBitsTo8( int num, int N )
  {
    return num << (8-N);  // You must implement this
  }
 
   
  /*
   * This method creates a copy of picture passed in the parameter. It changes the red, blue and green components 
   * of each pixel in copied picture. It uses the method mostSignificant2 to convert the 8-bit values into 2 bit values
   *
   *  Hence if you call this method, it will give you a copy of the picture passed in the parameter. But the copied picture has only 2 bits of 
   * information per color. For example, if blue color value for  any pixel in the picture is 01000000 (64 in decimal), the correspoding value 
   * of red color in copied picuture would be just 00000001 (1 in decinal)
   *
   */
  public static Picture degradeColors2Bits(Picture sourcePicture) {
    Picture picCopy = new Picture( sourcePicture.getWidth(),
                                   sourcePicture.getHeight() );
    for ( int x = 0; x < sourcePicture.getWidth(); x++ ) {
      for ( int y = 0; y < sourcePicture.getHeight(); y++ ) {
        Pixel source = sourcePicture.getPixel( x, y );
        Pixel target = picCopy.getPixel( x, y );
        
        int red = source.getRed();
        int green = source.getGreen();
        int blue = source.getBlue();
       
        red = mostSignificant2( red );
        green = mostSignificant2( green );
        blue = mostSignificant2( blue );
        
        red = shift2BitsTo8( red);
        green = shift2BitsTo8( green);
        blue = shift2BitsTo8( blue);
        
        target.setRed( red );
        target.setGreen( green );
        target.setBlue( blue );
      }
    }
    return picCopy;
  
 }  

  /*
   This method creates a copy of the picture passed in the parameter. It changes the red, blue and green components 
   of each pixel in copied picture. It uses the method mostSignificantN to convert the 8-bit values into N bit values
   and then shift it back to 8 bit values.
   Hence if you call this method with the Picture as one of the parameters, it will give you a copy of the picture. 
   But the copied picture has only N bits of information per color.
   */
  public static Picture degradeColorsNBits(Picture sourcePicture,int N) {
    Picture picCopy = new Picture( sourcePicture.getWidth(),
                                   sourcePicture.getHeight() );
    for ( int x = 0; x < sourcePicture.getWidth(); x++ ) {
      for ( int y = 0; y < sourcePicture.getHeight(); y++ ) {
        Pixel source = sourcePicture.getPixel( x, y );
        Pixel target = picCopy.getPixel( x, y );
        int red = source.getRed();
        int green = source.getGreen();
        int blue = source.getBlue();
        
        red = mostSignificantN( red, N );
        green = mostSignificantN( green, N);
        blue = mostSignificantN( blue, N);
        
        red = shiftNBitsTo8( red, N );
        green = shiftNBitsTo8( green, N);
        blue = shiftNBitsTo8( blue, N);
        
        target.setRed( red );
        target.setGreen( green );
        target.setBlue( blue );
      }
    }
    return picCopy;
 } 
  
  
  /**
   * Method name:hideSecretMessage2Bits
   * method hides a picture in another picture
   * Input: context(a picture that you want to show it at the shirt area)
   *        message(the original picture)  
   *        x(the start hiding x coordinate)
   *        y(the start hiding y coordinate)
   * Returns: canvas(a picture after hiding a picture in it)
   */
  public static Picture hideSecretMessage2Bits(Picture context, 
                                               Picture message, int x, int y)
  {
    Picture canvas = new Picture(context);
    for (int sX = x , tX = 0; sX < canvas.getWidth() 
                           && tX < message.getWidth(); sX++, tX++)
    {
      for (int sY = y, tY = 0; sY < canvas.getHeight()
                            && tY < message.getHeight(); sY++, tY++)
      {
        int red = canvas.getPixel(sX,sY).getRed();
        int green = canvas.getPixel(sX,sY).getGreen();
        int blue = canvas.getPixel(sX,sY).getBlue();
        
        int mRed = message.getPixel(tX,tY).getRed();
        int mGreen = message.getPixel(tX,tY).getGreen();
        int mBlue = message.getPixel(tX,tY).getBlue();
        
        mRed = Picture.mostSignificant2 (mRed);
        mGreen = Picture.mostSignificant2(mGreen);
        mBlue = Picture.mostSignificant2(mBlue);
      
        red = Picture.embedDigits2(red,mRed);
        green = Picture.embedDigits2(green,mGreen);
        blue = Picture.embedDigits2(blue,mBlue);
       
        canvas.getPixel(sX,sY).setColor(new Color(red,green,blue));
      }
    }
    return canvas;
  }
  
  /**
   * Method name:recoverSecretMessage2Bits
   * method recovers the hidden picture
   * Input: picWithMessage(a picture that has a picture hidden in it)  
   *        x(the start recovering x coordinate)
   *        y(the start recovering y coordinate)
   * Returns: result(showing the recovering picture)
   */
  public static Picture recoverSecretMessage2Bits
    (Picture picWithMessage, int x, int y)
  {
    Picture result = new Picture(picWithMessage.getWidth(),
                                 picWithMessage.getHeight());
    for (int sX = 0 ; sX < picWithMessage.getWidth(); sX++)
    {
      for (int sY = 0 ; sY < picWithMessage.getHeight(); sY++)
      {
        int red = picWithMessage.getPixel(sX,sY).getRed();
        int green = picWithMessage.getPixel(sX,sY).getGreen();
        int blue = picWithMessage.getPixel(sX,sY).getBlue();
        
        if (sX >= x && sY >= y)
        {
          red = Picture.getLeastSignificant2(red);
          green = Picture.getLeastSignificant2(green);
          blue = Picture.getLeastSignificant2(blue);
        
          red = Picture.shift2BitsTo8(red);
          green = Picture.shift2BitsTo8(green);
          blue = Picture.shift2BitsTo8(blue);
        }
        result.getPixel(sX,sY).setColor(new Color(red,green,blue));
      }
    }
    return result;
  }
  
  
  /**
   * Method name:hideSecretMessageNBits
   * method hides a picture in another picture
   * Input: context(a picture that you want to show it at the shirt area)
   *        message(the original picture)  
   *        x(the start hiding x coordinate)
   *        y(the start hiding y coordinate)
   *        N(N bit)
   * Returns: canvas(a picture after hiding a picture in it)
   */
  public static Picture hideSecretMessageNBits(Picture context, 
                                               Picture message, 
                                               int N , int x, int y)
  {
    Picture canvas = new Picture(context);
    for (int sX = x , tX = 0; sX < canvas.getWidth() 
                           && tX < message.getWidth(); sX++, tX++)
    {
      for (int sY = y, tY = 0; sY < canvas.getHeight()
                            && tY < message.getHeight(); sY++, tY++)
      {
        int red = canvas.getPixel(sX,sY).getRed();
        int green = canvas.getPixel(sX,sY).getGreen();
        int blue = canvas.getPixel(sX,sY).getBlue();
        
        int mRed = message.getPixel(tX,tY).getRed();
        int mGreen = message.getPixel(tX,tY).getGreen();
        int mBlue = message.getPixel(tX,tY).getBlue();
      
        mRed = Picture.mostSignificantN (mRed,N);
        mGreen = Picture.mostSignificantN(mGreen,N);
        mBlue = Picture.mostSignificantN(mBlue,N);
      
        red = Picture.embedDigitsN(red,mRed,N);
        green = Picture.embedDigitsN(green,mGreen,N);
        blue = Picture.embedDigitsN(blue,mBlue,N);
       
        canvas.getPixel(sX,sY).setColor(new Color(red,green,blue));
      }
    }
    return canvas;
  }
  
   /**
   * Method name:recoverSecretMessageNBits
   * method recovers the hidden picture
   * Input: picWithMessage(a picture that has a picture hidden in it)  
   *        x(the start recovering x coordinate)
   *        y(the start recovering y coordinate)
   *        N(N bit)
   * Returns: result(showing the recovering picture)
   */
  public static Picture recoverSecretMessageNBits
                        (Picture context, int N ,int x, int y)
  {
    Picture result = new Picture(context.getWidth(),
                                 context.getHeight());
    for (int sX = 0 ; sX < context.getWidth(); sX++)
    {
      for (int sY = 0 ; sY < context.getHeight(); sY++)
      {
        int red = context.getPixel(sX,sY).getRed();
        int green = context.getPixel(sX,sY).getGreen();
        int blue = context.getPixel(sX,sY).getBlue();
        
        if (sX >= x && sY >= y)
        {
          red = Picture.getLeastSignificantN(red,N);
          green = Picture.getLeastSignificantN(green,N);
          blue = Picture.getLeastSignificantN(blue,N);
        
          red = Picture.shiftNBitsTo8(red,N);
          green = Picture.shiftNBitsTo8(green,N);
          blue = Picture.shiftNBitsTo8(blue,N);
        }
     
        result.getPixel(sX,sY).setColor(new Color(red,green,blue));
      }
    }
    return result;
  }
 
   /* 
   * Method name:embedDigits2 
   * This method replaces the two least significant bits with the input messageVal
   */
   public static int embedDigits2(int contextVal, int messageVal )
  {
    int shiftRight = contextVal >> 2;
    int shiftLeft = shiftRight << 2;
    int contextVal1 = shiftLeft + messageVal;
    return contextVal1;
  }
 
  /* 
   * Method name:embedDigitsN 
   * This method replaces N least significant bits with the input messageVal
   */
  public static int embedDigitsN( int contextVal, int messageVal, int N )
  {
    int shiftRight = contextVal >> N;
    int shiftLeft = shiftRight << N;
    int contextVal1 = shiftLeft + messageVal;
    return contextVal1;
  }
  
   /* 
   * Method name:getLeastSignificant2
   * This method get the two least significant bits with the input num
   */
  public static int getLeastSignificant2( int num )
  {
    num = num % 4;
    return num;
  }
  
   /* 
   * Method name:getLeastSignificantN
   * This method get the N least significant bits with the input num
   */
  public static int getLeastSignificantN( int num, int N )
  {
    int N1 = 1;
    for (int i = 0; i < N; i++)
    {
      N1 = 2*N1;
    }
    num = num % N1;
    return num;
  }
  
  
  
  //Extra Credit
  /**
   * Method name:extraCreditEmbed
   * method hides two different pictures with the same size at the same place of the picture
   * Input: context(a original picture)
   *        message1(one of the hidden picture)
   *        message2(the other hidden picture)
   *        x(the start hiding x coordinate)
   *        y(the start hiding y coordinate)
   * Returns: canvas2(the picture with two pictures hidden in it)
   * Strategy:get the 2 most significant bits of the message2 to replace the 3rd and 4th bits of message1
   *          get the 4 most significant bits of the new message1 to replace the 4 least significant bits of context        
   */
  public static Picture extraCreditEmbed(Picture context,Picture message1,
                                         Picture message2, int x,int y)
  {
    Picture canvas1 = new Picture(message1);
    for (int sX = 0;sX < message1.getWidth();sX++)
    {
      for(int sY = 0;sY < message1.getHeight();sY++)
      {
        Pixel p1 = canvas1.getPixel(sX,sY);
        Pixel p2 = message2.getPixel(sX,sY);
        
        int mRed1 = p1.getRed();
        int mGreen1 = p1.getGreen();
        int mBlue1 = p1.getBlue();
        
        //get the 2 most significant bits of the message2 to replace the 3rd and 4th bits of canvas1
        int mRed2 = Picture.mostSignificant2(p2.getRed());
        int mGreen2 = Picture.mostSignificant2(p2.getGreen());
        int mBlue2 = Picture.mostSignificant2(p2.getBlue());
        
        mRed2 = mRed2 << 4;
        mGreen2 = mGreen2 << 4;
        mBlue2 = mBlue2 << 4;
        
        mRed1 = Picture.embedDigitsN(mRed1,mRed2,6);
        mGreen1 = Picture.embedDigitsN(mGreen1,mGreen2,6);
        mBlue1 = Picture.embedDigitsN(mBlue1,mBlue2,6);
        
        canvas1.getPixel(sX,sY).setColor(new Color(mRed1,mGreen1,mBlue1)); 
      }
    }
    
    Picture canvas2 = new Picture(context);
    for (int i = x, tX = 0;i < canvas2.getWidth() 
                       && tX < canvas1.getWidth(); i++,tX++)
    {
      for(int j = y, tY = 0;j < canvas2.getHeight()
                         && tY < canvas1.getHeight();j++,tY++)
      {
        Pixel p1 = canvas1.getPixel(tX,tY);
        Pixel p3 = canvas2.getPixel(i,j);
        
        int mRed = p3.getRed();
        int mGreen = p3.getGreen();
        int mBlue = p3.getBlue();
        
        //get the 4 most significant bits of the canvas1 to replace the 4 least significant bits of canvas2
        int mRed1 = Picture.mostSignificantN(p1.getRed(),4);
        int mGreen1 = Picture.mostSignificantN(p1.getGreen(),4);
        int mBlue1 = Picture.mostSignificantN(p1.getBlue(),4);
        
        mRed = Picture.embedDigitsN(mRed,mRed1,4);
        mGreen = Picture.embedDigitsN(mGreen,mGreen1,4);
        mBlue = Picture.embedDigitsN(mBlue,mBlue1,4);
        
        canvas2.getPixel(i,j).setColor(new Color(mRed,mGreen,mBlue)); 
      }
    }
    return canvas2;
  }
  

  /**
   * Method name:extraCreditExtract
   * method recovers the two different pictures with the same size which are hidded in the picture
   * Input: picWithMessage(a picture with two pictures hidden in it)
   *        x(the start recovering x coordinate)
   *        y(the start recovering y coordinate)
   * Returns: result(recover the two pictures seperately)
   * Strategy: get the four least significant bits of picWithMessage 
   *           get the first two bits of the four bits to extract message1
   *           get the 2 least significant bits of picWithMessage to extract message2
   */
  public static Picture extraCreditExtract(Picture picWithMessage, int x,int y)
  {
    Picture result = new Picture(2*picWithMessage.getWidth(),
                                 picWithMessage.getHeight());
    int red1,red2;
    int green1,green2;
    int blue1,blue2;
    for (int sX = 0 ; sX < picWithMessage.getWidth(); sX++)
    {
      for (int sY = 0 ; sY < picWithMessage.getHeight(); sY++)
      {
        int red = picWithMessage.getPixel(sX,sY).getRed();
        int green = picWithMessage.getPixel(sX,sY).getGreen();
        int blue = picWithMessage.getPixel(sX,sY).getBlue();
        
        if (sX >= x && sY >= y)
        {
          //get the four least significant bits of picWithMessage 
          //then get the first two bits of the four bits to extract message1
          red = Picture.getLeastSignificantN(red,4);
          green = Picture.getLeastSignificantN(green,4);
          blue = Picture.getLeastSignificantN(blue,4);
          
          red1 = red >> 2;
          green1 = green >> 2;
          blue1 = blue >> 2;
          
          red = Picture.shift2BitsTo8(red1);
          green = Picture.shift2BitsTo8(green1);
          blue = Picture.shift2BitsTo8(blue1);
        }
        
        result.getPixel(sX,sY).setColor(new Color(red,green,blue));
      }
    }
    
    for (int sX = 0 ; sX < picWithMessage.getWidth(); sX++)
    {
      for (int sY = 0 ; sY < picWithMessage.getHeight(); sY++)
      {
        int red = picWithMessage.getPixel(sX,sY).getRed();
        int green = picWithMessage.getPixel(sX,sY).getGreen();
        int blue = picWithMessage.getPixel(sX,sY).getBlue();
        
        if (sX >= x && sY >= y)
        {
          //get the 2 least significant bits of picWithMessage to extract message2
          red2 = Picture.getLeastSignificant2(red);
          green2 = Picture.getLeastSignificant2(green);
          blue2 = Picture.getLeastSignificant2(blue);
        
          red = Picture.shift2BitsTo8(red2);
          green = Picture.shift2BitsTo8(green2);
          blue = Picture.shift2BitsTo8(blue2);
        }
        result.getPixel(sX+picWithMessage.getWidth(),sY).
          setColor(new Color(red,green,blue));
      }
    }
    return result;
  }
}// this } is the end of class Picture, put all new methods before this
 
