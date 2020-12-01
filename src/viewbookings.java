
import java.awt.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.JComponent;
import javax.swing.table.DefaultTableModel;

public class viewbookings extends javax.swing.JFrame {

    public viewbookings() {
        initComponents();
        Addvaluetotable(); //Calling a method

    }
// Declaring public variables
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
    public String usernome;
    public String departure;
    public String arrival;
    public String price;
    public String date;
    public String passenger_name;
    public int passport_number;

    public int Index;
    public String BookingID;
    Connection con; //varibale
    PreparedStatement stm;// variable
    ResultSet result;
    public int availableseats;
    public int seatcapacity;
    public int bookedseats;
    public double initialprice;
    public Date date1;


    public viewbookings(String A1, String B1, String C1, String D1) { //Constructor for view bookings

        initComponents();
        this.usernome = A1; //Assigning the variables to the passed variables
        this.password = B1;
        this.usr_name = C1;
        this.open = D1;

        Addvaluetotable(); //calling a method
        
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);

    }
    void update_available_seats_on_cancellation(){
         Connection conn; //declaring variable
        ResultSet rs;
        ResultSet rs1;
        
      try { //Connection with the Azure SQL
        
         
         
        
          
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //Connection driver
            conn = DriverManager.getConnection("jdbc:sqlserver://flightbookingsystem01.database.windows.net:1433;database=flight_booking_system;user=Aritra@flightbookingsystem01;password=Flightbooking_1234;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");//Connection string
            java.sql.Statement stat = conn.createStatement();
            String Selectdate=("select traveldate,flight_id FROM flight_booking.Passenger_Info where bookingID='"+BookingID+"'");//query
            ResultSet rs55=stat.executeQuery(Selectdate);
            while (rs55.next())//if result is present
            {
            traveldate=rs55.getString("traveldate");//get travel date
            date1 = new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(traveldate).getTime());//cange date in given format
            b_id=rs55.getString("flight_id");//get booked id
           // System.out.println("dt payment "+date1);
         // System.out.println("flight id ="+b_id);
            }
            String SelectQuery = "select b.availableseats,c.seatingcapacity,a.Price from flight_booking.Flight_Detail a inner join flight_booking.seatavailabilty b on a.f_id=b.f_id inner join flight_booking.aircraft_details c on c.aircraft_modelname=a.aircraft_model where a.f_id ='"+b_id+"' and b.deptdate='"+date1+"' "; //Query Statement
            rs = stat.executeQuery(SelectQuery);//Executing Query
            while (rs.next()) {//Displaying results 
                //System.out.println("hit");
                 availableseats = rs.getInt(1);    //get pricing
                 seatcapacity=rs.getInt(2);//get seats
                 initialprice=rs.getInt(3);//get initial price
                 
                 bookedseats=(seatcapacity-availableseats)+1;//chnage book seates to add 1
                 
                if (availableseats>=0)//check for avaiable seats
                {
                   System.out.println("hit2"); 
                    availableseats+=1;
                
                String update_seats = "update flight_booking.seatavailabilty set availableseats='"+availableseats+"',bookedseats='"+bookedseats+"' where f_id ='"+b_id+"' and deptdate='"+date1+"'"; //query
                rs1=stat.executeQuery(update_seats);//execute query
                }
                else {
                };
                                         
            }
            
      
        } catch (Exception e) 
        {

        }
    }
    void dynamicpricing_oncancellation(){//develop a class for dynamic pricing
     
         
     double percentage_booked_seats=((double)bookedseats/seatcapacity)*100;//calculate percentage of booked flights
     double newflightprice;//create variable for new pricing
     if (percentage_booked_seats>0 && percentage_booked_seats<=10)
     { //if percentage of booked flight is 0 to 10
     newflightprice=initialprice;
     }
     else if (percentage_booked_seats>10 && percentage_booked_seats<=20){//if percentage of booked flight is 10 to 20
     newflightprice=1.1*initialprice;//new value of price
     }
     else if (percentage_booked_seats>20 && percentage_booked_seats<=30)//if percentage of booked flight is 20 to 30
     {
         newflightprice=1.2*initialprice;//new value of price
     }
     else if (percentage_booked_seats>30 && percentage_booked_seats<=40)//if percentage of booked flight is 30 to 40
     {
         newflightprice=1.3*initialprice;//new value of price
     }
     else if (percentage_booked_seats>40 && percentage_booked_seats<=50)//if percentage of booked flight is 40 to 50
     {
         newflightprice=1.4*initialprice;//new value of price
     }
     else if (percentage_booked_seats>50 && percentage_booked_seats<=60)//if percentage of booked flight is 50 to 60
     {
         newflightprice=1.5*initialprice;//new value of price
     }
     else if (percentage_booked_seats>60 && percentage_booked_seats<=70)//if percentage of booked flight is 60 to 70
     {
         newflightprice=1.6*initialprice;//new value of price
     }
     else if (percentage_booked_seats>70 && percentage_booked_seats<=80)//if percentage of booked flight is 70 to 80
     {
         newflightprice=1.7*initialprice;//new value of price
     }
     else if (percentage_booked_seats>80 && percentage_booked_seats<=90)//if percentage of booked flight is 80 to 90
     {
         newflightprice=1.8*initialprice;//new value of price
     }
     else if (percentage_booked_seats>90 && percentage_booked_seats<=100)//if percentage of booked flight is 90 to 100
     {
         newflightprice=1.9*initialprice;//new value of price
     }
     
     else {
     newflightprice=initialprice;//set varibale for new price
     }
    // System.out.println("% = "+percentage_booked_seats);
     //System.out.println(newflightprice);
     try {
        //  System.out.println("availableseats = "+availableseats);
          //      System.out.println("seatcapacity = "+seatcapacity);
            //    System.out.println("initialprice = "+initialprice);
         //connection with sql
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //Connection driver
            con = DriverManager.getConnection("jdbc:sqlserver://flightbookingsystem01.database.windows.net:1433;database=flight_booking_system;user=Aritra@flightbookingsystem01;password=Flightbooking_1234;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");//Connection string
                //query
                stm = con.prepareStatement("update flight_booking.seatavailabilty set currentprice='"+newflightprice+"',prcntgebookedseats='"+percentage_booked_seats+"'where f_id ='"+b_id+"' and deptdate='"+date1+"'" ); //query
                stm.executeUpdate();//execute query
                
                
             
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Travel_Info.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Travel_Info.class.getName()).log(Level.SEVERE, null, ex);
            }
     
     
     }
    public void Addvaluetotable() { //developing a method to add values to table
        try {
            int b;//private integer b
                //connection with java
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //Connection driver
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://flightbookingsystem01.database.windows.net:1433;database=flight_booking_system;user=Aritra@flightbookingsystem01;password=Flightbooking_1234;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");//Connection string
            Statement uml = conn.createStatement();
            String sql = "SELECT * FROM flight_booking.Passenger_Info a where Email_ID = '" + usernome + "' and status='active'"; //Statement query
            ResultSet rs = uml.executeQuery(sql); //Executing Query
            ResultSetMetaData resultc = (ResultSetMetaData) rs.getMetaData();
            b = resultc.getColumnCount();//getting number of columns in result

            DefaultTableModel dt = (DefaultTableModel) jTable1.getModel(); //setting up the table
            dt.setRowCount(0);//initial row count is 0

            while (rs.next()) { //when result is present

                Vector v = new Vector(); //getting a vector

                for (int i = 1; i <= b; i++) {//adding values to the table for b number of rows in tables

                    v.add(rs.getString("departure")); //Adding departure to vector
                    v.add(rs.getString("arrival"));//Adding arrival to vector
                    v.add(rs.getString("price"));//Adding price to vector
                    v.add(rs.getString("traveldate"));//Adding date to vector
                    v.add(rs.getString("BookingID"));//adding booking id to vector
                    

                }

                dt.addRow(v); //Adding whole row in table
            }

        } catch (SQLException ex) {
            Logger.getLogger(List_flights.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(List_flights.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Departure", "Arrival", "Price", "Date", "Booking ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 1040, 470));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("CANCEL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 650, 210, 54));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("MODIFY");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 650, 210, 54));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("HOME");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 100, 44));

        jLabel7.setText("@PIXABAY");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 110, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/white.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 100));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background.jpeg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
        if (evt.getClickCount() == 1){//when moouse is clicked one time or when row is selected
        DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
        Index = jTable1.getSelectedRow();//getting the selected row

        departure = dt.getValueAt(Index, 0).toString();//getiting the variables from the table
        arrival = dt.getValueAt(Index, 1).toString();
        price = dt.getValueAt(Index, 2).toString();
        date = dt.getValueAt(Index, 3).toString();
        BookingID = dt.getValueAt(Index, 4).toString();
        jButton1.setEnabled(true);//button is set enables
        jButton2.setEnabled(true);
        }
        else {//if again mouse is clicked, then selection is cleared
            jTable1.clearSelection();
            Index=0;
            jButton1.setEnabled(false);
            jButton2.setEnabled(false);
}
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (usernome == null) { //if login is not done, Hello, Guest will be displayed
            new Home_page().setVisible(true); //this homepage constructor will open
            this.dispose();
        } else {
            new Home_page(open, usernome, password, usr_name).setVisible(true); //Clicking back button opens home page with login details to set username on title
            this.dispose();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (Index >= 0) {//if slection is done, confirmation is asked to cancel the flight
            int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to cancel your ticket ", "Cancel Ticket", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (response == JOptionPane.YES_OPTION) {
//                //If yes is selcted then flight will cancel
//            
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //Connection driver
                    con = DriverManager.getConnection("jdbc:sqlserver://flightbookingsystem01.database.windows.net:1433;database=flight_booking_system;user=Aritra@flightbookingsystem01;password=Flightbooking_1234;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
                    Statement uml = con.createStatement();

                    String sql = "update flight_booking.Passenger_Info set status='cancelled' where BookingID = '" + BookingID + "'";//query statement

                    ResultSet rs = uml.executeQuery(sql);


                } catch (Exception e) 
        {

        }
                JOptionPane.showMessageDialog(null, "booking deleted successfully");//After cancelation of flight, message is displayed
                update_available_seats_on_cancellation();
                dynamicpricing_oncancellation(); //calling class dynamic pricing
                Addvaluetotable();//again method is called to update the table

            }
            

        } else {//else, option for selecting a flight will be shown
            JOptionPane.showConfirmDialog(this, "Please select a booking ?", "select booking", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE);
        };
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if (Index >= 0) {//if slection is done, confirmation is asked to modify the flight
            int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to modify your ticket ", "Modify Ticket", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (response == JOptionPane.YES_OPTION) {
                //If yes is selcted then flight will modified
//            
                try {//connection with sql
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //Connection driver
                    con = DriverManager.getConnection("jdbc:sqlserver://flightbookingsystem01.database.windows.net:1433;database=flight_booking_system;user=Aritra@flightbookingsystem01;password=Flightbooking_1234;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
                    Statement uml = con.createStatement();

                    String sql = "select * from flight_booking.Passenger_Info where BookingID = '" + BookingID + "'";//query
                    ResultSet rs = uml.executeQuery(sql);//execute statement 
                    while(rs.next()) //when result is present 
                    {
                        passenger_name = rs.getString("Passenger_name");//getting passenger name from table
                        passport_number = rs.getInt("passport");//getting passprt no. from table
                        
                    }

                    System.out.print(passenger_name);//printing the details
                    System.out.print(passport_number);

                    new Modifybooking(passenger_name, passport_number, BookingID,usernome,password,usr_name,open).setVisible(true);//new window is open for modifybooking
                    this.dispose();

                } catch (SQLException ex) {
                    Logger.getLogger(List_flights.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(List_flights.class.getName()).log(Level.SEVERE, null, ex);
                }
//                JOptionPane.showMessageDialog(null, "booking modified successfully");
                Addvaluetotable();

            }

        } else {//else option for selection is done
            JOptionPane.showConfirmDialog(this, "Please select a booking ", "select booking", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE);
        };


    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(viewbookings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewbookings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewbookings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewbookings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewbookings().setVisible(true);
            }
        });
        /* Create and display the form */

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
