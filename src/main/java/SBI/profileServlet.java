package SBI;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/profileServlet")
public class profileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		ArrayList<Employee> data=EmployeeService.showProfile(request);
		if(data!=null)
		{
			out.println("The User Details are as Follows");
			for(Employee e:data)
			{
				out.println(e);
			}
		}
		else {
			out.println("User Profile Fetching Failed");
		}
	}

}
