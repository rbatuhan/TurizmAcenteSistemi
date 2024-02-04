package business;

import core.Helper;
import dao.PansionTypeDao;
import dao.SeasonDao;
import entity.PansionType;
import entity.Season;

import java.util.ArrayList;

public class SeasonManager {
    private final SeasonDao seasonDao;

    // ID'ye göre sezon getiren metot.
    public Season getById(int id){
        return this.seasonDao.getById(id);
    }

    // Tüm sezonları getiren metot.
    public ArrayList<Season> findAll() {return this.seasonDao.findAll();}

    // Tablo için sezon bilgilerini düzenleyen metot.
    public ArrayList<Object[]> getForTable(int size, ArrayList<Season> seasonList) {
        ArrayList<Object[]> seasonObjList = new ArrayList<>();
        for (Season obj : seasonList) {
            int i = 0;
            Object[] rowObject = new Object[size];
            rowObject[i++] = obj.getId();
            rowObject[i++] = obj.getStrt_date().toString();
            rowObject[i++] = obj.getFnsh_date().toString();
            rowObject[i++] = obj.getHotel_id();
            seasonObjList.add(rowObject);
        }
        return seasonObjList;
    }

    public SeasonManager(){
        this.seasonDao = new SeasonDao();
    }

    // Yeni bir sezon ekleyen metot.
    public boolean save(Season season){
        if (this.getById(season.getId()) != null){
            Helper.showMsg("error");
            return false;
        }
        return this.seasonDao.save(season);
    }
}
