package br.com.cursoja.controlecursoja.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.cursoja.controlecursoja.model.entidade.Professor;

public class ProfessorDao extends Conexao{
	
	public boolean incluir (Professor professor) {
		boolean ok = false;
		String sql = "insert into professor (nome, celular, valorhora) values (?,?,?)";
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setString(1, professor.getNome());
			ps.setString(2, professor.getCelular());
			ps.setDouble(3, professor.getValorHora());
			ok = ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
			ok = false;
		} finally {
			fecharConexao();
		}
		return ok;
	}
	
	public List<Professor> listar(String nomeBusca){
		ArrayList<Professor> lista = new ArrayList<Professor>();
		String sql = "select * from professor where nome like ? order by nome";
		try {
			
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setString(1, "%"+nomeBusca+"%");
			ResultSet rs = ps.executeQuery();
			Professor p;
			while(rs.next()) {
				p = new Professor();
				p.setId(rs.getLong("idprofessor"));
				p.setNome(rs.getString("nome"));
				p.setCelular(rs.getString("celular"));
				p.setValorHora(rs.getDouble("valorhora"));
				lista.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		return lista;
	}
	
	public Professor buscar(long id) {
		Professor p = null;
		String sql = "select * from professor where idprofessor = ?";
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				p = new Professor();
				p.setId(rs.getLong("idprofessor"));
				p.setNome(rs.getString("nome"));
				p.setCelular(rs.getString("celular"));
				p.setValorHora(rs.getDouble("valorhora"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		return p;
	}
	
	public boolean alterar(Professor p) {
		boolean ok = true;
		String sql = "update professor set nome = ?, celular = ?, valorhora = ? where idprofessor = ?";
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setString(1, p.getNome());
			ps.setString(2, p.getCelular());
			ps.setDouble(3, p.getValorHora());
			ps.setLong(4, p.getId());
			ps.execute();
		} catch (Exception e){
			e.printStackTrace();
			ok = false;
		} finally {
			fecharConexao();
		}
		
		return ok;
	}
	
	public boolean excluir(long id) {
		boolean ok = true;
		String sql = "delete from professor where idprofessor = ?";
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setLong(1, id);
			ok = ps.execute();
		} catch(Exception e) {
			ok = false;
		} finally {
			fecharConexao();
		}
		
		return ok;
	}
}
