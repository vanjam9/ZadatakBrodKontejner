package model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by androiddevelopment on 20.1.17..
 */

@DatabaseTable(tableName = "brod")
public class Brod {

    public static final String POLJE_OZNAKA="oznaka";
    public static final String POLJE_NAZIV="naziv";

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "oznaka")
    private String oznaka;

    @DatabaseField(columnName = "naziv")
    private String naziv;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOznaka() {
        return oznaka;
    }

    public void setOznaka(String oznaka) {
        this.oznaka = oznaka;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public ForeignCollection<Kontejner> getKontejner() {
        return kontejner;
    }

    public void setKontejner(ForeignCollection<Kontejner> kontejner) {
        this.kontejner = kontejner;
    }

    @ForeignCollectionField(foreignFieldName = "brod")

    private ForeignCollection<Kontejner> kontejner;

    public Brod(String oznaka, String naziv) {
        this.oznaka = oznaka;
        this.naziv = naziv;
    }

    public Brod() {

    }
    @Override
    public String toString() {
        return "Brod{" +
                "id=" + id +
                ", oznaka=" + oznaka +
                ", naziv='" + naziv + '\'' +
                '}';
    }

}
