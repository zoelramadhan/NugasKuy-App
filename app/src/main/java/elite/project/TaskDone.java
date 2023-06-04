// package elite.project;

// import javafx.geometry.Insets;
// import javafx.geometry.Pos;
// import javafx.scene.Scene;
// import javafx.scene.control.Button;
// import javafx.scene.image.Image;
// import javafx.scene.image.ImageView;
// import javafx.scene.layout.HBox;
// import javafx.scene.layout.StackPane;
// import javafx.scene.layout.VBox;
// import javafx.scene.text.Font;
// import javafx.stage.Stage;

// public class TaskDone extends Stage {

//     public TaskDone() {
//         setTitle("NugasKuy");
//         // Mengubah icon aplikasi saat di run
//         Image icon = new Image(getClass().getResourceAsStream("/img/NugasKuy.png"));
//         getIcons().add(icon);

//         // Membuat konten untuk stage baru
//         StackPane root = new StackPane();
//         root.setAlignment(Pos.CENTER);

//         // membuat tombol
//         Button addTask = new Button("Tambah Tugas");
//         addTask.setFont(Font.loadFont(getClass().getResourceAsStream("/Poppins-Medium.ttf"), 22));
//         addTask.setPrefWidth(300);
//         addTask.setPrefHeight(40);
//         addTask.setStyle(
//                 "-fx-background-color: #6773E9; -fx-text-fill: white; -fx-background-radius: 16px;");

//         HBox box1 = new HBox();
//         box1.setPadding(new Insets(550, 20, 30, 20));
//         box1.setAlignment(Pos.CENTER);
//         box1.getChildren().addAll(addTask);

//         addTask.setOnAction(event -> {
//             FollowUp followUp = new FollowUp();
//             followUp.show();
//         });

//         // Membuat ImageView untuk menampilkan gambar
//         Image backgroundImage = new Image(getClass().getResourceAsStream("/img/HomeAddToDo.png"));
//         ImageView backgroundImageView = new ImageView(backgroundImage);
//         root.getChildren().addAll(backgroundImageView, box1);

//         VBox vLayout = new VBox(root);
//         // Menampilkan konten di dalam stage
//         Scene scene = new Scene(vLayout, 428, 800);
//         setResizable(false);
//         setScene(scene);
//     }
// }