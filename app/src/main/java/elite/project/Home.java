package elite.project;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Home extends Stage {

    private Button selectedCharacter;
    private StackPane root;
    private Stage primaryStage;
    private int exp = 0;
    private int level = 1;
    private int expRequired = 30;

    public Home(Button submitButton) {
        this.selectedCharacter = submitButton;
        setTitle("NugasKuy");

        // Mengubah icon aplikasi saat di run
        Image icon = new Image(getClass().getResourceAsStream("/img/NugasKuy.png"));
        getIcons().add(icon);

        // Membuat konten untuk stage baru
        StackPane root = new StackPane();
        root.setAlignment(Pos.CENTER);

        // membuat tombol
        Button addTask = new Button("Tambah Tugas");
        addTask.setFont(Font.loadFont(getClass().getResourceAsStream("/Poppins-Medium.ttf"), 22));
        addTask.setAlignment(Pos.CENTER);
        addTask.setPrefWidth(300);
        addTask.setPrefHeight(40);
        addTask.setStyle(
            "-fx-background-color: #6773E9; -fx-text-fill: white; -fx-background-radius: 16px;");

            addTask.setOnAction(event -> {
                AddTugas addTugas = new AddTugas();
                addTugas.show();
                primaryStage.close();
            });
            
            
            
        // Menambahkan level dan exp
        Text levelText = new Text("Level: " + level + " ");
        levelText.setFont(Font.loadFont(getClass().getResourceAsStream("/Poppins-Medium.ttf"), 18));
        levelText.setFill(Color.WHITE);
                    
        Text expText = new Text("Exp: " + exp + "/" + expRequired);
        expText.setFont(Font.loadFont(getClass().getResourceAsStream("/Poppins-Medium.ttf"), 18));
        expText.setFill(Color.WHITE);

        HBox milestone = new HBox();
        milestone.getChildren().addAll(levelText, expText);
        milestone.setPadding(new Insets(0, 0, 770, 0));
        milestone.setAlignment(Pos.CENTER);
        
        VBox box1 = new VBox();
        box1.setAlignment(Pos.CENTER);
        box1.getChildren().addAll(milestone);

        
        // Membuat ImageView untuk menampilkan gambar
        Image backgroundImage = new Image(getClass().getResourceAsStream("/img/HomeEmpty.png"));
        ImageView backgroundImageView = new ImageView(backgroundImage);
        
        // Menambahkan gambar karakter yang dipilih
        setCharacterImage();
        
        VBox showbox1 = new VBox();
        showbox1.setAlignment(Pos.CENTER);
        showbox1.getChildren().addAll(box1);

        root.getChildren().addAll(backgroundImageView, showbox1, addTask);
        
        HBox vLayout = new HBox(root);
        
        // Menampilkan konten di dalam stage
        Scene scene = new Scene(vLayout, 428, 800);
        setResizable(false);
        setScene(scene);
        
        // HBox infoBox = new HBox(levelText, expText);
        // infoBox.setAlignment(Pos.CENTER_LEFT);
        // infoBox.setSpacing(10);
        // infoBox.setPadding(new Insets(10));
        
        // // root.getChildren().add(infoBox);
    }
    

    private void setCharacterImage() {
        String imagePath = null;

        // Tentukan path gambar berdasarkan karakter yang dipilih
        if (selectedCharacter.equals("Oyen")) {
            imagePath = "/img/selectedCharacter2.png";
        } else if (selectedCharacter.equals("Buwung")) {
            imagePath = "/img/selectedCharacter1.png";
        } else if (selectedCharacter.equals("Kesper")) {
            imagePath = "/img/selectedCharacter3.png";
        }

        // Membuat ImageView untuk menampilkan gambar karakter
        if (imagePath != null) {
            Image characterImage = new Image(getClass().getResourceAsStream(imagePath));
            ImageView characterImageView = new ImageView(characterImage);
            characterImageView.setFitHeight(200);
            characterImageView.setFitWidth(200);
            root.getChildren().add(characterImageView);

            root.getChildren().removeIf(node -> node instanceof ImageView);
        }
    }
}

