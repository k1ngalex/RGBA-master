package model;
import java.util.Observable;

import android.graphics.Color;


public class RGBAModel extends Observable {

    // CLASS VARIABLES
    public static final int MAX_HUE = 360;
    public static final int MAX_SAT = 100;
    public static final int MAX_VAL = 100;
    public static final int MIN_POS = 0;


    // INSTANCE VARIABLES
    private float hue;
    private float Saturation;
    private float value;


    public RGBAModel()
    {
        this.hue = MAX_HUE;
        this.Saturation = MAX_SAT;
        this.value = MAX_VAL;

    }

    public void asBlack() { this.setHSV(0,0,0 ); }
    public void asRed() { this.setHSV(0,100,100); }
    public void asLime() { this.setHSV( 120,100,100); }
    public void asBlue() { this.setHSV( 240,100,100); }
    public void asYellow() { this.setHSV( 240,100,100); }
    public void asCyan() { this.setHSV( 180,100,100); }
    public void asMagenta() { this.setHSV( 300,100,100 ); }
    public void asSilver() { this.setHSV( 0,0,75 ); }
    public void asGray() { this.setHSV( 0,0,50 ); }
    public void asMaroon() { this.setHSV( 0,100,50 ); }
    public void asOlive() { this.setHSV( 60,100,50 ); }
    public void asGreen() { this.setHSV( 120,100,50 ); }
    public void asPurple() { this.setHSV( 300,100,50 ); }
    public void asTeal() { this.setHSV( 180,100,50 ); }
    public void asNavy() { this.setHSV( 240,100,50 ); }


    public float getMaxHue() { return hue; }
    public float getMaxSat()  { return Saturation; }
    public float getMinVal() {return  value;}

    public void setHue(float hue) {
       this.hue = hue;
        this.updateObservers();
    }

    public void setSaturation(float saturation) {
        this.Saturation = saturation;
        this.updateObservers();
    }

    public void setValue(float value) {
        this.value = value;
        this.updateObservers();
    }
    public void setHSV (float hue , float Saturation , float value) {
        this.hue = hue;
        this.Saturation = Saturation;
        this.value = value;
        this.updateObservers();

    }


    private void updateObservers() {
        this.setChanged();
        this.notifyObservers();
    }
}