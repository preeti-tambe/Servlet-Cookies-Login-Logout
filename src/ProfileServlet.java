

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		request.getRequestDispatcher("link.html").include(request, response);
		
		Cookie ck[]=request.getCookies();
		if(ck!=null)
		{
			String name=ck[0].getValue();
			if(!name.equals("") || name!=null)
			{
				out.print("<br><b> Welcome to profile</b>");
				out.print("<br>Welcome ,"+name);
			}
		}
		else
		{
			out.print("<br>Please Login First");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
