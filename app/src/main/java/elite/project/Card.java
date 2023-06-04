package elite.project;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Card {
    private Stage stage;

    public Card(Stage stage) {
        this.stage = stage;
    }

    public void show(String judul, String tag, String label, String deadline) {

        Image background = new Image(getClass().getResourceAsStream("/img/HomeAddToDo.png"));

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(20));
        root.setBackground(new Background(new BackgroundImage(background, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));

        // Kotak centang status
        Rectangle checkBox = new Rectangle(24, 24);
        checkBox.setFill(Color.BLACK);
        checkBox.setStroke(Color.GREEN);

        // Label judul tugas
        Label judulLabel = new Label(judul);
        judulLabel.setFont(Font.loadFont(getClass().getResourceAsStream("/Poppins-Medium.ttf"), 16));
        judulLabel.setTextFill(Color.WHITE);

        // Label tag dan label tugas
        Label tagLabel = new Label(tag);
        Label labelLabel = new Label(label);
        Label deadlineLabel = new Label(deadline);
        tagLabel.setFont(Font.loadFont(getClass().getResourceAsStream("/Poppins-Regular.ttf"), 14));
        labelLabel.setFont(Font.loadFont(getClass().getResourceAsStream("/Poppins-Regular.ttf"), 14));
        tagLabel.setTextFill(Color.WHITE);
        labelLabel.setTextFill(Color.WHITE);

        VBox vbox1 = new VBox(judulLabel, labelLabel);
        vbox1.setSpacing(6);

        VBox vbox2 = new VBox(tagLabel, deadlineLabel);
        vbox2.setSpacing(6);

        HBox hboxCard = new HBox(checkBox, vbox1);
        hboxCard.setSpacing(20);
        hboxCard.setAlignment(Pos.CENTER);

        HBox hBoxcard1 = new HBox(hboxCard, vbox2);
        hBoxcard1.setAlignment(Pos.CENTER);
        hBoxcard1.setSpacing(240);


        // membuat tombol
        Button addTask = new Button("Tambah Tugas");
        addTask.setFont(Font.loadFont(getClass().getResourceAsStream("/Poppins-Medium.ttf"), 22));
        addTask.setAlignment(Pos.CENTER);
        addTask.setPrefWidth(300);
        addTask.setPrefHeight(40);
        addTask.setStyle(
                "-fx-background-color: #6773E9; -fx-text-fill: white; -fx-background-radius: 16px;");

        VBox vLayout = new VBox();
        vLayout.setStyle("-fx-background-color: black; -fx-padding: 10; -fx-background-radius: 12px;");
        vLayout.setMinSize(396, 71);
        vLayout.setMaxSize(396, 71);
        vLayout.setAlignment(Pos.CENTER);

        VBox button1 = new VBox(addTask);
        button1.setAlignment(Pos.CENTER);

        // Menambahkan ImageView ke dalam vLayout
        vLayout.getChildren().addAll(hBoxcard1);

        root.setCenter(vLayout);
        root.setBottom(button1);

        Scene scene = new Scene(root, 428, 928);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}
