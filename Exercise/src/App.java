public class App {
    public static void main(String[] args) throws Exception {
        MensagemEmail minhaMsg = new MensagemEmail("eduardobrb1@gmail.com");

        minhaMsg.tipoComunicacao();
        minhaMsg.enviar();
        minhaMsg.enviar("Pedido entregue do Mercado Livre");
    }
}
