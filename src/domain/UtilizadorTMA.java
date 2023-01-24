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
    private Date data_criacao;
    private Date data_ultima_alteracao;
    private static String estado;
    private boolean licenca;
    private ArrayList<UtilizadorTMA> utilizadorestma = new ArrayList<>();
    private static ArrayList<Licenca> licencas = new ArrayList<>();

    //Construtor:
    public UtilizadorTMA(String username, int pcc, int hcmid, String gds, Date data_criacao, Date data_ultima_alteracao, String estado,boolean licenca) {
        this.username = username;
        this.pcc = pcc;
        this.hcmid = hcmid;
        this.gds = gds;
        this.data_criacao = data_criacao;
        this.data_ultima_alteracao = data_ultima_alteracao;
        this.estado = "Inativo";
        this.licenca = false;
    }

    //Metodos para obter data do sistema:
    public void obter_data() {
        Date data = new Date();
        System.out.println("A data atual é "+ data.toString());
    }

    public  void data_criacao() {
        this.data_criacao = new Date();
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

    public static boolean verificar_licencas(ArrayList<UtilizadorTMA> utilizadorestma, ArrayList licencas) throws FileNotFoundException {
        for(UtilizadorTMA utilizadortma : utilizadorestma) {
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
    public void inserir_dados_tma() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira o username, pcc(inteiro), hcmid(inteiro) e gds(string):");
        System.out.print("Username: ");
        String username = input.nextLine();
        System.out.print("PCC: ");
        int pcc = Integer.parseInt(input.nextLine());
        System.out.print("HCMID: ");
        int hcmid = Integer.parseInt(input.nextLine());
        System.out.println("GDS:");
        String gds = input.nextLine();
        if (verificar_dados_utilizadortma(utilizadorestma, username, pcc, hcmid)) {
            System.out.println("domain.UtilizadorTMA com esse username,pcc e hcmid já existe");
            inserir_dados_tma();
        }
        else {
            System.out.println("1-Confirmar criação de utilizadorTMA");
            System.out.println("2-Sair");
            int opcao = input.nextInt();
            if (opcao == 1) {
                data_criacao();
                this.data_ultima_alteracao = data_criacao;
                UtilizadorTMA utilTMA = new UtilizadorTMA(username, pcc, hcmid, gds, data_criacao, data_ultima_alteracao, estado, licenca);
                confirmar_criacao_tma(utilTMA);
            }
            else if (opcao == 2) {
                Menu.menu_utilizador();
            }
            else {
                System.out.println("Opção inválida");
            }
        }
    }

    public void confirmar_criacao_tma(UtilizadorTMA utilTMA) {
        utilizadorestma.add(utilTMA);
        Escreverficheiros.writeToFileUtilizadorTMA(utilizadorestma, "UtilizadoresTMA");
        System.out.println("domain.UtilizadorTMA criado com sucesso");

    }

    public void criar_utilizadorTMA() throws IOException {
        inserir_dados_tma();
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

    public static String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public static ArrayList<Licenca> getLicencas() {
        return licencas;
    }

    public void setLicencas(ArrayList<Licenca> licencas) {
        this.licencas = licencas;
    }

    public boolean getLicenca() {
        return licenca;
    }

    public void setLicenca(boolean licenca) {
        this.licenca = licenca;
    }
}
