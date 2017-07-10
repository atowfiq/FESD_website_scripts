package fesdweb.web;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import fesdweb.data.CompoundDataService;
import fesdweb.data.DataUtils;
import fesdweb.model.Compound;
import com.google.gson.Gson;

/**
 * Servlet implementation class BandStructureServlet
 */
@WebServlet("/BandStructureServlet")
public class BandStructureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BandStructureServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 int databaseId = Integer.parseInt(request.getParameter("database_id").toString());
		 String  source = request.getParameter("source").toString();
		 int bandIndex = Integer.parseInt(request.getParameter("database_id").toString());
		 
			//	Compound c = new CompoundDataService().GetCompoud(codId);
		//	String cif="";
		//	int cifId = c.Source.equals("cod")? c.CodID:c.ICSDID;
				//	cif =  new String(Files.readAllBytes(Paths.get(DataUtils.GetFCifFilePath(cifId,c.Source))), StandardCharsets.UTF_8);
				
					
		//	c.Cif =cif;
						
						

				String json = new Gson().toJson("Hello");

				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}