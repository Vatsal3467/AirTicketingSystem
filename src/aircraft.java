
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aritrasmac
 */
public class aircraft extends javax.swing.JFrame {

    /**
     * Creates new form aircraft
     */
    //decalare public variables
    public String username;
    public String selectedflight;
    public String selectedflight2;
    
    public aircraft() {//main 
        initComponents();
        addvaluestotable();//calling method
        addvaluestotable2();//calling method
        add_values_to_modfyflight();//calling method
    }
    public aircraft(String val1) {//created constructor for aircraft
        
        initComponents();
        addvaluestotable();//calling method
        addvaluestotable2();//calling method
        add_values_to_modfyflight();//calling method
        this.username=val1;//calling method
        
        jLabel1.setText("Hi! "+username);//set title
        
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        signout = new javax.swing.JButton();
        back = new javax.swing.JButton();
        panel2 = new java.awt.Panel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Aircraftname1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        seat1 = new javax.swing.JTextField();
        submit = new javax.swing.JButton();
        reset1 = new javax.swing.JButton();
        panel3 = new java.awt.Panel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        seat2 = new javax.swing.JTextField();
        modify = new javax.swing.JButton();
        reset2 = new javax.swing.JButton();
        aircrftname2 = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        panel4 = new java.awt.Panel();
        jLabel4 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        remove = new javax.swing.JButton();
        aircraftname3 = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background.jpeg"))); // NOI18N
        jLabel14.setMinimumSize(new java.awt.Dimension(1080, 570));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 190, 30));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Aircraft_Name", "Seating Capacity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable3);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 460, 100));

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Aircraft_Name", "Seating Capacity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable4);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 160, 480, 100));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 390, 10, 250));

        jLabel19.setText("@PIXABAY");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 120, -1, -1));

        signout.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        signout.setText("SIGN OUT");
        signout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signoutActionPerformed(evt);
            }
        });
        getContentPane().add(signout, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 30, 110, 50));

        back.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        back.setText("BACK");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 100, 50));

        panel2.setBackground(new java.awt.Color(255, 255, 204));
        panel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Add Aircraft");
        panel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        jLabel8.setText("Aircraft Name");
        panel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 92, -1));
        panel2.add(Aircraftname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 110, -1));

        jLabel9.setText("Seating Capacity");
        panel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));
        panel2.add(seat1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 110, -1));

        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        panel2.add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        reset1.setText("Reset");
        reset1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset1ActionPerformed(evt);
            }
        });
        panel2.add(reset1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, -1, -1));

        getContentPane().add(panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 270, 230));

        panel3.setBackground(new java.awt.Color(255, 255, 204));
        panel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Modify Existing Aircraft");
        panel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 190, -1));

        jLabel10.setText("Aircraft Name");
        panel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 90, -1));

        jLabel11.setText("Seating Capacity");
        panel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 90, 20));
        panel3.add(seat2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 120, -1));

        modify.setText("Modify");
        modify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyActionPerformed(evt);
            }
        });
        panel3.add(modify, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 80, -1));

        reset2.setText("Reset");
        reset2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset2ActionPerformed(evt);
            }
        });
        panel3.add(reset2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 90, -1));

        aircrftname2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aircrftname2ActionPerformed(evt);
            }
        });
        panel3.add(aircrftname2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 120, -1));

        getContentPane().add(panel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 390, 280, 230));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setMinimumSize(new java.awt.Dimension(10, 0));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 390, 10, 250));

        panel4.setBackground(new java.awt.Color(255, 255, 204));
        panel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Remove Aircraft");
        panel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 23, 160, -1));

        jLabel12.setText("Aircraft Name");
        panel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        remove.setText("Remove");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        panel4.add(remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 80, 30));

        aircraftname3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aircraftname3ActionPerformed(evt);
            }
        });
        panel4.add(aircraftname3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 149, -1));

        getContentPane().add(panel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 390, 270, 230));

        jLabel18.setFont(new java.awt.Font("DIN Condensed", 0, 36)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 102, 255));
        jLabel18.setText("Flight Booking Service");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, 440, 60));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/white.jpg"))); // NOI18N
        jLabel13.setText("jLabel4");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 110));

        jLabel15.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel15.setText("List of  active Aircrafts");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 230, -1));

        jLabel16.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel16.setText("List of Inactive active aircafts");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 130, -1, -1));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background.jpeg"))); // NOI18N
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1070, 730));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        String aircraftname=Aircraftname1.getText();//getting aircraft name to add aircraft
       int seatingcapacity=Integer.parseInt(seat1.getText());//getting seating capacity
       
       if (aircraftname.length()>=3 &&  seatingcapacity!=0 )//condition for aircraft name and seating capacity
       {
            try{
     
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //Connection driver
         Connection conn = DriverManager.getConnection("jdbc:sqlserver://flightbookingsystem01.database.windows.net:1433;database=flight_booking_system;user=Aritra@flightbookingsystem01;password=Flightbooking_1234;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");//Connection string
         Statement uml = conn.createStatement();//create statement
         String sql = "insert into flight_booking.aircraft_details values ('"+aircraftname+"','"+seatingcapacity+"','active')";//query
         ResultSet rs= uml.executeQuery(sql);//execute query
            
        
        
         
 
 }
catch (Exception e) 
        {

        }
            aircrftname2.removeAllItems();
            aircraftname3.removeAllItems();
        addvaluestotable();//add values to the table 1
        addvaluestotable2();//add values to table 2
        //add_values_to_modfyflight();//add values to modify flight
         add_values_to_modfyflight();
        Aircraftname1.setText("");
        seat1.setText("");
        aircrftname2.setLightWeightPopupEnabled(false);
        aircraftname3.setLightWeightPopupEnabled(false);
 }
       else {
       String message = "Please check the name of aircraft and seating capaccity number. \n *Note- The Aircraft name should be more than 2 letters and seatinf capacity field should consist only integers"; //A dialog box will open displaying no valid combinations
                JOptionPane.showMessageDialog(new ErrorDialogueBox(), message, "Invalid!", JOptionPane.ERROR_MESSAGE);//error message
       }
        
    }//GEN-LAST:event_submitActionPerformed

    private void reset1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset1ActionPerformed
        // TODO add your handling code here:
        Aircraftname1.setText(""); //setting inital values
      seat1.setText("");
      aircrftname2.setLightWeightPopupEnabled(false);
        aircraftname3.setLightWeightPopupEnabled(false);
    }//GEN-LAST:event_reset1ActionPerformed

    private void modifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyActionPerformed
      
        if (seat2.getText().length() !=0)//check for condition if not equal to 0
        {
            int seatingcapacity=Integer.parseInt(seat2.getText());//get string
        selectedflight = aircrftname2.getSelectedItem().toString();//get selected flight
            try{//connection with sql
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //Connection driver
        Connection conn = DriverManager.getConnection("jdbc:sqlserver://flightbookingsystem01.database.windows.net:1433;database=flight_booking_system;user=Aritra@flightbookingsystem01;password=Flightbooking_1234;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");//Connection string
         Statement uml = conn.createStatement();
         String sql = "update flight_booking.aircraft_details set seatingcapacity='"+seatingcapacity+"' where aircraft_modelname='"+selectedflight+"'";//query
         ResultSet rs=uml.executeQuery(sql);//execute query
        aircrftname2.setSelectedIndex(0);//set to inital condition
        seat2.setText("");
       
       }
       
       catch (Exception e) 
        {

        }
        addvaluestotable();//add values to table 1
        addvaluestotable2();//add values to table 2
        JOptionPane.showMessageDialog(this, "Aircraft modified successfully");
        }
        else{
        JOptionPane.showMessageDialog(this, "Seating capacity cannot be zero");
        }
        aircrftname2.setLightWeightPopupEnabled(false);
        aircraftname3.setLightWeightPopupEnabled(false);
        
    }//GEN-LAST:event_modifyActionPerformed

    private void aircrftname2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aircrftname2ActionPerformed
        
    }//GEN-LAST:event_aircrftname2ActionPerformed

    private void reset2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset2ActionPerformed
        aircrftname2.setSelectedIndex(0);//set to inital condition
        seat2.setText("");
        aircrftname2.setLightWeightPopupEnabled(false);
        aircraftname3.setLightWeightPopupEnabled(false);
    }//GEN-LAST:event_reset2ActionPerformed

    private void aircraftname3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aircraftname3ActionPerformed
       
    }//GEN-LAST:event_aircraftname3ActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
    try{
         selectedflight2=aircraftname3.getSelectedItem().toString();//get selected flight name 2
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //Connection driver
        Connection conn = DriverManager.getConnection("jdbc:sqlserver://flightbookingsystem01.database.windows.net:1433;database=flight_booking_system;user=Aritra@flightbookingsystem01;password=Flightbooking_1234;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");//Connection string
         Statement uml = conn.createStatement();
         String sql = "update flight_booking.aircraft_details set status='inactive' where aircraft_modelname='"+selectedflight2+"'";//query
        ResultSet rs= uml.executeQuery(sql);//execute query
       
        
        
       
       }     
       catch (Exception e) 
        {

        }
        aircrftname2.removeAllItems();//delete all items
        aircraftname3.removeAllItems();
        JOptionPane.showMessageDialog(null, "Aircraft Removed Successfully");//After remove of aircraft, message is displayed
        
        
        addvaluestotable();//update table 1
        addvaluestotable2();//update table 2
        
        add_values_to_modfyflight();
        aircraftname3.setSelectedIndex(0);
        
        aircrftname2.setLightWeightPopupEnabled(false);//to open popup
        aircraftname3.setLightWeightPopupEnabled(false);//to open popup
        
    }//GEN-LAST:event_removeActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        new admin_action(username).setVisible(true);//open admin action page
        this.dispose();//this is dispose
        
    }//GEN-LAST:event_backActionPerformed

    private void signoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signoutActionPerformed
        new signout().setVisible(true);//open sign out page
        this.dispose();//this is closed
    }//GEN-LAST:event_signoutActionPerformed
 public void addvaluestotable(){//create class add values to table 1
     
 try{
     int b;
 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //Connection driver
        Connection conn = DriverManager.getConnection("jdbc:sqlserver://flightbookingsystem01.database.windows.net:1433;database=flight_booking_system;user=Aritra@flightbookingsystem01;password=Flightbooking_1234;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");//Connection string
         Statement uml = conn.createStatement();//create statemnet 
         String sql = "select aircraft_modelname,seatingcapacity from flight_booking.aircraft_details where status='active'";
         ResultSet rs = uml.executeQuery(sql);//execute statement
       
         ResultSetMetaData resultc = (ResultSetMetaData) rs.getMetaData();
         b = resultc.getColumnCount();//get column count
         DefaultTableModel dt=(DefaultTableModel)jTable3.getModel();//get table
         dt.setRowCount(0);//initial row count to 0
         while(rs.next()){//if results are present
             
          
             Vector v= new Vector(); //getting a vector
             
             for (int i = 1; i<=b; i++)//implementing for loop for different values of i which given column count
              {
                 
                 v.add(rs.getString("aircraft_modelname")); //Adding aircraft to vector
                 v.add(rs.getString("seatingcapacity"));//Adding seating capacity to vector
               
                 
             }
             
             dt.addRow(v); //another row after adding vector in table
         }
 
 }
 
 catch (SQLException ex) {
            Logger.getLogger(List_flights.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(List_flights.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
 public void addvaluestotable2(){//create class add valuest to table 2
     
 try{
     int b;
 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //Connection driver
        Connection conn = DriverManager.getConnection("jdbc:sqlserver://flightbookingsystem01.database.windows.net:1433;database=flight_booking_system;user=Aritra@flightbookingsystem01;password=Flightbooking_1234;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");//Connection string
         Statement uml = conn.createStatement();
         String sql = "select aircraft_modelname,seatingcapacity from flight_booking.aircraft_details where status='inactive'";//query
         ResultSet rs = uml.executeQuery(sql);//execute query
//         ResultSetMetaData resultc = (ResultSetMetaData) rs.getMetaData();
//         b = resultc.getColumnCount();
         DefaultTableModel dt=(DefaultTableModel)jTable4.getModel();
         dt.setRowCount(0);
         while(rs.next()){//if results are present
             
          
             Vector v= new Vector(); //getting a vector
             
//             for (int i = 1; i<=b; i++)//implementing for loop for different values of i which given column count
//              {
                 
                 v.add(rs.getString("aircraft_modelname")); //Adding inactive aircraft id to vector
                 v.add(rs.getString("seatingcapacity"));//Adding seating capacity to vector
               
                 
//             }
             
             dt.addRow(v); //another row after adding vector in table
         }
 
 }
 
 catch (SQLException ex) {
            Logger.getLogger(List_flights.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(List_flights.class.getName()).log(Level.SEVERE, null, ex);
        }
 }

 
 public void add_values_to_modfyflight(){//creating class to add values to dropdown menu
 Connection conn; //declaring variable
        ResultSet rs;//declaring variable
        
        aircrftname2.addItem("Please select an aircraft");//add initial value
        aircraftname3.addItem("Please select an aircraft");//add initial value
        
        try { //Connection with the Azure SQL
         
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //Connection driver
            conn = DriverManager.getConnection("jdbc:sqlserver://flightbookingsystem01.database.windows.net:1433;database=flight_booking_system;user=Aritra@flightbookingsystem01;password=Flightbooking_1234;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");//Connection string
            java.sql.Statement stat = conn.createStatement();
            String SelectQuery = "SELECT aircraft_modelname FROM flight_booking.aircraft_details where status='active'"; //Query Statement
            rs = stat.executeQuery(SelectQuery);//Executing Query
            while (rs.next()) {//Displaying results 
                String aircraft_modelname = rs.getString(1);       
                aircrftname2.addItem(aircraft_modelname); //add the aircraft model name in combobox 1
                aircraftname3.addItem(aircraft_modelname);//add the aircraft model name in combobox 2
                //Adding item to combobox                              
            }
      
        } catch (Exception e) 
        {

        }
 
 }
 
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
            java.util.logging.Logger.getLogger(aircraft.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(aircraft.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(aircraft.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(aircraft.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new aircraft().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Aircraftname1;
    private javax.swing.JComboBox<String> aircraftname3;
    private javax.swing.JComboBox<String> aircrftname2;
    private javax.swing.JButton back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JButton modify;
    private java.awt.Panel panel2;
    private java.awt.Panel panel3;
    private java.awt.Panel panel4;
    private javax.swing.JButton remove;
    private javax.swing.JButton reset1;
    private javax.swing.JButton reset2;
    private javax.swing.JTextField seat1;
    private javax.swing.JTextField seat2;
    private javax.swing.JButton signout;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}
