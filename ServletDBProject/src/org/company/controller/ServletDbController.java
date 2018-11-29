package org.company.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.company.dao.ServletDbDao;
import org.company.model.ServletDbModel;

import javafx.print.PrintQuality;

/**
 * Servlet implementation class ServletDbController
 */
@WebServlet("/ServletDbController")
public class ServletDbController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletDbModel model;
	private ServletDbDao dao;
	public void init() {
		String url = getServletContext().getInitParameter("url");
		String user = getServletContext().getInitParameter("user");
		String password = getServletContext().getInitParameter("password");
		//		System.out.println(url);
		//		System.out.println(user);
		//		System.out.println(password);
		dao = new ServletDbDao(url,user,password);
		//dao.ServletDbDaos();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String title = request.getParameter("bookTitle");
		String author = request.getParameter("bookAuthor");
		String price = request.getParameter("bookPrice");
		//model.setTitle(title);
		//model.setAuthor(author);
		//model.setPrice(price);
		model = new ServletDbModel(title,author,price);
		ServletDbDao dao = new ServletDbDao();
		try {
			dao.ServletDbDaos(model);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		RequestDispatcher rs = request.getRequestDispatcher("welcome.html");
		rs.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
