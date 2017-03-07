/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hvv_admin4.panels;

import hvv_admin4.HVV_Admin4;
import hvv_admin4.steps.info.TechProcessGetterInfo;
import hvv_admin4.steps.info.TechProcessStepCommon;

/**
 *
 * @author yaroslav
 */
public class PanelStep07 extends TechProcessStepPanelTemplate {
    public final int MAXIMIZED_HEIGHT = 90;
    
    /**
     * Creates new form PanelStep01
     */
    public PanelStep07( HVV_Admin4 app) {
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

        btn_07_01_Start = new javax.swing.JButton();
        btn_07_01_Next = new javax.swing.JButton();
        btn_07_02_Start = new javax.swing.JButton();
        btn_07_02_Next = new javax.swing.JButton();
        lbl_07_00_Date_start = new javax.swing.JLabel();
        lbl_07_00_Time_start = new javax.swing.JLabel();
        lbl_07_00_IcoStep = new javax.swing.JLabel();
        lbl_07_00_Title = new javax.swing.JLabel();
        lbl_07_00_Date_stop = new javax.swing.JLabel();
        lbl_07_00_Time_stop = new javax.swing.JLabel();
        lbl_07_01_Date_start = new javax.swing.JLabel();
        lbl_07_01_Time_start = new javax.swing.JLabel();
        lbl_07_01_Title = new javax.swing.JLabel();
        lbl_07_01_Date_stop = new javax.swing.JLabel();
        lbl_07_01_Time_stop = new javax.swing.JLabel();
        lbl_07_02_Date_start = new javax.swing.JLabel();
        lbl_07_02_Time_start = new javax.swing.JLabel();
        lbl_07_02_Title = new javax.swing.JLabel();
        lbl_07_02_Date_stop = new javax.swing.JLabel();
        lbl_07_02_Time_stop = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(580, 90));
        setMinimumSize(new java.awt.Dimension(580, 90));
        setName(""); // NOI18N
        setLayout(null);

