package oblig3.oblig3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class Billettrepo {
    @Autowired
    private JdbcTemplate db;

    public List<Billett> hent(){
        String sql = "SELECT * FROM Billett";
        List<Billett> alleBilletter = db.query(sql,new BeanPropertyRowMapper(Billett.class));
        Collections.sort(alleBilletter,Billett::compareTo);
        return alleBilletter;
    }
    public void SlettBilletter(){
        String sql = "DELETE FROM Billett";
        db.update(sql);
    }

    public void Lagrebillett (Billett nyBillett) {
        String sql = "INSERT INTO Billett (Film, Fornavn, Etternavn, Telefonnr, Epost, Antall) Values(?,?,?,?,?,?)";
        db.update(sql, nyBillett.getFilm(),nyBillett.getFornavn(),nyBillett.getEtternavn(),nyBillett.getTelefonnr(),nyBillett.getEpost(),nyBillett.getAntall());

    }
}
