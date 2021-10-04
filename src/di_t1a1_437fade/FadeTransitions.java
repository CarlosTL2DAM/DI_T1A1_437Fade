/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di_t1a1_437fade;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.FadeTransition;
import javafx.animation.Timeline;

/**
 * 2ºDAM DI
 * @author Carlos Torres Liñán
 * 04/10/21 
 */
public class FadeTransitions extends Application {
    private StackPane root;
    private Scene scene;
    private Ellipse elipse;
    private FadeTransition animacion;
    
    @Override
    public void start(Stage primaryStage) {
        //Creamos root node
        root = new StackPane();
        
        //Creamos escena con el nodo root
        scene = new Scene(root, 300, 250);
        
        //Creamos la elipse que se desvanecerá
        elipse = new Ellipse(10,10,100,50);
        //Escogemos color de la elipse
        elipse.setFill(Color.RED);
        //Decimos que tenga un borde negro
        elipse.setStroke(Color.BLACK);
        
        //Creamos animacion, con duracion de 4000 milisegundos, y nodo elipse
        animacion = new FadeTransition(Duration.millis(4000), elipse);
        //Comienza desde valor máximo de color 1.0 hasta 0.1
        animacion.setFromValue(1.0);
        animacion.setToValue(0.1);
        //Hacemos que el ciclo sea indefinido
        animacion.setCycleCount(Timeline.INDEFINITE);
        //Decimos que cuando termine el ciclo se invierta
        animacion.setAutoReverse(true);
        animacion.play();
        
        //Eventos
        
        //Evento que si pulsamos se para la animacion
        elipse.setOnMousePressed(e -> {
            animacion.stop();
        });
        //Evento que si dejamos de pulsar prosigue la animacion
        elipse.setOnMouseReleased(e -> {
            animacion.play();
        });
        
        //Añadimos elipse a root
        root.getChildren().add(elipse);
        
        //Creamos FadeTransitions
        
        
        
        //Añadimos titulo a nuestra ventana
        primaryStage.setTitle("Ejercicio 4.3.7 FadeTransition");
        //Escogemos la escena que se muestra en la ventana
        primaryStage.setScene(scene);
        //Mostramos la ventana
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
