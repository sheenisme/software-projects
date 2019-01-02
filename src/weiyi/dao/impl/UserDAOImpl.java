package weiyi.dao.impl;  

import java.sql.*;
import java.util.*;

import weiyi.dao.*;
import weiyi.dao.vo.*;

/**
 * 构造UserDAO接口的实现类，实现对数据的增删查改
 * @author 广辉
 *
 */
public  class UserDAOImpl implements IUserDAO{  
	private Connection con;  
    private PreparedStatement stat = null;
    
    /**
     * 构造函数，设置数据库的连接对象
     * @param con
     */
    public UserDAOImpl(Connection con){  
        this.con = con;  
    } 
    
    /**
     * 向数据库中插入一个user对象
     */
    public boolean doCreate(User user)throws Exception{  
        String sql = "insert into softuser values(?,?,?,?) ";  
        stat = con.prepareStatement(sql);   
        stat.setString(1,user.getUserName());  
        stat.setString(2,user.getPassword());  
        stat.setString(3,user.getEmail());  
        stat.setString(4,user.getOthers());  
        int update = stat.executeUpdate();  
        if(update>0){  
            return true;  
        }  
        else{  
            return false;  
        }  
    } 
    
    /**
     * 查找数据库中所有的数据，返回一个List<User>对象
     */
    public List<User> findAll()throws Exception{  
        String sql = "select * from softuser";  
        stat = con.prepareStatement(sql);  
        ResultSet rs = stat.executeQuery();  
        User user = null;  
        List<User> list = new ArrayList<User>();  
        while(rs.next()){
        	//获取属性
            String userID = rs.getString(1);  
            String userName = rs.getString(2);  
            String password = rs.getString(3);
            String email = rs.getString(4); 
            String others = rs.getString(5);
            //将属性写至User对象中
            user = new User();  
            user.setUserID(userID);  
            user.setUserName(userName);
            user.setPassword(password);
            user.setEmail(email);
            user.setOthers(others);
            list.add(user);  
        }  
        return list;  
    } 
    
    /**
     * 通过名字从数据库中查找User对象并返回
     */
    public User findByName(String userName)throws Exception{  
        String sql = "select * from softuser where userName= ? ";  
        stat = con.prepareStatement(sql);  
        stat.setString(1,userName);  
        ResultSet rs = stat.executeQuery();  
        User user = null;  
        if(rs.next()){  
        	String userID = rs.getString(1);  
            String password = rs.getString(3);
            String email = rs.getString(4); 
            String others = rs.getString(5);   
            user = new User();  
            user.setUserID(userID);  
            user.setUserName(userName);
            user.setPassword(password);
            user.setEmail(email);
            user.setOthers(others);
        }  
        return user;  
    }
    
    /**
     * 从数据库中删除一个User对象对应的字段
     * @param user
     * @return
     * @throws Exception
     */
    public Boolean doRemove(User user)throws Exception{
		boolean flag = false;
		String sql = "delete from softuser where userName= ? ";
		stat = con.prepareStatement(sql); 
		stat.setString(1,user.getUserName());
		if (stat.executeUpdate() > 0) {
			flag = true;
		}
		return flag; 
    }
    
    /**
     * 通过ID从数据库中查找User对象并返回
     * @param userID
     * @return user
     * @throws Exception
     */
    public User findByUserID(String userID)throws Exception{  
        String sql = "select * from softuser where userID= ? ";  
        stat = con.prepareStatement(sql);  
        stat.setString(1,userID);  
        ResultSet rs = stat.executeQuery();  
        User user = null;  
        if(rs.next()){   
        	String userName=rs.getNString(2);
            String password = rs.getString(3);
            String email = rs.getString(4); 
            String others = rs.getString(5);   
            user = new User();  
            user.setUserID(userID);  
            user.setUserName(userName);
            user.setPassword(password);
            user.setEmail(email);
            user.setOthers(others);
        }  
        return user;  
    }
    
    /**
     * 修改数据库中一个User对象对应的字段
     * @param user
     * @return
     * @throws Exception
     */
    public Boolean doUpdate(User user)throws Exception{
    	Boolean flag=false;
    	String sql = "update softuser set password=?,email=?,others=? where userName=?";  
        stat = con.prepareStatement(sql);   
        stat.setString(1,user.getPassword());  
        stat.setString(2,user.getEmail());  
        stat.setString(3,user.getOthers());  
        stat.setString(4,user.getUserName()); 
        if(stat.executeUpdate()>0) {
        	flag=true;
        }
		return flag;
    }
    
    /**
     * 通过邮箱查找用户名并返回
     * @param user
     * @return
     * @throws Exception
     */
    public String getUserName(User user)throws Exception{
    	String sql = "select userName from softuser where email= ? ";  
        stat = con.prepareStatement(sql);  
        stat.setString(1,user.getEmail());  
        ResultSet rs = stat.executeQuery();   
        if(rs.next()){  
        	return rs.getString(1);
        }  
        return "";  
    }
}