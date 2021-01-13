/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantshop8;

/**
 *
 * @author Akash Pawar
 */
public class FinalID {
    /*
    Reminder :
    singleAlphabet is the initial alphabet you want to add in your id
    char_IDisToBeGenerated is the number which is appended after the 
    singleAlphabet(generally Total_p(now replaced simply by "i" in your code))
    NoOfDigits is the count you'd get from NumberDigits class.
    */
    
    /*
    Suppose, "Alphabet" = P
    You're looking for next id to be generated, then from Add/next button's program
    the parameter "char_IDisToBeGenerated" gets value 5
    from NumberDigits.getCount(), NoOfDigits becomes 1, and "a" becomes 3
    Thus, "final_id" is set to "P0005".
    */
    public static String getID(String Alphabet, int char_IDisToBeGenerated, int NoOfDigits) throws Exception{
        String final_id= null;    
        int Alphabet_no =  Alphabet.length();
        int digits = 0;
        if(Alphabet_no == 1){
            if(Alphabet.equals("P") || Alphabet.equals("S")){
                digits = 5;
            }
            if(Alphabet.equals("G") || Alphabet.equals("H") || Alphabet.equals("N")){
                digits = 4;
            }
        }
        if (Alphabet_no == 2){
            digits = 6;
        }
        
        int a = digits - NoOfDigits;
        
        //JOptionPane.showMessageDialog(null, "digits : "+digits);
        //JOptionPane.showMessageDialog(null, "NoOfDigits : "+NoOfDigits );
        //JOptionPane.showMessageDialog(null, "Alphabet_no : "+Alphabet_no );
        //JOptionPane.showMessageDialog(null, "a : "+a);
        if(Alphabet_no == 2 && Alphabet.equals("ST")){
            if(a==5){
                final_id = (Alphabet + "000" + Integer.toString(char_IDisToBeGenerated));
            }
            if(a==4){
                final_id = (Alphabet + "00" + Integer.toString(char_IDisToBeGenerated));
            }
            if(a==3){
                final_id = (Alphabet + "0" + Integer.toString(char_IDisToBeGenerated));
            }
            if(a==2){
                final_id = ((Alphabet + Integer.toString(char_IDisToBeGenerated)));
            } 
        }
        
        if(Alphabet_no == 1 && (Alphabet.equals("P") || Alphabet.equals("G") ||
                Alphabet.equals("H") || Alphabet.equals("S") || Alphabet.equals("N"))){
            if(a==3 ){
                final_id = (Alphabet + "000" + Integer.toString(char_IDisToBeGenerated));
            }
            if(a==2){
                final_id = (Alphabet + "00" + Integer.toString(char_IDisToBeGenerated));
            }
            if(a==1){
                final_id = (Alphabet + "0" + Integer.toString(char_IDisToBeGenerated));
            }
            if(a==0){
                final_id = (Alphabet + Integer.toString(char_IDisToBeGenerated));
            }
        }
        //JOptionPane.showMessageDialog(null, "final_id : "+final_id);
        return final_id;
    }   
}
