package br.edu.unisep.tarefas.view;
import br.edu.unisep.tarefas.model.Tarefa;

public class Principal {
    public static void main(String[] args) {
        Tarefa model = new Tarefa();
        TarefaView view = new TarefaView(model);

        while (true) {
            view.exibirMenu();
        }
    }
}

