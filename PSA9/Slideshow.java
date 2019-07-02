/* Filename: Slide.java 
* Created by:  Xinyi He (cs8aware)
* Date: Mar.12
*/
import java.util.Random;
public class Slideshow
{
  ///////////////////// fields //////////////////////////////////
  private Slide[] slides;

  ///////////////////// constructors ///////////////////////////
 /**
  *Constructor that initializes the slides array.
  */
  public Slideshow()
  {
    this.slides = new Slide[0];
  }
  
  ///////////////////// methods //////////////////////////////////
 /**
   * Method name: addSlide
   * The method is to add a slide at the end of the slides array.
   * Input:inSlide
   * Return:nothing
   **/
  public void addSlide(Slide inSlide)
  {
    Slide[] slidesNew = new Slide[slides.length+1];
    for( int i = 0; i < this.slides.length; i++) {
      slidesNew[i] = this.slides[i]; 
    }
    slidesNew[slidesNew.length - 1] = inSlide;
    this.slides = slidesNew;
  }

 /**
  * Method name: changeSlide
  * The method is to change the slide at the given index to inSlide. 
  * Input:inSlide,slideToChange
  * Return:nothing
  **/
  public void changeSlide(Slide inSlide, int slideToChange)
  {
    //if slideToChange is out of bound, then print out the wrong message,
    //else replace the slide with inSlide
    if (slideToChange >= 0 && slideToChange < this.slides.length)
    {
      this.slides[slideToChange] = inSlide;
    } 
    else 
    {
      System.out.println("Error method");
      return;
    }
  }
  
   /**
  * Method name:show
  * The method show the entire slides array.
  * Input:nothing
  * Return:nothing
  **/
  public void show()
  { 
    //if the slide is empty, print out the wrong message
    //else call the showSlide 
    if (this.slides[0] == null)
    {
      System.out.println("Error! The slideshow is empty!");
      return;
    }
    else
    {
      Random generator = new Random(10000);
      for (int i = 0;i < this.slides.length;i++)
      {
        boolean reverseSound = false;
        //generate a random integar from between 1 and 3
        int a = generator.nextInt(3)+1;
        this.slides[i].showSlide(a,reverseSound);
      }
    }
  }
  
 ////////////////main/////////////////////
  public static void main(String[] args)
  {
    //After the first week of class: happy,music
    //Before the first Midterm：nervous,trying
    //After receiving the grade for the first Midterm:ok,fine
    //Before the second Midterm:nervous, trying
    //After you completed PSA8:released, done
    Slide slide1 = new Slide(new Picture("1.jpg"),new Sound("1.wav"));
    Slide slide2 = new Slide(new Picture("2.jpg"),new Sound("2.wav"));
    Slide slide3 = new Slide(new Picture("3.jpg"),new Sound("3.wav"));
    Slide slide4 = new Slide(new Picture("4.jpg"),new Sound("2.wav"));
    Slide slide5 = new Slide(new Picture("5.jpg"),new Sound("5.wav"));

    Slideshow show = new Slideshow();
    //add slides to the slides array
    show.addSlide(slide1);
    show.addSlide(slide2);
    show.addSlide(slide3);
    show.addSlide(slide4);
    show.addSlide(slide5);
   // show the slideshow
    show.show();
  }
}