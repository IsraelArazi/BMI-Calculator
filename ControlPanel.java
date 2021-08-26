import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;




public class ControlPanel  extends JPanel
{

	private JPanel pGender,pMainGender,pTitel,pMainWH,pAge,pMainHeight, pHeight,pWeight, pButton,pBmi,pMainBmi,pCount;
	private JLabel titel,lResult1,lResult2, lBmiweight,lBmiDesc ,lCount ;
	private JRadioButton male , female;
	private JButton sendButton;
	private JTextField ageFild,actualWeightFild;
	private JSlider Sheight;
	private double recomWeight, heightNumber, realWeight, bmi, count;
	private Font font1= new Font("Secular one", Font.BOLD,30), font2= new Font("Secular one", Font.BOLD,20),font3= new Font("Secular one", Font.PLAIN ,20);
	private Color color1=new Color(255,255,255),color2=new Color(102,178,255),color3=new Color(255,0,255),color4=new Color(160,160,160);
	private Object source;
	private TitledBorder weightBorder, genderBorder, ageBorder ,heighBorder, bmiBorder;
	private Border borderM ,borderF, defult;
	private String bmiStatus;
	private Functions f;
	public ControlPanel()
	{


		setLayout (new BoxLayout (this, BoxLayout.Y_AXIS));

		setPreferredSize(new Dimension (600,650));

		
		borderM =BorderFactory.createLineBorder(color2);
		borderF =BorderFactory.createLineBorder(color3);
		defult =BorderFactory.createLineBorder(color4);
	

		setBackground (color4);

	
		//כותרת התוכנית א
		pTitel=new JPanel();
		pTitel.setPreferredSize(new Dimension(600,40));
		pTitel.setBackground(Color.white);
		titel=new JLabel("מחשבון BMI");
		titel.setPreferredSize(new Dimension(300,40));
		titel.setHorizontalAlignment(SwingConstants.CENTER);
		titel.setFont(font1);
		pTitel.add(titel);

		//הוספת כותרת א לפאנל שלה
		add(pTitel);
		add (Box.createRigidArea (new Dimension (0, 5)));
		
		//פאנל ראשי לבחירת מין
		pMainGender = new JPanel();
		pMainGender.setBackground(color1);
	
		
		

		//פאנל  כפתורהים לבחירת מין
		pGender = new JPanel();
		pGender.setPreferredSize(new Dimension(300,70));
		pGender.setBackground(color1);

		//מסגרת למין
		genderBorder =new TitledBorder(defult,"מין",TitledBorder.CENTER,0,font2);
		pGender.setBorder(genderBorder);

		//הגדרת כפתור בחירה זכר
		male = new JRadioButton("זכר"); 
		male.setPreferredSize(new Dimension (80,30));
		male.setHorizontalAlignment(SwingConstants.CENTER);
		male.setForeground(Color.black);
		male.setBackground(color1);
		male.setFont(font2);

		//הגדרת כפתור בחירה נקבה
		female = new JRadioButton("נקבה");
		female.setPreferredSize(new Dimension (80,30));
		female.setHorizontalAlignment(SwingConstants.CENTER);
		female.setBackground(color1);
		female.setForeground(Color.black);
		female.setFont(font2);

		//הגרת מאזין לבחירת מין
		GenderListener  listener = new GenderListener ();
		male.addActionListener(listener);
		female.addActionListener(listener);

		//חיבור שני הכפתורים לקבוצה
		ButtonGroup group = new ButtonGroup();
		group.add(male);
		group.add(female);


		//הוספת כפתורי זכר /נקבה לפאנל שלהם
		pGender.add(female);
		pGender.add(male);

		//הוספת פאנל מגדר לליאאוט
		pMainGender.add(pGender);
		add(pMainGender);
		add (Box.createRigidArea (new Dimension (0, 5)));
		
		//פאנל למשקל וגיל
		pMainWH=new JPanel();
		pMainWH.setBackground(color1);

		//הגדרת פאנל לבחירת משקל
		pWeight = new JPanel();
		pWeight.setPreferredSize(new Dimension (200,70));
		pWeight.setBackground(color1);

		//מסגרת למשקל
		weightBorder =new TitledBorder(defult,"משקל",TitledBorder.CENTER,0,font2);
		pWeight.setBorder(weightBorder);

		//הגדרת תיבת טקסט לבחירת משקל
		actualWeightFild = new JTextField(2);
		actualWeightFild.setFont(new Font("Tahoma", Font.PLAIN, 14));
		actualWeightFild.setPreferredSize(new Dimension (100,20));

		//הגדרת מאזין לבחירת משקל
		actualWeightFild.addActionListener(new weightListener());

		//הוספת משקל לפאנל שלו
		pWeight.add(actualWeightFild);
		

		//הוספת פאנל משקל לליאאוט
		pMainWH.add(pWeight);

		//פאנל לבחירת גיל
		pAge = new JPanel();
		pAge.setPreferredSize(new Dimension (200,70));
		pAge.setBackground(color1);

		//מסגרת לגיל
		ageBorder =new TitledBorder(defult,"גיל",TitledBorder.CENTER,0,font2);
		pAge.setBorder(ageBorder);

		//הגדרת תיבת טקסט לבחירת גיל
		ageFild = new JTextField(2);
		ageFild.setPreferredSize(new Dimension (20,20));
		ageFild.setFont(new Font("Tahoma", Font.PLAIN, 14));

		//הגדרת מאזין לבחירת גיל
		ageFild.addActionListener(new AgeListener());

		//הוספת גיל לפאנל  שלו
		pAge.add(ageFild);
		
		//הוספת פאנל גיל לליאאוט
		pMainWH.add(pAge);
		add(pMainWH);
		add (Box.createRigidArea (new Dimension (0, 5)));
		
		//פאנל ראשי לגובה
		pMainHeight = new JPanel();
		pMainHeight.setBackground(color1);


		//הגדרת פאנל לבחירת הגובה
		pHeight = new JPanel();
		pHeight.setPreferredSize(new Dimension (520,130));
		pHeight.setBackground(color1);

		//מסגרת לגובה
		heighBorder =new TitledBorder(defult,"גובה",TitledBorder.CENTER,0,font2);
		pHeight.setBorder(heighBorder);


		//הגדרת סליידר לבחירת הגובה
		Sheight = new JSlider (JSlider.HORIZONTAL, 0, 220, 2);
		Sheight.setForeground(Color.black);
		Sheight.setBackground(Color.black);
		Sheight.setMajorTickSpacing (20);
		Sheight.setMinorTickSpacing (10);
		Sheight.setPaintTicks (true);
		Sheight.setPaintLabels (true);
		Sheight.setAlignmentX (Component.LEFT_ALIGNMENT);
		Sheight.setPreferredSize(new Dimension (500,50));
		Sheight.setFont(new Font("Ariel",Font.BOLD ,10));
		Sheight.setBackground(color1);

		//הגדרת מאזין לבחירת הגובה
		Sheight.addChangeListener(new heightListener());

		//הוספת בחירת הגובה לפאנל שלו
		pHeight.add(Sheight);


		//הגדרת מונה לגובה
		pCount=new JPanel();
		pCount.setPreferredSize(new Dimension (250,30));
		pCount.setBackground(color1);
		lCount =new JLabel("");
		lCount.setText(String.valueOf("הגובה שלך:" + String.format("%.0f", count) + " מטר"));
		lCount.setFont(font3);
		lCount.setBackground(color1);
		lCount.setHorizontalAlignment(SwingConstants.CENTER);


		//הוספת המונה לפאנל שלו
		pCount.add(lCount);

		//הוספת פאנל המונה לפאנל הגובה
		pHeight.add(pCount);

		//הוספת פאזל הגובה לליאאוט
		pMainHeight.add(pHeight);
		add(pMainHeight);
		add (Box.createRigidArea (new Dimension (0, 5)));



		//הגדרת פאנל לכפתור שליחה
		pButton =new JPanel();
		pButton.setBackground(color1);
		pButton.setPreferredSize(new Dimension(100,40));

		//הגדרת כפתור שלח
		sendButton = new JButton("חשב");
		sendButton.setPreferredSize(new Dimension(100,40));
		sendButton.setFont(font2);
		sendButton.setBackground(color1);
		sendButton.setForeground(Color.black);

		//הגדרת מאזין לכפתור שלח
		sendButton.addActionListener(new sendListener());

		//הוספת כפתור שלח לפאמל שלו
		pButton.add(sendButton);

		//הוספת פאנל כפתור שלח לליאאוט
		add(pButton);
		add (Box.createRigidArea (new Dimension (0, 5)));
		
		//פאנל תוצאות ראשי
		pMainBmi =new JPanel();
		pMainBmi.setBackground(color1);


		//הגדרת פאנל MBI
		pBmi = new JPanel();
		pBmi.setPreferredSize(new Dimension(320,150));
		pBmi.setBackground(color1);

		//הגדרת מסגרת פאנל תוצאות
		bmiBorder =new TitledBorder(defult,"תוצאות",TitledBorder.CENTER,0,font2);
		pBmi.setBorder(bmiBorder);


		//תוצאת משקל MBI
		lBmiweight =new JLabel("");
		lBmiweight.setPreferredSize(new Dimension(350,25));
		lBmiweight.setFont(font3);
		lBmiweight.setHorizontalAlignment(SwingConstants.CENTER);

		//תיאור מצב משקל
		lBmiDesc =new JLabel("");
		lBmiDesc.setPreferredSize(new Dimension(350,25));
		lBmiDesc.setFont(font3);
		lBmiDesc.setHorizontalAlignment(SwingConstants.CENTER);


		//הגדרת לייבל משקל אמיתי
		lResult1 = new JLabel("");
		lResult1.setPreferredSize(new Dimension(350, 25));
		lResult1.setFont(font3);
		lResult1.setHorizontalAlignment(SwingConstants.CENTER);

		//הגדרת לייבל משקל מומלץ
		lResult2 = new JLabel("");
		lResult2.setPreferredSize(new Dimension(350, 25));
		lResult2.setFont(font3);
		lResult2.setHorizontalAlignment(SwingConstants.CENTER);

		//הוספת כל האלמנטים לפאנל BMI    
		pBmi.add(lResult1);
		pBmi.add(lResult2);
		pBmi.add(lBmiDesc);
		pBmi.add(lBmiweight);

		//הוספת פאנל BMI לליאאוט
		pMainBmi.add(pBmi);
		add(pMainBmi);
		add (Box.createRigidArea (new Dimension (0, 5)));

	}

