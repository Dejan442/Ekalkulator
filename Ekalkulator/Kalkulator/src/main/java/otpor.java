

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class otpor
 */
@WebServlet("/otpor")
public class otpor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public otpor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	String br1=request.getParameter("val1");
	String br2=request.getParameter("val2");
	String br3=request.getParameter("val3");
	String br4=request.getParameter("val4");
	
	
	String brS=br1+br2;
	
	PrintWriter out=response.getWriter();
	out.println("Rezultat je"+brS);
	
	Double brd=Double.parseDouble(brS);
	Double br3d=Double.parseDouble(br3);
	
	double otpor=brd*br3d;
	
	Double tolerancija=Double.parseDouble(br4);
	
	
	out.println("otpor je "+otpor);
	out.println("Tolerancija je "+tolerancija);
	
	request.setAttribute("Vrednost", otpor);
	request.setAttribute("Vrednost1", tolerancija);
	
	
	RequestDispatcher dis=request.getRequestDispatcher("OtpornostPrikaz.jsp");

	dis.forward(request,response);
	
	
	}

}
