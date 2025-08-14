package controller; // Define que a classe pertence ao pacote 'controller'.

// Importa as classes do JavaFX necessárias para a interface gráfica.
import javafx.fxml.FXML; // Anotação para vincular elementos do FXML a variáveis.
import javafx.scene.control.TextArea; // Componente para a área de texto.
import javafx.scene.control.TextField; // Componente para os campos de entrada de texto.
import javafx.scene.control.TextFormatter; // Classe para formatar texto em tempo real.

// Importa a interface funcional 'UnaryOperator' para definir a lógica da máscara.
import java.util.function.UnaryOperator;

// Importa a classe de modelo 'Cliente'.
import model.Cliente;

// A classe 'AtendimentoController' é o controlador da tela de atendimento.
public class AtendimentoController {

    // A anotação @FXML injeta os elementos do FXML com o 'fx:id' correspondente.
    // Assim, podemos manipular esses elementos diretamente no código.
    @FXML
    private TextField nomeClienteField; // Campo de texto para o nome do cliente.
    @FXML
    private TextField telefoneClienteField; // Campo de texto para o telefone do cliente.
    @FXML
    private TextField emailClienteField; // Campo de texto para o e-mail do cliente.
    @FXML
    private TextArea detalhesClienteArea; // Área de texto para exibir os detalhes do cliente.

    // Uma variável de instância para armazenar o objeto Cliente que será criado.
    private Cliente cliente;

    // O método 'initialize' é chamado automaticamente após a tela FXML ser carregada.
    // É o local ideal para fazer configurações iniciais, como aplicar a máscara.
    @FXML
    public void initialize() {
        // UnaryOperator define uma função que pega um valor e retorna um valor do mesmo tipo.
        // Aqui, ela pega um 'TextFormatter.Change' e retorna um 'TextFormatter.Change'.
        // É a lógica que define como o texto será formatado.
        UnaryOperator<TextFormatter.Change> filter = change -> {
            // Obtém o novo texto que está no campo após a digitação.
            String newText = change.getControlNewText();

            // Usa uma expressão regular para remover todos os caracteres que não são dígitos.
            // Isso garante que a formatação seja feita apenas nos números.
            String digitsOnly = newText.replaceAll("[^\\d]", "");
            
            // Verifica se o número de dígitos é maior que 11 (DDD + 9 dígitos).
            // Se for, a digitação é ignorada (retorna 'null').
            if (digitsOnly.length() > 11) {
                return null;
            }

            // O StringBuilder é mais eficiente para manipular strings, pois não cria novos objetos a cada alteração.
            StringBuilder formatted = new StringBuilder();
            
            // Inicia a formatação se houver pelo menos um dígito.
            if (digitsOnly.length() > 0) {
                formatted.append("("); // Adiciona o parêntese de abertura.
                
                // Se houver mais de 2 dígitos, adiciona o DDD.
                if (digitsOnly.length() > 2) {
                    formatted.append(digitsOnly.substring(0, 2)).append(") ");
                    
                    // Se houver mais de 7 dígitos, adiciona o hífen.
                    if (digitsOnly.length() > 7) {
                        formatted.append(digitsOnly.substring(2, 7)).append("-");
                        formatted.append(digitsOnly.substring(7)); // Adiciona o restante dos dígitos.
                    } else {
                        formatted.append(digitsOnly.substring(2)); // Adiciona os dígitos restantes sem o hífen.
                    }
                } else {
                    formatted.append(digitsOnly); // Adiciona os dígitos se o DDD não estiver completo.
                }
            }

            // Define o novo texto do campo com a string que acabamos de formatar.
            change.setText(formatted.toString());
            
            // Essas duas linhas são a chave para corrigir o problema do cursor.
            // Elas forçam o cursor a se mover para o final do texto após a formatação.
            change.setRange(0, change.getControlText().length());
            change.setCaretPosition(formatted.length());
            change.setAnchor(formatted.length());

            // Retorna o objeto 'change' formatado.
            return change;
        };

        // Aplica o 'TextFormatter' que criamos ao campo de texto do telefone.
        telefoneClienteField.setTextFormatter(new TextFormatter<>(filter));
    }

    // Este método é chamado quando o botão "Cadastrar Cliente" é clicado.
    // O evento 'onAction' no FXML está vinculado a ele.
    @FXML
    public void handleCadastrarCliente() {
        // Obtém o texto digitado em cada campo de texto.
        String nome = nomeClienteField.getText();
        String telefone = telefoneClienteField.getText();
        String email = emailClienteField.getText();

        // Cria uma nova instância da classe 'Cliente' com os dados obtidos.
        // O valor '1' é um ID de exemplo.
        cliente = new Cliente(nome, telefone, email, 1);
        
        // Atualiza o conteúdo da área de texto na interface gráfica.
        // O caractere '\n' cria uma nova linha para formatar a saída.
        detalhesClienteArea.setText("ID: " + cliente.getIdCliente() + "\n" +
                                    "Nome: " + cliente.getNome() + "\n" +
                                    "Celular: " + cliente.getTelefone() + "\n" +
                                    "Email: " + cliente.getEmail());
    }
}