package main;

import apresentacao.TelaLogin;
import br.univates.system32.app.Application;
import br.univates.system32.app.ApplicationProcess;
import br.univates.system32.app.FatalSystemException;
import br.univates.system32.db.DataBaseException;
import java.io.IOException;


public class SistemaFarmacia extends Application {

    private static SistemaFarmacia sys = new SistemaFarmacia();

    public static SistemaFarmacia getInstance() {
        return sys;
    }

    private SistemaFarmacia() {
        super("SistemaFarmacia", "sistemafarmacia");
    }

    @Override
    public void defineFirstExecutionProcesses() {
        this.addFirstExecutionProcess(new ApplicationProcess("Criando esquema do banco de dados.") {
            @Override
            public void run() throws FatalSystemException {
                createDataBaseSchemaGenerationProcess("/resources/script/sql.sql");
            }
        });
    }

    @Override
    public void defineInitialProcesses() {
        this.addInitialProcess(new ApplicationProcess("Abrindo a tela de login.") {
            @Override
            public void run() throws FatalSystemException {
                try {
                    TelaLogin tela = new TelaLogin();
                    tela.setVisible(true);
                } catch (DataBaseException | IOException ex) {
                    System.out.println("erro " + ex.getMessage());
                }
            }
        });
    }

    @Override
    public void defineFinalProcesses() {
        System.exit(0);
    }

}
