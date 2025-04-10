package SBI;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/depositServlet")
public class depositServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Float balance=EmployeeService.deposit(request);
		float depoAmount=Float.parseFloat(request.getParameter("deposit"));
		if(balance!=0)
		{
			out.println(depoAmount+" is deposited successfully.");
			out.println("Your Balance After Deposit is "+balance);
		}
		else {
			out.println("Deposit Failed");
		}
	}

}
