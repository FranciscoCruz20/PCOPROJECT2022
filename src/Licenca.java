import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class Licenca {

    //Atributos:
    private Date data_criacao;
    private String estado;
    private Date validade;
    private  UtilizadorTMA utilizadortma;
    private boolean pagamento;
    private boolean renovacao;
    private float preco;
    private Cliente cliente;
    private Pool pool;
    private ArrayList<Licenca> licencas = new ArrayList<>();
    private ArrayList<Utilizador> utilizadorestma = new ArrayList<Utilizador>();


    //Construtor:
    public Licenca(Date data_criacao,String estado, Date validade, UtilizadorTMA utilizadortma, boolean pagamento, boolean renovacao, float preco, Cliente cliente, Pool pool) {
        this.data_criacao = data_criacao;
        this.estado = "Inativa";
        this.validade = validade;
        this.utilizadortma = utilizadortma;
        this.pagamento = false;
        this.renovacao = false;
        this.preco = 100;
        this.cliente = cliente;
        this.pool = pool;
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

    public void criar_licenca() throws FileNotFoundException {

        Scanner input = new Scanner(System.in);
        System.out.println("Introduza os dados da licença");
        System.out.println("Validade(ano-mês-dia):");
        try {
            String validade = input.nextLine();

            // Using parse method to convert the string to LocalDate object
            LocalDate date = LocalDate.parse(validade, DateTimeFormatter.ISO_DATE);

            // Printing the date object
            System.out.println(date);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Exception: " + e);
        }
        catch (DateTimeParseException e) {
            System.out.println("Exception: " + e);
        }
        System.out.println("Utilizador TMA:");
        String utilizadortma = input.nextLine();
        if (UtilizadorTMA.verificar_utilizador(utilizadorestma, utilizadortma)) {
            if (UtilizadorTMA.verificar_licencas(utilizadorestma, licencas)){
                System.out.println("Cliente:");
                String cliente = input.nextLine();
                if (Cliente.verificar_cliente(cliente) == true) {
                    data_criacao();
                    System.out.println(getValidade() + ", " + getUtilizadortma() + ", " + getCliente() + ", " + getData_criacao() + ", " + getEstado() + ", " + getPagamento() + ", " + getRenovacao() + ", " + getPreco());
                    System.out.println("1-Confirmar licença");
                    int opcao =  input.nextInt();
                    if (opcao == 1) {
                        String pool = input.nextLine();
                        Pool.escolher_pool(pool);
                        confirmar_licenca();
                    }
                    else {
                        System.out.println("Opção inválida");
                    }
                } else {
                    System.out.println("Dados inseridos incorretos");
                }
            }
            }
        else {
            System.out.println("Dados inseridos incorretos");
        }
    }

    public void dados_licenca(Date validade, UtilizadorTMA utilizadortma, Cliente cliente) {

    }

    public void confirmar_licenca() {

    }

    //Getters e Setters:
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public boolean getRenovacao() {
        return renovacao;
    }

    public void setRenovacao(boolean renovacao) {
        this.renovacao = renovacao;
    }

    public boolean getPagamento() {
        return pagamento;
    }

    public void setPagamento(boolean pagamento) {
        this.pagamento = pagamento;
    }

    public UtilizadorTMA getUtilizadortma() {
        return utilizadortma;
    }

    public void setUtilizadortma(UtilizadorTMA utilizadortma) {
        this.utilizadortma = utilizadortma;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(Date data_criacao) {
        this.data_criacao = data_criacao;
    }
}
