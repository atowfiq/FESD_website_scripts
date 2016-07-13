package fesdweb.data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fesdweb.model.Compound;
import fesdweb.model.Element;


public class CompoundDataService {

	
	public CompoundDataService()
	{}
	
	

	public ArrayList<Compound> SearchCompound(int atomicNo, String addtionalElements,
			Boolean isShowAll, int spaceGroup, String crystalSystem,String restrictNumberOfElements) {
		
		ArrayList<Compound> compoundList = new ArrayList<Compound>();
		Connection conn = DataUtils.CreateConnection();
		String callSearchCompound ="{call SearchCompound(?,?,?,?)}";
		try (CallableStatement stmt = conn.prepareCall(callSearchCompound)) {
		    stmt.setInt(1, atomicNo);
		    stmt.setBoolean(2, isShowAll);
		    stmt.setInt(3, spaceGroup);
		    stmt.setString(4, crystalSystem);
		    ResultSet rs = stmt.executeQuery();
			
		    
		    try {
				while (rs.next()) {
						String formula = rs.getString("_chemical_formula_sum");
						if(!IsValidForAdditionalElements(formula,addtionalElements,restrictNumberOfElements))
							continue;
						Compound c = new Compound(atomicNo, rs.getInt("_cod_database_code"),formula,  rs.getInt("_space_group_IT_number"), rs.getString("_symmetry_cell_setting"), rs.getString("_symmetry_space_group_name_HM"));
						compoundList.add(c); 
				}
				rs.close();
				stmt.close();
				conn.close();
			
			} catch (Exception ex) {
				ex.printStackTrace();
				System.out.print(ex.getMessage());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return compoundList;
	}



	private boolean IsValidForAdditionalElements(String formula, String addtionalElements,String restrictNumberOfElements) {
		
		String[] elementsInCompound =  formula.split(" ");
		String[] filterElements =  addtionalElements.split(",");
		
		if(restrictNumberOfElements.equals("Binary")&&elementsInCompound.length!=2)
			return false;
		if(restrictNumberOfElements.equals("Ternary")&&elementsInCompound.length!=3)
			return false;
			
		
		if(addtionalElements.length()==0)
		{
			return true;
			
		}
		
		
			
		for(int i=0;i<filterElements.length;i++)
		{
			boolean isExist= false;
			for(int j=0;j<elementsInCompound.length;j++)
			{
				String e  = elementsInCompound[j].replaceAll("\\d","");
					
				
				if(e.toLowerCase().equals(filterElements[i].toLowerCase()))
				{
					isExist = true;
					break;
				}
			
			}
			if(!isExist)
				return false;
		}
		
		return true;
	}



	public Compound GetCompoud(int codId) {
		Compound c = null;
		Statement stmt = null;
		try {
			Connection conn = DataUtils.CreateConnection();
			stmt = conn.createStatement();
			                   
			ResultSet rs = stmt.executeQuery("SELECT atomicno,_chemical_formula_structural,_chemical_formula_sum,_space_group_IT_number,"
					+"_symmetry_cell_setting,_symmetry_space_group_name_Hall,_symmetry_space_group_name_HM,_cell_angle_alpha,"
					+"_cell_formula_units_Z,_cell_length_a,_cell_length_b,_cell_length_c,_cell_volume,_cod_database_code FROM compound Where _cod_database_code="+codId);
			
			try {
				while (rs.next()) {
					 c = new Compound(rs.getInt("atomicNo"), rs.getInt("_cod_database_code"),rs.getString("_chemical_formula_sum"),  rs.getInt("_space_group_IT_number"), rs.getString("_symmetry_cell_setting"), 
							 rs.getString("_symmetry_space_group_name_HM"),rs.getString("_symmetry_space_group_name_Hall"),rs.getString("_cell_angle_alpha"),rs.getString("_cell_formula_units_Z"),rs.getString("_cell_length_a"),rs.getString("_cell_length_b")
							 ,rs.getString("_cell_length_c"),rs.getString("_cell_volume"));
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
		

		return c;
	}
}
