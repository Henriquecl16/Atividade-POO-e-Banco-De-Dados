package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelos.Cliente;
import modelos.Produto;
import utils.ConectaDB;

public class ClienteDao {
	
	public Cliente salvar(Cliente cliente) {

	    String sql = "insert into tb_clientes(cpf, nome, email, rua, numero, bairro, cep, cidade, estado) values(?,?,?,?,?,?,?,?,?)";

	    Connection con = ConectaDB.conectar();

	    try {

	        PreparedStatement stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	        stm.setString(1, cliente.getCpf());
	        stm.setString(2, cliente.getNome());
	        stm.setString(3, cliente.getEmail());
	        stm.setString(4, cliente.getRua());
	        stm.setInt(5, cliente.getNumero());
	        stm.setString(6, cliente.getBairro());
	        stm.setString(7, cliente.getCep());
	        stm.setString(8, cliente.getCidade());
	        stm.setString(9, cliente.getEstado());
	        
	        stm.execute();
	        
	        ResultSet rs = stm.getGeneratedKeys();
	        
	        if (rs.next()) {
	        	cliente.setId(rs.getInt(1));
	        }
	        
	        rs.close();
	        stm.close();
	        con.close();
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return null;
	    }
	    
	    
	    return cliente;
	}
	
	public Cliente consultar(int id) {
	
	    Cliente cliente = null;

	    String sql = "select * from tb_clientes where id = ?";

	    try {

	        PreparedStatement ps = ConectaDB.conectar().prepareStatement(sql);

	        ps.setInt(1, id);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {

	            cliente = new Cliente();

	            cliente.setId(rs.getInt("id"));
	            cliente.setCpf(rs.getString("cpf"));
	            cliente.setNome(rs.getString("nome"));
	            cliente.setEmail(rs.getString("email"));
	            cliente.setRua(rs.getString("rua"));
	            cliente.setNumero(rs.getInt("numero"));
	            cliente.setBairro(rs.getString("bairro"));
	            cliente.setCep(rs.getString("cep"));
	            cliente.setCidade(rs.getString("cidade"));
	            cliente.setEstado(rs.getString("estado"));

	        }

	    } catch (Exception e) {

	        System.out.println("Erro ao consultar cliente: " + e.getMessage());

	    }

	    return cliente;
	}
	
	public List<Cliente> consultar() {

	    List<Cliente> clientes = new ArrayList<Cliente>();
	    Connection con = ConectaDB.conectar();
	    
	    try {

	        PreparedStatement stm = con.prepareStatement("select * from tb_clientes");

	        ResultSet rs = stm.executeQuery();
	        
	        while (rs.next()) {

	            Cliente cliente = new Cliente();

	            cliente.setId(rs.getInt("id"));
	            cliente.setCpf(rs.getString("cpf"));
	            cliente.setNome(rs.getString("nome"));
	            cliente.setEmail(rs.getString("email"));
	            cliente.setRua(rs.getString("rua"));
	            cliente.setNumero(rs.getInt("numero"));
	            cliente.setBairro(rs.getString("bairro"));
	            cliente.setCep(rs.getString("cep"));
	            cliente.setCidade(rs.getString("cidade"));
	            cliente.setEstado(rs.getString("estado"));

	            clientes.add(cliente);
	        }
	        
	        rs.close();
	        stm.close();
	        con.close();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return clientes;
	    
	    
	}
	
	public void alterar(Cliente cliente) {
		String sql = "update tb_clientes set cpf = ?, nome = ?, email = ?, rua = ?, numero = ?, bairro = ?, cep = ?, cidade = ?, estado = ? where id = ?";
		
		 Connection con = ConectaDB.conectar();
		 
		 try {

			    PreparedStatement stm = con.prepareStatement(sql);
			    
			    stm.setString(1, cliente.getCpf());
			    stm.setString(2, cliente.getNome());
			    stm.setString(3, cliente.getEmail());
			    stm.setString(4, cliente.getRua());
			    stm.setInt(5, cliente.getNumero());
			    stm.setString(6, cliente.getBairro());
			    stm.setString(7, cliente.getCep());
			    stm.setString(8, cliente.getCidade());
			    stm.setString(9, cliente.getEstado());
			    stm.setInt(10, cliente.getId());
			    
			    stm.execute();
			    
			    stm.close();
			    con.close();

			} catch (SQLException e) {
			    e.printStackTrace();
			}
	}
	
	public void deletar(int id) {
		String sql = "delete from tb_clientes where id = ?";
		Connection con = ConectaDB.conectar();
		
		try {

		    PreparedStatement stm = con.prepareStatement(sql);
		    
		    stm.setInt(1, id);

		    stm.execute();

		    stm.close();
		    con.close();

		} catch (SQLException e) {
		    e.printStackTrace();
		}
		
		

	}


		
	}
	
	


