public abstract class Mensagem {
    protected String destinatario;

    public Mensagem(String destinatario) {
        this.destinatario = destinatario;
    }

    public void exibirDados() {
        System.out.println("Destinatario da Mensagem: " + this.destinatario);
    }

    public static void tipoComunicacao() {
        System.out.println("Inciando canal de comunicação... ");
    }

    public abstract void enviar();
}
