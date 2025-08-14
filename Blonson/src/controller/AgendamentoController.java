package controller; // Declaração do pacote onde a classe está localizada.

// Importa classes do JavaFX necessárias para a interface.
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

// Importa as classes de modelo que você criou.
import model.Agendamento;
import model.Cliente;
import model.Veiculo;
import model.Servico;

// A classe 'AgendamentoController' é responsável por controlar a tela de agendamento.
public class AgendamentoController {

    // Declaração dos elementos da interface gráfica.
    // A anotação '@FXML' é usada para injetar os elementos da tela definidos no arquivo FXML.
    @FXML
    private TextField clienteIdField; // Campo de texto para o ID do cliente.
    @FXML
    private TextField veiculoPlacaField; // Campo de texto para a placa do veículo.
    @FXML
    private TextField servicoDescricaoField; // Campo de texto para a descrição do serviço.
    @FXML
    private DatePicker dataAgendamentoPicker; // Componente para selecionar a data.
    @FXML
    private TextArea detalhesAgendamentoArea; // Área de texto para exibir os detalhes.
    
    private Agendamento agendamento; // Variável para armazenar o objeto de agendamento criado.

    // O método 'handleAgendarServico' é a lógica executada quando o botão "Agendar" é clicado.
    @FXML
    public void handleAgendarServico() {
        
        // **Lógica de busca de cliente, veículo e serviço (simplificada para o exemplo)**
        // Em uma aplicação real, você faria uma busca em um banco de dados
        // usando o ID do cliente e a placa do veículo para encontrar os objetos correspondentes.
        // Aqui, estamos a criar objetos de exemplo para demonstrar a funcionalidade.
        
        // Cria um objeto 'Cliente' de exemplo, pegando o ID do campo de texto.
        Cliente cliente = new Cliente("Exemplo Cliente", "(11) 99999-9999", "email@exemplo.com", Integer.parseInt(clienteIdField.getText()));
        
        // Cria um objeto 'Veiculo' de exemplo, pegando a placa do campo de texto.
        Veiculo veiculo = new Veiculo("Exemplo Marca", "Exemplo Modelo", 2020, veiculoPlacaField.getText());
        
        // Cria um objeto 'Servico' de exemplo, pegando a descrição do campo.
        Servico servico = new Servico(servicoDescricaoField.getText(), 150.00, 2.0);

        // Pega o valor do DatePicker (que é um objeto LocalDate) e o converte para uma String.
        String dataHora = dataAgendamentoPicker.getValue().toString();
        
        // Cria uma nova instância de 'Agendamento' com os dados coletados.
        // Ele usa os objetos 'cliente', 'veiculo' e a descrição do serviço.
        agendamento = new Agendamento(dataHora, cliente, veiculo, servico.getDescricao());

        // Atualiza a área de texto para exibir os detalhes do agendamento recém-criado.
        // O método '\n' é usado para quebrar a linha e formatar a saída.
        detalhesAgendamentoArea.setText("Agendamento Criado:" + "\n" +
                                        "Data e Hora: " + agendamento.getDataHora() + "\n" +
                                        "Cliente: " + agendamento.getCliente().getNome() + "\n" +
                                        "Veículo: " + agendamento.getVeiculo().getModelo() + "\n" +
                                        "Serviço: " + agendamento.getServicosAgendados());
    }
}