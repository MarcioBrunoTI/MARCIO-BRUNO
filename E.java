import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class E {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("===== GERADOR DE TABUADA =====");
        System.out.print("Digite um número inteiro: ");
        int numero = entrada.nextInt();

        String nomeArquivo = "tabuada_" + numero + ".txt";

        try {
            FileWriter escritor = new FileWriter(nomeArquivo);
            escritor.write("===== TABUADA DO " + numero + " =====\n\n");

            for (int i = 1; i <= 10; i++) {
                int resultado = numero * i;
                escritor.write(numero + " x " + i + " = " + resultado + "\n");
            }

            escritor.write("\nArquivo gerado com sucesso!");
            escritor.close();

            System.out.println("\nTabuada do " + numero + " foi salva no arquivo \"" + nomeArquivo + "\".");
        } 
        catch (IOException e) {
            System.out.println("Ocorreu um erro ao criar o arquivo: " + e.getMessage());
        }

        entrada.close();
    }
}
