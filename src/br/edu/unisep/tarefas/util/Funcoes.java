package br.edu.unisep.tarefas.util;

public class Funcoes {
    public static boolean isNumeroValido(String entrada) {
        try {
            Integer.parseInt(entrada);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
