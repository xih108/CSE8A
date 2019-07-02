/* Filename: PSA3B.java 
* Created by: Xinyi He(cs8aware) and Oliver Kelton (cs8awaoc)
* Date: Jan 28th 2017
*/ 
public class PSA3B
{
    //The line below is magic, you don't have to understand it (yet)
    public static void main (String[] args) 
    { 
      Picture original=new Picture(FileChooser.pickAFile());//select a picture
      Pixel[] pixelArray=original.getPixels();//get all the pixels and put them in an array
      original.show();//show the original picture
      Picture after=new Picture(original);//make a copy of the original picture called after
      int i=pixelArray.length;//get the value of 1/3 length of pixels
      after.complement(0,i/3-1);//call the method for the first 1/3 pixels
      after.grayscale(i/3,2*i/3-1);//call the method for the second 1/3 pixels
      after.myFilter(2*i/3,i-1);//call the method for the third 1/3 pixels
      after.repaint();//repaint picture after
    } 
}

