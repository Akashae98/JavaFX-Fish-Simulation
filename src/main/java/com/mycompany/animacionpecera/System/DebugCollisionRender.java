/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.animacionpecera.System;

import com.mycompany.animacionpecera.Components.ColliderComponent;
import com.mycompany.animacionpecera.Components.Transform;
import com.mycompany.animacionpecera.Entity;
import java.util.List;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author User
 */
public class DebugCollisionRender extends GameSystem {

    private final Canvas canvas;
    private final GraphicsContext gc;
    private boolean showBox = false;

    public DebugCollisionRender(Canvas canvas) {
        this.canvas = canvas;
        this.gc = canvas.getGraphicsContext2D();
    }

    public void setShowBox(boolean show) {
        this.showBox = show;
    }


    @Override
    public void update(List<Entity> entities, double deltaTime) {
        if (!showBox) {
            return;
        }  
        for (Entity entity : entities) {
            if (entity.hasComponent(ColliderComponent.class) && entity.hasComponent(Transform.class)) {
                ColliderComponent collider = entity.getComponent(ColliderComponent.class);
                Transform transform = entity.getComponent(Transform.class);
                
                gc.save();
                          
                double halfWidth = collider.getWidth(transform) / 2.0;
                double halfHeight = collider.getHeight(transform) / 2.0;
                
                gc.setTransform(getAffineTransform(transform));
                
                gc.setStroke(Color.MAGENTA);
                gc.setLineWidth(1.0);
                gc.strokeRect(-halfWidth, -halfHeight, collider.getWidth(transform), collider.getHeight(transform));
                
                gc.strokeText(".", 0, 0);
                
                gc.restore();
            }
        }
    }

     public javafx.scene.transform.Affine getAffineTransform(Transform transform) {
        javafx.scene.transform.Affine affine = new javafx.scene.transform.Affine();

        //Important order: translate -> rotate -> scale
        affine.appendTranslation(transform.getX(), transform.getY());

        if (transform.getRotation() != 0) {
            affine.appendRotation(Math.toDegrees(transform.getRotation()));
        }

        return affine;
    }

}
