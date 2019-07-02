/*
 Xinyi He (cs8aware) 
*/
import junit.framework.TestCase;

public class MyJUnitTester extends TestCase
{
  Picture pic1 = new Picture("1.jpg");
  Picture pic2 = new Picture("2.jpg");
  Sound sound1 = new Sound("1.wav");
  Sound sound2 = new Sound("2.wav");
  
  Slide slide1 = new Slide(new Picture("1.jpg"),new Sound("1.wav"));
  Slide slide2 = new Slide(new Picture("2.jpg"),new Sound("2.wav"));
  Slide slide3 = new Slide(new Picture("3.jpg"),new Sound("3.wav"));
  Slide slide4 = new Slide(new Picture("4.jpg"),new Sound("4.wav"));
    
 
  public void testChangePic()
  {
    Slide slide1 = new Slide();
    //By asserting that slide1.pic is null, 
    //we have verified the constructor: public Slide()
    //because when no parameter passed in,slide1.pic is null.
    assertEquals(null,slide1.pic);
    
    Slide slide2 = new Slide(pic1, sound1);
    //By asserting that slide2.pic refers to the same picture as pic1,
    //we have verified the constructor: public Slide(Picture inPic, Sound inSound)
    //because when parameter pic1 is passed in, slide2.pic refers to pic1
    assertEquals("2 args ctor",pic1.toString(), slide2.pic.toString());
    
    slide2.changePic(pic2);
    //By asserting that slide2.pic refers to the same picture as pic2,
    //we have verified the method:changePic 
    //because when parameter pic2 is passed in, slide2.pic refers to pic2
    assertEquals("changePic",pic2.toString(),slide2.pic.toString());
  }
  
  
  public void testChangeSound()
  {
    Slide slide1 = new Slide();
    //By asserting that slide1.sound is null, 
    //we have verified the constructor:public Slide()
    //because when no parameter passed in,slide1.sound is null.
    assertEquals(null,slide1.sound);
    
    Slide slide2 = new Slide(pic1, sound1);
    //By asserting that slide2.sound refers to the same sound as sound1,
    //we have verified the constructor: public Slide(Picture inPic, Sound inSound)
    //because when parameter sound1 is passed in, slide2.sound refers to sound1
    assertEquals("2 args ctor",sound1.toString(), slide2.sound.toString());
    
    slide2.changeSound(sound2);
    //By asserting that slide2.sound refers to the same picture as sound2,
    //we have verified the method:changeSound 
    //because when parameter sound2 is passed in, slide2.sound refers to sound2
    assertEquals("changeSound",sound2.toString(),slide2.sound.toString());
  }

  public void testAddSlide()
  {
    Slideshow slideShow = new Slideshow();
    //By asserting that the length of the array sildeShow.getSlides() is 0,
    //we have verified the constructor:public Slideshow()
    //because when no parameter is passed in,slideShow.getSlides() is a array with length 0.
    assertEquals(0,slideShow.getSlides().length);
    
    slideShow.addSlide(slide1);
    //By asserting that sildeShow.getSlides() at index 0 refers to the same slide as slide1
    //we have verified the method:public addSlide
    //because when slide1 is passed in,it will be at index 0 of slideShow.getSlides().
    assertEquals("addSlide",slide1,slideShow.getSlides()[0]);
  }

   public void testChangeSlide()
  {
    Slideshow slideShow = new Slideshow();
    //When the length of the array sildeShow.getSlides() is 0,
    //it would definitely be wrong if I try to change the slide at index 0  with slide1.
    try{
      slideShow.changeSlide(slide1,0);
      fail();
    }
    catch (IndexOutOfBoundsException e)
    {
    }
    
    slideShow.addSlide(slide1);
    slideShow.addSlide(slide2);
    slideShow.addSlide(slide3);
    slideShow.changeSlide(slide4,2);
    //By asserting that sildeShow.getSlides() at index 2 refers to the same slide as slide4,
    //we have verified the method:public changeSlide
    //because when slide4 and 2 is passed in,it will replace the slide at index 2 with slide4.
    assertEquals("changeSlide",slide4,slideShow.getSlides()[2]);
   }
}