/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hvv_admin4.panels;

import hvv_admin4.HVV_Admin4;
import hvv_admin4.steps.info.TechProcessStepCommon;

/**
 *
 * @author yaroslav
 */
public class PanelStep08 extends TechProcessStepPanelTemplate {
    public final int MAXIMIZED_HEIGHT = 150;
    
    /**
     * Creates new form PanelStep01
     */
    public PanelStep08( HVV_Admin4 app) {
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

        btn_08_01_Start = new javax.swing.JButton();
        btn_08_01_Next = new javax.swing.JButton();
        btn_08_02_Start = new javax.swing.JButton();
        btn_08_02_Next = new javax.swing.JButton();
        btn_08_03_Start = new javax.swing.JButton();
        btn_08_03_Next = new javax.swing.JButton();
        btn_08_04_Start = new javax.swing.JButton();
        btn_08_04_Next = new javax.swing.JButton();
        lbl_08_00_Date_start = new javax.swing.JLabel();
        lbl_08_00_Time_start = new javax.swing.JLabel();
        lbl_08_00_IcoStep = new javax.swing.JLabel();
        lbl_08_00_Title = new javax.swing.JLabel();
        lbl_08_00_Date_stop = new javax.swing.JLabel();
        lbl_08_00_Time_stop = new javax.swing.JLabel();
        lbl_08_01_Date_start = new javax.swing.JLabel();
        lbl_08_01_Time_start = new javax.swing.JLabel();
        lbl_08_01_Title = new javax.swing.JLabel();
        lbl_08_01_Date_stop = new javax.swing.JLabel();
        lbl_08_01_Time_stop = new javax.swing.JLabel();
        lbl_08_02_Date_start = new javax.swing.JLabel();
        lbl_08_02_Time_start = new javax.swing.JLabel();
        lbl_08_02_Title = new javax.swing.JLabel();
        lbl_08_02_Date_stop = new javax.swing.JLabel();
        lbl_08_02_Time_stop = new javax.swing.JLabel();
        lbl_08_03_Date_start = new javax.swing.JLabel();
        lbl_08_03_Time_start = new javax.swing.JLabel();
        lbl_08_03_Title = new javax.swing.JLabel();
        lbl_08_03_Date_stop = new javax.swing.JLabel();
        lbl_08_03_Time_stop = new javax.swing.JLabel();
        lbl_08_04_Date_start = new javax.swing.JLabel();
        lbl_08_04_Time_start = new javax.swing.JLabel();
        lbl_08_04_Title = new javax.swing.JLabel();
        lbl_08_04_Date_stop = new javax.swing.JLabel();
        lbl_08_04_Time_stop = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(580, 150));
        setMinimumSize(new java.awt.Dimension(580, 150));
        setName(""); // NOI18N
        setLayout(null);

