package domain;

import java.util.Scanner;

/**
 * Classe creator de objetos do tipo Cliente
 */
public class ClienteCreator {

    /**
     * Método que cria objetos do tipo Cliente e guarda os seus dados num ficheiro txt.
     * @return CLiente
     */
    public static Cliente criar_cliente() {

        Scanner input = new Scanner(System.in);

        System.out.println("Nome:");
        String nome = input.nextLine();

        System.out.println("Email:");
        String email = input.nextLine();

        System.out.println("Número de telefone:");
        int telefone = Integer.parseInt(input.nextLine());

        System.out.println("NIF:");
        int nif = Integer.parseInt(input.nextLine());

        System.out.println("Código postal:");
        String codigo_postal = input.nextLine();

        System.out.println("Endereço:");
        String endereco = input.nextLine();

        System.out.println("País");
        String  pais = input.nextLine();

        System.out.println("Informação adicional:");
        String informacao_adicional = input.nextLine();

        System.out.println("Pagamento default:");
        String pagamento_default = input.nextLine();

        Cliente cliente = new Cliente(nome, email, telefone, nif, endereco, codigo_postal, pais, informacao_adicional, pagamento_default);
        Cliente.clientes.add(cliente);
        Escreverficheiros.writeToFileCliente(Cliente.clientes, "Clientes.txt");
        System.out.println("Cliente criado com sucesso");


        return new Cliente(nome, email, telefone, nif, endereco, codigo_postal, pais, informacao_adicional, pagamento_default);
    }
}
