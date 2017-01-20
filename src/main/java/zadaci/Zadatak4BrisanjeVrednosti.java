package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import model.Brod;
import model.Kontejner;

import java.io.IOException;
import java.util.List;

/**
 * Created by androiddevelopment on 20.1.17..
 */
public class Zadatak4BrisanjeVrednosti {




    static Dao<Brod,Integer> brodDao;
    static Dao<Kontejner,Integer>kontejnerDao;
    public static void main(String[] args) {
        ConnectionSource connectionSource = null;
        try {

            connectionSource = new JdbcConnectionSource("jdbc:sqlite:brodKontejner.db");
            brodDao= DaoManager.createDao(connectionSource,Brod.class);
            kontejnerDao=DaoManager.createDao(connectionSource,Kontejner.class);

            Kontejner ZaBrisanje = kontejnerDao.queryForId(k1.getId());
            kontejnerDao.delete(ZaBrisanje);

            List<Kontejner> kontejner = kontejnerDao.queryForAll();
            for (Kontejner k : kontejner)
                System.out.println(k);

            Kontejner KP2ZaBrisanje = kontejnerDao.queryForId(k2.getId());
            kontejnerDao.delete(KP2ZaBrisanje);

            List<Kontejner> kontejner1 = kontejnerDao.queryForAll();
            for (Kontejner k : kontejner1)
                System.out.println(k);

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (connectionSource != null) {
                try {
                    connectionSource.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
