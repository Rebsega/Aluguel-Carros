package exceptions;

public class EntidadeJaExisteException extends RuntimeException{

    public EntidadeJaExisteException(String tipo, String id) {
        super("Já existe um registro do tipo %s com o id %s.".formatted(tipo, id));
    }
}
