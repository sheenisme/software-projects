package weiyi.dao.factory;

import weiyi.dao.IUserDAO;
import weiyi.dao.proxy.UserDAOProxy;  
public class DAOFactory{  
    public static IUserDAO getEmail( ){  
        IUserDAO dao = null;  
        try{  
            dao = new UserDAOProxy();      
        }  
        catch(Exception e){  
            e.printStackTrace();  
        }  
        return dao;  
    }  
}  