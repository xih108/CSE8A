/* Filename: ExtraCreditPSA6.java 
* Created by: Xinyi He (cs8aware)
* Date: Feb 17
*/ 
public class ExtraCreditPSA6 extends Picture
{ 
    //The line below is magic, you don't have to understand it (yet)
    public static void main (String[] args) 
    {  
      //show the three pictures()
      Picture context = new Picture("extra_original.bmp");
      Picture message1 = new Picture("extra_message1.bmp");
      Picture message2 = new Picture("extra_message2.bmp");
      context.show();
      message1.show();
      message2.show();
      
      //call method extraCreditEmbed and show the pictuce with two other pictures hidden in it
      Picture hide = Picture.extraCreditEmbed(context, message1,
                                              message2, 259 ,200);
      hide.write(System.getProperty("user.home")+
                                   "/extra_picture_with_hidden_message.bmp");
      hide.show();
      
      //call method extraCreditExtract and show the two hidden pictures
      Picture recover = Picture.extraCreditExtract(hide, 259, 200);
      recover.write(System.getProperty("user.home")+
                                       "/extra_recovered_message.bmp");
      recover.explore();  
    } 
}
