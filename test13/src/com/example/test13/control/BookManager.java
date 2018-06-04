package com.example.test13.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.test13.model.BookDbDao;
import com.example.test13.model.BookDto;
import com.example.test13.model.DBConnectionInfo;

/**
 * Servlet implementation class BookManager
 */
//@WebServlet("/BookManager")
public class BookManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// step #1. get URL path info
		request.setCharacterEncoding("UTF-8");
		
		String urlSubPath = request.getPathInfo().split("/")[1];
		
		// step #2. process input data and route output
		DBConnectionInfo connInfo =
			(DBConnectionInfo)getServletContext().getAttribute("connection-info");
		String viewName = null;
		
		if (urlSubPath.equals("search")) {
			viewName = "/search.jsp";
		}
		else if (urlSubPath.equals("search_result")) {
			// get input parameters
			String code = request.getParameter("code");
			
			try {
				// data processing
				BookDbDao dao = new BookDbDao(connInfo);
				List<BookDto> bookList = dao.getBookList(code);

				// output results
				request.setAttribute("book_list", bookList);
				viewName = "/search_result.jsp";			
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		else if (urlSubPath.equals("insert")) {
			viewName = "/insert.jsp";
		}
		else if (urlSubPath.equals("insert_result")) {
			// get input parameters
			BookDto book = new BookDto();
			
			book.setCode(request.getParameter("code"));
			book.setTitle(request.getParameter("title"));
			book.setWriter(request.getParameter("writer"));
			book.setPrice(
					Integer.parseInt(request.getParameter("price")));
					
			try {
				// data prcoessing
				BookDbDao dao = new BookDbDao(connInfo);
				int result = dao.insertBook(book);

				// output results
				request.setAttribute("result", String.valueOf(result));
				viewName = "/insert_result.jsp";
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if (urlSubPath.equals("delete")) {
			// get input parameters
			String code = request.getParameter("code");

			try {
				// data prcoessing
				BookDbDao dao = new BookDbDao(connInfo);
				int result = dao.deleteBook(code);

				// output results
				request.setAttribute("result", String.valueOf(result));
				viewName = "/delete_result.jsp";
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if (urlSubPath.equals("update")) {
			// get input parameters
			String code = request.getParameter("code");
			
			try {
				// data processing
				BookDbDao dao = new BookDbDao(connInfo);
				BookDto book = null;
				List<BookDto> bookList = dao.getBookList(code);
				if (bookList != null) {
					book = bookList.get(0);
				}

				// output results
				request.setAttribute("book", book);
				viewName = "/update.jsp";			
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		else if (urlSubPath.equals("update_result")) {
			// get input parameters
			BookDto book = new BookDto();
			
			book.setCode(request.getParameter("code"));
			book.setTitle(request.getParameter("title"));
			book.setWriter(request.getParameter("writer"));
			book.setPrice(
					Integer.parseInt(request.getParameter("price")));
					
			try {
				// data prcoessing
				BookDbDao dao = new BookDbDao(connInfo);
				int result = dao.updateBook(book);

				// output results
				request.setAttribute("result", String.valueOf(result));
				viewName = "/update_result.jsp";
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		else {
			viewName = "/error_400.jsp";
		}
		
		// step #3. forward to view page
		if (viewName != null) {
			RequestDispatcher view 
				= request.getRequestDispatcher(viewName);
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
