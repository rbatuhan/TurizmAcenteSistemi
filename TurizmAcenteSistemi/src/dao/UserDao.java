package dao;

import core.Db;
import entity.User;

import java.sql.*;
import java.util.ArrayList;

public class UserDao {
    private final Connection conn; // Veritabanı bağlantısı


    public UserDao() {
        this.conn = Db.getInstance(); // Veritabanı bağlantısını çalıştıran constructur
    }

    //Kullanıcı ID'sine göre kullanıcı bilgisini getiren metot.
    public User getById(int id) {
        User obj = null;
        String query = "SELECT * FROM public.user WHERE user_id = ?";
        try {
            PreparedStatement pr = this.conn.prepareStatement(query);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()){
                obj = this.match(rs);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return obj;
    }

    // Tüm kullanıcıları getiren metot.
    public ArrayList<User> findAll(){
        ArrayList<User> userList = new ArrayList<>();
        return this.selectByQuery("SELECT * FROM public.user ORDER BY user_id ASC");

    }

    // Belirli bir roldeki kullanıcıları getiren metot.
    public ArrayList<User> findByRole(String userSearchRole){
        ArrayList<User> userList = new ArrayList<>();
        String query = "SELECT * FROM public.user WHERE user_role=" + "'"+userSearchRole+"'";
        try {

            ResultSet rs = this.conn.createStatement().executeQuery(query);

            while (rs.next()){
                userList.add(this.match(rs));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return userList;
    }
    // Verilen query sorgusuna göre kullanıcıları getiren genel metot.
    public ArrayList<User> selectByQuery(String query){
        ArrayList<User> userList = new ArrayList<>();
        try {
            ResultSet rs = this.conn.createStatement().executeQuery(query);
            while (rs.next()){
                userList.add(this.match(rs));
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return userList;
    }

    // Kullanıcı adı ve şifre ile giriş yapan kullanıcıyı getiren metot.
    public User findByLogin(String username, String password){
        User obj = null;
        String query = "SELECT * FROM public.user WHERE user_name = ? AND user_password = ?";
        try {
            PreparedStatement pr = this.conn.prepareStatement(query);
            pr.setString(1,username);
            pr.setString(2,password);
            ResultSet rs = pr.executeQuery();
            if (rs.next()){
                obj = this.match(rs);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return obj;
    }

    // Yeni bir kullanıcı ekleyen metot.
    public boolean save(User user) {
        String query = "INSERT INTO public.user " +
                "(" +
                "user_name," +
                "user_password," +
                "user_role" +
                ")" +
                " VALUES (?,?,?)";
        try {
            PreparedStatement pr = this.conn.prepareStatement(query);
            pr.setString(1, user.getUsername());
            pr.setString(2, user.getPassword());
            pr.setString(3, user.getRole());

            return pr.executeUpdate() != -1;

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return true;
    }

    // Kullanıcı bilgilerini güncelleyen metot.
    public boolean update(User user){
        String query = "UPDATE public.user SET " +
                "user_name = ?, " +
                "user_password = ?, " +
                "user_role = ? " +
                " WHERE user_id = ?";
        try {
            PreparedStatement pr = this.conn.prepareStatement(query);
            pr.setString(1, user.getUsername());
            pr.setString(2, user.getPassword());
            pr.setString(3, user.getRole());
            pr.setInt(4, user.getId());
            return pr.executeUpdate() != -1;
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return true;
    }

    //Seçili ID'ye sahip kullanıcıyı silen metot.
    public boolean delete(int id){
        String query = "DELETE FROM public.user WHERE user_id = ?";
        try {
            PreparedStatement pr = this.conn.prepareStatement(query);
            pr.setInt(1, id);
            return pr.executeUpdate() != -1;
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return true;
    }

    // ResultSet'ten alınan verilerle bir kullanıcı nesnesi oluşturan metot.
    public  User match(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("user_id"));
        user.setUsername(rs.getString("user_name"));
        user.setPassword(rs.getString("user_password"));
        user.setRole(rs.getString("user_role"));

        return user;
    }

}