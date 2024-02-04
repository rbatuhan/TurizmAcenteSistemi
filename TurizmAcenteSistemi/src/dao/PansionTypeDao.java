package dao;

import core.Db;
import entity.Hotel;
import entity.PansionType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PansionTypeDao {
    private final Connection conn;
    public PansionTypeDao(){this.conn = Db.getInstance();}

    // Belirli bir ID'ye sahip pansion tipini getiren metot.
    public PansionType getById(int id) {
        PansionType obj = null;
        String query = "SELECT * FROM public.pansion_type WHERE pansion_id = ?";
        try {
            PreparedStatement pr = this.conn.prepareStatement(query);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) obj = this.match(rs);
        }catch (Exception throwables){
            throwables.printStackTrace();
        }
        return obj;
    }

    // Tüm pansion tiplerini getiren metot.
    public ArrayList<PansionType> findAll(){
        return this.selectByQuery("SELECT * FROM public.pansion_type ORDER BY pansion_id ASC");
    }

    // Belirli bir query sorgusuna göre pansion tiplerini getiren metot.
    public ArrayList<PansionType> selectByQuery(String query){
        ArrayList<PansionType> pansionTypeList = new ArrayList<>();
        try {
            ResultSet rs = this.conn.createStatement().executeQuery(query);
            while (rs.next()){
                pansionTypeList.add(this.match(rs));
            }
        }catch (Exception throwables){
            throwables.printStackTrace();
        }
        return pansionTypeList;
    }

    // ResultSet'ten PansionType nesnesine eşleme yapan metot.
    public PansionType match(ResultSet rs) throws Exception{
        PansionType obj = new PansionType();
        obj.setId(rs.getInt("pansion_id"));
        obj.setPansionType(rs.getString("pansion_type"));
        obj.setHotelId(rs.getInt("hotel_id"));
        return obj;
    }

    // Yeni bir pansion tipi ekleyen metot.
    public boolean save(PansionType pansionType){
        String query = "INSERT INTO public.pansion_type " +
                "(" +
                "pansion_type, " +
                "hotel_id" +
                ")" +
                " VALUES (?,?)";
        try {
            PreparedStatement pr = this.conn.prepareStatement(query);
            pr.setString(1, pansionType.getPansionType());
            pr.setInt(2, pansionType.getHotelId());
            return pr.executeUpdate() != -1;
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return true;
    }
}
