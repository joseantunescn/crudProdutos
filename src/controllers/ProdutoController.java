package controllers;

import entities.Produto;
import repositories.ProdutoRepository;

import java.sql.SQLOutput;
import java.util.Scanner;

public class ProdutoController {

    //method to capture the data of a product
    public static void cadastrarProduto() {

        System.out.println("\nCADASTRO DE PRODUTO:\n");

        try {

            var scanner = new Scanner(System.in);
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
            var id = produtoRepository.create(produto);

            System.out.println("Produto cadastrado com sucesso! ID: " + id);

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    //method to update a product
    public static void atualizarProduto() {

        System.out.println("\nATUALIZACAO DE PRODUTO:\n");

        try {

            var scanner = new Scanner(System.in);
            //create an object of the class Produto
            var produto = new Produto();

            System.out.println("Digite o id do produto que deseja atualizar: ");
            produto.setId(Integer.parseInt(scanner.nextLine()));

            System.out.print("Digite o nome do produto: ");
            produto.setNome(scanner.nextLine());
            System.out.print("Digite o preço do produto: ");
            produto.setPreco(Double.parseDouble(scanner.nextLine()));
            System.out.print("Digite a quantidade do produto: ");
            produto.setQuantidade(Integer.parseInt(scanner.nextLine()));

            //update an object of the class ProdutoRepository
            var produtoRepository = new ProdutoRepository();
            if (produtoRepository.update(produto)) {
                System.out.println("Produto atualizado com sucesso!");
            } else {
                System.out.println("Produto não encontrado!");
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    //method to delete a product
    public static void deletarProduto() {

        System.out.println("\nDELECAO DE PRODUTO:\n");

        try {

            var scanner = new Scanner(System.in);
            System.out.println("Digite o id do produto que deseja deletar: ");
            var id = Integer.parseInt(scanner.nextLine());

            //delete an object of the class ProdutoRepository
            var produtoRepository = new ProdutoRepository();
            if (produtoRepository.delete(id)) {
                System.out.println("Produto deletado com sucesso!");
            } else {
                System.out.println("Produto não encontrado!");
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    //method to find all products
    public static void listarProdutos() {

        System.out.println("\nLISTAGEM DE PRODUTOS:\n");

        try {
            //find all products from the database
            var produtoRepository = new ProdutoRepository();
            produtoRepository.findAll();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
