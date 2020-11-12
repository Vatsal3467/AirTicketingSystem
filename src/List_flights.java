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
   
    
    public List_flights(String val2,String val3,String val4, String val5, String val6, String val7, String val8,String val9) throws ClassNotFoundException
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
                  
                 
         Addvaluestotable();
        
        
        if (usr_name == null){//Set Title for User, If guest then will display Guest otherwise Name of user
            book.setVisible(false); 
            alert.setText("Please Sign in to Book a Flight!!!");
           }
           else{ //Display name of user
           book.setVisible(true);
           book.setEnabled(false);
           }
     
    }

 
    
    
    
     public void Addvaluestotable(){ try {
         //Making class Adding values to table
         
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
         
         
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my","root","Vatsal@123");
         Statement uml = conn.createStatement();
         String sql = "SELECT f_id, f_arrival, f_departure, f_datetime, Price FROM Flight_Detail a where a.f_arrival = '" + arrival_name + "' and a.f_departure = '" + departure_name + "' and a.f_datetime = '" + traveldate + "'";
         ResultSet rs = uml.executeQuery(sql); //Executing Query
         ResultSetMetaData resultc = (ResultSetMetaData) rs.getMetaData();
         b = resultc.getColumnCount();
         
         DefaultTableModel dt=(DefaultTableModel)jTable1.getModel();
         dt.setRowCount(0);
         
         while(rs.next()){
             
             Vector v= new Vector(); //getting a vector
             
             for (int i = 1; i<=b; i++)
              {
                 
                 v.add(rs.getString("f_id")); //Adding Flight id to table
                 v.add(rs.getString("f_arrival"));//Adding arrival to table
                 v.add(rs.getString("f_departure"));//adding departure to table
                 v.add(rs.getString("f_datetime"));//adding date to table
                 v.add(rs.getString("Price"));//adding price to table
             }
             
             dt.addRow(v); //another row after adding
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
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        alert = new javax.swing.JLabel();
        trial = new javax.swing.JLabel();
        book = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jlabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Flight ID", "Arrival", "Departure", "Date", "Price(CA $)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(200);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 816, 199));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 690, 55));

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
        getContentPane().add(alert, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 450, 600, 30));

        trial.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(trial, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, 980, 40));

        book.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        book.setText("Book");
        book.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookActionPerformed(evt);
            }
        });
        getContentPane().add(book, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 540, 120, 50));

        jLabel2.setText("@PIXABAY");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 120, -1, -1));

        jlabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background.jpeg"))); // NOI18N
        getContentPane().add(jlabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1070, 750));

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

             DefaultTableModel dt =(DefaultTableModel)jTable1.getModel();
             int Index = jTable1.getSelectedRow();
             
             int i = Integer.parseInt(dt.getValueAt(Index, 0).toString());
             
             b_id = dt.getValueAt(Index,0).toString();
             b_arrival = dt.getValueAt(Index,1).toString();
             b_departure = dt.getValueAt(Index,2).toString();
             selected_date = dt.getValueAt(Index,3).toString();
             selected_price = dt.getValueAt(Index,4).toString();
             
              trial.setText("Selected Flight has ID: " + b_id + ", Departing from: " + b_departure+ ", Arriving at: " + b_arrival+ " on " + selected_date + " and your price is " + selected_price);
              
             book.setEnabled(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void bookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookActionPerformed
                    new Travel_Info(b_id,b_arrival,b_departure,selected_date,open,username,password,usr_name,selected_price).setVisible(true);
                    this.dispose();
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jlabel4;
    private javax.swing.JLabel trial;
    // End of variables declaration//GEN-END:variables
}
