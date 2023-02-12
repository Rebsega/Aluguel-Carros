package exceptions;

public class VeiculoEmUsoException extends RuntimeException{

    public VeiculoEmUsoException(String tipo, String id) {
        super("O Veículo com id %s e do tipo %s já está em uso".formatted(id, tipo));
    }
}
