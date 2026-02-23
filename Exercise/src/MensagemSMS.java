public class MensagemSMS extends Mensagem{

    public MensagemSMS(String destinatario) {
        super(destinatario);
    }

    @Override
    public void enviar() {
        System.out.println("Enviando SMS para: " + this.destinatario);
    }

    public void enviar(String assunto) {
        System.out.println(assunto);
    }
}
