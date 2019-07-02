/* Filename: PSA3A.java 
* Created by: Xinyi He(cs8aware) and Oliver Kelton (cs8awaoc)
* Date: Jan 28th 2017
*/ 
public class PSA3A
{
    //The line below is magic, you don't have to understand it (yet)
    public static void main (String[] args) 
    { 
      Picture original=new Picture(FileChooser.pickAFile());//select a picture
      Picture copy=new Picture(original);//make a copy of the original picture
      original.explore();//show the original picture
      copy.subtractColor(100,200,300);//call the method,change the copy picture
      copy.explore();//show the original picture
    }
}

