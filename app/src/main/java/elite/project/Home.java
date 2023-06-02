package elite.project;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Home extends Stage {

    private String selectedCharacter;
    private StackPane root;

    public Home(String selectedCharacter) {

        this.selectedCharacter = selectedCharacter;

        // Membuat konten untuk stage baru
        StackPane root = new StackPane();

        // Membuat ImageView untuk menampilkan gambar
        Image backgroundImage = new Image(getClass().getResourceAsStream("/img/HomeEmpty.png"));
        ImageView backgroundImageView = new ImageView(backgroundImage);
        root.getChildren().add(backgroundImageView);

        // Menambahkan gambar karakter yang dipilih
        setCharacterImage();

        // Menampilkan konten di dalam stage
        Scene scene = new Scene(root, 428 , 926);
        setScene(scene);
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
        }
    }
}

