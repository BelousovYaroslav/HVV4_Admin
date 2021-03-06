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
public class PanelStep02 extends TechProcessStepPanelTemplate {
    public final int MAXIMIZED_HEIGHT = 120;
    
    /**
     * Creates new form PanelStep01
     */
    public PanelStep02( HVV_Admin4 app) {
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

        btn_02_01_Start = new javax.swing.JButton();
        btn_02_01_Next = new javax.swing.JButton();
        btn_02_02_Start = new javax.swing.JButton();
        btn_02_02_Next = new javax.swing.JButton();
        lbl_02_00_Date_start = new javax.swing.JLabel();
        lbl_02_00_Time_start = new javax.swing.JLabel();
        lbl_02_00_IcoStep = new javax.swing.JLabel();
        lbl_02_00_Title = new javax.swing.JLabel();
        lbl_02_00_Date_stop = new javax.swing.JLabel();
        lbl_02_00_Time_stop = new javax.swing.JLabel();
        lbl_02_01_Date_start = new javax.swing.JLabel();
        lbl_02_01_Time_start = new javax.swing.JLabel();
        lbl_02_01_Title = new javax.swing.JLabel();
        lbl_02_01_Date_stop = new javax.swing.JLabel();
        lbl_02_01_Time_stop = new javax.swing.JLabel();
        lbl_02_02_Date_start = new javax.swing.JLabel();
        lbl_02_02_Time_start = new javax.swing.JLabel();
        lbl_02_02_Title = new javax.swing.JLabel();
        lbl_02_02_Date_stop = new javax.swing.JLabel();
        lbl_02_02_Time_stop = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(580, 90));
        setMinimumSize(new java.awt.Dimension(580, 90));
        setPreferredSize(new java.awt.Dimension(460, 90));
        setLayout(null);

