package br.com.cursoja.controlecursoja.controller;

import java.io.IOException;

import br.com.cursoja.controlecursoja.model.dao.ProfessorDao;
import br.com.cursoja.controlecursoja.model.entidade.Professor;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IncluirProfessor
 */
public class IncluirProfessor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IncluirProfessor() {
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
		String nome = request.getParameter("nomeprofessor");
		String celular = request.getParameter("celular");
		String strValor = request.getParameter("valorhora");
		
		double valorhora = 0.0;
		try {
			valorhora = Double.parseDouble(strValor);
		} catch (Exception e) {
			
		}
		
		Professor p = new Professor();
		p.setNome(nome);
		p.setCelular(celular);
		p.setValorHora(valorhora);
		
		ProfessorDao dao = new ProfessorDao();
		boolean retorno = dao.incluir(p);
		
		response.sendRedirect("lista_professor.jsp");
	}

}
