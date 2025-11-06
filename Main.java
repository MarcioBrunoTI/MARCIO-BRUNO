public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        agenda.addContatinho(new Contatinho("Nick Ferreira", "nick@gmail.com", "83988888", "Professor"));
        agenda.addContatinho(new Contatinho("Ana Lima", "ana@gmail.com", "83999999", "Amiga"));
        agenda.addContatinho(new Contatinho("Carlos Souza", "carlos@gmail.com", "83888888", "Trabalho"));

        String nomeArquivo = "contatinhos.txt";
        agenda.salvarLista(nomeArquivo);

        Contatinho encontrado = agenda.buscarContatinhoPorNome("Ana Lima", nomeArquivo);
        if (encontrado != null) {
            System.out.println("Contato encontrado: " + encontrado);
        } else {
            System.out.println("Contato não encontrado.");
        }
    }
}
