package application;

import controllers.ProdutoController;

import javax.swing.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("\nSISTEMA DE CONTROLE DE PRODUTOS:\n");
        System.out.println("(1) - CADASTRAR PRODUTO");
        System.out.println("(2) - ATUALIZAR PRODUTO");
        System.out.println("(3) - EXCLUIR PRODUTO");
        System.out.println("(4) - CONSULTAR PRODUTOS");

        var opcao = JOptionPane.showInputDialog("Informe a opção desejada:");

        switch (opcao) {
            case "1":
                ProdutoController.cadastrarProduto();
                break;
            case "2":
                ProdutoController.atualizarProduto();
                break;
            case "3":
                ProdutoController.deletarProduto();
                break;
            case "4":
                ProdutoController.listarProdutos();
                break;
            default:
                System.out.println("\nOpção inválida.");
        }
    }
}
