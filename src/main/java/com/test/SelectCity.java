package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

/**
 * Servlet implementation class Controller
 */
public class SelectCity extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String city = request.getParameter("city");
		PrintWriter out = response.getWriter();
		String population = null;
		String populationDensity = null;
		String areaTotal = null;
		
		if(city == null) {
			response.setContentType("text/html");
			out.println("<html><body><h2>Invalid city.!!!</h2></body></html>");

		} else {
			try {
				
				if ("LA".equalsIgnoreCase(city)) {
					
					URLConnection connection = new URL("http://dbpedia.org/resource/Los_Angeles").openConnection();
					connection.setRequestProperty("Accept", "application/json");
					InputStream res = connection.getInputStream();
					BufferedReader buf = new BufferedReader(new InputStreamReader(res));
					StringBuffer jsonBuf = new StringBuffer();
					String s = buf.readLine();
					while(s != null) {
						jsonBuf.append(s.trim());
						s = buf.readLine();
					}
					
					JSONObject j = new JSONObject(jsonBuf.toString());
					
					population = j.getJSONObject("http://dbpedia.org/resource/Los_Angeles")
							.getJSONArray("http://dbpedia.org/ontology/populationTotal").getJSONObject(0).getString("value");
					
					
					populationDensity = j.getJSONObject("http://dbpedia.org/resource/Los_Angeles")
							.getJSONArray("http://dbpedia.org/ontology/PopulatedPlace/populationDensity").getJSONObject(0).getString("value");
					
					
					areaTotal = j.getJSONObject("http://dbpedia.org/resource/Los_Angeles")
							.getJSONArray("http://dbpedia.org/ontology/PopulatedPlace/areaTotal").getJSONObject(0).getString("value");
					
				}
				
				else if ("SC".equalsIgnoreCase(city)) {
					
					URLConnection connection = new URL("http://dbpedia.org/resource/Sacramento,_California").openConnection();
					connection.setRequestProperty("Accept", "application/json");
					InputStream res = connection.getInputStream();
					BufferedReader buf = new BufferedReader(new InputStreamReader(res));
					StringBuffer jsonBuf = new StringBuffer();
					String s = buf.readLine();
					while(s != null) {
						jsonBuf.append(s.trim());
						s = buf.readLine();
					}
					
					JSONObject j = new JSONObject(jsonBuf.toString());
					
					population = j.getJSONObject("http://dbpedia.org/resource/Sacramento,_California")
							.getJSONArray("http://dbpedia.org/ontology/populationTotal").getJSONObject(0).getString("value");
					
					
					populationDensity = j.getJSONObject("http://dbpedia.org/resource/Sacramento,_California")
							.getJSONArray("http://dbpedia.org/ontology/PopulatedPlace/populationDensity").getJSONObject(0).getString("value");
					
					
					areaTotal = j.getJSONObject("http://dbpedia.org/resource/Sacramento,_California")
							.getJSONArray("http://dbpedia.org/ontology/PopulatedPlace/areaTotal").getJSONObject(0).getString("value");
					
					
				}

				else if ("SE".equalsIgnoreCase(city)) {
					
					URLConnection connection = new URL("http://dbpedia.org/resource/Seattle").openConnection();
					connection.setRequestProperty("Accept", "application/json");
					InputStream res = connection.getInputStream();
					BufferedReader buf = new BufferedReader(new InputStreamReader(res));
					StringBuffer jsonBuf = new StringBuffer();
					String s = buf.readLine();
					while(s != null) {
						jsonBuf.append(s.trim());
						s = buf.readLine();
					}
					
					JSONObject j = new JSONObject(jsonBuf.toString());
					
					population = j.getJSONObject("http://dbpedia.org/resource/Seattle")
							.getJSONArray("http://dbpedia.org/ontology/populationTotal").getJSONObject(0).getString("value");
					
					
					populationDensity = j.getJSONObject("http://dbpedia.org/resource/Seattle")
							.getJSONArray("http://dbpedia.org/ontology/PopulatedPlace/populationDensity").getJSONObject(0).getString("value");
					
					
					areaTotal = j.getJSONObject("http://dbpedia.org/resource/Seattle")
							.getJSONArray("http://dbpedia.org/ontology/PopulatedPlace/areaTotal").getJSONObject(0).getString("value");
						
				}
				
				request.setAttribute("population",population);
				request.setAttribute("populationDensity",populationDensity);
				request.setAttribute("areaTotal",areaTotal);
				
				RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/jsp/reply.jsp");
		        view.forward(request, response);	

				
				
			} catch (Exception e ){
				e.printStackTrace();
			}
		}
	}

}
