/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabean;

/**
 *
 * @author 陌上心殇
 */
public class TimeBean {

    //更新上下线消息时间
    public boolean Update(String username,String time, String type) {
        boolean isUpdate=false;
        DBAccessBean db = new DBAccessBean();
        if (db.createConn()) {
            if ("ontime".equals(type)) {
                String sql = "update time set ontime='" + time + "'where username='"+username+"' ";
                db.updata(sql);
                db.closeStmt();
                db.closeConn();
                isUpdate=true;
            } else if ("downtime".equals(type)) {
                String sql = "update time set downtime='" + time + "'where username='"+username+"'";
                db.updata(sql);
                db.closeStmt();
                db.closeConn();
                isUpdate=true;
            }
        }
        return isUpdate;
    }

    //为新用户增加上下线时间表
    public void Add(String name, String ontime, String downtime) {
        DBAccessBean db = new DBAccessBean();
        if (db.createConn()) {
            String sql = "insert into time ( username , ontime , downtime ) values ('" + name + "','" + ontime + "','" + downtime + "')";
            db.updata(sql);
            db.closeStmt();
            db.closeConn();
        }
    }
    
    //查询下线时间
    public String ontimeSelect(String name){
        String ontime="";
        DBAccessBean db = new DBAccessBean();
        if(db.createConn()){
            String sql="select ontime from time where username = '"+name+"'";
            db.query(sql);
            if(db.next())
            ontime=db.getValue("ontime");
            db.closeRs();
            db.closeStmt();
            db.closeConn();
        }
       return ontime; 
    }
    
    //查询下线时间
    public String downtimeSelect(String name){
        String downtime="";
        DBAccessBean db = new DBAccessBean();
        if(db.createConn()){
            String sql="select downtime from time where username = '"+name+"'";
            db.query(sql);
            if(db.next())
            downtime=db.getValue("downtime");
            db.closeRs();
            db.closeStmt();
            db.closeConn();
        }
       return downtime; 
    }
}
