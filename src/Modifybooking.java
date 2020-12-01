
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.text.Format;
import java.text.SimpleDateFormat;
import javax.swing.table.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Modifybooking extends javax.swing.JFrame {
    //public variables
    public String arrival_name;
    public String departure_name;
    public String traveldate;
    public String str_fid;
    public String str_date[];
    public String str_dateprint;
    public String date_month;
    public String date_num;
    public String pswdmatch = "true";
    public String username;
    public String password;
    public String Price;
    public String usr_name;
    public String open;
    public String b_id;
    public String b_arrival;
    public String b_departure;
    public String selected_date;
    public String selected_price;
    public String day;
    public String passenger_name;
    public int passport_number;
    public String booking_id;
    public String arrival,departure,bookingdate,flightid;
    public String res;
    public String selected_day;

    public Modifybooking() {
        initComponents();
    }

    Connection con;
    PreparedStatement stm;
    PreparedStatement stl;

    public Modifybooking(String val1, int val2, String val3,String val4,String val5,String val6,String val7) { //constructor for modifybooking
        initComponents();
        //Setting up variables passed by previous page
        this.passenger_name = val1;
        this.passport_number = val2;
        this.booking_id = val3;
        this.username=val4;
        this.password=val5;
        this.usr_name=val6;
        this.open=val7;

        String passnum = Integer.toString(passport_number); //converting passport number into string

        if (passenger_name != null) {
            jTextField1.setText(passenger_name);
            jTextField2.setText(passnum);
            
            try {//sql connection
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //Connection driver
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://flightbookingsystem01.database.windows.net:1433;database=flight_booking_system;user=Aritra@flightbookingsystem01;password=Flightbooking_1234;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");//Connection string
            Statement uml = conn.createStatement();
            String sql = "select * from  flight_booking.Passenger_Info  WHERE BookingId = '" + booking_id + "'";//query

            ResultSet rs = uml.executeQuery(sql); //Executing Query
            while (rs.next()) //results of execution
            {
               //setting values from tabel into variables
                arrival = rs.getString("arrival");
                departure = rs.getString("departure");
                bookingdate=rs.getString("traveldate");
                flightid=rs.getString("flight_id");
                jTextField6.setText(bookingdate);
                jTextField5.setText(departure);
                jTextField4.setText(arrival);
                jTextField3.setText(booking_id);
                jTextField7.setText(flightid);
                
            }
            conn.close();

        } catch (Exception e) {

        }
           
        } else {
            jTextField1.setText(passenger_name);
            jTextField2.setText(passnum);
            
            try {//connection with sql
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //Connection driver
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://flightbookingsystem01.database.windows.net:1433;database=flight_booking_system;user=Aritra@flightbookingsystem01;password=Flightbooking_1234;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");//Connection string
            Statement uml = conn.createStatement();
            String sql = "select * from  flight_booking.Passenger_Info  WHERE BookingId = '" + booking_id + "'"; //query

            ResultSet rs = uml.executeQuery(sql); //Executing Query
            while (rs.next()) //results of execution
            {
               //setting results value in variables
                arrival = rs.getString("arrival");
                departure = rs.getString("departure");
                bookingdate=rs.getString("traveldate");
                flightid=rs.getString("flight_id");
                
                //setting variable values into the window fields
                jTextField6.setText(bookingdate);
                jTextField5.setText(departure);
                jTextField4.setText(arrival);
                jTextField3.setText(booking_id);
                jTextField7.setText(flightid);
                
            }
            conn.close();

        } catch (Exception e) {

        }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Passenger Name");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 156, -1));

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 333, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Passport Number");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 156, -1));

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 210, 333, 30));
        getContentPane().add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 590, 333, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Date");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 590, 156, 14));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("CONFIRM");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 650, 120, 50));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("BACK");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 90, 44));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("HOME");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 20, 90, 44));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/white.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 90));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Arrival");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 340, 156, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Departure");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 400, 156, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Booking  ID");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 530, 100, 20));

        jTextField3.setEditable(false);
        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 520, 333, 30));

        jTextField4.setEditable(false);
        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 330, 333, 30));

        jTextField5.setEditable(false);
        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 390, 333, 30));

        jLabel12.setForeground(new java.awt.Color(255, 0, 51));
        jLabel12.setText("Please Enter New Date Here");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 590, 160, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Travel Date");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 470, 120, -1));

        jTextField6.setEditable(false);
        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 460, 333, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("flight ID");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, 120, -1));

        jLabel11.setText("@PIXABAY");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 120, -1, -1));

        jTextField7.setEditable(false);
        jTextField7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField7.setMinimumSize(new java.awt.Dimension(7, 23));
        getContentPane().add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 270, 333, 30));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background.jpeg"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1070, 730));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    void getrequiredday(){ //method for getting required day
        
        java.sql.Date sqldate = new java.sql.Date(jDateChooser1.getDate().getTime()); //date chooser from java
        traveldate = sqldate.toString(); //convert into string
        Format dateFormat = new SimpleDateFormat("EEEEEEEEE");//setting date format
       res = dateFormat.format(sqldate);
       long millistime = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millistime);
            if(sqldate.compareTo(date) > 0){
    try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //Connection driver
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://flightbookingsystem01.database.windows.net:1433;database=flight_booking_system;user=Aritra@flightbookingsystem01;password=Flightbooking_1234;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");//Connection string
            Statement uml = conn.createStatement();
            String sql = "select * from  flight_booking.Flight_Detail where f_arrival= '" + arrival + "' and f_departure = '" + departure + "' and day='" + res + "'";

            ResultSet rs = uml.executeQuery(sql); //Executing Query
            while (rs.next()) //results of execution
            {
               selected_day = rs.getString("day"); //setting variable selected_day from day
            }
            

        } catch (Exception e) {

        }
            }
            else{
                selected_day="abc";
                String message = "Travel date must be greater than current date!"; //provide error message is travel date is less than current date
            JOptionPane.showMessageDialog(new ErrorDialogueBox(), message, "Invalid!", JOptionPane.ERROR_MESSAGE);
            }
    
    }
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    new Home_page(open,username,password,usr_name).setVisible(true); //Clicking home button opens home page with login details to set username on title
                        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        getrequiredday();//call method
        if (selected_day.equals("abc"))
        {
          
        }
        else if(selected_day.equals(res)){

        String bid = booking_id;

        System.out.println("traveldate="+selected_day); //printing out date
        System.out.println("selected day="+res);

        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //Connection driver
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://flightbookingsystem01.database.windows.net:1433;database=flight_booking_system;user=Aritra@flightbookingsystem01;password=Flightbooking_1234;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");//Connection string
            Statement uml = conn.createStatement();
            String sql = "UPDATE flight_booking.Passenger_Info SET traveldate= '" + traveldate + "' WHERE BookingId = '" + bid + "'";

            ResultSet rs = uml.executeQuery(sql); //Executing Query
//            while (rs.next()) //results of execution
//            {
//                day = rs.getString("day");
//            }
//            conn.close();

        } catch (Exception e) {

        }
        jTextField6.setText(traveldate);
        JOptionPane.showMessageDialog(this, "booking updated successfully"); //show message of updtaded booking
        }
        
//        
        
        else{
        JOptionPane.showMessageDialog(this, "Flight not available on this day."); //Show message if no flights are available 
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //Connection driver
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://flightbookingsystem01.database.windows.net:1433;database=flight_booking_system;user=Aritra@flightbookingsystem01;password=Flightbooking_1234;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");//Connection string
            Statement uml = conn.createStatement();
            String sql = "Select * from flight_booking.Cust_Info;"; //query

            ResultSet rs = uml.executeQuery(sql); //Executing Query
            while (rs.next()) //results of execution
            {
//                username = rs.getString("arrival");
//                password = rs.getString("departure");
//                Price = rs.getString("price");
//                traveldate = rs.getString("traveldate");
//                booking_id = rs.getString("BookingID");

            }
            new viewbookings(username, password, usr_name, open).setVisible(true);//by clicking on button, view booking page is open
            this.dispose();
            
            conn.close();

        } catch (Exception e) {

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Modifybooking().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
