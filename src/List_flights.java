    ////import com.mysql.cj.jdbc.result.ResultSetMetaData;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import javax.swing.table.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
public class List_flights extends javax.swing.JFrame {
//Import packages
    /**
     * Creates new form test
     */
    public List_flights() { //constructor for list flight
        initComponents();
        Addvaluestotable();
        setResizable(false);
        
    } //Declaring public variables
    public String arrival_name;
    public String departure_name;
    public String traveldate;
    public String str_fid;
    public String str_date[];
    public String str_dateprint;
    public String date_month;
    public String date_num;
    public String pswdmatch="true";
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
    public String Day;
    public Date selecteddate;
   public int availableseats;
    
    public List_flights(String val2,String val3,String val4, String val5, String val6, String val7, String val8,String val9,String val10,Date val11) throws ClassNotFoundException
    { //Constructor for list_Flight with variables
         initComponents();
         
         
         
         //this.str_fid=val1; //Flight id passed by Homepage
         this.arrival_name=val2; //Arrival detailes passed by homepage
         this.departure_name=val3;//Departure detailes passed by homapge
         this.traveldate=val4; //Date passed by Homepage
         this.open=val5; //Login passed by homepage
         this.username=val6;//Username passed by homepage
         this.password=val7;//password passed by homepage
         this.usr_name=val8;//id passed by homepage
         this.Price=val9;//price passed by homepage
         this.Day=val10;//pass day
         this.selecteddate=val11;//selected day
                  
                 
         Addvaluestotable();//calling method add values to table
        
        
        if (usr_name == null){//Set Title for User, If guest then will display Guest otherwise Name of user
            book.setVisible(false); //if login is not don, the book button is not visible
            alert.setText("Please Sign in to Book a Flight!!!"); //if not login this statement will be printed
           }
           else{ //else, button is visible but not enabled
           book.setVisible(true);
           book.setEnabled(false);
           }
     
    }

 
    
    
    
