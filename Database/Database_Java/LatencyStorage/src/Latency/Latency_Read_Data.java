package Latency;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import jssc.SerialPort;
import jssc.SerialPortException;

/**
*
* @author Sanjeev
*/

public class Latency_Read_Data implements Runnable {
	static Connection conn;
	public static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static String username = "sanjeev";
	public static String DBpassword = "sanjeev";
	public static SerialPort serialPort = new SerialPort("COM5");
	Thread thread = null;
	public static Latency_Read_Data object = new Latency_Read_Data();

	public static void main(String[] args) {
		
		try {
	           for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	               if ("Nimbus".equals(info.getName())) {
	                   javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                   break;
	               }
	           }
	       } catch (Exception ex) {
	    	   System.out.println(ex);    	   
	       }

		JLabel Label = new JLabel("Serial Communication");
		final JFrame frame = new JFrame("Serial Communication");
		JButton aButton = new JButton("Receive Data");
		aButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				object.start();
				
			}
		});
		JButton bButton = new JButton("End Data");
		bButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				object.stop();
			}
		});
		// JPanel jplContentPane = new JPanel(new BoxLayout());
		JPanel jplContentPane = new JPanel();
		jplContentPane.setLayout(new BoxLayout(jplContentPane,
				BoxLayout.PAGE_AXIS));
		jplContentPane.setBorder(BorderFactory
				.createEmptyBorder(75, 75, 75, 75));
		jplContentPane.add(Label);
		jplContentPane.add(aButton);
		jplContentPane.add(bButton);
		frame.setContentPane(jplContentPane);
		frame.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.pack();
		frame.setVisible(true);
	}

	public void start() {
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}

	public void stop() {
		thread.stop();
		thread = null;
	}

	public void run() {
		while (thread != null) {
			
				ReadData();
				// String received_data ="22/05/2014 16:59:39 0000080460 us";
				// String[] data = received_data.split(" ");
				// String timestamp=data[0]+" "+data[1];
				// write2db(timestamp,data[2],data[3]);
		}
		thread = null;
	}

	// ----------------------------Write Serial Data to
	// Database---------------------------------------------

	public static void write2db(String timestamp, String latency, String unit) {

		Statement stmt = null;
		int result = 0;
		try {
			conn = getConnection1();
			stmt = conn.createStatement();
			String write2db = "insert into sanjeev.latency values (TO_DATE('"
					+ timestamp + "', 'dd/mm/yyyy hh24:mi:ss'),'"
					+ Integer.parseInt(latency) + "','" + unit + "')";
			System.out.println(write2db);
			result = stmt.executeUpdate(write2db);
			System.out.println("write2db Query Processed");
			conn.close();
		} catch (Exception e) {
		}

	}

	// ------------------------Read Data from Serial
	// Port--------------------------

	public static void ReadData() {
System.out.println("iam in");
		while (true) {
			try {
				serialPort.openPort();// Open serial port
				System.out.println("Port Open");
				serialPort.setParams(115200, 8, 1, 0);// Set params.
				System.out.println("Parameters Set");
				byte[] buffer = serialPort.readBytes(34);// Read bytes from
															// serial port
				if (buffer.length == 34) {
					String received_data = new String(buffer);
					System.out.println(received_data);
					String[] data = received_data.split(" ");
					String timestamp = data[0] + " " + data[1];
					write2db(timestamp, data[2], data[3]);
				} else {
					break;
				}
				serialPort.closePort();// Close serial port
				System.out.println("Port Closed");
			} catch (SerialPortException ex) {
				System.out.println(ex);

			}
		}
	}

	// ------------------------Connection Manager
	// Class----------------------------

	public static Connection getConnection1() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("iam entering connection");
			conn = DriverManager.getConnection(URL, username, DBpassword);
			System.out.println("connection established");
		} catch (Exception e) {
			System.out.println(e);
		}
		return conn;
	}

}