	//פונקציית מאזין לבחירת מין
	private class GenderListener implements ActionListener
	{

		public void actionPerformed (ActionEvent event)
		{
			source = event.getSource();
			if(source==male)
			{
				male.setForeground(color2);
				female.setForeground(Color.black);
				genderBorder = new TitledBorder(borderM,"מין",TitledBorder.CENTER,0,font2);
				pGender.setBorder(genderBorder);
				ageBorder =new TitledBorder(borderM,"גיל",TitledBorder.CENTER,0,font2);
				pAge.setBorder(ageBorder);
				weightBorder =new TitledBorder(borderM,"משקל",TitledBorder.CENTER,0,font2);
				pWeight.setBorder(weightBorder);
				heighBorder =new TitledBorder(borderM,"גובה",TitledBorder.CENTER,0,font2);
				pHeight.setBorder(heighBorder);
				sendButton.setBackground(color2);
				bmiBorder = new TitledBorder(borderM,"תוצאות",TitledBorder.CENTER,0,font2);
				pBmi.setBorder(bmiBorder);
				setBorder(borderM);
				setBackground (color2);
			}
			else if(source==female)
			{
				female.setForeground(color3);
				male.setForeground(Color.black);
				genderBorder = new TitledBorder(borderF,"מין",TitledBorder.CENTER,0,font2);
				pGender.setBorder(genderBorder);
				ageBorder =new TitledBorder(borderF,"גיל",TitledBorder.CENTER,0,font2);
				pAge.setBorder(ageBorder);
				weightBorder =new TitledBorder(borderF,"משקל",TitledBorder.CENTER,0,font2);
				pWeight.setBorder(weightBorder);
				heighBorder =new TitledBorder(borderF,"גובה",TitledBorder.CENTER,0,font2);
				pHeight.setBorder(heighBorder);
				sendButton.setBackground(color3);
				bmiBorder = new TitledBorder(borderF,"תוצאות",TitledBorder.CENTER,0,font2);
				pBmi.setBorder(bmiBorder);
				setBackground (color3);
				setBorder(borderF);
			}


		}       

	}

