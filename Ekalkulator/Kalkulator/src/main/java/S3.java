

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
 * Servlet implementation class S3
 */
@WebServlet("/S3")
public class S3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S3() {
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
				
		
uTrougao tr=new uTrougao();
		
		
		double Z1=Double.parseDouble(request.getParameter("impedansa1"));
		double Z2=Double.parseDouble(request.getParameter("impedansa2"));
		double Z3=Double.parseDouble(request.getParameter("impedansa3"));
		
		double Z12=tr.Z12(Z1, Z2, Z3);
		double Z13=tr.Z13(Z1, Z2, Z3);
		double Z23=tr.Z23(Z1, Z2, Z3);
		
		
		PrintWriter out=response.getWriter();
		
		out.println("Rezultat za Z12 je "+Z12);
		out.println("Rezultat za Z13 je "+Z13);
		out.println("Rezultat za Z23 je"+Z23);
		
		 request.setAttribute("calculatedValue", Z12);
		    request.setAttribute("calculatedValue2", Z13);
		    request.setAttribute("calculatedValue3", Z23);
		    

		    // Prosleđivanje JSP-u
		    RequestDispatcher dispatcher = request.getRequestDispatcher("TrougaoRez.jsp");
		    dispatcher.forward(request, response);
		    
		    

		    try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/namotaji","root","Dejan");
				
				PreparedStatement ps=(PreparedStatement) con.prepareStatement("insert into tabela2 values(?,?,?,?,?,?)");
				
				
				ps.setDouble(1,Z12);
				ps.setDouble(2,Z13);
				ps.setDouble(3, Z23);
				ps.setDouble(4, Z1);
				ps.setDouble(5, Z2);
				ps.setDouble(6,Z3);
				
				
				int i =ps.executeUpdate();
				
				if(i>0) {
					
				
					
				}
				
				
				
			}catch(Exception e) {
				
				System.out.println(e);
			}
			

		    
		    
		    
		    
		    
		
		
	}

}
