package elite.project;

import elite.models.Task;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FollowUp  {

    private Stage stage;
    private String userName;
    private String pathImage;
    private ObservableList<Task> listTask;
    private Task task;

    public FollowUp(Stage stage, String userName, String pathImage, ObservableList<Task> listTask, Task task) {
        this.stage = stage;
        this.userName = userName;
        this.listTask = listTask;
        this.task = task;
        this.pathImage = pathImage;
    }


    public void show() {
        stage.setTitle("NugasKuy");
        // Mengubah icon aplikasi saat di run
        Image icon = new Image(getClass().getResourceAsStream("/img/NugasKuy.png"));
        stage.getIcons().add(icon);

        // Membuat konten untuk stage baru
        StackPane root = new StackPane();

        // Membuat ImageView untuk menampilkan gambar
        Image backgroundImage = new Image(getClass().getResourceAsStream("/img/Follow Up.png"));
        ImageView backgroundImageView = new ImageView(backgroundImage);

        Button selesaiButton = new Button("Selesai");
        selesaiButton.setFont(Font.loadFont(getClass().getResourceAsStream("/Poppins-Medium.ttf"), 18));
        selesaiButton.setPrefWidth(300);
        selesaiButton.setPrefHeight(40);
        selesaiButton.setStyle(
                "-fx-background-color: #6773E9; -fx-text-fill: white; -fx-background-radius: 16px;");

        selesaiButton.setOnAction(event -> {
            int i = listTask.indexOf(task);
            // listTask.remove(task);
            listTask.get(i).finishTask();
            Home home = new Home(stage, userName, pathImage, listTask);
            home.show();

        });

        Button batalButton = new Button("Batal");
        batalButton.setFont(Font.loadFont(getClass().getResourceAsStream("/Poppins-Medium.ttf"), 18));
        batalButton.setPrefWidth(300);
        batalButton.setPrefHeight(40);
        batalButton.setStyle(
                "-fx-background-color: #F05F5F; -fx-text-fill: white; -fx-background-radius: 16px;");

        batalButton.setOnAction(event -> {
            Home home = new Home(stage, userName, pathImage, listTask);
            home.show();
        });

        VBox button = new VBox(selesaiButton, batalButton);
        button.setSpacing(10);
        button.setAlignment(Pos.BOTTOM_CENTER);
        button.setPadding(new Insets(0, 15, 90, 15));
        root.getChildren().addAll(backgroundImageView, button);

        VBox vLayout = new VBox(root);
        // Menampilkan konten di dalam stage
        Scene scene = new Scene(vLayout, 394, 318);
        stage.setResizable(false);
        stage.setScene(scene);
    }
}
