/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hvv_admin4.state;

/**
 *
 * @author yaroslav
 */
public class RestoreHvStep1 extends javax.swing.JDialog {

    /**
     * Creates new form RestoreHvStep
     */
    public RestoreHvStep1() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblStepStartedDtm = new javax.swing.JLabel();
        lblStepStartedDtm1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        lblStepStartedDtm.setText("<html>... и по рассчётам должен был бы закончиться 2018.09.01 17:00</html>");
        getContentPane().add(lblStepStartedDtm);
        lblStepStartedDtm.setBounds(10, 50, 380, 40);

        lblStepStartedDtm1.setText("<html>Этап \"3.1 Обработка в среде О2-Ne20. 2ой цикл.\" был начат 2018.01.09 16:30</html>");
        getContentPane().add(lblStepStartedDtm1);
        lblStepStartedDtm1.setBounds(10, 10, 380, 40);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(120, 210, 130, 60);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(120, 140, 130, 60);
        getContentPane().add(jTextField3);
        jTextField3.setBounds(260, 140, 130, 60);
        getContentPane().add(jTextField4);
        jTextField4.setBounds(260, 210, 130, 60);

        jLabel1.setText("<html>U<sub>на штенгеле</sub></html>");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 210, 100, 60);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("В начале");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(120, 120, 130, 15);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("В конце");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(260, 120, 130, 15);

        jLabel4.setText("<html>U<sub>на анод</sub></html>");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 140, 100, 60);
        getContentPane().add(jTextField5);
        jTextField5.setBounds(120, 390, 130, 60);
        getContentPane().add(jTextField6);
        jTextField6.setBounds(120, 320, 130, 60);
        getContentPane().add(jTextField7);
        jTextField7.setBounds(260, 320, 130, 60);
        getContentPane().add(jTextField8);
        jTextField8.setBounds(260, 390, 130, 60);

        jLabel5.setText("<html>U<sub>на штенгеле</sub></html>");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 390, 100, 60);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("В начале");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(120, 300, 130, 15);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("В конце");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(260, 300, 130, 15);

        jLabel8.setText("<html>U<sub>на анод</sub></html>");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(10, 320, 100, 60);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("обработка по коротким плечам");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(10, 280, 380, 15);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("обработка по длинному плечу");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(11, 100, 380, 15);

        jButton1.setText("Продолжить");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(10, 470, 380, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
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
            java.util.logging.Logger.getLogger(RestoreHvStep1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RestoreHvStep1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RestoreHvStep1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RestoreHvStep1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RestoreHvStep1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JTextField jTextField8;
    private javax.swing.JLabel lblStepStartedDtm;
    private javax.swing.JLabel lblStepStartedDtm1;
    // End of variables declaration//GEN-END:variables
}
