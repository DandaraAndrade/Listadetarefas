package br.edu.unisep.tarefas.view;

import br.edu.unisep.tarefas.model.Tarefa;
import br.edu.unisep.tarefas.util.Funcoes;

import javax.swing.JOptionPane;

public class TarefaView {
    private Tarefa model;

    public TarefaView(Tarefa model) {
        this.model = model;
    }

    public void exibirMenu() {
        String menu = "Selecione uma opção:\n"
                + "1. Adicionar tarefa\n"
                + "2. Marcar tarefa como concluída\n"
                + "3. Remover tarefa\n"
                + "4. Exibir todas as tarefas\n"
                + "5. Sair";
        String escolha = JOptionPane.showInputDialog(menu);

        if (Funcoes.isNumeroValido(escolha)) {
            int opcao = Integer.parseInt(escolha);
            switch (opcao) {
                case 1:
                    adicionarTarefa();
                    break;
                case 2:
                    marcarTarefaConcluida();
                    break;
                case 3:
                    removerTarefa();
                    break;
                case 4:
                    exibirTarefas();
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Saindo do programa.");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Entrada inválida! Por favor, digite um número.");
        }
    }

    private void adicionarTarefa() {
        String tarefa = JOptionPane.showInputDialog("Digite a tarefa a ser adicionada:");
        if (tarefa != null && !tarefa.trim().isEmpty()) {
            model.adicionarTarefa(tarefa);
            JOptionPane.showMessageDialog(null, "Tarefa adicionada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Tarefa inválida!");
        }
    }

    private void marcarTarefaConcluida() {
        String tarefasListadas = model.exibirTarefas();
        if (tarefasListadas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma tarefa disponível.");
        } else {
            String escolha = JOptionPane.showInputDialog("Escolha o número da tarefa para marcar como concluída:\n" + tarefasListadas);
            if (Funcoes.isNumeroValido(escolha)) {
                int indice = Integer.parseInt(escolha) - 1;
                if (indice >= 0 && indice < model.getTotalTarefas()) {
                    model.marcarTarefaConcluida(indice);
                    JOptionPane.showMessageDialog(null, "Tarefa marcada como concluída!");
                } else {
                    JOptionPane.showMessageDialog(null, "Tarefa não encontrada.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Entrada inválida!");
            }
        }
    }

    private void removerTarefa() {
        String tarefasListadas = model.exibirTarefas();
        if (tarefasListadas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma tarefa disponível.");
        } else {
            String escolha = JOptionPane.showInputDialog("Escolha o número da tarefa para remover:\n" + tarefasListadas);
            if (Funcoes.isNumeroValido(escolha)) {
                int indice = Integer.parseInt(escolha) - 1;
                if (indice >= 0 && indice < model.getTotalTarefas()) {
                    model.removerTarefa(indice);
                    JOptionPane.showMessageDialog(null, "Tarefa removida!");
                } else {
                    JOptionPane.showMessageDialog(null, "Tarefa não encontrada.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Entrada inválida!");
            }
        }
    }

    private void exibirTarefas() {
        String tarefas = model.exibirTarefas();
        if (tarefas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma tarefa cadastrada.");
        } else {
            JOptionPane.showMessageDialog(null, "Tarefas:\n" + tarefas);
        }
    }
}
