package repositories;

import entities.Produto;
import factories.ConnectionFactory;

public class ProdutoRepository {

    //method to insert a product in the database
    public void insert(Produto produto) throws Exception {

        //open a connection to the database
        try (var connection = ConnectionFactory.getConnection()) {

            //close the connection
            //connection.close();

            //write the SQL command to insert a product in the database
            var sql = "INSERT INTO produtos (nome, preco, quantidade) VALUES (?, ?, ?)";

            //pass the values to each parameter of the SQL command
            statement.setString(1, produto.getNome());
            statement.setDouble(2, produto.getPreco());
            statement.setInt(3, produto.getQuantidade());

            //execute the SQL command
            statement.execute();

        }
    }
}

