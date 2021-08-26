
public class Functions {
	
	//פונקציה לחישוב  המשקל הרצוי לגבר
	public double funcmale(double m)
	
	{
		return 48 + 1.1 * (m - 152);
		
	}
	
	//פונקציה לחישוב  המשקל הרצוי לאשה
	public double funcfemale(double f)
	
	{
		return 45.4 + 0.9 * (f - 152);
		
	}
	
	
	//פונקציה לחישוב ה BMI
	public double bmi(double h, double w )
	{
		h/=100;
		h=(h*h);
		return w/h;
	}
	
	//פונקציה המחשבת את הסטטוס
	public String stasus(double bmi)
	
	{
		String result = null;
		
		if (bmi<15)
			result="אנורקסי";
		else if(bmi >=15 & bmi <18.5)
			result="תת משקל";
		else if(bmi >=18.5 & bmi <24.9 )
			result="נורמלי";
		else if(bmi >=25.0 & bmi <29.9)
			result="משקל עודף";
		else if(bmi >=30.0 & bmi<35)
			result="שמן";
		else if(bmi>35)
			result="שמן מאוד";
		return result;
	}
		
	

}
