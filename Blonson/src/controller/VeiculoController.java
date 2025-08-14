package controller; // Declara que a classe pertence ao pacote 'controller'.

// Importa as classes do JavaFX necessárias para a interface gráfica.
import javafx.fxml.FXML; // Anotação para vincular elementos do FXML a variáveis.
import javafx.scene.control.TextArea; // Componente para a área de texto.
import javafx.scene.control.TextField; // Componente para os campos de entrada de texto.

// Importa a classe de modelo 'Veiculo'.
import model.Veiculo;

// A classe 'VeiculoController' é o controlador da tela de cadastro de veículos.
public class VeiculoController {

    // A anotação @FXML injeta os elementos do FXML com o 'fx:id' correspondente.
    @FXML
    private TextField marcaField; // Campo de texto para a marca do veículo.
    @FXML
    private TextField modeloField; // Campo de texto para o modelo do veículo.
    @FXML
    private TextField anoField; // Campo de texto para o ano do veículo.
    @FXML
    private TextField placaField; // Campo de texto para a placa do veículo.
    @FXML
    private TextArea detalhesVeiculoArea; // Área de texto para exibir os detalhes.
    
    // Uma variável de instância para armazenar o objeto Veiculo que será criado.
    private Veiculo veiculo;

    // O método 'handleCadastrarVeiculo' é a ação a ser executada quando o botão de cadastro é clicado.
    @FXML
    public void handleCadastrarVeiculo() {
        try {
            // Obtém o texto digitado em cada campo de entrada.
            String marca = marcaField.getText();
            String modelo = modeloField.getText();
            String placa = placaField.getText();
            
            // Converte o texto do campo 'ano' para um número inteiro.
            // O 'Integer.parseInt' pode lançar uma exceção se o texto não for um número.
            int ano = Integer.parseInt(anoField.getText());

            // Cria uma nova instância da classe 'Veiculo' com os dados obtidos.
            veiculo = new Veiculo(marca, modelo, ano, placa);
            
            // Atualiza a área de texto da interface com os detalhes do veículo recém-criado.
            // O '\n' é usado para quebrar a linha.
            detalhesVeiculoArea.setText("Marca: " + veiculo.getMarca() + "\n" +
                                        "Modelo: " + veiculo.getModelo() + "\n" +
                                        "Ano: " + veiculo.getAno() + "\n" +
                                        "Placa: " + veiculo.getPlaca());
        } catch (NumberFormatException e) {
            // Se a conversão para 'int' falhar, esta exceção é capturada.
            // Uma mensagem de erro é exibida na área de texto para informar o usuário.
            detalhesVeiculoArea.setText("Erro: O campo Ano deve ser um número inteiro.");
            System.err.println("Erro de formato de número: " + e.getMessage());
        }
    }
}