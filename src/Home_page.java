
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
      
    public boolean validate = false;
    public boolean isMatch = true;
    public String open;
    public String psw_match;
    public Home_page() 
    {
        initComponents();
        Get_Arrival();
        Get_Departure();
        
        
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
         User_name.setText("Hello, Guest!!");
         jButton2.setText("SIGN IN");
    }
    else{
    User_name.setText("Hi, " + usr_name);
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
        
        jComboBox1.addItem("Select an arrival destination...");
        
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
        
        jComboBox2.addItem("Select an departure destination...");
        
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

        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        User_name = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jComboBox2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("SEARCH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setText("Departure");

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel2.setText("Arrival");

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel3.setText("Date of travel");

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("SIGN IN");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        User_name.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        User_name.setText("Hello, Guest!!!");

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("SIGN OUT");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(User_name, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox2, 0, 229, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(jButton1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton2)
                                .addComponent(jButton3)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addGap(13, 13, 13))))
                    .addComponent(User_name, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(137, Short.MAX_VALUE))
        );

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
            String sql = "SELECT f_id, f_arrival, f_departure, f_datetime FROM Flight_Detail a where a.f_arrival = '" + arrival_name + "' and a.f_departure = '" + departure_name + "' and a.f_datetime = '" + traveldate + "'";
    
            ResultSet rs = uml.executeQuery(sql);
            if(rs.next())
            {
                f_id = rs.getInt("f_id");
                f_arrival = rs.getString("f_arrival");
                f_departure = rs.getString("f_departure");
                datetime = rs.getString("f_datetime");
                str_fid=Integer.toString(f_id);
            }
                    }   
                    catch(Exception E){
                    
                    }
                    dispose();
                    new List_flights(str_fid,f_arrival,f_departure,datetime,open,username,password,usr_name).setVisible(true);
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
    private javax.swing.JLabel User_name;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
