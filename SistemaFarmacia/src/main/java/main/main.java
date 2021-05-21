package main;


import br.univates.system32.db.DataBaseException;
import br.univates.system32.db.DuplicateKeyException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class main {

    public static void main(String[] args) throws DataBaseException, DuplicateKeyException, NoSuchAlgorithmException, UnsupportedEncodingException {
        SistemaFarmacia s = SistemaFarmacia.getInstance();  
        
        //s.setSplashPath("images/icone.png");
        s.start();

    }
}
