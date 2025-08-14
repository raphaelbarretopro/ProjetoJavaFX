package model; // Declara que a classe pertence ao pacote 'model'.
              // Isso organiza o código por responsabilidade (separando modelos, controladores, etc.).

// Importa outras classes de modelo que um agendamento precisa para funcionar.
import model.Cliente;
import model.Veiculo;

// A classe 'Agendamento' representa um agendamento na sua aplicação.
public class Agendamento {
    
    // Atributos (campos) da classe. Eles definem as características de um agendamento.
    private String dataHora; // Armazena a data e a hora do agendamento.
    private Cliente cliente; // Armazena o objeto Cliente associado a este agendamento.
    private Veiculo veiculo; // Armazena o objeto Veiculo associado a este agendamento.
    private String servicosAgendados; // Armazena uma descrição dos serviços a serem realizados.
    private String status; // Armazena o status do agendamento (ex: "Agendado", "Concluído").

    // Construtor da classe.
    // Ele é usado para criar uma nova instância de 'Agendamento' e inicializar seus atributos.
    public Agendamento(String dataHora, Cliente cliente, Veiculo veiculo, String servicosAgendados) {
        this.dataHora = dataHora; // 'this.dataHora' refere-se ao atributo da classe.
                                 // 'dataHora' refere-se ao parâmetro do construtor.
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.servicosAgendados = servicosAgendados;
        this.status = "Agendado"; // Define o status inicial do agendamento como "Agendado".
    }

    // Métodos de acesso (Getters).
    // Eles permitem que outras classes obtenham o valor de um atributo privado.
    // 'public' significa que o método pode ser chamado de qualquer lugar.
    public String getDataHora() {
        return dataHora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public String getServicosAgendados() {
        return servicosAgendados;
    }

    public String getStatus() {
        return status;
    }

    // Métodos (Comportamentos).
    // Eles definem o que um objeto 'Agendamento' pode fazer.
    public void exibirAgendamentoCompleto() {
        // Exibe todos os detalhes do agendamento no console.
        System.out.println("\n--- Detalhes do Agendamento ---");
        System.out.println("Data e Hora: " + dataHora);
        System.out.println("Status: " + status);
        
        System.out.println("\nInformações do Cliente:");
        // Chama um método do objeto 'cliente' para exibir seus próprios detalhes.
        cliente.exibirDetalhesCliente();
        
        System.out.println("\nInformações do Veículo:");
        // Chama um método do objeto 'veiculo' para exibir suas próprias informações.
        veiculo.exibirInformacoesVeiculo();
        
        System.out.println("\nServiços Agendados: " + servicosAgendados);
        System.out.println("------------------------------");
    }

    // Método para atualizar o status do agendamento.
    // Ele recebe o novo status como parâmetro.
    public void atualizarStatus(String novoStatus) {
        this.status = novoStatus; // Atribui o novo status ao atributo 'status'.
        System.out.println("Status do agendamento atualizado para: " + novoStatus);
    }
}