package SBI;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/transferServlet")
public class transferServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		float balance=EmployeeService.transfer(request);
		float transferAmount=Float.parseFloat(request.getParameter("transfer"));
		if(balance!=0)
		{
			out.println(transferAmount+" is transferred SuccessFully");
			out.println("The Balance is "+balance);
		}
		else {
			out.println("Amount transfer Failed");
		}

	}

}
