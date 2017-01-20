package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import model.Brod;
import model.Kontejner;

import java.io.IOException;
import java.util.List;

/**
 * Created by androiddevelopment on 20.1.17..
 */
public class Zadatak3IzmenaVre4dnosti {




    static Dao<Brod,Integer> brodDao;
    static Dao<Kontejner,Integer>kontejnerDao;
    public static void main(String[] args) {


        ConnectionSource connectionSource = null;
        try {

            connectionSource = new JdbcConnectionSource("jdbc:sqlite:brodKontejner.db");

            brodDao= DaoManager.createDao(connectionSource,Brod.class);
            kontejnerDao=DaoManager.createDao(connectionSource,Kontejner.class);



            TableUtils.clearTable(connectionSource, Brod.class);
            TableUtils.clearTable(connectionSource, Kontejner.class);


            Brod b1 = new Brod("Brod1","Transporter1");
            brodDao.create(b1);

            Kontejner k3=new Kontejner("KP3","Morski proizvodi",200.7);
            k3.setBrod(b1);
            kontejnerDao.create(k3);

            List<Kontejner> kontejner = kontejnerDao.queryForAll();
            for (Kontejner k : kontejner)
                System.out.println(k);


            Kontejner izmena = kontejnerDao.queryForId(k3.getId());
            izmena.setOpis("Plodovi mora");
            kontejnerDao.update(izmena);

            List<Kontejner> kontejneri = kontejnerDao.queryForAll();
            for (Kontejner k1 : kontejneri)
                System.out.println(k1);

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
