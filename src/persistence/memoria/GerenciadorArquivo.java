package persistence.memoria;

import entities.EntidadeGenerica;
import persistence.arquivo.ManipuladorArquivo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorArquivo<T extends EntidadeGenerica> implements ManipuladorArquivo {

    private final List<T> dados;

    private final String arquivo;

    public GerenciadorArquivo(String arquivo) {
        this.dados = new ArrayList<>();
        this.arquivo = arquivo;
    }
    @Override
    public Object lerDoArquivo() {

        try (InputStream fileInputStream = new FileInputStream(arquivo);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);) {
            return objectInputStream.readObject();
        } catch (IOException e) {
            System.out.println("Erro no momento de ler o arquivo, continuando o processamento");
        } catch (ClassNotFoundException e) {
            System.out.println("Erro no momento de converter o arquivo para o tipo Java, continuando o processamento");
        }

        return new ArrayList<>();
    }

    @Override
    public void escreverArquivo(Object dados) {
        try(OutputStream fileOutputStream = new FileOutputStream(arquivo);
            ObjectOutputStream escritor = new ObjectOutputStream(fileOutputStream)){
            escritor.writeObject(dados);
            escritor.flush();
        } catch (IOException e) {
            System.err.println("Erro em salvar no arquivo!");
            e.printStackTrace();
        }
    }

    @Override
    public Object buscarPorIdUnico(String id) {
        List<Object> lista = new ArrayList<>();
        for (T entidade: dados) {
            if (entidade.getId().equals(id)) {
                lista.add(entidade);
            }
        }
        return lista;
    }

    @Override
    public List<Object> buscarPorId(String id) {
        List<Object> lista = new ArrayList<>();
        for (T entidade: dados) {
            if (entidade.getId().equals(id)) {
                lista.add(entidade);
            }
        }
        return lista;
    }
}
