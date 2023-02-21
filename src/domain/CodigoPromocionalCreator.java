package domain;

/**
 * Creator de obejtos do tipo CodigoPromocional
 */
public class CodigoPromocionalCreator {

    /**
     * Método que cria o objeto
     * @return
     */
    public static CodigoPromocional criar_codigo() {

        String codigo = "123456789";
        boolean estado = false;

        return new CodigoPromocional(codigo, estado);
    }
}
