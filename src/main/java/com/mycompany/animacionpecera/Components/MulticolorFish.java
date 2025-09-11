package com.mycompany.animacionpecera.Components;
import java.util.Random;
import com.mycompany.animacionpecera.MainScene;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.paint.Color;

public class MulticolorFish extends Component{

    private final double hue;
    private final double randomHue;
    private final ColorAdjust colorEffect;
    Random random = MainScene.random;

    public MulticolorFish(Color color) {
        this.randomHue = random.nextDouble();
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
            colorAdjust.setHue(0 + (randomHue) * 0.3 - 0.1);//adjusted pink
            colorAdjust.setSaturation(0.45);
            colorAdjust.setBrightness(0.35);

        } else if (isPurpleHue()) {
            colorAdjust.setHue(0 - (randomHue) * 0.5);//adjusted purples anb blues
            colorAdjust.setSaturation(0.40);
            colorAdjust.setBrightness(0.30);

        } else {
            // Coral to golden colors
            colorAdjust.setHue(randomHue * 0.12);
            colorAdjust.setSaturation(0.55);
            colorAdjust.setBrightness(0.15);

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
