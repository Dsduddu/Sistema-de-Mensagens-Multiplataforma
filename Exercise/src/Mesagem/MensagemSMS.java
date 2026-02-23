package Mesagem;
import Interface.Prioritario;

public class MensagemSMS extends Mensagem implements Prioritario{

    public MensagemSMS(String destinatario) {
        super(destinatario);
    }

    @Override
    public void enviar() {
        System.out.println("Enviando SMS para: " + this.destinatario);
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
