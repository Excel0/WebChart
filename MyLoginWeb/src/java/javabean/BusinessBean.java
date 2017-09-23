/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabean;
import myutil.md5;

/**
 *
 * @author 陌上心殇
 */
public class BusinessBean {

    public boolean valid(String username, String password) {   //登录验证
        boolean isValid = false;
        DBAccessBean db = new DBAccessBean();
        md5 secret=new md5(password);
        String ps=secret.md5math();
        if (db.createConn()) {
            String sql = "select * from user where username='" + username + "'and password='" + ps + "'";
            db.query(sql);
            if (db.next()) {
                isValid = true;
            }
            db.closeRs();
            db.closeStmt();
            db.closeConn();
        }
        return isValid;
    }

    public boolean isExist(String username) {  //检查用户是否存在
        boolean isExist = false;
        DBAccessBean db = new DBAccessBean();
        if (db.createConn()) {
            String sql = "select * from user where username='" + username + "'";
            db.query(sql);
            if (db.next()) {
                isExist = true;
            }
            db.closeRs();
            db.closeStmt();
            db.closeConn();
        }
        return isExist;
    }

    public void add(String username, String password, String email) {
        DBAccessBean db = new DBAccessBean();
        md5 secret=new md5(password);
        String ps=secret.md5math();
        if (db.createConn()) {
            String sql = "insert into user(username , password , email)values('" + username + "','" + ps + "','" + email + "')";
            db.updata(sql);
            db.closeStmt();
            db.closeConn();
        }
    }
}
