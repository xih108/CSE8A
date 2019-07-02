/* Filename: PSA4A.java 
* Created by: Xinyi He (cs8aware) and Yiwen Li (cs8awals)
* Date: Feb 5th 2017
*/ 

/*I've given you a basic skeleton of how your code is going to look so you can get a basic idea of the workflow here*/
public class PSA4A {
 public static void main(String [] args)
 {
   //Choose a picture file and show it
   String sourceFile = FileChooser.pickAFile();
   Picture sourcePicture = new Picture(sourceFile);
   sourcePicture.show();
   
   //Copy Picture objects
   Picture copy1 = new Picture(sourcePicture);
   Picture copy2 = new Picture(sourcePicture);
   Picture copy3 = new Picture(sourcePicture);
   
   //Call method flipHorizontal
   copy1.flipHorizontal(); 
   copy1.show();
   
   //Call method flipVertical
   copy2.flipVertical();
   copy2.show();
   
   //Call method grayscale
   copy3.grayscale();
   copy3.show();
   
   //Create a array of Pictures
   Picture[] pictures = new Picture[3];
   pictures[0] = copy1;
   pictures[1] = copy2;
   pictures[2] = copy3;
   
   //Create a picture object using the canvas which we will be drawing our collage on
   int width = sourcePicture.getWidth();
   int height = sourcePicture.getHeight();
   Picture canvas = new Picture(3*width,height);
   
   //Call collage() with canvas and show it!
   canvas.collage(pictures);
   canvas.explore();
 }
 
}