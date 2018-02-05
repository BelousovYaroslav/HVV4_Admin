/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hvv_admin4;

import hvv_admin4.panels.PanelActivation;
import hvv_admin4.panels.PanelDegasation;
import hvv_admin4.panels.PanelEnterCVC;
import hvv_admin4.panels.PanelEnterComment;
import hvv_admin4.panels.PanelEnterGetterInfo;
import hvv_admin4.panels.PanelEnterIgenIext;
import hvv_admin4.panels.PanelEnterSerial;
import hvv_admin4.panels.PanelEnterStartFinishVoltage;
import hvv_admin4.panels.PanelImpermeability;
import hvv_admin4.panels.PanelMain;
import hvv_admin4.panels.PanelMessage;
import hvv_admin4.panels.PanelPuffMessage;
import hvv_admin4.panels.PanelSetThermoProcessingFinishTime;
import hvv_admin4.panels.PanelTimer;
import javax.swing.JOptionPane;

/**
 *
 * @author yaroslav
 */
public class HVV_Admin4MainFrame extends javax.swing.JFrame {
    final private HVV_Admin4 theApp;
    
    final public PanelMain m_pnlMain;
    final public PanelEnterStartFinishVoltage m_pnlEnterHvVoltage;
    final public PanelTimer m_pnlStopWatch;
    final public PanelEnterSerial m_pnlEnterSerial;
    final public PanelImpermeability m_pnlImpermeability;
    final public PanelSetThermoProcessingFinishTime m_pnlSetThermoProcessingFinishTime;
    final public PanelEnterGetterInfo m_pnlEnterGetterInfo;
    final public PanelEnterCVC m_pnlEnterCVC;
    final public PanelEnterIgenIext m_pnlEnterIgenIext;
    final public PanelEnterComment m_pnlEnterComment;
    final public PanelDegasation m_pnlDegasation;
    final public PanelActivation m_pnlActivation;
    final public PanelMessage m_pnlFinalMessage;
    final public PanelPuffMessage m_pnlPuffMessage;
    