     public void Addvaluestotable(){ try {
         //Making method Adding values to table
         
         int b;
         String str_date[]=traveldate.split("-");
         switch (str_date[1]) {
             case "01" -> date_month="January" ; //giving numbers to string
             case "02" -> date_month="february";
             case "03" -> date_month="March";
             case "04" -> date_month="April";
             case "05" -> date_month="May";
             case "06" -> date_month="June";
             case "07" -> date_month="July";
             case "08" -> date_month="August";
             case "09" -> date_month="September";
             case "10" -> date_month="October";
             case "11" -> date_month="November";
             case "12" -> date_month="December";
             default -> {
             }
         }
         date_num = switch (str_date[2]) { //Using switch statement to get different states
             case "01" -> "st";
             case "02" -> "nd";
             case "03" -> "rd";
             case "21" -> "st";
             case "22" -> "nd";
             case "23" -> "rd";
             default -> "th";
         };
         
         
         
         
         str_dateprint=(str_date[2]+date_num+" "+date_month+" "+str_date[0]); //Developing string for adding a values to table
         jLabel1.setText("List of available flights on "+str_date[2]+date_num+" "+date_month+" "+str_date[0]); //setting text above for what flight is being searched
         
         
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //Connection driver
        Connection conn = DriverManager.getConnection("jdbc:sqlserver://flightbookingsystem01.database.windows.net:1433;database=flight_booking_system;user=Aritra@flightbookingsystem01;password=Flightbooking_1234;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");//Connection string
         Statement uml = conn.createStatement();
         String sql = "SELECT a.f_id,a.f_arrival,a.f_departure,a.day,a.dept_time,a.arrival_time,c.availableseats,c.currentprice FROM flight_booking.Flight_Detail a inner join flight_booking.seatavailabilty c on a.f_id=c.f_id  where a.f_arrival = '" + arrival_name + "' and a.f_departure = '" + departure_name + "' and a.day = '" + Day + "' and c.deptdate='"+selecteddate+"'";
         ResultSet rs = uml.executeQuery(sql); //Executing Query
         ResultSetMetaData resultc = (ResultSetMetaData) rs.getMetaData();
         b = resultc.getColumnCount();
         
         DefaultTableModel dt=(DefaultTableModel)jTable1.getModel();
         dt.setRowCount(0);
         
         while(rs.next()){
             
             availableseats=rs.getInt("availableseats");
             Vector v= new Vector(); //getting a vector
             
             for (int i = 1; i<=b; i++)//implementing for loop for different values of i which given column count
              {
                 
                 v.add(rs.getString("f_id")); //Adding Flight id to vector
                 v.add(rs.getString("f_arrival"));//Adding arrival to vector
                 v.add(rs.getString("f_departure"));//adding departure to vector
                 v.add(rs.getTime("dept_time"));//adding departure to vector
                 v.add(rs.getTime("arrival_time"));//adding time to vector
                 v.add(rs.getString("day"));//adding date to vector
                 v.add(rs.getString("availableseats"));//adding avaiable seats to 
                 v.add(rs.getString("currentprice"));//adding price to vector
                 
             }
             
             dt.addRow(v); //another row after adding vector in table
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

        jlabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        alert = new javax.swing.JLabel();
        trial = new javax.swing.JLabel();
        book = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jlabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background.jpeg"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Flight ID", "Arrival", "Departure", "Dept Time", "Arrival Time", "Day", "Available Seats", "Price(CA $)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(100);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 940, 199));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 690, 55));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("BACK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 30, 100, 40));

        jLabel5.setFont(new java.awt.Font("DIN Condensed", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 102, 255));
        jLabel5.setText("Flight Booking Service");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 400, 60));

        alert.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        alert.setForeground(new java.awt.Color(255, 0, 51));
        getContentPane().add(alert, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 630, 40));

        trial.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(trial, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 1040, 40));

        book.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        book.setText("BOOK");
        book.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookActionPerformed(evt);
            }
        });
        getContentPane().add(book, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 540, 120, 50));

        jLabel2.setText("@PIXABAY");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 120, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/white.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 90));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background.jpeg"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1070, 730));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

                    
                     //this will be closed
                    if(username == null){ //if login is not done, Hello, Guest will be displayed
                        new Home_page().setVisible(true); //this homepage constructor will open
                  this.dispose();
                    }
                    else{
                        new Home_page(open,username,password,usr_name).setVisible(true); //Clicking back button opens home page with login details to set username on title
                        this.dispose();
                    }
                    
                    
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
if (evt.getClickCount() == 1){//when mouse is clicker or when row is selected in table
             DefaultTableModel dt =(DefaultTableModel)jTable1.getModel();
             int Index = jTable1.getSelectedRow();
             
             int i = Integer.parseInt(dt.getValueAt(Index, 0).toString());
             //values form the table are stored in variables
             b_id = dt.getValueAt(Index,0).toString();
             b_arrival = dt.getValueAt(Index,1).toString();
             b_departure = dt.getValueAt(Index,2).toString();
             selected_date = dt.getValueAt(Index,5).toString();
             selected_price = dt.getValueAt(Index,7).toString();
             
              trial.setText("Selected Flight has ID: " + b_id + ", Departing from: " + b_departure+ ", Arriving at: " + b_arrival+ " on " + selected_date + " and your price is CAD" + selected_price); //text is set which given out selected flight
              
             book.setEnabled(true);// if seleted selected, the book butoon is enabled
}
else {
    jTable1.clearSelection();
    book.setEnabled(false);
    trial.setText("");
}
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void bookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookActionPerformed

        if (availableseats>0)
{
        
        new Travel_Info(b_id,b_arrival,b_departure,selected_date,open,username,password,usr_name,selected_price,traveldate,Day).setVisible(true);
                    
//                  new modifybooking(b_id,b_arrival,b_departure,selected_date,open,username,password,usr_name,selected_price).setVisible(false);
                    this.dispose();
}
else {
JOptionPane.showMessageDialog(this, "No seats available on this flight. please choose another flight");//if no seats are avaiable, the provide eqqoe message
}
            // TODO add your handling code here:
    }//GEN-LAST:event_bookActionPerformed

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
            java.util.logging.Logger.getLogger(List_flights.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(List_flights.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(List_flights.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(List_flights.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new List_flights().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alert;
    private javax.swing.JButton book;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jlabel4;
    private javax.swing.JLabel trial;
    // End of variables declaration//GEN-END:variables
}
