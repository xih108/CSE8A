/* Filename: PSA6.java 
* Created by: Xinyi He (cs8aware) and Yiwen Li (cs8awals)
* Date: Feb 17
*/ 
public class PSA6 extends Picture
{ 
//The line below is magic, you don't have to understand it (yet)
    public static void main (String[] args) 
    {  
      //Test for 2 Bits
      String contextPic = FileChooser.pickAFile();
      Picture context = new Picture(contextPic);
      context.show();
      String messagePic = FileChooser.pickAFile();
      Picture message = new Picture(messagePic);
      message.show();
      //Test for method hideSecretMessage2Bits
      Picture myPicWithMessage= Picture.hideSecretMessage2Bits(context, 
                                                               message, 0, 0);
      myPicWithMessage.show();
      //Test for method recoverSecretMessage2Bits
      String recoverPic = FileChooser.pickAFile();
      Picture recoverPicture = Picture.recoverSecretMessage2Bits
                                      (new Picture(recoverPic), 100, 100);
      recoverPicture.show();
      
      
      //Test for N bits
      String contextPic1 = FileChooser.pickAFile();
      Picture context1 = new Picture(contextPic1);
      context1.show();
      String messagePic1 = FileChooser.pickAFile();
      Picture message1 = new Picture(messagePic1);
      message1.show();
      //Test for method hideSecretMessageNBits
      Picture myPicWithMessage1 = Picture.hideSecretMessageNBits
                                         (context1, message1,2, 0, 0);
      myPicWithMessage1.show(); 
      //Test for method recoverSecretMessageNBits
      Picture recoverPicture1 = Picture.recoverSecretMessageNBits
                                       (myPicWithMessage1,2,100, 100);
      recoverPicture1.show();
     
      
      //Show and save the hidden message and the recover picture
      Picture context2 = new Picture("original.bmp");
      context2.show();
      Picture message2 = new Picture("message.bmp");
      message2.show();
      Picture contextWithMsg = Picture.hideSecretMessage2Bits
                                      (context2,message2, 95, 12);
      contextWithMsg.write(System.getProperty("user.home")+
                           "/my_picture_with_hidden_message.bmp");
      contextWithMsg.show();
      
      Picture msg = Picture.recoverSecretMessage2Bits
                           (contextWithMsg, 0, 0);
      msg.write(System.getProperty("user.home")+
                                   "/my_hidden_message.bmp");
      msg.show();
    } 
}
