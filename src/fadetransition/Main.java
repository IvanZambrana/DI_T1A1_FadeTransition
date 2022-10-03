/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package fadetransition;

import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Ivan
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
    
        //Setting title
        primaryStage.setTitle("FadeTransition");
        
        //Ellipse
        Ellipse ellipse = new Ellipse(150, 150, 100, 80);
        ellipse.setFill(Color.RED);
        ellipse.setStroke(Color.BLACK);
        
        // Fade transition to an ellipse
        FadeTransition ft = new FadeTransition(Duration.millis(3000),ellipse);
        ft.setFromValue(1.0);
        ft.setToValue(0.1);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        
        //Start animation
        ft.play();
        
        //Control animation
        ellipse.setOnMousePressed(e->ft.pause());
        ellipse.setOnMouseReleased(e->ft.play());
        
        
        //Pane and Scene
        Pane root = new Pane();
        root.getChildren().add(ellipse);
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
