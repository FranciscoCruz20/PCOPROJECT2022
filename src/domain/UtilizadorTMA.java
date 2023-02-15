package domain;

import view.Menu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class UtilizadorTMA {

    //Atributos:
    private String username;
    private int pcc;
    private int hcmid;
    private String gds;
    public static Date data_criacao;
    public static Date data_ultima_alteracao;
    public static String estado;
    public static ArrayList<UtilizadorTMA> utilizadorestma = new ArrayList<>();

    //Construtor:
    public UtilizadorTMA(String username, int pcc, int hcmid, String gds, Date data_criacao, Date data_ultima_alteracao, String estado) {
        this.username = username;
        this.pcc = pcc;
        this.hcmid = hcmid;
        this.gds = gds;
        this.data_criacao = data_criacao;
        this.data_ultima_alteracao = data_ultima_alteracao;
        this.estado = "Inativo";

    }

    /**
     * Método que obtem a data de criação do utilziadortma
     */
    public static void data_criacao() {
        UtilizadorTMA.data_criacao = new Date();
        System.out.println("Data de criação: "+ data_criacao.toString());
    }

    /**
     * Método que verifica a existência de um utilizadortma na lista dos mesmos e no ficheiro txt onde estão guardados os seus dados
     * @param utilizadorestma
     * @param nome
     * @return estado de verificação
     * @throws FileNotFoundException
     */
    public static boolean verificar_utilizadortma(ArrayList<UtilizadorTMA> utilizadorestma, String nome) throws FileNotFoundException {
        for(UtilizadorTMA utilizadortma : utilizadorestma) {
            try {
                //Leitura do ficheiro;
                FileReader fr = new FileReader("UtilizadoresTMA.txt");
                BufferedReader br = new BufferedReader(fr);
                String line;
                //Verificação em linha:
                while ((line = br.readLine()) != null) {
                    if (line.contains(nome)) {
                        return false;
                    }
                }
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return true;
            }
        }
        return true;
    }

    //Information Expert, tem a responsabilidade de vferificar os dados do utilizadortma, já que esta classe contèm toda a informação necessária
    /**
     * Método que verifica a existência de um utilizadortma na lista dos mesmos e no ficheiro txt onde estão guardados os seus dados
     * @param utilizadorestma
     * @param nome
     * @param pcc
     * @param hcmid
     * @return estado de verificação
     * @throws FileNotFoundException
     */
    public static boolean verificar_dados_utilizadortma(ArrayList<UtilizadorTMA> utilizadorestma, String nome, int pcc, int hcmid) throws FileNotFoundException {
        for(UtilizadorTMA utilizadortma : utilizadorestma) {
            try {
                //Leitura do ficheiro;
                FileReader fr = new FileReader("UtilizadoresTMA.txt");
                BufferedReader br = new BufferedReader(fr);
                String line;
                //Verificação em linha:
                while ((line = br.readLine()) != null) {
                    if (line.contains(nome) && line.equals(pcc) && line.equals(hcmid)) {
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
     * Método que chama método creator de objetos do tipo UtilziadorTMA
     * @throws IOException
     */
    public static void inserir_dados_tma() throws IOException {
        UtilizadorTMACreator.criar_utilizadortma();
    }


    /**
     * Método que adiciona o utilziadortma a lista dos mesmos
     * Escreve os dados do utilziadortma no ficheiro txt
     * @param utilTMA
     */
    public static void confirmar_criacao_tma(UtilizadorTMA utilTMA) {
        utilizadorestma.add(utilTMA);
        Escreverficheiros.writeToFileUtilizadorTMA(utilizadorestma, "UtilizadoresTMA");
        System.out.println("UtilizadorTMA criado com sucesso");

    }

    //Getters e Setters:

    /**
     *
     * @return lista de utilizadorestma
     */
    public ArrayList<UtilizadorTMA> getUtilizadorestma() {
        return utilizadorestma;
    }

    /**
     *
     * @param utilizadorestma
     */
    public void setUtilizadorestma(ArrayList<UtilizadorTMA> utilizadorestma) {
        this.utilizadorestma = utilizadorestma;
    }

    /**
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return PCC
     */
    public int getPcc() {
        return pcc;
    }

    /**
     *
     * @param pcc
     */
    public void setPcc(int pcc) {
        this.pcc = pcc;
    }

    /**
     *
     * @return HCMID
     */
    public int getHcmid() {
        return hcmid;
    }

    /**
     *
     * @param hcmid
     */
    public void setHcmid(int hcmid) {
        this.hcmid = hcmid;
    }

    /**
     *
     * @return GDS
     */
    public String getGds() {
        return gds;
    }

    /**
     *
     * @param gds
     */
    public void setGds(String gds) {
        this.gds = gds;
    }

    /**
     *
     * @return data de criação do utilizadortma
     */
    public Date getData_criacao() {
        return data_criacao;
    }

    /**
     *
     * @param data_criacao
     */
    public void setData_criacao(Date data_criacao) {
        this.data_criacao = data_criacao;
    }

    /**
     *
     * @return data da ultima alteração do utilizadortma
     */
    public Date getData_ultima_alteracao() {
        return data_ultima_alteracao;
    }

    /**
     *
     * @param data_ultima_alteracao
     */
    public void setData_ultima_alteracao(Date data_ultima_alteracao) {
        this.data_ultima_alteracao = data_ultima_alteracao;
    }

    /**
     *
     * @return estado
     */
    public static String getEstado() {
        return estado;
    }

    /**
     *
     * @param estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }


}
