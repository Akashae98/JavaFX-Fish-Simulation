/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.animacionpecera;

import java.util.List;

/**
 *
 * @author carol
 */
public class MovementSystem extends System {

    private BoundingBox canvasBox;

    public MovementSystem(BoundingBox canvasBox) {
        this.canvasBox = canvasBox;
    }

    @Override
    public void update(List<Entity> entities, double deltaTime) {
        for (Entity entity : entities) {
            if (entity.hasComponent(VelocityComponent.class) && entity.hasComponent(PositionComponent.class)) {

                VelocityComponent velocity = entity.getComponent(VelocityComponent.class);
                PositionComponent positionCom = entity.getComponent(PositionComponent.class);
                //To move:
                Position newPosition = new Position(
                        positionCom.position.x() + velocity.velX * deltaTime,
                        positionCom.position.y() + velocity.velY * deltaTime
                );
                //update the PositionComponent with the new Position
                positionCom.position = newPosition;

            }
            //To collide or rotate..
            if (entity.hasComponent(ColliderComponent.class) && entity.hasComponent(SpriteComponent.class)) {
                ColliderComponent collider = entity.getComponent(ColliderComponent.class);
                VelocityComponent vel = entity.getComponent(VelocityComponent.class);
                PositionComponent pos = entity.getComponent(PositionComponent.class);
                SpriteComponent sprite = entity.getComponent(SpriteComponent.class);

                boolean bounced = handleBounce(pos, vel, collider);

                if (bounced || vel.velX != 0) {
                    // horizontal flip
                    sprite.flip = vel.velX > 0;

                    // rotation
                    if ((vel.velY > 0 && vel.velX > 0) || (vel.velY < 0 && vel.velX < 0)) {
                        sprite.rotation = 10;
                    } else if ((vel.velY < 0 && vel.velX > 0) || (vel.velY > 0 && vel.velX < 0)) {
                        sprite.rotation = -10;
                    } else {
                        sprite.rotation = 0;
                    }

                }
            }
        }
    }

    private boolean handleBounce(PositionComponent pos,
            VelocityComponent vel, ColliderComponent collider) {

        BoundingBox entityBox = getBoundingBox(pos, collider);

        boolean bounced = false;

        // Verify collisions on left and right
        if ((entityBox.topLeft().x() < canvasBox.topLeft().x() && vel.velX < 0)
                || (entityBox.bottomRight().x() > canvasBox.bottomRight().x() && vel.velX > 0)) {
            vel.velX = -vel.velX; // Invert velocity x
            bounced = true;
        }

        // Verify collision on top and bottom
        if ((entityBox.topLeft().y() < canvasBox.topLeft().y() && vel.velY < 0)
                || (entityBox.bottomRight().y() > canvasBox.bottomRight().y() && vel.velY > 0)) {
            vel.velY = -vel.velY; // Invert velocity y
            bounced = true;
        }

        return bounced;
    }

    public BoundingBox getBoundingBox(PositionComponent pos, ColliderComponent collider) {
        return collider.getBoundingBox(pos.position);
    }

}
