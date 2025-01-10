
public class Trafo {
	
	
	double np,us,up;
	double rp=5;
	
	public static  double NS(double np,double us,double up) {
		
		return np*(us/up);
	}
	
	public static double IS(double us,double rp) {
		
		return (us/rp);
	}

}
