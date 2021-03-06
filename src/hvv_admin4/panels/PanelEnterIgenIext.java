/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hvv_admin4.panels;

import hvv_admin4.HVV_Admin4;
import hvv_admin4.HVV_Admin4Constants;
import hvv_admin4.steps.info.TechProcessCommentInfo;
import hvv_admin4.steps.info.TechProcessIgenIextProcessInfo;
import hvv_admin4.steps.info.TechProcessUacProcessInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import org.apache.log4j.Logger;

/**
 *
 * @author yaroslav
 */
public class PanelEnterIgenIext extends javax.swing.JPanel {
    final HVV_Admin4 theApp;
    static Logger logger = Logger.getLogger(PanelEnterIgenIext.class);
    
    final private double m_dbl_AICoefficient, m_dbl_TICoefficient;
    
    /**
     * Creates new form PanelProcess
     */
    public PanelEnterIgenIext( HVV_Admin4 app) {
        theApp = app;
        initComponents();
        
        switch( theApp.GetSelectedArm()) {
            case HVV_Admin4Constants.ARM1:
                m_dbl_AICoefficient = 1.1643;   m_dbl_TICoefficient = 0.9571;
            break;
            
            case HVV_Admin4Constants.ARM2:
                m_dbl_AICoefficient = 0.95;     m_dbl_TICoefficient = 0.968;
            break;
                
            case HVV_Admin4Constants.ARM3:
                m_dbl_AICoefficient = 0.9625;   m_dbl_TICoefficient = 0.9625;
            break;
                
            case HVV_Admin4Constants.ARM4:
                m_dbl_AICoefficient = 0.9623;   m_dbl_TICoefficient = 0.9563;
            break;
                
            default:
                m_dbl_AICoefficient = 1.;   m_dbl_TICoefficient = 1.;
        }
    }

