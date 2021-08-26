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

	
		//����� ������� �
		pTitel=new JPanel();
		pTitel.setPreferredSize(new Dimension(600,40));
		pTitel.setBackground(Color.white);
		titel=new JLabel("������ BMI");
		titel.setPreferredSize(new Dimension(300,40));
		titel.setHorizontalAlignment(SwingConstants.CENTER);
		titel.setFont(font1);
		pTitel.add(titel);

		//����� ����� � ����� ���
		add(pTitel);
		add (Box.createRigidArea (new Dimension (0, 5)));
		
		//���� ���� ������ ���
		pMainGender = new JPanel();
		pMainGender.setBackground(color1);
	
		
		

		//����  �������� ������ ���
		pGender = new JPanel();
		pGender.setPreferredSize(new Dimension(300,70));
		pGender.setBackground(color1);

		//����� ����
		genderBorder =new TitledBorder(defult,"���",TitledBorder.CENTER,0,font2);
		pGender.setBorder(genderBorder);

		//����� ����� ����� ���
		male = new JRadioButton("���"); 
		male.setPreferredSize(new Dimension (80,30));
		male.setHorizontalAlignment(SwingConstants.CENTER);
		male.setForeground(Color.black);
		male.setBackground(color1);
		male.setFont(font2);

		//����� ����� ����� ����
		female = new JRadioButton("����");
		female.setPreferredSize(new Dimension (80,30));
		female.setHorizontalAlignment(SwingConstants.CENTER);
		female.setBackground(color1);
		female.setForeground(Color.black);
		female.setFont(font2);

		//���� ����� ������ ���
		GenderListener  listener = new GenderListener ();
		male.addActionListener(listener);
		female.addActionListener(listener);

		//����� ��� �������� ������
		ButtonGroup group = new ButtonGroup();
		group.add(male);
		group.add(female);


		//����� ������ ��� /���� ����� ����
		pGender.add(female);
		pGender.add(male);

		//����� ���� ���� �������
		pMainGender.add(pGender);
		add(pMainGender);
		add (Box.createRigidArea (new Dimension (0, 5)));
		
		//���� ����� ����
		pMainWH=new JPanel();
		pMainWH.setBackground(color1);

		//����� ���� ������ ����
		pWeight = new JPanel();
		pWeight.setPreferredSize(new Dimension (200,70));
		pWeight.setBackground(color1);

		//����� �����
		weightBorder =new TitledBorder(defult,"����",TitledBorder.CENTER,0,font2);
		pWeight.setBorder(weightBorder);

		//����� ���� ���� ������ ����
		actualWeightFild = new JTextField(2);
		actualWeightFild.setFont(new Font("Tahoma", Font.PLAIN, 14));
		actualWeightFild.setPreferredSize(new Dimension (100,20));

		//����� ����� ������ ����
		actualWeightFild.addActionListener(new weightListener());

		//����� ���� ����� ���
		pWeight.add(actualWeightFild);
		

		//����� ���� ���� �������
		pMainWH.add(pWeight);

		//���� ������ ���
		pAge = new JPanel();
		pAge.setPreferredSize(new Dimension (200,70));
		pAge.setBackground(color1);

		//����� ����
		ageBorder =new TitledBorder(defult,"���",TitledBorder.CENTER,0,font2);
		pAge.setBorder(ageBorder);

		//����� ���� ���� ������ ���
		ageFild = new JTextField(2);
		ageFild.setPreferredSize(new Dimension (20,20));
		ageFild.setFont(new Font("Tahoma", Font.PLAIN, 14));

		//����� ����� ������ ���
		ageFild.addActionListener(new AgeListener());

		//����� ��� �����  ���
		pAge.add(ageFild);
		
		//����� ���� ��� �������
		pMainWH.add(pAge);
		add(pMainWH);
		add (Box.createRigidArea (new Dimension (0, 5)));
		
		//���� ���� �����
		pMainHeight = new JPanel();
		pMainHeight.setBackground(color1);


		//����� ���� ������ �����
		pHeight = new JPanel();
		pHeight.setPreferredSize(new Dimension (520,130));
		pHeight.setBackground(color1);

		//����� �����
		heighBorder =new TitledBorder(defult,"����",TitledBorder.CENTER,0,font2);
		pHeight.setBorder(heighBorder);


		//����� ������ ������ �����
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

		//����� ����� ������ �����
		Sheight.addChangeListener(new heightListener());

		//����� ����� ����� ����� ���
		pHeight.add(Sheight);


		//����� ���� �����
		pCount=new JPanel();
		pCount.setPreferredSize(new Dimension (250,30));
		pCount.setBackground(color1);
		lCount =new JLabel("");
		lCount.setText(String.valueOf("����� ���:" + String.format("%.0f", count) + " ���"));
		lCount.setFont(font3);
		lCount.setBackground(color1);
		lCount.setHorizontalAlignment(SwingConstants.CENTER);


		//����� ����� ����� ���
		pCount.add(lCount);

		//����� ���� ����� ����� �����
		pHeight.add(pCount);

		//����� ���� ����� �������
		pMainHeight.add(pHeight);
		add(pMainHeight);
		add (Box.createRigidArea (new Dimension (0, 5)));



		//����� ���� ������ �����
		pButton =new JPanel();
		pButton.setBackground(color1);
		pButton.setPreferredSize(new Dimension(100,40));

		//����� ����� ���
		sendButton = new JButton("���");
		sendButton.setPreferredSize(new Dimension(100,40));
		sendButton.setFont(font2);
		sendButton.setBackground(color1);
		sendButton.setForeground(Color.black);

		//����� ����� ������ ���
		sendButton.addActionListener(new sendListener());

		//����� ����� ��� ����� ���
		pButton.add(sendButton);

		//����� ���� ����� ��� �������
		add(pButton);
		add (Box.createRigidArea (new Dimension (0, 5)));
		
		//���� ������ ����
		pMainBmi =new JPanel();
		pMainBmi.setBackground(color1);


		//����� ���� MBI
		pBmi = new JPanel();
		pBmi.setPreferredSize(new Dimension(320,150));
		pBmi.setBackground(color1);

		//����� ����� ���� ������
		bmiBorder =new TitledBorder(defult,"������",TitledBorder.CENTER,0,font2);
		pBmi.setBorder(bmiBorder);


		//����� ���� MBI
		lBmiweight =new JLabel("");
		lBmiweight.setPreferredSize(new Dimension(350,25));
		lBmiweight.setFont(font3);
		lBmiweight.setHorizontalAlignment(SwingConstants.CENTER);

		//����� ��� ����
		lBmiDesc =new JLabel("");
		lBmiDesc.setPreferredSize(new Dimension(350,25));
		lBmiDesc.setFont(font3);
		lBmiDesc.setHorizontalAlignment(SwingConstants.CENTER);


		//����� ����� ���� �����
		lResult1 = new JLabel("");
		lResult1.setPreferredSize(new Dimension(350, 25));
		lResult1.setFont(font3);
		lResult1.setHorizontalAlignment(SwingConstants.CENTER);

		//����� ����� ���� �����
		lResult2 = new JLabel("");
		lResult2.setPreferredSize(new Dimension(350, 25));
		lResult2.setFont(font3);
		lResult2.setHorizontalAlignment(SwingConstants.CENTER);

		//����� �� �������� ����� BMI    
		pBmi.add(lResult1);
		pBmi.add(lResult2);
		pBmi.add(lBmiDesc);
		pBmi.add(lBmiweight);

		//����� ���� BMI �������
		pMainBmi.add(pBmi);
		add(pMainBmi);
		add (Box.createRigidArea (new Dimension (0, 5)));

	}

	//�������� ����� ������ ���
	private class GenderListener implements ActionListener
	{

		public void actionPerformed (ActionEvent event)
		{
			source = event.getSource();
			if(source==male)
			{
				male.setForeground(color2);
				female.setForeground(Color.black);
				genderBorder = new TitledBorder(borderM,"���",TitledBorder.CENTER,0,font2);
				pGender.setBorder(genderBorder);
				ageBorder =new TitledBorder(borderM,"���",TitledBorder.CENTER,0,font2);
				pAge.setBorder(ageBorder);
				weightBorder =new TitledBorder(borderM,"����",TitledBorder.CENTER,0,font2);
				pWeight.setBorder(weightBorder);
				heighBorder =new TitledBorder(borderM,"����",TitledBorder.CENTER,0,font2);
				pHeight.setBorder(heighBorder);
				sendButton.setBackground(color2);
				bmiBorder = new TitledBorder(borderM,"������",TitledBorder.CENTER,0,font2);
				pBmi.setBorder(bmiBorder);
				setBorder(borderM);
				setBackground (color2);
			}
			else if(source==female)
			{
				female.setForeground(color3);
				male.setForeground(Color.black);
				genderBorder = new TitledBorder(borderF,"���",TitledBorder.CENTER,0,font2);
				pGender.setBorder(genderBorder);
				ageBorder =new TitledBorder(borderF,"���",TitledBorder.CENTER,0,font2);
				pAge.setBorder(ageBorder);
				weightBorder =new TitledBorder(borderF,"����",TitledBorder.CENTER,0,font2);
				pWeight.setBorder(weightBorder);
				heighBorder =new TitledBorder(borderF,"����",TitledBorder.CENTER,0,font2);
				pHeight.setBorder(heighBorder);
				sendButton.setBackground(color3);
				bmiBorder = new TitledBorder(borderF,"������",TitledBorder.CENTER,0,font2);
				pBmi.setBorder(bmiBorder);
				setBackground (color3);
				setBorder(borderF);
			}


		}       

	}

	//�������� ����� ������ ����
	private class weightListener implements ActionListener
	{

		public void actionPerformed (ActionEvent event)
		
		{
			realWeight =Integer.parseInt(actualWeightFild.getText());

		}
	}

	// ��������  ����� ������ ����
	private class AgeListener implements ActionListener
	{

		public void actionPerformed (ActionEvent eventage)
		{

		
		}
	}

	//�������� ����� �����
	private class heightListener implements ChangeListener {

		public void stateChanged (ChangeEvent eventheight) {

			count =0;
			heightNumber = Sheight.getValue();
			count=heightNumber;
			count/=100;
			lCount.setText(String.valueOf("����� ���:" +  String.format("%.2f", count) + " ���"));


		}
	}

	// �������� ����� ������ ���
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
				lResult1.setText(String.valueOf("����� ������ ���:" +"kg " + String.format("%.0f", realWeight)));
				lResult2.setForeground(color2);
				lResult2.setText(String.valueOf("����� ������ ���:" + "kg "+ String.format("%.0f",recomWeight)));
				bmiBorder =new TitledBorder(borderM,"������",TitledBorder.CENTER,0,font2);
				pBmi.setBorder(bmiBorder);
				bmi=f.bmi(heightNumber, realWeight);
				lBmiweight.setText(String.valueOf( (String.format("%.2f", bmi)+ ":BMI")));
				lBmiweight.setForeground(color2);
				bmiStatus=f.stasus(bmi);
				lBmiDesc.setText("����� ����� ���:" + bmiStatus);
				lBmiDesc.setForeground(color2);
				
				
			}
			else if (source == female)
			{


				realWeight =Integer.parseInt(actualWeightFild.getText());
				recomWeight = f.funcfemale(heightNumber);
				lResult1.setForeground(color3);
				lResult1.setText(String.valueOf("����� ������ ���:" +"kg " + String.format("%.0f", realWeight)));
				lResult2.setForeground(color3);
				lResult2.setText(String.valueOf("����� ������ ���:" + "kg "+ String.format("%.0f", recomWeight)));
				bmiBorder =new TitledBorder(borderF,"������",TitledBorder.CENTER,0,font2);
				pBmi.setBorder(bmiBorder);
				bmi=f.bmi(heightNumber, realWeight);
				lBmiweight.setText(String.valueOf( (String.format("%.2f", bmi)+ ":BMI")));
				lBmiweight.setForeground(color3);
				bmiStatus=f.stasus(bmi);
				lBmiDesc.setText("����� ����� ���:" + bmiStatus);
				lBmiDesc.setForeground(color3);
			}
			else if(source == null)
			{
				JOptionPane.showMessageDialog (null,"�� ����� ���");
			}
		}
           catch(Exception e) 
			
		
			{
				JOptionPane.showMessageDialog (null,"�� ����� ������ ��� ����� ������ ���");
			}
		
		
		}
	}
}
