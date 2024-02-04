package business;

import core.Helper;
import dao.HotelDao;
import entity.Hotel;

import java.util.ArrayList;

public class HotelManager {

    private final HotelDao hotelDao;

    // Belirtilen ID'ye sahip oteli getiren metod
    public Hotel getByID(int id){return this.hotelDao.getById(id);}

    // Bütün otelleri getiren metod
    public ArrayList<Hotel> findAll() {return this.hotelDao.findAll();}

    // Otelleri tabloya uygun formatta getiren metod
    public ArrayList<Object[]> getForTable(int size, ArrayList<Hotel> hotelList){
        ArrayList<Object[]> hotelObjList = new ArrayList<>();
        for (Hotel obj : hotelList){
            int i = 0;
            Object[] rowObject = new Object[size];
            rowObject[i++] = obj.getId();
            rowObject[i++] = obj.getHotel_name();
            rowObject[i++] = obj.getHotel_star();
            rowObject[i++] = obj.getHotel_city();
            rowObject[i++] = obj.getHotel_region();
            rowObject[i++] = obj.getHotel_address();
            rowObject[i++] = obj.getHotel_mail();
            rowObject[i++] = obj.getHotel_mpno();
            rowObject[i++] = obj.getHotel_features_carpark();
            rowObject[i++] = obj.getHotel_features_wifi();
            rowObject[i++] = obj.getHotel_features_pool();
            rowObject[i++] = obj.getHotel_features_fitness();
            rowObject[i++] = obj.getHotel_features_concierge();
            rowObject[i++] = obj.getHotel_features_spa();
            rowObject[i++] = obj.getHotel_features_room_service();
            hotelObjList.add(rowObject);
        }
        return hotelObjList;
    }

    public HotelManager(){
        this.hotelDao = new HotelDao();
    }

    // Yeni bir otel kaydı ekleyen metod
    public boolean save(Hotel hotel){
        if (this.getByID(hotel.getId()) != null){
            Helper.showMsg("error");
            return false;
        }
        return this.hotelDao.save(hotel);
    }
}
