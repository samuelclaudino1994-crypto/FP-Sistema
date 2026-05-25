package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Criando um componente simples de texto
        Label label = new Label("FP Finanças - Inteligência Orçamentária");
        // Ajustando uma fonte um pouco maior e negrito para testar o visual
        label.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #2c3e50;");

        // Layout básico: organiza os elementos no centro
        StackPane root = new StackPane();
        root.getChildren().add(label);

        // Criando a cena com tamanho de 800x600 (bom tamanho para um Dashboard inicial)
        Scene scene = new Scene(root, 800, 600);

        // Configurando o Palco (Janela)
        primaryStage.setTitle("FP Finanças - MVP Desktop");
        primaryStage.setScene(scene);
        primaryStage.show(); // Exibe a janela
    }

    public static void main(String[] args) {
        launch(args);
    }
}