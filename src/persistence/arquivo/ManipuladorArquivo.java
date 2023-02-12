package persistence.arquivo;

import java.util.List;

public interface ManipuladorArquivo {

    Object lerDoArquivo();

    Object buscarPorIdUnico(String id);

    List<Object> buscarPorId(String id);

    void escreverArquivo(Object object);

}
