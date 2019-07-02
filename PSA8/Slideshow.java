/* Filename: Slideshow.java 
* Created by:  Xinyi He (cs8aware) and Yifan Wu (cs8awaqb)
* Date: Mar.12
*/

import java.util.Random;
public class Slideshow
{
  ///////////////////// fields //////////////////////////////////
  private Slide[] slides;
  private double probFlip;

  ///////////////////// constructors //////////////////////////////////
 /**
  *Constructor that initializes the slides array and set probFlip to be 0.
  */
  public Slideshow()
  {
    this.slides = new Slide[0];
    this.probFlip = 0.5;
  }

 /**
  *Constructor that initializes the slides array and set probFlip to inProb.
  */
  public Slideshow(double inProb)
  {
    //call the above constructor
    this();
    changeProbFlip(inProb);
  }
  
  ///////////////////// methods //////////////////////////////////
 /**
   * Method name: changeProbFlip
   * The method is to change ProbFlip to be inProb.
   * Input:inProb 
   * Return:nothing
   **/
  public void changeProbFlip(double inProb)
  {
    //if inProb is not approporiate, then print out the wrong message,
    //else set the probFlip
    if (inProb < 0 || inProb > 1)
    {
      System.out.println("Inappropriate value for probFlip..."
                           + "probFlip will not be changed");
      return;
    }
    else
    {
      this.probFlip = inProb;
    }
  }
  
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
      throw new IndexOutOfBoundsException();
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
    //else call the showSlide method
    if (this.slides[0] == null || this.slides == null)
    {
      System.out.println("Error! The slideshow is empty!");
      return;
    }
    else
    {
      Random generator = new Random(2048);
      for (int i = 0;i < this.slides.length;i++)
      {
        boolean pictureFlipHorizontal = false;
        boolean reverseSound = false;
        double a = generator.nextDouble();
        if (a < this.probFlip)
        {
          pictureFlipHorizontal = true;
          reverseSound = true;
        }
        this.slides[i].showSlide(pictureFlipHorizontal,reverseSound);
      }
    }
  }
  
///////////////////////main///////////////////////
  public static void main(String[] args)
  {
    /*Slide slide1 = new Slide(new Picture("1.jpg"),new Sound("1.wav"));
    Slide slide2 = new Slide(new Picture("2.jpg"),new Sound("2.wav"));
    Slide slide3 = new Slide(new Picture("3.jpg"),new Sound("3.wav"));
    Slide slide4 = new Slide(new Picture("4.jpg"),new Sound("4.wav"));
    
    /*Slide slide1 = new Slide();
    Slide slide2 = new Slide();
    Slide slide3 = new Slide(new Picture("3.jpg"),new Sound("3.wav"));
    Slide slide4 = new Slide(new Picture("4.jpg"),new Sound("4.wav"));*/
    /*Slide slide1 = new Slide();
    Slide slide2 = new Slide();
    Slide slide3 = new Slide();
    Slide slide4 = new Slide();*/

    /*Slideshow show = new Slideshow(0.6);
    show.addSlide(slide1);
    show.addSlide(slide2);
    show.addSlide(slide3);
    show.addSlide(slide4);
    show.show();*/
    Sound s = new Sound("2.wav");
    s.explore();
    s =   s.repeatThreeTimes();
    s.explore();
    
    
  }
  
  /********** Extra credit tester helper method ************/
  public Slide[] getSlides(){
    return this.slides; 
  }
}