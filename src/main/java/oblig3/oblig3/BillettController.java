package oblig3.oblig3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@RestController
public class BillettController {
    @Autowired
    private JdbcTemplate db;


    @PostMapping ("/Lagre")
    public void Lagrebillett (Billett nyBillett) {
        String sql = "INSERT INTO Billett (Film, Fornavn, Etternavn, Telefonnr, Epost, Antall) Values(?,?,?,?,?,?)";
        db.update(sql, nyBillett.getFilm(),nyBillett.getFornavn(),nyBillett.getEtternavn(),nyBillett.getTelefonnr(),nyBillett.getEpost(),nyBillett.getAntall());

    }
    @GetMapping("/HentBilletter")
    public List <Billett> hent(){
        String sql = "SELECT * FROM Billett";
        List<Billett> alleBilletter = db.query(sql,new BeanPropertyRowMapper(Billett.class));
        Collections.sort(alleBilletter,Billett::compareTo);
        return alleBilletter;
    }

    @GetMapping("/SlettBilletter")
    public void SlettBilletter(){
    String sql = "DELETE FROM Billett";
    db.update(sql);

    }




}
