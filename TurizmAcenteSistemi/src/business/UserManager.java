package business;

import core.Helper;
import dao.UserDao;
import entity.User;

import java.util.ArrayList;

public class UserManager {
    private final UserDao userDao;

    public User getById(int id) {
        return this.userDao.getById(id);
    }

    public ArrayList<User> findAll() {return this.userDao.findAll();}

    public ArrayList<Object[]>getForTable(int size, ArrayList<User> userList){
        ArrayList<Object[]> userObjList = new ArrayList<>();
        for (User obj : userList){
            int i = 0;
            Object[] rowObject = new Object[size];
            rowObject[i++] = obj.getId();
            rowObject[i++] = obj.getUsername();
            rowObject[i++] = obj.getPassword();
            rowObject[i++] = obj.getRole();
            userObjList.add(rowObject);
        }
        return userObjList;
    }

    public UserManager(){
        this.userDao = new UserDao();
    }

    public User findByLogin(String username, String password){
        return this.userDao.findByLogin(username, password);
    }

    public ArrayList<User> findByRole(String userSearchRole){
        return this.userDao.findByRole(userSearchRole);
    }

    public boolean save(User user){
        if (this.getById(user.getId()) != null){
            Helper.showMsg("error");
            return false;
        }
        return this.userDao.save(user);
    }

    public boolean update(User user){
        if (this.getById(user.getId()) == null){
            Helper.showMsg(user.getId() + "ID kayıtlı kullanıcı bulunamadı");
            return false;
        }
        return this.userDao.update(user);
    }

    public boolean delete(int id){
        if (this.getById(id) == null){
            Helper.showMsg(id + " ID kayıtlı kullanıcı bulunamadı");
            return false;
        }
        return this.userDao.delete(id);
    }

    public User getByListUserId(int userId){
        return this.userDao.getById(userId);
    }


}