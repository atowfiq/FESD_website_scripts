package fesdweb.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import fesdweb.data.CompoundDataService;
import fesdweb.model.Compound;

/**
 * Servlet implementation class CompoundServlet
 */
@WebServlet("/CompoundServlet")
public class CompoundServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompoundServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int atomicNo = Integer.parseInt(request.getParameter("AtomicNo").toString());
		String addtionalElements = request.getParameter("AE").toString();
		Boolean isShowAll = Boolean.parseBoolean(request.getParameter("IsShowAll"));
		int spaceGroup = Integer.parseInt(request.getParameter("SpaceGroup"));
	    String crystalSystem  = request.getParameter("CrystalSystem");
	    String restrictNumberOfElements  = request.getParameter("RestrictNumberOfElements");
		
	    ArrayList<Compound> compoundsList = new CompoundDataService().SearchCompound(atomicNo,addtionalElements,isShowAll,spaceGroup,crystalSystem,restrictNumberOfElements);
	    
	    String json = new Gson().toJson(compoundsList);

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
