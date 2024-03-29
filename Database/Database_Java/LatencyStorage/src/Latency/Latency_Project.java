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

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import jssc.SerialPort;
import jssc.SerialPortException;

/**
 *
 * @author Sanjeev
 */
public class Latency_Project extends javax.swing.JFrame implements Runnable {

    static Connection conn;
    public static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    public static String username = "sanjeev";
    public static String DBpassword = "sanjeev";
    public static SerialPort serialPort = new SerialPort("COM14");
    public static String[][] dbdata;
    public static int noOfRecords;
    Thread thread = null;
    public static Latency_Project object = new Latency_Project();

    /**
     * Creates new form LatencyApplication
     */
    public Latency_Project() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        aButton = new javax.swing.JButton();
        bButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        Start = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        End = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Latency Application");

        aButton.setText("Receive Data");

        bButton.setText("Stop Data");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Serial Communication");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Latency History");

        jLabel3.setText("Search By :");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[]{
            "Date", "Latency"}));

        jLabel4.setText("Start :");

        aButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                object.start();

            }
        });

        bButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                object.stop();
            }
        });

        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean start_string = true;
                boolean end_string = true;
                String datePattern = "\\d{2}-\\d{2}-\\d{4}";
                String latencypattern = "\\d+";
                if (jComboBox1.getSelectedItem().toString().equalsIgnoreCase("Latency")) {
                    if (!Start.getText().isEmpty()) {
                        start_string = Start.getText().matches(latencypattern);
                        if (start_string == false) {
                            JOptionPane.showMessageDialog(null, "Invalid Start Latency");
                        }

                    }
                    if (!End.getText().isEmpty()) {
                        end_string = End.getText().matches(latencypattern);
                        if (end_string == false) {
                            JOptionPane.showMessageDialog(null, "Invalid End Latency");
                        }
                    }
                }

                if (jComboBox1.getSelectedItem().toString().equalsIgnoreCase("Date")) {
                    if (!Start.getText().isEmpty()) {
                        start_string = Start.getText().matches(datePattern);
                        if (start_string == true) {
                            String date[] = Start.getText().split("-");
                            if (Integer.parseInt(date[0]) > 31 || Integer.parseInt(date[1]) > 12 || Integer.parseInt(date[2]) < 1990) {
                                start_string = false;
                                JOptionPane.showMessageDialog(null, "Invalid Start Date");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Please enter Start Date in DD-MM-YYYY Format");
                        }

                    }
                    if (!End.getText().isEmpty()) {
                        end_string = End.getText().matches(datePattern);
                        if (end_string == true) {
                            String date[] = End.getText().split("-");
                            if (Integer.parseInt(date[0]) > 31 || Integer.parseInt(date[1]) > 12 || Integer.parseInt(date[2]) < 1990) {
                                end_string = false;
                                JOptionPane.showMessageDialog(null, "Invalid End Date");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Please enter End Date in DD-MM-YYYY Format");
                        }
                    }
                }
                if (start_string == true && end_string == true) {
                    dbdata(jComboBox1.getSelectedItem().toString(),
                            Start.getText(), End.getText());
                    Object headers[] = {"TIMESTAMP", "LATENCY", "UNIT"};
                    JTable table = new JTable(dbdata, headers);
                    JScrollPane scrollPane = new JScrollPane(table);
                    final JFrame SchedulerStatusframe = new JFrame("HISTORY");
                    SchedulerStatusframe.add(scrollPane, BorderLayout.CENTER);
                    SchedulerStatusframe.setSize(800, 150);
                    SchedulerStatusframe.setVisible(true);
                    SchedulerStatusframe.addWindowListener(new WindowAdapter() {
                        public void windowClosing(WindowEvent e) {
                            SchedulerStatusframe.dispose();
                        }
                    });
                }
            }
        });

        jLabel5.setText("End :");

        jButton1.setText("Search");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
                getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(
                layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(aButton,
                javax.swing.GroupLayout.PREFERRED_SIZE,
                119,
                javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(
                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                Short.MAX_VALUE)
                .addComponent(bButton,
                javax.swing.GroupLayout.PREFERRED_SIZE,
                119,
                javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
                .addComponent(jSeparator1)
                .addGroup(
                layout.createSequentialGroup()
                .addGroup(
                layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(
                layout.createSequentialGroup()
                .addGap(134,
                134,
                134)
                .addComponent(
                jLabel1))
                .addGroup(
                layout.createSequentialGroup()
                .addGap(18, 18,
                18)
                .addComponent(
                jLabel4,
                javax.swing.GroupLayout.PREFERRED_SIZE,
                52,
                javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(
                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(
                Start,
                javax.swing.GroupLayout.PREFERRED_SIZE,
                87,
                javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51,
                51)
                .addComponent(
                jLabel5,
                javax.swing.GroupLayout.PREFERRED_SIZE,
                51,
                javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(
                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(
                End,
                javax.swing.GroupLayout.PREFERRED_SIZE,
                87,
                javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                layout.createSequentialGroup()
                .addComponent(
                jButton1,
                javax.swing.GroupLayout.PREFERRED_SIZE,
                119,
                javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91,
                91))
                .addGroup(
                layout.createSequentialGroup()
                .addGap(107,
                107,
                107)
                .addComponent(
                jLabel3,
                javax.swing.GroupLayout.PREFERRED_SIZE,
                89,
                javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37,
                37)
                .addComponent(
                jComboBox1,
                javax.swing.GroupLayout.PREFERRED_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
                .addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                layout.createSequentialGroup()
                .addContainerGap(
                javax.swing.GroupLayout.DEFAULT_SIZE,
                Short.MAX_VALUE).addComponent(jLabel2)
                .addGap(147, 147, 147)));
        layout.setVerticalGroup(layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(
                layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1,
                javax.swing.GroupLayout.PREFERRED_SIZE,
                34,
                javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(
                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(
                layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(
                aButton,
                javax.swing.GroupLayout.PREFERRED_SIZE,
                43,
                javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(
                bButton,
                javax.swing.GroupLayout.PREFERRED_SIZE,
                43,
                javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1,
                javax.swing.GroupLayout.PREFERRED_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(
                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2,
                javax.swing.GroupLayout.PREFERRED_SIZE,
                27,
                javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(
                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(
                layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING,
                false)
                .addComponent(
                jLabel3,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                Short.MAX_VALUE)
                .addComponent(
                jComboBox1,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                33, Short.MAX_VALUE))
                .addPreferredGap(
                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(
                layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(
                jLabel4,
                javax.swing.GroupLayout.PREFERRED_SIZE,
                29,
                javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(
                Start,
                javax.swing.GroupLayout.PREFERRED_SIZE,
                29,
                javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(
                jLabel5,
                javax.swing.GroupLayout.PREFERRED_SIZE,
                29,
                javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(
                End,
                javax.swing.GroupLayout.PREFERRED_SIZE,
                29,
                javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(
                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                15, Short.MAX_VALUE)
                .addComponent(jButton1,
                javax.swing.GroupLayout.PREFERRED_SIZE,
                43,
                javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap()));

        pack();
    }// </editor-fold>

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
//             String received_data ="22/06/2014 16:59:39 0000080460 us";
//             String[] data = received_data.split(" ");
//             String timestamp=data[0]+" "+data[1];
//             write2db(timestamp,data[2],data[3]);
        }
        thread = null;
    }

    // ----------------------------Write Serial Data to
    // Database---------------------------------------------
    public static void write2db(String timestamp, String latency, String unit) {

        Statement stmt = null;
        int result = 0;
        try {
            conn = getConnection();
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
//        while (true) {
            try {
                serialPort.openPort();// Open serial port
                System.out.println("Port Open");
                serialPort.setParams(115200, 8, 1, 0);// Set params.
                System.out.println("Parameters Set");
                while (true) {
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
                }
                serialPort.closePort();// Close serial port
                System.out.println("Port Closed");
            }
             catch (SerialPortException ex) {
                System.out.println(ex);

            }
        
    }

    // ----------------------------Read data by Start Date from
    // Database---------------------------------------------
    public static ResultSet dbdata(String Search_Criteria, String Start,
            String End) {

        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            stmt = conn.createStatement();
            String Query = null;
            if (Search_Criteria.contains("Date")) {
                if (End.isEmpty() && Start.isEmpty()) {
                    Query = "select TO_CHAR(TIME, 'dd/mm/yyyy hh24:mi:ss'),LATENCY,UNIT from sanjeev.latency order by TIME desc";
                } else if (End.isEmpty()) {
                    Query = "select TO_CHAR(TIME, 'dd/mm/yyyy hh24:mi:ss'),LATENCY,UNIT from sanjeev.latency where (TIME > '"
                            + Start + "' or TIME like '%" + Start + "%') order by TIME asc";
                } else if (Start.isEmpty()) {
                    Query = "select TO_CHAR(TIME, 'dd/mm/yyyy hh24:mi:ss'),LATENCY,UNIT from sanjeev.latency where (TIME < '"
                            + End + "' or TIME like '%" + End + "%') order by TIME asc";
                } else {
                    Query = "select TO_CHAR(TIME, 'dd/mm/yyyy hh24:mi:ss'),LATENCY,UNIT from sanjeev.latency where (TIME > '"
                            + Start
                            + "' or TIME like '%"
                            + Start
                            + "%') and (TIME < '"
                            + End
                            + "' or TIME like '%"
                            + End + "%') order by TIME asc";
                }
            } else if (Search_Criteria.contains("Latency")) {
                if (End.isEmpty() && Start.isEmpty()) {
                    Query = "select TO_CHAR(TIME, 'dd/mm/yyyy hh24:mi:ss'),LATENCY,UNIT from sanjeev.latency order by LATENCY asc";
                } else if (End.isEmpty()) {
                    Query = "select TO_CHAR(TIME, 'dd/mm/yyyy hh24:mi:ss'),LATENCY,UNIT from sanjeev.latency where LATENCY >= '"
                            + Start + "' order by LATENCY asc";
                } else if (Start.isEmpty()) {
                    Query = "select TO_CHAR(TIME, 'dd/mm/yyyy hh24:mi:ss'),LATENCY,UNIT from sanjeev.latency where LATENCY <= '"
                            + End + "' order by LATENCY asc";
                } else {
                    Query = "select TO_CHAR(TIME, 'dd/mm/yyyy hh24:mi:ss'),LATENCY,UNIT from sanjeev.latency where LATENCY >= '"
                            + Start + "' and LATENCY <= '" + End + "' order by LATENCY asc";
                }
            }

            System.out.println(Query);
            rs = stmt.executeQuery(Query);
            int i;
            dbdata = new String[100000][3];
            for (i = 0; rs.next() == true; i++) {
                dbdata[i][0] = rs.getString(1);
                dbdata[i][1] = rs.getString(2);
                dbdata[i][2] = rs.getString(3);
            }
            noOfRecords = i;
            System.out.println(i);
            conn.close();
        } catch (Exception e) {
        }

        return rs;
    }

    // ------------------------Connection Manager
    // Class----------------------------
    public static Connection getConnection() {
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

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed"
        // desc=" Look and feel setting code (optional) ">
		/*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase
         * /tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                    .getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(
            		Latency_Project.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Latency_Project().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify
    private javax.swing.JTextField End;
    private javax.swing.JTextField Start;
    private javax.swing.JButton aButton;
    private javax.swing.JButton bButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration
}