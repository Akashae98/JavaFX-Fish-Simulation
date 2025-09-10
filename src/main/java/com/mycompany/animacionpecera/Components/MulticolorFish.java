package com.mycompany.animacionpecera.Components;
import java.util.Random;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.paint.Color;

public class MulticolorFish extends Component{

    private final double hue;
    private final double RandomHue;
    private final ColorAdjust colorEffect;
    Random random = new Random();

    public MulticolorFish(Color color) {
        this.RandomHue = random.nextDouble();
        this.hue = color.getHue();
        this.colorEffect = createColorEffect();
    }

    private ColorAdjust createColorEffect() {
        ColorAdjust colorAdjust = new ColorAdjust();

        if (isTurquoiseHue()) {
            // turns the pink image to blue colors
            double normalizedHue = (hue - 180) / 180.0;
            colorAdjust.setHue(normalizedHue);
            colorAdjust.setSaturation(0.45);
            colorAdjust.setBrightness(0.2);

        } else if (isPinkHue()) {
            colorAdjust.setHue(0 + (RandomHue) * 0.3 - 0.1);//ajusted pink
            colorAdjust.setSaturation(0.45);
            colorAdjust.setBrightness(0.35);

        } else if (isPurpleHue()) {
            colorAdjust.setHue(0 - (RandomHue) * 0.5);//ajusted purples anb blues
            colorAdjust.setSaturation(0.40);
            colorAdjust.setBrightness(0.30);

        } else {
            // Coral to golden colors
            colorAdjust.setHue(RandomHue * 0.12);
            colorAdjust.setSaturation(0.60);
            colorAdjust.setBrightness(0.25);

        }
        return colorAdjust;
    }

    public ColorAdjust getColorEffect() {
        return colorEffect;
    }


    public boolean isPinkHue() {
        return hue >= 170 && hue <= 200;
    }

    public boolean isTurquoiseHue() {
        return hue >= 330 || hue <= 20;
    }

    public boolean isPurpleHue() {
        return hue >= 260 && hue < 330;
    }


}