        btn_07_01_Start.setText("Старт");
        btn_07_01_Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_07_01_StartActionPerformed(evt);
            }
        });
        add(btn_07_01_Start);
        btn_07_01_Start.setBounds(0, 29, 150, 30);

        btn_07_01_Next.setText("Далее");
        add(btn_07_01_Next);
        btn_07_01_Next.setBounds(430, 29, 150, 30);

        btn_07_02_Start.setText("Старт");
        add(btn_07_02_Start);
        btn_07_02_Start.setBounds(0, 59, 150, 30);

        btn_07_02_Next.setText("Далее");
        add(btn_07_02_Next);
        btn_07_02_Next.setBounds(430, 59, 150, 30);

        lbl_07_00_Date_start.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_07_00_Date_start.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_07_00_Date_start.setText("-");
        lbl_07_00_Date_start.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lbl_07_00_Date_start);
        lbl_07_00_Date_start.setBounds(0, 0, 90, 25);

        lbl_07_00_Time_start.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_07_00_Time_start.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_07_00_Time_start.setText("-");
        lbl_07_00_Time_start.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lbl_07_00_Time_start);
        lbl_07_00_Time_start.setBounds(90, 0, 60, 25);

        lbl_07_00_IcoStep.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_07_00_IcoStep.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lbl_07_00_IcoStep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_07_00_IcoStepMouseClicked(evt);
            }
        });
        add(lbl_07_00_IcoStep);
        lbl_07_00_IcoStep.setBounds(150, 0, 30, 25);

        lbl_07_00_Title.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_07_00_Title.setText("<html>7. Обезгаживание раб. геттеров</html>");
        lbl_07_00_Title.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lbl_07_00_Title.setOpaque(true);
        add(lbl_07_00_Title);
        lbl_07_00_Title.setBounds(180, 0, 250, 25);

        lbl_07_00_Date_stop.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_07_00_Date_stop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_07_00_Date_stop.setText("-");
        lbl_07_00_Date_stop.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lbl_07_00_Date_stop);
        lbl_07_00_Date_stop.setBounds(430, 0, 90, 25);

        lbl_07_00_Time_stop.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_07_00_Time_stop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_07_00_Time_stop.setText("-");
        lbl_07_00_Time_stop.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lbl_07_00_Time_stop);
        lbl_07_00_Time_stop.setBounds(520, 0, 60, 25);

        lbl_07_01_Date_start.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_07_01_Date_start.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_07_01_Date_start.setText("-");
        lbl_07_01_Date_start.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lbl_07_01_Date_start);
        lbl_07_01_Date_start.setBounds(0, 30, 90, 25);

        lbl_07_01_Time_start.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_07_01_Time_start.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_07_01_Time_start.setText("-");
        lbl_07_01_Time_start.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lbl_07_01_Time_start);
        lbl_07_01_Time_start.setBounds(90, 30, 60, 25);

        lbl_07_01_Title.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_07_01_Title.setText("7.1 Подготовка технол. геттера");
        lbl_07_01_Title.setToolTipText("");
        lbl_07_01_Title.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lbl_07_01_Title.setOpaque(true);
        add(lbl_07_01_Title);
        lbl_07_01_Title.setBounds(180, 30, 250, 25);

        lbl_07_01_Date_stop.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_07_01_Date_stop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_07_01_Date_stop.setText("-");
        lbl_07_01_Date_stop.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lbl_07_01_Date_stop);
        lbl_07_01_Date_stop.setBounds(430, 30, 90, 25);

        lbl_07_01_Time_stop.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_07_01_Time_stop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_07_01_Time_stop.setText("-");
        lbl_07_01_Time_stop.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lbl_07_01_Time_stop);
        lbl_07_01_Time_stop.setBounds(520, 30, 60, 25);

        lbl_07_02_Date_start.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_07_02_Date_start.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_07_02_Date_start.setText("-");
        lbl_07_02_Date_start.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lbl_07_02_Date_start);
        lbl_07_02_Date_start.setBounds(0, 60, 90, 25);

        lbl_07_02_Time_start.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_07_02_Time_start.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_07_02_Time_start.setText("-");
        lbl_07_02_Time_start.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lbl_07_02_Time_start);
        lbl_07_02_Time_start.setBounds(90, 60, 60, 25);

        lbl_07_02_Title.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_07_02_Title.setText("7.2 Обезгаживание");
        lbl_07_02_Title.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lbl_07_02_Title.setOpaque(true);
        add(lbl_07_02_Title);
        lbl_07_02_Title.setBounds(180, 60, 250, 25);

        lbl_07_02_Date_stop.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_07_02_Date_stop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_07_02_Date_stop.setText("-");
        lbl_07_02_Date_stop.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lbl_07_02_Date_stop);
        lbl_07_02_Date_stop.setBounds(430, 60, 90, 25);

        lbl_07_02_Time_stop.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_07_02_Time_stop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_07_02_Time_stop.setText("-");
        lbl_07_02_Time_stop.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lbl_07_02_Time_stop);
        lbl_07_02_Time_stop.setBounds(520, 60, 60, 25);
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_07_00_IcoStepMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_07_00_IcoStepMouseClicked
        CollapseClick( 6);
    }//GEN-LAST:event_lbl_07_00_IcoStepMouseClicked

    private void btn_07_01_StartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_07_01_StartActionPerformed
        TechProcessStepCommon info = new TechProcessGetterInfo( theApp);
        info.SetStartDateAsCurrent();
        info.SetStartReportTitle( "Начало процесса обезгаживания");
        theApp.SaveStepInfo( "121", info, true);
        
        theApp.m_ReportGenerator.Generate();
        
        //FAKE
        theApp.SetCurrentStep( 121);
        
        theApp.m_pMainWnd.m_pnlEnterGetterInfo.InitOnStart( theApp.GetLocalDate());
        theApp.SetCurrentStepInProgress( true);
        theApp.m_pMainWnd.m_pnlEnterGetterInfo.setVisible( true);
        
        theApp.m_pMainWnd.m_pnlMain.setVisible( false);
    }//GEN-LAST:event_btn_07_01_StartActionPerformed


    public void SetState() {
        
        //7. Обезгаживание рабочих геттеров
        boolean bStart = false;
        boolean bStop = false;
        
        if( theApp.IsStepMapContainsKey( "121")) {
            TechProcessStepCommon info = theApp.GetStepInfo( "121");
            
            if( info.GetStartDate() != null) {
                lbl_07_00_Date_start.setText( theApp.strFormatDate( info.GetStartDate()));
                lbl_07_00_Time_start.setText( theApp.strFormatTime( info.GetStartDate()));
                bStart = true;
            }
        }
        
        if( theApp.IsStepMapContainsKey( "122")) {
            TechProcessStepCommon info = theApp.GetStepInfo( "122");    
            if( info.GetStopDate() != null) {
                lbl_07_00_Date_stop.setText( theApp.strFormatDate( info.GetStopDate()));
                lbl_07_00_Time_stop.setText( theApp.strFormatTime( info.GetStopDate()));
                bStop = true;
            }
        }
        
        if( bStart == false) {
            lbl_07_00_Date_start.setText( "-");
            lbl_07_00_Time_start.setText( "-");
        }
        
        if( bStop == false) {
            lbl_07_00_Date_stop.setText( "-");
            lbl_07_00_Time_stop.setText( "-");
        }
        
        lbl_07_00_IcoStep.setIcon( m_bCollapsed ? theApp.GetResources().getIconTriaRight() : theApp.GetResources().getIconTriaDown());
        
        
        lbl_07_00_Title.setEnabled( theApp.GetCurrentStep() < 140);
        
        if( 120 < theApp.GetCurrentStep() && theApp.GetCurrentStep() < 140) {
            lbl_07_00_Title.setFont( theApp.GetBoldFont());
            m_bCollapsed = false;
        }
        else {
            lbl_07_00_Title.setFont( theApp.GetUsualFont());
        }
        
        if( m_bCollapsed == false) {
            //7.1
            FillStepDates("121", lbl_07_01_Date_start, lbl_07_01_Time_start, lbl_07_01_Date_stop, lbl_07_01_Time_stop);
            lbl_07_01_Title.setFont( theApp.GetCurrentStep() == 121 ? theApp.GetBoldFont() : theApp.GetUsualFont());
            lbl_07_01_Title.setEnabled( theApp.GetCurrentStep() <= 121);
            btn_07_01_Start.setVisible( theApp.GetCurrentStep() == 121 && !theApp.IsCurrentStepInProgress());
            btn_07_01_Next.setVisible(  theApp.GetCurrentStep() == 121 &&  theApp.IsCurrentStepInProgress());
            btn_07_01_Start.setVisible( true);
            
            //7.2
            FillStepDates("122", lbl_07_02_Date_start, lbl_07_02_Time_start, lbl_07_02_Date_stop, lbl_07_02_Time_stop);
            lbl_07_02_Title.setFont( theApp.GetCurrentStep() == 122 ? theApp.GetBoldFont() : theApp.GetUsualFont());
            lbl_07_02_Title.setEnabled( theApp.GetCurrentStep() <= 122);
            btn_07_02_Start.setVisible( theApp.GetCurrentStep() == 122 && !theApp.IsCurrentStepInProgress());
            btn_07_02_Next.setVisible(  theApp.GetCurrentStep() == 122 &&  theApp.IsCurrentStepInProgress());
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_07_01_Next;
    public javax.swing.JButton btn_07_01_Start;
    public javax.swing.JButton btn_07_02_Next;
    public javax.swing.JButton btn_07_02_Start;
    public javax.swing.JLabel lbl_07_00_Date_start;
    public javax.swing.JLabel lbl_07_00_Date_stop;
    public javax.swing.JLabel lbl_07_00_IcoStep;
    public javax.swing.JLabel lbl_07_00_Time_start;
    public javax.swing.JLabel lbl_07_00_Time_stop;
    public javax.swing.JLabel lbl_07_00_Title;
    public javax.swing.JLabel lbl_07_01_Date_start;
    public javax.swing.JLabel lbl_07_01_Date_stop;
    public javax.swing.JLabel lbl_07_01_Time_start;
    public javax.swing.JLabel lbl_07_01_Time_stop;
    public javax.swing.JLabel lbl_07_01_Title;
    public javax.swing.JLabel lbl_07_02_Date_start;
    public javax.swing.JLabel lbl_07_02_Date_stop;
    public javax.swing.JLabel lbl_07_02_Time_start;
    public javax.swing.JLabel lbl_07_02_Time_stop;
    public javax.swing.JLabel lbl_07_02_Title;
    // End of variables declaration//GEN-END:variables
}
