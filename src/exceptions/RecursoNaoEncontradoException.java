package exceptions;

public class RecursoNaoEncontradoException extends RuntimeException{

    public RecursoNaoEncontradoException(String tipo, String id) {
        super("Não foi encontrado um registro do tipo %s com id %s.".formatted(tipo, id));
    }
}

