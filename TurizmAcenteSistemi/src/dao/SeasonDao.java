package dao;

import core.Db;
import entity.*;


import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class SeasonDao {
    private final Connection conn;
    private final HotelDao hotelDao;
    public SeasonDao(){
        this.conn = Db.getInstance();
        this.hotelDao = new HotelDao();
    }

    public ArrayList<Season> findAll(){
        return this.selectByQuery("SELECT * FROM public.season ORDER BY season_id ASC");
    }

    public ArrayList<Season> selectByQuery(String query){
        ArrayList<Season> seasons = new ArrayList<>();
        try {
            ResultSet rs = this.conn.createStatement().executeQuery(query);
            while (rs.next()){
                seasons.add(this.match(rs));
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return seasons;
    }

    public boolean save(Season season){
        String query = "INSERT INTO public.season" +
                "(" +
                "season_strt_date," +
                "season_fnsh_date," +
                "hotel_id"+
                ")" +
                " VALUES (?,?,?)";

        try {
            PreparedStatement pr = this.conn.prepareStatement(query);
            pr.setDate(1, Date.valueOf(season.getStrt_date()));
            pr.setDate(2, Date.valueOf(season.getFnsh_date()));
            pr.setInt(3, season.getHotel_id());

            return pr.executeUpdate() != -1;
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return true;
    }

    public Season match(ResultSet rs) throws SQLException {
        Season season = new Season();
        season.setId(rs.getInt("season_id"));
        season.setStrt_date(LocalDate.parse(rs.getString("season_strt_date")));
        season.setFnsh_date(LocalDate.parse(rs.getString("season_fnsh_date")));
        season.setHotel_id(rs.getInt("hotel_id"));

        return season;
    }

    public Season getById(int id){
        Season obj = null;
        String query = "SELECT * FROM public.season WHERE season_id = ?";
        try {
            PreparedStatement pr = this.conn.prepareStatement(query);
            pr.setInt(1,id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()){
                obj = this.match(rs);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return obj;
    }
}
