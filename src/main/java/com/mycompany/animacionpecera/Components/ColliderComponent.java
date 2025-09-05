/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.animacionpecera.Components;


/**
 *
 * @author carol
 */
public class ColliderComponent extends Component {

    public double width;
    public double height;

    public ColliderComponent(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth(Transform transform) {
        return width * transform.getScaleX();
    }

    public double getHeight(Transform transform) {
        return height * transform.getScaleY();
    }

   public double getLeft(Transform transform) {
        return transform.getX() - getWidth(transform) / 2.0;
    }
    
    public double getRight(Transform transform) {
        return transform.getX() + getWidth(transform) / 2.0;
    }
    
    public double getTop(Transform transform) {
        return transform.getY() - getHeight(transform) / 2.0;
    }
    
    public double getBottom(Transform transform) {
        return transform.getY() + getHeight(transform) / 2.0;
    }


    //Collisions with colliders...
    public boolean intersects(ColliderComponent other, Transform thisTransform, Transform otherTransform) {
        return this.getRight(thisTransform) > other.getLeft(otherTransform)
                && this.getLeft(thisTransform) < other.getRight(otherTransform)
                && this.getBottom(thisTransform) > other.getTop(otherTransform)
                && this.getTop(thisTransform) < other.getBottom(otherTransform);
    }
}
