/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import config.Constant;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author ETDelacruz
 */
public class Password implements Constant {
    
    public Password(){
    
    }
 
    public boolean validatePassword(){
        return false;
    }
    
    public static String getEncryptedPw(String pw){
    
        String generatedPassword = null;
        StringBuilder sb = new StringBuilder();
        
        try {
            MessageDigest md = MessageDigest.getInstance(HASH_ALGO);
            md.update(pw.getBytes());
            byte[] bytes = md.digest();
            
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } 
        catch (NoSuchAlgorithmException e) 
        {
            e.printStackTrace();
        }
        return generatedPassword;
        
    }
    
    
}
