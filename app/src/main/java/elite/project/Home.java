package elite.project;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Home extends Stage {

    private Button selectedCharacter;
    private StackPane root;
    private Stage primaryStage;

    public Home(Button submitButton) {
        this.selectedCharacter = submitButton;
        setTitle("NugasKuy");

        // Mengubah icon aplikasi saat di run
        Image icon = new Image(getClass().getResourceAsStream("/img/NugasKuy.png"));
        getIcons().add(icon);

        // Membuat konten untuk stage baru
        StackPane root = new StackPane();

        // membuat tombol
        Button addTask = new Button("Tambah Tugas");
        addTask.setFont(Font.loadFont(getClass().getResourceAsStream("/Poppins-Medium.ttf"), 22));
        addTask.setAlignment(Pos.CENTER);

        addTask.setOnAction(action -> {
            AddTugas addTugas = new AddTugas();
            addTugas.show();
            primaryStage.close();
        });

        // Membuat ImageView untuk menampilkan gambar
        Image backgroundImage = new Image(getClass().getResourceAsStream("/img/HomeEmpty.png"));
        ImageView backgroundImageView = new ImageView(backgroundImage);
        root.getChildren().addAll(backgroundImageView, addTask);

        // Menambahkan gambar karakter yang dipilih
        setCharacterImage();

        VBox vLayout = new VBox(root);
        // Menampilkan konten di dalam stage
        Scene scene = new Scene(vLayout, 428, 800);
        setResizable(false);
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

            root.getChildren().removeIf(node -> node instanceof ImageView);
        }
    }
}