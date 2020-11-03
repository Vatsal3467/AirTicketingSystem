
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.*;


public class Home_page extends javax.swing.JFrame 
{
    String arrival_name, departure_name, traveldate;
    public int f_id;
    public String f_arrival;
    public String f_departure;
    public String datetime;
    public String str_fid;
    public String username;
    public String password;
    public String usr_name;
    public String f_username;
    public int flightprice;
    public String Flight_price;
      
    public boolean validate = false;
    public boolean isMatch = true;
    public String open;
    public String psw_match;
    public Home_page() 
    {
        initComponents();
        Get_Arrival();
        Get_Departure();
        setResizable(false);
        
        
    }
 public Home_page(String A1,String B1,String C1,String D1) 
    {
         
        
        initComponents();
        Get_Arrival();
        Get_Departure();
       
        this.open=A1;
        this.username=B1;
        this.password=C1;
        this.usr_name=D1;
        
        if (usr_name == null){
         User_name1.setText("Hello, Guest!!");
         jButton2.setText("SIGN IN");
    }
    else{
    User_name1.setText("Hi, " + usr_name);
    jButton3.setEnabled(true);
    jButton2.setText("MY PROFILE");
    }
        
        
        
    }
 
 
    public static void main(String args[]) 
    {

        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new Home_page().setVisible(true);
                
            }
        });
    }
    
    void Get_Arrival() 
    {
        Connection conn;
        ResultSet rs;
        
        jComboBox1.addItem("Select an arrival city");
        
        try {
         
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://flightbookingsystem.database.windows.net:1433;database=flight_booking_system;user=Aritra@flightbookingsystem;password=Flightbooking_1234;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30");
            java.sql.Statement stat = conn.createStatement();
            String SelectQuery = "SELECT a_name FROM dbo.Airport_Detail_List";
            rs = stat.executeQuery(SelectQuery);
            while (rs.next()) {
                String airport = rs.getString("a_name");       
                jComboBox1.addItem(airport);                                 
            }
      
        } catch (Exception e) 
        {

        }

    }  

    
    void Get_Departure() 
    {
        Connection conn;
        ResultSet rs;
        
        jComboBox2.addItem("Select an departure city");
        
        try 
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://flightbookingsystem.database.windows.net:1433;database=flight_booking_system;user=Aritra@flightbookingsystem;password=Flightbooking_1234;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30");
            java.sql.Statement stat = conn.createStatement();
            String SelectQuery = "SELECT a_name FROM dbo.Airport_Detail_List";
            rs = stat.executeQuery(SelectQuery);
            while (rs.next()) 
            {
                String airport = rs.getString("a_name");
                jComboBox2.addItem(airport);                        
            }
        
        } catch (Exception e) 
        {

        }
    }

    void Get_Date()
    {
        java.sql.Date sqldate = new java.sql.Date(jDateChooser1.getDate().getTime());
        traveldate = sqldate.toString();
    }
     
    @SuppressWarnings("empty-statement")
            
    
        
            
            
    
    
    void Search_Flights() 
    {  
        Get_Date();
        try 
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://flightbookingsystem.database.windows.net:1433;database=flight_booking_system;user=Aritra@flightbookingsystem;password=Flightbooking_1234;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30");
            Statement uml = conn.createStatement();
            String sql = "SELECT f_id, f_arrival, f_departure, f_datetime FROM Flight_Detail a where a.f_arrival = '" + arrival_name + "' and a.f_departure = '" + departure_name + "' and a.f_datetime = '" + traveldate + "'";
    
            ResultSet rs = uml.executeQuery(sql);
            while(rs.next())
            {
                f_id = rs.getInt("f_id");
                f_arrival = rs.getString("f_arrival");
                f_departure = rs.getString("f_departure");
                datetime = rs.getString("f_datetime");
                str_fid=Integer.toString(f_id);
            }
            conn.close();
            
            if(f_departure.equals(f_arrival) && datetime.equalsIgnoreCase(traveldate))
            {
                isMatch = false;
            } 
            else
            {
                isMatch = true;
            }                 
            
            validate = true;
            
        } catch (Exception e) 
        {

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label2 = new java.awt.Label();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        User_name1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        label2.setText("label2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jComboBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 350, 212, 48));

        jComboBox2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 229, 48));
        getContentPane().add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 360, 198, 47));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("SEARCH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 360, -1, 43));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Departure");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 229, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Arrival");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 310, 212, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Date of travel");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 310, 198, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("SIGN IN");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, 131, 44));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("SIGN OUT");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 10, -1, 44));

        User_name1.setFont(new java.awt.Font("Tamil MN", 1, 29)); // NOI18N
        User_name1.setForeground(new java.awt.Color(255, 255, 255));
        User_name1.setText("Hello, Guest!!!");
        getContentPane().add(User_name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 435, -1));

        jLabel5.setFont(new java.awt.Font("DIN Condensed", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 102, 255));
        jLabel5.setText("Flight Booking Service");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 350, 60));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background.jpeg"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1070, 750));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/white.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 110));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
       
        arrival_name = jComboBox1.getSelectedItem().toString();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        departure_name = jComboBox2.getSelectedItem().toString();
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jButton1.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {   
                Search_Flights();
                
                        
                if((validate == true) && (isMatch = true))
                {
                    try{Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://flightbookingsystem.database.windows.net:1433;database=flight_booking_system;user=Aritra@flightbookingsystem;password=Flightbooking_1234;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30");
            Statement uml = conn.createStatement();
            String sql = "SELECT f_id, f_arrival, f_departure, f_datetime,Price FROM Flight_Detail a where a.f_arrival = '" + arrival_name + "' and a.f_departure = '" + departure_name + "' and a.f_datetime = '" + traveldate + "'";
    
            ResultSet rs = uml.executeQuery(sql);
            if(rs.next())
            {
                f_id = rs.getInt("f_id");
                flightprice=rs.getInt("Price");
                f_arrival = rs.getString("f_arrival");
                f_departure = rs.getString("f_departure");
                datetime = rs.getString("f_datetime");
                str_fid=Integer.toString(f_id);
                Flight_price=Integer.toString(flightprice);
                
                
                
            }
                    }   
                    catch(Exception E){
                    
                    }
                    dispose();
                    new List_flights(str_fid,f_arrival,f_departure,datetime,open,username,password,usr_name,Flight_price).setVisible(true);
                }
                else
                {                  
                    dispose();
                    new Home_page().setVisible(true);
                    String message = "Enter a valid combination!";
                    JOptionPane.showMessageDialog(new ErrorDialogueBox(), message, "Invalid!", JOptionPane.ERROR_MESSAGE);
                    
                    initComponents();
                    Get_Arrival();
                    Get_Departure();                 
                }
            }
        });
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
jButton2.addActionListener(new ActionListener() 
         
        {
            public void actionPerformed(ActionEvent e) 
            {   
                
                        
                if(null == open )
                {
                    dispose();
                    new Login().setVisible(true);
                }
                
                
                else switch (open) {
                    case "true" -> {
                        dispose();
                        new myprofile(username,password).setVisible(true);
                        //goto profile
                    }
                    case "false" -> {
                        dispose();
                        new Login().setVisible(true);
                    }
                    default -> {
                        dispose();
                        new Login().setVisible(true);
                    }
                }
            }
        });
         
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new signout().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel User_name1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private java.awt.Label label2;
    // End of variables declaration//GEN-END:variables
}
