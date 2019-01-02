package weiyi.dao;  
import java.util.List; 
import weiyi.dao.vo.User;

/**
 * 定义UserDAO接口：IUserDAO
 * @author 广辉
 */
public interface IUserDAO{  
    public boolean doCreate(User user)throws Exception;  
    public List<User> findAll()throws Exception;  
    public User findByName(String userName)throws Exception;
    public Boolean doRemove(User user)throws Exception;
    public Boolean doUpdate(User user)throws Exception;
    public String getUserName(User user)throws Exception;
    public User findByUserID(String userID)throws Exception;
}  