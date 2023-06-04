package elite.project;

import elite.models.Task;
import elite.models.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Home {
    private Stage stage;
    private ObservableList<Task> listTask;
    private User user;

    public Home(Stage stage, User user) {
        this.stage = stage;
        this.listTask = FXCollections.observableArrayList();
        this.user = user;
    }

    public Home(Stage stage, User user,  ObservableList<Task> listTask) {
        this.stage = stage;
        this.listTask = listTask;
        this.user = user;
    }

    public void show() {
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
            "-fx-background-color: #6773E9; -fx-text-fill: white; -fx-background-radius: 16px;");

        addTask.setOnAction(event -> {
            AddTugas addTugas = new AddTugas(stage, user, listTask);
            addTugas.show();
            // primaryStage.close();
        });

        VBox vLayout = new VBox();
        vLayout.setPadding(new Insets(130, 12, 20, 12));
        vLayout.setSpacing(16);
        // vLayout.setStyle("-fx-background-color: black; -fx-padding: 10; -fx-background-radius: 12px;");
        vLayout.setMinSize(396, 71);
        // vLayout.setMaxSize(396, 71);
        // vLayout.setAlignment(Pos.CENTER);

        Region space = new Region();
        VBox.setVgrow(space, Priority.ALWAYS);

        HBox LayoutButton = new HBox();
        LayoutButton.setPadding(new Insets(0, 0, 0, 0));
        LayoutButton.setAlignment(Pos.CENTER);
        LayoutButton.getChildren().add(addTask);
    
        // Menambahkan level dan exp
        Text levelText = new Text("Level: " + user.getLevel() + "     ");
        levelText.setFont(Font.loadFont(getClass().getResourceAsStream("/Poppins-Medium.ttf"), 18));
        levelText.setFill(Color.WHITE);
                    
        Text expText = new Text("Exp: " + user.getExp() + "/" + user.getExpRequired());
        expText.setFont(Font.loadFont(getClass().getResourceAsStream("/Poppins-Medium.ttf"), 18));
        expText.setFill(Color.WHITE);

        HBox milestone = new HBox();
        milestone.getChildren().addAll(levelText, expText);
        milestone.setPadding(new Insets(0, -200, 776, 0));
        milestone.setAlignment(Pos.CENTER);
        
        VBox box1 = new VBox();
        box1.setAlignment(Pos.CENTER);
        box1.getChildren().addAll(milestone);

        Image backgroundImage;
        if (listTask.isEmpty()) {
            // Membuat ImageView untuk menampilkan gambar
        backgroundImage = new Image(getClass().getResourceAsStream("/img/HomeEmpty.png"));
        
        }else{
            backgroundImage = new Image(getClass().getResourceAsStream("/img/HomeAddToDo.png"));
            for (Task task : listTask) {
                VBox v = createTaskBox(task);
               
                vLayout.getChildren().add(v);
            }
        }
        vLayout.getChildren().addAll(space, LayoutButton);
        ImageView backgroundImageView = new ImageView(backgroundImage);
        root.getChildren().add(backgroundImageView);
        
        VBox showbox1 = new VBox();
        showbox1.setAlignment(Pos.CENTER);
        showbox1.getChildren().addAll(box1);
        

        Image imgIcon = new Image(getClass().getResourceAsStream(user.getFotoProfil()));
        ImageView imgIconView = new ImageView(imgIcon);

        Label Usrname = new Label(user.getNama());
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


        root.getChildren().addAll(showbox1, Profile, vLayout);
        
        HBox vLayout2 = new HBox(root);
        
        // Menampilkan konten di dalam stage
        Scene scene = new Scene(vLayout2, 428, 926);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    private VBox createTaskBox(Task task) {
        // Kotak centang status
        Image backgroundImage;
        if (task.isFinish()) {
            backgroundImage = new Image(getClass().getResourceAsStream("/img/CheckBox.png"));
        }else{
            backgroundImage = new Image(getClass().getResourceAsStream("/img/UncheckBox.png"));
        }
        ImageView checkBox= new ImageView(backgroundImage);

        



        // Label judul tugas
        Label judulLabel = new Label(task.getJudulTugas());
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

        Region sizRegion = new  Region();
        sizRegion.setMinSize(1, 12);


        VBox taskBox = new VBox();
        taskBox.setStyle("-fx-background-color: black; -fx-padding: 10; -fx-background-radius: 12px;");
        taskBox.setMinSize(396, 71);
        taskBox.setMaxSize(396, 71);
        taskBox.setAlignment(Pos.CENTER);
        taskBox.getChildren().addAll(hBoxcard1, sizRegion);

        taskBox.setOnMouseClicked(v->{
            System.out.println("apa");
            FollowUp followUp = new FollowUp(stage, user, listTask, task);
            followUp.show();
        });
    

        return taskBox;
    }
}

