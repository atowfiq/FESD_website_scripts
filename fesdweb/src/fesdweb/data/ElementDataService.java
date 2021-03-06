package fesdweb.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.fabric.xmlrpc.base.Array;

import fesdweb.model.Element;
import fesdweb.model.SpaceGroup;

public class ElementDataService {

	public ElementDataService()
	{
	}
	
	public Element GetElement(int atomicNo)
	{
		Element e = null;
		Statement stmt = null;
		try {
			Connection conn = DataUtils.CreateConnection();
			stmt = conn.createStatement();
			                   
			ResultSet rs = stmt.executeQuery("SELECT symbol,groupid,name,period,molarmass FROM element Where AtomicNumber="+atomicNo);
			
			try {
				while (rs.next()) {
					e = new Element(atomicNo, rs.getObject(1).toString(),Integer.parseInt(rs.getObject(2).toString()) , rs.getObject(3).toString(), Integer.parseInt(rs.getObject(4).toString()), Float.parseFloat(rs.getObject(5).toString()));
				}
				rs.close();
				stmt.close();
				conn.close();
			
			} catch (Exception ex) {
				ex.printStackTrace();
				System.out.print(ex.getMessage());
			}
		} catch (Exception ex) {
            ex.printStackTrace();
            System.out.print(ex.getMessage());
		}
		finally
		{
			if(stmt!=null)
				try {
					stmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
		
		return e;

	}
	
	public ArrayList<SpaceGroup> GetSpaceGroup(int atomicNo)
	{
		ArrayList<SpaceGroup> spaceGroups = new ArrayList<SpaceGroup>();
		Statement stmt = null;
		try {
			Connection conn = DataUtils.CreateConnection();
			stmt = conn.createStatement();
			String query = "select _symmetry_space_group_name_Hall,_space_group_IT_number"
					+" from compound where _symmetry_space_group_name_Hall is not null  and _space_group_IT_number is not null and atomicNo="+atomicNo
					+ " group by _space_group_IT_number,_symmetry_space_group_name_Hall"
					+" order by _space_group_IT_number";  
			ResultSet rs = stmt.executeQuery(query);
			
			try {
				while (rs.next()) {
					String sg = rs.getObject(1).toString();
					String sgNo = rs.getObject(2).toString();
					SpaceGroup	s = new SpaceGroup( sg,Integer.parseInt(sgNo));
					spaceGroups.add(s);
				}
				rs.close();
				stmt.close();
				conn.close();
			
			} catch (Exception ex) {
				ex.printStackTrace();
				System.out.print(ex.getMessage());
			}
		} catch (Exception ex) {
            ex.printStackTrace();
            System.out.print(ex.getMessage());
		}
		finally
		{
			if(stmt!=null)
				try {
					stmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
		
		return spaceGroups;

	}

	public ArrayList<String> GetSpaceGroupCellSetting() {
		ArrayList<String> spaceGroupCSList = new ArrayList<String>();
		Statement stmt = null;
		try {
			Connection conn = DataUtils.CreateConnection();
			stmt = conn.createStatement();
			String query = "select _symmetry_cell_setting from compound"
						+" where _symmetry_cell_setting is not null and _symmetry_cell_setting <>'?'"
						+"group by _symmetry_cell_setting";  
			ResultSet rs = stmt.executeQuery(query);
			
			try {
				while (rs.next()) {
					String sgCS = rs.getObject(1).toString();
					
					spaceGroupCSList.add(sgCS);
				}
				rs.close();
				stmt.close();
				conn.close();
			
			} catch (Exception ex) {
				ex.printStackTrace();
				System.out.print(ex.getMessage());
			}
		} catch (Exception ex) {
            ex.printStackTrace();
            System.out.print(ex.getMessage());
		}
		finally
		{
			if(stmt!=null)
				try {
					stmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
		

		return spaceGroupCSList;
	}
	
	
	public ArrayList<String> GetAllElements() {
		ArrayList<String> allElements = new ArrayList<String>();
		Statement stmt = null;
		try {
			Connection conn = DataUtils.CreateConnection();
			stmt = conn.createStatement();
			String query = "select symbol from element group by symbol";  
			ResultSet rs = stmt.executeQuery(query);
			
			try {
				while (rs.next()) {
					String elementSymbol = rs.getObject(1).toString();
					
					allElements.add(elementSymbol);
				}
				rs.close();
				stmt.close();
				conn.close();
			
			} catch (Exception ex) {
				ex.printStackTrace();
				System.out.print(ex.getMessage());
			}
		} catch (Exception ex) {
            ex.printStackTrace();
            System.out.print(ex.getMessage());
		}
		finally
		{
			if(stmt!=null)
				try {
					stmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
		

		return allElements;
	}
	
	
}
