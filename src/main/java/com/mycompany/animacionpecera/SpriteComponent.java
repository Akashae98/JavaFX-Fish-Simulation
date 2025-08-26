/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.animacionpecera;

import javafx.scene.image.Image;

/**
 *
 * @author carol
 */
public class SpriteComponent extends Component {

    public Image image;
    public double size;
    public double rotation;

    public SpriteComponent(String imagePath, double size) {
        this.image = new Image(getClass().getResourceAsStream(imagePath));
        this.size = size;
    }

    public void rotate(double degrees) {
        this.rotation += degrees;
    }

    public double getWidth() {
        return image.getWidth() * size;
    }

    public double getHeight() {
        return image.getHeight() * size;
    }
}
