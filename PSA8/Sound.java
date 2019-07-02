/* Filename: Sound.java 
* Created by: Xinyi He (cs8aware) and Yifan Wu (cs8awaqb)
* Date: Mar.12
*/ 
/**
 * Class that represents a sound.  This class is used by the students
 * to extend the capabilities of SimpleSound.
 *
 * Copyright Georgia Institute of Technology 2004
 * @author Barbara Ericson ericson@cc.gatech.edu
 */

/*--------PROGRAM DESCRIPTION----------
* This program focuses on making changes on sound
* It uses method flipHorizontalSquare to flip a square 
* in the horizontal orientation within the boundary.
* 
* It uses method concatenateSound to concatenate two pieces of sound.
* It uses methods reverseSound to reverse the sound.
* It uses methods palindromeSound to create a palindrome sound.
* It uses methods extracreditSoundCollage to divide sound1 and sound2 
* into n parts and randomly put a piece of sound2 after a piece of sound1
* PSA7PictureTester.java is used to test the method flipHorizontalSquare.
* PSA7A.java is used to test the method concatenateSound.
* PSA7B.java is used to test the method palindromeSound 
*                and the method extracreditSoundCollage.
 */

import java.util.Random;
public class Sound extends SimpleSound
{

  /////////////// consructors ////////////////////////////////////

  /**
   * Constructor that takes a file name
   * @param fileName the name of the file to read the sound from
   */
  public Sound(String fileName)
  {
    // let the parent class handle setting the file name
    super(fileName);
  }

  /**
   * Constructor that takes the number of samples in
   * the sound
   * @param numSamples the number of samples desired
   */
  public Sound (int numSamples)
  {
    // let the parent class handle this
    super(numSamples);
  }

  /**
   * Constructor that takes the number of samples that this
   * sound will have and the sample rate
   * @param numSamples the number of samples desired
   * @param sampleRate the number of samples per second
   */
  public Sound (int numSamples, int sampleRate)
  {
    // let the parent class handle this
    super(numSamples,sampleRate);
  }

  /**
   * Constructor that takes a sound to copy
   */
  public Sound (Sound copySound)
  {
    // let the parent class handle this
    super(copySound);
  }

  ////////////////// methods ////////////////////////////////////

  /**
   * Method to return the string representation of this sound
   * @return a string with information about this sound
   */
  public String toString()
  {
    String output = "Sound";
    String fileName = getFileName();

    // if there is a file name then add that to the output
    if (fileName != null)
      output = output + " file: " + fileName;

    // add the length in frames
    output = output + " number of samples: " + getLengthInFrames();

    return output;
  }


  /**
   * Method name:reverseSound
   * This method reverses the sound
   * Input: nothing
   * Returns: reverse(the sound being reversed)
   */
   public Sound reverseSound()
  { 
    //make a copy of the calling object
    Sound reverse = new Sound(this);
    
    //for loop
    for (int i = 0; i < this.getLength(); i++)
    {
      //reverse the sound
      reverse.setSampleValueAt(i,this.getSampleValueAt(this.getLength()-1-i));
    }
    //return the reversed sound
    return reverse;
  }
   
   public Sound repeatThreeTimes()
{
   Sound copy = new Sound(3*this.getLength());
   for (int index = 0; index < 3;index++)
   {
    for (int i = 0; i < this.getLength();i++ )   
   {
     copy.setSampleValueAt((index+1)*i,this.getSampleValueAt(i));
   }}

return copy;
}

   public void clipIntoFromEnd(int nsamples,Sound other)
   {
     if (nsamples > this.getLength() || nsamples > other.getLength())
     {
        System.out.println("Not enough samples");
     }
     else
     {
        for (int i = nsamples-1, targetI = this.getLength()-1; i >= 0; i--,targetI--)
        {
           this.setSampleValueAt(targetI, other.getSampleValueAt(i));
        }
     }
   }

} // this } is the end of class Sound, put all new methods before this
