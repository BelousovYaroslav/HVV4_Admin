/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hvv_admin4.panels;

import hvv_admin4.HVV_Admin4;
import hvv_admin4.steps.info.TechProcessStepCommon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import org.apache.log4j.Logger;

/**
 *
 * @author yaroslav
 */
public class PanelImpermeability extends javax.swing.JPanel {
    final HVV_Admin4 theApp;
    static Logger logger = Logger.getLogger(PanelImpermeability.class);
    
    /**
     * Creates new form PanelProcess
     */
    public PanelImpermeability( HVV_Admin4 app) {
        theApp = app;
        
        initComponents();
        
        
    }
    
    public void Init() {
        btnNext.setEnabled( false);
        new Timer( 1000, new ActionListener() {

            @Override
            public void actionPerformed( ActionEvent e) {
                javax.swing.Timer t = ( Timer) e.getSource();
                t.stop();
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
        btnNext = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 200)));
        setMaximumSize(new java.awt.Dimension(640, 440));
        setMinimumSize(new java.awt.Dimension(640, 440));
        setPreferredSize(new java.awt.Dimension(640, 440));
        setLayout(null);

        lblTitle.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitle.setText("<html>1.1 Подтвердите герметичность установки.</thml>");
        lblTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTitle);
        lblTitle.setBounds(10, 10, 620, 40);

        btnNext.setText("Приборы установлены герметично, продолжаем процесс");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        add(btnNext);
        btnNext.setBounds(10, 360, 620, 50);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        TechProcessStepCommon info = theApp.GetCommonStep( "001");
        info.SetStopDateAsCurrent();
        info.SetStopReportTitle( "Подтверждение герметичности установки");
        
        theApp.SetCurrentStep( 21);
        theApp.SetCurrentStepInProgress( false);
        
        theApp.m_ReportGenerator.Generate();
               
        theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep01.m_bCollapsed = true;
        theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.Reposition();
        theApp.m_pMainWnd.m_pnlMain.ScrollActiveStepToCenter();
        theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.SetStates();
        
        
        theApp.m_pMainWnd.m_pnlMain.setVisible( true);
        
        theApp.m_pMainWnd.m_pnlImpermeability.setVisible( false);
        
        
    }//GEN-LAST:event_btnNextActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNext;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}
