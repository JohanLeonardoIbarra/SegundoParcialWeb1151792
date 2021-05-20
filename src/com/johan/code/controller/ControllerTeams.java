package com.johan.code.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.johan.code.dao.TeamDao;
import com.johan.code.model.Team;

/**
 * Servlet implementation class ControllerTeams
 */
@WebServlet({"/teams","/teams/*"})
public class ControllerTeams extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeamDao teamDao;
    /**
     * Default constructor. 
     */
    public ControllerTeams() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		teamDao = new TeamDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String[] opt =  request.getRequestURI().split("/");
		String action =  request.getContextPath();
		if (opt.length>3){
		 action = opt[3];
		}		
		try {
			switch (action) {
			case "new":
				showNewForm(request, response);
				break;
			case "insert":
				insertarTeam(request, response);
				break;
			case "delete":
				eliminarTeam(request, response);
				break;
			case "edit":
				showEditForm(request, response);
				break;
			case "update":
				editarTeam(request, response);
				break;
			default:
				listTeams(request, response);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	private void listTeams(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Team> teams = teamDao.selectAll();
		request.setAttribute("teams", teams);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/Teams.jsp");
		dispatcher.forward(request, response);
	}

	private void editarTeam(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String pais = request.getParameter("pais");
 
		
		Team team = new Team(id, nombre, pais);
		teamDao.update(team);
		response.sendRedirect("/GiroDItalia/teams/list");
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		Team team = teamDao.select(id);

		request.setAttribute("team", team);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/newTeam.jsp");
		dispatcher.forward(request, response);
	}

	private void eliminarTeam(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		teamDao.delete(id);
		response.sendRedirect("/GiroDItalia/teams/list");
	}

	private void insertarTeam(HttpServletRequest request, HttpServletResponse response) throws IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/newTeam.jsp");
		String nombre = request.getParameter("id");
		String email = request.getParameter("name");
		String pais = request.getParameter("country");
		Team team = new Team(nombre, email, pais);
		teamDao.insert(team);
		response.sendRedirect("/GiroDItalia/teams/list");
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/newTeam.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
