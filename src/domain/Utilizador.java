package domain;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utilizador {

    //Atributos:
    private String nome;
    private String email;
    private String funcao;
    private boolean confrimacao_email;
    private String password;
    private static ArrayList<String> utilizadores = new ArrayList<String>();


    //Construtor:
    public Utilizador(String nome, String email, String funcao, String password) {
        this.nome = nome;
        this.email = email;
        this.funcao = funcao;
        this.confrimacao_email = false;
        this.password = password;
    }

    //verificar a existência do nome inserido na lista de utilizadores no ficheiro txt;
    public static boolean verificar_utilizador(ArrayList<Utilizador> utilizadores, String nome) throws FileNotFoundException {
        for(Utilizador utilizador : utilizadores) {
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


    //Verificar se o nome está dentro do ficheiro de utilizadres:
    public static boolean verificar_utilizador_confirmar(ArrayList<Utilizador> utilizadores, String nome, String email) throws FileNotFoundException {
        for(Utilizador utilizador : utilizadores) {
            try {
                FileReader fr = new FileReader("Utilizadores.txt");
                BufferedReader br = new BufferedReader(fr);
                String line;
                //Verificação em linha:
                while ((line = br.readLine()) != null) {
                    if (line.contains(nome)) {
                        if (line.contains(email)) {
                            return true;
                        }
                    }
                }
                return false;
            }
            catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }


    //Método que muda o  estado de confirmação do email, que por default é false para true;
    public void confirmar_email() {
        setConfrimacao_email(true);
    }

    //Getters e setters:

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getConfrimacao_email() {
        return confrimacao_email;
    }

    public void setConfrimacao_email(boolean confrimacao_email) {
        this.confrimacao_email = confrimacao_email;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail() {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome() {
    }
}


