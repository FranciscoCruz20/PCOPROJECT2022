package domain;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Classe das licenças;
 */
public class Licenca {

    //Atributos:
    private static Date data_criacao;
    private static String estado;
    private static String validade;
    private static String utilizadortma;
    private static boolean pagamento;
    private static boolean renovacao;
    private static float preco;
    private static String cliente;
    public static ArrayList<Licenca> licencas = new ArrayList<>();
    public static ArrayList<UtilizadorTMA> utilizadorestma = new ArrayList<UtilizadorTMA>();
    private static ArrayList<Cliente> clientes = new ArrayList<>();

    //Construtor:
    public Licenca(Date data_criacao, String estado, String validade, String utilizadortma, boolean pagamento, boolean renovacao, float preco, String cliente) {
        this.data_criacao = data_criacao;
        this.estado = "Inativa";
        this.validade = validade;
        this.utilizadortma = utilizadortma;
        this.pagamento = false;
        this.renovacao = false;
        this.preco = 100;
        this.cliente = cliente;
    }

    /**
     * Método que obtem a data do sistema;
     */
    public void obter_data() {
        Date data = new Date();
        System.out.println("A hora do sitema é "+ data.toString());
    }

    /**
     * Método que define a data de criação da licença;
     * @return data de criação da licença;
     */
    public static Date data_criacao() {
        Date data_criacao = new Date();
        System.out.println("Data de criação: "+ data_criacao.toString());
        return data_criacao;
    }

    /**
     * Método que permite alterar imformação da licença;
     */
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

    /**
     * Método que chama o creator da classe Licenca;
     * @throws FileNotFoundException
     */
    public static void criar_licenca() throws FileNotFoundException {
        LicencaCreator.criarLicenca();
    }

    /*
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
                System.out.println("1-Confirmar licença");
                String estado = getEstado();
                int opcao =  input.nextInt();
                if (opcao == 1) {
                    //LicencaCreator.criarLicenca(data_criacao, estado, getValidade(), getUtilizadortma(), getPagamento(), getRenovacao(), getPreco(), getCliente());
                    //Licenca licenca = new Licenca(data_criacao, estado, getValidade(), getUtilizadortma(), getPagamento(), getRenovacao(), getPreco(), getCliente());
                    licencas.add(LicencaCreator.criarLicenca(data_criacao, estado, getValidade(), getUtilizadortma(), getPagamento(), getRenovacao(), getPreco(), getCliente()));
                    Escreverficheiros.writeToFileLicenca(licencas, "Licenças.txt");
                    System.out.println("Licença criada com sucesso");
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
     */

    //Getters e Setters:

    /**
     *
     * @return cliente
     */
    public static String getCliente() {
        return cliente;
    }

    /**
     *
     * @param cliente
     */
    public static void setCliente(String cliente) {
        Licenca.cliente = cliente;
    }

    /**
     *
     * @return preço da licença
     */
    public static float getPreco() {
        return preco;
    }

    /**
     *
     * @param preco
     */
    public void setPreco(float preco) {
        this.preco = preco;
    }

    /**
     *
     * @return estado da renovação
     */
    public static boolean getRenovacao() {
        return renovacao;
    }

    /**
     *
     * @param renovacao
     */
    public void setRenovacao(boolean renovacao) {
        this.renovacao = renovacao;
    }

    /**
     *
     * @return estado do pagamento
     */
    public static boolean getPagamento() {
        return pagamento;
    }

    /**
     *
     * @param pagamento
     */
    public void setPagamento(boolean pagamento) {
        this.pagamento = pagamento;
    }

    /**
     *
     * @return utilizadortma
     */
    public static String getUtilizadortma() {
        return utilizadortma;
    }

    /**
     *
     * @param utilizadortma
     */
    public static void setUtilizadortma(String utilizadortma) {
        Licenca.utilizadortma = utilizadortma;
    }

    /**
     *
     * @return validade da licença
     */
    public static String getValidade() {
        return validade;
    }

    /**
     *
     * @param validade
     */
    public static void setValidade(String validade) {
        Licenca.validade = validade;
    }

    /**
     *
     * @return estado da licença
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

    /**
     *
     * @return data de criação da licença
     */
    public  Date getData_criacao() {
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
     * @return dados da licença
     */
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
