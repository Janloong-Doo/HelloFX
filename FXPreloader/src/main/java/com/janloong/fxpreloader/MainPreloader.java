package com.janloong.fxpreloader;

import javafx.application.Preloader;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @author Janloong
 * @create 2017-12-11 14:19
 **/
public class MainPreloader extends Preloader {
    ProgressBar bar;
    Stage stage;

    private Scene createPreloaderScene() {
        bar = new ProgressBar();
        BorderPane p = new BorderPane();
        p.setCenter(bar);
        //return new Scene(p, 300, 150);
        return new Scene(p, 600, 300);
    }
    @Override
    public void init(){
        System.out.println("preloader init");

    }

    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("preloader start================");
        this.stage = stage;
        stage.setScene(createPreloaderScene());
        stage.show();
    }
    @Override
    public void handleStateChangeNotification(StateChangeNotification scn) {
        if (scn.getType() == StateChangeNotification.Type.BEFORE_START) {
            stage.hide();
        }
    }

    @Override
    public void handleProgressNotification(ProgressNotification pn) {
        bar.setProgress(pn.getProgress());
    }

    public static void main(String[] args){
        launch();
    }
}
