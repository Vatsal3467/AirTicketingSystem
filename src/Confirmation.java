/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vatsal
 */
public class Confirmation extends javax.swing.JFrame {
    
    
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
    
    
    
    /**
     * Creates new form Confirmation
     */
    public Confirmation() {
        initComponents();
    }

    
    
    
    public Confirmation(String val1,String val2,String val3,String val4, String val5, String val6, String val7, String val8,String val9){
         initComponents();
         this.b_id=val1; //Flight id passed by Homepage
         this.b_arrival=val2; //Arrival detailes passed by homepage
         this.b_departure=val3;//Departure detailes passed by homapge
         this.selected_date=val4; //Date passed by Homepage
         this.open=val5; //Login passed by homepage
         this.username=val6;//Username passed by homepage
         this.password=val7;//password passed by homepage
         this.usr_name=val8;//id passed by homepage
         this.selected_price=val9;//price passed by homepage
        
        title.setText("Hi, " + usr_name); //setting text for button hi, username
        
        String c ="Your ticlet for flight " + b_id + " flying from " + b_departure + " to " + b_arrival + " on " + selected_date + " is confirmed.";
        details.setText(c);
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        thanks = new javax.swing.JLabel();
        details = new javax.swing.JLabel();
        thanks1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        thanks2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("SIGN OUT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 30, 117, 52));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("HOME");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 109, 52));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("CONFIRMATION PAGE");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 442, 54));

        title.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jPanel1.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 143, 40));

        thanks.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        thanks.setText("In case of the issue, Please do not hesitate to contact us on our E-mail ID.");
        jPanel1.add(thanks, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, 635, 36));

        details.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(details, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 910, 66));

        thanks1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        thanks1.setText("Thanks for booking with us. Have a great trip!!");
        jPanel1.add(thanks1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, 635, 29));

        jLabel4.setText("@PIXABAY");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 120, -1, -1));

        thanks2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        thanks2.setText("Bon Voyage!!");
        jPanel1.add(thanks2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 510, 635, 36));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/white.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 100));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background.jpeg"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      
           new Home_page(open,username,password,usr_name).setVisible(true); //Clicking home button opens home page with login details to set username on title
           this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          new signout().setVisible(true); //signout
          dispose();        

    // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Confirmation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Confirmation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Confirmation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Confirmation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Confirmation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel details;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel thanks;
    private javax.swing.JLabel thanks1;
    private javax.swing.JLabel thanks2;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}