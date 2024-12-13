package br.edu.unisep.tarefas.model;
import java.util.ArrayList;

public class Tarefa {
    private ArrayList<String> tarefas;

    public Tarefa() {
        tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(String tarefa) {
        tarefas.add(tarefa);
    }

    public void marcarTarefaConcluida(int indice) {
        if (indice >= 0 && indice < tarefas.size()) {
            String tarefa = tarefas.get(indice);
            tarefas.set(indice, tarefa + " (Concluída)");
        }
    }

    public void removerTarefa(int indice) {
        if (indice >= 0 && indice < tarefas.size()) {
            tarefas.remove(indice);
        }
    }

    public String exibirTarefas() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tarefas.size(); i++) {
            sb.append(i + 1).append(". ").append(tarefas.get(i)).append("\n");
        }
        return sb.toString();
    }

    public int getTotalTarefas() {
        return tarefas.size();
    }
}
