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

    @Override
    public void update(List<Entity> entities, double deltaTime) {
        for (Entity entity : entities) {
            if (entity.hasComponent(VelocityComponent.class) && entity.hasComponent(PositionComponent.class)) {

                VelocityComponent velocity = entity.getComponent(VelocityComponent.class);
                PositionComponent positionCom = entity.getComponent(PositionComponent.class);

                Position newPosition = new Position(
                        positionCom.position.x() + velocity.velX * deltaTime,
                        positionCom.position.y() + velocity.velY * deltaTime
                );

                // Update the PositionComponent with the new Position
                positionCom.position = newPosition;
            }

        }
    }

}
