package elite.project;

import javafx.stage.Stage;

public abstract class AbstractHome {
    protected Stage stage;
    
    public AbstractHome(Stage stage){
        this.stage = stage;
    }

    public abstract void show();
}
