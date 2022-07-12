package br.com.cursoja.controlecursoja.controller;

import java.io.IOException;

import br.com.cursoja.controlecursoja.model.dao.ProfessorDao;
import br.com.cursoja.controlecursoja.model.entidade.Professor;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AlterarProfessor
 */
public class AlterarProfessor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterarProfessor() {
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
		String strId = request.getParameter("id");
		String nome = request.getParameter("nome");
		String celular = request.getParameter("celular");
		String strValor = request.getParameter("valorhora");
		
		long id = 0;
		try {
			id = Long.parseLong(strId);
		} catch(Exception e) {
			
		}
		
		double valor = 0;
		try {
			valor = Double.parseDouble(strValor);
		} catch(Exception e) {
			
		}
		
		Professor p = new Professor();
		p.setId(id);
		p.setNome(nome);
		p.setCelular(celular);
		p.setValorHora(valor);
		
		ProfessorDao dao = new ProfessorDao();
		boolean retorno = dao.alterar(p);
		response.sendRedirect("lista_professor.jsp");
	}

}
