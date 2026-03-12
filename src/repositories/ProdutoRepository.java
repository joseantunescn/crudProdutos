package repositories;

import entities.Produto;
import factories.ConnectionFactory;

import java.sql.PreparedStatement;

public class ProdutoRepository {

    private PreparedStatement statement;

    //method to insert a product in the database
    public Integer create(Produto produto) throws Exception {

        //open a connection to the database
        try (var connection = ConnectionFactory.getConnection()) {

            //close the connection
            //connection.close();

            //write the SQL command to insert a product in the database
            var sql = "INSERT INTO produtos (nome, preco, quantidade) VALUES (?, ?, ?)";

            //create a prepared statement from the SQL command
            var statement = connection.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);

            //pass the values to each parameter of the SQL command
            statement.setString(1, produto.getNome());
            statement.setDouble(2, produto.getPreco());
            statement.setInt(3, produto.getQuantidade());

            //execute the SQL command
            statement.execute();

            //get the generated id of the product and return it
            var keys = statement.getGeneratedKeys();
            if(keys.next()) {
                return keys.getInt(1);
            }
            return 0;

        }
    }


    //method to update a product in the database
    public boolean update(Produto produto) throws Exception {

        //open a connection to the database
        try (var connection = ConnectionFactory.getConnection()) {

            //write the SQL command to update a product in the database
            var sql = "UPDATE produtos SET nome = ?, preco = ?, quantidade = ? WHERE id = ?";

            //create a prepared statement from the SQL command
            var statement = connection.prepareStatement(sql);

            //pass the values to each parameter of the SQL command
            statement.setString(1, produto.getNome());
            statement.setDouble(2, produto.getPreco());
            statement.setInt(3, produto.getQuantidade());
            statement.setInt(4, produto.getId());

            //execute the SQL command and return true if it was successful
            return statement.executeUpdate() > 0;

        }
    }

    //method to delete a product from the database
    public boolean delete(int id) throws Exception {

        //open a connection to the database
        try (var connection = ConnectionFactory.getConnection()) {

            //write the SQL command to delete a product from the database
            var sql = "DELETE FROM produtos WHERE id = ?";

            //create a prepared statement from the SQL command
            var statement = connection.prepareStatement(sql);

            //pass the value to the parameter of the SQL command
            statement.setInt(1, id);

            //execute the SQL command and return true if it was successful
            return statement.executeUpdate() > 0;

        }
    }

    //method to find all products from the database
    public void findAll() throws Exception {

        //open a connection to the database
        try (var connection = ConnectionFactory.getConnection()) {

            //write the SQL command to find all products from the database
            var sql = "SELECT * FROM produtos ORDER BY id";

            //create a prepared statement from the SQL command
            var statement = connection.prepareStatement(sql);

            //execute the SQL command and get the result set
            var resultSet = statement.executeQuery();

            //iterate over the result set and print the data of each product
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Nome: " + resultSet.getString("nome"));
                System.out.println("Preço: " + resultSet.getDouble("preco"));
                System.out.println("Quantidade: " + resultSet.getInt("quantidade"));
                System.out.println("Data e Hora de Cadastro: " + resultSet.getTimestamp("datahoracadastro"));
                System.out.println("-----------------------------------");
            }

        }
    }

}

