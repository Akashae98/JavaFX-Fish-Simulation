package com.mycompany.animacionpecera.Components;
import java.util.Random;

import javafx.scene.paint.Color;

public class MulticolorFish extends Component{

    private final Color color;
    private double hue;
    private double RandomHue;
    Random random = new Random();

    public MulticolorFish(Color color) {
        this.color = color;
        this.RandomHue = random.nextDouble();
        this.hue = color.getHue();
    }

    public Color getColor() {
        return color;
    }

    public double getHue() {
        return hue;
    }

    public double getRandomHue() {
        return RandomHue;
    }

    public boolean isPinkHue(double hue) {
        return hue >= 170 && hue <= 200;
    }

    public boolean isTurquoiseHue(double hue) {
        return hue >= 330 || hue <= 20;
    }

    public boolean isPurpleHue(double hue) {
        return hue >= 260 && hue < 330;
    }

}
