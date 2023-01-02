import java.util.Date;

public class UtilizadorTMA {

    //Atributos:
    private String username;
    private int pcc;
    private int hcmid;
    private String gds;
    private Date data_criacao;
    private Date data_ultima_alteracao;
    private String estado;

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

    //Metodos para obter data do sistema:
    public void obter_data() {
        Date data = new Date();
        System.out.println("A hora do sitema é "+ data.toString());
    }

    public  void data_criacao() {
        Date data_criacao = new Date();
        System.out.println("Data de criação: "+ data_criacao.toString());
    }

    //Getters e Setters:
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPcc() {
        return pcc;
    }

    public void setPcc(int pcc) {
        this.pcc = pcc;
    }

    public int getHcmid() {
        return hcmid;
    }

    public void setHcmid(int hcmid) {
        this.hcmid = hcmid;
    }

    public String getGds() {
        return gds;
    }

    public void setGds(String gds) {
        this.gds = gds;
    }

    public Date getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(Date data_criacao) {
        this.data_criacao = data_criacao;
    }

    public Date getData_ultima_alteracao() {
        return data_ultima_alteracao;
    }

    public void setData_ultima_alteracao(Date data_ultima_alteracao) {
        this.data_ultima_alteracao = data_ultima_alteracao;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}