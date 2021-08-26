
import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
		
	JFrame frame = new JFrame("מחשבון BMI");
	frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	
	JPanel p = new JPanel();
	p.add(new ControlPanel());
	frame.add(p);
	

   frame.pack();
   frame.setVisible(true);

	}

}
