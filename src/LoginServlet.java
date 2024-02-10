

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		request.getRequestDispatcher("link.html").include(request, response);
		
		String name=request.getParameter("uname");
		String pass=request.getParameter("upass");
		
		if(pass.equals("123"))
		{
			out.print("<br>You are successfully Logged In");
			out.print("<br> <b>Welcome</b> "+name);
			
			Cookie ck= new Cookie("uname", name);
			response.addCookie(ck);
			
		}else
		{
			out.print("<br><br>SORRY, Username or password error...!!");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		out.close();
		
		
	}

}
