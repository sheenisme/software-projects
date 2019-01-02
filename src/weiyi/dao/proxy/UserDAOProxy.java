package weiyi.dao.proxy; 

import weiyi.MD5.EncryptImp;
import weiyi.dao.*;  
import weiyi.dao.vo.*;   
import weiyi.dao.dbc.*;
import weiyi.dao.impl.UserDAOImpl;

import java.util.*; 

/**
 * 创建代理类，将对数据库操作的类进行封装
 * @author 广辉
 *
 */
public class UserDAOProxy implements IUserDAO{  
    private DatabaseConnection dbc;  
    private IUserDAO dao = null; 
    
    /**
     * 构造函数，初始化数据库连接
     * @throws Exception
     */
    public UserDAOProxy()throws Exception{  
        dbc = new DatabaseConnection();  
        dao = new UserDAOImpl(dbc.getConnection());  
    } 
    
    /**
     * 插入数据
     */
    public boolean doCreate(User user)throws Exception{  
        boolean flag = false;  
        if(dao.findByName(user.getUserName())==null){  
            flag = dao.doCreate(user);  
        }  
        dbc.close();  
        return flag;  
    } 
    
    /**
     * 查找数据库中所有数据
     */
    public List<User> findAll()throws Exception{  
    	List<User>list = dao.findAll();  
        dbc.close();  
        return list;  
    } 
    
    /**
     * 根据username从数据库中查找User对象并返回
     */
    public User findByName(String userName)throws Exception {  
        User user = dao.findByName(userName);  
        dbc.close();  
        return user;  
    }
    
    /**
     * 根据userID从数据库中查找User对象并返回
     */
    public User findByUserID(String userID)throws Exception {  
        User user = dao.findByUserID(userID);  
        dbc.close();  
        return user;  
    }
    
    /**
     * 删除一个字段
     */
    public Boolean doRemove(User user)throws Exception {
    	boolean result=dao.doRemove(user);
    	dbc.close();
    	return result;
    }
    
    /**
     * 修改一个字段
     */
	public Boolean doUpdate(User user) throws Exception {
		boolean result=dao.doUpdate(user);
    	dbc.close();
    	return result;
	}
	
    /**
     * 通过邮箱查找用户名
     */
    public String getUserName(User user)throws Exception {
    	String username=dao.getUserName(user);
    	dbc.close();
    	return username;
    }
    
    /**
     * 调用MD5包中的类，实现对某一个字符串进行MD5加密，封装加密的细节
     * @param password
     * @return String
     */
    public String getMD5(String password) {
    	//调用MD5包进行加密
		EncryptImp ei=new EncryptImp();
		return ei.md5(password);
    }
}  