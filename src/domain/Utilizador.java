package domain;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Utilizador {

    //Atributos:
    private String nome;
    private static String email;
    private static String funcao;
    private static boolean confrimacao_email;
    private static String password;
    public static ArrayList<Utilizador> utilizadores = new ArrayList<Utilizador>();


    //Construtor:
    public Utilizador(String nome, String email, String funcao, String password) {
        this.nome = nome;
        this.email = email;
        this.funcao = funcao;
        this.confrimacao_email = false;
        this.password = password;
    }

    /**
     * Método que chama o método criador de objetos do tipo Utilziador na classe creator de Utilziador
     */
    public static void criar_utilizador() throws FileNotFoundException {
        UtilizadorCreator.criar_utilizador();
    }

    /**
     * Verificar a existência do nome inserido na lista de utilizadores no ficheiro txt
     * @param utilizadores
     * @param nome
     * @return estado de verificação do utilizador
     */
    public static boolean verificar_utilizador(ArrayList<Utilizador> utilizadores, String nome) throws FileNotFoundException{
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

    /**
     * Verificar se o nome está dentro do ficheiro de utilizadores
     * @param utilizadores
     * @param nome
     * @param password
     * @return estado de verificação do utilizador
     * @throws FileNotFoundException
     */
    public static boolean verificar_utilizador_confirmar(ArrayList<Utilizador> utilizadores, String nome, String password) throws FileNotFoundException {
        for(Utilizador utilizador : utilizadores) {
            try {
                FileReader fr = new FileReader("Utilizadores.txt");
                BufferedReader br = new BufferedReader(fr);
                String line;
                //Verificação em linha:
                while ((line = br.readLine()) != null) {
                    if (line.contains(nome)) {
                        if (line.contains(password)) {
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


    //Getters e setters:

    /**
     *
     * @return password do utilizador
     */
    public static String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return estado de confirmação de email
     */
    public boolean getConfrimacao_email() {
        return confrimacao_email;
    }

    /**
     *
     * @param confrimacao_email
     */
    public static void setConfrimacao_email(boolean confrimacao_email) {
        Utilizador.confrimacao_email = confrimacao_email;
    }

    /**
     *
     * @return função do utilziador
     */
    public static String getFuncao() {
        return funcao;
    }

    /**
     *
     * @param funcao
     */
    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    /**
     *
     * @return email do utilziador
     */
    public static String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return nome do utilizador
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
}


