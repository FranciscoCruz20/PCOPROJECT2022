package domain;

import java.util.ArrayList;
import java.util.Date;

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
