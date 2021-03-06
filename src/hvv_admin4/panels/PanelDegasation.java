/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hvv_admin4.panels;

import hvv_admin4.HVV_Admin4;
import hvv_admin4.HVV_Admin4Constants;
import hvv_admin4.dialogs.DlgBigStopWatch;
import hvv_admin4.steps.info.TechProcessDegasationStepInfo;
import hvv_admin4.steps.info.TechProcessHFInfo;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.Timer;
import org.apache.log4j.Logger;

/**
 *
 * @author yaroslav
 */
public class PanelDegasation extends javax.swing.JPanel {
    final HVV_Admin4 theApp;
    static Logger logger = Logger.getLogger( PanelDegasation.class);
    public LinkedList m_lstProgram;
    PanelDegasationProgress m_pnlProgress;
    final DlgBigStopWatch m_dlgBigStopWatch;
    
    /**
     * Creates new form PanelProcess
     * @param app Main application pointer
     */
    public PanelDegasation( HVV_Admin4 app) {
        theApp = app;
        initComponents();
        
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();    
        m_dlgBigStopWatch = new DlgBigStopWatch( app, null, false);
        int nY = 0;
        if( theApp.GetSelectedArm() == HVV_Admin4Constants.ARM3 ||
            theApp.GetSelectedArm() == HVV_Admin4Constants.ARM4)
                    nY = (int) (m_dlgBigStopWatch.getHeight() * 1.3);
        m_dlgBigStopWatch.setLocation( rect.width - m_dlgBigStopWatch.getWidth(), nY);
        
        
        //m_pParent.m_dlgInd1 = new TechProcessStep08_1_Dlg( theApp, null/*theApp.m_pMainWnd*/, false, m_nInductor, m_pParent);
        
        
        m_pnlProgress = new PanelDegasationProgress( theApp, this);
        pnlProgress.add( m_pnlProgress);
        m_pnlProgress.setBounds( 2, 2, 465, 269);
        m_pnlProgress.setVisible( true);
        
        
        /*
        radGetterType1.setSelected( true);
        radGetterType2.setSelected( true);
        
        radInductorType1.setSelected(true);
        radInductorType2.setSelected(true);
        */
        m_dlgBigStopWatch.lblInductor.setText( "ИНД1");
        
        m_lstProgram = new LinkedList();
        new Timer( 100, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Timer t = ( Timer) e.getSource();
                t.stop();
                defineProgram();
            }
        }).start();
        
        m_scrollBar.setMaximum( 680 - 250 + 15);
        m_scrollBar.setValue( 0);
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        lblTitle = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        lblGetterType = new javax.swing.JLabel();
        radGetterType1 = new javax.swing.JRadioButton();
        radGetterType2 = new javax.swing.JRadioButton();
        lblInductorType = new javax.swing.JLabel();
        radInductorType1 = new javax.swing.JRadioButton();
        radInductorType2 = new javax.swing.JRadioButton();
        pnlProgress = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        m_scrollBar = new javax.swing.JScrollBar();
        jLabel6 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 200)));
        setMaximumSize(new java.awt.Dimension(640, 440));
        setMinimumSize(new java.awt.Dimension(640, 440));
        setPreferredSize(new java.awt.Dimension(640, 440));
        addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                formMouseWheelMoved(evt);
            }
        });
        setLayout(null);

        lblTitle.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitle.setText("<html><u>7.2 Обезгаживание рабочих геттеров</u></thml>");
        add(lblTitle);
        lblTitle.setBounds(10, 10, 620, 40);

        btnNext.setText("С т а р т");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        add(btnNext);
        btnNext.setBounds(10, 380, 500, 50);

        lblGetterType.setText("<html>Тип геттера:</html>");
        add(lblGetterType);
        lblGetterType.setBounds(10, 60, 100, 20);

        buttonGroup1.add(radGetterType1);
        radGetterType1.setText("1");
        radGetterType1.setEnabled(false);
        radGetterType1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radGetterType1ActionPerformed(evt);
            }
        });
        add(radGetterType1);
        radGetterType1.setBounds(110, 60, 40, 23);

        buttonGroup1.add(radGetterType2);
        radGetterType2.setSelected(true);
        radGetterType2.setText("2");
        radGetterType2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        radGetterType2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radGetterType2ActionPerformed(evt);
            }
        });
        add(radGetterType2);
        radGetterType2.setBounds(170, 60, 40, 20);

        lblInductorType.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInductorType.setText("<html>Тип индуктора:</html>");
        add(lblInductorType);
        lblInductorType.setBounds(290, 60, 120, 20);

        buttonGroup2.add(radInductorType1);
        radInductorType1.setSelected(true);
        radInductorType1.setText("1");
        radInductorType1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radInductorType1ActionPerformed(evt);
            }
        });
        add(radInductorType1);
        radInductorType1.setBounds(410, 60, 40, 20);

        buttonGroup2.add(radInductorType2);
        radInductorType2.setText("2");
        radInductorType2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        radInductorType2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radInductorType2ActionPerformed(evt);
            }
        });
        add(radInductorType2);
        radInductorType2.setBounds(470, 60, 40, 20);

        pnlProgress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        pnlProgress.setLayout(null);
        add(pnlProgress);
        pnlProgress.setBounds(10, 120, 470, 250);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("P выброса");
        add(jLabel3);
        jLabel3.setBounds(280, 90, 210, 20);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Мощность");
        add(jLabel5);
        jLabel5.setBounds(170, 90, 90, 20);

        m_scrollBar.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
            public void adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
                m_scrollBarAdjustmentValueChanged(evt);
            }
        });
        add(m_scrollBar);
        m_scrollBar.setBounds(490, 120, 20, 250);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Длительность");
        add(jLabel6);
        jLabel6.setBounds(40, 90, 110, 20);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        JTextField [] m_StepsPM = { m_pnlProgress.edtStep1MaxPressure,  m_pnlProgress.edtStep2MaxPressure,
                                    m_pnlProgress.edtStep3MaxPressure,  m_pnlProgress.edtStep4MaxPressure,
                                    m_pnlProgress.edtStep5MaxPressure,  m_pnlProgress.edtStep6MaxPressure,
                                    m_pnlProgress.edtStep7MaxPressure,  m_pnlProgress.edtStep8MaxPressure,
                                    m_pnlProgress.edtStep9MaxPressure,  m_pnlProgress.edtStep10MaxPressure,
                                    m_pnlProgress.edtStep11MaxPressure, m_pnlProgress.edtStep12MaxPressure,
                                    m_pnlProgress.edtStep13MaxPressure, m_pnlProgress.edtStep14MaxPressure,
                                    m_pnlProgress.edtStep15MaxPressure, m_pnlProgress.edtStep16MaxPressure,
                                    m_pnlProgress.edtStep17MaxPressure};

        JSpinner [] m_StepsPE   = { m_pnlProgress.spnStep1MaxPressureExp,  m_pnlProgress.spnStep2MaxPressureExp,
                                    m_pnlProgress.spnStep3MaxPressureExp,  m_pnlProgress.spnStep4MaxPressureExp,
                                    m_pnlProgress.spnStep5MaxPressureExp,  m_pnlProgress.spnStep6MaxPressureExp,
                                    m_pnlProgress.spnStep7MaxPressureExp,  m_pnlProgress.spnStep8MaxPressureExp,
                                    m_pnlProgress.spnStep9MaxPressureExp,  m_pnlProgress.spnStep10MaxPressureExp,
                                    m_pnlProgress.spnStep11MaxPressureExp, m_pnlProgress.spnStep12MaxPressureExp,
                                    m_pnlProgress.spnStep13MaxPressureExp, m_pnlProgress.spnStep14MaxPressureExp,
                                    m_pnlProgress.spnStep15MaxPressureExp, m_pnlProgress.spnStep16MaxPressureExp, 
                                    m_pnlProgress.spnStep17MaxPressureExp};

        TechProcessHFInfo info;
                
        if( m_pnlProgress.m_nStep == -1) {
            //мы нажали "старт"
            info = new TechProcessHFInfo();
            info.m_lstProgram = new LinkedList();
            
            info.SetStartDateAsCurrent( theApp.GetSettings().GetTimeZoneShift());

            lblGetterType.setEnabled( false);
            radGetterType1.setEnabled( false);
            radGetterType2.setEnabled( false);
            
            lblInductorType.setEnabled( false);
            radInductorType1.setEnabled( false);
            radInductorType2.setEnabled( false);
            
            if( radGetterType1.isSelected())
                info.SetGetter( HVV_Admin4Constants.GETTER1);
            else
                info.SetGetter( HVV_Admin4Constants.GETTER2);

            if( radInductorType1.isSelected())
                info.SetInductor(HVV_Admin4Constants.INDUCTOR_TYPE1);
            else
                info.SetInductor( HVV_Admin4Constants.INDUCTOR_TYPE2);

            theApp.SaveStepInfo( "122", info, true);
                        
            m_pnlProgress.m_nStep = 0;
            info.SetCurrentStep( 0);
            
            if( theApp.GetSettings().GetDebugShortenProgTimes())
                m_pnlProgress.m_nStepSecondsLeft = ( ( TechProcessDegasationStepInfo) m_lstProgram.getFirst()).GetDuration() * 5;
            else
                m_pnlProgress.m_nStepSecondsLeft = ( ( TechProcessDegasationStepInfo) m_lstProgram.getFirst()).GetDuration() * 60;
            
            m_pnlProgress.m_nFlashSeconds = 4;
            
            btnNext.setText( "Далее");
            btnNext.setEnabled( false);
        }
        else {
            
            //мы нажали "далее"
            
            //перезаполняем сверху вниз лесенку этапов программы обезгаживания и давлений выбросов
            info = ( TechProcessHFInfo) theApp.GetCommonStep( "122");
            info.m_lstProgram.clear();
            
            Iterator it = m_lstProgram.iterator();
            for( int i=0; i<m_lstProgram.size(); i++) {
                TechProcessDegasationStepInfo step = ( TechProcessDegasationStepInfo) it.next();
                    
                if( m_StepsPM[i].getText().isEmpty() == false) {
                    try {
                        String str = m_StepsPM[i].getText();
                        str = str.replace( ',', '.');
                        double dbl = new Double( str);
                        Integer nExp = ( Integer) m_StepsPE[i].getValue();
                        dbl = dbl * Math.pow( 10, new Double( nExp));
                        step.SetMaxPressure(dbl);

                    } catch( NumberFormatException ex) {
                        logger.info( "NumberFormatException caught!", ex);
                    }
                }                    

                info.m_lstProgram.addLast( step);
            }

            //сохраняем 
            theApp.SaveStepInfo( "122", info, true);
            
            
            if( m_pnlProgress.m_nStep == m_lstProgram.size()) {
                //мы нажали "далее" в плане перейти к следующему этапу процесса э/в обработки (к пункту 8.1)
                info.SetStopDateAsCurrent( theApp.GetSettings().GetTimeZoneShift());
                m_dlgBigStopWatch.dispose();
                
                theApp.SaveStepInfo( "122", info, true);
                
                theApp.SetCurrentStep( 141);
                theApp.SetCurrentStepInProgress( false);
                
                theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.SetStates();
                theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.Reposition();
                theApp.m_pMainWnd.m_pnlMain.ScrollActiveStepToCenter();
                theApp.m_pMainWnd.m_pnlMain.setVisible( true);
                
                theApp.m_pMainWnd.m_pnlDegasation.setVisible( false);
            }
            else {
                //мы нажали "далее" в плане перейти к следующему этапу программы обезгаживания
                TechProcessDegasationStepInfo infoInner = ( TechProcessDegasationStepInfo) m_lstProgram.get( m_pnlProgress.m_nStep);
                
                if( theApp.GetSettings().GetDebugShortenProgTimes() == true)
                    m_pnlProgress.m_nStepSecondsLeft = infoInner.GetDuration() * 5;
                else
                    m_pnlProgress.m_nStepSecondsLeft = infoInner.GetDuration() * 60;
                
                m_pnlProgress.m_nFlashSeconds = 4;
                btnNext.setEnabled( false);
            }
            
        }
        
        theApp.m_ReportGenerator.Generate();
    }//GEN-LAST:event_btnNextActionPerformed

    private void formMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_formMouseWheelMoved
        /*
        if( m_lstProgram.size() <= 7)
            return;
        */
        
        int nMin = m_scrollBar.getMinimum();
        int nMax = m_scrollBar.getMaximum();
        int nPos = m_scrollBar.getValue();
        int nStep1 = m_scrollBar.getBlockIncrement();
        int nStep2 = m_scrollBar.getUnitIncrement();

        int nNextPos = nPos + evt.getWheelRotation() * nStep1;

        if( nNextPos < nMin) nNextPos = nMin;
        if( nNextPos > nMax) nNextPos = nMax;
        m_scrollBar.setValue( nNextPos);
    }//GEN-LAST:event_formMouseWheelMoved

    private void m_scrollBarAdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {//GEN-FIRST:event_m_scrollBarAdjustmentValueChanged
        if( m_pnlProgress != null)
            m_pnlProgress.setBounds( 2, 2 - m_scrollBar.getValue(), 465, 269 + m_scrollBar.getValue());
    }//GEN-LAST:event_m_scrollBarAdjustmentValueChanged

    public void Init() {
        if( theApp.GetProcessedDeviceType() == HVV_Admin4Constants.DEVICE_SMALL) {
            radInductorType1.setEnabled( false);
            radInductorType2.setSelected( true);
            m_dlgBigStopWatch.lblInductor.setText( "ИНД2");
        }
        else if( theApp.GetProcessedDeviceType() == HVV_Admin4Constants.DEVICE_MEDIUM) {
            
        }
        else {
            
        }
        
        defineProgram();
        
        btnNext.setEnabled( false);
        new  Timer( 1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                (( Timer) e.getSource()).stop();
                btnNext.setEnabled( true);
            }
        }).start();
    }
    
    public void defineProgram() {
        int nProgramType = 0;
        
        if( theApp.GetProcessedDeviceType() == HVV_Admin4Constants.DEVICE_SMALL) nProgramType += 100;
        else if( theApp.GetProcessedDeviceType() == HVV_Admin4Constants.DEVICE_MEDIUM) nProgramType += 200;
        else nProgramType += 300;
        
        if( radGetterType1.isSelected()) nProgramType += 10;
        else nProgramType += 20;
        
        if( radInductorType1.isSelected()) nProgramType += 1;
        else nProgramType += 2;
        
        switch( nProgramType) {
            
            //SMALL
            case 111:   //small, get1, ind1    - no
                m_lstProgram.clear();
                m_lstProgram.add( new TechProcessDegasationStepInfo( 1,  1));
                m_lstProgram.add( new TechProcessDegasationStepInfo( 2,  1));
            break;
                
            case 112:   //small, get1, ind2    - no
                m_lstProgram.clear();
                m_lstProgram.add( new TechProcessDegasationStepInfo( 1,  1));
                m_lstProgram.add( new TechProcessDegasationStepInfo( 2,  1));
            break;
            
            case 121:   //small, get2, ind1    - no
                m_lstProgram.clear();
                m_lstProgram.add( new TechProcessDegasationStepInfo( 1,  1));
                m_lstProgram.add( new TechProcessDegasationStepInfo( 2,  1));
            break;
                
            case 122:   //small, get2, ind2    - yes
                m_lstProgram.clear();
                m_lstProgram.add( new TechProcessDegasationStepInfo( 2,  2));
                m_lstProgram.add( new TechProcessDegasationStepInfo( 2,  4));
                if( theApp.GetSettings().GetDebugShortenProgItems() == false) {
                    m_lstProgram.add( new TechProcessDegasationStepInfo( 2, 6));
                    m_lstProgram.add( new TechProcessDegasationStepInfo( 2, 8));
                    m_lstProgram.add( new TechProcessDegasationStepInfo( 2, 10));
                    m_lstProgram.add( new TechProcessDegasationStepInfo( 2, 12));
                    m_lstProgram.add( new TechProcessDegasationStepInfo( 2, 14));
                    m_lstProgram.add( new TechProcessDegasationStepInfo( 5, 15));
                    m_lstProgram.add( new TechProcessDegasationStepInfo( 2, 12));
                    m_lstProgram.add( new TechProcessDegasationStepInfo( 2, 10));
                    m_lstProgram.add( new TechProcessDegasationStepInfo( 2, 8));
                    m_lstProgram.add( new TechProcessDegasationStepInfo( 2, 6));
                    m_lstProgram.add( new TechProcessDegasationStepInfo( 2, 4));
                    m_lstProgram.add( new TechProcessDegasationStepInfo( 2, 2));
                }
            break;
                
            //MEDIUM
            case 211:   //medium, get1, ind1    - no
                m_lstProgram.clear();
                m_lstProgram.add( new TechProcessDegasationStepInfo( 1,  1));
                m_lstProgram.add( new TechProcessDegasationStepInfo( 2,  1));
            break;
                
            case 212:   //medium, get1, ind2    - no
                m_lstProgram.clear();
                m_lstProgram.add( new TechProcessDegasationStepInfo( 1,  1));
                m_lstProgram.add( new TechProcessDegasationStepInfo( 2,  1));
            break;
            
            case 221:   //medium, get2, ind1    - yes
                m_lstProgram.clear();
                m_lstProgram.add( new TechProcessDegasationStepInfo( 3, 10));
                m_lstProgram.add( new TechProcessDegasationStepInfo( 3, 15));
                if( theApp.GetSettings().GetDebugShortenProgItems() == false) {
                    m_lstProgram.add( new TechProcessDegasationStepInfo(  5, 20));
                    m_lstProgram.add( new TechProcessDegasationStepInfo( 10, 25));
                    m_lstProgram.add( new TechProcessDegasationStepInfo(  5, 20));
                    m_lstProgram.add( new TechProcessDegasationStepInfo(  3, 15));
                    m_lstProgram.add( new TechProcessDegasationStepInfo(  3, 10));
                }
            break;
                
            case 222:   //medium, get2, ind2    - yes
                m_lstProgram.clear();
                m_lstProgram.add( new TechProcessDegasationStepInfo( 2,  2));
                m_lstProgram.add( new TechProcessDegasationStepInfo( 2,  4));
                if( theApp.GetSettings().GetDebugShortenProgItems() == false) {
                    m_lstProgram.add( new TechProcessDegasationStepInfo( 2, 6));
                    m_lstProgram.add( new TechProcessDegasationStepInfo( 2, 8));
                    m_lstProgram.add( new TechProcessDegasationStepInfo( 2, 10));
                    m_lstProgram.add( new TechProcessDegasationStepInfo( 2, 12));
                    m_lstProgram.add( new TechProcessDegasationStepInfo( 2, 14));
                    m_lstProgram.add( new TechProcessDegasationStepInfo( 2, 16));
                    m_lstProgram.add( new TechProcessDegasationStepInfo( 5, 17));
                    m_lstProgram.add( new TechProcessDegasationStepInfo( 2, 14));
                    m_lstProgram.add( new TechProcessDegasationStepInfo( 2, 12));
                    m_lstProgram.add( new TechProcessDegasationStepInfo( 2, 10));
                    m_lstProgram.add( new TechProcessDegasationStepInfo( 2, 8));
                    m_lstProgram.add( new TechProcessDegasationStepInfo( 2, 6));
                    m_lstProgram.add( new TechProcessDegasationStepInfo( 2, 4));
                    m_lstProgram.add( new TechProcessDegasationStepInfo( 2, 2));
                }
            break;
                
                
                
                
            //BIG
            case 311:   //BIG, get1, ind1    - no
                m_lstProgram.clear();
                m_lstProgram.add( new TechProcessDegasationStepInfo( 1,  1));
                m_lstProgram.add( new TechProcessDegasationStepInfo( 2,  1));
            break;
                
            case 312:   //BIG, get1, ind2    - no
                m_lstProgram.clear();
                m_lstProgram.add( new TechProcessDegasationStepInfo( 1,  1));
                m_lstProgram.add( new TechProcessDegasationStepInfo( 2,  1));
            break;
            
            case 321:   //BIG, get2, ind1    - no
                m_lstProgram.clear();
                m_lstProgram.add( new TechProcessDegasationStepInfo( 1,  1));
                m_lstProgram.add( new TechProcessDegasationStepInfo( 2,  1));
            break;
                
            case 322:   //BIG, get2, ind2    - no
                m_lstProgram.clear();
                m_lstProgram.add( new TechProcessDegasationStepInfo( 1,  1));
                m_lstProgram.add( new TechProcessDegasationStepInfo( 2,  1));
            break;
        }
        
        /*
        if( m_lstProgram.size() >= 7) {
            m_scrollBar.setEnabled( true);
            m_scrollBar.setMaximum( 21 + 40 * ( m_lstProgram.size() - 7));
        }
        else
            m_scrollBar.setEnabled( false);
        */
    }
    
    private void radGetterType1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radGetterType1ActionPerformed
        defineProgram();
    }//GEN-LAST:event_radGetterType1ActionPerformed

    private void radGetterType2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radGetterType2ActionPerformed
        defineProgram();
    }//GEN-LAST:event_radGetterType2ActionPerformed

    private void radInductorType1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radInductorType1ActionPerformed
        defineProgram();
        m_dlgBigStopWatch.lblInductor.setText( "ИНД1");
    }//GEN-LAST:event_radInductorType1ActionPerformed

    private void radInductorType2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radInductorType2ActionPerformed
        defineProgram();
        m_dlgBigStopWatch.lblInductor.setText( "ИНД2");
    }//GEN-LAST:event_radInductorType2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnNext;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblGetterType;
    private javax.swing.JLabel lblInductorType;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JScrollBar m_scrollBar;
    private javax.swing.JPanel pnlProgress;
    private javax.swing.JRadioButton radGetterType1;
    private javax.swing.JRadioButton radGetterType2;
    private javax.swing.JRadioButton radInductorType1;
    public javax.swing.JRadioButton radInductorType2;
    // End of variables declaration//GEN-END:variables
}
