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
import java.sql.*;
public class DBAccessBean {
    private String drv="com.mysql.jdbc.Driver";
    private String url="jdbc:mysql://localhost:3306/Login";
    private String user="root";
    private String pwd="1996";
    private Connection conn=null;//数据库连接对象
    private Statement stmt=null; //SQL语句的声明对象
    private ResultSet rs=null;  //结果集对象 
    
    public String getDrv() {
        return drv;
    }

    public void setDrv(String drv) {
        this.drv = drv;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public Statement getStmt() {
        return stmt;
    }

    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }
    
    public boolean createConn(){   //创建数据库连接
        boolean b=false;
        try{
            Class.forName(drv).newInstance();
            conn=DriverManager.getConnection(url, user, pwd);
            b=true;
        }catch(SQLException e){e.printStackTrace();}
         catch(ClassNotFoundException e){e.printStackTrace();}
         catch(InstantiationException e){e.printStackTrace();}
         catch(IllegalAccessException e){e.printStackTrace();}
        return b;
    }
    
    public boolean updata(String sql){   //更新数据库
        boolean b=false;
        try{
            stmt=conn.createStatement();
            stmt.execute(sql);
            b=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return b;
    }
    
    public void query(String sql){    //获取结果集
        try{
            stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public boolean next(){   //移到下一条记录
        boolean b=false;
        try{
            if(rs.next())
                b=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return b;
    }
    
    public String getValue(String field){    //获取当前记录字段field的值
        String value=null;
        try{
            if(rs!=null)
                value=rs.getString(field);
        }catch(Exception e){
            e.printStackTrace();
        }
        return value;
    }
    
    public void closeConn(){//关闭数据库连接
        try{
            if(conn!=null)
                conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void closeStmt(){  //关闭SQL语句对象
        try{
            if(stmt!=null)
                conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
     public void closeRs(){  //销毁结果集 
        try{
            if(rs!=null)
                conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
