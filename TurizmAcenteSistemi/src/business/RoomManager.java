package business;

import core.Helper;
import dao.RoomDao;
import entity.Hotel;
import entity.Room;

import java.time.LocalDate;
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

    // Tabloda oda arama işlemini gerçekleştiren metot.
    public ArrayList<Room> searchForTable(String hotel_name, String hotel_city, String strt_date, String fnsh_date,
                                          int adult_count, int child_count) {

        ArrayList<String> querys = new ArrayList<>();
        ArrayList<Room> result = new ArrayList<>();

        if (hotel_name.isBlank()) {
            querys.add(" SELECT * FROM public.room r  LEFT JOIN public.hotel h ON r.hotel_id = h.hotel_id" +
                    " WHERE h.hotel_name ILIKE '%" + hotel_name + "%'");
        }
        if (hotel_city.isBlank()) {
            querys.add(" SELECT * FROM public.room r  LEFT JOIN public.hotel h ON r.hotel_id = h.hotel_id" +
                    " WHERE h.hotel_city ILIKE '%" + hotel_city + "%'");
        }
        //if (strt_date.isBlank()) {
        //    querys.add(" SELECT * FROM public.room r  LEFT JOIN public.season s ON r.season_id = s.season_id" +
        //            " WHERE AND s.season.strt_date >= '" + strt_date);
       // }
       // if (fnsh_date.isBlank()) {
       //     querys.add(" SELECT * FROM public.room r  LEFT JOIN public.season s ON r.season_id = s.season_id " +
        //            " WHERE s.season.fnsh_date <= '" + strt_date);
        //}
        //if (adult_count >= 0) {
        //    querys.add(" ");
       // }
       // if (child_count >= 0) {
        //    querys.add(" ");
       // }

        for (String s : querys) {
            result.addAll(roomDao.selectByQuery(s));
        }

        return result;
    }
}