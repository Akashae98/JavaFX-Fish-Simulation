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
    public double size;
    public boolean flip = false;

    public SpriteComponent(String imageKey, double size) {
        this.imageKey = imageKey;
        this.size = size;
    }

    public String getImageKey() {
        return imageKey;
    }

   
}
