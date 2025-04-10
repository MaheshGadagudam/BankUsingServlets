package SBI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class EmployeeService {
	public static float checkBalance(HttpServletRequest req)
	{
		try {
			Connection con=getConnection();
			if(con!=null)
			{
				
				Statement st=con.createStatement();
				
				String query="select * from SBI where account=1234";
				ResultSet rs=st.executeQuery(query);
				
				float balance=0;
				while(rs.next())
				{
					int account=rs.getInt(1);
					String name=rs.getString(2);
					long ph=rs.getLong(3);
					balance=rs.getFloat(4);
					
				}
				return balance;
			}
			else {
				
				return 0;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","Mahesh@3743");
			return con;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static ArrayList<Employee> showProfile(HttpServletRequest req)
	{
		try {
			Connection con=getConnection();
			Statement st=con.createStatement();
			String query="select * from SBI";
			ResultSet rs=st.executeQuery(query);
			ArrayList<Employee> data=new ArrayList<>();
			while(rs.next())
			{
				int account=rs.getInt(1);
				String name=rs.getString(2);
				long phno=rs.getLong(3);
				float balance=rs.getFloat(4);
				Employee e=new Employee(account, name, phno, balance);
				data.add(e);
			}
			rs.close();
			st.close();
			con.close();
			return data;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static float deposit(HttpServletRequest req)
	{
		try {
			Connection con=getConnection();
			float balance=checkBalance(req);
			float depoAmount=Float.parseFloat(req.getParameter("deposit"));
			balance=balance+depoAmount;
			PreparedStatement pst=con.prepareStatement("update SBI set balance=? where account=1234");
			pst.setFloat(1, balance);
			pst.executeUpdate();
			pst.close();
			con.close();
			return checkBalance(req);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	public static float transfer(HttpServletRequest req)
	{
		try {
			Connection con=getConnection();
			float balance=checkBalance(req);
			float transferAmount=Float.parseFloat(req.getParameter("transfer"));
			balance=balance-transferAmount;
			PreparedStatement pst=con.prepareStatement("update SBI set balance=? where account=1234");
			pst.setFloat(1, balance);
			pst.executeUpdate();
			pst.close();
			con.close();
			return checkBalance(req);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}
}
