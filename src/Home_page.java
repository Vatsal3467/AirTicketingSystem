
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
    
    public boolean validate = false;
    public boolean isMatch = true;
    
    public Home_page() 
    {
        initComponents();
        Get_Arrival();
        Get_Departure();
        
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jComboBox1.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
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

        jComboBox2.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Departure");

        jLabel2.setText("Arrival");

        jLabel3.setText("Date of travel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jButton1))
                    .addComponent(jLabel3))
                .addGap(53, 53, 53))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(207, Short.MAX_VALUE))
        );

        pack();
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
                    dispose();
                    new List_Flights().setVisible(true);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