    /**
     * Creates new form HVV_Admin4MainFrame
     */
    public HVV_Admin4MainFrame( HVV_Admin4 app) {
        theApp = app;
        initComponents();
        String strTitle = "4х ЭВО, ";
        
        switch( theApp.GetSelectedArm()) {
            case HVV_Admin4Constants.ARM1: strTitle += "РМ1, "; break;
            case HVV_Admin4Constants.ARM2: strTitle += "РМ2, "; break;
            case HVV_Admin4Constants.ARM3: strTitle += "РМ3, "; break;
            case HVV_Admin4Constants.ARM4: strTitle += "РМ4, "; break;
        }
        
        strTitle += theApp.GetSerial();
        if( theApp.GetProcessedDeviceType() == HVV_Admin4Constants.DEVICE_SMALL) {
            if( !theApp.GetSerial().contains( "(м)"))
                strTitle += " (м)";
        }
        strTitle += ",     v 2017.12.28 17:30, (С) ФЛАВТ, 2017.";
        setTitle( strTitle);
        
        m_pnlMain = new PanelMain( theApp);
        pnlMainView.add( m_pnlMain);
        m_pnlMain.setBounds( 2, 2, 635, 456);
        m_pnlMain.setVisible( true);
        
        m_pnlEnterSerial = new PanelEnterSerial( app);
        pnlMainView.add( m_pnlEnterSerial);
        m_pnlEnterSerial.setBounds( 2, 2, 635, 456);
        m_pnlEnterSerial.setVisible( false);
        
        m_pnlEnterHvVoltage = new PanelEnterStartFinishVoltage( app);
        pnlMainView.add( m_pnlEnterHvVoltage);
        m_pnlEnterHvVoltage.setBounds( 2, 2, 635, 456);
        m_pnlEnterHvVoltage.setVisible( false);
        
        m_pnlStopWatch = new PanelTimer( app);
        pnlMainView.add( m_pnlStopWatch);
        m_pnlStopWatch.setBounds( 2, 2, 635, 456);
        m_pnlStopWatch.setVisible( false);
        
        m_pnlImpermeability = new PanelImpermeability( app);
        pnlMainView.add( m_pnlImpermeability);
        m_pnlImpermeability.setBounds( 2, 2, 635, 456);
        m_pnlImpermeability.setVisible( false);
        
        m_pnlSetThermoProcessingFinishTime = new PanelSetThermoProcessingFinishTime( app);
        pnlMainView.add( m_pnlSetThermoProcessingFinishTime);
        m_pnlSetThermoProcessingFinishTime.setBounds( 2, 2, 635, 456);
        m_pnlSetThermoProcessingFinishTime.setVisible( false);
        
        m_pnlEnterGetterInfo = new PanelEnterGetterInfo(app);
        pnlMainView.add( m_pnlEnterGetterInfo);
        m_pnlEnterGetterInfo.setBounds( 2, 2, 635, 456);
        m_pnlEnterGetterInfo.setVisible( false);
        
        m_pnlEnterCVC = new PanelEnterCVC(app);
        pnlMainView.add( m_pnlEnterCVC);
        m_pnlEnterCVC.setBounds( 2, 2, 635, 456);
        m_pnlEnterCVC.setVisible( false);
        
        m_pnlEnterIgenIext = new PanelEnterIgenIext( app);
        pnlMainView.add( m_pnlEnterIgenIext);
        m_pnlEnterIgenIext.setBounds( 2, 2, 635, 456);
        m_pnlEnterIgenIext.setVisible( false);
        
        m_pnlEnterComment = new PanelEnterComment(app);
        pnlMainView.add( m_pnlEnterComment);
        m_pnlEnterComment.setBounds( 2, 2, 635, 456);
        m_pnlEnterComment.setVisible( false);
        
        m_pnlDegasation = new PanelDegasation(app);
        pnlMainView.add( m_pnlDegasation);
        m_pnlDegasation.setBounds( 2, 2, 635, 456);
        m_pnlDegasation.setVisible( false);
        
        m_pnlActivation = new PanelActivation(app);
        pnlMainView.add( m_pnlActivation);
        m_pnlActivation.setBounds( 2, 2, 635, 456);
        m_pnlActivation.setVisible( false);
        
        m_pnlFinalMessage = new PanelMessage(app);
        pnlMainView.add( m_pnlFinalMessage);
        m_pnlFinalMessage.setBounds( 2, 2, 635, 456);
        m_pnlFinalMessage.setVisible( false);
        
        m_pnlPuffMessage = new PanelPuffMessage(app);
        pnlMainView.add( m_pnlPuffMessage);
        m_pnlPuffMessage.setBounds( 2, 2, 635, 456);
        m_pnlPuffMessage.setVisible( false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMainView = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(660, 510));
        setMinimumSize(new java.awt.Dimension(660, 510));
        setPreferredSize(new java.awt.Dimension(660, 510));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        pnlMainView.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        pnlMainView.setMaximumSize(new java.awt.Dimension(640, 460));
        pnlMainView.setMinimumSize(new java.awt.Dimension(640, 460));
        pnlMainView.setPreferredSize(new java.awt.Dimension(640, 460));

        javax.swing.GroupLayout pnlMainViewLayout = new javax.swing.GroupLayout(pnlMainView);
        pnlMainView.setLayout(pnlMainViewLayout);
        pnlMainViewLayout.setHorizontalGroup(
            pnlMainViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 638, Short.MAX_VALUE)
        );
        pnlMainViewLayout.setVerticalGroup(
            pnlMainViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 458, Short.MAX_VALUE)
        );

        getContentPane().add(pnlMainView);
        pnlMainView.setBounds(10, 10, 640, 460);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if( HVV_Admin4.MessageBoxAskYesNo( "Вы уверены что вы хотите выйти?", "ADMIN4") == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_formWindowClosing

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnlMainView;
    // End of variables declaration//GEN-END:variables
}
