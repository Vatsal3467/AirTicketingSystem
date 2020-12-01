/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//Import requruired packages
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import static java.time.Clock.system;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.*;


/**
 *
 * @author Vatsal
 */
public class Admin_Flight extends javax.swing.JFrame {

    
    //Decalre public variables
    Connection con;
    PreparedStatement stm;
    ResultSet rs;
    public String fidcheck;
    public String admin;
    public String selectedflight;
    public Time date1;
    public Time date2;
    public Time date1s;
    public Time date2s;
    /**
     * Creates new form Admin_Flight
     */
    public Admin_Flight() {//main class
        initComponents();
        Connect();
        Get_Arrival();
        Get_Departure();
        add_values_to_dropdownlist();      
        
        
        //setting differnet values to initail conditions that text field are not editable
        prices.setEditable(false);
        departures.setEnabled(false);
        arrivals.setEnabled(false);
        days.setEnabled(false);
        departuretimes.setEditable(false);
        arrivaltimes.setEditable(false);
        models.setEnabled(false);
        
        modify.setEnabled(false);
        cancel.setEnabled(false);
    }

    
    public Admin_Flight(String Val1){//develop a constructor to pass variables with it
        initComponents();//calling init componet
        Connect();//calling connect
        Get_Arrival();//calling arrival
        Get_Departure();//calling departure
          
        add_values_to_dropdownlist();//calling ad dvalues to table
        
        //setting inital conditions
        prices.setEditable(false);
        departures.setEnabled(false);
        arrivals.setEnabled(false);
        days.setEnabled(false);
         departuretimes.setEditable(false);
        arrivaltimes.setEditable(false);
        models.setEnabled(false);
        //setting buttons not enabled
        modify.setEnabled(false);
        cancel.setEnabled(false);
        
        this.admin = Val1;//variable declared
        
        title.setText("Hi!! " + Val1);//setting title
        
    }
    
    
    
    public void Connect() {//creating method connect
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //Connection driver
            con = DriverManager.getConnection("jdbc:sqlserver://flightbookingsystem01.database.windows.net:1433;database=flight_booking_system;user=Aritra@flightbookingsystem01;password=Flightbooking_1234;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");//Connection string

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void add_values_to_dropdownlist(){//creating method add values to dropdown
 Connection conn; //declaring variable
        ResultSet rs;//declaring variable
        
        model.addItem("Please select an aircraft");//add list of airport models
        models.addItem("Please select an aircraft");//add list of airport models
        
        try { //Connection with the Azure SQL
         
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //Connection driver
            conn = DriverManager.getConnection("jdbc:sqlserver://flightbookingsystem01.database.windows.net:1433;database=flight_booking_system;user=Aritra@flightbookingsystem01;password=Flightbooking_1234;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");//Connection string
            java.sql.Statement stat = conn.createStatement();
            String SelectQuery = "SELECT aircraft_modelname FROM flight_booking.aircraft_details where status='active'"; //Query Statement
            rs = stat.executeQuery(SelectQuery);//Executing Query
            while (rs.next()) {//Displaying results 
                String aircraft_modelname = rs.getString(1);       
                model.addItem(aircraft_modelname); 
                models.addItem(aircraft_modelname);
                //Adding item to combobox                              
            }
      
        } catch (Exception e) 
        {

        }
 
 }
    
   public void Get_Arrival() //Create a method Arrival
    {
        
        
        arrival.addItem("Select an arrival city");//adding item to the dropdown menu
        arrivals.addItem("");//add item to arrival in search menu

            java.sql.Statement stat;
        try {
            stat = con.createStatement();
               String SelectQuery = "SELECT a_name FROM flight_booking.air_name "; //Query Statement
            rs = stat.executeQuery(SelectQuery);//Executing Query
            while (rs.next()) {//Displaying results 
                String airport = rs.getString("a_name");       
                arrival.addItem(airport);   //Adding item to combobox    
                arrivals.addItem(airport);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Flight.class.getName()).log(Level.SEVERE, null, ex);
        }
         
      
        

    }
   
   
   
   
    void Get_Departure() //Creating method for Departure
    {
    
        
        try //Creating method for Departure
        {
            departure.addItem("Select an departure city");//add inital value to the departure combobox
            departures.addItem("");
            java.sql.Statement stat = con.createStatement();//connection wiht sql
            String SelectQuery = "SELECT a_name FROM flight_booking.air_name";//query
            rs = stat.executeQuery(SelectQuery);//execution of query
            while (rs.next()) //if results re present
            {
                String airport = rs.getString("a_name");
                departure.addItem(airport);        //Adding departure list to the combobox    
                departures.addItem(airport);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Flight.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        signout = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        search = new javax.swing.JButton();
        modify = new javax.swing.JButton();
        days = new javax.swing.JComboBox<>();
        prices = new javax.swing.JTextField();
        day = new javax.swing.JComboBox<>();
        fid = new javax.swing.JTextField();
        fidsearch = new javax.swing.JTextField();
        arrival = new javax.swing.JComboBox<>();
        arrivals = new javax.swing.JComboBox<>();
        price = new javax.swing.JTextField();
        departure = new javax.swing.JComboBox<>();
        departures = new javax.swing.JComboBox<>();
        departuretimes = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        clear = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        arrivaltimes = new javax.swing.JTextField();
        models = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        model = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        signout.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        signout.setText("SIGN OUT");
        signout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signoutActionPerformed(evt);
            }
        });
        jPanel1.add(signout, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 30, 120, 50));

