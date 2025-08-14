package controller; // Declara que esta classe pertence ao pacote 'controller'.

// Importa as classes do JavaFX necessárias para a aplicação.
import javafx.application.Application; // Classe base para todas as aplicações JavaFX.
import javafx.fxml.FXMLLoader;       // Utilitário para carregar arquivos FXML.
import javafx.scene.Parent;          // Classe base para nós com filhos no gráfico de cena.
import javafx.scene.Scene;           // Contêiner para todo o conteúdo da cena.
import javafx.stage.Stage;           // Contêiner de nível superior para a janela da aplicação.

// A classe 'MainApp' estende 'Application', um requisito para aplicações JavaFX.
public class MainApp extends Application {

    // O método 'start' é o ponto de entrada principal do JavaFX.
    // É chamado após o método 'launch' iniciar o sistema.
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Passo 1: Carregar o arquivo FXML
        // -----------------------------
        // FXMLLoader carrega um arquivo FXML que descreve a interface do usuário.
        // `getClass().getResource(...)` encontra o caminho do arquivo no classpath do projeto.
        // O caminho "/view/resources/main.fxml" aponta para a localização do seu arquivo FXML principal.
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/resources/main.fxml"));
        
        // Passo 2: Criar o gráfico de cena
        // -----------------------------
        // `loader.load()` lê o FXML e constrói a hierarquia dos componentes da UI.
        // O resultado é um objeto 'Parent', que é o nó raiz do gráfico de cena.
        Parent root = loader.load();

        // Passo 3: Configurar a cena e a janela
        // ----------------------------------
        // Uma 'Scene' é um contêiner para o conteúdo do gráfico de cena. Ela armazena o nó 'root'.
        Scene scene = new Scene(root);
        
        // 'primaryStage' é a janela principal da aplicação.
        // `setTitle(...)` define o texto exibido na barra de título da janela.
        primaryStage.setTitle("Oficina Mecânica Os Blonson - Menu Principal");
        
        // `setScene(...)` adiciona a cena ao stage principal.
        primaryStage.setScene(scene);
        
        // `show()` torna a janela visível para o usuário.
        primaryStage.show();
    }

    // Este é o método main padrão de uma aplicação Java.
    public static void main(String[] args) {
        // O comando `launch(args)` inicia o ambiente de execução do JavaFX.
        // Ele chama o método `start` da sua subclasse `Application`.
        launch(args);
    }
}