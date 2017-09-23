/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myutil;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 陌上心殇
 */
public class md5 {
    String secret;
    public md5(String secret){
        this.secret=secret;
    }
    public String md5math(){
        MessageDigest md5=null;
        String value=null;
        try {
            md5=MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(md5.class.getName()).log(Level.SEVERE, null, ex);
        }
        sun.misc.BASE64Encoder baseEncoder=new sun.misc.BASE64Encoder();
        try {
            value=baseEncoder.encode(md5.digest(secret.getBytes("utf-8")));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(md5.class.getName()).log(Level.SEVERE, null, ex);
        }
        return value;
    }
}
