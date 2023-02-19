package app;

import view.Menu;
import java.io.IOException;

/**
 * Classe responsável pelo arranque do sistema
 */
public class TMAManager {

    /**
     * Método main da aplicação
     * Arranque do sistema
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Menu.menu_inicial();
    }
}
