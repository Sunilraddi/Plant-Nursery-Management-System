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
public class verify {
    public static boolean verifyEmail(String email)
    {
        email = email.trim();
        if(email == null || email.equals(""))
            return false;       
        return email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
    }
    
    public static boolean verifyContact(String contact)
    {
        contact = contact.trim();
        if(contact == null || contact.equals(""))
            return false;        
        return contact.matches("[7-9][0-9]{9}");
    }   
    
    public static boolean verifyAlphabets(String text)
    {
        text = text.trim();
        if(text == null || text.equals(""))
            return false;        
        return text.matches("^[a-z A-Z]*$");
    } 
    
    public static boolean ComboBoxValidationfor5C2(String a, String b, String c, String d, String e){
        return (a.isEmpty()== false && b.isEmpty()==false) ||
                (a.isEmpty()== false && c.isEmpty()==false) ||
                (a.isEmpty()== false && d.isEmpty()==false) ||
                (a.isEmpty()== false && e.isEmpty()==false) ||
                (b.isEmpty()== false && c.isEmpty()==false) ||
                (b.isEmpty()== false && d.isEmpty()==false) ||
                (b.isEmpty()== false && e.isEmpty()==false) ||
                (c.isEmpty()== false && d.isEmpty()==false) ||
                (c.isEmpty()== false && e.isEmpty()==false) ||
                (d.isEmpty()== false && e.isEmpty()==false) ||
                (a.isEmpty()== false && b.isEmpty()==false && c.isEmpty()==false) ||
                (a.isEmpty()== false && b.isEmpty()==false && d.isEmpty()==false) ||
                (a.isEmpty()== false && b.isEmpty()==false && e.isEmpty()==false) ||
                (a.isEmpty()== false && c.isEmpty()==false && d.isEmpty()==false) ||
                (a.isEmpty()== false && c.isEmpty()==false && e.isEmpty()==false) ||
                (a.isEmpty()== false && d.isEmpty()==false && e.isEmpty()==false) ||
                (b.isEmpty()== false && c.isEmpty()==false && d.isEmpty()==false) ||
                (b.isEmpty()== false && c.isEmpty()==false && e.isEmpty()==false) ||
                (b.isEmpty()== false && d.isEmpty()==false && e.isEmpty()==false) ||
                (c.isEmpty()== false && d.isEmpty()==false && e.isEmpty()==false) ||
                (a.isEmpty()== false && b.isEmpty()==false && c.isEmpty()==false && d.isEmpty()==false) ||
                (a.isEmpty()== false && b.isEmpty()==false && c.isEmpty()==false && e.isEmpty()==false) ||
                (a.isEmpty()== false && b.isEmpty()==false && d.isEmpty()==false && e.isEmpty()==false) ||
                (a.isEmpty()== false && c.isEmpty()==false && d.isEmpty()==false && e.isEmpty()==false) ||
                (b.isEmpty()== false && c.isEmpty()==false && d.isEmpty()==false && e.isEmpty()==false) ||
                (a.isEmpty()== false && b.isEmpty()==false && c.isEmpty()==false && d.isEmpty()==false && e.isEmpty()==false);
    }
}
