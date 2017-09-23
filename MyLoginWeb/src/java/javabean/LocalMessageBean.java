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
public class LocalMessageBean {
    
    //插入消息记录
    public void Add(String username, String time, String message) {
        DBAccessBean db = new DBAccessBean();
        if (db.createConn()) {
            String sql = "insert into localmessage(username , time , message)values('" + username + "','" + time + "','" + message + "')";
            db.updata(sql);
            db.closeStmt();
            db.createConn();
        }
    }
    
    //查询离线消息记录
    public String[][] offRecord(String ontime,String downtime){
        DBAccessBean db = new DBAccessBean();
        String[][] str=new String[100][2];
        if(db.createConn()){
            String sql = "select * from localmessage where time>'"+downtime+"' and time<'"+ontime+"'";
            int i=0;
            db.query(sql);
            System.out.println("查询语句已执行。。。。。。。。。。。。。");
            while(db.next()){
                System.out.println("进入结果集");
                str[i][0] = db.getValue("username");
                str[i][1] = db.getValue("message");
                System.out.println("1111111111111"+str[i][0]);
                System.out.println("1111111111111"+str[i][1]);
                i++;
            }
            db.closeRs();
            db.closeStmt();
            db.closeConn();
        }
        return str;
    }
}
