import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class UtilizadorTMA extends Utilizador{

    //Atributos:
    private String username;
    private int pcc;
    private int hcmid;
    private String gds;
    private Date data_criacao;
    private Date data_ultima_alteracao;
    private String estado;
    private ArrayList<UtilizadorTMA> utilizadorestma = new ArrayList<>();
    private ArrayList<Licenca> licencas = new ArrayList<>();

    //Construtor:
    public UtilizadorTMA(String nome, String email, String funcao, String password, String username, int pcc, int hcmid, String gds, Date data_criacao, Date data_ultima_alteracao, String estado,ArrayList licencas) {
        super(nome, email, funcao, password);
        this.username = username;
        this.pcc = pcc;
        this.hcmid = hcmid;
        this.gds = gds;
        this.data_criacao = data_criacao;
        this.data_ultima_alteracao = data_ultima_alteracao;
        this.estado = "Inativo";
        this.licencas = licencas;
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

    public static boolean verificar_licencas(ArrayList<Utilizador> utilizadorestma, ArrayList licencas) throws FileNotFoundException {
        for(Utilizador utilizadortma : utilizadorestma) {
            try {
                //Leitura do ficheiro;
                FileReader fr = new FileReader("UtilizadoresTMA.txt");
                BufferedReader br = new BufferedReader(fr);
                String line;
                //Verificação em linha:
                while ((line = br.readLine()) != null) {
                    if (line.contains((CharSequence) licencas)) {
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

    //Getters e Setters:

    public ArrayList<UtilizadorTMA> getUtilizadorestma() {
        return utilizadorestma;
    }

    public void setUtilizadorestma(ArrayList<UtilizadorTMA> utilizadorestma) {
        this.utilizadorestma = utilizadorestma;
    }

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
