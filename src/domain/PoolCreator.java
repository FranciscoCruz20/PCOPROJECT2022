package domain;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Scanner;

/**
 * Classe creator de pools, cria objetos do tipo Pool com os devidos inputs;
 */
public class PoolCreator {

    /**
     *
     * Método que cria objetos do tipo Pool onde os inputs são os valores dados aos atributos de Pool;
     * Para além da criação do objeto, este é guardado numa lista de objetos do mesmo tipo e guardado num ficheiro txt.;
     * @return objeto do tipo Pool;
     * @throws FileNotFoundException
     */
    public static Pool criar_pool() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduza os dados da pool");
        System.out.println("Nome:");
        String nome = input.nextLine();
        int max_licencas = 0;
        Date data_criacao = null;
        if (Pool.verificar_pool(Pool.pools, nome) == false) {
            System.out.println("Pool com este nome já existe");
            criar_pool();
        } else {
            System.out.println("Validade(ano-mês-dia):");
            String validade = null;
            try {
                validade = input.nextLine();
                LocalDate date = LocalDate.parse(validade, DateTimeFormatter.ISO_DATE);
                System.out.println(date);
            } catch (IllegalArgumentException e) {
                System.out.println("Exception: " + e);
            } catch (DateTimeParseException e) {
                System.out.println("Exception: " + e);
            }
            Pool.setValidade(validade);
            data_criacao = Pool.data_criacao();
            System.out.println("Número máximo de licenças:");
            max_licencas = input.nextInt();
            Pool.setLicencas_disp(max_licencas);
            Pool.setMax_licencas(max_licencas);
            Pool.setLicencas_usadas(0);
            System.out.println("Pretende renovação?(yes/no)");
            String decisao = input.nextLine();
            if (decisao == "yes") {
                Pool.setRenovacao(true);
            } else if (decisao == "no") {
                Pool.setRenovacao(false);
            } else {
                System.out.println("Opção inválida");
            }
            System.out.println("domain.Cliente:");
            String cliente = input.nextLine();
            if (Cliente.verificar_cliente(cliente) == true) {
                Pool.setCliente(Cliente.procurarCliente(cliente));
                Pool pool = new Pool(nome, max_licencas, data_criacao, Pool.getValidade(), Pool.getEstado(), Pool.getLicencas_disp(), Pool.getEstado_pagamento(), Pool.getRenovacao(), Pool.getPreco(), Pool.getCliente(), Pool.getLicencas(), Pool.getLicencas_usadas());
                Pool.pools.add(pool);
                Escreverficheiros.writeToFilePool(Pool.pools, "Pools.txt");
                System.out.println("Pool criada com sucesso");
            }
        }
        return new Pool(nome, max_licencas, data_criacao, Pool.getValidade(), Pool.getEstado(), Pool.getLicencas_disp(), Pool.getEstado_pagamento(), Pool.getRenovacao(), Pool.getPreco(), Pool.getCliente(), Pool.getLicencas(), Pool.getLicencas_usadas());
    }

}
