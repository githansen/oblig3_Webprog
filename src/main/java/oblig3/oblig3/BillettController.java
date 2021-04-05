package oblig3.oblig3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
public class BillettController {

    @Autowired
    Billettrepo rep;



    @PostMapping ("/Lagre")
    public void Lagrebillett (Billett nyBillett) {
      rep.Lagrebillett(nyBillett);
    }
    @GetMapping("/HentBilletter")
    public List <Billett> hent(){
        return rep.hent();
    }

    @GetMapping("/SlettBilletter")
    public void SlettBilletter(){
    rep.SlettBilletter();

    }




}
