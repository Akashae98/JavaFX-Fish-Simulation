/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.animacionpecera;

import java.util.List;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author carol
 */
public class RenderSystem extends System {

    private GraphicsContext gc;

    public RenderSystem(GraphicsContext gc) {
        this.gc = gc;
    }

    @Override
    public void update(List<Entity> entities, double deltaTime) {

        for (Entity entity : entities) {
            if (entity.hasComponent(PositionComponent.class)
                    && entity.hasComponent(SpriteComponent.class)) {

                PositionComponent pos = entity.getComponent(PositionComponent.class);
                SpriteComponent sprite = entity.getComponent(SpriteComponent.class);
                //save gc state
                gc.save();

                // translate to the center fro rotation
                gc.translate(pos.position.x(), pos.position.y());
                gc.rotate(sprite.rotation);

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
