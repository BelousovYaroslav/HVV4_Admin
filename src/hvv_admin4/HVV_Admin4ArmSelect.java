/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hvv_admin4;

/**
 *
 * @author yaroslav
 */
public class HVV_Admin4ArmSelect extends javax.swing.JDialog {

    private int m_nArm;
    public int GetSelectedArm() { return m_nArm; }
    
    /**
     * Creates new form HVV_Admin4ArmSelect
     */
    public HVV_Admin4ArmSelect(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        m_nArm = HVV_Admin4Constants.ARM1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        radArm1 = new javax.swing.JRadioButton();
        radArm2 = new javax.swing.JRadioButton();
        radArm3 = new javax.swing.JRadioButton();
        radArm4 = new javax.swing.JRadioButton();
        btnNext = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Выбор рабочего места");
        setMaximumSize(new java.awt.Dimension(400, 400));
        setMinimumSize(new java.awt.Dimension(400, 400));
        setModal(true);
        setPreferredSize(new java.awt.Dimension(400, 400));
        setResizable(false);
        getContentPane().setLayout(null);

        buttonGroup1.add(radArm1);
        radArm1.setFont(new java.awt.Font("Cantarell", 0, 36)); // NOI18N
        radArm1.setSelected(true);
        radArm1.setText("РМ 1");
        radArm1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(100, 100, 100)));
        radArm1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        radArm1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        radArm1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radArm1ActionPerformed(evt);
            }
        });
        getContentPane().add(radArm1);
        radArm1.setBounds(0, 0, 200, 150);

        buttonGroup1.add(radArm2);
        radArm2.setFont(new java.awt.Font("Cantarell", 0, 36)); // NOI18N
        radArm2.setText("РМ 2");
        radArm2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(100, 100, 100)));
        radArm2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        radArm2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        radArm2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radArm2ActionPerformed(evt);
            }
        });
        getContentPane().add(radArm2);
        radArm2.setBounds(0, 150, 200, 150);

        buttonGroup1.add(radArm3);
        radArm3.setFont(new java.awt.Font("Cantarell", 0, 36)); // NOI18N
        radArm3.setText("РМ 3");
        radArm3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(100, 100, 100)));
        radArm3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        radArm3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        radArm3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radArm3ActionPerformed(evt);
            }
        });
        getContentPane().add(radArm3);
        radArm3.setBounds(200, 0, 200, 150);

        buttonGroup1.add(radArm4);
        radArm4.setFont(new java.awt.Font("Cantarell", 0, 36)); // NOI18N
        radArm4.setText("РМ 4");
        radArm4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        radArm4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        radArm4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        radArm4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radArm4ActionPerformed(evt);
            }
        });
        getContentPane().add(radArm4);
        radArm4.setBounds(200, 150, 200, 150);

        btnNext.setText("Далее");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        getContentPane().add(btnNext);
        btnNext.setBounds(140, 310, 130, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radArm1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radArm1ActionPerformed
        m_nArm = HVV_Admin4Constants.ARM1;
    }//GEN-LAST:event_radArm1ActionPerformed

    private void radArm2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radArm2ActionPerformed
        m_nArm = HVV_Admin4Constants.ARM2;
    }//GEN-LAST:event_radArm2ActionPerformed

    private void radArm3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radArm3ActionPerformed
        m_nArm = HVV_Admin4Constants.ARM3;
    }//GEN-LAST:event_radArm3ActionPerformed

    private void radArm4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radArm4ActionPerformed
        m_nArm = HVV_Admin4Constants.ARM4;
    }//GEN-LAST:event_radArm4ActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        dispose();
    }//GEN-LAST:event_btnNextActionPerformed

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
            java.util.logging.Logger.getLogger(HVV_Admin4ArmSelect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HVV_Admin4ArmSelect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HVV_Admin4ArmSelect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HVV_Admin4ArmSelect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                HVV_Admin4ArmSelect dialog = new HVV_Admin4ArmSelect(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNext;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton radArm1;
    private javax.swing.JRadioButton radArm2;
    private javax.swing.JRadioButton radArm3;
    private javax.swing.JRadioButton radArm4;
    // End of variables declaration//GEN-END:variables
}
