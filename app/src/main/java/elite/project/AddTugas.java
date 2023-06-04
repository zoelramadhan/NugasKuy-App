package elite.project;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AddTugas  {
    private Stage stage;

    public AddTugas(Stage stage) {
        this.stage = stage;
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
        deadlineField.setAlignment(Pos.CENTER_LEFT);
        deadlineField.setFont(Font.loadFont(getClass().getResourceAsStream("/Poppins-Regular.ttf"), 16));

        VBox inputContainer1 = new VBox(judulTugas, juduField);
        inputContainer1.setSpacing(10);
        inputContainer1.setAlignment(Pos.CENTER_LEFT);

        VBox inputContainer2 = new VBox(tag, tagField);
        inputContainer2.setSpacing(10);
        inputContainer2.setAlignment(Pos.CENTER_LEFT);

        VBox inputContainer3 = new VBox(label, labelField);
        inputContainer3.setSpacing(10);
        inputContainer3.setAlignment(Pos.CENTER_LEFT);

        VBox inputContainer4 = new VBox(deadline, deadlineField);
        inputContainer4.setSpacing(10);
        inputContainer4.setAlignment(Pos.CENTER_LEFT);

        VBox inputContainer = new VBox(inputContainer1, inputContainer2, inputContainer3, inputContainer4);
        inputContainer.setSpacing(50);
        inputContainer.setAlignment(Pos.CENTER);
        inputContainer.setPadding(new Insets(0, 15, 0, 15));

        // Button Simpan
        Button simpanButton = new Button("Simpan");
        simpanButton.setPrefWidth(396);
        simpanButton.setPrefHeight(58);
        simpanButton.setLineSpacing(25);
        simpanButton.setAlignment(Pos.CENTER);
        simpanButton.setFont(Font.loadFont(getClass().getResourceAsStream("/Poppins-Medium.ttf"), 25));
        simpanButton.setStyle(
                "-fx-background-color: #6773E9; -fx-text-fill: white; -fx-background-radius: 16px; -fx-alignment: TOP_CENTER;");

        simpanButton.setOnAction(event -> {
            String judul = juduField.getText();
            String tagString = tagField.getText();
            String laString = labelField.getText();
            String deString = deadlineField.getText();
    
            // Membuat objek Card dengan data inputan
            Card card = new Card(stage);
            card.show(judul, tagString, laString, deString);
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

    private VBox createTaskBox(Task task) {
        // Kotak centang status
        Rectangle checkBox = new Rectangle(24, 24);
        checkBox.setFill(Color.BLACK);
        checkBox.setStroke(Color.GREEN);

        // Label judul tugas
        Label judulLabel = new Label(task.getJudul());
        judulLabel.setFont(Font.loadFont(getClass().getResourceAsStream("/Poppins-Medium.ttf"), 16));
        judulLabel.setTextFill(Color.WHITE);

        // Label tag dan label tugas
        Label tagLabel = new Label(task.getTag());
        Label labelLabel = new Label(task.getLabel());
        Label deadlineLabel = new Label(task.getDeadline());
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

        VBox taskBox = new VBox();
        taskBox.setStyle("-fx-background-color: black; -fx-padding: 10; -fx-background-radius: 12px;");
        taskBox.setMinSize(396, 71);
        taskBox.setMaxSize(396, 71);
        taskBox.setAlignment(Pos.CENTER);
        taskBox.getChildren().addAll(hBoxcard1);

        return taskBox;
    }

    private class Task {
        private String judul;
        private String tag;
        private String label;
        private String deadline;

        public Task(String judul, String tag, String label, String deadline) {
            this.judul = judul;
            this.tag = tag;
            this.label = label;
            this.deadline = deadline;
        }

        public String getJudul() {
            return judul;
        }

        public String getTag() {
            return tag;
        }

        public String getLabel() {
            return label;
        }

        public String getDeadline() {
            return deadline;
        }
    }

}
