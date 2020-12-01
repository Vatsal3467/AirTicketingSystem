
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.Format;
import java.text.SimpleDateFormat;
import static java.time.Clock.system;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class Home_page extends javax.swing.JFrame 
{
    //Declare Variables
    public String arrival_name, departure_name, traveldate;
    public int f_id;
    public String f_arrival;
    public String f_departure;
    public String day;
    public String str_fid;
    public String username;
    public String password;
    public String usr_name;
    public String f_username;
    public int flightprice;
    public String Flight_price;
    public String res;
   
    
    public int d,m,y,dn=0;
    
   
      
    public boolean validate = false;
    public boolean isMatch = true;
    public String open;
    public String psw_match;
    public int deptid;
    public Date checkdate;
    public java.sql.Date sqldateselected;
    
    public Home_page() 
    {
        //Call Home_page
        initComponents();
        Get_Arrival();
        Get_Departure();
        top3destinations();
        setResizable(false);
        jButton5.setVisible(false);
        jButton3.setVisible(false);
        
    }
 public Home_page(String A1,String B1,String C1,String D1) 
    {
         //Called Home_page as Constructor if login by user
        
        initComponents();
        Get_Arrival();
        Get_Departure();
        top3destinations();
       
        this.open=A1; //if login or not
        this.username=B1; //getting username passed by login page
        this.password=C1; //getting password passed by login page
        this.usr_name=D1; //getting  id passed by login page
        
        
        if (usr_name == null)
        {//Set Title for User, If guest then will display Guest otherwise Name of user
         User_name1.setText("Hello, Guest!!");
         jButton2.setText("SIGN IN"); //setting text for button Sign in
         jButton5.setVisible(false);
         jButton3.setVisible(false);
        
        }
        else{ //Display name of user
        User_name1.setText("Hi, " + usr_name); //setting text for button hi, username
        jButton3.setEnabled(true);
        jButton2.setText("MY PROFILE");
        //if login, Sign in will be chnaged to My profile and that window will be opened
         jButton5.setEnabled(true);
         jButton5.setVisible(true);
         jButton3.setVisible(true);
         jButton6.setVisible(false);
        }
        
        
        
    }
 
 
    public static void main(String args[]) 
    {

        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new Home_page().setVisible(true); //Opening Home_page by calling main method
                
            }
        });
    }
  
    void Get_Arrival() //Create a class Arrival
    {
        Connection conn; //declaring variable
        ResultSet rs;//declaring variable
        
        jComboBox1.addItem("Select an arrival city");
        
        try { //Connection with the Azure SQL
         
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //Connection driver
            conn = DriverManager.getConnection("jdbc:sqlserver://flightbookingsystem01.database.windows.net:1433;database=flight_booking_system;user=Aritra@flightbookingsystem01;password=Flightbooking_1234;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");//Connection string
            java.sql.Statement stat = conn.createStatement();
            String SelectQuery = "SELECT a_name FROM flight_booking.air_name "; //Query Statement
            rs = stat.executeQuery(SelectQuery);//Executing Query
            while (rs.next()) {//Displaying results 
                String airport = rs.getString("a_name");       
                jComboBox1.addItem(airport);   //Adding item to combobox                              
            }
      
        } catch (Exception e) 
        {

        }

    }  

    
    void Get_Departure() //Creating class for Departure
    {
        
        Connection conn;
        ResultSet rs;
        
        jComboBox2.addItem("Select an departure city");
        
        try 
        { //Connection with SQL server
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //Connection driver
            conn = DriverManager.getConnection("jdbc:sqlserver://flightbookingsystem01.database.windows.net:1433;database=flight_booking_system;user=Aritra@flightbookingsystem01;password=Flightbooking_1234;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");//Connection string
            java.sql.Statement stat = conn.createStatement();
            String SelectQuery = "SELECT a_name FROM flight_booking.air_name";
            rs = stat.executeQuery(SelectQuery);
            while (rs.next()) 
            {
                String airport = rs.getString("a_name");
                jComboBox2.addItem(airport);        //Adding departure list to the combobox                
            }
        
        } catch (Exception e) 
        {

        }
    }

    void Get_Date() //Creating class for getting dates
    {
        if(jDateChooser1.getDate()==null){
   
}
        else{
        
            java.sql.Date sqldate = new java.sql.Date(jDateChooser1.getDate().getTime()); //Used calender jar file to get date and time
            long millistime = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millistime);
            
        if(sqldate != null)
        {
            if(sqldate.compareTo(date) > 0)
            {
               traveldate = sqldate.toString();
              
            }
            else
            {
                String message = "Travel date must be greater than current date!"; //A dialog box will open displaying no valid combinations
                JOptionPane.showMessageDialog(new ErrorDialogueBox(), message, "Invalid!", JOptionPane.ERROR_MESSAGE);
            }
        }
        else
        {
            String message = "Enter a travel date!"; //A dialog box will open displaying no valid combinations
            JOptionPane.showMessageDialog(new ErrorDialogueBox(), message, "Invalid!", JOptionPane.ERROR_MESSAGE);
        }
        }
    }
    
    void top3destinations(){//set values for top 3 destinations which were chosen
    try { //Connection with the Azure SQL
        int b;
          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //Connection driver
        Connection conn = DriverManager.getConnection("jdbc:sqlserver://flightbookingsystem01.database.windows.net:1433;database=flight_booking_system;user=Aritra@flightbookingsystem01;password=Flightbooking_1234;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");//Connection string
         Statement uml = conn.createStatement();
         String sql = "select TOP (3) b.f_arrival,b.f_departure, sum(a.bookedseats)  as seatsbooked_no from flight_booking.seatavailabilty a inner JOIN flight_booking.Flight_Detail b on a.f_id=b.f_id group by b.f_arrival,b.f_departure";
         ResultSet rs = uml.executeQuery(sql); //Executing Query
         ResultSetMetaData resultc = (ResultSetMetaData) rs.getMetaData();//storing the result
         b = resultc.getColumnCount();//getting column count
         
         DefaultTableModel dt=(DefaultTableModel)jTable1.getModel();
         dt.setRowCount(0);
         
         while(rs.next()){
             
            
             Vector v= new Vector(); //getting a vector
             
             for (int i = 1; i<=b; i++)//implementing for loop for different values of i which given column count
              {
                 
                 v.add(rs.getString(2)); //Adding Fdeparture to vector
                 v.add(rs.getString(1));//Adding arrival to vector
               
                 
             }
             
             dt.addRow(v); //another row after adding vector in table
         }
         
         
        } catch (Exception e) 
        {

        }
    }
    
    void getDay(){//creating class getDay
  if(jDateChooser1.getDate()==null){
   
}    
  else{
java.sql.Date sqldate2 = new java.sql.Date(jDateChooser1.getDate().getTime());
Format dateFormat = new SimpleDateFormat("EEEEEEEEE"); //converteing date into day
       res = dateFormat.format(sqldate2);
      
  }
  

    }
     
    @SuppressWarnings("empty-statement")
            
    
        
            
    void updateseatsfordate(){//update seats for the table
    try 
        { //Creating connection with SQL database
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //Connection driver
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://flightbookingsystem01.database.windows.net:1433;database=flight_booking_system;user=Aritra@flightbookingsystem01;password=Flightbooking_1234;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");//Connection string
            Statement uml = conn.createStatement();
            java.sql.Date sqldate12 = new java.sql.Date(jDateChooser1.getDate().getTime());//getting the date
        
            String sql = "select deptdate FROM flight_booking.seatavailabilty where f_id='"+f_id+"' and deptdate='"+sqldate12+"'";//query
            
            ResultSet rs = uml.executeQuery(sql); //Executing Query
           
            if (rs.next())//if results are present 
            {
            Date dt=rs.getDate("deptdate");//update date
           
            }
            else {//if date not present, create the date
            try{
                    
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //Connection driver
                    Connection con2 = DriverManager.getConnection("jdbc:sqlserver://flightbookingsystem01.database.windows.net:1433;database=flight_booking_system;user=Aritra@flightbookingsystem01;password=Flightbooking_1234;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");//Connection string
                    Statement uml2 = con2.createStatement();//create statement
                     java.sql.Date sqldate11 = new java.sql.Date(jDateChooser1.getDate().getTime());//getting date
           
                 String sql2="insert into flight_booking.seatavailabilty (deptdate,f_id,currentprice,availableseats) select'"+sqldate11+"', a.f_id,a.Price,b.seatingcapacity FROM flight_booking.aircraft_details b inner join flight_booking.Flight_Detail a on a.aircraft_model=b.aircraft_modelname where a.f_id='"+f_id+"'"; //quert



              uml2.executeQuery(sql2);//ececute query
//              con2.close();
//            
                }
                catch (Exception ed) 
        {

        }
            }
            

                
               
    
    } 
    
    
    catch (SQLException | ClassNotFoundException e) 
        {
            
        }
    }
    
    
    
    
    void Search_Flights() //Create class Search Flight
    {  
        Get_Date();
       getDay();
       
         //getting date
        try 
        { //Creating connection with SQL database
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //Connection driver
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://flightbookingsystem01.database.windows.net:1433;database=flight_booking_system;user=Aritra@flightbookingsystem01;password=Flightbooking_1234;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");//Connection string
            Statement uml = conn.createStatement();
            String sql = "SELECT f_id, f_arrival, f_departure,day FROM flight_booking.Flight_Detail a where a.f_arrival = '" + arrival_name + "' and a.f_departure = '" + departure_name + "' and day='" + res + "' ";
    
            ResultSet rs = uml.executeQuery(sql); //Executing Query
            while(rs.next()) //results of execution
            {
                f_id = rs.getInt("f_id");
                f_arrival = rs.getString("f_arrival");
                f_departure = rs.getString("f_departure");
                day = rs.getString("day");
                str_fid=Integer.toString(f_id);
                
                
            }
            conn.close();
            if (jDateChooser1.getDate()==null){
//            JOptionPane.showMessageDialog(null, "Please choose date");
            }
            else{
            if(f_departure.equals(f_arrival) && day.equalsIgnoreCase(res)) //Condition of Arrival and Departure if both are equal
            {
                isMatch = false;
                
            } 
            else
            {
                isMatch = true;
                
            }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        User_name1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
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
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 400, 212, 48));

        jComboBox2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 229, 48));
        getContentPane().add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 400, 198, 47));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("SEARCH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 400, -1, 43));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "From", "To"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 210, 320, 80));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setText("My Bookings");
        jButton5.setEnabled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, 131, 44));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Departure");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 229, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Arrival");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 360, 212, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Date of travel");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 360, 198, -1));

        jLabel8.setFont(new java.awt.Font("Noto Sans Oriya", 3, 18)); // NOI18N
        jLabel8.setText("Flight Routes in-demand!");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 160, 270, 40));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("SIGN IN");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 30, 131, 44));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("SIGN OUT");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 30, -1, 44));

        User_name1.setFont(new java.awt.Font("Tamil MN", 1, 29)); // NOI18N
        User_name1.setForeground(new java.awt.Color(255, 255, 255));
        User_name1.setText("Hello, Guest!!!");
        getContentPane().add(User_name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 435, -1));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("EXIT APPLICATION");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 570, 200, 43));

        jLabel5.setFont(new java.awt.Font("DIN Condensed", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 102, 255));
        jLabel5.setText("Flight Booking Service");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 430, 60));

        jLabel7.setText("@PIXABAY");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 120, -1, -1));

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setText("ADMIN Login");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 570, 240, 50));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background.jpeg"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1070, 730));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/white.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 110));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
       
        arrival_name = jComboBox1.getSelectedItem().toString(); //Setting items from Departure into Combobox
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        departure_name = jComboBox2.getSelectedItem().toString(); //Setting items from Arrival to combobox
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         
               Search_Flights(); //Calling Search class
              
          
        
                       
                if((validate == true) && (isMatch = true) && jDateChooser1.getDate()!=null) //if arrival and departure are different
                {
                    try {
                         updateseatsfordate();//update seats 
                      
                        sqldateselected = new java.sql.Date(jDateChooser1.getDate().getTime());
                        new List_flights(arrival_name,departure_name,traveldate,open,username,password,usr_name,Flight_price,res,sqldateselected).setVisible(true);
                        
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Home_page.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    dispose(); //this will be closed
                }
                
                
                
                else
                {                  
                    String message = "Enter a valid combination!"; //A dialog box will open displaying no valid combinations
                    JOptionPane.showMessageDialog(new ErrorDialogueBox(), message, "Invalid!", JOptionPane.ERROR_MESSAGE);
                    
                    
                }
            
            
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

                //If this button is pressed then Login page will open
                 
                if(null == open )
                {
                    
                    new Login().setVisible(true);
                    dispose(); //this will close
                }
                
                
                else switch (open) {
                    case "true" -> {
                       
                        new myprofile(username,password).setVisible(true); //If already login, My profile page will open
                         dispose(); //this will close
                        //goto profile
                    }
                    case "false" -> {
                        
                        new Login().setVisible(true); //if not login, login page will open
                        dispose(); //this will close
                    }
                    default -> { //by default
                     
                        new Login().setVisible(true);
                        dispose(); //this will close
                    }
                }
           
         
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new signout().setVisible(true); //this button signots the user, if they rae login, by default it is disabled 
        dispose();// this page will close
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
            this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       new bookingaction(username,password,usr_name,open).setVisible(true); //if this button is clicked, bookingaction page is opened
       this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       new Admin_login().setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel User_name1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private java.awt.Label label2;
    // End of variables declaration//GEN-END:variables
}
