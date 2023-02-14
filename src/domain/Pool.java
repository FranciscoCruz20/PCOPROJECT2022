package domain;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Pool {

    //Atributos:
    private static String nome;
    private static int max_licencas;
    private static Date data_criacao;
    private static String validade;
    private static String estado;
    private static int licencas_disp;
    private static boolean estado_pagamento;
    private static boolean renovacao;
    private static float preco;
    private static Cliente cliente;
    private static Licenca licenca;
    private static int licencas_usadas;
    private static ArrayList<Licenca> licencas = new ArrayList<>();
    private static ArrayList<Pool> pools = new ArrayList<>();

    //Construtor:
    public Pool(String nome, int max_licencas, Date data_criacao, String validade, String estado,int licencas_disp, boolean estado_pagamento, boolean renovacao, float preco,Cliente cliente, List licencas, int licencas_usadas) {
        this.nome = nome;
        this.max_licencas = 0;
        this.data_criacao = data_criacao;
        this.validade = validade;
        this.estado = "Inativa";
        this.licencas_disp = 0;
        this.estado_pagamento = false;
        this.renovacao = false;
        this.preco = 0;
        this.cliente = cliente;
        this.licencas_usadas = 0;
        this.licencas = new ArrayList<>();

    }

    public void adicionarLicença(Licenca licença) {
        licencas.add(licença);
    }


    /*
    public void adicionarLicença(Licenca licença) {
        if (licencas.size() < max_licencas) {
            licencas.add(licença);
        } else {
            System.out.println("A pool já está cheia!");
        }
    }
    */

    public static void confirmar_pool_licenca() {
        setLicencas_disp(licencas_disp--);
        setLicencas_usadas(licencas_usadas++);
    }

    public static void criar_pool() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduza os dados da pool");
        System.out.println("Nome:");
        String nome = input.nextLine();
        if (verificar_pool(pools, nome)==false) {
            System.out.println("domain.Pool com este nome já existe");
            criar_pool();
        }
        else {
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
            setValidade(validade);
            Date data_criacao = data_criacao();
            System.out.println("Número máximo de licenças:");
            int max_licencas = input.nextInt();
            setLicencas_disp(max_licencas);
            setMax_licencas(max_licencas);
            setLicencas_usadas(0);
            System.out.println("Pretende renovação?(yes/no)");
            String decisao = input.nextLine();
            if (decisao == "yes") {
                setRenovacao(true);
            }
            else if (decisao == "no") {
                setRenovacao(false);
            }
            else {
                System.out.println("Opção inválida");
            }
            System.out.println("domain.Cliente:");
            String cliente = input.nextLine();
            if (Cliente.verificar_cliente(cliente)==true) {
                setCliente(Cliente.procurarCliente(cliente));
                Pool pool = new Pool(nome, max_licencas, data_criacao, getValidade(), getEstado(), getLicencas_disp(), getEstado_pagamento(), getRenovacao(), getPreco(), getCliente(), getLicencas(), getLicencas_usadas());
                pools.add(pool);
                Escreverficheiros.writeToFilePool(pools, "Pools.txt");
                System.out.println("Pool criada com sucesso");
                pool.toString();
            }
        }
    }

    public static boolean verificar_pool(ArrayList<Pool> pools, String nome) throws FileNotFoundException {
        for(Pool pool : pools) {
            try {
                //Leitura do ficheiro;
                FileReader fr = new FileReader("Pools.txt");
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

    public static void escolher_pool(String pool) {
        //Selecionar pool
        if (pools.contains(pool)) {
            if (licencas_usadas < max_licencas ) {
                confirmar_pool_licenca();
            }
            else {
                System.out.println("domain.Pool cheia");
            }
        }
    }

    public void remover_licenca(Pool pool) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.println("Selecionar licença");
        int opcao = input.nextInt();
        if (opcao==0 && opcao>Pool.getMax_licencas()) {
        licencas.remove(pool);

        }
    }

    public static Date data_criacao() {
        Date data_criacao = new Date();
        System.out.println("Data de criação: "+ data_criacao.toString());
        return data_criacao;
    }




    //Getters e Setters:
    public static int getLicencas_usadas() {
        return licencas_usadas;
    }

    public static void setLicencas_usadas(int licencas_usadas) {
        Pool.licencas_usadas = licencas_usadas;
    }

    public static int getMax_licencas() {
        return max_licencas;
    }

    public static void setMax_licencas(int max_licencas) {

        Pool.max_licencas = max_licencas;
    }

    public static Date getData_criacao() {

        return data_criacao;
    }

    public void setData_criacao(Date data_criacao) {

        this.data_criacao = data_criacao;
    }

    public static String getValidade() {

        return validade;
    }

    public static void setValidade(String validade) {

        Pool.validade = validade;
    }

    public static String getEstado() {

        return estado;
    }

    public void setEstado(String estado) {

        this.estado = estado;
    }

    public static int getLicencas_disp() {

        return licencas_disp;
    }

    public static void setLicencas_disp(int licencas_disp) {

        Pool.licencas_disp = licencas_disp;
    }

    public static boolean getEstado_pagamento() {

        return estado_pagamento;
    }

    public void setEstado_pagamento(boolean estado_pagamento) {

        this.estado_pagamento = estado_pagamento;
    }

    public static boolean getRenovacao() {

        return renovacao;
    }

    public static void setRenovacao(boolean renovacao) {

        Pool.renovacao = renovacao;
    }

    public static float getPreco() {

        return preco;
    }

    //Preço da pool é o preço de uma licença X o número máximo de licenças
    public void setPreco(int max_licencas) {
        this.preco = max_licencas*100;
    }

    public static Cliente getCliente() {

        return cliente;
    }

    public static void setCliente(Cliente cliente) {

        Pool.cliente = cliente;
    }

    public static String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static ArrayList<Licenca> getLicencas() {
        return licencas;
    }

    public void setLicencas(ArrayList<Licenca> licencas) {
        this.licencas = licencas;
    }

    public static ArrayList<Pool> getPools() {
        return pools;
    }

    public void setPools(ArrayList<Pool> pools) {
        this.pools = pools;
    }

    public static Licenca getLicenca() {
        return licenca;
    }

    public static void setLicenca(Licenca licenca) {
        Pool.licenca = licenca;
    }

    @Override
    public String toString() {
        return "domain.Pool{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
