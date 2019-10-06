package com.jcg.java;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.google.gson.Gson;

@WebServlet("/employeeServlet")
public class EmployeeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/***** This Method Is Called By The Servlet Container To Process A 'GET' Request. *****/
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
		handleRequest(req, resp);
	}

	public void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException {

		JSONArray arrayObj = null;
		List<Employee> empList = null;
		try {

			/***** Fetching Employee Records From The Database *****/
			empList = MyDb.getEmployeeListFromDb();
			if(empList != null && empList.size() > 0) {				
				System.out.println("Total Employee Records Fetch From Db Are?= " + empList.size());
			} else {
				System.out.println("No Employee Records Are Present In Db");
			}

			arrayObj = new JSONArray(empList);
			String jObj = new Gson().toJson(arrayObj);

			/***** Preparing The Output Response *****/
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write(jObj);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}