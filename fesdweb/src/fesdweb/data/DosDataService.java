package fesdweb.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fesdweb.model.Bandstructure;
import fesdweb.model.Dos;
import fesdweb.model.PartialDos;

public class DosDataService {
	public Dos GetDos(int compoundId) {
		Dos dos = null;
		Statement stmt = null;
		try {
			Connection conn = DataUtils.CreateConnection();
			stmt = conn.createStatement();
			String query =  String.format("select energy,totaldos from dostotaldata where compoundid = %s", compoundId);                   
			ResultSet rs = stmt.executeQuery(query);	
			try {
				while (rs.next()) {
					dos = new Dos(rs.getString("energy"),rs.getString("totaldos"));
					dos.PartialValue= GetPartialDos(compoundId);
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
					e1.printStackTrace();
				}
		}
		return dos;
	}

	private ArrayList<PartialDos> GetPartialDos(int compoundId) {
		ArrayList<PartialDos> result = new ArrayList<>();
		Statement stmt = null;
		try {
			Connection conn = DataUtils.CreateConnection();
			stmt = conn.createStatement();
			String query =  String.format("select element,elementindex,orbitals,`f` from partialdosdata where compoundid = %s and `f` is not null;", compoundId);                   
			ResultSet rs = stmt.executeQuery(query);	
			try {
				while (rs.next()) {
					result.add(new PartialDos(rs.getString("element"),rs.getInt("elementindex"),rs.getString("orbitals"),rs.getString("f")));
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
					e1.printStackTrace();
				}
		}
		return result;

	}
	
}
