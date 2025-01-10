

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Tr
 */
@WebServlet("/Tr")
public class Tr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tr() {
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
		
	
		double  Up=Double.parseDouble(request.getParameter("UP"));

		double Us=Double.parseDouble(request.getParameter("US"));
				double Np=Double.parseDouble(request.getParameter("NP"));
				
				
				Trafo tr=new Trafo();
				
				double NS=tr.NS(Np, Us, Up);
				double IS=tr.IS(Us, NS);
				
				
				
				double Ip=IS*(NS/Np);
				
				PrintWriter out=response.getWriter();
				
				out.println("Rezultati "+NS);
				out.println("Rezultati "+IS);
				out.println("Rezultati "+Ip);
				
				
				request.setAttribute("calculatedValue1", Up);
		request.setAttribute("calculatedValue2",Us);
		request.setAttribute("calculatedValue3", Np);
		request.setAttribute("calculatedValue4", NS);
		request.setAttribute("calculatedValue5", IS);
		request.setAttribute("calculatedValue6", Ip);



		RequestDispatcher dis=request.getRequestDispatcher("Proracun.jsp");

		dis.forward(request,response);




		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/namotaji","root","Dejan");
			
			PreparedStatement ps=(PreparedStatement) con.prepareStatement("insert into trafo values(?,?,?,?,?,?)");
			
			
			ps.setDouble(1,Up);
			ps.setDouble(2,Us);
			ps.setDouble(3, Np);
			ps.setDouble(4, NS);
			ps.setDouble(5, IS);
			ps.setDouble(6,Ip);
			
			
			int i =ps.executeUpdate();
			
			if(i>0) {
				
			
				
			}
			
			
			
		}catch(Exception e) {
			
			System.out.println(e);
		}


	
	
	
	}

}
