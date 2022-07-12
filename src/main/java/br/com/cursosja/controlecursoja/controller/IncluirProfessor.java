package br.com.cursosja.controlecursoja.controller;

import java.io.IOException;

import br.com.cursosja.controlecursoja.model.dao.ProfessorDao;
import br.com.cursosja.controlecursoja.model.entidade.Professor;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IncluirCurso
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
		
		String nome = request.getParameter("nome");
		String celular = request.getParameter("celular");
		String strValor = request.getParameter("valorhora");
		
		double mensalidade = 0.0;
		
		try {
			mensalidade = Double.parseDouble(strValor);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		System.out.println(strValor);
		
		Professor c = new Professor();
		c.setNome(nome);
		c.setCelular(celular);
		c.setValorHora(strValor);
		
		ProfessorDao dao = new ProfessorDao();
		
		boolean retorno = dao.incluir(c);
		
		
		response.sendRedirect("lista_professor.jsp");
	}

}
