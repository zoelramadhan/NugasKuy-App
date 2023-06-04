package elite.project;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Home {
    private Stage stage;

    private int exp = 0;
    private int level = 1;
    private int expRequired = 30;

    public Home(Stage stage) {
        this.stage = stage;
    }

    public void show(Button submitButton, String userName, String pathImage) {
        stage.setTitle("NugasKuy");

        // Mengubah icon aplikasi saat di run
        Image icon = new Image(getClass().getResourceAsStream("/img/NugasKuy.png"));
        stage.getIcons().add(icon);

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
                "-fx-background-color: #6773E9; -fx-text-fill: white; -fx-background-radius: 26px;");

        addTask.setOnAction(event -> {
            System.out.print("JADIKAN MI");
            AddTugas addTugas = new AddTugas(stage);
            addTugas.show();
            // primaryStage.close();
        });

        HBox LayoutButton = new HBox();
        LayoutButton.setPadding(new Insets(310, 0, 0, 0));
        LayoutButton.setAlignment(Pos.CENTER);
        LayoutButton.getChildren().add(addTask);

        // Menambahkan level dan exp
        Text levelText = new Text("Level : " + level + "     ");
        levelText.setFont(Font.loadFont(getClass().getResourceAsStream("/Poppins-Medium.ttf"), 18));
        levelText.setFill(Color.WHITE);

        Text expText = new Text("Exp : " + exp + "/" + expRequired);
        expText.setFont(Font.loadFont(getClass().getResourceAsStream("/Poppins-Medium.ttf"), 18));
        expText.setFill(Color.WHITE);

        HBox milestone = new HBox();
        milestone.getChildren().addAll(levelText, expText);
        milestone.setPadding(new Insets(0, -200, 776, 0));
        milestone.setAlignment(Pos.CENTER);

        VBox box1 = new VBox();
        box1.setAlignment(Pos.CENTER);
        box1.getChildren().addAll(milestone);

        // Membuat ImageView untuk menampilkan gambar
        Image backgroundImage = new Image(getClass().getResourceAsStream("/img/HomeEmpty.png"));
        ImageView backgroundImageView = new ImageView(backgroundImage);

        VBox showbox1 = new VBox();
        showbox1.setAlignment(Pos.CENTER);
        showbox1.getChildren().addAll(box1);

        Image imgIcon = new Image(getClass().getResourceAsStream(pathImage));
        ImageView imgIconView = new ImageView(imgIcon);

        Label Usrname = new Label(userName);
        Usrname.setFont(Font.loadFont(getClass().getResourceAsStream("/Poppins-Medium.ttf"), 24));
        Usrname.setAlignment(Pos.CENTER_LEFT);
        Usrname.setStyle("-fx-text-fill: white");

        HBox NameProfile = new HBox();
        NameProfile.getChildren().addAll(Usrname);

        HBox ImageProfile = new HBox();
        ImageProfile.getChildren().addAll(imgIconView);
        imgIconView.setFitHeight(35); // Ubah tinggi gambar sesuai kebutuhan
        imgIconView.setFitWidth(35);

        HBox Profile = new HBox();
        Profile.getChildren().addAll(imgIconView, NameProfile);
        Profile.setPadding(new Insets(56, 0, 0, 22.5));
        Profile.setSpacing(4);

        root.getChildren().addAll(backgroundImageView, showbox1, Profile, LayoutButton);

        HBox vLayout = new HBox(root);

        // Menampilkan konten di dalam stage
        Scene scene = new Scene(vLayout, 428, 926);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}