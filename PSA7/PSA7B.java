/* Filename: PSA7B.java 
* Created by: Xinyi He (cs8aware) and Junyi Guo (cs8awakw)
* Date:  Feb 22
*/ 
public class PSA7B
{
//The line below is magic, you don't have to understand it (yet)
    public static void main (String[] args)
    {
      //select the sound and display it
      Sound sound1 = new Sound(FileChooser.pickAFile());
      sound1.blockingPlay();

      //test the method palindromeSound
      Sound palindrome = sound1.palindromeSound();
      palindrome.blockingPlay();
      
      Sound s1 = new Sound("sound0.wav");
      s1.explore();
      
      Sound s2 = new Sound("sound1.wav");
      s2.explore();
      
      //call the static method extracreditSoundCollage
      //s1 is one sound, s2 is the other sound, 
      //100 means divide s1 and s2 into 100 parts
      Sound s = Sound.extracreditSoundCollage(s1,s2,100);
      s.blockingPlay();
      s.write(System.getProperty("user.home")+"/extracredit.wav");
      s.explore();  
    }
}
