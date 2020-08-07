package com.github.bjdavies1.githubsimpleinfo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GuiBase.fxml"));
        primaryStage.setTitle("Github small user info");
        primaryStage.setScene(new Scene(root, 900, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