        cancel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cancel.setText("CANCEL");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        jPanel1.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 720, 100, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("DAY");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 160, 160, 40));

        title.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 230, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("ADD FLIGHT ROUTE");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 230, 40));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("FLIGHT NUMBER");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 170, 40));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("DEPARTURE");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 160, 40));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("ARRIVAL");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 160, 40));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("PRICE");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 610, 160, 40));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("PRICE");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 210, 160, 40));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("MODIFY/ CANCEL FLIGHT");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 270, 40));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("FLIGHT NUMBER");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, 170, 40));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("DEPARTURE");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 460, 160, 40));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("ARRIVAL");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 510, 160, 40));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("DAY");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 560, 160, 40));

        back.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        back.setText("BACK");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel1.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 100, 50));

        search.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        search.setText("SEARCH");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        jPanel1.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 410, 90, 40));

        modify.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        modify.setText("MODIFY");
        modify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyActionPerformed(evt);
            }
        });
        jPanel1.add(modify, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 720, 110, 40));

        days.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        days.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" }));
        jPanel1.add(days, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 560, 230, 30));

        prices.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(prices, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 610, 230, 30));

        day.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        day.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please Select the Day..", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" }));
        jPanel1.add(day, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 170, 230, 30));

        fid.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(fid, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 230, 30));

        fidsearch.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(fidsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 420, 230, 30));

        arrival.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(arrival, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, 230, 30));

        arrivals.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(arrivals, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 510, 230, 30));

        price.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 220, 230, 30));

        departure.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(departure, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 230, 30));

        departures.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(departures, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 460, 230, 30));
        jPanel1.add(departuretimes, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 460, 230, 30));

        jLabel15.setText("@PIXABAY");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 120, -1, -1));

        clear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        clear.setText("CLEAR");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        jPanel1.add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 720, 100, 40));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("DEPARTURE TIME");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 460, 150, 30));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("ARRIVAL TIME");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 510, 160, 30));
        jPanel1.add(arrivaltimes, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 510, 230, 30));

        models.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modelsActionPerformed(evt);
            }
        });
        jPanel1.add(models, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 560, 230, 30));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("AIRCRAFT MODEL");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 560, 150, 30));

        add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add.setText("ADD");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel1.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 370, 90, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/white.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1090, 110));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("SELECT AIRCRAFT MODEL");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 270, 210, 30));

        model.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modelActionPerformed(evt);
            }
        });
        jPanel1.add(model, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 270, 230, 30));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("DEPARTURE TIME");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 317, 150, 30));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 230, 30));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("ARRIVAL TIME");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 320, 160, 30));
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 320, 230, 30));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background.jpeg"))); // NOI18N
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed

     String Departure = departure.getSelectedItem().toString();//getitng departure from window
     String Arrival = arrival.getSelectedItem().toString();//getting arrival
     String Day = day.getSelectedItem().toString();//getting day
             
     checkflightid();//calling method to check if flight if already exist
     
     if(fid.getText().length() == 0){//check for condition if flight id is not entered
         JOptionPane.showMessageDialog(this, "Please Enter Flight ID");//error
     }
     
        
     
    else if(fidcheck.equals(fid.getText())){//condition if flight id already present
        JOptionPane.showMessageDialog(this, "Flight with this id already exist... Please use different ID to add a flight");
     }
     
     else if(departure.getSelectedIndex() == 0){//contidion to check selection of departure
         
         JOptionPane.showMessageDialog(this, "Please select Departure Airport");
     }
     
      else if(arrival.getSelectedIndex() == 0){//condition to check selected arrival
         
         JOptionPane.showMessageDialog(this, "Please select Arrival Airport");
     }
      else if(Departure.equals(Arrival)){//condition to check if arrival is equal to departure
         String message = "Enter a valid combination!";
         JOptionPane.showMessageDialog(new ErrorDialogueBox(), message, "Invalid!", JOptionPane.ERROR_MESSAGE);
     }
      else if (jTextField1.getText().length() == 0)//condition to check entered time
     {
     JOptionPane.showMessageDialog(this, "Please enter the Departure Time in hh:mm:ss format");
     }
      
     
     else if(day.getSelectedIndex() == 0){//condition to check selected day
         
         JOptionPane.showMessageDialog(this, "Please select Day");
     }
     else if(price.getText().length() == 0){//condition to check price
         JOptionPane.showMessageDialog(this, "Please Enter Price");
     }    
     
     
     else if(model.getSelectedIndex() == 0){//condition to check model
         
         JOptionPane.showMessageDialog(this, "Please select model");
     }
     
     else if (jTextField2.getText().length() == 0)
     {//condition to check time
     JOptionPane.showMessageDialog(this, "Please enter the Arrival Time in hh:mm:ss format");
     }
     
     else{//else add values to table
          String dept_time=jTextField1.getText();//getting dep time
     String arrivaltime=jTextField2.getText();//getting arrival time
        
     
       try {//try to convert in time format

    
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");//calling defalut method
            long ms = sdf.parse(dept_time).getTime();//setting tim ein variable
            long ms2 = sdf.parse(arrivaltime).getTime();

            date1 = new Time(ms);//converting into time
            date2 = new Time(ms2);
           
        } catch (ParseException ex) {
            Logger.getLogger(Admin_Flight.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
       
     String Model = model.getSelectedItem().toString();
     int f_id = Integer.parseInt(fid.getText());//getting fid
     int Price = Integer.parseInt(price.getText());//getting price 
     try {
            
           
            String sql = "INSERT INTO flight_booking.Flight_Detail(f_id,f_arrival,f_departure,Price,day,aircraft_model,dept_time,arrival_time)values('"+f_id+"','"+Arrival+"','"+Departure+"','"+Price+"','"+Day+"','"+Model+"','"+date1+"','"+date2+"')";//query
            stm = con.prepareStatement(sql);//prepare statement
            int s = stm.executeUpdate(); //Executing query status

                        if (s == 1) {//if query is executed
                            JOptionPane.showMessageDialog(this, "Flight Added Successfully"); //if executed successfully, dialog box will open
                            //setting the text box's value to null value
                            fid.setText("");
                            day.setSelectedIndex(0);
                            price.setText("");
                            jTextField1.setText("");
                            jTextField2.setText("");
                            departure.setSelectedIndex(0);
                            model.setSelectedIndex(0);
                            arrival.setSelectedIndex(0);
                            fid.requestFocus();
                        
                        } else {
                            JOptionPane.showMessageDialog(this, "Flight not Added");
                        }
        
                       
            
        }catch (SQLException ex) {
            Logger.getLogger(Admin_Flight.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     }
        // TODO add your handling code here:
    }//GEN-LAST:event_addActionPerformed

     void checkflightid(){//creating class for checking flight id
try 
        { //Creating connection with SQL database
            
            int f_id = Integer.parseInt(fid.getText()); //getting flight id
            Statement uml = con.createStatement();//create statement 
            String sql = "SELECT * FROM flight_booking.Flight_detail where f_id = '" + f_id + "'";//query
    
            rs = uml.executeQuery(sql); //Executing Query
            if(rs.next()) //results of execution
            {
                
                fidcheck = rs.getString("f_id");//storing it in variable
             
                
                
            }
            else{
                    fidcheck = "nothing";
                    }
            
        }
            catch (Exception e) 
               
        {

        }


}
    
    
    
    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
      
        
        if(fidsearch.getText().length() == 0){//getting flight id to search if null display message
            JOptionPane.showMessageDialog(this, "Please Enter Flight ID to Search!!");
        }
        
        else{//else execute query
        
        
        
            String f_id = fidsearch.getText();//getting searched flight id
            
            String query = "Select * from flight_booking.Flight_Detail where f_id='" + f_id + "'";//query
            
            try {
            Statement stm = con.createStatement(); //try executing statement
            rs = stm.executeQuery(query);//Executing query
               if (rs.next()) { //GEtting results from the sql after execution of query
                String Departure = rs.getString("f_departure");//storing results into the variables
                String Arrival = rs.getString("f_arrival");
                String Price = rs.getString("Price");
                String day = rs.getString("day");
                String deptime = rs.getString("dept_time");
                String arrtime = rs.getString("arrival_time");
                String model = rs.getString("aircraft_model");
                
                departures.setSelectedItem(Departure);//setting the local variables value into the text boxes and combo boxes
                arrivals.setSelectedItem(Arrival);
                days.setSelectedItem(day);
                prices.setText(Price);
                models.setSelectedItem(model);
                departuretimes.setText(deptime);
                arrivaltimes.setText(arrtime);
                
                prices.setEditable(true);//set everything to editable
                departures.setEnabled(true);
                arrivals.setEnabled(true);
                days.setEnabled(true);
                departuretimes.setEditable(true);
                arrivaltimes.setEditable(true);
                models.setEnabled(true);
                //if results re present the allow user to use button
                modify.setEnabled(true);
                cancel.setEnabled(true);
                
            }
               
               else{
                   JOptionPane.showMessageDialog(this, "This Flight Does not Exist");// if flight does not exist show error message
                   fidsearch.requestFocus();
               }

            
        } catch (SQLException ex) {
            Logger.getLogger(myprofile.class.getName()).log(Level.SEVERE, null, ex);
        }
            
         
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

    private void modifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyActionPerformed

            //getting the variables from the window
            String f_id = fidsearch.getText();
            String Departure = departures.getSelectedItem().toString();
            String Arrival = arrivals.getSelectedItem().toString();
            String Day = days.getSelectedItem().toString();
            
            String model = models.getSelectedItem().toString();
            
       
            //cehcking for the initail conditions if the values selected cannot be used or are empty
    if(departures.getSelectedIndex() == 0){
         
         JOptionPane.showMessageDialog(this, "Please select Departure Airport");
     }
     
    else if(arrivals.getSelectedIndex() == 0){
         
         JOptionPane.showMessageDialog(this, "Please select Arrival Airport");
     }
      
     
     else if(days.getSelectedIndex() == -1){
         
         JOptionPane.showMessageDialog(this, "Please select Day");
     }
          
        
     else if(Departure.equals(Arrival)){
         String message = "Enter a valid combination!";
         JOptionPane.showMessageDialog(new ErrorDialogueBox(), message, "Invalid!", JOptionPane.ERROR_MESSAGE);
     }
     
     else if(prices.getText().length() == 0){
         JOptionPane.showMessageDialog(this, "Please Enter Price");
     }
     
    // else if (selectedflight.equals("Please select an aircraft"))
    // {
  //   JOptionPane.showMessageDialog(this, "Please choose aircraft type");
     //}
          
    
     else{//if all the values are modified correctly then following flight can be modified in database
            int Price = Integer.parseInt(prices.getText());//getting price
            
            String dept_time=departuretimes.getText();//getting dep time
            String arrivaltime=arrivaltimes.getText();//getting arrival time
        
     
       try {//try to convert in time format

    
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");//calling defalut method
            long ms = sdf.parse(dept_time).getTime();//setting tim ein variable
            long ms2 = sdf.parse(arrivaltime).getTime();

          date1s = new Time(ms);//converting into time
          date2s = new Time(ms2);
           
        } catch (ParseException ex) {
            Logger.getLogger(Admin_Flight.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
            Statement uml;
        try {
            //query
            String sql = "UPDATE flight_booking.Flight_Detail SET f_departure = '"+Departure+"', f_arrival = '"+Arrival+"', Price = '"+Price+"', day = '"+Day+"', dept_time = '"+date1s+"', arrival_time = '"+date2s+"', aircraft_model = '"+model+"' WHERE f_id = '"+f_id+"'";
              stm = con.prepareStatement(sql);
           
              int s = stm.executeUpdate(); //Executing query status

                        if (s == 1) {
                            JOptionPane.showMessageDialog(this, "Flight Modified Successfully"); //if executed successfully, dialog box will open
                            //set text boxes to editable
                            prices.setEditable(true);
                            departures.setEditable(true);
                            arrivals.setEditable(true);
                            days.setEditable(true);
                            departuretimes.setEditable(true);
                            arrivaltimes.setEditable(true);
                            models.setEnabled(true);
                            
                            
                            
                        } else {
                            JOptionPane.showMessageDialog(this, "Error Modifying the Flight");//else show mesAGE FLIGHT NOT MODIFIED
                           
                        }
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Flight.class.getName()).log(Level.SEVERE, null, ex);
        }
           
            

     }
        // TODO add your handling code here:
    }//GEN-LAST:event_modifyActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed

        //ask for confirmation to delete a flight
        int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to cancel this Flight ", "Cancel Flight", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (response == JOptionPane.YES_OPTION) {//if response is yes
                //getting values to get flight from database
                String f_id = fidsearch.getText();
                   String Departure = departures.getSelectedItem().toString();
                   String Arrival = arrivals.getSelectedItem().toString();
                   String Day = days.getSelectedItem().toString();
                   int Price = Integer.parseInt(prices.getText());


                   Statement uml;//creating variable
               try {

                   String sql = "Delete from flight_booking.Flight_Detail WHERE f_id = '"+f_id+"'";//query
                     stm = con.prepareStatement(sql);
                   int s = stm.executeUpdate(); //Executing query status

                               if (s == 1) {
                                   JOptionPane.showMessageDialog(this, "Flight Canceled Successfully"); //if executed successfully, dialog box will open
                                   fidsearch.setText("");//set values to initail conditions
                                   days.setSelectedIndex(-1);
                                   prices.setText("");
                                   departures.setSelectedIndex(-1);
                                   arrivals.setSelectedIndex(-1);
                                   departuretimes.setText("");
                                   arrivaltimes.setText("");
                                   models.setSelectedIndex(-1);
                                   
                                   //set values to not editable
                                   prices.setEditable(false);
                                   departures.setEnabled(false);
                                   arrivals.setEnabled(false);
                                   days.setEnabled(false);
                                   departuretimes.setEditable(false);
                                   arrivaltimes.setEditable(false);
                                   models.setEnabled(false);

                                   //request focus to flight search
                                   fidsearch.requestFocus();
                                   //diable the buttons
                                   modify.setEnabled(false);
                                    cancel.setEnabled(false);
                               } else {
                                   JOptionPane.showMessageDialog(this, "Error Cancelling the Flight");
                               }
               } catch (SQLException ex) {
                   Logger.getLogger(Admin_Flight.class.getName()).log(Level.SEVERE, null, ex);
               }
            }
            
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
       
        //clear action sets values to defalut value
       fidsearch.setText("");
       days.setSelectedIndex(-1);
       prices.setText("");
       departures.setSelectedIndex(-1);
       arrivals.setSelectedIndex(-1);
       departuretimes.setText("");
       arrivaltimes.setText("");
       models.setSelectedIndex(-1);
       
       
       //values are not editables
        prices.setEditable(false);
        departures.setEnabled(false);
        arrivals.setEnabled(false);
        days.setEnabled(false);
        departuretimes.setEditable(false);
        arrivaltimes.setEditable(false);
        models.setEnabled(false);
        
        
       fidsearch.requestFocus();
       //diable the button
       modify.setEnabled(false);
       cancel.setEnabled(false);
        
        



        // TODO add your handling code here:
    }//GEN-LAST:event_clearActionPerformed

    private void signoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signoutActionPerformed

new signout().setVisible(true); //signout
        dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_signoutActionPerformed

    private void modelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modelActionPerformed
        selectedflight=model.getSelectedItem().toString();
    }//GEN-LAST:event_modelActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
new admin_action(admin).setVisible(true);//one admin actions
        this.dispose();


        // TODO add your handling code here:
    }//GEN-LAST:event_backActionPerformed

    private void modelsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modelsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modelsActionPerformed

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
            java.util.logging.Logger.getLogger(Admin_Flight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_Flight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_Flight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_Flight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_Flight().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JComboBox<String> arrival;
    private javax.swing.JComboBox<String> arrivals;
    private javax.swing.JTextField arrivaltimes;
    private javax.swing.JButton back;
    private javax.swing.JButton cancel;
    private javax.swing.JButton clear;
    private javax.swing.JComboBox<String> day;
    private javax.swing.JComboBox<String> days;
    private javax.swing.JComboBox<String> departure;
    private javax.swing.JComboBox<String> departures;
    private javax.swing.JTextField departuretimes;
    private javax.swing.JTextField fid;
    private javax.swing.JTextField fidsearch;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JComboBox<String> model;
    private javax.swing.JComboBox<String> models;
    private javax.swing.JButton modify;
    private javax.swing.JTextField price;
    private javax.swing.JTextField prices;
    private javax.swing.JButton search;
    private javax.swing.JButton signout;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
