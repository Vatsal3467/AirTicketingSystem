import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
public class List_flights extends javax.swing.JFrame {

    /**
     * Creates new form test
     */
    public List_flights() {
        initComponents();
        setResizable(false);
    }
    public String f_arrival;
    public String f_departure;
    public String datetime;
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

   
    
    public List_flights(String val1, String val2,String val3,String val4, String val5, String val6, String val7, String val8,String val9)
    {
         initComponents();
         
         
         
         this.str_fid=val1;
         this.f_arrival=val2;
         this.f_departure=val3;
         this.datetime=val4;
         this.open=val5;
         this.username=val6;
         this.password=val7;
         this.usr_name=val8;
         this.Price=val9;
          
         
         
        Addvaluestotable();
    }
    
    
    
    
     public void Addvaluestotable(){
        DefaultTableModel dt=(DefaultTableModel) jTable1.getModel();
        
        Vector v= new Vector();
        String str_date[]=datetime.split("-");
        switch (str_date[1]) {
            case "01" -> date_month="January" ;
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
         date_num = switch (str_date[2]) {
            case "01" -> "st";
            case "02" -> "nd";
            case "03" -> "rd";
            case "21" -> "st";
            case "22" -> "nd";
            case "23" -> "rd";
            default -> "th";
        };
        
        
                
         
        str_dateprint=(str_date[2]+date_num+" "+date_month+" "+str_date[0]);
        
        v.add(str_fid);
        v.add(f_arrival);
        v.add(f_departure);
        v.add(str_dateprint);
        v.add(Price);
        
        dt.addRow(v);
        
        jLabel1.setText("List of available flights on "+str_date[2]+date_num+" "+date_month+" "+str_date[0]);
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
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Flight ID", "Departure", "Arrival", "Date", "Price(CA $)"
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
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(200);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 816, 199));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 580, 55));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("BACK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 20, 100, 40));

        jLabel5.setFont(new java.awt.Font("DIN Condensed", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 102, 255));
        jLabel5.setText("Flight Booking Service");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 350, 60));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/white.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 90));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background.jpeg"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1070, 750));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
dispose();
                    new Home_page(open,username,password,usr_name).setVisible(true);
                    if(username.equals(null)){
                        new Home_page().setVisible(true);
                    }
                    
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
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
