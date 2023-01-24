package domain;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;

public class Administrador {

    //Atributos
    private String username;
    private String password;
    private ArrayList<Utilizador> utilizadores = new ArrayList<Utilizador>();//Lista de utilizadores criados;

    //Construtor:
    public Administrador(String admin, String password) {
        //Atributos com valores default, unicos valores de acesso ao modo admin;
        this.username = "admin";
        this.password = "12345";
    }

    //Verificação dos valores dos atributos de administrador, comparação dos inputs com os valores do construtor;
    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    /*
    //verificar a existência do nome inserido na lista de utilizadores no ficheiro txt;
    public boolean verificar_utilizador(ArrayList<domain.Utilizador> utilizadores, String nome) throws FileNotFoundException {
        for(domain.Utilizador utilizador : utilizadores) {
            try {
                //Leitura do ficheiro;
                FileReader fr = new FileReader("Utilizadores.txt");
                BufferedReader br = new BufferedReader(fr);
                String line;
                //Verificação em linha:
                while ((line = br.readLine()) != null) {
                    if (line.contains(nome)) {
                        return true;
                    }
                }
                return false;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

     */

    //Getters e setters:
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
