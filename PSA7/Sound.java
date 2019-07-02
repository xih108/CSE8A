/* Filename: Sound.java 
* Created by: Xinyi He (cs8aware) and Junyi Guo (cs8awakw)
* Date: Feb.22
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
   * Method name:concatenateSound
   * This method concatenates two piece of sound
   * Input: firstSound(the first sound)
   *        secondSound(the second sound)  
   *        switchPoint(start the second sound either at switchPoint 
   *                                or at the end of the first sound)
   * Returns: nothing
   */
  public void concatenateSound (Sound firstSound, Sound secondSound, 
                                int switchPoint)
  {
    //declare variables
    int i,target;
    SoundSample[] fArray = firstSound.getSamples();
    SoundSample[] sArray = secondSound.getSamples();
    
    //for loop: i is the index of the sample of first sound
    //target is the index of the calling object
    for (i = 0,target = 0; i < fArray.length
                        && i < switchPoint     
                        && target < this.getLength();i++,target++)
    {
      this.setSampleValueAt(target, fArray[i].getValue());
    }
    
    //for loop:i is the index of the sample of second sound
    //target is the index of the calling object
    //start second sound 
    for (i = 0; i < sArray.length && target < this.getLength(); i++,target++)
    { 
      this.setSampleValueAt(target, sArray[i].getValue());
    }
    
    //if the calling object is very long
    //leave the remaining portion of the calling object as silent.
    for (; target < this.getLength(); target++)
    { 
      this.setSampleValueAt(target, 0);
    }
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

  /**
   * Method name:palindromeSound
   * This method creates a palindrome sound
   * Input: nothing
   * Returns: palindrome(the sound combined of the original sound 
   *                                       and its reversed sound)
   */
  public Sound palindromeSound()
  {
    //create an empty new sound
    Sound palindrome = new Sound(2*this.getLength());
    //call the method reverseSound
    Sound reverse = this.reverseSound();
    //call the method concatenateSound
    palindrome.concatenateSound(this, reverse, this.getLength());
    return palindrome;
  }
  
  /**
   * Xinyi He (cs8aware)
   * Method name:extracreditSoundCollage
   * This method first divides sound1 and sound2 into n parts
   * then put a random piece of sound2 between two random pieces of sound1 
   * Input: sound1
   *        sound2 
   *        n (how many parts should sound1 and sound2 be divided into)
   * Returns: s (a sound which is created by sound1 and sound2)
   */
  public static Sound extracreditSoundCollage(Sound sound1, 
                                              Sound sound2, int n)
  {
    //create an empty sound
    Sound s = new Sound(sound1.getLength()+sound2.getLength());
    //declare variables
    int i,x = 0,target = 0;
    int[] a = new int[n];
    
    //create n different numbers between 0 and n-1
    for(x = 0;x < n; x++)
    {
      a[x] = x;
    }
    
    for(x = 0;x < n;x++)
    {
       Random generator = new Random();
       int y = generator.nextInt(n);
       int m = a[x];
       a[x] = a[y];
       a[y] = m;
    }
    
    //divide sound1 and sound2 into n parts
    //and combine them together piece by piece
    for(int j = 0; j < n;j++)
    {
      for (i = a[j]*sound1.getLength()/n;i < (a[j]+1)*sound1.getLength()/n; 
           i++,target++)
      {
        s.setSampleValueAt(target, sound1.getSampleValueAt(i));
      }
    
      for (i = a[j]*sound2.getLength()/n;i < (a[j]+1)*sound2.getLength()/n;
           i++,target++)
      {
        s.setSampleValueAt(target, sound2.getSampleValueAt(i));
      }
    }
    //return the new created sound
    return s;
  }
  
} // this } is the end of class Sound, put all new methods before this
