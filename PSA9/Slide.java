/* Filename: Slideshow.java 
* Created by:  Xinyi He (cs8aware)
* Date: Mar.12
*/

/**I have submitted CAPE review**/

/*--------PROGRAM DESCRIPTION----------
*This program focuses on creating personalized slides and then show them.
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
*It has method showSlide to choose which filter to use and play the sound.
*Then hide the picture after the sound ends.
* 
*Slideshow.java file: 
*It has one instance variables: 
*slides refers to the slide array of Slideshow object.
*
*It has one constructors: 
*public Slideshow() takes no parameters and initializes the slides array. 
*
*It has four methods:
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
  * Input:filterToUse, boolean soundReverse
  *       (decides which filter to use)
  * Return:nothing
  **/
  public void showSlide(int filterToUse, boolean soundReverse)
  {
    //if pic and sound are null ,print out wrong message
    if (this.pic == null || this.sound == null ) 
    {
      System.out.println("error");
      return;
    }
    Picture pic1 = new Picture(this.pic);
    Sound s1 = new Sound(this.sound);
    //choose which filter to use,and show the picture
    switch(filterToUse)
    {
      case 1: pic1.complement();//get the complement of the picture
      case 2: pic1.grayscale();//create a gray version
      case 3: pic1.swap();//swap the color
    }
    pic1.show();
    
    if(soundReverse)
    {
      s1 = s1.reverseSound();
     }
    s1.blockingPlay();
    pic1.hide();
}
  
}