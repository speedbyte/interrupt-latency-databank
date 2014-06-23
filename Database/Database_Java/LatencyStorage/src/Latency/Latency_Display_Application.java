package Latency;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
*
* @author Sanjeev
*/


 public class Latency_Display_Application {
 public static Connection conn;
 public static String URL= "jdbc:oracle:thin:@localhost:1521:xe";
 public static String username="sanjeev";
 public static String DBpassword="sanjeev";
 public static String[][] dbdata ;
 public static int noOfRecords;
 public static JTextField Start_date = new JTextField(8);
 public static JTextField End_date = new JTextField(8);
 
 public static void main(String[] args) {

  final JFrame frame = new JFrame("Latency Application");
  JButton  aButton= new JButton("Get data");
  JLabel start_date=new JLabel("Start Date");
  JLabel end_date=new JLabel("End Date");
  aButton.addActionListener(new ActionListener() {

   public void actionPerformed(ActionEvent e) {
	   dbdata(Start_date.getText(),End_date.getText());
	   Object headers[] = { "TIMESTAMP", "LATENCY","UNIT" }; 
		JTable table = new JTable(dbdata, headers);
		JScrollPane scrollPane = new JScrollPane(table);
		final JFrame SchedulerStatusframe = new JFrame("LATENCY HISTORY");
		SchedulerStatusframe.add(scrollPane, BorderLayout.CENTER);
		SchedulerStatusframe.setSize(800,150);
		SchedulerStatusframe.setVisible(true);
		SchedulerStatusframe.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				SchedulerStatusframe.dispose();
			}
		});
   }
   });
  
 // JPanel jplContentPane = new JPanel(new BoxLayout());
  JPanel jplContentPane = new JPanel();
  jplContentPane.setLayout(new BoxLayout(jplContentPane, BoxLayout.PAGE_AXIS));
  jplContentPane.setBorder(BorderFactory.createEmptyBorder(75,75,75,75));
  jplContentPane.add(start_date);
  jplContentPane.add(Start_date);
  jplContentPane.add(end_date);
  jplContentPane.add(End_date);
  jplContentPane.add(aButton);
  frame.setContentPane(jplContentPane);
  frame.addWindowListener(new WindowAdapter() {

   public void windowClosing(WindowEvent e) {
    System.exit(0);
   }
  });
  frame.pack();
  frame.setVisible(true);
 }
 
//----------------------------Read data by Start Date from Database---------------------------------------------
 
public static  ResultSet dbdata(String Start_date,String End_date ) {
  
  Statement stmt = null;
  ResultSet rs = null;
  try{
   conn = getConnection1();
   stmt=conn.createStatement();
   String Query=null;
   if(End_date.isEmpty())
   {
	   Query = "select TO_CHAR(TIME, 'dd/mm/yyyy hh24:mi:ss'),LATENCY,UNIT from sanjeev.latency where (TIME > '"+Start_date+"' or TIME like '%"+Start_date+"%')";
   }else
   if(Start_date.isEmpty())
   {
	   Query = "select TO_CHAR(TIME, 'dd/mm/yyyy hh24:mi:ss'),LATENCY,UNIT from sanjeev.latency where (TIME < '"+End_date+"' or TIME like '%"+End_date+"%')";
   }else
   {
	   Query = "select TO_CHAR(TIME, 'dd/mm/yyyy hh24:mi:ss'),LATENCY,UNIT from sanjeev.latency where (TIME > '"+Start_date+"' or TIME like '%"+Start_date+"%') and (TIME < '"+End_date+"' or TIME like '%"+End_date+"%')";
   }
   
   System.out.println(Query);
   rs = stmt.executeQuery(Query);    
   int i;
   dbdata = new String[10000][3];
   for(i=0;rs.next()==true;i++)
	{
	   dbdata[i][0]=rs.getString(1);
	   dbdata[i][1]=rs.getString(2);
	   dbdata[i][2]=rs.getString(3);
	}
   noOfRecords=i;
   System.out.println(i);
   conn.close();
  }catch(Exception e){ }

return rs;
 }

//------------------------Connection Manager Class----------------------------

    public static  Connection getConnection1()
    {
     Connection conn=null;
       try
       {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        System.out.println("iam entering connection");
        conn = DriverManager.getConnection(URL,username,DBpassword);
    System.out.println("connection established");
   } catch (Exception e) {
    System.out.println(e);
   }
   return conn;
 }
 

}