package br.edu.faculdadedelta.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.faculdadedelta.util.Conexao;
import br.edu.faculdadedelta.modelo.VeiculoWanderson;


public class VeiculoDaoWanderson {
	
	public void incluir (VeiculoWanderson servico) throws ClassNotFoundException, SQLException {
		
		Conexao conexao = new Conexao();
		Connection conn = conexao.conectarNoBanco();
		String sql = "INSERT INTO servicos (desc_cliente, desc_servico, valor_unitario_servico, qtde_servico, data_exec_servico)"
				+ "VALUES (?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, servico.getCliente().trim());
		ps.setString(2, servico.getServico().trim());
		ps.setDouble(3, servico.getValorUnit());
		ps.setInt(4, servico.getQuantidade());
		ps.setDate(5, new java.sql.Date(servico.getDataServ().getTime()));
		
		ps.executeUpdate();
		
		ps.close();
		conn.close();
	}
	
	public void alterar(VeiculoWanderson servico) throws ClassNotFoundException, SQLException {
		Conexao conexao = new Conexao();
		Connection conn = conexao.conectarNoBanco();
		String sql = "UPDATE servicos SET desc_cliente = ?, "
				+ " desc_servico = ?, "
				+ " valor_unitario_servico = ?, "
				+ " qtde_servico  = ? "
				+ "data_exec_servico = ?"
				+ " WHERE id_servico = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, servico.getCliente().trim());
		ps.setString(2, servico.getServico().trim());
		ps.setDouble(3, servico.getValorUnit());
		ps.setInt(4, servico.getQuantidade());
		ps.setDate(5, new java.sql.Date(servico.getDataServ().getTime()));
		ps.setLong(6, servico.getId());
		
		ps.executeUpdate();
		
		ps.close();
		conn.close();
	}
	
	public void excluir(VeiculoWanderson servico) throws ClassNotFoundException, SQLException {
		Conexao conexao = new Conexao();
		Connection conn = conexao.conectarNoBanco();
		String sql = "DELETE FROM servicos WHERE id_servico = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setLong(1, servico.getId());
		
		ps.executeUpdate();
		
		ps.close();
		conn.close();
	}
	
	public List<VeiculoWanderson> listar() throws ClassNotFoundException, SQLException {
		Conexao conexao = new Conexao();
		Connection conn = conexao.conectarNoBanco();
		String sql = "SELECT id_servico, desc_cliente, desc_servico, valor_unitario_servico, qtde_servico, data_exec_servico "
				+ "FROM servicos";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<VeiculoWanderson> listaRetorno = new ArrayList<VeiculoWanderson>();
 		
		while (rs.next()) {
			VeiculoWanderson servico = new VeiculoWanderson();
			servico.setId(rs.getLong("id_servico"));
			servico.setCliente(rs.getString("desc_cliente").trim());
			servico.setCliente(rs.getString("desc_servico").trim());
			servico.setValorUnit(rs.getDouble("valor_unitario_servico"));
			servico.setQuantidade(rs.getInt("qtde_servico"));
			servico.setDataServ(rs.getDate("data_exec_servico"));
			listaRetorno.add(servico);
		}
		rs.close();
		ps.close();
		conn.close();
		
		return listaRetorno;
	}
	

}
