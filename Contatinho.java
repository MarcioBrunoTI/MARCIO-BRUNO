import java.io.*;
import java.util.*;
public class Contatinho implements Comparable<Contatinho> {
    private String nome;
    private String email;
    private String telefone;
    private String categoria;

    public Contatinho(String nome, String email, String telefone, String categoria) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public int compareTo(Contatinho outro) {
        return this.nome.compareToIgnoreCase(outro.nome);
    }

    @Override
    public String toString() {
        return nome + "#" + email + "#" + telefone + "#" + categoria;
    }
}

 class Agenda {
    private List<Contatinho> lista;

    public Agenda() {
        lista = new ArrayList<>();
    }

    public void addContatinho(Contatinho c) {
        lista.add(c);
    }

    public void ordenarLista() {
        Collections.sort(lista);
    }

    public void salvarLista(String nomeArquivo) {
        ordenarLista();
        try (FileWriter escritor = new FileWriter(nomeArquivo)) {
            for (Contatinho c : lista) {
                escritor.write(c.toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar a lista: " + e.getMessage());
        }
    }

    public Contatinho buscarContatinhoPorNome(String nome, String nomeArquivo) {
        try (BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                String[] dados = linha.split("#");
                if (dados.length == 4 && dados[0].equalsIgnoreCase(nome)) {
                    return new Contatinho(dados[0], dados[1], dados[2], dados[3]);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return null;
    }
}
