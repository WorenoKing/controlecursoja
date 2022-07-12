package br.com.cursosja.controlecursoja.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.cursosja.controlecursoja.model.entidade.Professor;

public class ProfessorDao extends Conexao {

	public boolean incluir(Professor professor) {
		boolean ok = false;
		String sql = "insert into professor (nome, valor) "
				   + " values (?, ?) ";
		
		try {
		
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setString(1, professor.getNome());
			ps.setString(2, professor.getCelular());
			ps.setDouble(3, professor.getValorHora()); 
			
			ok = ps.execute();
		} catch(Exception e) {
			e.printStackTrace();
			ok = false;
		} finally {
			fecharConexao();
		}
			
		return ok;
		
	}
	
	public List<Professor> listar(String nomeBusca) {
		ArrayList<Professor> lista = new ArrayList<Professor>();
		
		String sql = "select * from professor " 
				   + "where nome like ? "
				   + "order by nome";
		
		try {
			
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setString(1, "%" + nomeBusca + "%");
			
			ResultSet rs = ps.executeQuery();
			
			Professor c;
			while(rs.next()) {
				c = new Professor();
				c.setId(rs.getLong("idprofessor"));
				c.setNome(rs.getString("nome"));
				c.setCelular(rs.getString("celular"));
				c.setValorHora(rs.getDouble("valor"));
				
				lista.add(c);
			}
		} catch(Exception e) {
			
		}finally {
			fecharConexao();
		}
		
		
		return lista;
	}

	public Professor buscar(long id) {
		// TODO Auto-generated method stub
		Professor c = null;
		
		String sql = "select * from professor "
				   + "where idprofessor = ? ";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setLong(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				c = new Professor();
				c.setId(rs.getLong("idcurso"));
				c.setNome(rs.getString("nome"));
				c.setCelular("celular");
				c.setValorHora(rs.getDouble("valor"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			fecharConexao();
		}
		
		return c;
	}

	public boolean alterar(Professor c) {
		// TODO Auto-generated method stub
		boolean ok = true;
		
		String sql = "update professor set "
				   + "nome = ?, "
				   + "celular = ? "
				   + "valorhora = ? "
				   + "where idprofessor = ?";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setString(1, c.getNome());
			ps.setString(2, c.getCelular());
			ps.setDouble(3, c.getValorHora());
			ps.setLong(4, c.getId());
			
			ps.execute();
		} catch(Exception e) {
			e.printStackTrace();
			
			ok = false;
		}finally {
			fecharConexao();
		}
		
		return ok;
	}

	public boolean excluir(long id) {
		// TODO Auto-generated method stub
		boolean ok = true;
		
		String sql = "delete from professor where idprofessor = ?";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setLong(1, id);
			
			ok = ps.execute();
		}catch(Exception e) {
			e.printStackTrace();
			ok = false;
		}finally {
			fecharConexao();
		}
		
		return ok;
	}
}