	//פונקציית מאזין לבחירת משקל
	private class weightListener implements ActionListener
	{

		public void actionPerformed (ActionEvent event)
		
		{
			realWeight =Integer.parseInt(actualWeightFild.getText());

		}
	}

	// פונקציית  מאזין לבחירת הגיל
	private class AgeListener implements ActionListener
	{

		public void actionPerformed (ActionEvent eventage)
		{

		
		}
	}

	//פונקציית מאזין לגובה
	private class heightListener implements ChangeListener {

		public void stateChanged (ChangeEvent eventheight) {

			count =0;
			heightNumber = Sheight.getValue();
			count=heightNumber;
			count/=100;
			lCount.setText(String.valueOf("הגובה שלך:" +  String.format("%.2f", count) + " מטר"));


		}
	}

	// פונקציית מאזין לכפתור שלח
	private class sendListener implements ActionListener
	{

		public void actionPerformed (ActionEvent eventsent)
		{
			try {
			 f=new Functions();

			if (source == male)
			{

				realWeight =Integer.parseInt(actualWeightFild.getText());
				recomWeight = f.funcmale(heightNumber);
				lResult1.setForeground(color2);
				lResult1.setText(String.valueOf("משקלך האמיתי הוא:" +"kg " + String.format("%.0f", realWeight)));
				lResult2.setForeground(color2);
				lResult2.setText(String.valueOf("המשקל המומלץ הוא:" + "kg "+ String.format("%.0f",recomWeight)));
				bmiBorder =new TitledBorder(borderM,"תוצאות",TitledBorder.CENTER,0,font2);
				pBmi.setBorder(bmiBorder);
				bmi=f.bmi(heightNumber, realWeight);
				lBmiweight.setText(String.valueOf( (String.format("%.2f", bmi)+ ":BMI")));
				lBmiweight.setForeground(color2);
				bmiStatus=f.stasus(bmi);
				lBmiDesc.setText("סטטוס המשקל שלך:" + bmiStatus);
				lBmiDesc.setForeground(color2);
				
				
			}
			else if (source == female)
			{


				realWeight =Integer.parseInt(actualWeightFild.getText());
				recomWeight = f.funcfemale(heightNumber);
				lResult1.setForeground(color3);
				lResult1.setText(String.valueOf("משקלך האמיתי הוא:" +"kg " + String.format("%.0f", realWeight)));
				lResult2.setForeground(color3);
				lResult2.setText(String.valueOf("המשקל המומלץ הוא:" + "kg "+ String.format("%.0f", recomWeight)));
				bmiBorder =new TitledBorder(borderF,"תוצאות",TitledBorder.CENTER,0,font2);
				pBmi.setBorder(bmiBorder);
				bmi=f.bmi(heightNumber, realWeight);
				lBmiweight.setText(String.valueOf( (String.format("%.2f", bmi)+ ":BMI")));
				lBmiweight.setForeground(color3);
				bmiStatus=f.stasus(bmi);
				lBmiDesc.setText("סטטוס המשקל שלך:" + bmiStatus);
				lBmiDesc.setForeground(color3);
			}
			else if(source == null)
			{
				JOptionPane.showMessageDialog (null,"נא לבחור מין");
			}
		}
           catch(Exception e) 
			
		
			{
				JOptionPane.showMessageDialog (null,"נא להזין נתונים בכל השדות ולנסות שוב");
			}
		
		
		}
	}
}
