package elite.project;

import elite.models.Task;
import elite.models.User;
import javafx.collections.ObservableList;
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

public class AddTugas  {
        private Stage stage;
        private User user;
        private ObservableList<Task> listTask;

        public AddTugas(Stage stage, User user,  ObservableList<Task> listTask) {
                this.stage = stage;
                this.user = user;
                this.listTask = listTask;
            }
        
    public void show() {
        stage.setTitle("NugasKuy");

        // Mengubah icon aplikasi saat di run
        Image icon = new Image(getClass().getResourceAsStream("/img/NugasKuy.png"));
        stage.getIcons().add(icon);

        // Image statusbar di top bar
        Image statusBar = new Image(getClass().getResourceAsStream("/img/StatusBar.png"));
        ImageView viewStatusBar = new ImageView(statusBar);
        VBox vBoxStatusBar = new VBox(viewStatusBar);
        vBoxStatusBar.setAlignment(Pos.TOP_CENTER);
        vBoxStatusBar.setStyle("-fx-background-color: rgb(44, 48, 57)");

        // label untuk inputfield judul tugas
        Label judulTugas = new Label("Judul Tugas");
        judulTugas.setFont(Font.loadFont(getClass().getResourceAsStream("/Poppins-Medium.ttf"), 16));
        judulTugas.setTextFill(Color.WHITE);

        // inputfield untuk judul tugas
        TextField juduField = new TextField();
        judulTugas.setAlignment(Pos.CENTER);
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
        deadlineField.setAlignment(Pos.CENTER_LEFT);
        deadlineField.setFont(Font.loadFont(getClass().getResourceAsStream("/Poppins-Regular.ttf"), 16));

        VBox inputContainer1 = new VBox(judulTugas, juduField);
        inputContainer1.setSpacing(7);
        inputContainer1.setAlignment(Pos.CENTER_LEFT);

        VBox inputContainer2 = new VBox(tag, tagField);
        inputContainer2.setSpacing(7);
        inputContainer2.setAlignment(Pos.CENTER_LEFT);

        VBox inputContainer3 = new VBox(label, labelField);
        inputContainer3.setSpacing(7);
        inputContainer3.setAlignment(Pos.CENTER_LEFT);

        VBox inputContainer4 = new VBox(deadline, deadlineField);
        inputContainer4.setSpacing(7);
        inputContainer4.setAlignment(Pos.CENTER_LEFT);

        VBox inputContainer = new VBox(inputContainer1, inputContainer2, inputContainer3, inputContainer4);
        inputContainer.setSpacing(35);
        inputContainer.setAlignment(Pos.TOP_CENTER);
        inputContainer.setPadding(new Insets(0, 15, 0, 15));

        // Button Simpan
        Button simpanButton = new Button("Simpan");
        simpanButton.setPrefWidth(398);
        simpanButton.setPrefHeight(55);
        simpanButton.setLineSpacing(25);
        simpanButton.setAlignment(Pos.CENTER);
        simpanButton.setFont(Font.loadFont(getClass().getResourceAsStream("/Poppins-Medium.ttf"), 24));
        simpanButton.setStyle(
                "-fx-background-color: #6773E9; -fx-text-fill: white; -fx-background-radius: 26px; -fx-alignment: CENTER;");

        simpanButton.setOnAction(event -> {
                String judul = juduField.getText();
                String tagString = tagField.getText();
                String laString = labelField.getText();
                String deString = deadlineField.getText();

                Task task = new Task(judul, tagString, laString, deString);
                listTask.add(task);
                Home home = new Home(stage, user, listTask);
                home.show();
            });
            
        
            VBox layoutButton = new VBox(simpanButton);
            layoutButton.setAlignment(Pos.CENTER);
    
            VBox vLayout = new VBox(vBoxStatusBar, inputContainer, layoutButton);
            vLayout.setStyle("-fx-background-color: #222831");
            vLayout.setAlignment(Pos.TOP_CENTER);
            vLayout.setSpacing(50);
    
            // Menampilkan konten di dalam stage
            Scene scene = new Scene(vLayout, 428, 926);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
    }
}