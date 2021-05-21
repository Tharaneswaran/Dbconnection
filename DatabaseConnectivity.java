package com.anna.msc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnectivity
{

	public static void main(String[] args)
	{
		Connection ObjConnect = null;
		Statement ObjStatement = null;
		ResultSet ObjResSt = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");

			ObjConnect = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root", "");
			ObjStatement = ObjConnect.createStatement();
			String strQuery = "select * from java_table1";

			ObjResSt = ObjStatement.executeQuery(strQuery);

			while (ObjResSt.next())
			{

				System.out.println("Reg No : " +ObjResSt.getInt(1) + " Name : " + ObjResSt.getString(2)+"   " + " Dept : "
						+ ObjResSt.getString(3) + "  "+ " Branch : " + ObjResSt.getString(4));

			}
			

		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try
			{
				ObjResSt.close();
				ObjStatement.close();
				ObjConnect.close();
			}
			catch (SQLException ex)
			{
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
			catch (NullPointerException ec)
			{
				ec.printStackTrace();	
		    }

	}
	}
}