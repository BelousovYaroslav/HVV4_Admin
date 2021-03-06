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
public class PanelStep05 extends TechProcessStepPanelTemplate {
    public final int MAXIMIZED_HEIGHT = 120;
    
    /**
     * Creates new form PanelStep01
     */
    public PanelStep05( HVV_Admin4 app) {
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

        btn_05_01_Start = new javax.swing.JButton();
        btn_05_01_Next = new javax.swing.JButton();
        btn_05_02_Start = new javax.swing.JButton();
        btn_05_02_Next = new javax.swing.JButton();
        lbl_05_00_Date_start = new javax.swing.JLabel();
        lbl_05_00_Time_start = new javax.swing.JLabel();
        lbl_05_00_IcoStep = new javax.swing.JLabel();
        lbl_05_00_Title = new javax.swing.JLabel();
        lbl_05_00_Date_stop = new javax.swing.JLabel();
        lbl_05_00_Time_stop = new javax.swing.JLabel();
        lbl_05_01_Date_start = new javax.swing.JLabel();
        lbl_05_01_Time_start = new javax.swing.JLabel();
        lbl_05_01_Title = new javax.swing.JLabel();
        lbl_05_01_Date_stop = new javax.swing.JLabel();
        lbl_05_01_Time_stop = new javax.swing.JLabel();
        lbl_05_02_Date_start = new javax.swing.JLabel();
        lbl_05_02_Time_start = new javax.swing.JLabel();
        lbl_05_02_Title = new javax.swing.JLabel();
        lbl_05_02_Date_stop = new javax.swing.JLabel();
        lbl_05_02_Time_stop = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(460, 120));
        setMinimumSize(new java.awt.Dimension(460, 120));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(460, 120));
        setLayout(null);

        btn_05_01_Start.setText("Старт");
        add(btn_05_01_Start);
        btn_05_01_Start.setBounds(0, 40, 90, 40);

        btn_05_01_Next.setText("Далее");
        add(btn_05_01_Next);
        btn_05_01_Next.setBounds(370, 40, 90, 40);

        btn_05_02_Start.setText("Старт");
        add(btn_05_02_Start);
        btn_05_02_Start.setBounds(0, 80, 90, 40);

        btn_05_02_Next.setText("Далее");
        add(btn_05_02_Next);
        btn_05_02_Next.setBounds(370, 80, 90, 40);

        lbl_05_00_Date_start.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_05_00_Date_start.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_05_00_Date_start.setText("-");
        add(lbl_05_00_Date_start);
        lbl_05_00_Date_start.setBounds(0, 0, 90, 20);

        lbl_05_00_Time_start.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_05_00_Time_start.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_05_00_Time_start.setText("-");
        add(lbl_05_00_Time_start);
        lbl_05_00_Time_start.setBounds(0, 20, 90, 20);

        lbl_05_00_IcoStep.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_05_00_IcoStep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_05_00_IcoStepMouseClicked(evt);
            }
        });
        add(lbl_05_00_IcoStep);
        lbl_05_00_IcoStep.setBounds(90, 0, 30, 40);

        lbl_05_00_Title.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_05_00_Title.setText("<html>5. Оценка параметров прибора</html>");
        lbl_05_00_Title.setOpaque(true);
        add(lbl_05_00_Title);
        lbl_05_00_Title.setBounds(120, 0, 250, 40);

        lbl_05_00_Date_stop.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_05_00_Date_stop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_05_00_Date_stop.setText("-");
        add(lbl_05_00_Date_stop);
        lbl_05_00_Date_stop.setBounds(370, 0, 90, 20);

        lbl_05_00_Time_stop.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_05_00_Time_stop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_05_00_Time_stop.setText("-");
        add(lbl_05_00_Time_stop);
        lbl_05_00_Time_stop.setBounds(370, 20, 90, 20);

        lbl_05_01_Date_start.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_05_01_Date_start.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_05_01_Date_start.setText("-");
        add(lbl_05_01_Date_start);
        lbl_05_01_Date_start.setBounds(0, 40, 90, 20);

        lbl_05_01_Time_start.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_05_01_Time_start.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_05_01_Time_start.setText("-");
        add(lbl_05_01_Time_start);
        lbl_05_01_Time_start.setBounds(0, 60, 90, 20);

        lbl_05_01_Title.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_05_01_Title.setText("5.1 Замеры параметров");
        lbl_05_01_Title.setOpaque(true);
        add(lbl_05_01_Title);
        lbl_05_01_Title.setBounds(120, 40, 250, 40);

        lbl_05_01_Date_stop.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_05_01_Date_stop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_05_01_Date_stop.setText("-");
        add(lbl_05_01_Date_stop);
        lbl_05_01_Date_stop.setBounds(370, 40, 90, 20);

        lbl_05_01_Time_stop.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_05_01_Time_stop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_05_01_Time_stop.setText("-");
        add(lbl_05_01_Time_stop);
        lbl_05_01_Time_stop.setBounds(370, 60, 90, 20);

        lbl_05_02_Date_start.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_05_02_Date_start.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_05_02_Date_start.setText("-");
        add(lbl_05_02_Date_start);
        lbl_05_02_Date_start.setBounds(0, 80, 90, 20);

        lbl_05_02_Time_start.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_05_02_Time_start.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_05_02_Time_start.setText("-");
        add(lbl_05_02_Time_start);
        lbl_05_02_Time_start.setBounds(0, 100, 90, 20);

        lbl_05_02_Title.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_05_02_Title.setText("5.2 Внесение комментариев");
        lbl_05_02_Title.setOpaque(true);
        add(lbl_05_02_Title);
        lbl_05_02_Title.setBounds(120, 80, 250, 40);

        lbl_05_02_Date_stop.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_05_02_Date_stop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_05_02_Date_stop.setText("-");
        add(lbl_05_02_Date_stop);
        lbl_05_02_Date_stop.setBounds(370, 80, 90, 20);

        lbl_05_02_Time_stop.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lbl_05_02_Time_stop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_05_02_Time_stop.setText("-");
        add(lbl_05_02_Time_stop);
        lbl_05_02_Time_stop.setBounds(370, 100, 90, 20);
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_05_00_IcoStepMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_05_00_IcoStepMouseClicked
        CollapseClick( 4);
    }//GEN-LAST:event_lbl_05_00_IcoStepMouseClicked


    public void SetState() {
        
        //2. Обработка в среде кислорода
        boolean bStart = false;
        boolean bStop = false;
        
        if( theApp.IsStepMapContainsKey( "081")) {
            TechProcessStepCommon info = theApp.GetCommonStep( "081");
            
            if( info.GetStartDate() != null) {
                lbl_05_00_Date_start.setText( theApp.strFormatDate( info.GetStartDate()));
                lbl_05_00_Time_start.setText( theApp.strFormatTime( info.GetStartDate()));
                bStart = true;
            }
        }    
        
        if( theApp.IsStepMapContainsKey( "082")) {
            TechProcessStepCommon info = theApp.GetCommonStep( "082");
            if( info.GetStopDate() != null) {
                lbl_05_00_Date_stop.setText( theApp.strFormatDate( info.GetStopDate()));
                lbl_05_00_Time_stop.setText( theApp.strFormatTime( info.GetStopDate()));
                bStop = true;
            }
        }
        
        if( bStart == false) {
            lbl_05_00_Date_start.setText( "-");
            lbl_05_00_Time_start.setText( "-");
        }
        
        if( bStop == false) {
            lbl_05_00_Date_stop.setText( "-");
            lbl_05_00_Time_stop.setText( "-");
        }
        
        lbl_05_00_IcoStep.setIcon( m_bCollapsed ? theApp.GetResources().getIconTriaRight() : theApp.GetResources().getIconTriaDown());
        
        
        lbl_05_00_Title.setEnabled( theApp.GetCurrentStep() < 100);
        
        if( 80 < theApp.GetCurrentStep() && theApp.GetCurrentStep() < 100) {
            lbl_05_00_Title.setFont( theApp.GetBoldFont());
            m_bCollapsed = false;
        }
        else {
            lbl_05_00_Title.setFont( theApp.GetUsualFont());
        }
        
        if( m_bCollapsed == false) {
            //5.1
            FillStepDates("081", lbl_05_01_Date_start, lbl_05_01_Time_start, lbl_05_01_Date_stop, lbl_05_01_Time_stop);
            lbl_05_01_Title.setFont( theApp.GetCurrentStep() == 81 ? theApp.GetBoldFont() : theApp.GetUsualFont());
            lbl_05_01_Title.setEnabled( theApp.GetCurrentStep() <= 81);
            btn_05_01_Start.setVisible( theApp.GetCurrentStep() == 81 && !theApp.IsCurrentStepInProgress());
            btn_05_01_Next.setVisible(  theApp.GetCurrentStep() == 81 &&  theApp.IsCurrentStepInProgress());
            
            //5.2
            FillStepDates("083", lbl_05_02_Date_start, lbl_05_02_Time_start, lbl_05_02_Date_stop, lbl_05_02_Time_stop);
            lbl_05_02_Title.setFont( theApp.GetCurrentStep() == 82 ? theApp.GetBoldFont() : theApp.GetUsualFont());
            lbl_05_02_Title.setEnabled( theApp.GetCurrentStep() <= 82);
            btn_05_02_Start.setVisible( theApp.GetCurrentStep() == 82 && !theApp.IsCurrentStepInProgress());
            btn_05_02_Next.setVisible(  theApp.GetCurrentStep() == 82 &&  theApp.IsCurrentStepInProgress());
        }
        else {
            btn_05_01_Start.setVisible( false);
            btn_05_01_Next.setVisible(  false);
            btn_05_02_Start.setVisible( false);
            btn_05_02_Next.setVisible(  false);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_05_01_Next;
    public javax.swing.JButton btn_05_01_Start;
    public javax.swing.JButton btn_05_02_Next;
    public javax.swing.JButton btn_05_02_Start;
    public javax.swing.JLabel lbl_05_00_Date_start;
    public javax.swing.JLabel lbl_05_00_Date_stop;
    public javax.swing.JLabel lbl_05_00_IcoStep;
    public javax.swing.JLabel lbl_05_00_Time_start;
    public javax.swing.JLabel lbl_05_00_Time_stop;
    public javax.swing.JLabel lbl_05_00_Title;
    public javax.swing.JLabel lbl_05_01_Date_start;
    public javax.swing.JLabel lbl_05_01_Date_stop;
    public javax.swing.JLabel lbl_05_01_Time_start;
    public javax.swing.JLabel lbl_05_01_Time_stop;
    public javax.swing.JLabel lbl_05_01_Title;
    public javax.swing.JLabel lbl_05_02_Date_start;
    public javax.swing.JLabel lbl_05_02_Date_stop;
    public javax.swing.JLabel lbl_05_02_Time_start;
    public javax.swing.JLabel lbl_05_02_Time_stop;
    public javax.swing.JLabel lbl_05_02_Title;
    // End of variables declaration//GEN-END:variables
}
