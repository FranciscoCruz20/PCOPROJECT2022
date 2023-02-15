package domain;

import view.Menu;

import java.io.IOException;
import java.util.Scanner;

public class UtilizadorTMACreator {

    /**
     * Método responsável pela criação de objetos do tipo UtilziadorTMA
     * @return utilziadortma
     * @throws IOException
     */
    public static UtilizadorTMA criar_utilizadortma(String username, int pcc, int hcmid, String gds) throws IOException {
        UtilizadorTMA utilTMA = new UtilizadorTMA(username, pcc, hcmid, gds, UtilizadorTMA.data_criacao, UtilizadorTMA.data_ultima_alteracao, UtilizadorTMA.estado);
        HandlerUC06.confirmar_criacao_tma(utilTMA);
        return new UtilizadorTMA(username, pcc, hcmid, gds, UtilizadorTMA.data_criacao, UtilizadorTMA.data_ultima_alteracao, UtilizadorTMA.estado);
    }
}
