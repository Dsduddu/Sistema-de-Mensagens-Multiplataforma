import Mesagem.Mensagem;
import Mesagem.MensagemEmail;
import Mesagem.MensagemSMS;
import Interface.Prioritario;
import Interface.Agendavel;

public class App {
    public static void main(String[] args) throws Exception {
        // 1. Criamos um Array do tipo da Classe Pai (Abstração/Herança)
        // Isso nos permite guardar qualquer tipo de mensagem.
        Mensagem[] listaMensagens = new Mensagem[2];
        listaMensagens[0] = new MensagemEmail("eduardo@email.com");
        listaMensagens[1] = new MensagemSMS("62981257540");

        System.out.println("=== SISTEMA DE NOTIFICAÇÕES ===\n");

        // 2. Loop Polimórfico
        for (Mensagem m : listaMensagens) {
            
            // Comportamento Comum: Todas as mensagens sabem enviar
            m.enviar();

            // Comportamento por Interface: Nem todas têm prioridade ou agendamento
            // Usamos 'instanceof' para verificar as "habilidades" de cada objeto
            
            if (m instanceof Prioritario) {
                // Fazemos o Cast para acessar os métodos da Interface Prioritario
                Prioritario p = (Prioritario) m;
                p.definirPrioridade(Prioritario.maxNivel);
            }

            if (m instanceof Agendavel) {
                // Fazemos o Cast para acessar os métodos da Interface Agendavel
                Agendavel a = (Agendavel) m;
                a.agendar("25/12/2026");
                // Chamando o método default da interface
                a.cancelarAgendamento();
            }

            System.out.println("--------------------------------");
        }
    }
}
