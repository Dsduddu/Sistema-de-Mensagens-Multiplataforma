package Mesagem;
public class MensagemEmail extends Mensagem{

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
}
