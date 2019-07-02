/* Filename: PSA5.java 
* Created by:  Xinyi He (cs8aware) and Yiwen Li (cs8awals)
* Date: 2.10 
*/ 
import java.awt.Color;
public class PSA5
{ 
    //The line below is magic, you don't have to understand it (yet)
    public static void main (String[] args) 
    { 
      //create a new Picture and show it. "pic0.jpg" is the original picture
      Picture myself = new Picture("pic0.jpg");
      myself.explore();
      
      //pic1.jpg is the background piture ,pic2.jpg is the shirt picture
      Picture background = new Picture("pic1.jpg");
      Picture myShirt = new Picture("pic2.jpg");
      Picture copy = new Picture(myself);
      
      //call the method chromakeyBackgroundChange and show the modified picture
      Color replaceColor = new Color(15, 234, 18); 
      copy = copy.chromakeyBackgroundChange(background, replaceColor);
      Picture copy1 = new Picture(copy);
      copy1.explore();
      
      
      //call the method chromakeyShirtChange and show the modified picture      
      Color oldShirtColor = new Color(200, 235, 240);
      copy1 = copy1.chromakeyShirtChange(myShirt, myself ,oldShirtColor, 270, 140, 90, 100);
      Picture copy2 = new Picture(copy1);
      copy2.explore(); 
    } 
}