package controller; // Declara que a classe pertence ao pacote 'controller'.

// Importa as classes do JavaFX necessárias para a interface gráfica.
import javafx.fxml.FXML; // Anotação para vincular elementos do FXML a variáveis.
import javafx.scene.control.TextArea; // Componente para a área de texto.
import javafx.scene.control.TextField; // Componente para os campos de entrada de texto.

// Importa a classe de modelo 'Servico'.
import model.Servico;

// A classe 'ServicoController' é o controlador da tela de cadastro de serviços.
public class ServicoController {

    // A anotação @FXML injeta os elementos do FXML com o 'fx:id' correspondente.
    @FXML
    private TextField descricaoField; // Campo de texto para a descrição do serviço.
    @FXML
    private TextField custoField; // Campo de texto para o custo do serviço.
    @FXML
    private TextField tempoEstimadoField; // Campo de texto para o tempo estimado.
    @FXML
    private TextArea detalhesServicoArea; // Área de texto para exibir os detalhes do serviço.

    // Uma variável de instância para armazenar o objeto Servico que será criado.
    private Servico servico;

    // O método 'handleCadastrarServico' é a ação a ser executada quando o botão de cadastro é clicado.
    @FXML
    public void handleCadastrarServico() {
        try {
            // Obtém o texto digitado em cada campo de entrada.
            String descricao = descricaoField.getText();
            
            // Converte o texto dos campos de custo e tempo para números do tipo 'double'.
            // O 'Double.parseDouble' pode lançar uma exceção se o texto não for um número.
            double custo = Double.parseDouble(custoField.getText());
            double tempoEstimado = Double.parseDouble(tempoEstimadoField.getText());

            // Cria uma nova instância da classe 'Servico' com os dados obtidos.
            servico = new Servico(descricao, custo, tempoEstimado);

            // Atualiza a área de texto da interface com os detalhes do serviço recém-criado.
            // O '\n' é usado para quebrar a linha.
            detalhesServicoArea.setText("Descrição: " + servico.getDescricao() + "\n" +
                                        "Custo: R$" + servico.getCusto() + "\n" +
                                        "Tempo Estimado: " + servico.getTempoEstimadoEmHoras() + " horas");
        } catch (NumberFormatException e) {
            // Se a conversão para 'double' falhar (por exemplo, se o usuário digitar letras),
            // esta exceção é capturada e uma mensagem de erro é exibida.
            detalhesServicoArea.setText("Erro: Por favor, insira valores numéricos para o Custo e o Tempo Estimado.");
            System.err.println("Erro de formato de número: " + e.getMessage());
        }
    }
}