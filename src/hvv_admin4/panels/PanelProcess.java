/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hvv_admin4.panels;

import hvv_admin4.HVV_Admin4;
import hvv_admin4.planner.PlannerItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JPanel;
import javax.swing.Timer;
import org.apache.log4j.Logger;

/**
 *
 * @author yaroslav
 */
public class PanelProcess extends javax.swing.JPanel {
    final HVV_Admin4 theApp;
    
    final PanelStep01 m_pnlStep01;
    final PanelStep02 m_pnlStep02;
    final PanelStep03 m_pnlStep03;
    final PanelStep04 m_pnlStep04;
    final PanelStep05 m_pnlStep05;
    final PanelStep06 m_pnlStep06;
    final PanelStep07 m_pnlStep07;
    final PanelStep08 m_pnlStep08;
    final PanelStep09 m_pnlStep09;
    final PanelStep10 m_pnlStep10;
    
    static Logger logger = Logger.getLogger( PanelProcess.class);
    
    /**
     * Creates new form PanelProcess
     */
    public PanelProcess( HVV_Admin4 app) {
        theApp = app;
        
        initComponents();
        
        m_pnlStep01 = new PanelStep01( app);
        add( m_pnlStep01);
        m_pnlStep01.setVisible( true);
        
        m_pnlStep02 = new PanelStep02( app);
        add( m_pnlStep02);
        m_pnlStep02.setVisible( true);
        
        m_pnlStep03 = new PanelStep03( app);
        add( m_pnlStep03);
        m_pnlStep03.setVisible( true);
        
        m_pnlStep04 = new PanelStep04( app);
        add( m_pnlStep04);
        m_pnlStep04.setVisible( true);
        
        m_pnlStep05 = new PanelStep05( app);
        add( m_pnlStep05);
        m_pnlStep05.setVisible( true);
        
        m_pnlStep06 = new PanelStep06( app);
        add( m_pnlStep06);
        m_pnlStep06.setVisible( true);
        
        m_pnlStep07 = new PanelStep07( app);
        add( m_pnlStep07);
        m_pnlStep07.setVisible( true);
        
        m_pnlStep08 = new PanelStep08( app);
        add( m_pnlStep08);
        m_pnlStep08.setVisible( true);
        
        m_pnlStep09 = new PanelStep09( app);
        add( m_pnlStep09);
        m_pnlStep09.setVisible( true);
        
        m_pnlStep10 = new PanelStep10( app);
        add( m_pnlStep10);
        m_pnlStep10.setVisible( true);
        
        SetStates();
        
        new Timer( 1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Timer t = ( Timer) e.getSource();
                if( theApp.m_pMainWnd != null)
                    if( theApp.m_pMainWnd.m_pnlMain != null) {
                        t.stop();
                        Reposition();
                    }
            }
        }).start();
    }

    public void SetStates() {
        m_pnlStep01.SetState();
        m_pnlStep02.SetState();
        m_pnlStep03.SetState();
        m_pnlStep04.SetState();
        m_pnlStep05.SetState();
        m_pnlStep06.SetState();
        m_pnlStep07.SetState();
        m_pnlStep08.SetState();
        m_pnlStep09.SetState();
        m_pnlStep10.SetState();
        
        boolean bPlannerFail = false;
        Date dtRunningDate = theApp.GetLocalDate();
        
        //FIRST STEP
        PlannerItem item = ( PlannerItem) theApp.GetPlanner().m_lstSteps.get( 0);
        dtRunningDate = item.ProcessIncrement( dtRunningDate);

        
        /*if( theApp.GetSettings().GetUsePlanner()) {
            for( int i=1; i<13; i++) {
                
                JLabel lblDtStart;
                JLabel lblTmStart;
                
                switch( i) {
                    case  1: lblDtStart =  pnlStep2.lbl_02_00_Date_start; lblTmStart =  pnlStep2.lbl_02_00_Time_start; break;
                    case  2: lblDtStart =  pnlStep3.lbl_03_00_Date_start; lblTmStart =  pnlStep3.lbl_03_00_Time_start; break;
                    case  3: lblDtStart =  pnlStep4.lbl_04_00_Date_start; lblTmStart =  pnlStep4.lbl_04_00_Time_start; break;
                    case  4: lblDtStart =  pnlStep5.lbl_05_00_Date_start; lblTmStart =  pnlStep5.lbl_05_00_Time_start; break;
                    case  5: lblDtStart =  pnlStep6.lbl_06_00_Date_start; lblTmStart =  pnlStep6.lbl_06_00_Time_start; break;
                    case  6: lblDtStart =  pnlStep7.lbl_07_00_Date_start; lblTmStart =  pnlStep7.lbl_07_00_Time_start; break;
                    case  7: lblDtStart =  pnlStep8.lbl_08_00_Date_start; lblTmStart =  pnlStep8.lbl_08_00_Time_start; break;
                    case  8: lblDtStart =  pnlStep9.lbl_09_00_Date_start; lblTmStart =  pnlStep9.lbl_09_00_Time_start; break;
                    case  9: lblDtStart = pnlStep10.lbl_10_00_Date_start; lblTmStart = pnlStep10.lbl_10_00_Time_start; break;
                    case 10: lblDtStart = pnlStep11.lbl_11_00_Date_start; lblTmStart = pnlStep11.lbl_11_00_Time_start; break;
                    case 11: lblDtStart = pnlStep12.lbl_12_00_Date_start; lblTmStart = pnlStep12.lbl_12_00_Time_start; break;
                    default: lblDtStart = pnlStep13.lbl_13_00_Date_start; lblTmStart = pnlStep13.lbl_13_00_Time_start; break;
                }
                
                if( theApp.GetCurrentStep() >= i * 20) {
                    lblDtStart.setForeground( null);
                    lblTmStart.setForeground( null);
                    
                    String strStep = String.format( "%03d", i * 20 + 1);
                    if( theApp.IsStepMapContainsKey( strStep)) {
                        TechProcessStepInfo info = theApp.GetStepInfo( strStep);
                        if( info.GetStartDate() != null)
                            dtRunningDate = info.GetStartDate();
                    }
                    
                }
                else {
                    
                    item = ( PlannerItem) theApp.GetPlanner().m_lstSteps.get( i);
                    
                    if( bPlannerFail != true)
                        if( item.Validation( dtRunningDate) != 0) bPlannerFail = true;
                    
                    dtRunningDate = item.ProcessIncrement( dtRunningDate);
                    
                    if( bPlannerFail) {
                        lblDtStart.setForeground( new Color( 230, 180, 180));
                        lblTmStart.setForeground( new Color( 230, 180, 180));
                        
                        lblDtStart.setText( theApp.strFormatDate( dtRunningDate));
                        lblTmStart.setText( theApp.strFormatTime( dtRunningDate));
                    }
                    else {
                        lblDtStart.setForeground( new Color( 180, 180, 180));
                        lblTmStart.setForeground( new Color( 180, 180, 180));
                        
                        lblDtStart.setText( theApp.strFormatDate( dtRunningDate));
                        lblTmStart.setText( theApp.strFormatTime( dtRunningDate));
                    }
                }
            }
        }*/
    }
    
    public int Reposition() {
        int y = 1;
        int nFlowHeight;
        
        for( int i=0; i < 10; i++) {
            
            JPanel pnl = null;
            boolean bCollapsed = true;
            int nMaximizedHeight = 0;
            
            switch( i) {
                case  0: pnl =  m_pnlStep01; bCollapsed = m_pnlStep01.m_bCollapsed; nMaximizedHeight =  m_pnlStep01.MAXIMIZED_HEIGHT; break;
                case  1: pnl =  m_pnlStep02; bCollapsed = m_pnlStep02.m_bCollapsed; nMaximizedHeight =  m_pnlStep02.MAXIMIZED_HEIGHT; break;
                case  2: pnl =  m_pnlStep03; bCollapsed = m_pnlStep03.m_bCollapsed; nMaximizedHeight =  m_pnlStep03.MAXIMIZED_HEIGHT; break;
                case  3: pnl =  m_pnlStep04; bCollapsed = m_pnlStep04.m_bCollapsed; nMaximizedHeight =  m_pnlStep04.MAXIMIZED_HEIGHT; break;
                case  4: pnl =  m_pnlStep05; bCollapsed = m_pnlStep05.m_bCollapsed; nMaximizedHeight =  m_pnlStep05.MAXIMIZED_HEIGHT; break;
                case  5: pnl =  m_pnlStep06; bCollapsed = m_pnlStep06.m_bCollapsed; nMaximizedHeight =  m_pnlStep06.MAXIMIZED_HEIGHT; break;
                case  6: pnl =  m_pnlStep07; bCollapsed = m_pnlStep07.m_bCollapsed; nMaximizedHeight =  m_pnlStep07.MAXIMIZED_HEIGHT; break;
                case  7: pnl =  m_pnlStep08; bCollapsed = m_pnlStep08.m_bCollapsed; nMaximizedHeight =  m_pnlStep08.MAXIMIZED_HEIGHT; break;
                case  8: pnl =  m_pnlStep09; bCollapsed = m_pnlStep09.m_bCollapsed; nMaximizedHeight =  m_pnlStep09.MAXIMIZED_HEIGHT; break;
                case  9: pnl =  m_pnlStep10; bCollapsed = m_pnlStep10.m_bCollapsed; nMaximizedHeight =  m_pnlStep10.MAXIMIZED_HEIGHT; break;
            }
            
            if( pnl != null) {
                if( bCollapsed == true) nFlowHeight = 30;
                else nFlowHeight = nMaximizedHeight;
            
                pnl.setBounds( 1, 1, 580, nFlowHeight);
                pnl.setLocation( 1, y);
                
                y += nFlowHeight;
            }
        }
        
        y+=5;
        
        if( y <= 440) {
            theApp.m_pMainWnd.m_pnlMain.m_scrollBar.setEnabled( false);
            theApp.m_pMainWnd.m_pnlMain.m_scrollBar.setValue( 0);
            setBounds( 2, 2, 586, 430);
        }
        else {
            //logger.fatal( "theApp=" + theApp);
            //logger.fatal( "theApp.m_pMainWnd=" + theApp.m_pMainWnd);
            //logger.fatal( "theApp.m_pMainWnd.m_pnlMain=" + theApp.m_pMainWnd.m_pnlMain);
            //logger.fatal( "theApp.m_pMainWnd.m_pnlMain.m_scrollBar=" + theApp.m_pMainWnd.m_pnlMain.m_scrollBar);
            
            theApp.m_pMainWnd.m_pnlMain.m_scrollBar.setEnabled( true);
            theApp.m_pMainWnd.m_pnlMain.m_scrollBar.setMaximum( y - 430);
        }
        logger.debug( "Y=" + y);
        return y;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 200)));
        setMaximumSize(new java.awt.Dimension(590, 440));
        setMinimumSize(new java.awt.Dimension(590, 440));
        setPreferredSize(new java.awt.Dimension(590, 440));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 588, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 438, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
