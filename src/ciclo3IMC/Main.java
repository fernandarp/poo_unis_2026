package ciclo3IMC;

import javax.swing.*;

public class Main {
    private static float convertStrToFloat(String text) {
        try {
            return Float.parseFloat(text.replace(",", "."));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Dados inválidos!", "error", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("Número inválido");
        }
    }

    private static String createResultMsg(float imc, String category) {
        return String.format(
                "Resultado do IMC: %.2f\nSituação: %s",
                imc,
                category
        );
    }

    public static void main(String[] args) {
        float peso, altura, imc;
        String categoriaImc;

        peso = convertStrToFloat(JOptionPane.showInputDialog("Escreva o peso em kg"));
        altura = convertStrToFloat(JOptionPane.showInputDialog("Escreva a altura em cm"));

        IMC imcCalc = new IMC(altura, peso);
        imc = imcCalc.getIMC();
        categoriaImc = imcCalc.getCategory();

        JOptionPane.showMessageDialog(null, createResultMsg(imc, categoriaImc), "Resultado", JOptionPane.INFORMATION_MESSAGE);

    }
}