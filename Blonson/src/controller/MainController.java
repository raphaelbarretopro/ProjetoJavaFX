package controller; // Declara que a classe está no pacote 'controller'.

// Importa as classes do JavaFX necessárias para o controlador.
import javafx.fxml.FXML;           // Anotação para vincular métodos a eventos do FXML.
import javafx.fxml.FXMLLoader;     // Utilitário para carregar arquivos FXML.
import javafx.scene.Parent;        // A raiz do gráfico de cena de uma nova janela.
import javafx.scene.Scene;         // O contêiner de todos os elementos visuais da nova janela.
import javafx.stage.Stage;         // A nova janela (stage) que será criada.

import java.io.IOException;        // Importa a exceção de entrada/saída.

// A classe 'MainController' controla as ações da tela principal.
public class MainController {

    // A anotação @FXML vincula este método a um evento 'onAction' no FXML (ex: um clique de botão).
    @FXML
    public void abrirTelaCadastrarCliente() throws IOException {
        
        // Passo 1: Carregar o arquivo FXML.
        // FXMLLoader carrega a definição de layout do 'Atendimento.fxml'.
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/resources/Atendimento.fxml"));
        
        // Passo 2: Criar a hierarquia de componentes.
        // O método 'load()' constrói a interface e retorna o nó raiz.
        Parent root = loader.load();
        
        // Passo 3: Criar e configurar a nova janela (Stage).
        // Cria um novo 'Stage' (janela) que será o contêiner da nova tela.
        Stage stage = new Stage();
        stage.setTitle("Cadastro de Cliente"); // Define o título da janela.
        
        // Passo 4: Criar a cena e exibi-la.
        // Cria uma 'Scene' com o 'root' e a define na nova janela.
        stage.setScene(new Scene(root));
        stage.show(); // Torna a nova janela visível.
    }

    @FXML
    public void abrirTelaCadastrarVeiculo() throws IOException {
        // A lógica é a mesma da função acima, mas para o cadastro de veículos.
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/resources/Veiculo.fxml"));
    	Parent root = loader.load();
    	Stage stage = new Stage();
    	stage.setTitle("Cadastro de Veículo");
    	stage.setScene(new Scene(root));
    	stage.show();
    }

    @FXML
    public void abrirTelaCadastrarServico() throws IOException {
        // Lógica para abrir a tela de cadastro de serviço.
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/resources/Servico.fxml"));
    	Parent root = loader.load();
    	Stage stage = new Stage();
    	stage.setTitle("Cadastro de Serviço");
    	stage.setScene(new Scene(root));
    	stage.show();
    }

    @FXML
    public void abrirTelaAgendarServico() throws IOException {
        // Lógica para abrir a tela de agendamento.
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/resources/Agendamento.fxml"));
    	Parent root = loader.load();
    	Stage stage = new Stage();
    	stage.setTitle("Agendar Serviço");
    	stage.setScene(new Scene(root));
    	stage.show();
    }
}