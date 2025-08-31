/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.animacionpecera.Components;

import com.mycompany.animacionpecera.ImageManager;
import javafx.scene.image.Image;

/**
 *
 * @author carol
 */
public class SpriteComponent extends Component {

    public Image image;
    public double size;
    public boolean flip = false;

    public SpriteComponent(String imagePath, double size) {
        this.image = ImageManager.getInstance().getImage(imagePath);
        this.size = size;
    }

    public double getWidth() {
        return image.getWidth() * size;
    }

    public double getHeight() {
        return image.getHeight() * size;
    }
}
