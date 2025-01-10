
public class KlasaZvezda {
	
	double Z12,Z23,Z13;
	
	
		public static double  	Z1(double Z12,double Z23,double Z13) {
			
			
			return  (Z12*Z13)/(Z12+Z13+Z23);
			
	}

		public static double Z2(double Z12,double Z23,double Z13) {
			
			return (Z12*Z23)/(Z12+Z23+Z13);
			
			
			
			
		}
		public static double Z3(double Z12,double Z23,double Z13) {
			
			return (Z13*Z23)/(Z12+Z13+Z23);
			
		}
}
