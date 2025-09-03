/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.animacionpecera.Components;


/**
 *
 * @author carol
 */
public class SpriteComponent extends Component {

    public String imageKey;
    public double scale;
    public boolean flip = false;

    public SpriteComponent(String imageKey, double scale) {
        this.imageKey = imageKey;
        this.scale = scale;
    }

    public String getImageKey() {
        return imageKey;
    }

   
}
