package domain;

import java.io.FileNotFoundException;
import java.util.Date;

/**
 * Classe creator de licenças, cria objetos do tipo Licenca com os devidos inputs;
 */
public class LicencaCreator {

    /**
     *
     * Método que cria objetos do tipo Licenca onde os inputs são associados aos atributos de licenca;
     * Para além da criação do objeto, este é guardado numa lista de objetos do mesmo tipo e guardado num ficheiro txt.;
     * @return objeto do tipo Licenca;
     * @throws FileNotFoundException
     * @param data_criacao
     * @param estado
     * @param validade
     * @param utilizadortma
     * @param pagamento
     * @param renovacao
     * @param preco
     * @param cliente
     */
    public static Licenca criarLicenca(Date data_criacao, String estado, String validade, String utilizadortma, boolean pagamento, boolean renovacao, float preco, String cliente) throws FileNotFoundException {

        Licenca licenca = new Licenca(data_criacao, estado, Licenca.getValidade(), utilizadortma, Licenca.getPagamento(), Licenca.getRenovacao(), Licenca.getPreco(), Licenca.getCliente());
        Licenca.licencas.add(licenca);
        Escreverficheiros.writeToFileLicenca(Licenca.licencas, "Licenças.txt");
        System.out.println("Licença criada com sucesso");
        return new Licenca(data_criacao, estado, validade, utilizadortma, Licenca.getPagamento(), Licenca.getRenovacao(), Licenca.getPreco(), Licenca.getCliente());
    }

}
