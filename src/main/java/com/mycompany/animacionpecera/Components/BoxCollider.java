/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.animacionpecera.Components;

/**
 *
 * @author User
 */
public class BoxCollider extends ColliderComponent {
    
    public BoxCollider(double width, double height) {
        super(width, height);
    }
    
    @Override
     public double getWidth(Transform transform) {
        return width * transform.getScaleX();
    }

    @Override
    public double getHeight(Transform transform) {
        return height * transform.getScaleY();
    }
    
     @Override
    public double getLeft(Transform transform) {
        return transform.getX() - getWidth(transform) / 2.0;
    }
    
    @Override
    public double getRight(Transform transform) {
        return transform.getX() + getWidth(transform) / 2.0;
    }
    
    @Override
    public double getTop(Transform transform) {
        return transform.getY() - getHeight(transform) / 2.0;
    }
    
    @Override
    public double getBottom(Transform transform) {
        return transform.getY() + getHeight(transform) / 2.0;
    }
    
}
