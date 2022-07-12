package br.com.cursoja.controlecursoja.controller;

import java.io.IOException;

import br.com.cursoja.controlecursoja.model.dao.CursoDao;
import br.com.cursoja.controlecursoja.model.entidade.Curso;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IncluirCurso
 */
public class IncluirCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IncluirCurso() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nome = request.getParameter("nomecurso");
		String strValor = request.getParameter("mensalidade");
		
		double mensalidade = 0.0;
		try {
			mensalidade = Double.parseDouble(strValor);
		} catch (Exception e) {
			
		}
		
		Curso c = new Curso();
		c.setNome(nome);
		c.setValor(mensalidade);
		
		CursoDao dao = new CursoDao();
		boolean retorno = dao.incluir(c);
		
		response.sendRedirect("lista_curso.jsp");
	}

}
