package domain;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class Licenca {

    //Atributos:
    private static Date data_criacao;
    private static String estado;
    private static String validade;
    private static String utilizadortma;
    private static boolean pagamento;
    private static boolean renovacao;
    private static float preco;
    private static Cliente cliente;
    //private static domain.Pool pool;
    private static ArrayList<Licenca> licencas = new ArrayList<>();
    private static ArrayList<UtilizadorTMA> utilizadorestma = new ArrayList<UtilizadorTMA>();
    private static ArrayList<Cliente> clientes = new ArrayList<>();

    //Construtor:
    public Licenca(Date data_criacao, String estado, String validade, String utilizadortma, boolean pagamento, boolean renovacao, float preco, Cliente cliente) {
        this.data_criacao = data_criacao;
        this.estado = "Inativa";
        this.validade = validade;
        this.utilizadortma = utilizadortma;
        this.pagamento = false;
        this.renovacao = false;
        this.preco = 100;
        this.cliente = cliente;
        //this.pool = pool;
    }

    //Metodos para obter data do sistema:
    public void obter_data() {
        Date data = new Date();
        System.out.println("A hora do sitema é "+ data.toString());
    }

    public static Date data_criacao() {
        Date data_criacao = new Date();
        System.out.println("Data de criação: "+ data_criacao.toString());
        return data_criacao;
    }

    public void alterar_licenca() {
        Scanner input = new Scanner(System.in);
        this.toString();
        System.out.println("Que parametro quer alterar?");
        String parametro = input.nextLine();
        System.out.println("Oque deseja colocar?");
        String alteracao = input.nextLine();
        Escreverficheiros.alterar_ficheiros_licencas(licencas, "Licenças.txt", parametro,alteracao);
        this.toString();
    }

    public void criar_licenca() throws FileNotFoundException {

        Scanner input = new Scanner(System.in);
        System.out.println("Introduza os dados da licença");
        System.out.println("Validade(ano-mês-dia):");
        String validade = input.nextLine();
        setValidade(validade);
        System.out.println("domain.Utilizador TMA:");
        String utilizadortma = input.nextLine();
        if (UtilizadorTMA.verificar_utilizadortma(utilizadorestma, utilizadortma)) {
            setUtilizadortma(utilizadortma);
            System.out.println("domain.Cliente:");
            String cliente = input.nextLine();
            if (Cliente.verificar_cliente(cliente)==true) {
                setCliente(cliente);
                Date data_criacao = data_criacao();
                //System.out.println(getValidade() + ", " + getUtilizadortma() + ", " + getCliente() + ", " + getData_criacao() + ", " + getEstado() + ", " + getPagamento() + ", " + getRenovacao() + ", " + getPreco());
                System.out.println("1-Confirmar licença");
                String estado = getEstado();
                int opcao =  input.nextInt();
                if (opcao == 1) {
                    Licenca licenca = new Licenca(data_criacao, estado, getValidade(), getUtilizadortma(), getPagamento(), getRenovacao(), getPreco(), getCliente());
                    licencas.add(licenca);
                    Escreverficheiros.writeToFileLicenca(licencas, "Licenças.txt");
                    System.out.println("Licença criada com sucesso");
                    licenca.toString();
                }
                else {
                        System.out.println("Opção inválida");
                    }
            } else {
                System.out.println("Dados inseridos incorretos");
            }
            }
        else {
            System.out.println("Dados inseridos incorretos");
        }
    }

    public void dados_licenca(Date validade, UtilizadorTMA utilizadortma, Cliente cliente) {

    }

    //Getters e Setters:
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = Cliente.procurarCliente(cliente);
    }

    public  float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public  boolean getRenovacao() {
        return renovacao;
    }

    public void setRenovacao(boolean renovacao) {
        this.renovacao = renovacao;
    }

    public  boolean getPagamento() {
        return pagamento;
    }

    public void setPagamento(boolean pagamento) {
        this.pagamento = pagamento;
    }

    public String getUtilizadortma() {
        return utilizadortma;
    }

    public void setUtilizadortma(String utilizadortma) {
        this.utilizadortma = utilizadortma;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public  String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public  Date getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(Date data_criacao) {
        this.data_criacao = data_criacao;
    }

    public String toString() {
        return "domain.Licenca{" +
                "data_criacao=" + data_criacao +
                ", estado='" + estado + '\'' +
                ", validade=" + validade +
                ", utilizadortma=" + utilizadortma +
                ", pagamento=" + pagamento +
                ", renovacao=" + renovacao +
                ", preco=" + preco +
                ", cliente=" + cliente +
                '}';
    }
}
