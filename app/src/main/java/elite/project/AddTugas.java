package elite.project;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AddTugas extends Stage {

    public AddTugas() {
        setTitle("NugasKuy");

        // Mengubah icon aplikasi saat di run
        Image icon = new Image(getClass().getResourceAsStream("/img/NugasKuy.png"));
        getIcons().add(icon);

        // Image statusbar di top bar
        Image statusBar = new Image(getClass().getResourceAsStream("/img/StatusBar.png"));
        ImageView viewStatusBar = new ImageView(statusBar);
        VBox vBox = new VBox(viewStatusBar);
        vBox.setStyle("-fx-background-color: rgb(44, 48, 57)");

        // label untuk inputfield judul tugas
        Label judulTugas = new Label("Judul Tugas");
        judulTugas.setFont(Font.loadFont(getClass().getResourceAsStream("/Poppins-Medium.ttf"), 16));
        judulTugas.setTextFill(Color.WHITE);
        judulTugas.setPadding(new Insets(0, 0, 12, 0));

        // inputfield untuk judul tugas
        TextField juduField = new TextField();
        juduField.setStyle(
                "-fx-background-color: black; -fx-background-radius: 12px; -fx-text-fill: white; -fx-background-insets: 0 0 -12 0; -fx-alignment: center-left; -fx-font-family: 'Poppins'; -fx-font-size: 18px; -fx-font-weight: 600;");
        juduField.setAlignment(Pos.CENTER);
        juduField.setFont(Font.loadFont(getClass().getResourceAsStream("/Poppins-Regular.ttf"), 16));

        // label untuk inputfield tag
        Label tag = new Label("Tag");
        tag.setFont(Font.loadFont(getClass().getResourceAsStream("/Poppins-Medium.ttf"), 16));
        tag.setTextFill(Color.WHITE);

        // inputfield untuk tag
        TextField tagField = new TextField();
        tagField.setStyle(
                "-fx-background-color: black; -fx-background-radius: 12px; -fx-text-fill: white; -fx-background-insets: 0 0 -12 0; -fx-alignment: center-left; -fx-font-family: 'Poppins'; -fx-font-size: 18px; -fx-font-weight: 600;");
        tagField.setAlignment(Pos.CENTER);
        tagField.setFont(Font.loadFont(getClass().getResourceAsStream("/Poppins-Regular.ttf"), 16));

        // label untuk inputfield label tugas
        Label label = new Label("Label");
        label.setFont(Font.loadFont(getClass().getResourceAsStream("/Poppins-Medium.ttf"), 16));
        label.setTextFill(Color.WHITE);

        // inputfield untuk label tugas
        TextField labelField = new TextField();
        labelField.setStyle(
                "-fx-background-color: black; -fx-background-radius: 12px; -fx-text-fill: white; -fx-background-insets: 0 0 -12 0; -fx-alignment: center-left; -fx-font-family: 'Poppins'; -fx-font-size: 18px; -fx-font-weight: 600;");
        labelField.setAlignment(Pos.CENTER);
        labelField.setFont(Font.loadFont(getClass().getResourceAsStream("/Poppins-Regular.ttf"), 16));

        // label untuk inputfield deadline tugas
        Label deadline = new Label("Deadline");
        deadline.setFont(Font.loadFont(getClass().getResourceAsStream("/Poppins-Medium.ttf"), 16));
        deadline.setTextFill(Color.WHITE);
        deadline.setLineSpacing(12);

        // inputfield untuk deadline tugas
        TextField deadlineField = new TextField();
        deadlineField.setStyle(
                "-fx-background-color: black; -fx-background-radius: 12px; -fx-text-fill: white; -fx-background-insets: 0 0 -12 0; -fx-alignment: center-left; -fx-font-family: 'Poppins'; -fx-font-size: 18px; -fx-font-weight: 600;");
        deadlineField.setAlignment(Pos.CENTER);
        deadlineField.setFont(Font.loadFont(getClass().getResourceAsStream("/Poppins-Regular.ttf"), 16));

        VBox inputContainer = new VBox();
        inputContainer.setSpacing(12);

        // Button Simpan
        Button simpaButton = new Button("Simpan");
        simpaButton.setPrefWidth(258);
        simpaButton.setPrefHeight(55);
        simpaButton.setLineSpacing(25);
        simpaButton.setFont(Font.loadFont(getClass().getResourceAsStream("/Poppins-Medium.ttf"), 24));
        simpaButton.setStyle(
                "-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-background-radius: 16px; -fx-alignment: TOP_CENTER;");

        // Vbox
        VBox vLayout = new VBox(vBox, judulTugas, juduField, tag, tagField, label, labelField, deadline, deadlineField,
                simpaButton);
        vLayout.setStyle("-fx-background-color: #222831");
        vLayout.setAlignment(Pos.TOP_CENTER);
        vLayout.setSpacing(15);
        // Menampilkan konten di dalam stage
        Scene scene = new Scene(vLayout, 428, 999);
        setResizable(false);
        setScene(scene);
    }
}
