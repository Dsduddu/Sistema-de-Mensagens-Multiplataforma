import Mesagem.Mensagem;
import Mesagem.MensagemEmail;
import Mesagem.MensagemSMS;
import Interface.Prioritario;
import Interface.Agendavel;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Mensagem minhaMsg = null; // Começa vazia

        System.out.println("Escolha o tipo de mensagem: (1) E-mail (2) SMS");
        int opcao = leitor.nextInt();
        leitor.nextLine(); // Limpa o buffer do teclado

        System.out.println("Digite o destinatário:");
        String dest = leitor.nextLine();

        // Polimorfismo na prática: a variável é 'Mensagem', 
        // mas o objeto depende da escolha do usuário.
        if (opcao == 1) {
            minhaMsg = new MensagemEmail(dest);
        } else if (opcao == 2) {
            minhaMsg = new MensagemSMS(dest);
        }

        // Execução dinâmica
        if (minhaMsg != null) {
            minhaMsg.enviar();
            
            // Se for E-mail, podemos pedir o agendamento
            if (minhaMsg instanceof Agendavel) {
                System.out.println("Digite a data para agendar:");
                String data = leitor.nextLine();
                ((Agendavel) minhaMsg).agendar(data);
            }
        }

        leitor.close();
    }
}
   