/* Filename: PSA7A.java
* Created by: Xinyi He (cs8aware) and Junyi Guo (cs8awakw)
* Date: Feb.22
*/ 
public class PSA7A
{
//The line below is magic, you don't have to understand it (yet)
    public static void main (String[] args)
    {
        //select the sound and display it
        Sound sound1 = new Sound(FileChooser.pickAFile());
        sound1.blockingPlay();
        
        //select the sound and display it
        Sound sound2 = new Sound(FileChooser.pickAFile()); 
        sound2.blockingPlay();
        
        //select the sound and call the method, then display 
        Sound silence = new Sound(FileChooser.pickAFile());
        silence.concatenateSound(sound1, sound2, 100000);
        silence.blockingPlay();
    }
}