        btn_02_01_Start.setText("Старт");
        btn_02_01_Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_02_01_StartActionPerformed(evt);
            }
        });
        add(btn_02_01_Start);
        btn_02_01_Start.setBounds(0, 40, 90, 40);

        btn_02_01_Next.setText("Далее");
        add(btn_02_01_Next);
        btn_02_01_Next.setBounds(370, 40, 90, 40);

        btn_02_02_Start.setText("Старт");
        btn_02_02_Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_02_02_StartActionPerformed(evt);
            }
        });
        add(btn_02_02_Start);
        btn_02_02_Start.setBounds(0, 80, 90, 40);

        btn_02_02_Next.setText("Далее");
        add(btn_02_02_Next);
        btn_02_02_Next.setBounds(370, 80, 90, 40);

        lbl_02_00_Date_start.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_02_00_Date_start.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_02_00_Date_start.setText("-");
        add(lbl_02_00_Date_start);
        lbl_02_00_Date_start.setBounds(0, 0, 90, 20);

        lbl_02_00_Time_start.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_02_00_Time_start.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_02_00_Time_start.setText("-");
        add(lbl_02_00_Time_start);
        lbl_02_00_Time_start.setBounds(0, 20, 90, 20);

        lbl_02_00_IcoStep.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_02_00_IcoStep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_02_00_IcoStepMouseClicked(evt);
            }
        });
        add(lbl_02_00_IcoStep);
        lbl_02_00_IcoStep.setBounds(90, 0, 30, 40);

        lbl_02_00_Title.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_02_00_Title.setText("<html>2. Обработка в среде O<sub>2</sub></html>");
        lbl_02_00_Title.setOpaque(true);
        add(lbl_02_00_Title);
        lbl_02_00_Title.setBounds(120, 0, 250, 40);

        lbl_02_00_Date_stop.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_02_00_Date_stop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_02_00_Date_stop.setText("-");
        add(lbl_02_00_Date_stop);
        lbl_02_00_Date_stop.setBounds(370, 0, 90, 20);

        lbl_02_00_Time_stop.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_02_00_Time_stop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_02_00_Time_stop.setText("-");
        add(lbl_02_00_Time_stop);
        lbl_02_00_Time_stop.setBounds(370, 20, 90, 20);

        lbl_02_01_Date_start.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_02_01_Date_start.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_02_01_Date_start.setText("-");
        add(lbl_02_01_Date_start);
        lbl_02_01_Date_start.setBounds(0, 40, 90, 20);

        lbl_02_01_Time_start.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_02_01_Time_start.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_02_01_Time_start.setText("-");
        add(lbl_02_01_Time_start);
        lbl_02_01_Time_start.setBounds(0, 60, 90, 20);

        lbl_02_01_Title.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_02_01_Title.setText("2.1 Обработка. 1ый цикл");
        lbl_02_01_Title.setOpaque(true);
        add(lbl_02_01_Title);
        lbl_02_01_Title.setBounds(120, 40, 250, 40);

        lbl_02_01_Date_stop.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_02_01_Date_stop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_02_01_Date_stop.setText("-");
        add(lbl_02_01_Date_stop);
        lbl_02_01_Date_stop.setBounds(370, 40, 90, 20);

        lbl_02_01_Time_stop.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_02_01_Time_stop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_02_01_Time_stop.setText("-");
        add(lbl_02_01_Time_stop);
        lbl_02_01_Time_stop.setBounds(370, 60, 90, 20);

        lbl_02_02_Date_start.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_02_02_Date_start.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_02_02_Date_start.setText("-");
        add(lbl_02_02_Date_start);
        lbl_02_02_Date_start.setBounds(0, 80, 90, 20);

        lbl_02_02_Time_start.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_02_02_Time_start.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_02_02_Time_start.setText("-");
        add(lbl_02_02_Time_start);
        lbl_02_02_Time_start.setBounds(0, 100, 90, 20);

        lbl_02_02_Title.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_02_02_Title.setText("2.2 Обработка. 2ой цикл.");
        lbl_02_02_Title.setOpaque(true);
        add(lbl_02_02_Title);
        lbl_02_02_Title.setBounds(120, 80, 250, 40);

        lbl_02_02_Date_stop.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_02_02_Date_stop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_02_02_Date_stop.setText("-");
        add(lbl_02_02_Date_stop);
        lbl_02_02_Date_stop.setBounds(370, 80, 90, 20);

        lbl_02_02_Time_stop.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_02_02_Time_stop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_02_02_Time_stop.setText("-");
        add(lbl_02_02_Time_stop);
        lbl_02_02_Time_stop.setBounds(370, 100, 90, 20);
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_02_00_IcoStepMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_02_00_IcoStepMouseClicked
        CollapseClick( 1);
    }//GEN-LAST:event_lbl_02_00_IcoStepMouseClicked

    private void btn_02_01_StartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_02_01_StartActionPerformed
        theApp.SetCurrentStep( 21);

        theApp.m_pMainWnd.m_pnlPuffMessage.Init();
        theApp.m_pMainWnd.m_pnlPuffMessage.setVisible( true);
        theApp.m_pMainWnd.m_pnlMain.setVisible( false);
    }//GEN-LAST:event_btn_02_01_StartActionPerformed

    private void btn_02_02_StartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_02_02_StartActionPerformed
        theApp.SetCurrentStep( 22);

        theApp.m_pMainWnd.m_pnlPuffMessage.Init();
        theApp.m_pMainWnd.m_pnlPuffMessage.setVisible( true);
        theApp.m_pMainWnd.m_pnlMain.setVisible( false);
    }//GEN-LAST:event_btn_02_02_StartActionPerformed


    public void SetState() {
        
        //2. Обработка в среде кислорода
        boolean bStart = false;
        boolean bStop = false;
        
        if( theApp.IsStepMapContainsKey( "021")) {
            TechProcessStepCommon info = theApp.GetCommonStep( "021");
            
            if( info.GetStartDate() != null) {
                lbl_02_00_Date_start.setText( theApp.strFormatDate( info.GetStartDate()));
                lbl_02_00_Time_start.setText( theApp.strFormatTime( info.GetStartDate()));
                bStart = true;
            }
        }
        
        if( theApp.IsStepMapContainsKey( "022")) {
            TechProcessStepCommon info = theApp.GetCommonStep( "022");
            if( info.GetStopDate() != null) {
                lbl_02_00_Date_stop.setText( theApp.strFormatDate( info.GetStopDate()));
                lbl_02_00_Time_stop.setText( theApp.strFormatTime( info.GetStopDate()));
                bStop = true;
            }
        }
        
        
        if( bStart == false) {
            lbl_02_00_Date_start.setText( "-");
            lbl_02_00_Time_start.setText( "-");
        }
        
        if( bStop == false) {
            lbl_02_00_Date_stop.setText( "-");
            lbl_02_00_Time_stop.setText( "-");
        }
        
        lbl_02_00_IcoStep.setIcon( m_bCollapsed ? theApp.GetResources().getIconTriaRight() : theApp.GetResources().getIconTriaDown());
        
        lbl_02_00_Title.setEnabled( theApp.GetCurrentStep() < 40);
        if( 20 < theApp.GetCurrentStep() && theApp.GetCurrentStep() < 40) {
            lbl_02_00_Title.setFont( theApp.GetBoldFont());
            m_bCollapsed = false;
        }
        else {
            lbl_02_00_Title.setFont( theApp.GetUsualFont());
        }
        
        if( m_bCollapsed == false) {
            //2.1 Обработка. 1ый цикл
            FillStepDates( "021", lbl_02_01_Date_start, lbl_02_01_Time_start, lbl_02_01_Date_stop, lbl_02_01_Time_stop);
            lbl_02_01_Title.setFont( theApp.GetCurrentStep() == 21 ? theApp.GetBoldFont() : theApp.GetUsualFont());
            lbl_02_01_Title.setBackground(theApp.GetCurrentStep() == 21 ? new Color( 240, 230, 230) : null);
            lbl_02_01_Title.setEnabled( theApp.GetCurrentStep() <= 21);
            btn_02_01_Start.setVisible( theApp.GetCurrentStep() == 21 && !theApp.IsCurrentStepInProgress());
            btn_02_01_Next.setVisible(  theApp.GetCurrentStep() == 21 &&  theApp.IsCurrentStepInProgress());
            
            //2.2 Ввод напряжений 1-го цикла процесса обработки O2
            FillStepDates( "022", lbl_02_02_Date_start, lbl_02_02_Time_start, lbl_02_02_Date_stop, lbl_02_02_Time_stop);
            lbl_02_02_Title.setFont( theApp.GetCurrentStep() == 22 ? theApp.GetBoldFont() : theApp.GetUsualFont());
            lbl_02_02_Title.setBackground(theApp.GetCurrentStep() == 22 ? new Color( 240, 230, 230) : null);
            lbl_02_02_Title.setEnabled( theApp.GetCurrentStep() <= 22);
            btn_02_02_Start.setVisible( theApp.GetCurrentStep() == 22 && !theApp.IsCurrentStepInProgress());
            btn_02_02_Next.setVisible(  theApp.GetCurrentStep() == 22 &&  theApp.IsCurrentStepInProgress());
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_02_01_Next;
    public javax.swing.JButton btn_02_01_Start;
    public javax.swing.JButton btn_02_02_Next;
    public javax.swing.JButton btn_02_02_Start;
    public javax.swing.JLabel lbl_02_00_Date_start;
    public javax.swing.JLabel lbl_02_00_Date_stop;
    public javax.swing.JLabel lbl_02_00_IcoStep;
    public javax.swing.JLabel lbl_02_00_Time_start;
    public javax.swing.JLabel lbl_02_00_Time_stop;
    public javax.swing.JLabel lbl_02_00_Title;
    public javax.swing.JLabel lbl_02_01_Date_start;
    public javax.swing.JLabel lbl_02_01_Date_stop;
    public javax.swing.JLabel lbl_02_01_Time_start;
    public javax.swing.JLabel lbl_02_01_Time_stop;
    public javax.swing.JLabel lbl_02_01_Title;
    public javax.swing.JLabel lbl_02_02_Date_start;
    public javax.swing.JLabel lbl_02_02_Date_stop;
    public javax.swing.JLabel lbl_02_02_Time_start;
    public javax.swing.JLabel lbl_02_02_Time_stop;
    public javax.swing.JLabel lbl_02_02_Title;
    // End of variables declaration//GEN-END:variables
}
