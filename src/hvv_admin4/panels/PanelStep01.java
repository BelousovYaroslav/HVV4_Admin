/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hvv_admin4.panels;

import hvv_admin4.HVV_Admin4;
import hvv_admin4.steps.info.TechProcessStepCommon;
import java.awt.Color;

/**
 *
 * @author yaroslav
 */
public class PanelStep01 extends TechProcessStepPanelTemplate {
    public final int MAXIMIZED_HEIGHT = 80;
    
    /**
     * Creates new form PanelStep01
     */
    public PanelStep01( HVV_Admin4 app) {
        theApp = app;
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

        btn_01_01_Start = new javax.swing.JButton();
        btn_01_01_Next = new javax.swing.JButton();
        lbl_01_00_Date_start = new javax.swing.JLabel();
        lbl_01_00_Time_start = new javax.swing.JLabel();
        lbl_01_00_IcoStep = new javax.swing.JLabel();
        lbl_01_00_Title = new javax.swing.JLabel();
        lbl_01_00_Date_stop = new javax.swing.JLabel();
        lbl_01_00_Time_stop = new javax.swing.JLabel();
        lbl_01_01_Date_start = new javax.swing.JLabel();
        lbl_01_01_Time_start = new javax.swing.JLabel();
        lbl_01_01_Title = new javax.swing.JLabel();
        lbl_01_01_Date_stop = new javax.swing.JLabel();
        lbl_01_01_Time_stop = new javax.swing.JLabel();

        setLayout(null);

        btn_01_01_Start.setText("Старт");
        btn_01_01_Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_01_01_StartActionPerformed(evt);
            }
        });
        add(btn_01_01_Start);
        btn_01_01_Start.setBounds(0, 40, 90, 40);

        btn_01_01_Next.setText("Далее");
        btn_01_01_Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_01_01_NextActionPerformed(evt);
            }
        });
        add(btn_01_01_Next);
        btn_01_01_Next.setBounds(370, 40, 90, 40);

        lbl_01_00_Date_start.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_01_00_Date_start.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_01_00_Date_start.setText("-");
        add(lbl_01_00_Date_start);
        lbl_01_00_Date_start.setBounds(0, 0, 90, 20);

        lbl_01_00_Time_start.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_01_00_Time_start.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_01_00_Time_start.setText("-");
        add(lbl_01_00_Time_start);
        lbl_01_00_Time_start.setBounds(0, 20, 90, 20);

        lbl_01_00_IcoStep.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_01_00_IcoStep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_01_00_IcoStepMouseClicked(evt);
            }
        });
        add(lbl_01_00_IcoStep);
        lbl_01_00_IcoStep.setBounds(90, 0, 30, 40);

        lbl_01_00_Title.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_01_00_Title.setText("<html>1. Установка и откачка прибора</html>");
        lbl_01_00_Title.setOpaque(true);
        add(lbl_01_00_Title);
        lbl_01_00_Title.setBounds(120, 0, 250, 40);

        lbl_01_00_Date_stop.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_01_00_Date_stop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_01_00_Date_stop.setText("-");
        add(lbl_01_00_Date_stop);
        lbl_01_00_Date_stop.setBounds(370, 0, 90, 20);

        lbl_01_00_Time_stop.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_01_00_Time_stop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_01_00_Time_stop.setText("-");
        add(lbl_01_00_Time_stop);
        lbl_01_00_Time_stop.setBounds(370, 20, 90, 20);

        lbl_01_01_Date_start.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_01_01_Date_start.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_01_01_Date_start.setText("-");
        add(lbl_01_01_Date_start);
        lbl_01_01_Date_start.setBounds(0, 40, 90, 20);

        lbl_01_01_Time_start.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_01_01_Time_start.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_01_01_Time_start.setText("-");
        add(lbl_01_01_Time_start);
        lbl_01_01_Time_start.setBounds(0, 60, 90, 20);

        lbl_01_01_Title.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_01_01_Title.setText("1.1 Подготовка прибора");
        lbl_01_01_Title.setOpaque(true);
        add(lbl_01_01_Title);
        lbl_01_01_Title.setBounds(120, 40, 250, 40);

        lbl_01_01_Date_stop.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_01_01_Date_stop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_01_01_Date_stop.setText("-");
        add(lbl_01_01_Date_stop);
        lbl_01_01_Date_stop.setBounds(370, 40, 90, 20);

        lbl_01_01_Time_stop.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_01_01_Time_stop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_01_01_Time_stop.setText("-");
        add(lbl_01_01_Time_stop);
        lbl_01_01_Time_stop.setBounds(370, 60, 90, 20);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_01_01_StartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_01_01_StartActionPerformed
        //theApp.m_pMainWnd.m_pnlDegasation.setVisible( true);
        //theApp.m_pMainWnd.m_pnlMain.setVisible( false);



        //мы начинаем процесс
        TechProcessStepCommon info = new TechProcessStepCommon();
        info.SetStartDateAsCurrent( theApp.GetSettings().GetTimeZoneShift());
        info.SetStartReportTitle( "Установка и откачка приборов");
        theApp.SaveStepInfo( "001", info, true);
        theApp.SetCurrentStep( 1);
        
        theApp.m_ReportGenerator.Generate();
        
        theApp.SetCurrentStepInProgress( true);
        
        SetState();
        theApp.m_pMainWnd.m_pnlEnterSerial.setVisible( true);
        theApp.m_pMainWnd.m_pnlMain.setVisible( false);
        
    }//GEN-LAST:event_btn_01_01_StartActionPerformed

    private void btn_01_01_NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_01_01_NextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_01_01_NextActionPerformed

    private void lbl_01_00_IcoStepMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_01_00_IcoStepMouseClicked
        CollapseClick( 0);
    }//GEN-LAST:event_lbl_01_00_IcoStepMouseClicked


    public void SetState() {
        
        //1. Заполнение рабочей камеры азотом
        boolean bStart = false;
        boolean bStop = false;
        
        if( theApp.IsStepMapContainsKey( "001")) {
            TechProcessStepCommon info = theApp.GetCommonStep( "001");
            
            if( info.GetStartDate() != null) {
                lbl_01_00_Date_start.setText( theApp.strFormatDate( info.GetStartDate()));
                lbl_01_00_Time_start.setText( theApp.strFormatTime( info.GetStartDate()));
                bStart = true;
            }
            
            
            if( info.GetStopDate() != null) {
                lbl_01_00_Date_stop.setText( theApp.strFormatDate( info.GetStopDate()));
                lbl_01_00_Time_stop.setText( theApp.strFormatTime( info.GetStopDate()));
                bStop = true;
            }
        }
        
        if( bStart == false) {
            lbl_01_00_Date_start.setText( "-");
            lbl_01_00_Time_start.setText( "-");
        }
        
        if( bStop == false) {
            lbl_01_00_Date_stop.setText( "-");
            lbl_01_00_Time_stop.setText( "-");
        }
        
        lbl_01_00_IcoStep.setIcon( m_bCollapsed ? theApp.GetResources().getIconTriaRight() : theApp.GetResources().getIconTriaDown());
        
        lbl_01_00_Title.setEnabled( theApp.GetCurrentStep() < 20);
        if( theApp.GetCurrentStep() < 20) {
            lbl_01_00_Title.setFont( theApp.GetBoldFont());
            m_bCollapsed = false;
        }
        else {
            lbl_01_00_Title.setFont( theApp.GetUsualFont());
        }
        
        if( m_bCollapsed == false) {
            //1.1 Заполнение рабочей камеры азотом
            bStart = false;
            bStop = false;
        
            if( theApp.IsStepMapContainsKey( "001")) {
                TechProcessStepCommon info = theApp.GetCommonStep( "001");

                if( info.GetStartDate() != null) {
                    lbl_01_01_Date_start.setText( theApp.strFormatDate( info.GetStartDate()));
                    lbl_01_01_Time_start.setText( theApp.strFormatTime( info.GetStartDate()));
                    bStart = true;
                }


                if( info.GetStopDate() != null) {
                    lbl_01_01_Date_stop.setText( theApp.strFormatDate( info.GetStopDate()));
                    lbl_01_01_Time_stop.setText( theApp.strFormatTime( info.GetStopDate()));
                    bStop = true;
                }
                
            }

            if( bStart == false) {
                lbl_01_01_Date_start.setText( "-");
                lbl_01_01_Time_start.setText( "-");
            }

            if( bStop == false) {
                lbl_01_01_Date_stop.setText( "-");
                lbl_01_01_Time_stop.setText( "-");
            }

            /*
            if( theApp.GetCurrentStep() == 1 && theApp.m_pMainWnd.m_EmuTimer.isRunning())
                lblAnimation_01_01.setIcon( theApp.GetResources().getIconAnimatedProgress25());
            else
                lblAnimation_01_01.setIcon( null);
            */
            
            lbl_01_01_Title.setFont( theApp.GetCurrentStep() < 20 ? theApp.GetBoldFont() : theApp.GetUsualFont());
            lbl_01_01_Title.setBackground(theApp.GetCurrentStep() <= 1 ? new Color( 240, 230, 230) : null);
            lbl_01_01_Title.setEnabled( theApp.GetCurrentStep() < 20);

            //НАЧАЛЬНЫЙ ЭТАП
            if( theApp.GetCurrentStep() == 1) {
                btn_01_01_Start.setVisible( !theApp.IsCurrentStepInProgress());
                btn_01_01_Next.setVisible(  theApp.IsCurrentStepInProgress());
            }
            else {
                btn_01_01_Start.setVisible( false);
                btn_01_01_Next.setVisible(  false);
            }
        }
        else {
            btn_01_01_Start.setVisible( false);
            btn_01_01_Next.setVisible(  false);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_01_01_Next;
    public javax.swing.JButton btn_01_01_Start;
    public javax.swing.JLabel lbl_01_00_Date_start;
    public javax.swing.JLabel lbl_01_00_Date_stop;
    public javax.swing.JLabel lbl_01_00_IcoStep;
    public javax.swing.JLabel lbl_01_00_Time_start;
    public javax.swing.JLabel lbl_01_00_Time_stop;
    public javax.swing.JLabel lbl_01_00_Title;
    public javax.swing.JLabel lbl_01_01_Date_start;
    public javax.swing.JLabel lbl_01_01_Date_stop;
    public javax.swing.JLabel lbl_01_01_Time_start;
    public javax.swing.JLabel lbl_01_01_Time_stop;
    public javax.swing.JLabel lbl_01_01_Title;
    // End of variables declaration//GEN-END:variables
}
