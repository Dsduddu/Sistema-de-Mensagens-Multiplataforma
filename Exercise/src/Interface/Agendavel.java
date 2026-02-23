package Interface;

public interface Agendavel {
    void agendar(String data);

    default void cancelarAgendamento() {
        System.out.println("Agendamento cancelado com sucesso.");
    }
}
