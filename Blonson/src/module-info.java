module Blonson {
    // Define o nome do módulo do seu projeto como "Blonson"

    requires javafx.controls;
    // Necessário para usar controles do JavaFX (Button, Label, TextField, etc.)

    requires javafx.fxml;
    // Necessário para carregar arquivos FXML (a interface declarativa)

    requires javafx.graphics;
    // Necessário para trabalhar com a parte gráfica (Scene, Stage, Canvas, etc.)

    // Esta linha comentada seria usada se você tivesse uma classe principal dentro do pacote 'application'
    //exports application;
    //opens application to javafx.fxml;

    exports controller;
    // Permite que outros módulos acessem as classes do pacote 'controller'

    opens controller to javafx.fxml;
    // Permite que o JavaFX acesse classes do pacote 'controller' via reflexão, essencial para vincular FXML aos controllers

    exports model;
    // Permite que outros módulos acessem as classes do pacote 'model'

    opens model to javafx.fxml;
    // Permite que o JavaFX acesse classes do pacote 'model' via reflexão
}