        btn_08_01_Start.setText("Старт");
        btn_08_01_Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_08_01_StartActionPerformed(evt);
            }
        });
        add(btn_08_01_Start);
        btn_08_01_Start.setBounds(0, 29, 150, 30);

        btn_08_01_Next.setText("Далее");
        add(btn_08_01_Next);
        btn_08_01_Next.setBounds(430, 29, 150, 30);

        btn_08_02_Start.setText("Старт");
        btn_08_02_Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_08_02_StartActionPerformed(evt);
            }
        });
        add(btn_08_02_Start);
        btn_08_02_Start.setBounds(0, 59, 150, 30);

        btn_08_02_Next.setText("Далее");
        add(btn_08_02_Next);
        btn_08_02_Next.setBounds(430, 59, 150, 30);

        btn_08_03_Start.setText("Старт");
        btn_08_03_Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_08_03_StartActionPerformed(evt);
            }
        });
        add(btn_08_03_Start);
        btn_08_03_Start.setBounds(0, 89, 150, 30);

        btn_08_03_Next.setText("Далее");
        add(btn_08_03_Next);
        btn_08_03_Next.setBounds(430, 89, 150, 30);

        btn_08_04_Start.setText("Старт");
        btn_08_04_Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_08_04_StartActionPerformed(evt);
            }
        });
        add(btn_08_04_Start);
        btn_08_04_Start.setBounds(0, 119, 150, 30);

        btn_08_04_Next.setText("Далее");
        add(btn_08_04_Next);
        btn_08_04_Next.setBounds(430, 119, 150, 30);

        lbl_08_00_Date_start.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_08_00_Date_start.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_08_00_Date_start.setText("-");
        lbl_08_00_Date_start.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lbl_08_00_Date_start);
        lbl_08_00_Date_start.setBounds(0, 0, 90, 25);

        lbl_08_00_Time_start.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_08_00_Time_start.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_08_00_Time_start.setText("-");
        lbl_08_00_Time_start.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lbl_08_00_Time_start);
        lbl_08_00_Time_start.setBounds(90, 0, 60, 25);

        lbl_08_00_IcoStep.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_08_00_IcoStep.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lbl_08_00_IcoStep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_08_00_IcoStepMouseClicked(evt);
            }
        });
        add(lbl_08_00_IcoStep);
        lbl_08_00_IcoStep.setBounds(150, 0, 30, 25);

        lbl_08_00_Title.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_08_00_Title.setText("<html>8. Тренировка в трен. смеси</html>");
        lbl_08_00_Title.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lbl_08_00_Title.setOpaque(true);
        add(lbl_08_00_Title);
        lbl_08_00_Title.setBounds(180, 0, 250, 25);

        lbl_08_00_Date_stop.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_08_00_Date_stop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_08_00_Date_stop.setText("-");
        lbl_08_00_Date_stop.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lbl_08_00_Date_stop);
        lbl_08_00_Date_stop.setBounds(430, 0, 90, 25);

        lbl_08_00_Time_stop.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_08_00_Time_stop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_08_00_Time_stop.setText("-");
        lbl_08_00_Time_stop.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lbl_08_00_Time_stop);
        lbl_08_00_Time_stop.setBounds(520, 0, 60, 25);

        lbl_08_01_Date_start.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_08_01_Date_start.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_08_01_Date_start.setText("-");
        lbl_08_01_Date_start.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lbl_08_01_Date_start);
        lbl_08_01_Date_start.setBounds(0, 30, 90, 25);

        lbl_08_01_Time_start.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_08_01_Time_start.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_08_01_Time_start.setText("-");
        lbl_08_01_Time_start.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lbl_08_01_Time_start);
        lbl_08_01_Time_start.setBounds(90, 30, 60, 25);

        lbl_08_01_Title.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_08_01_Title.setText("8.1 Выдержка");
        lbl_08_01_Title.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lbl_08_01_Title.setOpaque(true);
        add(lbl_08_01_Title);
        lbl_08_01_Title.setBounds(180, 30, 250, 25);

        lbl_08_01_Date_stop.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_08_01_Date_stop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_08_01_Date_stop.setText("-");
        lbl_08_01_Date_stop.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lbl_08_01_Date_stop);
        lbl_08_01_Date_stop.setBounds(430, 30, 90, 25);

        lbl_08_01_Time_stop.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_08_01_Time_stop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_08_01_Time_stop.setText("-");
        lbl_08_01_Time_stop.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lbl_08_01_Time_stop);
        lbl_08_01_Time_stop.setBounds(520, 30, 60, 25);

        lbl_08_02_Date_start.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_08_02_Date_start.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_08_02_Date_start.setText("-");
        lbl_08_02_Date_start.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lbl_08_02_Date_start);
        lbl_08_02_Date_start.setBounds(0, 60, 90, 25);

        lbl_08_02_Time_start.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_08_02_Time_start.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_08_02_Time_start.setText("-");
        lbl_08_02_Time_start.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lbl_08_02_Time_start);
        lbl_08_02_Time_start.setBounds(90, 60, 60, 25);

        lbl_08_02_Title.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_08_02_Title.setText("8.2 Тренировка. 1ый цикл.");
        lbl_08_02_Title.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lbl_08_02_Title.setOpaque(true);
        add(lbl_08_02_Title);
        lbl_08_02_Title.setBounds(180, 60, 250, 25);

        lbl_08_02_Date_stop.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_08_02_Date_stop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_08_02_Date_stop.setText("-");
        lbl_08_02_Date_stop.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lbl_08_02_Date_stop);
        lbl_08_02_Date_stop.setBounds(430, 60, 90, 25);

        lbl_08_02_Time_stop.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_08_02_Time_stop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_08_02_Time_stop.setText("-");
        lbl_08_02_Time_stop.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lbl_08_02_Time_stop);
        lbl_08_02_Time_stop.setBounds(520, 60, 60, 25);

        lbl_08_03_Date_start.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_08_03_Date_start.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_08_03_Date_start.setText("-");
        lbl_08_03_Date_start.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lbl_08_03_Date_start);
        lbl_08_03_Date_start.setBounds(0, 90, 90, 25);

        lbl_08_03_Time_start.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_08_03_Time_start.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_08_03_Time_start.setText("-");
        lbl_08_03_Time_start.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lbl_08_03_Time_start);
        lbl_08_03_Time_start.setBounds(90, 90, 60, 25);

        lbl_08_03_Title.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_08_03_Title.setText("8.3 Выдержка");
        lbl_08_03_Title.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lbl_08_03_Title.setOpaque(true);
        add(lbl_08_03_Title);
        lbl_08_03_Title.setBounds(180, 90, 250, 25);

        lbl_08_03_Date_stop.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_08_03_Date_stop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_08_03_Date_stop.setText("-");
        lbl_08_03_Date_stop.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lbl_08_03_Date_stop);
        lbl_08_03_Date_stop.setBounds(430, 90, 90, 25);

        lbl_08_03_Time_stop.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_08_03_Time_stop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_08_03_Time_stop.setText("-");
        lbl_08_03_Time_stop.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lbl_08_03_Time_stop);
        lbl_08_03_Time_stop.setBounds(520, 90, 60, 25);

        lbl_08_04_Date_start.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_08_04_Date_start.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_08_04_Date_start.setText("-");
        lbl_08_04_Date_start.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lbl_08_04_Date_start);
        lbl_08_04_Date_start.setBounds(0, 120, 90, 25);

        lbl_08_04_Time_start.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_08_04_Time_start.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_08_04_Time_start.setText("-");
        lbl_08_04_Time_start.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lbl_08_04_Time_start);
        lbl_08_04_Time_start.setBounds(90, 120, 60, 25);

        lbl_08_04_Title.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_08_04_Title.setText("8.4 Тренировка. 2ой цикл.");
        lbl_08_04_Title.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lbl_08_04_Title.setOpaque(true);
        add(lbl_08_04_Title);
        lbl_08_04_Title.setBounds(180, 120, 250, 25);

        lbl_08_04_Date_stop.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_08_04_Date_stop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_08_04_Date_stop.setText("-");
        lbl_08_04_Date_stop.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lbl_08_04_Date_stop);
        lbl_08_04_Date_stop.setBounds(430, 120, 90, 25);

        lbl_08_04_Time_stop.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_08_04_Time_stop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_08_04_Time_stop.setText("-");
        lbl_08_04_Time_stop.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lbl_08_04_Time_stop);
        lbl_08_04_Time_stop.setBounds(520, 120, 60, 25);
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_08_00_IcoStepMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_08_00_IcoStepMouseClicked
        CollapseClick( 7);
    }//GEN-LAST:event_lbl_08_00_IcoStepMouseClicked

    private void btn_08_01_StartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_08_01_StartActionPerformed
        theApp.SetCurrentStep( 141);
        theApp.SetCurrentStepInProgress( false);
        
        theApp.m_pMainWnd.m_pnlPuffMessage.Init();
        theApp.m_pMainWnd.m_pnlPuffMessage.setVisible( true);
        
        theApp.m_pMainWnd.m_pnlMain.setVisible( false);
    }//GEN-LAST:event_btn_08_01_StartActionPerformed

    private void btn_08_02_StartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_08_02_StartActionPerformed
        theApp.SetCurrentStep( 142);
        theApp.SetCurrentStepInProgress( false);
        
        theApp.m_pMainWnd.m_pnlPuffMessage.Init();
        theApp.m_pMainWnd.m_pnlPuffMessage.setVisible( true);
        
        theApp.m_pMainWnd.m_pnlMain.setVisible( false);
    }//GEN-LAST:event_btn_08_02_StartActionPerformed

    private void btn_08_04_StartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_08_04_StartActionPerformed
        theApp.SetCurrentStep( 144);
        theApp.SetCurrentStepInProgress( false);
        
        theApp.m_pMainWnd.m_pnlPuffMessage.Init();
        theApp.m_pMainWnd.m_pnlPuffMessage.setVisible( true);
        
        theApp.m_pMainWnd.m_pnlMain.setVisible( false);
    }//GEN-LAST:event_btn_08_04_StartActionPerformed

    private void btn_08_03_StartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_08_03_StartActionPerformed
        theApp.SetCurrentStep( 143);
        theApp.SetCurrentStepInProgress( false);
        
        theApp.m_pMainWnd.m_pnlPuffMessage.Init();
        theApp.m_pMainWnd.m_pnlPuffMessage.setVisible( true);
        
        theApp.m_pMainWnd.m_pnlMain.setVisible( false);
    }//GEN-LAST:event_btn_08_03_StartActionPerformed


    public void SetState() {
        
        //8. Тренировка в тренировочной сети
        boolean bStart = false;
        boolean bStop = false;
        
        if( theApp.IsStepMapContainsKey( "141")) {
            TechProcessStepCommon info = theApp.GetCommonStep( "141");
            
            if( info.GetStartDate() != null) {
                lbl_08_00_Date_start.setText( theApp.strFormatDate( info.GetStartDate()));
                lbl_08_00_Time_start.setText( theApp.strFormatTime( info.GetStartDate()));
                bStart = true;
            }
        }
        
        if( theApp.IsStepMapContainsKey( "144")) {
            TechProcessStepCommon info = theApp.GetCommonStep( "144");    
            if( info.GetStopDate() != null) {
                lbl_08_00_Date_stop.setText( theApp.strFormatDate( info.GetStopDate()));
                lbl_08_00_Time_stop.setText( theApp.strFormatTime( info.GetStopDate()));
                bStop = true;
            }
        }
        
        if( bStart == false) {
            lbl_08_00_Date_start.setText( "-");
            lbl_08_00_Time_start.setText( "-");
        }
        
        if( bStop == false) {
            lbl_08_00_Date_stop.setText( "-");
            lbl_08_00_Time_stop.setText( "-");
        }
        
        lbl_08_00_IcoStep.setIcon( m_bCollapsed ? theApp.GetResources().getIconTriaRight() : theApp.GetResources().getIconTriaDown());
        
        
        lbl_08_00_Title.setEnabled( theApp.GetCurrentStep() < 160);
        
        if( 140 < theApp.GetCurrentStep() && theApp.GetCurrentStep() < 160) {
            lbl_08_00_Title.setFont( theApp.GetBoldFont());
            m_bCollapsed = false;
        }
        else {
            lbl_08_00_Title.setFont( theApp.GetUsualFont());
        }
        
        if( m_bCollapsed == false) {
            //8.1
            FillStepDates("141", lbl_08_01_Date_start, lbl_08_01_Time_start, lbl_08_01_Date_stop, lbl_08_01_Time_stop);
            lbl_08_01_Title.setFont( theApp.GetCurrentStep() == 141 ? theApp.GetBoldFont() : theApp.GetUsualFont());
            lbl_08_01_Title.setEnabled( theApp.GetCurrentStep() <= 141);
            btn_08_01_Start.setVisible( theApp.GetCurrentStep() == 141 && !theApp.IsCurrentStepInProgress());
            btn_08_01_Next.setVisible(  theApp.GetCurrentStep() == 141 &&  theApp.IsCurrentStepInProgress());
            btn_08_01_Start.setVisible( true);
            
            //8.2
            FillStepDates("142", lbl_08_02_Date_start, lbl_08_02_Time_start, lbl_08_02_Date_stop, lbl_08_02_Time_stop);
            lbl_08_02_Title.setFont( theApp.GetCurrentStep() == 142 ? theApp.GetBoldFont() : theApp.GetUsualFont());
            lbl_08_02_Title.setEnabled( theApp.GetCurrentStep() <= 142);
            btn_08_02_Start.setVisible( theApp.GetCurrentStep() == 142 && !theApp.IsCurrentStepInProgress());
            btn_08_02_Next.setVisible(  theApp.GetCurrentStep() == 142 &&  theApp.IsCurrentStepInProgress());
            
            //8.3
            FillStepDates("143", lbl_08_03_Date_start, lbl_08_03_Time_start, lbl_08_03_Date_stop, lbl_08_03_Time_stop);
            lbl_08_03_Title.setFont( theApp.GetCurrentStep() == 143 ? theApp.GetBoldFont() : theApp.GetUsualFont());
            lbl_08_03_Title.setEnabled( theApp.GetCurrentStep() <= 143);
            btn_08_03_Start.setVisible( theApp.GetCurrentStep() == 143 && !theApp.IsCurrentStepInProgress());
            btn_08_03_Next.setVisible(  theApp.GetCurrentStep() == 143 &&  theApp.IsCurrentStepInProgress());
            
            //8.4
            FillStepDates("144", lbl_08_04_Date_start, lbl_08_04_Time_start, lbl_08_04_Date_stop, lbl_08_04_Time_stop);
            lbl_08_04_Title.setFont( theApp.GetCurrentStep() == 144 ? theApp.GetBoldFont() : theApp.GetUsualFont());
            lbl_08_04_Title.setEnabled( theApp.GetCurrentStep() <= 144);
            btn_08_04_Start.setVisible( theApp.GetCurrentStep() == 144 && !theApp.IsCurrentStepInProgress());
            btn_08_04_Next.setVisible(  theApp.GetCurrentStep() == 144 &&  theApp.IsCurrentStepInProgress());
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_08_01_Next;
    public javax.swing.JButton btn_08_01_Start;
    public javax.swing.JButton btn_08_02_Next;
    public javax.swing.JButton btn_08_02_Start;
    public javax.swing.JButton btn_08_03_Next;
    public javax.swing.JButton btn_08_03_Start;
    public javax.swing.JButton btn_08_04_Next;
    public javax.swing.JButton btn_08_04_Start;
    public javax.swing.JLabel lbl_08_00_Date_start;
    public javax.swing.JLabel lbl_08_00_Date_stop;
    public javax.swing.JLabel lbl_08_00_IcoStep;
    public javax.swing.JLabel lbl_08_00_Time_start;
    public javax.swing.JLabel lbl_08_00_Time_stop;
    public javax.swing.JLabel lbl_08_00_Title;
    public javax.swing.JLabel lbl_08_01_Date_start;
    public javax.swing.JLabel lbl_08_01_Date_stop;
    public javax.swing.JLabel lbl_08_01_Time_start;
    public javax.swing.JLabel lbl_08_01_Time_stop;
    public javax.swing.JLabel lbl_08_01_Title;
    public javax.swing.JLabel lbl_08_02_Date_start;
    public javax.swing.JLabel lbl_08_02_Date_stop;
    public javax.swing.JLabel lbl_08_02_Time_start;
    public javax.swing.JLabel lbl_08_02_Time_stop;
    public javax.swing.JLabel lbl_08_02_Title;
    public javax.swing.JLabel lbl_08_03_Date_start;
    public javax.swing.JLabel lbl_08_03_Date_stop;
    public javax.swing.JLabel lbl_08_03_Time_start;
    public javax.swing.JLabel lbl_08_03_Time_stop;
    public javax.swing.JLabel lbl_08_03_Title;
    public javax.swing.JLabel lbl_08_04_Date_start;
    public javax.swing.JLabel lbl_08_04_Date_stop;
    public javax.swing.JLabel lbl_08_04_Time_start;
    public javax.swing.JLabel lbl_08_04_Time_stop;
    public javax.swing.JLabel lbl_08_04_Title;
    // End of variables declaration//GEN-END:variables
}
