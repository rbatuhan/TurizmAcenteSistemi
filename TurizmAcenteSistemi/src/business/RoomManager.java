package business;

import core.Helper;
import dao.RoomDao;
import entity.Hotel;
import entity.Room;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RoomManager {
    private final RoomDao roomDao;

    public RoomManager() {
        this.roomDao = new RoomDao();
    }

    // ID'ye göre oda getiren metot.
    public Room getByID(int id) {
        return this.roomDao.getById(id);
    }

    // Tüm odaları getiren metot.
    public ArrayList<Room> findAll() {
        return this.roomDao.findAll();
    }

    // Tablo için oda bilgilerini düzenleyen metot.
    public ArrayList<Object[]> getForTable(int size, ArrayList<Room> roomList) {
        ArrayList<Object[]> roomObjList = new ArrayList<>();
        for (Room obj : roomList) {
            int i = 0;
            Object[] rowObject = new Object[size];
            rowObject[i++] = obj.getId();
            rowObject[i++] = obj.getRoom_type();
            rowObject[i++] = obj.getRoom_stock();
            rowObject[i++] = obj.getSeason_id();
            rowObject[i++] = obj.getRoom_adult_prc();
            rowObject[i++] = obj.getRoom_child_prc();
            rowObject[i++] = obj.getHotel().getHotel_name();
            rowObject[i++] = obj.getPansionType().getPansionType();
            rowObject[i++] = obj.getRoom_square_meter();
            rowObject[i++] = obj.getRoom_number_bed();
            rowObject[i++] = obj.getRoom_tv();
            rowObject[i++] = obj.getRoom_minibar();
            rowObject[i++] = obj.getRoom_game_console();
            rowObject[i++] = obj.getRoom_kasa();
            rowObject[i++] = obj.getRoom_projection();

            roomObjList.add(rowObject);
        }
        return roomObjList;
    }

    // Yeni bir oda ekleyen metot.
    public boolean save(Room room) {
        if (this.getByID(room.getId()) != null) {
            Helper.showMsg("error");
            return false;
        }
        return this.roomDao.save(room);
    }

    // Oda silen metot.
    public boolean delete(int id){
        if (this.getByID(id) == null){
            Helper.showMsg(id + " ID kayıtlı kullanıcı bulunamadı");
            return false;
        }
        return this.roomDao.delete(id);
    }

    // Tabloda oda arama işlemini gerçekleştiren metot.
    public ArrayList<Room> searchForTable(String hotel_name, String hotel_city, String strt_date,
                                          String fnsh_date, int adultCount, int childCount) {
        ArrayList<String> searchRoomQuery = new ArrayList<>();
        String query = "SELECT * FROM public.room r " +
                "JOIN public.hotel AS h ON r.hotel_id = h.hotel_id " +
                "LEFT JOIN season s ON r.season_id = s.season_id WHERE ";

        searchRoomQuery.add(" r.room_stock > " + 0);
        searchRoomQuery.add(" AND r.room_number_bed >= " + (adultCount + childCount));
        if (!strt_date.equals("    /  /  ")){
            searchRoomQuery.add(" AND s.season_strt_date <= '" + strt_date + "'");
        }
        if (!fnsh_date.equals("    /  /  ")){
            searchRoomQuery.add(" AND s.season_fnsh_date >= '" + fnsh_date + "'");
        }
        if (hotel_name != null) {
            searchRoomQuery.add(" AND LOWER(h.hotel_name) LIKE LOWER('%" + hotel_name + "%')");
        }
        if (hotel_city != null) {
            searchRoomQuery.add(" AND LOWER(h.hotel_city) LIKE LOWER('%" + hotel_city + "%')");
        }

        query += String.join("", searchRoomQuery);
        ArrayList<Room> resultQuery = this.roomDao.selectByQuery(query);
        return resultQuery;
    }
}