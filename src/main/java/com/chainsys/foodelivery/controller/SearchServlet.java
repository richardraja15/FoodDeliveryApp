package com.chainsys.foodelivery.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.fooddelivery.dao.SearchDAO;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	String search=request.getParameter("search");
	
	SearchDAO searchDAO=new SearchDAO();
	ArrayList<String> restaurantName = null;
	ArrayList<String> menuName = null;
	try {
		restaurantName=searchDAO.getRestaurant(search);
		menuName=searchDAO.getMenu(search);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	PrintWriter out=response.getWriter();
	out.println(menuName);
	System.out.println(restaurantName);
	
	}

}
