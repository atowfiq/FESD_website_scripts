package fesdweb.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import fesdweb.data.ElementDataService;
import fesdweb.model.Element;
import fesdweb.model.ElementPageData;
import fesdweb.model.SpaceGroup;

/**
 * Servlet implementation class ElementServlet
 */
@WebServlet("/ElementServlet")
public class ElementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	ElementDataService _Service= null;
    public ElementServlet() {
        super();
        _Service = new ElementDataService();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int atomicNo = Integer.parseInt(request.getParameter("AtomicNo").toString());
		 
		
		ElementPageData  elementData = new ElementPageData();
		
		elementData.ElementObj  = _Service.GetElement(atomicNo);
		//elementData.SpaceGroupSymmetry = _Service.GetSpaceGroup(atomicNo);
		elementData.SpaceGroupCellSetting = _Service.GetSpaceGroupCellSetting();
		elementData.AllElements = _Service.GetAllElements();
	    String json = new Gson().toJson(elementData);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
//		//response.getWriter().append("Served at: "+e.Name).append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
