package domain;

import domain.Administrador;
import domain.Cliente;
import domain.Licenca;
import view.Menu;

import java.io.IOException;
import java.util.*;

public class Main {

    static Cliente cli = new Cliente("","",000000000,000000000,"","","","","");
    static Utilizador util = new Utilizador("nome", "email", "", "");
    static ArrayList<Utilizador> utilizadores = new ArrayList<Utilizador>();
    static ArrayList<Cliente> clientes = new ArrayList<>();
    static Administrador admin = new Administrador("admin", "password");
    static Licenca lic = new Licenca(null,"Inátiva",null,null,false,false,100,null);
    static UtilizadorTMA utilTMA = new UtilizadorTMA("", 0,0,"",null,null,"",false);
    static Pool p = new Pool("", 0,null,null,"",0,false,false,0,null,null,0);

    //domain.Main:
    //Para aceder como admin:
    //Username: admin
    //Password: 12345
    public static void main(String[] args) throws IOException {
        Menu.menu_inicial();
    }

}







