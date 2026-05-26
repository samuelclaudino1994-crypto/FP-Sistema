package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    private BorderPane mainLayout; // Deixamos global para conseguir mudar o centro de qualquer lugar
    private String buttonStyle = "-fx-background-color: transparent; -fx-text-fill: #94a3b8; -fx-font-size: 14px; -fx-alignment: center-left; -fx-cursor: hand; -fx-width: 180px; -fx-padding: 10px 15px;";

    @Override
    public void start(Stage primaryStage) {
        mainLayout = new BorderPane();

        // --- MENU LATERAL ---
        VBox sidebar = new VBox(10);
        sidebar.setStyle("-fx-background-color: #1e293b; -fx-padding: 20px; -fx-pref-width: 220px;");

        Label menuTitle = new Label("FP Finanças");
        menuTitle
                .setStyle("-fx-text-fill: #ffffff; -fx-font-size: 18px; -fx-font-weight: bold; -fx-padding: 0 0 20 0;");

        Button btnDashboard = new Button("📊 Dashboard");
        Button btnTransacoes = new Button("💰 Movimentações");
        Button btnCategorias = new Button("📁 Categorias");

        // Estilo padrão para todos
        btnDashboard.setStyle(buttonStyle + "-fx-text-fill: #38bdf8; -fx-font-weight: bold;");
        btnTransacoes.setStyle(buttonStyle);
        btnCategorias.setStyle(buttonStyle);

        sidebar.getChildren().addAll(menuTitle, btnDashboard, btnTransacoes, btnCategorias);
        mainLayout.setLeft(sidebar);

        // Define a tela inicial como o Dashboard
        mainLayout.setCenter(criarTelaDashboard());

        // --- LÓGICA DOS CLIQUES (AÇÃO) ---
        btnDashboard.setOnAction(e -> {
            resetBotoes(btnDashboard, btnTransacoes, btnCategorias);
            btnDashboard.setStyle(buttonStyle + "-fx-text-fill: #38bdf8; -fx-font-weight: bold;");
            mainLayout.setCenter(criarTelaDashboard());
        });

        btnTransacoes.setOnAction(e -> {
            resetBotoes(btnDashboard, btnTransacoes, btnCategorias);
            btnTransacoes.setStyle(buttonStyle + "-fx-text-fill: #38bdf8; -fx-font-weight: bold;");
            mainLayout.setCenter(criarTelaMovimentacoes());
        });

        btnCategorias.setOnAction(e -> {
            resetBotoes(btnDashboard, btnTransacoes, btnCategorias);
            btnCategorias.setStyle(buttonStyle + "-fx-text-fill: #38bdf8; -fx-font-weight: bold;");
            mainLayout.setCenter(criarTelaCategorias());
        });

        Scene scene = new Scene(mainLayout, 1200, 850);
        primaryStage.setTitle("FP Finanças - MVP Desktop");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // --- FUNÇÃO PARA CRIAR A TELA DO DASHBOARD ---
    // É necessário importar o componente de gráfico no topo do arquivo:
    // import javafx.scene.chart.PieChart;

    private VBox criarTelaDashboard() {
        VBox content = new VBox(30);
        content.setStyle("-fx-background-color: #f8fafc; -fx-padding: 30px;");

        // --- SEÇÃO 1: CARDS GRANDES COM ÍCONES E PORCENTAGENS RETORNADAS ---
        HBox cardsContainer = new HBox(20);
        cardsContainer.getChildren().addAll(
                criarCardFinanceiro("Saldo Geral", "R$ 4.500,00", "#0f172a", "💰"),
                criarCardFinanceiro("Necessidades (55%)", "R$ 2.475,00", "#3b82f6", "🏠"),
                criarCardFinanceiro("Desejos (25%)", "R$ 1.125,00", "#eab308", "🍿"),
                criarCardFinanceiro("Investimentos (20%)", "R$ 900,00", "#a855f7", "📈"));

        // --- SEÇÃO 2: GRÁFICO E RESUMO/METAS (Lado a Lado) ---
        HBox mainRow = new HBox(25);
        mainRow.setPrefHeight(450);

        // Bloco do Gráfico (60% da largura)
        PieChart pieChart = new PieChart();

        // Adicionando os dados com a porcentagem escrita no próprio rótulo para
        // garantir a exibição
        // 1. Criando os 3 dados da pizza (Atenção à grafia certinha com
        // 'Investimentos')
        PieChart.Data fatiaNecessidades = new PieChart.Data("Necessidades (55%)", 55);
        PieChart.Data fatiaDesejos = new PieChart.Data("Desejos (25%)", 25);
        PieChart.Data fatiaInvestimentos = new PieChart.Data("Investimentos (20%)", 20);

        // 2. Adicionando os 3 na pizza (Todos separados por vírgula)
        pieChart.getData().addAll(fatiaNecessidades, fatiaDesejos, fatiaInvestimentos);
        // Configurações para o gráfico exibir as legendas e rótulos corretamente
        pieChart.setLabelsVisible(true); // Força o JavaFX a mostrar o texto na fatia
        pieChart.setLegendVisible(true); // Mostra a legenda colorida embaixo do gráfico

        VBox chartBox = new VBox(10, new Label("Distribuição Estratégica Real (55/25/20)"), pieChart);
        chartBox.setStyle(
                "-fx-background-color: #ffffff; -fx-padding: 20; -fx-background-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.04), 10, 0, 0, 4);");
        chartBox.setPrefWidth(600);

        // Bloco de Resumo/Metas (40% da largura)
        VBox summaryBox = new VBox(20);
        summaryBox.setStyle(
                "-fx-background-color: #ffffff; -fx-padding: 20; -fx-background-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.04), 10, 0, 0, 4);");
        summaryBox.setPrefWidth(350);

        Label lblSummaryTitle = new Label("Resumo de Metas");
        lblSummaryTitle.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        // Simulando itens de metas
        VBox meta1 = new VBox(5, new Label("Alimentação (Max R$ 800)"), new Label("Gasto: R$ 650"));
        meta1.setStyle("-fx-border-color: #f1f5f9; -fx-border-width: 0 0 1 0; -fx-padding: 0 0 10 0;");

        VBox meta2 = new VBox(5, new Label("Lazer (Max R$ 400)"), new Label("Gasto: R$ 380"));
        meta2.setStyle("-fx-border-color: #f1f5f9; -fx-border-width: 0 0 1 0; -fx-padding: 0 0 10 0;");

        summaryBox.getChildren().addAll(lblSummaryTitle, meta1, meta2);

        mainRow.getChildren().addAll(chartBox, summaryBox);

        // JUNTANDO TUDO
        content.getChildren().addAll(cardsContainer, mainRow);
        return content;
    }

    // --- FUNÇÃO PARA CRIAR A TELA DE MOVIMENTAÇÕES ---
    private VBox criarTelaMovimentacoes() {
        VBox content = new VBox(20);
        content.setStyle("-fx-background-color: #f8fafc; -fx-padding: 30px;");

        Label title = new Label("💰 Movimentações");
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");

        Label placeholder = new Label("Aqui vai entrar a sua tabela de transações e o botão de adicionar gasto.");
        placeholder.setStyle("-fx-font-size: 14px; -fx-text-fill: #64748b;");

        content.getChildren().addAll(title, placeholder);
        return content;
    }

    // --- FUNÇÃO PARA CRIAR A TELA DE CATEGORIAS ---
    private VBox criarTelaCategorias() {
        VBox content = new VBox(20);
        content.setStyle("-fx-background-color: #f8fafc; -fx-padding: 30px;");

        Label title = new Label("📁 Categorias");
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");

        Label placeholder = new Label("Gerenciamento de categorias (Alimentação, Transporte, Lazer...).");
        placeholder.setStyle("-fx-font-size: 14px; -fx-text-fill: #64748b;");

        content.getChildren().addAll(title, placeholder);
        return content;
    }

    // --- MÉTODO AUXILIAR PARA CRIAR CARDS RAPIDAMENTE ---
    private VBox criarCardFinanceiro(String titulo, String valor, String corValor, String icone) {
        VBox card = new VBox(5);
        // Ajustando altura entre 110 e 130px e largura mínima
        card.setPrefHeight(120);
        card.setMinHeight(110);
        card.setPrefWidth(220);

        card.setStyle("-fx-background-color: #ffffff; -fx-padding: 15px; -fx-background-radius: 12px; " +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.06), 10, 0, 0, 5);");

        Label lblIcone = new Label(icone);
        lblIcone.setStyle("-fx-font-size: 22px;"); // Tamanho do ícone

        Label lblTitle = new Label(titulo);
        lblTitle.setStyle("-fx-text-fill: #64748b; -fx-font-size: 13px; -fx-font-weight: bold;");

        Label lblValue = new Label(valor);
        lblValue.setStyle("-fx-font-size: 22px; -fx-font-weight: bold; -fx-text-fill: " + corValor + ";");

        // Organiza ícone no topo e textos abaixo
        card.getChildren().addAll(lblIcone, lblTitle, lblValue);
        return card;
    }

    // --- RESETAR COR DOS BOTÕES DO MENU ---
    private void resetBotoes(Button... botoes) {
        for (Button btn : botoes) {
            btn.setStyle(buttonStyle);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}