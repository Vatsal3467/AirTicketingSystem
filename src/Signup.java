/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
// Importing all the necessary libraries for operation.
/**
 *
 * @author Vatsal
 */
public class Signup extends javax.swing.JFrame {

    /**
     * Creates new form Signup
     */
    public Signup() {
        initComponents();
        Connect();
        setResizable(false);
    }
    Connection con;
    PreparedStatement stm;

    public void Connect() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://flightbookingsystem.database.windows.net:1433;database=flight_booking_system;user=Aritra@flightbookingsystem;password=Flightbooking_1234;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
// Connecting the java with Azure microsoft SQL database using drivers so that the data is stored into the table.
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        age = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        pass = new javax.swing.JTextField();
        passcon = new javax.swing.JTextField();
        answer = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        sex = new javax.swing.JComboBox<>();
        sq = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        dob = new javax.swing.JFormattedTextField();
        email = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("SIGN-UP");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, -1, 61));

        jLabel2.setText("NAME");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 101, 30));

        jLabel3.setText("AGE");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 101, 30));

        jLabel4.setText("DATE OF BIRTH");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, 101, 30));

        jLabel5.setText("EMAIL-ID");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 101, 30));

        jLabel6.setText("PASSWORD");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 101, 30));

        jLabel7.setText("CONFIRM PASSWORD");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 370, 150, 30));

        jLabel8.setText("SEQURITY QUESTION");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 410, 140, 30));

        jLabel9.setText("SEX");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, 101, 30));

        jLabel10.setText("ANSWER");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 450, 101, 30));

        age.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ageActionPerformed(evt);
            }
        });
        jPanel1.add(age, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, 335, -1));

        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        jPanel1.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 335, -1));
        jPanel1.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, 335, -1));

        passcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passconActionPerformed(evt);
            }
        });
        jPanel1.add(passcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 370, 335, -1));
        jPanel1.add(answer, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 450, 335, -1));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("CLEAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 550, 103, 37));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("SUBMIT");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 550, 103, 37));

        sex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        jPanel1.add(sex, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 240, -1, -1));

        sq.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "What is your favorite color", "Which is your favorite place", "What is your first school name", "what is your mother name" }));
        jPanel1.add(sq, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 410, 335, -1));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setText("CANCEL");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 550, 103, 37));

        dob.setColumns(10);
        try {
            dob.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        dob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dobActionPerformed(evt);
            }
        });
        jPanel1.add(dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, 335, -1));
        jPanel1.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, 335, 20));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("HOME");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 40));

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton8.setText("SIGN-IN");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 20, -1, 40));

        jLabel12.setText("@PIXABAY");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 100, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background.jpeg"))); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1070, 760));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 650));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        new Home_page().setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void dobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dobActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String Name = name.getText();
        String Age = age.getText();
        String Email = email.getText();
        String Sex = sex.getSelectedItem().toString();
        String DOB = dob.getText();
        String Pass = pass.getText();
        String Passcon = passcon.getText();
        String SQ = sq.getSelectedItem().toString();
        String Answer = answer.getText();
        /*
        Getting fields like name,age,emailID,sex, date of birth,password,security question and answer 
        using getText method. In case of drop down box fields like Sex and Security question the selected field 
        gets converted to string.
        */
        if (Email.contains("@")) {
            // The email field should contain @ sign for vaid entry.

            if (Pass.equals(Passcon) && Pass.length() >= 5) {
                // Password length should be more than 5 characters as a part of security feature.

                try {
                    stm = con.prepareStatement("INSERT INTO Cust_Info(First_Name,Age,Email_ID,Sex,DOB,Pass,SQ,Answer)values(?,?,?,?,?,?,?,?)");
                    stm.setString(1, Name);
                    stm.setString(2, Age);
                    stm.setString(3, Email);
                    stm.setString(4, Sex);
                    stm.setString(5, DOB);
                    stm.setString(6, Pass);
                    stm.setString(7, SQ);
                    stm.setString(8, Answer);
                    int s = stm.executeUpdate();
                    /* 
                    Inserting the detail entered by the user in Cust_Info table in Microsoft Azure SQL in same order Name,Age
                    Email ID, SEX, Date of Birth, Password,security question ,security answer.
                            */
                    if (s == 1) {
                        JOptionPane.showMessageDialog(this, "Account Created Successfully");

                        name.setText("");
                        age.setText("");
                        email.setText("");
                        sex.setSelectedIndex(-1);
                        dob.setText("");
                        pass.setText("");
                        passcon.setText("");
                        sq.setSelectedIndex(-1);
                        answer.setText("");
                        name.requestFocus();

                    } else {
                        JOptionPane.showMessageDialog(this, "Account Not Created");
                    }
// If the details are stored into MySQL table than account is created successfully.else account is not created.
                    // TODO add your handling code here:
                } catch (SQLException ex) {
                    Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Password Does not match or The Password is too Small");
                // If entered password is less than 5 characters error is displayed .
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please Enter valid Email Address");
            // If the entered Email ID doesnot contain @ sign error is displayed indicating invalid email ID.
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        name.setText("");
        age.setText("");
        email.setText("");
        sex.setSelectedIndex(-1);
        dob.setText("");
        pass.setText("");
        passcon.setText("");
        sq.setSelectedIndex(-1);
        answer.setText("");
        name.requestFocus();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void passconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passconActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passconActionPerformed

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void ageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ageActionPerformed

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
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Signup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField age;
    private javax.swing.JTextField answer;
    private javax.swing.JFormattedTextField dob;
    private javax.swing.JTextField email;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton8;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField name;
    private javax.swing.JTextField pass;
    private javax.swing.JTextField passcon;
    private javax.swing.JComboBox<String> sex;
    private javax.swing.JComboBox<String> sq;
    // End of variables declaration//GEN-END:variables
}
