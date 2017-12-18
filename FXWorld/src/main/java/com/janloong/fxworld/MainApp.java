package com.janloong.fxworld;

import com.janloong.fxworld.gui.main.MainController;
import com.jfoenix.controls.JFXDecorator;
import com.jfoenix.svg.SVGGlyph;
import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.container.DefaultFlowContainer;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MainApp extends Application {

    @FXMLViewFlowContext
    private ViewFlowContext flowContext;

    @Override
    public void start(Stage stage) throws Exception {
        //new Thread(() -> {
        //    try {
        //        SVGGlyphLoader.loadGlyphsFont(MainApp.class.getResourceAsStream("/fonts/icomoon.svg"),
        //                "icomoon.svg");
        //    } catch (IOException ioExc) {
        //        ioExc.printStackTrace();
        //    }
        //}).start();
        Flow flow = new Flow(MainController.class);
        DefaultFlowContainer container = new DefaultFlowContainer();
        flowContext = new ViewFlowContext();
        flowContext.register("Stage", stage);
        flow.createHandler(flowContext).start(container);

        JFXDecorator decorator = new JFXDecorator(stage, container.getView());
        decorator.setCustomMaximize(true);
        decorator.setText("JFoenix Demo");
        decorator.setGraphic(new SVGGlyph(""));

        double width = 800;
        double height = 600;
        try {
            Rectangle2D bounds = Screen.getScreens().get(0).getBounds();
            width = bounds.getWidth() / 2.5;
            height = bounds.getHeight() / 1.35;
        }catch (Exception e){ }

        Scene scene = new Scene(decorator, width, height);
        final ObservableList<String> stylesheets = scene.getStylesheets();
        stylesheets.addAll(MainApp.class.getResource("/css/jfoenix-fonts.css").toExternalForm(),
                MainApp.class.getResource("/css/jfoenix-design.css").toExternalForm(),
                MainApp.class.getResource("/css/jfoenix-main-demo.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