    public void InitComponentsOnStart() {
        switch( theApp.GetCurrentStep()) {
            case 82:
                lblTitle.setText( "<html><u>5.1 Замеры параметров. Токи генерации и погасания.</u></html>");
            break;
            case 182:
                lblTitle.setText( "<html><u>10.2 Замеры параметров. Токи генерации и погасания.</u></html>");
            break;
        }
        
        edtIextA.setText("");
        lblValueIextA.setText( "0.00 mA ");
        
        edtIextT.setText("");
        lblValueIextT.setText( "0.00 mA ");
        
        
        
        edtIgenA.setText("");
        lblValueIgenA.setText( "<html>&lt; I<sub>погас.</sub></html>");
        
        edtIgenT.setText("");
        lblValueIgenT.setText( "<html>&lt; I<sub>погас.</sub></html>");
        
        btnNext.setEnabled( false);
        new  Timer( 1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                (( Timer) e.getSource()).stop();
                btnNext.setEnabled( true);
            }
        }).start();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblTitleIanode = new javax.swing.JLabel();
        lblTitleItubu = new javax.swing.JLabel();
        lblIgeneration = new javax.swing.JLabel();
        edtIgenA = new javax.swing.JTextField();
        lblEquIgenA = new javax.swing.JLabel();
        lblValueIgenA = new javax.swing.JLabel();
        edtIgenT = new javax.swing.JTextField();
        lblEquIgenT = new javax.swing.JLabel();
        lblValueIgenT = new javax.swing.JLabel();
        lblIextinction = new javax.swing.JLabel();
        edtIextA = new javax.swing.JTextField();
        lblEquIextA = new javax.swing.JLabel();
        lblValueIextA = new javax.swing.JLabel();
        edtIextT = new javax.swing.JTextField();
        lblEquIextT = new javax.swing.JLabel();
        lblValueIextT = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 200)));
        setMaximumSize(new java.awt.Dimension(640, 440));
        setMinimumSize(new java.awt.Dimension(640, 440));
        setPreferredSize(new java.awt.Dimension(640, 440));
        setLayout(null);

        lblTitle.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitle.setText("<html><u>5.1 Замеры параметров. Токи генерации и погасания.</u></thml>");
        add(lblTitle);
        lblTitle.setBounds(10, 10, 500, 60);

        lblTitleIanode.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        lblTitleIanode.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleIanode.setText("Ток на аноде");
        add(lblTitleIanode);
        lblTitleIanode.setBounds(60, 90, 230, 40);

        lblTitleItubu.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        lblTitleItubu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleItubu.setText("Ток на штенгеле");
        add(lblTitleItubu);
        lblTitleItubu.setBounds(290, 90, 220, 40);

        lblIgeneration.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        lblIgeneration.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIgeneration.setText("<html>I <sub>ген.</sub></html>");
        add(lblIgeneration);
        lblIgeneration.setBounds(10, 140, 50, 80);

        edtIgenA.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        edtIgenA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtIgenA.setNextFocusableComponent(edtIextA);
        edtIgenA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edtIgenAKeyReleased(evt);
            }
        });
        add(edtIgenA);
        edtIgenA.setBounds(60, 140, 80, 80);

        lblEquIgenA.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        lblEquIgenA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEquIgenA.setText("=");
        add(lblEquIgenA);
        lblEquIgenA.setBounds(140, 140, 20, 80);

        lblValueIgenA.setFont(new java.awt.Font("Cantarell", 0, 28)); // NOI18N
        lblValueIgenA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblValueIgenA.setText("<html>&lt; I<sub>погас.</sub></html>");
        add(lblValueIgenA);
        lblValueIgenA.setBounds(160, 140, 120, 80);

        edtIgenT.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        edtIgenT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtIgenT.setNextFocusableComponent(edtIextT);
        edtIgenT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edtIgenTKeyReleased(evt);
            }
        });
        add(edtIgenT);
        edtIgenT.setBounds(290, 140, 80, 80);

        lblEquIgenT.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        lblEquIgenT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEquIgenT.setText("=");
        add(lblEquIgenT);
        lblEquIgenT.setBounds(370, 140, 20, 80);

        lblValueIgenT.setFont(new java.awt.Font("Cantarell", 0, 28)); // NOI18N
        lblValueIgenT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblValueIgenT.setText("<html>&lt; I<sub>погас.</sub></html>");
        add(lblValueIgenT);
        lblValueIgenT.setBounds(390, 140, 120, 80);

        lblIextinction.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        lblIextinction.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIextinction.setText("<html>I<sub> пог.</sub></html>");
        add(lblIextinction);
        lblIextinction.setBounds(10, 260, 50, 80);

        edtIextA.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        edtIextA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtIextA.setNextFocusableComponent(edtIgenT);
        edtIextA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edtIextAKeyReleased(evt);
            }
        });
        add(edtIextA);
        edtIextA.setBounds(60, 260, 80, 80);

        lblEquIextA.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        lblEquIextA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEquIextA.setText("=");
        add(lblEquIextA);
        lblEquIextA.setBounds(140, 260, 20, 80);

        lblValueIextA.setFont(new java.awt.Font("Cantarell", 0, 28)); // NOI18N
        lblValueIextA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblValueIextA.setText("0.00 mA");
        add(lblValueIextA);
        lblValueIextA.setBounds(160, 260, 120, 80);

        edtIextT.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        edtIextT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtIextT.setNextFocusableComponent(btnNext);
        edtIextT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edtIextTKeyReleased(evt);
            }
        });
        add(edtIextT);
        edtIextT.setBounds(290, 260, 80, 80);

        lblEquIextT.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        lblEquIextT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEquIextT.setText("=");
        add(lblEquIextT);
        lblEquIextT.setBounds(370, 260, 20, 80);

        lblValueIextT.setFont(new java.awt.Font("Cantarell", 0, 28)); // NOI18N
        lblValueIextT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblValueIextT.setText("0.00 mA");
        add(lblValueIextT);
        lblValueIextT.setBounds(390, 260, 120, 80);

        btnNext.setText("Далее");
        btnNext.setNextFocusableComponent(edtIgenA);
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        add(btnNext);
        btnNext.setBounds(10, 380, 500, 50);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        //отмечаем окончание внесения пороговых токов
        TechProcessIgenIextProcessInfo info = ( TechProcessIgenIextProcessInfo)
                theApp.GetCommonStep( String.format( "%03d", theApp.GetCurrentStep()));
        info.SetStopDateAsCurrent( theApp.GetSettings().GetTimeZoneShift());
        //info.SetStopReportTitle( "");
        
        
        try {
            String strVal;
            if( edtIgenA.getText().isEmpty())
                info.Set_Igen_A( Double.NaN);
            else {
                strVal = lblValueIgenA.getText().replaceAll( " mA", "");
                strVal = strVal.replace( ',', '.');
                info.Set_Igen_A( new Double( strVal));
            }
            
            strVal = lblValueIextA.getText().replaceAll( " mA", "");
            strVal = strVal.replace( ',', '.');
            info.Set_Iext_A( new Double( strVal));
            
            
            if( edtIgenT.getText().isEmpty())
                info.Set_Igen_T( Double.NaN);
            else {
                strVal = lblValueIgenT.getText().replaceAll( " mA", "");
                strVal = strVal.replace( ',', '.');
                info.Set_Igen_T( new Double( strVal));
            }
            
            strVal = lblValueIextT.getText().replaceAll( " mA", "");
            strVal = strVal.replace( ',', '.');
            info.Set_Iext_T( new Double( strVal));
            
        } catch( NumberFormatException ex) {
            logger.warn( "Поймали NumberFormatException при вводе токов генерации и погасания", ex);
            return;
        }
        
        // 5.1 = 81  -->   5.2 = 82
        //10.2 = 182 -->  10.3 = 183
        theApp.SetCurrentStep( theApp.GetCurrentStep() + 1);
        
        theApp.m_ReportGenerator.Generate();
        
        TechProcessUacProcessInfo info2 = new TechProcessUacProcessInfo();
        info2.SetStartDateAsCurrent( theApp.GetSettings().GetTimeZoneShift());
        info2.SetStartReportTitle( "Снятие вольт-амперной характеристики");
        theApp.SaveStepInfo( String.format( "%03d", theApp.GetCurrentStep()), info2, true);
        
        theApp.m_pMainWnd.m_pnlEnterCVC.InitComponentsOnStart();
        theApp.m_pMainWnd.m_pnlEnterCVC.setVisible( true);
        
        theApp.m_pMainWnd.m_pnlEnterIgenIext.setVisible( false);
        
    }//GEN-LAST:event_btnNextActionPerformed

    private void edtIgenAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtIgenAKeyReleased
        if( edtIgenA.getText().isEmpty()) {
            lblValueIgenA.setText( "<html>&lt; I<sub>погас.</sub></html>");
        }
        else {
            double dblVal = 0;
            String strVal = edtIgenA.getText();
            strVal = strVal.replace( ',', '.');
            try { dblVal = Double.parseDouble( strVal); }
            catch( NumberFormatException ex) {  }
            lblValueIgenA.setText( "" + String.format( "%.2f", dblVal * m_dbl_AICoefficient) + " mA");
        }
    }//GEN-LAST:event_edtIgenAKeyReleased

    private void edtIgenTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtIgenTKeyReleased
        if( edtIgenT.getText().isEmpty()) {
            lblValueIgenT.setText( "<html>&lt; I<sub>погас.</sub></html>");
        }
        else {
            double dblVal = 0;
            String strVal = edtIgenT.getText();
            strVal = strVal.replace( ',', '.');
            try { dblVal = Double.parseDouble( strVal); }
            catch( NumberFormatException ex) {  }
            lblValueIgenT.setText( "" + String.format( "%.2f", dblVal * m_dbl_TICoefficient) + " mA");
        }
    }//GEN-LAST:event_edtIgenTKeyReleased

    private void edtIextAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtIextAKeyReleased
        double dblVal = 0;
        String strVal = edtIextA.getText();
        strVal = strVal.replace( ',', '.');
        try { dblVal = Double.parseDouble( strVal); }
        catch( NumberFormatException ex) {  }
        lblValueIextA.setText( "" + String.format( "%.2f", dblVal * m_dbl_AICoefficient) + " mA");
    }//GEN-LAST:event_edtIextAKeyReleased

    private void edtIextTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtIextTKeyReleased
        double dblVal = 0;
        String strVal = edtIextT.getText();
        strVal = strVal.replace( ',', '.');
        try { dblVal = Double.parseDouble( strVal); }
        catch( NumberFormatException ex) {  }
        lblValueIextT.setText( "" + String.format( "%.2f", dblVal * m_dbl_TICoefficient) + " mA");
    }//GEN-LAST:event_edtIextTKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNext;
    public javax.swing.JTextField edtIextA;
    public javax.swing.JTextField edtIextT;
    public javax.swing.JTextField edtIgenA;
    public javax.swing.JTextField edtIgenT;
    private javax.swing.JLabel lblEquIextA;
    private javax.swing.JLabel lblEquIextT;
    private javax.swing.JLabel lblEquIgenA;
    private javax.swing.JLabel lblEquIgenT;
    private javax.swing.JLabel lblIextinction;
    private javax.swing.JLabel lblIgeneration;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitleIanode;
    private javax.swing.JLabel lblTitleItubu;
    private javax.swing.JLabel lblValueIextA;
    private javax.swing.JLabel lblValueIextT;
    private javax.swing.JLabel lblValueIgenA;
    private javax.swing.JLabel lblValueIgenT;
    // End of variables declaration//GEN-END:variables
}
