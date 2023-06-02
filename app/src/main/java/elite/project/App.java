package elite.project;

import java.util.HashMap;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class App extends Application {

    private static final int TITLE_SIZE = 24;
    private static final int CHARACTER_IMAGE_SIZE = 110;
    private String selectedCharacter;
    private String inputName;
    private StackPane selectedCharacterPane;
    private Stage primaryStage;

    @Override
    public void start(Stage stage) throws Exception {
        this.primaryStage = stage;
        stage.setTitle("NugasKuy");

        // Mengubah icon aplikasi saat di run
        Image icon = new Image(getClass().getResourceAsStream("/img/NugasKuy.png"));
        stage.getIcons().add(icon);

        // Image statusbar di top bar
        Image statusBar = new Image(getClass().getResourceAsStream("/img/StatusBar.png"));
        ImageView viewStatusBar = new ImageView(statusBar);
        VBox vBox = new VBox(viewStatusBar);
        vBox.setStyle("-fx-background-color: rgb(44, 48, 57)");

        VBox titleContainer = new VBox();
        titleContainer.setPadding(new Insets(12));
        titleContainer.setPrefSize(400, 100);

        // Menampilkan Greatings
        Label title = new Label("Halo");
        title.setFont(Font.loadFont(getClass().getResourceAsStream("/Poppins-Medium.ttf"), TITLE_SIZE));
        title.setTextFill(Color.WHITE);

        // Menambahkan interaksi gambar emot
        Image waving = new Image(getClass().getResourceAsStream("/img/waving.png"));
        ImageView wavingImageView = new ImageView(waving);
        wavingImageView.setFitHeight(25);
        wavingImageView.setFitWidth(25);

        // membungkus title dengan waving menjadi horizontal
        HBox hbox = new HBox(title, wavingImageView);
        hbox.setSpacing(6);
        hbox.setPadding(new Insets(140, 0, 0, 16));
        HBox.setMargin(title, new Insets(0, 0, 0, -16)); // Atur margin untuk label

        // label untuk greatings tambahan
        Label welcomeLabel = new Label("Selamat Datang di");
        welcomeLabel.setFont(Font.loadFont(getClass().getResourceAsStream("/Poppins-Medium.ttf"), TITLE_SIZE));
        welcomeLabel.setTextFill(Color.WHITE);

        // underlined untuk menekankan branding warna hijau nugasKuy
        Label nugasLabel = new Label("NugasKuy");
        nugasLabel.setFont(Font.loadFont(getClass().getResourceAsStream("/Poppins-SemiBold.ttf"), TITLE_SIZE));
        nugasLabel.setTextFill(Color.web("#22CC8F"));

        // Membungkus welcomelabel dan nugas label menjadi layout horizontal
        HBox welcomeContainer = new HBox(welcomeLabel, nugasLabel);
        welcomeContainer.setSpacing(4);

        // label untuk inputfield nama user
        Label nameLabel = new Label("Masukkan Nama");
        nameLabel.setFont(Font.loadFont(getClass().getResourceAsStream("/Poppins-Medium.ttf"), 16));
        nameLabel.setTextFill(Color.WHITE);

        // inputfield untuk nama
        TextField nameField = new TextField();
        nameField.setStyle(
                "-fx-background-color: black; -fx-background-radius: 12px; -fx-text-fill: white; -fx-background-insets: 0 0 -12 0; -fx-alignment: center-left; -fx-font-family: 'Poppins'; -fx-font-size: 18px; -fx-font-weight: 600;");
        nameField.setAlignment(Pos.CENTER_LEFT);
        nameField.setPadding(new Insets(12, 0, 0, 24));
        nameField.setFont(Font.loadFont(getClass().getResourceAsStream("/Poppins-Regular.ttf"), 16));

        // layout vertikal yang membungukus label dan inputfield user name
        VBox inputContainer = new VBox();
        inputContainer.setSpacing(12);

        // label untuk pilih character
        Label characterLabel = new Label("Pilih Karakter");
        characterLabel.setFont(Font.loadFont(getClass().getResourceAsStream("/Poppins-Medium.ttf"), 16));
        characterLabel.setTextFill(Color.WHITE);

        // layout untuk membungkus vertikal ketiga container tadi
        VBox contentVBox = new VBox(hbox, welcomeContainer, nameLabel, nameField);
        contentVBox.setSpacing(8);
        contentVBox.setPadding(new Insets(24, 0, 12, 0));

        HBox characterContainer = new HBox(characterLabel);
        characterContainer.setSpacing(24);
        characterContainer.setPadding(new Insets(-8, 0, 0, 0));

        // HashMap untuk menyimpan karakter dan path gambarnya
        HashMap<String, String[]> characterImages = new HashMap<>();
        characterImages.put("Oyen", new String[] { "/img/unselectedCharacter2.png", "/img/selectedCharacter2.png" });
        characterImages.put("Buwung", new String[] { "/img/unselectedCharacter1.png", "/img/selectedCharacter1.png" });
        characterImages.put("Kesper", new String[] { "/img/unselectedCharacter3.png", "/img/selectedCharacter3.png" });

        // Menampilkan karakter-karakter yang dapat dipilih
        for (String character : characterImages.keySet()) {
            String[] imagePaths = characterImages.get(character);

            // Membuat ImageView karakter unselected
            Image unselectedCharacterImage = new Image(getClass().getResourceAsStream(imagePaths[0]));
            ImageView unselectedCharacterImageViewLocal = new ImageView(unselectedCharacterImage);
            unselectedCharacterImageViewLocal.setFitHeight(CHARACTER_IMAGE_SIZE);
            unselectedCharacterImageViewLocal.setFitWidth(CHARACTER_IMAGE_SIZE);

            // Membuat ImageView karakter selected (ter-outline)
            Image selectedCharacterImage = new Image(getClass().getResourceAsStream(imagePaths[1]));
            ImageView selectedCharacterImageViewLocal = new ImageView(selectedCharacterImage);
            selectedCharacterImageViewLocal.setFitHeight(CHARACTER_IMAGE_SIZE);
            selectedCharacterImageViewLocal.setFitWidth(CHARACTER_IMAGE_SIZE);
            selectedCharacterImageViewLocal.setVisible(false);

            // Membuat StackPane untuk karakter
            StackPane characterPane = new StackPane();
            characterPane.getChildren().addAll(unselectedCharacterImageViewLocal, selectedCharacterImageViewLocal);

            // Menambahkan tindakan saat karakter dipilih
            characterPane.setOnMouseClicked(event -> {
                if (selectedCharacterPane == characterPane) {
                    // Karakter sudah dipilih, jadi hapus pilihannya
                    selectedCharacterImageViewLocal.setVisible(false);
                    unselectedCharacterImageViewLocal.setVisible(true);
                    selectedCharacterPane = null;
                    selectedCharacter = null;
                } else {
                    // Hapus efek ter-outline dari karakter sebelumnya (jika ada)
                    if (selectedCharacterPane != null) {
                        ImageView previousSelectedImageView = (ImageView) selectedCharacterPane.getChildren().get(1);
                        previousSelectedImageView.setVisible(false);
                        ImageView previousUnselectedImageView = (ImageView) selectedCharacterPane.getChildren().get(0);
                        previousUnselectedImageView.setVisible(true);
                    }

                    // Pilih karakter baru
                    selectedCharacterImageViewLocal.setVisible(true);
                    unselectedCharacterImageViewLocal.setVisible(false);
                    selectedCharacterPane = characterPane;
                    selectedCharacter = character;
                }

                inputName = nameField.getText();

            });

            Label characterNameLabel = new Label(character);
            characterNameLabel.setFont(Font.loadFont(getClass().getResourceAsStream("/Poppins-Medium.ttf"), 14));
            characterNameLabel.setTextFill(Color.WHITE);

            VBox characterBox = new VBox(characterPane, characterNameLabel);
            characterBox.setAlignment(Pos.CENTER);
            characterBox.setSpacing(12);

            characterContainer.getChildren().add(characterBox);
        }

        contentVBox.getChildren().add(characterContainer);

        // Membuat tombol
        Button submitButton = new Button("Mulai");
        submitButton.setPrefWidth(398);
        submitButton.setPrefHeight(55);
        submitButton.setFont(Font.loadFont(getClass().getResourceAsStream("/Poppins-Medium.ttf"), 24));
        submitButton.setStyle(
                "-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-background-radius: 16px; -fx-alignment: center;");
        submitButton.setOnAction(event -> {
            // Tindakan yang akan dilakukan saat tombol ditekan
            // Misalnya, menampilkan pesan dengan karakter yang dipilih dan nama pengguna
            if (selectedCharacter != null && !inputName.isEmpty()) {
                System.out.println("Karakter yang dipilih: " + selectedCharacter);
                System.out.println("Nama pengguna: " + inputName);
            }
            // Membuat instance dari Home dan meneruskan data
            Home homeStage = new Home(submitButton);
            // Menampilkan stage Home
            homeStage.show();
            // Menutup stage sebelumnya (App)
            primaryStage.close();
        });

        VBox contenVBox = new VBox(hbox, welcomeContainer, contentVBox, characterLabel, characterContainer);
        contenVBox.setSpacing(20);
        contenVBox.setPadding(new Insets(60, 0, 0, 12));

        VBox contentbutton = new VBox(submitButton);
        contentbutton.setSpacing(0);
        contentbutton.setPadding(new Insets(60, 0, 0, 12));

        titleContainer.getChildren().addAll(contenVBox, contentbutton);

        vBox.getChildren().add(titleContainer);

        Scene scene = new Scene(vBox, 428, 800);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}

// pastikan ada 4 pilar oop nya
// atur skenario nya
// discene berapa dan berapa
