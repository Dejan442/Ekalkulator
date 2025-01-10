

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
 * Servlet implementation class S2
 */
@WebServlet("/S2")
public class S2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S2() {
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
		
		
		KlasaZvezda kz=new KlasaZvezda();
		
		
		
		double impedansa=Double.parseDouble(request.getParameter("impedansa1"));
		double impedansa2=Double.parseDouble(request.getParameter("impedansa2"));
		double impedansa3=Double.parseDouble(request.getParameter("impedansa3"));
		
		double Z1=kz.Z1(impedansa, impedansa2, impedansa3);
		double Z2=kz.Z2(impedansa, impedansa2, impedansa3);
		double Z3=kz.Z3(impedansa, impedansa2, impedansa3);
		
		
		
		PrintWriter out=response.getWriter();
		out.println("rezultat je "+ Z1);
		out.println("rezultat je "+ Z2);
		out.println("rezultat je "+ Z3);
		
		

	    // Postavljanje vrednosti u request
	    request.setAttribute("calculatedValue", Z1);
	    request.setAttribute("calculatedValue2", Z2);
	    request.setAttribute("calculatedValue3", Z3);
	    

	    // Prosleđivanje JSP-u
	    RequestDispatcher dispatcher = request.getRequestDispatcher("ZvezdaRez.jsp");
	    dispatcher.forward(request, response);
		
	   

		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/namotaji","root","Dejan");
			
			PreparedStatement ps=(PreparedStatement) con.prepareStatement("insert into tabela1 values(?,?,?,?,?,?)");
			
			
			
			ps.setDouble(1,  Z1);
			ps.setDouble(2,  Z2);
			ps.setDouble(3, Z3);
			ps.setDouble(4,  impedansa);
			ps.setDouble(5, impedansa2);
			ps.setDouble(6,  impedansa3);
			
			int i =ps.executeUpdate();
			
			if(i>0) {
				
			
				
			}
			
			
			
		}catch(Exception e) {
			
			System.out.println(e);
		}
		

	    
	    
	    
	    
	
	
	
	
	}

}
