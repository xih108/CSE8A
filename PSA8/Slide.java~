/* Filename: Slide.java 
* Created by:  Xinyi He (cs8aware) and Yifan Wu (cs8awaqb)
* Date: Mar.12
*/

/*--------PROGRAM DESCRIPTION----------
*This program focuses on creating slides and then show them.
*Slide.java file：
*It has two instance variables: 
*pic refers to the picture of the Slide object.
*sound refers to the sound of the Slide Object.
*
*It has two constructors: 
*public Slide() takes no parameters and sets pic and sound to null. 
*public Slide(Picture inPic,Sound inSound) takes 2 parameters,inPic&inSound. 
*sets pic to inPic, sets sound to inSound.
*
*It has three methods: 
*It has method changePic to change the picture of the slide by inPic. 
*It has method changeSound to change the sound of the slide by inSound.
*It has method showSlide to show the picture(flip horizontally or vertically)
*and play the sound(reversely or not) at the same time.
*Then hide the picture after the sound ends.
* 
*Slideshow.java file: 
*It has two instance variables: 
*slides refers to the slide array of Slideshow object.
*probFlip means the probability of flipping.
* 
*It has two constructors: 
*public Slideshow() takes no parameters and initializes the slides array. 
*public Slideshow(double inProb) takes an input parameter for probFlip, 
*and initializes the slides array. 
*
*It has five methods:
*It has method changeProbFlip to changes value of probFlip to inProb. 
*It has method addSlide to add a slide to the end of the slides array. 
*It has method changeSlide to change the slide at the given index to inSlide. 
*It has method show to show the entire slideshow. 
*It has a main method to run your slideshow. 
*/

public class Slide
{
  ///////////////////// fields //////////////////////////////////
  public Picture pic;
  public Sound sound;
  
  ///////////////////// constructors //////////////////////////////////
  /**
   * Constructor that initializes pic and sound to be null.
   */
  public Slide()
  {
    this.pic = null;
    this.sound = null;
  }
  
  /**
   * Constructor that initializes pic and sound to be inPic and inSound.
   */                         
  public Slide(Picture inPic, Sound inSound)
  {
    this.pic = new Picture(inPic);
    this.sound = new Sound(inSound);
  }
  
  ///////////////////// methods //////////////////////////////////
 /**
   * Method name: changePic
   * The method is to change the picture of the slide to be inPic.
   * Input:inPic 
   * Return:nothing
   **/
  public void changePic(Picture inPic)
  {
    this.pic = inPic;
  }
  
 /**
   * Method name: changeSound
   * The method is to change the sound of the slide to be inSound.
   * Input:inSound
   * Return:nothing
   **/
  public void changeSound(Sound inSound)
  {
    this.sound = inSound;
  }
  
 /**
  * Method name: showSlide
  * The method is to show the slide.
  * Input:boolean pictureFlipHorizontal, boolean soundReverse
  *       (decides how to flip the picture and whether reverse the sound)
  * Return:nothing
  **/
  public void showSlide(boolean pictureFlipHorizontal, boolean soundReverse)
  {
    if (this.pic == null || this.sound == null ) 
    {
      System.out.println("error");
      return;
    }
    Picture pic1 = new Picture(this.pic);
    Sound s1 = new Sound(this.sound);
    if(pictureFlipHorizontal)
    {
      pic1.flipHorizontal();
    }
    else 
    {
      pic1.flipVertical();
    }
    pic1.show();
   
    if(soundReverse)
    {
      s1 = s1.reverseSound();
    }
    s1.blockingPlay();
    pic1.hide();
}
  
  //test
  public static void main(String[] args)
  {
    Slide s1 = new Slide(new Picture("1.jpg"),new Sound("2.wav"));
    s1.showSlide(false,true);
    s1.changePic(new Picture("2.jpg"));
    s1.changeSound(new Sound("3.wav"));
    s1.showSlide(false,true);
  }
}