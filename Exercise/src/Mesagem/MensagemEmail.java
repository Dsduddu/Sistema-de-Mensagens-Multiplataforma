package Mesagem;
import Interface.Agendavel;
import Interface.Prioritario;

public class MensagemEmail extends Mensagem implements Agendavel, Prioritario{
    
    public MensagemEmail(String destinatario) {
        super(destinatario);
    }

    @Override
    public void enviar() {
        System.out.println("Enviando E-mail para: " + this.destinatario);
    }

    public void enviar(String assunto) {
        System.out.println(assunto);
    }

    @Override
    public void agendar(String data) {
        System.out.println("E-mail agendado para a data: " + data);
    }

    @Override
    public void definirPrioridade(int nivel) {
        if (nivel > maxNivel) {
            System.out.println("Erro, nível de prioridade máximo 10");
        } else {
            System.out.println("Prioridade definidade: " + nivel);
        }
    }
}
