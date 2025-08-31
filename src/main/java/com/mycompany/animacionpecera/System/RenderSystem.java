/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.animacionpecera.System;

import com.mycompany.animacionpecera.Bubble;
import com.mycompany.animacionpecera.Components.SpriteComponent;
import com.mycompany.animacionpecera.Entity;
import com.mycompany.animacionpecera.Components.Transform;
import java.util.List;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Stop;

/**
 *
 * @author carol
 */
public class RenderSystem extends GameSystem {

    private final GraphicsContext gc;
    private final Canvas canvas;
    private final Paint background;

    public RenderSystem(Canvas canvas) {
        this.canvas = canvas;
        this.gc = canvas.getGraphicsContext2D();
        //the gradient background simulates water 
        this.background = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE,
                new Stop(0, Color.rgb(127, 240, 220)),
                new Stop(1, Color.rgb(70, 130, 180)));
    }

    @Override
    public void update(List<Entity> entities, double deltaTime) {
        // Paint the background
        gc.setFill(background);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        //paint entities
        for (Entity entity : entities) {
            Transform transform = entity.getComponent(Transform.class);
            SpriteComponent sprite = entity.getComponent(SpriteComponent.class);
            
            //a white circle to highlight the bubbles..?
            if (entity.hasComponent(Bubble.class)) {
                gc.setFill(Color.rgb(255, 255, 255, 0.3)); //white color semitransparent
                gc.fillOval(transform.getX() - sprite.getWidth() / 2,
                transform.getY() - sprite.getWidth() / 2, sprite.getWidth(), sprite.getWidth());//fills with color the inside of bubble
                gc.setStroke(Color.rgb(255, 255, 255, 0.5));//white color for the bubble edge
                gc.strokeOval(transform.getX() - sprite.getWidth() / 2,
                transform.getY() - sprite.getWidth() / 2, sprite.getWidth(), sprite.getWidth());//fills with color
            }          
            if (entity.hasComponent(Transform.class) && entity.hasComponent(SpriteComponent.class)) {
                //save gc state
                gc.save();

                // applies translate and rotation
                gc.setTransform(transform.getAffineTransform());

                if (sprite.flip) {
                    gc.scale(-1, 1);
                }

                gc.drawImage(sprite.image, -sprite.getWidth() / 2,
                        -sprite.getHeight() / 2, sprite.getWidth(), sprite.getHeight());

                gc.restore();

            }
        }

    }

}
