package com.jcg.java.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.google.gson.Gson;
import com.jcg.java.config.Dbimplementation;
import com.jcg.java.config.MyDb;
import com.jcg.java.model.Employee;
import com.jcg.java.model.Hotel;

@WebServlet("/searchServlet")
public class SearchServlet extends HttpServlet {
	 MyDb db=new MyDb();
	 Dbimplementation dbimpl=new Dbimplementation();
	private static final long serialVersionUID = 1L;

	/***** This Method Is Called By The Servlet Container To Process A 'GET' Request. *****/
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
		handleRequest(req, resp);
	}

	public void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException {

		JSONArray arrayObj = null;
		List<Hotel> hotelList = null;
		try {

			/***** Fetching Employee Records From The Database *****/
			hotelList = db.getHotelListFromDb();
			if(hotelList != null && hotelList.size() > 0) {				
				System.out.println("Total Employee Records Fetch From Db Are?= " + hotelList.size());
			} else {
				System.out.println("No Employee Records Are Present In Db");
			}

			arrayObj = new JSONArray(hotelList);
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
