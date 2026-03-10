package controllers;

import entities.Produto;
import repositories.ProdutoRepository;

import java.util.Scanner;

public class ProdutoController {

    //method to capture the data of a product
    public static void cadastrarProduto() {

        try {

            var scanner = mew Scanner(System.in);
            //create an object of the class Produto
            var produto = new Produto();

            System.out.print("Digite o nome do produto: ");
            produto.setNome(scanner.nextLine());
            System.out.print("Digite o preço do produto: ");
            produto.setPreco(Double.parseDouble(scanner.nextLine()));
            System.out.print("Digite a quantidade do produto: ");
            produto.setQuantidade(Integer.parseInt(scanner.nextLine()));

            //create an object of the class ProdutoRepository
            var produtoRepository = new ProdutoRepository();
            produtoRepository.create(produto);

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

}
