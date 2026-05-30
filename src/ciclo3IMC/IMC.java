package AtvCiclo3IMC;

import javax.swing.*;

public class IMC {
    private float height;
    private float weight;
    private float imc;

    public IMC(float height_cm, float weight_kg) {
        this.height = height_cm;
        this.weight = weight_kg;
        this.imc = this.calculate();
    }

    private boolean isValidWeight() {
        return this.weight > 0.1 && this.weight < 700;
    }
    private boolean isValidHeight() {
        return this.height > 10 && this.height < 300;
    }

    private float calculate() {
        if (isValidHeight() && isValidWeight()) {
            float height_m = height/100;
            imc = weight / (height_m*height_m);
            return imc;
        }
        JOptionPane.showMessageDialog(null, "Dados inválidos!", "error", JOptionPane.ERROR_MESSAGE);
        throw new IllegalArgumentException("Dados inválidos!");
    }

    public float getIMC() {
        return this.imc;
    }

    public String getCategory() {
        if (this.imc < 17) {
            return "Muito abaixo do peso";
        } else if (this.imc < 18.5) {
            return "Abaixo do peso";
        } else if (this.imc < 25) {
            return "Peso normal";
        } else if (this.imc < 30) {
            return "Acima do peso";
        } else if (this.imc < 35) {
            return "Obesidade I";
        } else if (this.imc < 40) {
            return "Obesidade II (severa)";
        } else
            return "Obesidade III (mórbida)";
    }
}
