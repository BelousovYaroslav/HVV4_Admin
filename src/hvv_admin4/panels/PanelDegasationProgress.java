/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hvv_admin4.panels;

import hvv_admin4.HVV_Admin4;
import hvv_admin4.steps.info.TechProcessDegasationStepInfo;
import hvv_admin4.steps.info.TechProcessHFInfo;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.Timer;
import org.apache.log4j.Logger;

/**
 *
 * @author yaroslav
 */
public class PanelDegasationProgress extends javax.swing.JPanel {
    final HVV_Admin4 theApp;
    
    static Logger logger = Logger.getLogger(PanelDegasationProgress.class);
    final Timer m_pRefreshTimer;
    
    public int m_nStep;
    public int m_nStepSecondsLeft;
    public int m_nFlashSeconds;
    
    final public PanelDegasation m_pParent;
    
    final Color m_clrRed;
    final Color m_clrBlue;
    
    /**
     * Creates new form PanelProcess
     */
    public PanelDegasationProgress( HVV_Admin4 app, PanelDegasation pParent) {
        theApp = app;
        
        initComponents();
        
        m_clrRed =  new Color( 220, 150, 150);
        m_clrBlue = Color.red;//= new Color( 150, 150, 220);
        
        m_pParent = pParent;
        
        m_nStep = -1;
        m_nStepSecondsLeft = -1;
                
        m_pRefreshTimer = new Timer( 1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SetStates();
                if( m_nStep != -1) {
                    m_pParent.m_dlgBigStopWatch.RefreshTime( m_nStepSecondsLeft);
                    if( m_nStepSecondsLeft == 0) {
                        if( m_pParent.btnNext.isEnabled() == false) {
                            if( ++m_nStep == m_pParent.m_lstProgram.size())
                                m_pRefreshTimer.stop();
                            m_pParent.btnNext.setEnabled( true);
                            (( TechProcessHFInfo) theApp.SecretSteps().get( "122")).SetCurrentStep(m_nStep);
                        }
                        
                        if( m_nFlashSeconds == 0)
                           m_nFlashSeconds = 4;
                    }
                    else
                        m_nStepSecondsLeft--;
                }
            }
        });
        
        
    }

    public void StartRefreshTimer() {
        m_pRefreshTimer.start();
    }
    
    public void SetStates() {
        JLabel [] m_StepsIcon = {   lblStep1Icon,  lblStep2Icon,  lblStep3Icon,  lblStep4Icon,  lblStep5Icon,
                                    lblStep6Icon,  lblStep7Icon,  lblStep8Icon,  lblStep9Icon,  lblStep10Icon,
                                    lblStep11Icon, lblStep12Icon, lblStep13Icon, lblStep14Icon, lblStep15Icon,
                                    lblStep16Icon, lblStep17Icon };
        
        JLabel [] m_StepsTTotal = { lblStep1TimeTotal,  lblStep2TimeTotal,  lblStep3TimeTotal,  lblStep4TimeTotal,  lblStep5TimeTotal,
                                    lblStep6TimeTotal,  lblStep7TimeTotal,  lblStep8TimeTotal,  lblStep9TimeTotal,  lblStep10TimeTotal,
                                    lblStep11TimeTotal, lblStep12TimeTotal, lblStep13TimeTotal, lblStep14TimeTotal, lblStep15TimeTotal,
                                    lblStep16TimeTotal, lblStep17TimeTotal};
        
        JLabel [] m_StepsPower  = { lblStep1Power,  lblStep2Power,  lblStep3Power,  lblStep4Power,  lblStep5Power,
                                    lblStep6Power,  lblStep7Power,  lblStep8Power,  lblStep9Power,  lblStep10Power, 
                                    lblStep11Power, lblStep12Power, lblStep13Power, lblStep14Power, lblStep15Power,
                                    lblStep16Power, lblStep17Power};
        
        JTextField [] m_StepsPM = { edtStep1MaxPressure,  edtStep2MaxPressure,  edtStep3MaxPressure,  edtStep4MaxPressure,  edtStep5MaxPressure,
                                    edtStep6MaxPressure,  edtStep7MaxPressure,  edtStep8MaxPressure,  edtStep9MaxPressure,  edtStep10MaxPressure,
                                    edtStep11MaxPressure, edtStep12MaxPressure, edtStep13MaxPressure, edtStep14MaxPressure, edtStep15MaxPressure,
                                    edtStep16MaxPressure, edtStep17MaxPressure};
                
        JLabel     [] m_StepsPB = { lblStep1_10,  lblStep2_10,  lblStep3_10,  lblStep4_10,  lblStep5_10,
                                    lblStep6_10,  lblStep7_10,  lblStep8_10,  lblStep9_10,  lblStep10_10,
                                    lblStep11_10, lblStep12_10, lblStep13_10, lblStep14_10, lblStep15_10,
                                    lblStep16_10, lblStep17_10};
        
        JSpinner [] m_StepsPE   = { spnStep1MaxPressureExp,  spnStep2MaxPressureExp,  spnStep3MaxPressureExp,  spnStep4MaxPressureExp,  spnStep5MaxPressureExp,
                                    spnStep6MaxPressureExp,  spnStep7MaxPressureExp,  spnStep8MaxPressureExp,  spnStep9MaxPressureExp,  spnStep10MaxPressureExp,
                                    spnStep11MaxPressureExp, spnStep12MaxPressureExp, spnStep13MaxPressureExp, spnStep14MaxPressureExp, spnStep15MaxPressureExp,
                                    spnStep16MaxPressureExp, spnStep17MaxPressureExp};
                
        for( int i=0; i < 17; i++) {
            
            if( i < m_pParent.m_lstProgram.size()) {
                TechProcessDegasationStepInfo item = ( TechProcessDegasationStepInfo) m_pParent.m_lstProgram.get(i);
                m_StepsTTotal[i].setText( "" + item.GetDuration());
                m_StepsPower[i].setText( "" + item.GetPower());

                /*
                if( m_StepsPM[i].hasFocus() == false) {
                    if( item.GetMaxPressure() != 1.e-5) {
                        String strMaxPressure = String.format( "%.2e", item.GetMaxPressure());
                        strMaxPressure = strMaxPressure.replace( ',', '.');

                        String strMantissa = strMaxPressure.substring( 0, strMaxPressure.indexOf('.') + 3);
                        m_StepsPM[i].setText( strMantissa);

                        String strExponent = strMaxPressure.substring( strMaxPressure.indexOf('.') + 4);

                        m_StepsPE[i].setValue( Integer.parseInt( strExponent));

                    }
                }*/

                if( m_nStep >= 0) {
                    m_StepsIcon[i].setIcon( i == m_nStep ? theApp.GetResources().getIconTriaRight() : null);
                }

                if( m_nFlashSeconds > 0) {
                    if( m_nStep == i) {
                        if( m_nStepSecondsLeft == 0) {
                            m_StepsIcon[i].setBackground(   ( ( m_nFlashSeconds % 2) == 0) ? m_clrBlue : null);
                            m_StepsTTotal[i].setBackground( ( ( m_nFlashSeconds % 2) == 0) ? m_clrBlue : null);
                            m_StepsPower[i].setBackground(  ( ( m_nFlashSeconds % 2) == 0) ? m_clrBlue : null);
                        }
                        else {
                            m_StepsIcon[i].setBackground(   ( ( m_nFlashSeconds % 2) == 0) ? m_clrRed : null);
                            m_StepsTTotal[i].setBackground( ( ( m_nFlashSeconds % 2) == 0) ? m_clrRed : null);
                            m_StepsPower[i].setBackground(  ( ( m_nFlashSeconds % 2) == 0) ? m_clrRed : null);
                        }

                        m_nFlashSeconds--;
                    }
                }
                
            }
            else {
                m_StepsTTotal[i].setText( "");
                m_StepsPower[i].setText( "");
            }
        }
        
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblStep1Icon = new javax.swing.JLabel();
        lblStep1TimeTotal = new javax.swing.JLabel();
        lblStep1Power = new javax.swing.JLabel();
        edtStep1MaxPressure = new javax.swing.JTextField();
        lblStep1_10 = new javax.swing.JLabel();
        spnStep1MaxPressureExp = new javax.swing.JSpinner();
        lblStep2Icon = new javax.swing.JLabel();
        lblStep2TimeTotal = new javax.swing.JLabel();
        lblStep2Power = new javax.swing.JLabel();
        edtStep2MaxPressure = new javax.swing.JTextField();
        lblStep2_10 = new javax.swing.JLabel();
        spnStep2MaxPressureExp = new javax.swing.JSpinner();
        lblStep3Icon = new javax.swing.JLabel();
        lblStep3TimeTotal = new javax.swing.JLabel();
        lblStep3Power = new javax.swing.JLabel();
        edtStep3MaxPressure = new javax.swing.JTextField();
        lblStep3_10 = new javax.swing.JLabel();
        spnStep3MaxPressureExp = new javax.swing.JSpinner();
        lblStep4Icon = new javax.swing.JLabel();
        lblStep4TimeTotal = new javax.swing.JLabel();
        lblStep4Power = new javax.swing.JLabel();
        edtStep4MaxPressure = new javax.swing.JTextField();
        lblStep4_10 = new javax.swing.JLabel();
        spnStep4MaxPressureExp = new javax.swing.JSpinner();
        lblStep5Icon = new javax.swing.JLabel();
        lblStep5TimeTotal = new javax.swing.JLabel();
        lblStep5Power = new javax.swing.JLabel();
        edtStep5MaxPressure = new javax.swing.JTextField();
        lblStep5_10 = new javax.swing.JLabel();
        spnStep5MaxPressureExp = new javax.swing.JSpinner();
        lblStep6Icon = new javax.swing.JLabel();
        lblStep6TimeTotal = new javax.swing.JLabel();
        lblStep6Power = new javax.swing.JLabel();
        edtStep6MaxPressure = new javax.swing.JTextField();
        lblStep6_10 = new javax.swing.JLabel();
        spnStep6MaxPressureExp = new javax.swing.JSpinner();
        lblStep7Icon = new javax.swing.JLabel();
        lblStep7TimeTotal = new javax.swing.JLabel();
        lblStep7Power = new javax.swing.JLabel();
        edtStep7MaxPressure = new javax.swing.JTextField();
        lblStep7_10 = new javax.swing.JLabel();
        spnStep7MaxPressureExp = new javax.swing.JSpinner();
        lblStep8Icon = new javax.swing.JLabel();
        lblStep8TimeTotal = new javax.swing.JLabel();
        lblStep8Power = new javax.swing.JLabel();
        edtStep8MaxPressure = new javax.swing.JTextField();
        lblStep8_10 = new javax.swing.JLabel();
        spnStep8MaxPressureExp = new javax.swing.JSpinner();
        lblStep9Icon = new javax.swing.JLabel();
        lblStep9TimeTotal = new javax.swing.JLabel();
        lblStep9Power = new javax.swing.JLabel();
        edtStep9MaxPressure = new javax.swing.JTextField();
        lblStep9_10 = new javax.swing.JLabel();
        spnStep9MaxPressureExp = new javax.swing.JSpinner();
        lblStep10Icon = new javax.swing.JLabel();
        lblStep10TimeTotal = new javax.swing.JLabel();
        lblStep10Power = new javax.swing.JLabel();
        edtStep10MaxPressure = new javax.swing.JTextField();
        lblStep10_10 = new javax.swing.JLabel();
        spnStep10MaxPressureExp = new javax.swing.JSpinner();
        lblStep11Icon = new javax.swing.JLabel();
        lblStep11TimeTotal = new javax.swing.JLabel();
        lblStep11Power = new javax.swing.JLabel();
        edtStep11MaxPressure = new javax.swing.JTextField();
        lblStep11_10 = new javax.swing.JLabel();
        spnStep11MaxPressureExp = new javax.swing.JSpinner();
        lblStep12Icon = new javax.swing.JLabel();
        lblStep12TimeTotal = new javax.swing.JLabel();
        lblStep12Power = new javax.swing.JLabel();
        edtStep12MaxPressure = new javax.swing.JTextField();
        lblStep12_10 = new javax.swing.JLabel();
        spnStep12MaxPressureExp = new javax.swing.JSpinner();
        lblStep13Icon = new javax.swing.JLabel();
        lblStep13TimeTotal = new javax.swing.JLabel();
        lblStep13Power = new javax.swing.JLabel();
        edtStep13MaxPressure = new javax.swing.JTextField();
        lblStep13_10 = new javax.swing.JLabel();
        spnStep13MaxPressureExp = new javax.swing.JSpinner();
        lblStep14Icon = new javax.swing.JLabel();
        lblStep14TimeTotal = new javax.swing.JLabel();
        lblStep14Power = new javax.swing.JLabel();
        edtStep14MaxPressure = new javax.swing.JTextField();
        lblStep14_10 = new javax.swing.JLabel();
        spnStep14MaxPressureExp = new javax.swing.JSpinner();
        lblStep15Icon = new javax.swing.JLabel();
        lblStep15TimeTotal = new javax.swing.JLabel();
        lblStep15Power = new javax.swing.JLabel();
        edtStep15MaxPressure = new javax.swing.JTextField();
        lblStep15_10 = new javax.swing.JLabel();
        spnStep15MaxPressureExp = new javax.swing.JSpinner();
        lblStep16Icon = new javax.swing.JLabel();
        lblStep16TimeTotal = new javax.swing.JLabel();
        lblStep16Power = new javax.swing.JLabel();
        edtStep16MaxPressure = new javax.swing.JTextField();
        lblStep16_10 = new javax.swing.JLabel();
        spnStep16MaxPressureExp = new javax.swing.JSpinner();
        lblStep17Icon = new javax.swing.JLabel();
        lblStep17TimeTotal = new javax.swing.JLabel();
        lblStep17Power = new javax.swing.JLabel();
        edtStep17MaxPressure = new javax.swing.JTextField();
        lblStep17_10 = new javax.swing.JLabel();
        spnStep17MaxPressureExp = new javax.swing.JSpinner();

        setMaximumSize(new java.awt.Dimension(490, 680));
        setMinimumSize(new java.awt.Dimension(490, 680));
        setPreferredSize(new java.awt.Dimension(490, 680));
        setLayout(null);

        lblStep1Icon.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep1Icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep1Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep1Icon.setOpaque(true);
        add(lblStep1Icon);
        lblStep1Icon.setBounds(0, 0, 30, 40);

        lblStep1TimeTotal.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep1TimeTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep1TimeTotal.setText("-");
        lblStep1TimeTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep1TimeTotal.setOpaque(true);
        add(lblStep1TimeTotal);
        lblStep1TimeTotal.setBounds(30, 0, 100, 40);

        lblStep1Power.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep1Power.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep1Power.setText("-");
        lblStep1Power.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep1Power.setOpaque(true);
        add(lblStep1Power);
        lblStep1Power.setBounds(150, 0, 100, 40);

        edtStep1MaxPressure.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        edtStep1MaxPressure.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtStep1MaxPressure.setNextFocusableComponent(spnStep1MaxPressureExp);
        add(edtStep1MaxPressure);
        edtStep1MaxPressure.setBounds(270, 0, 90, 40);

        lblStep1_10.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep1_10.setText(" · 10");
        lblStep1_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblStep1_10);
        lblStep1_10.setBounds(360, 0, 60, 40);

        spnStep1MaxPressureExp.setModel(new javax.swing.SpinnerNumberModel(-5, -6, -4, 1));
        spnStep1MaxPressureExp.setNextFocusableComponent(edtStep2MaxPressure);
        add(spnStep1MaxPressureExp);
        spnStep1MaxPressureExp.setBounds(420, 0, 50, 26);

        lblStep2Icon.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep2Icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep2Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep2Icon.setOpaque(true);
        add(lblStep2Icon);
        lblStep2Icon.setBounds(0, 40, 30, 40);

        lblStep2TimeTotal.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep2TimeTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep2TimeTotal.setText("-");
        lblStep2TimeTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep2TimeTotal.setOpaque(true);
        add(lblStep2TimeTotal);
        lblStep2TimeTotal.setBounds(30, 40, 100, 40);

        lblStep2Power.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep2Power.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep2Power.setText("-");
        lblStep2Power.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep2Power.setOpaque(true);
        add(lblStep2Power);
        lblStep2Power.setBounds(150, 40, 100, 40);

        edtStep2MaxPressure.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        edtStep2MaxPressure.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtStep2MaxPressure.setNextFocusableComponent(spnStep2MaxPressureExp);
        add(edtStep2MaxPressure);
        edtStep2MaxPressure.setBounds(270, 40, 90, 40);

        lblStep2_10.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep2_10.setText(" · 10");
        lblStep2_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblStep2_10);
        lblStep2_10.setBounds(360, 40, 60, 40);

        spnStep2MaxPressureExp.setModel(new javax.swing.SpinnerNumberModel(-5, -6, -4, 1));
        spnStep2MaxPressureExp.setNextFocusableComponent(edtStep3MaxPressure);
        add(spnStep2MaxPressureExp);
        spnStep2MaxPressureExp.setBounds(420, 40, 50, 26);

        lblStep3Icon.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep3Icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep3Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep3Icon.setOpaque(true);
        add(lblStep3Icon);
        lblStep3Icon.setBounds(0, 80, 30, 40);

        lblStep3TimeTotal.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep3TimeTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep3TimeTotal.setText("-");
        lblStep3TimeTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep3TimeTotal.setOpaque(true);
        add(lblStep3TimeTotal);
        lblStep3TimeTotal.setBounds(30, 80, 100, 40);

        lblStep3Power.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep3Power.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep3Power.setText("-");
        lblStep3Power.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep3Power.setOpaque(true);
        add(lblStep3Power);
        lblStep3Power.setBounds(150, 80, 100, 40);

        edtStep3MaxPressure.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        edtStep3MaxPressure.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtStep3MaxPressure.setNextFocusableComponent(spnStep3MaxPressureExp);
        add(edtStep3MaxPressure);
        edtStep3MaxPressure.setBounds(270, 80, 90, 40);

        lblStep3_10.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep3_10.setText(" · 10");
        lblStep3_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblStep3_10);
        lblStep3_10.setBounds(360, 80, 60, 40);

        spnStep3MaxPressureExp.setModel(new javax.swing.SpinnerNumberModel(-5, -6, -4, 1));
        spnStep3MaxPressureExp.setNextFocusableComponent(edtStep4MaxPressure);
        add(spnStep3MaxPressureExp);
        spnStep3MaxPressureExp.setBounds(420, 80, 50, 26);

        lblStep4Icon.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep4Icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep4Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep4Icon.setOpaque(true);
        add(lblStep4Icon);
        lblStep4Icon.setBounds(0, 120, 30, 40);

        lblStep4TimeTotal.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep4TimeTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep4TimeTotal.setText("-");
        lblStep4TimeTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep4TimeTotal.setOpaque(true);
        add(lblStep4TimeTotal);
        lblStep4TimeTotal.setBounds(30, 120, 100, 40);

        lblStep4Power.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep4Power.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep4Power.setText("-");
        lblStep4Power.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep4Power.setOpaque(true);
        add(lblStep4Power);
        lblStep4Power.setBounds(150, 120, 100, 40);

        edtStep4MaxPressure.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        edtStep4MaxPressure.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtStep4MaxPressure.setNextFocusableComponent(spnStep4MaxPressureExp);
        add(edtStep4MaxPressure);
        edtStep4MaxPressure.setBounds(270, 120, 90, 40);

        lblStep4_10.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep4_10.setText(" · 10");
        lblStep4_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblStep4_10);
        lblStep4_10.setBounds(360, 120, 60, 40);

        spnStep4MaxPressureExp.setModel(new javax.swing.SpinnerNumberModel(-5, -6, -4, 1));
        spnStep4MaxPressureExp.setNextFocusableComponent(edtStep5MaxPressure);
        add(spnStep4MaxPressureExp);
        spnStep4MaxPressureExp.setBounds(420, 120, 50, 26);

        lblStep5Icon.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep5Icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep5Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep5Icon.setOpaque(true);
        add(lblStep5Icon);
        lblStep5Icon.setBounds(0, 160, 30, 40);

        lblStep5TimeTotal.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep5TimeTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep5TimeTotal.setText("-");
        lblStep5TimeTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep5TimeTotal.setOpaque(true);
        add(lblStep5TimeTotal);
        lblStep5TimeTotal.setBounds(30, 160, 100, 40);

        lblStep5Power.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep5Power.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep5Power.setText("-");
        lblStep5Power.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep5Power.setOpaque(true);
        add(lblStep5Power);
        lblStep5Power.setBounds(150, 160, 100, 40);

        edtStep5MaxPressure.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        edtStep5MaxPressure.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtStep5MaxPressure.setNextFocusableComponent(spnStep5MaxPressureExp);
        add(edtStep5MaxPressure);
        edtStep5MaxPressure.setBounds(270, 160, 90, 40);

        lblStep5_10.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep5_10.setText(" · 10");
        lblStep5_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblStep5_10);
        lblStep5_10.setBounds(360, 160, 60, 40);

        spnStep5MaxPressureExp.setModel(new javax.swing.SpinnerNumberModel(-5, -6, -4, 1));
        spnStep5MaxPressureExp.setNextFocusableComponent(edtStep6MaxPressure);
        add(spnStep5MaxPressureExp);
        spnStep5MaxPressureExp.setBounds(420, 160, 50, 26);

        lblStep6Icon.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep6Icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep6Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep6Icon.setOpaque(true);
        add(lblStep6Icon);
        lblStep6Icon.setBounds(0, 200, 30, 40);

        lblStep6TimeTotal.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep6TimeTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep6TimeTotal.setText("-");
        lblStep6TimeTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep6TimeTotal.setOpaque(true);
        add(lblStep6TimeTotal);
        lblStep6TimeTotal.setBounds(30, 200, 100, 40);

        lblStep6Power.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep6Power.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep6Power.setText("-");
        lblStep6Power.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep6Power.setOpaque(true);
        add(lblStep6Power);
        lblStep6Power.setBounds(150, 200, 100, 40);

        edtStep6MaxPressure.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        edtStep6MaxPressure.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtStep6MaxPressure.setNextFocusableComponent(spnStep6MaxPressureExp);
        add(edtStep6MaxPressure);
        edtStep6MaxPressure.setBounds(270, 200, 90, 40);

        lblStep6_10.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep6_10.setText(" · 10");
        lblStep6_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblStep6_10);
        lblStep6_10.setBounds(360, 200, 60, 40);

        spnStep6MaxPressureExp.setModel(new javax.swing.SpinnerNumberModel(-5, -6, -4, 1));
        spnStep6MaxPressureExp.setNextFocusableComponent(edtStep7MaxPressure);
        add(spnStep6MaxPressureExp);
        spnStep6MaxPressureExp.setBounds(420, 200, 50, 26);

        lblStep7Icon.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep7Icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep7Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep7Icon.setOpaque(true);
        add(lblStep7Icon);
        lblStep7Icon.setBounds(0, 240, 30, 40);

        lblStep7TimeTotal.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep7TimeTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep7TimeTotal.setText("-");
        lblStep7TimeTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep7TimeTotal.setOpaque(true);
        add(lblStep7TimeTotal);
        lblStep7TimeTotal.setBounds(30, 240, 100, 40);

        lblStep7Power.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep7Power.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep7Power.setText("-");
        lblStep7Power.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep7Power.setOpaque(true);
        add(lblStep7Power);
        lblStep7Power.setBounds(150, 240, 100, 40);

        edtStep7MaxPressure.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        edtStep7MaxPressure.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtStep7MaxPressure.setNextFocusableComponent(spnStep7MaxPressureExp);
        add(edtStep7MaxPressure);
        edtStep7MaxPressure.setBounds(270, 240, 90, 40);

        lblStep7_10.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep7_10.setText(" · 10");
        lblStep7_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblStep7_10);
        lblStep7_10.setBounds(360, 240, 60, 40);

        spnStep7MaxPressureExp.setModel(new javax.swing.SpinnerNumberModel(-5, -6, -4, 1));
        spnStep7MaxPressureExp.setNextFocusableComponent(edtStep8MaxPressure);
        add(spnStep7MaxPressureExp);
        spnStep7MaxPressureExp.setBounds(420, 240, 50, 26);

        lblStep8Icon.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep8Icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep8Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep8Icon.setOpaque(true);
        add(lblStep8Icon);
        lblStep8Icon.setBounds(0, 280, 30, 40);

        lblStep8TimeTotal.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep8TimeTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep8TimeTotal.setText("-");
        lblStep8TimeTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep8TimeTotal.setOpaque(true);
        add(lblStep8TimeTotal);
        lblStep8TimeTotal.setBounds(30, 280, 100, 40);

        lblStep8Power.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep8Power.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep8Power.setText("-");
        lblStep8Power.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep8Power.setOpaque(true);
        add(lblStep8Power);
        lblStep8Power.setBounds(150, 280, 100, 40);

        edtStep8MaxPressure.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        edtStep8MaxPressure.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtStep8MaxPressure.setNextFocusableComponent(spnStep8MaxPressureExp);
        add(edtStep8MaxPressure);
        edtStep8MaxPressure.setBounds(270, 280, 90, 40);

        lblStep8_10.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep8_10.setText(" · 10");
        lblStep8_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblStep8_10);
        lblStep8_10.setBounds(360, 280, 60, 40);

        spnStep8MaxPressureExp.setModel(new javax.swing.SpinnerNumberModel(-5, -6, -4, 1));
        spnStep8MaxPressureExp.setNextFocusableComponent(edtStep9MaxPressure);
        add(spnStep8MaxPressureExp);
        spnStep8MaxPressureExp.setBounds(420, 280, 50, 26);

        lblStep9Icon.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep9Icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep9Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep9Icon.setOpaque(true);
        add(lblStep9Icon);
        lblStep9Icon.setBounds(0, 320, 30, 40);

        lblStep9TimeTotal.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep9TimeTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep9TimeTotal.setText("-");
        lblStep9TimeTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep9TimeTotal.setOpaque(true);
        add(lblStep9TimeTotal);
        lblStep9TimeTotal.setBounds(30, 320, 100, 40);

        lblStep9Power.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep9Power.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep9Power.setText("-");
        lblStep9Power.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep9Power.setOpaque(true);
        add(lblStep9Power);
        lblStep9Power.setBounds(150, 320, 100, 40);

        edtStep9MaxPressure.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        edtStep9MaxPressure.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtStep9MaxPressure.setNextFocusableComponent(spnStep9MaxPressureExp);
        add(edtStep9MaxPressure);
        edtStep9MaxPressure.setBounds(270, 320, 90, 40);

        lblStep9_10.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep9_10.setText(" · 10");
        lblStep9_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblStep9_10);
        lblStep9_10.setBounds(360, 320, 60, 40);

        spnStep9MaxPressureExp.setModel(new javax.swing.SpinnerNumberModel(-5, -6, -4, 1));
        spnStep9MaxPressureExp.setNextFocusableComponent(edtStep10MaxPressure);
        add(spnStep9MaxPressureExp);
        spnStep9MaxPressureExp.setBounds(420, 320, 50, 26);

        lblStep10Icon.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep10Icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep10Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep10Icon.setOpaque(true);
        add(lblStep10Icon);
        lblStep10Icon.setBounds(0, 360, 30, 40);

        lblStep10TimeTotal.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep10TimeTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep10TimeTotal.setText("-");
        lblStep10TimeTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep10TimeTotal.setOpaque(true);
        add(lblStep10TimeTotal);
        lblStep10TimeTotal.setBounds(30, 360, 100, 40);

        lblStep10Power.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep10Power.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep10Power.setText("-");
        lblStep10Power.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep10Power.setOpaque(true);
        add(lblStep10Power);
        lblStep10Power.setBounds(150, 360, 100, 40);

        edtStep10MaxPressure.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        edtStep10MaxPressure.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtStep10MaxPressure.setNextFocusableComponent(spnStep10MaxPressureExp);
        add(edtStep10MaxPressure);
        edtStep10MaxPressure.setBounds(270, 360, 90, 40);

        lblStep10_10.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep10_10.setText(" · 10");
        lblStep10_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblStep10_10);
        lblStep10_10.setBounds(360, 360, 60, 40);

        spnStep10MaxPressureExp.setModel(new javax.swing.SpinnerNumberModel(-5, -6, -4, 1));
        spnStep10MaxPressureExp.setNextFocusableComponent(edtStep11MaxPressure);
        add(spnStep10MaxPressureExp);
        spnStep10MaxPressureExp.setBounds(420, 360, 50, 26);

        lblStep11Icon.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep11Icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep11Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep11Icon.setOpaque(true);
        add(lblStep11Icon);
        lblStep11Icon.setBounds(0, 400, 30, 40);

        lblStep11TimeTotal.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep11TimeTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep11TimeTotal.setText("-");
        lblStep11TimeTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep11TimeTotal.setOpaque(true);
        add(lblStep11TimeTotal);
        lblStep11TimeTotal.setBounds(30, 400, 100, 40);

        lblStep11Power.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep11Power.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep11Power.setText("-");
        lblStep11Power.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep11Power.setOpaque(true);
        add(lblStep11Power);
        lblStep11Power.setBounds(150, 400, 100, 40);

        edtStep11MaxPressure.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        edtStep11MaxPressure.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtStep11MaxPressure.setNextFocusableComponent(spnStep11MaxPressureExp);
        add(edtStep11MaxPressure);
        edtStep11MaxPressure.setBounds(270, 400, 90, 40);

        lblStep11_10.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep11_10.setText(" · 10");
        lblStep11_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblStep11_10);
        lblStep11_10.setBounds(360, 400, 60, 40);

        spnStep11MaxPressureExp.setModel(new javax.swing.SpinnerNumberModel(-5, -6, -4, 1));
        spnStep11MaxPressureExp.setNextFocusableComponent(edtStep12MaxPressure);
        add(spnStep11MaxPressureExp);
        spnStep11MaxPressureExp.setBounds(420, 400, 50, 26);

        lblStep12Icon.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep12Icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep12Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep12Icon.setOpaque(true);
        add(lblStep12Icon);
        lblStep12Icon.setBounds(0, 440, 30, 40);

        lblStep12TimeTotal.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep12TimeTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep12TimeTotal.setText("-");
        lblStep12TimeTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep12TimeTotal.setOpaque(true);
        add(lblStep12TimeTotal);
        lblStep12TimeTotal.setBounds(30, 440, 100, 40);

        lblStep12Power.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep12Power.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep12Power.setText("-");
        lblStep12Power.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep12Power.setOpaque(true);
        add(lblStep12Power);
        lblStep12Power.setBounds(150, 440, 100, 40);

        edtStep12MaxPressure.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        edtStep12MaxPressure.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtStep12MaxPressure.setNextFocusableComponent(spnStep12MaxPressureExp);
        add(edtStep12MaxPressure);
        edtStep12MaxPressure.setBounds(270, 440, 90, 40);

        lblStep12_10.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep12_10.setText(" · 10");
        lblStep12_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblStep12_10);
        lblStep12_10.setBounds(360, 440, 60, 40);

        spnStep12MaxPressureExp.setModel(new javax.swing.SpinnerNumberModel(-5, -6, -4, 1));
        spnStep12MaxPressureExp.setNextFocusableComponent(edtStep13MaxPressure);
        add(spnStep12MaxPressureExp);
        spnStep12MaxPressureExp.setBounds(420, 440, 50, 26);

        lblStep13Icon.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep13Icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep13Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep13Icon.setOpaque(true);
        add(lblStep13Icon);
        lblStep13Icon.setBounds(0, 480, 30, 40);

        lblStep13TimeTotal.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep13TimeTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep13TimeTotal.setText("-");
        lblStep13TimeTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep13TimeTotal.setOpaque(true);
        add(lblStep13TimeTotal);
        lblStep13TimeTotal.setBounds(30, 480, 100, 40);

        lblStep13Power.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep13Power.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep13Power.setText("-");
        lblStep13Power.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep13Power.setOpaque(true);
        add(lblStep13Power);
        lblStep13Power.setBounds(150, 480, 100, 40);

        edtStep13MaxPressure.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        edtStep13MaxPressure.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtStep13MaxPressure.setNextFocusableComponent(spnStep13MaxPressureExp);
        add(edtStep13MaxPressure);
        edtStep13MaxPressure.setBounds(270, 480, 90, 40);

        lblStep13_10.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep13_10.setText(" · 10");
        lblStep13_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblStep13_10);
        lblStep13_10.setBounds(360, 480, 60, 40);

        spnStep13MaxPressureExp.setModel(new javax.swing.SpinnerNumberModel(-5, -6, -4, 1));
        spnStep13MaxPressureExp.setNextFocusableComponent(edtStep14MaxPressure);
        add(spnStep13MaxPressureExp);
        spnStep13MaxPressureExp.setBounds(420, 480, 50, 26);

        lblStep14Icon.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep14Icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep14Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep14Icon.setOpaque(true);
        add(lblStep14Icon);
        lblStep14Icon.setBounds(0, 520, 30, 40);

        lblStep14TimeTotal.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep14TimeTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep14TimeTotal.setText("-");
        lblStep14TimeTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep14TimeTotal.setOpaque(true);
        add(lblStep14TimeTotal);
        lblStep14TimeTotal.setBounds(30, 520, 100, 40);

        lblStep14Power.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep14Power.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep14Power.setText("-");
        lblStep14Power.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep14Power.setOpaque(true);
        add(lblStep14Power);
        lblStep14Power.setBounds(150, 520, 100, 40);

        edtStep14MaxPressure.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        edtStep14MaxPressure.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtStep14MaxPressure.setNextFocusableComponent(spnStep14MaxPressureExp);
        add(edtStep14MaxPressure);
        edtStep14MaxPressure.setBounds(270, 520, 90, 40);

        lblStep14_10.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep14_10.setText(" · 10");
        lblStep14_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblStep14_10);
        lblStep14_10.setBounds(360, 520, 60, 40);

        spnStep14MaxPressureExp.setModel(new javax.swing.SpinnerNumberModel(-5, -6, -4, 1));
        spnStep14MaxPressureExp.setNextFocusableComponent(edtStep15MaxPressure);
        add(spnStep14MaxPressureExp);
        spnStep14MaxPressureExp.setBounds(420, 520, 50, 26);

        lblStep15Icon.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep15Icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep15Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep15Icon.setOpaque(true);
        add(lblStep15Icon);
        lblStep15Icon.setBounds(0, 560, 30, 40);

        lblStep15TimeTotal.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep15TimeTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep15TimeTotal.setText("-");
        lblStep15TimeTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep15TimeTotal.setOpaque(true);
        add(lblStep15TimeTotal);
        lblStep15TimeTotal.setBounds(30, 560, 100, 40);

        lblStep15Power.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep15Power.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep15Power.setText("-");
        lblStep15Power.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep15Power.setOpaque(true);
        add(lblStep15Power);
        lblStep15Power.setBounds(150, 560, 100, 40);

        edtStep15MaxPressure.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        edtStep15MaxPressure.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtStep15MaxPressure.setNextFocusableComponent(spnStep15MaxPressureExp);
        add(edtStep15MaxPressure);
        edtStep15MaxPressure.setBounds(270, 560, 90, 40);

        lblStep15_10.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep15_10.setText(" · 10");
        lblStep15_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblStep15_10);
        lblStep15_10.setBounds(360, 560, 60, 40);

        spnStep15MaxPressureExp.setModel(new javax.swing.SpinnerNumberModel(-5, -6, -4, 1));
        spnStep15MaxPressureExp.setNextFocusableComponent(edtStep16MaxPressure);
        add(spnStep15MaxPressureExp);
        spnStep15MaxPressureExp.setBounds(420, 560, 50, 26);

        lblStep16Icon.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep16Icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep16Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep16Icon.setOpaque(true);
        add(lblStep16Icon);
        lblStep16Icon.setBounds(0, 600, 30, 40);

        lblStep16TimeTotal.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep16TimeTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep16TimeTotal.setText("-");
        lblStep16TimeTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep16TimeTotal.setOpaque(true);
        add(lblStep16TimeTotal);
        lblStep16TimeTotal.setBounds(30, 600, 100, 40);

        lblStep16Power.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep16Power.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep16Power.setText("-");
        lblStep16Power.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep16Power.setOpaque(true);
        add(lblStep16Power);
        lblStep16Power.setBounds(150, 600, 100, 40);

        edtStep16MaxPressure.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        edtStep16MaxPressure.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtStep16MaxPressure.setNextFocusableComponent(spnStep16MaxPressureExp);
        add(edtStep16MaxPressure);
        edtStep16MaxPressure.setBounds(270, 600, 90, 40);

        lblStep16_10.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep16_10.setText(" · 10");
        lblStep16_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblStep16_10);
        lblStep16_10.setBounds(360, 600, 60, 40);

        spnStep16MaxPressureExp.setModel(new javax.swing.SpinnerNumberModel(-5, -6, -4, 1));
        spnStep16MaxPressureExp.setNextFocusableComponent(edtStep17MaxPressure);
        add(spnStep16MaxPressureExp);
        spnStep16MaxPressureExp.setBounds(420, 600, 50, 26);

        lblStep17Icon.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep17Icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep17Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep17Icon.setOpaque(true);
        add(lblStep17Icon);
        lblStep17Icon.setBounds(0, 640, 30, 40);

        lblStep17TimeTotal.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep17TimeTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep17TimeTotal.setText("-");
        lblStep17TimeTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep17TimeTotal.setOpaque(true);
        add(lblStep17TimeTotal);
        lblStep17TimeTotal.setBounds(30, 640, 100, 40);

        lblStep17Power.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep17Power.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep17Power.setText("-");
        lblStep17Power.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep17Power.setOpaque(true);
        add(lblStep17Power);
        lblStep17Power.setBounds(150, 640, 100, 40);

        edtStep17MaxPressure.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        edtStep17MaxPressure.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtStep17MaxPressure.setNextFocusableComponent(spnStep17MaxPressureExp);
        add(edtStep17MaxPressure);
        edtStep17MaxPressure.setBounds(270, 640, 90, 40);

        lblStep17_10.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep17_10.setText(" · 10");
        lblStep17_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblStep17_10);
        lblStep17_10.setBounds(360, 640, 60, 40);

        spnStep17MaxPressureExp.setModel(new javax.swing.SpinnerNumberModel(-5, -6, -4, 1));
        add(spnStep17MaxPressureExp);
        spnStep17MaxPressureExp.setBounds(420, 640, 50, 26);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField edtStep10MaxPressure;
    public javax.swing.JTextField edtStep11MaxPressure;
    public javax.swing.JTextField edtStep12MaxPressure;
    public javax.swing.JTextField edtStep13MaxPressure;
    public javax.swing.JTextField edtStep14MaxPressure;
    public javax.swing.JTextField edtStep15MaxPressure;
    public javax.swing.JTextField edtStep16MaxPressure;
    public javax.swing.JTextField edtStep17MaxPressure;
    public javax.swing.JTextField edtStep1MaxPressure;
    public javax.swing.JTextField edtStep2MaxPressure;
    public javax.swing.JTextField edtStep3MaxPressure;
    public javax.swing.JTextField edtStep4MaxPressure;
    public javax.swing.JTextField edtStep5MaxPressure;
    public javax.swing.JTextField edtStep6MaxPressure;
    public javax.swing.JTextField edtStep7MaxPressure;
    public javax.swing.JTextField edtStep8MaxPressure;
    public javax.swing.JTextField edtStep9MaxPressure;
    private javax.swing.JLabel lblStep10Icon;
    private javax.swing.JLabel lblStep10Power;
    private javax.swing.JLabel lblStep10TimeTotal;
    public javax.swing.JLabel lblStep10_10;
    private javax.swing.JLabel lblStep11Icon;
    private javax.swing.JLabel lblStep11Power;
    private javax.swing.JLabel lblStep11TimeTotal;
    public javax.swing.JLabel lblStep11_10;
    private javax.swing.JLabel lblStep12Icon;
    private javax.swing.JLabel lblStep12Power;
    private javax.swing.JLabel lblStep12TimeTotal;
    public javax.swing.JLabel lblStep12_10;
    private javax.swing.JLabel lblStep13Icon;
    private javax.swing.JLabel lblStep13Power;
    private javax.swing.JLabel lblStep13TimeTotal;
    public javax.swing.JLabel lblStep13_10;
    private javax.swing.JLabel lblStep14Icon;
    private javax.swing.JLabel lblStep14Power;
    private javax.swing.JLabel lblStep14TimeTotal;
    public javax.swing.JLabel lblStep14_10;
    private javax.swing.JLabel lblStep15Icon;
    private javax.swing.JLabel lblStep15Power;
    private javax.swing.JLabel lblStep15TimeTotal;
    public javax.swing.JLabel lblStep15_10;
    private javax.swing.JLabel lblStep16Icon;
    private javax.swing.JLabel lblStep16Power;
    private javax.swing.JLabel lblStep16TimeTotal;
    public javax.swing.JLabel lblStep16_10;
    private javax.swing.JLabel lblStep17Icon;
    private javax.swing.JLabel lblStep17Power;
    private javax.swing.JLabel lblStep17TimeTotal;
    public javax.swing.JLabel lblStep17_10;
    private javax.swing.JLabel lblStep1Icon;
    private javax.swing.JLabel lblStep1Power;
    private javax.swing.JLabel lblStep1TimeTotal;
    public javax.swing.JLabel lblStep1_10;
    private javax.swing.JLabel lblStep2Icon;
    private javax.swing.JLabel lblStep2Power;
    private javax.swing.JLabel lblStep2TimeTotal;
    public javax.swing.JLabel lblStep2_10;
    private javax.swing.JLabel lblStep3Icon;
    private javax.swing.JLabel lblStep3Power;
    private javax.swing.JLabel lblStep3TimeTotal;
    public javax.swing.JLabel lblStep3_10;
    private javax.swing.JLabel lblStep4Icon;
    private javax.swing.JLabel lblStep4Power;
    private javax.swing.JLabel lblStep4TimeTotal;
    public javax.swing.JLabel lblStep4_10;
    private javax.swing.JLabel lblStep5Icon;
    private javax.swing.JLabel lblStep5Power;
    private javax.swing.JLabel lblStep5TimeTotal;
    public javax.swing.JLabel lblStep5_10;
    private javax.swing.JLabel lblStep6Icon;
    private javax.swing.JLabel lblStep6Power;
    private javax.swing.JLabel lblStep6TimeTotal;
    public javax.swing.JLabel lblStep6_10;
    private javax.swing.JLabel lblStep7Icon;
    private javax.swing.JLabel lblStep7Power;
    private javax.swing.JLabel lblStep7TimeTotal;
    public javax.swing.JLabel lblStep7_10;
    private javax.swing.JLabel lblStep8Icon;
    private javax.swing.JLabel lblStep8Power;
    private javax.swing.JLabel lblStep8TimeTotal;
    public javax.swing.JLabel lblStep8_10;
    private javax.swing.JLabel lblStep9Icon;
    private javax.swing.JLabel lblStep9Power;
    private javax.swing.JLabel lblStep9TimeTotal;
    public javax.swing.JLabel lblStep9_10;
    public javax.swing.JSpinner spnStep10MaxPressureExp;
    public javax.swing.JSpinner spnStep11MaxPressureExp;
    public javax.swing.JSpinner spnStep12MaxPressureExp;
    public javax.swing.JSpinner spnStep13MaxPressureExp;
    public javax.swing.JSpinner spnStep14MaxPressureExp;
    public javax.swing.JSpinner spnStep15MaxPressureExp;
    public javax.swing.JSpinner spnStep16MaxPressureExp;
    public javax.swing.JSpinner spnStep17MaxPressureExp;
    public javax.swing.JSpinner spnStep1MaxPressureExp;
    public javax.swing.JSpinner spnStep2MaxPressureExp;
    public javax.swing.JSpinner spnStep3MaxPressureExp;
    public javax.swing.JSpinner spnStep4MaxPressureExp;
    public javax.swing.JSpinner spnStep5MaxPressureExp;
    public javax.swing.JSpinner spnStep6MaxPressureExp;
    public javax.swing.JSpinner spnStep7MaxPressureExp;
    public javax.swing.JSpinner spnStep8MaxPressureExp;
    public javax.swing.JSpinner spnStep9MaxPressureExp;
    // End of variables declaration//GEN-END:variables
}
