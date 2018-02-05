/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hvv_admin4.panels;

import hvv_admin4.HVV_Admin4;
import hvv_admin4.HVV_Admin4Constants;
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
public class PanelActivationProgress extends javax.swing.JPanel {
    final HVV_Admin4 theApp;
    
    static Logger logger = Logger.getLogger(PanelActivationProgress.class);
    final Timer m_pRefreshTimer;
    
    public int m_nStep;
    public int m_nStepSecondsLeft;
    public int m_nFlashSeconds;
    
    public boolean m_bTrailingAdded;
    final public PanelActivation m_pParent;
    
    final Color m_clrRed;
    final Color m_clrBlue;
    
    /**
     * Creates new form PanelProcess
     */
    public PanelActivationProgress( HVV_Admin4 app, PanelActivation pParent) {
        theApp = app;
        
        initComponents();
        
        m_clrRed =  new Color( 220, 150, 150);
        m_clrBlue = Color.red;//new Color( 150, 150, 220);
        
        m_pParent = pParent;
        
        m_nStep = -1;
        m_nStepSecondsLeft = -1;
        m_bTrailingAdded = false;
        
        m_pRefreshTimer = new Timer( 1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SetStates();
                if( m_nStep != -1) {
                    m_pParent.m_dlgBigStopWatch.RefreshTime( m_nStepSecondsLeft);
                    if( m_nStepSecondsLeft == 0) {
                        if( m_pParent.btnNext.isEnabled() == false) {
                            if( ++m_nStep == m_pParent.m_lstProgram.size() && m_bTrailingAdded)
                                m_pRefreshTimer.stop();
                            m_pParent.btnNext.setEnabled( true);
                            ( ( TechProcessHFInfo) theApp.SecretSteps().get( "162")).SetCurrentStep( m_nStep);
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
                                    lblStep16Icon, lblStep17Icon, lblStep18Icon, lblStep19Icon, lblStep20Icon,
                                    lblStep21Icon, lblStep22Icon, lblStep23Icon, lblStep24Icon, lblStep25Icon,
                                    lblStep26Icon, lblStep27Icon, lblStep28Icon, lblStep29Icon, lblStep30Icon,
                                    lblStep31Icon, lblStep32Icon};
        
        JLabel [] m_StepsTTotal = { lblStep1TimeTotal,  lblStep2TimeTotal,  lblStep3TimeTotal,  lblStep4TimeTotal,  lblStep5TimeTotal,
                                    lblStep6TimeTotal,  lblStep7TimeTotal,  lblStep8TimeTotal,  lblStep9TimeTotal,  lblStep10TimeTotal,
                                    lblStep11TimeTotal, lblStep12TimeTotal, lblStep13TimeTotal, lblStep14TimeTotal, lblStep15TimeTotal,
                                    lblStep16TimeTotal, lblStep17TimeTotal, lblStep18TimeTotal, lblStep19TimeTotal, lblStep20TimeTotal,
                                    lblStep21TimeTotal, lblStep22TimeTotal, lblStep23TimeTotal, lblStep24TimeTotal, lblStep25TimeTotal,
                                    lblStep26TimeTotal, lblStep27TimeTotal, lblStep28TimeTotal, lblStep29TimeTotal, lblStep30TimeTotal,
                                    lblStep31TimeTotal, lblStep32TimeTotal};
        
        JLabel [] m_StepsPower  = { lblStep1Power,  lblStep2Power,  lblStep3Power,  lblStep4Power,  lblStep5Power,
                                    lblStep6Power,  lblStep7Power,  lblStep8Power,  lblStep9Power,  lblStep10Power, 
                                    lblStep11Power, lblStep12Power, lblStep13Power, lblStep14Power, lblStep15Power,
                                    lblStep16Power, lblStep17Power, lblStep18Power, lblStep19Power, lblStep20Power, 
                                    lblStep21Power, lblStep22Power, lblStep23Power, lblStep24Power, lblStep25Power,
                                    lblStep26Power, lblStep27Power, lblStep28Power, lblStep29Power, lblStep30Power,
                                    lblStep31Power, lblStep32Power};
        
        JTextField [] m_StepsPM = { edtStep1MaxPressure,  edtStep2MaxPressure,  edtStep3MaxPressure,  edtStep4MaxPressure,  edtStep5MaxPressure,
                                    edtStep6MaxPressure,  edtStep7MaxPressure,  edtStep8MaxPressure,  edtStep9MaxPressure,  edtStep10MaxPressure,
                                    edtStep11MaxPressure, edtStep12MaxPressure, edtStep13MaxPressure, edtStep14MaxPressure, edtStep15MaxPressure,
                                    edtStep16MaxPressure, edtStep17MaxPressure, edtStep18MaxPressure, edtStep19MaxPressure, edtStep20MaxPressure,
                                    edtStep21MaxPressure, edtStep22MaxPressure, edtStep23MaxPressure, edtStep24MaxPressure, edtStep25MaxPressure,
                                    edtStep26MaxPressure, edtStep27MaxPressure, edtStep28MaxPressure, edtStep29MaxPressure, edtStep30MaxPressure,
                                    edtStep31MaxPressure, edtStep32MaxPressure };
                
        JLabel     [] m_StepsPB = { lblStep1_10,  lblStep2_10,  lblStep3_10,  lblStep4_10,  lblStep5_10,
                                    lblStep6_10,  lblStep7_10,  lblStep8_10,  lblStep9_10,  lblStep10_10,
                                    lblStep11_10, lblStep12_10, lblStep13_10, lblStep14_10, lblStep15_10,
                                    lblStep16_10, lblStep17_10, lblStep18_10, lblStep19_10, lblStep20_10,
                                    lblStep21_10, lblStep22_10, lblStep23_10, lblStep24_10, lblStep25_10,
                                    lblStep26_10, lblStep27_10, lblStep28_10, lblStep29_10, lblStep30_10,
                                    lblStep31_10, lblStep32_10 };
        
        JSpinner [] m_StepsPE   = { spnStep1MaxPressureExp,  spnStep2MaxPressureExp,  spnStep3MaxPressureExp,  spnStep4MaxPressureExp,  spnStep5MaxPressureExp,
                                    spnStep6MaxPressureExp,  spnStep7MaxPressureExp,  spnStep8MaxPressureExp,  spnStep9MaxPressureExp,  spnStep10MaxPressureExp,
                                    spnStep11MaxPressureExp, spnStep12MaxPressureExp, spnStep13MaxPressureExp, spnStep14MaxPressureExp, spnStep15MaxPressureExp,
                                    spnStep16MaxPressureExp, spnStep17MaxPressureExp, spnStep18MaxPressureExp, spnStep19MaxPressureExp, spnStep20MaxPressureExp,
                                    spnStep21MaxPressureExp, spnStep22MaxPressureExp, spnStep23MaxPressureExp, spnStep24MaxPressureExp, spnStep25MaxPressureExp,
                                    spnStep26MaxPressureExp, spnStep27MaxPressureExp, spnStep28MaxPressureExp, spnStep29MaxPressureExp, spnStep30MaxPressureExp,
                                    spnStep31MaxPressureExp, spnStep32MaxPressureExp };

        for( int i=0; i < 32; i++) {
            
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
                if( m_nStep >= 0) {
                    m_StepsIcon[i].setIcon( i == m_nStep ? theApp.GetResources().getIconTriaRight() : null);
                }
                
                if( m_nFlashSeconds > 0) {
                    if( m_nStep == i) {
                        if( m_nStepSecondsLeft == 0) {
                            m_StepsIcon[i].setBackground(   ( ( m_nFlashSeconds % 2) == 0) ? m_clrBlue : null);
                            //m_StepsTTotal[i].setBackground( ( ( m_nFlashSeconds % 2) == 0) ? m_clrBlue : null);
                            //m_StepsPower[i].setBackground(  ( ( m_nFlashSeconds % 2) == 0) ? m_clrBlue : null);
                        }
                        else {
                            m_StepsIcon[i].setBackground(   ( ( m_nFlashSeconds % 2) == 0) ? m_clrRed : null);
                            //m_StepsTTotal[i].setBackground( ( ( m_nFlashSeconds % 2) == 0) ? m_clrRed : null);
                            //m_StepsPower[i].setBackground(  ( ( m_nFlashSeconds % 2) == 0) ? m_clrRed : null);
                        }

                        m_nFlashSeconds--;
                    }
                }
                
                m_StepsTTotal[i].setText( "");
                m_StepsPower[i].setText( "");
            }
        }
        
        //прячем контролы под кнопками "добавить этап"
        for( int i=0; i<24; i++) {
            if( m_bTrailingAdded) {
                //если этап уже добавили и кнопки не нужны, все элементы ввода давдений видны
                m_StepsPM[ i].setVisible( true);
                m_StepsPE[ i].setVisible( true);
            }
            else {
                //прячем контролы под кнопками "добавить этап"
                if( i == m_pParent.m_lstProgram.size() ||  i == m_pParent.m_lstProgram.size() + 1) {
                    m_StepsPM[ i].setVisible( false);
                    m_StepsPE[ i].setVisible( false);
                }
                else {
                    m_StepsPM[ i].setVisible( true);
                    m_StepsPE[ i].setVisible( true);
                }
            }
        }
        
        if( m_bTrailingAdded) {
            edtTrailingTime.setVisible( false);
            edtTrailingPower.setVisible( false);
            btnAddStep.setVisible( false);
            btnAddTrailingSteps.setVisible( false);
        }
        else {
            edtTrailingTime.setLocation(  edtTrailingTime.getX(), 40 * m_pParent.m_lstProgram.size());
            edtTrailingPower.setLocation( edtTrailingPower.getX(), 40 * m_pParent.m_lstProgram.size());
            btnAddStep.setLocation( btnAddStep.getX(), 40 * m_pParent.m_lstProgram.size());

            btnAddTrailingSteps.setLocation( btnAddTrailingSteps.getX(), 40 * ( m_pParent.m_lstProgram.size() + 1));
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

        edtTrailingTime = new javax.swing.JTextField();
        edtTrailingPower = new javax.swing.JTextField();
        btnAddStep = new javax.swing.JButton();
        btnAddTrailingSteps = new javax.swing.JButton();
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
        lblStep18Icon = new javax.swing.JLabel();
        lblStep18TimeTotal = new javax.swing.JLabel();
        lblStep18Power = new javax.swing.JLabel();
        edtStep18MaxPressure = new javax.swing.JTextField();
        lblStep18_10 = new javax.swing.JLabel();
        spnStep18MaxPressureExp = new javax.swing.JSpinner();
        lblStep19Icon = new javax.swing.JLabel();
        lblStep19TimeTotal = new javax.swing.JLabel();
        lblStep19Power = new javax.swing.JLabel();
        edtStep19MaxPressure = new javax.swing.JTextField();
        lblStep19_10 = new javax.swing.JLabel();
        spnStep19MaxPressureExp = new javax.swing.JSpinner();
        lblStep20Icon = new javax.swing.JLabel();
        lblStep20TimeTotal = new javax.swing.JLabel();
        lblStep20Power = new javax.swing.JLabel();
        edtStep20MaxPressure = new javax.swing.JTextField();
        lblStep20_10 = new javax.swing.JLabel();
        spnStep20MaxPressureExp = new javax.swing.JSpinner();
        lblStep21Icon = new javax.swing.JLabel();
        lblStep21TimeTotal = new javax.swing.JLabel();
        lblStep21Power = new javax.swing.JLabel();
        edtStep21MaxPressure = new javax.swing.JTextField();
        lblStep21_10 = new javax.swing.JLabel();
        spnStep21MaxPressureExp = new javax.swing.JSpinner();
        lblStep22Icon = new javax.swing.JLabel();
        lblStep22TimeTotal = new javax.swing.JLabel();
        lblStep22Power = new javax.swing.JLabel();
        edtStep22MaxPressure = new javax.swing.JTextField();
        lblStep22_10 = new javax.swing.JLabel();
        spnStep22MaxPressureExp = new javax.swing.JSpinner();
        lblStep23Icon = new javax.swing.JLabel();
        lblStep23TimeTotal = new javax.swing.JLabel();
        lblStep23Power = new javax.swing.JLabel();
        edtStep23MaxPressure = new javax.swing.JTextField();
        lblStep23_10 = new javax.swing.JLabel();
        spnStep23MaxPressureExp = new javax.swing.JSpinner();
        lblStep24Icon = new javax.swing.JLabel();
        lblStep24TimeTotal = new javax.swing.JLabel();
        lblStep24Power = new javax.swing.JLabel();
        edtStep24MaxPressure = new javax.swing.JTextField();
        lblStep24_10 = new javax.swing.JLabel();
        spnStep24MaxPressureExp = new javax.swing.JSpinner();
        lblStep25Icon = new javax.swing.JLabel();
        lblStep25TimeTotal = new javax.swing.JLabel();
        lblStep25Power = new javax.swing.JLabel();
        edtStep25MaxPressure = new javax.swing.JTextField();
        lblStep25_10 = new javax.swing.JLabel();
        spnStep25MaxPressureExp = new javax.swing.JSpinner();
        lblStep26Icon = new javax.swing.JLabel();
        lblStep26TimeTotal = new javax.swing.JLabel();
        lblStep26Power = new javax.swing.JLabel();
        edtStep26MaxPressure = new javax.swing.JTextField();
        lblStep26_10 = new javax.swing.JLabel();
        spnStep26MaxPressureExp = new javax.swing.JSpinner();
        lblStep27Icon = new javax.swing.JLabel();
        lblStep27TimeTotal = new javax.swing.JLabel();
        lblStep27Power = new javax.swing.JLabel();
        edtStep27MaxPressure = new javax.swing.JTextField();
        lblStep27_10 = new javax.swing.JLabel();
        spnStep27MaxPressureExp = new javax.swing.JSpinner();
        lblStep28Icon = new javax.swing.JLabel();
        lblStep28TimeTotal = new javax.swing.JLabel();
        lblStep28Power = new javax.swing.JLabel();
        edtStep28MaxPressure = new javax.swing.JTextField();
        lblStep28_10 = new javax.swing.JLabel();
        spnStep28MaxPressureExp = new javax.swing.JSpinner();
        lblStep29Icon = new javax.swing.JLabel();
        lblStep29TimeTotal = new javax.swing.JLabel();
        lblStep29Power = new javax.swing.JLabel();
        edtStep29MaxPressure = new javax.swing.JTextField();
        lblStep29_10 = new javax.swing.JLabel();
        spnStep29MaxPressureExp = new javax.swing.JSpinner();
        lblStep30Icon = new javax.swing.JLabel();
        lblStep30TimeTotal = new javax.swing.JLabel();
        lblStep30Power = new javax.swing.JLabel();
        edtStep30MaxPressure = new javax.swing.JTextField();
        lblStep30_10 = new javax.swing.JLabel();
        spnStep30MaxPressureExp = new javax.swing.JSpinner();
        lblStep31Icon = new javax.swing.JLabel();
        lblStep31TimeTotal = new javax.swing.JLabel();
        lblStep31Power = new javax.swing.JLabel();
        edtStep31MaxPressure = new javax.swing.JTextField();
        lblStep31_10 = new javax.swing.JLabel();
        spnStep31MaxPressureExp = new javax.swing.JSpinner();
        lblStep32Icon = new javax.swing.JLabel();
        lblStep32TimeTotal = new javax.swing.JLabel();
        lblStep32Power = new javax.swing.JLabel();
        edtStep32MaxPressure = new javax.swing.JTextField();
        lblStep32_10 = new javax.swing.JLabel();
        spnStep32MaxPressureExp = new javax.swing.JSpinner();

        setFocusTraversalPolicyProvider(true);
        setMaximumSize(new java.awt.Dimension(580, 1320));
        setMinimumSize(new java.awt.Dimension(580, 1320));
        setPreferredSize(new java.awt.Dimension(580, 1320));
        setLayout(null);

        edtTrailingTime.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        edtTrailingTime.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtTrailingTime.setNextFocusableComponent(edtTrailingPower);
        add(edtTrailingTime);
        edtTrailingTime.setBounds(30, 80, 120, 40);

        edtTrailingPower.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        edtTrailingPower.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        add(edtTrailingPower);
        edtTrailingPower.setBounds(150, 80, 120, 40);

        btnAddStep.setText("Добавить этап");
        btnAddStep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddStepActionPerformed(evt);
            }
        });
        add(btnAddStep);
        btnAddStep.setBounds(270, 80, 200, 40);

        btnAddTrailingSteps.setText("Добавить завершающие шаги");
        btnAddTrailingSteps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTrailingStepsActionPerformed(evt);
            }
        });
        add(btnAddTrailingSteps);
        btnAddTrailingSteps.setBounds(30, 120, 440, 40);

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
        lblStep1TimeTotal.setBounds(30, 0, 120, 40);

        lblStep1Power.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep1Power.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep1Power.setText("-");
        lblStep1Power.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep1Power.setOpaque(true);
        add(lblStep1Power);
        lblStep1Power.setBounds(150, 0, 120, 40);

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
        lblStep2TimeTotal.setBounds(30, 40, 120, 40);

        lblStep2Power.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep2Power.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep2Power.setText("-");
        lblStep2Power.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep2Power.setOpaque(true);
        add(lblStep2Power);
        lblStep2Power.setBounds(150, 40, 120, 40);

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
        lblStep3TimeTotal.setBounds(30, 80, 120, 40);

        lblStep3Power.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep3Power.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep3Power.setText("-");
        lblStep3Power.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep3Power.setOpaque(true);
        add(lblStep3Power);
        lblStep3Power.setBounds(150, 80, 120, 40);

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
        lblStep4TimeTotal.setBounds(30, 120, 120, 40);

        lblStep4Power.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep4Power.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep4Power.setText("-");
        lblStep4Power.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep4Power.setOpaque(true);
        add(lblStep4Power);
        lblStep4Power.setBounds(150, 120, 120, 40);

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
        lblStep5TimeTotal.setBounds(30, 160, 120, 40);

        lblStep5Power.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep5Power.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep5Power.setText("-");
        lblStep5Power.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep5Power.setOpaque(true);
        add(lblStep5Power);
        lblStep5Power.setBounds(150, 160, 120, 40);

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
        lblStep6TimeTotal.setBounds(30, 200, 120, 40);

        lblStep6Power.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep6Power.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep6Power.setText("-");
        lblStep6Power.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep6Power.setOpaque(true);
        add(lblStep6Power);
        lblStep6Power.setBounds(150, 200, 120, 40);

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
        lblStep7TimeTotal.setBounds(30, 240, 120, 40);

        lblStep7Power.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep7Power.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep7Power.setText("-");
        lblStep7Power.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep7Power.setOpaque(true);
        add(lblStep7Power);
        lblStep7Power.setBounds(150, 240, 120, 40);

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
        lblStep8TimeTotal.setBounds(30, 280, 120, 40);

        lblStep8Power.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep8Power.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep8Power.setText("-");
        lblStep8Power.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep8Power.setOpaque(true);
        add(lblStep8Power);
        lblStep8Power.setBounds(150, 280, 120, 40);

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
        lblStep9TimeTotal.setBounds(30, 320, 120, 40);

        lblStep9Power.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep9Power.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep9Power.setText("-");
        lblStep9Power.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep9Power.setOpaque(true);
        add(lblStep9Power);
        lblStep9Power.setBounds(150, 320, 120, 40);

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

        lblStep10Icon.setFont(new java.awt.Font("Cantarell", 0, 10)); // NOI18N
        lblStep10Icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep10Icon.setText("10");
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
        lblStep10TimeTotal.setBounds(30, 360, 120, 40);

        lblStep10Power.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep10Power.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep10Power.setText("-");
        lblStep10Power.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep10Power.setOpaque(true);
        add(lblStep10Power);
        lblStep10Power.setBounds(150, 360, 120, 40);

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
        lblStep11TimeTotal.setBounds(30, 400, 120, 40);

        lblStep11Power.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep11Power.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep11Power.setText("-");
        lblStep11Power.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep11Power.setOpaque(true);
        add(lblStep11Power);
        lblStep11Power.setBounds(150, 400, 120, 40);

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
        lblStep12TimeTotal.setBounds(30, 440, 120, 40);

        lblStep12Power.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep12Power.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep12Power.setText("-");
        lblStep12Power.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep12Power.setOpaque(true);
        add(lblStep12Power);
        lblStep12Power.setBounds(150, 440, 120, 40);

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
        lblStep13TimeTotal.setBounds(30, 480, 120, 40);

        lblStep13Power.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep13Power.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep13Power.setText("-");
        lblStep13Power.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep13Power.setOpaque(true);
        add(lblStep13Power);
        lblStep13Power.setBounds(150, 480, 120, 40);

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
        lblStep14TimeTotal.setBounds(30, 520, 120, 40);

        lblStep14Power.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep14Power.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep14Power.setText("-");
        lblStep14Power.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep14Power.setOpaque(true);
        add(lblStep14Power);
        lblStep14Power.setBounds(150, 520, 120, 40);

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
        lblStep15TimeTotal.setBounds(30, 560, 120, 40);

        lblStep15Power.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep15Power.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep15Power.setText("-");
        lblStep15Power.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep15Power.setOpaque(true);
        add(lblStep15Power);
        lblStep15Power.setBounds(150, 560, 120, 40);

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
        lblStep16TimeTotal.setBounds(30, 600, 120, 40);

        lblStep16Power.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep16Power.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep16Power.setText("-");
        lblStep16Power.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep16Power.setOpaque(true);
        add(lblStep16Power);
        lblStep16Power.setBounds(150, 600, 120, 40);

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
        lblStep17TimeTotal.setBounds(30, 640, 120, 40);

        lblStep17Power.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep17Power.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep17Power.setText("-");
        lblStep17Power.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep17Power.setOpaque(true);
        add(lblStep17Power);
        lblStep17Power.setBounds(150, 640, 120, 40);

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
        spnStep17MaxPressureExp.setNextFocusableComponent(edtStep18MaxPressure);
        add(spnStep17MaxPressureExp);
        spnStep17MaxPressureExp.setBounds(420, 640, 50, 26);

        lblStep18Icon.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep18Icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep18Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep18Icon.setOpaque(true);
        add(lblStep18Icon);
        lblStep18Icon.setBounds(0, 680, 30, 40);

        lblStep18TimeTotal.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep18TimeTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep18TimeTotal.setText("-");
        lblStep18TimeTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep18TimeTotal.setOpaque(true);
        add(lblStep18TimeTotal);
        lblStep18TimeTotal.setBounds(30, 680, 120, 40);

        lblStep18Power.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep18Power.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep18Power.setText("-");
        lblStep18Power.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep18Power.setOpaque(true);
        add(lblStep18Power);
        lblStep18Power.setBounds(150, 680, 120, 40);

        edtStep18MaxPressure.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        edtStep18MaxPressure.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtStep18MaxPressure.setNextFocusableComponent(spnStep18MaxPressureExp);
        add(edtStep18MaxPressure);
        edtStep18MaxPressure.setBounds(270, 680, 90, 40);

        lblStep18_10.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep18_10.setText(" · 10");
        lblStep18_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblStep18_10);
        lblStep18_10.setBounds(360, 680, 60, 40);

        spnStep18MaxPressureExp.setModel(new javax.swing.SpinnerNumberModel(-5, -6, -4, 1));
        spnStep18MaxPressureExp.setNextFocusableComponent(edtStep19MaxPressure);
        add(spnStep18MaxPressureExp);
        spnStep18MaxPressureExp.setBounds(420, 680, 50, 26);

        lblStep19Icon.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep19Icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep19Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep19Icon.setOpaque(true);
        add(lblStep19Icon);
        lblStep19Icon.setBounds(0, 720, 30, 40);

        lblStep19TimeTotal.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep19TimeTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep19TimeTotal.setText("-");
        lblStep19TimeTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep19TimeTotal.setOpaque(true);
        add(lblStep19TimeTotal);
        lblStep19TimeTotal.setBounds(30, 720, 120, 40);

        lblStep19Power.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep19Power.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep19Power.setText("-");
        lblStep19Power.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep19Power.setOpaque(true);
        add(lblStep19Power);
        lblStep19Power.setBounds(150, 720, 120, 40);

        edtStep19MaxPressure.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        edtStep19MaxPressure.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtStep19MaxPressure.setNextFocusableComponent(spnStep19MaxPressureExp);
        add(edtStep19MaxPressure);
        edtStep19MaxPressure.setBounds(270, 720, 90, 40);

        lblStep19_10.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep19_10.setText(" · 10");
        lblStep19_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblStep19_10);
        lblStep19_10.setBounds(360, 720, 60, 40);

        spnStep19MaxPressureExp.setModel(new javax.swing.SpinnerNumberModel(-5, -6, -4, 1));
        spnStep19MaxPressureExp.setNextFocusableComponent(edtStep20MaxPressure);
        add(spnStep19MaxPressureExp);
        spnStep19MaxPressureExp.setBounds(420, 720, 50, 26);

        lblStep20Icon.setFont(new java.awt.Font("Cantarell", 0, 10)); // NOI18N
        lblStep20Icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep20Icon.setText("20");
        lblStep20Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep20Icon.setOpaque(true);
        add(lblStep20Icon);
        lblStep20Icon.setBounds(0, 760, 30, 40);

        lblStep20TimeTotal.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep20TimeTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep20TimeTotal.setText("-");
        lblStep20TimeTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep20TimeTotal.setOpaque(true);
        add(lblStep20TimeTotal);
        lblStep20TimeTotal.setBounds(30, 760, 120, 40);

        lblStep20Power.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep20Power.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep20Power.setText("-");
        lblStep20Power.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep20Power.setOpaque(true);
        add(lblStep20Power);
        lblStep20Power.setBounds(150, 760, 120, 40);

        edtStep20MaxPressure.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        edtStep20MaxPressure.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtStep20MaxPressure.setNextFocusableComponent(spnStep20MaxPressureExp);
        add(edtStep20MaxPressure);
        edtStep20MaxPressure.setBounds(270, 760, 90, 40);

        lblStep20_10.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep20_10.setText(" · 10");
        lblStep20_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblStep20_10);
        lblStep20_10.setBounds(360, 760, 60, 40);

        spnStep20MaxPressureExp.setModel(new javax.swing.SpinnerNumberModel(-5, -6, -4, 1));
        spnStep20MaxPressureExp.setNextFocusableComponent(edtStep21MaxPressure);
        add(spnStep20MaxPressureExp);
        spnStep20MaxPressureExp.setBounds(420, 760, 50, 26);

        lblStep21Icon.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep21Icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep21Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep21Icon.setOpaque(true);
        add(lblStep21Icon);
        lblStep21Icon.setBounds(0, 800, 30, 40);

        lblStep21TimeTotal.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep21TimeTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep21TimeTotal.setText("-");
        lblStep21TimeTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep21TimeTotal.setOpaque(true);
        add(lblStep21TimeTotal);
        lblStep21TimeTotal.setBounds(30, 800, 120, 40);

        lblStep21Power.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep21Power.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep21Power.setText("-");
        lblStep21Power.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep21Power.setOpaque(true);
        add(lblStep21Power);
        lblStep21Power.setBounds(150, 800, 120, 40);

        edtStep21MaxPressure.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        edtStep21MaxPressure.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtStep21MaxPressure.setNextFocusableComponent(spnStep21MaxPressureExp);
        add(edtStep21MaxPressure);
        edtStep21MaxPressure.setBounds(270, 800, 90, 40);

        lblStep21_10.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep21_10.setText(" · 10");
        lblStep21_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblStep21_10);
        lblStep21_10.setBounds(360, 800, 60, 40);

        spnStep21MaxPressureExp.setModel(new javax.swing.SpinnerNumberModel(-5, -6, -4, 1));
        spnStep21MaxPressureExp.setNextFocusableComponent(edtStep22MaxPressure);
        add(spnStep21MaxPressureExp);
        spnStep21MaxPressureExp.setBounds(420, 800, 50, 26);

        lblStep22Icon.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep22Icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep22Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep22Icon.setOpaque(true);
        add(lblStep22Icon);
        lblStep22Icon.setBounds(0, 840, 30, 40);

        lblStep22TimeTotal.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep22TimeTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep22TimeTotal.setText("-");
        lblStep22TimeTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep22TimeTotal.setOpaque(true);
        add(lblStep22TimeTotal);
        lblStep22TimeTotal.setBounds(30, 840, 120, 40);

        lblStep22Power.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep22Power.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep22Power.setText("-");
        lblStep22Power.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep22Power.setOpaque(true);
        add(lblStep22Power);
        lblStep22Power.setBounds(150, 840, 120, 40);

        edtStep22MaxPressure.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        edtStep22MaxPressure.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtStep22MaxPressure.setNextFocusableComponent(spnStep22MaxPressureExp);
        add(edtStep22MaxPressure);
        edtStep22MaxPressure.setBounds(270, 840, 90, 40);

        lblStep22_10.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep22_10.setText(" · 10");
        lblStep22_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblStep22_10);
        lblStep22_10.setBounds(360, 840, 60, 40);

        spnStep22MaxPressureExp.setModel(new javax.swing.SpinnerNumberModel(-5, -6, -4, 1));
        spnStep22MaxPressureExp.setNextFocusableComponent(edtStep23MaxPressure);
        add(spnStep22MaxPressureExp);
        spnStep22MaxPressureExp.setBounds(420, 840, 50, 26);

        lblStep23Icon.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep23Icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep23Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep23Icon.setOpaque(true);
        add(lblStep23Icon);
        lblStep23Icon.setBounds(0, 880, 30, 40);

        lblStep23TimeTotal.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep23TimeTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep23TimeTotal.setText("-");
        lblStep23TimeTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep23TimeTotal.setOpaque(true);
        add(lblStep23TimeTotal);
        lblStep23TimeTotal.setBounds(30, 880, 120, 40);

        lblStep23Power.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep23Power.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep23Power.setText("-");
        lblStep23Power.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep23Power.setOpaque(true);
        add(lblStep23Power);
        lblStep23Power.setBounds(150, 880, 120, 40);

        edtStep23MaxPressure.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        edtStep23MaxPressure.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtStep23MaxPressure.setNextFocusableComponent(spnStep23MaxPressureExp);
        add(edtStep23MaxPressure);
        edtStep23MaxPressure.setBounds(270, 880, 90, 40);

        lblStep23_10.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep23_10.setText(" · 10");
        lblStep23_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblStep23_10);
        lblStep23_10.setBounds(360, 880, 60, 40);

        spnStep23MaxPressureExp.setModel(new javax.swing.SpinnerNumberModel(-5, -6, -4, 1));
        spnStep23MaxPressureExp.setNextFocusableComponent(edtStep24MaxPressure);
        add(spnStep23MaxPressureExp);
        spnStep23MaxPressureExp.setBounds(420, 880, 50, 26);

        lblStep24Icon.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep24Icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep24Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep24Icon.setOpaque(true);
        add(lblStep24Icon);
        lblStep24Icon.setBounds(0, 920, 30, 40);

        lblStep24TimeTotal.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep24TimeTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep24TimeTotal.setText("-");
        lblStep24TimeTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep24TimeTotal.setOpaque(true);
        add(lblStep24TimeTotal);
        lblStep24TimeTotal.setBounds(30, 920, 120, 40);

        lblStep24Power.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep24Power.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep24Power.setText("-");
        lblStep24Power.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep24Power.setOpaque(true);
        add(lblStep24Power);
        lblStep24Power.setBounds(150, 920, 120, 40);

        edtStep24MaxPressure.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        edtStep24MaxPressure.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtStep24MaxPressure.setNextFocusableComponent(spnStep24MaxPressureExp);
        add(edtStep24MaxPressure);
        edtStep24MaxPressure.setBounds(270, 920, 90, 40);

        lblStep24_10.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep24_10.setText(" · 10");
        lblStep24_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblStep24_10);
        lblStep24_10.setBounds(360, 920, 60, 40);

        spnStep24MaxPressureExp.setModel(new javax.swing.SpinnerNumberModel(-5, -6, -4, 1));
        spnStep24MaxPressureExp.setNextFocusableComponent(edtStep25MaxPressure);
        add(spnStep24MaxPressureExp);
        spnStep24MaxPressureExp.setBounds(420, 920, 50, 26);

        lblStep25Icon.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep25Icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep25Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep25Icon.setOpaque(true);
        add(lblStep25Icon);
        lblStep25Icon.setBounds(0, 960, 30, 40);

        lblStep25TimeTotal.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep25TimeTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep25TimeTotal.setText("-");
        lblStep25TimeTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep25TimeTotal.setOpaque(true);
        add(lblStep25TimeTotal);
        lblStep25TimeTotal.setBounds(30, 960, 120, 40);

        lblStep25Power.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep25Power.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep25Power.setText("-");
        lblStep25Power.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep25Power.setOpaque(true);
        add(lblStep25Power);
        lblStep25Power.setBounds(150, 960, 120, 40);

        edtStep25MaxPressure.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        edtStep25MaxPressure.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtStep25MaxPressure.setNextFocusableComponent(spnStep25MaxPressureExp);
        add(edtStep25MaxPressure);
        edtStep25MaxPressure.setBounds(270, 960, 90, 40);

        lblStep25_10.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep25_10.setText(" · 10");
        lblStep25_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblStep25_10);
        lblStep25_10.setBounds(360, 960, 60, 40);

        spnStep25MaxPressureExp.setModel(new javax.swing.SpinnerNumberModel(-5, -6, -4, 1));
        spnStep25MaxPressureExp.setNextFocusableComponent(edtStep26MaxPressure);
        add(spnStep25MaxPressureExp);
        spnStep25MaxPressureExp.setBounds(420, 960, 50, 26);

        lblStep26Icon.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep26Icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep26Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep26Icon.setOpaque(true);
        add(lblStep26Icon);
        lblStep26Icon.setBounds(0, 1000, 30, 40);

        lblStep26TimeTotal.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep26TimeTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep26TimeTotal.setText("-");
        lblStep26TimeTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep26TimeTotal.setOpaque(true);
        add(lblStep26TimeTotal);
        lblStep26TimeTotal.setBounds(30, 1000, 120, 40);

        lblStep26Power.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep26Power.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep26Power.setText("-");
        lblStep26Power.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep26Power.setOpaque(true);
        add(lblStep26Power);
        lblStep26Power.setBounds(150, 1000, 120, 40);

        edtStep26MaxPressure.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        edtStep26MaxPressure.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtStep26MaxPressure.setNextFocusableComponent(spnStep26MaxPressureExp);
        add(edtStep26MaxPressure);
        edtStep26MaxPressure.setBounds(270, 1000, 90, 40);

        lblStep26_10.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep26_10.setText(" · 10");
        lblStep26_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblStep26_10);
        lblStep26_10.setBounds(360, 1000, 60, 40);

        spnStep26MaxPressureExp.setModel(new javax.swing.SpinnerNumberModel(-5, -6, -4, 1));
        spnStep26MaxPressureExp.setNextFocusableComponent(edtStep27MaxPressure);
        add(spnStep26MaxPressureExp);
        spnStep26MaxPressureExp.setBounds(420, 1000, 50, 26);

        lblStep27Icon.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep27Icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep27Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep27Icon.setOpaque(true);
        add(lblStep27Icon);
        lblStep27Icon.setBounds(0, 1040, 30, 40);

        lblStep27TimeTotal.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep27TimeTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep27TimeTotal.setText("-");
        lblStep27TimeTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep27TimeTotal.setOpaque(true);
        add(lblStep27TimeTotal);
        lblStep27TimeTotal.setBounds(30, 1040, 120, 40);

        lblStep27Power.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep27Power.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep27Power.setText("-");
        lblStep27Power.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep27Power.setOpaque(true);
        add(lblStep27Power);
        lblStep27Power.setBounds(150, 1040, 120, 40);

        edtStep27MaxPressure.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        edtStep27MaxPressure.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtStep27MaxPressure.setNextFocusableComponent(spnStep27MaxPressureExp);
        add(edtStep27MaxPressure);
        edtStep27MaxPressure.setBounds(270, 1040, 90, 40);

        lblStep27_10.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep27_10.setText(" · 10");
        lblStep27_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblStep27_10);
        lblStep27_10.setBounds(360, 1040, 60, 40);

        spnStep27MaxPressureExp.setModel(new javax.swing.SpinnerNumberModel(-5, -6, -4, 1));
        spnStep27MaxPressureExp.setNextFocusableComponent(edtStep28MaxPressure);
        add(spnStep27MaxPressureExp);
        spnStep27MaxPressureExp.setBounds(420, 1040, 50, 26);

        lblStep28Icon.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep28Icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep28Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep28Icon.setOpaque(true);
        add(lblStep28Icon);
        lblStep28Icon.setBounds(0, 1080, 30, 40);

        lblStep28TimeTotal.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep28TimeTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep28TimeTotal.setText("-");
        lblStep28TimeTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep28TimeTotal.setOpaque(true);
        add(lblStep28TimeTotal);
        lblStep28TimeTotal.setBounds(30, 1080, 120, 40);

        lblStep28Power.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep28Power.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep28Power.setText("-");
        lblStep28Power.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep28Power.setOpaque(true);
        add(lblStep28Power);
        lblStep28Power.setBounds(150, 1080, 120, 40);

        edtStep28MaxPressure.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        edtStep28MaxPressure.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtStep28MaxPressure.setNextFocusableComponent(spnStep28MaxPressureExp);
        add(edtStep28MaxPressure);
        edtStep28MaxPressure.setBounds(270, 1080, 90, 40);

        lblStep28_10.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep28_10.setText(" · 10");
        lblStep28_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblStep28_10);
        lblStep28_10.setBounds(360, 1080, 60, 40);

        spnStep28MaxPressureExp.setModel(new javax.swing.SpinnerNumberModel(-5, -6, -4, 1));
        spnStep28MaxPressureExp.setNextFocusableComponent(edtStep29MaxPressure);
        add(spnStep28MaxPressureExp);
        spnStep28MaxPressureExp.setBounds(420, 1080, 50, 26);

        lblStep29Icon.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep29Icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep29Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep29Icon.setOpaque(true);
        add(lblStep29Icon);
        lblStep29Icon.setBounds(0, 1120, 30, 40);

        lblStep29TimeTotal.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep29TimeTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep29TimeTotal.setText("-");
        lblStep29TimeTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep29TimeTotal.setOpaque(true);
        add(lblStep29TimeTotal);
        lblStep29TimeTotal.setBounds(30, 1120, 120, 40);

        lblStep29Power.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep29Power.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep29Power.setText("-");
        lblStep29Power.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep29Power.setOpaque(true);
        add(lblStep29Power);
        lblStep29Power.setBounds(150, 1120, 120, 40);

        edtStep29MaxPressure.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        edtStep29MaxPressure.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtStep29MaxPressure.setNextFocusableComponent(spnStep29MaxPressureExp);
        add(edtStep29MaxPressure);
        edtStep29MaxPressure.setBounds(270, 1120, 90, 40);

        lblStep29_10.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep29_10.setText(" · 10");
        lblStep29_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblStep29_10);
        lblStep29_10.setBounds(360, 1120, 60, 40);

        spnStep29MaxPressureExp.setModel(new javax.swing.SpinnerNumberModel(-5, -6, -4, 1));
        spnStep29MaxPressureExp.setNextFocusableComponent(edtStep30MaxPressure);
        add(spnStep29MaxPressureExp);
        spnStep29MaxPressureExp.setBounds(420, 1120, 50, 26);

        lblStep30Icon.setFont(new java.awt.Font("Cantarell", 0, 10)); // NOI18N
        lblStep30Icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep30Icon.setText("30");
        lblStep30Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep30Icon.setOpaque(true);
        add(lblStep30Icon);
        lblStep30Icon.setBounds(0, 1160, 30, 40);

        lblStep30TimeTotal.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep30TimeTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep30TimeTotal.setText("-");
        lblStep30TimeTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep30TimeTotal.setOpaque(true);
        add(lblStep30TimeTotal);
        lblStep30TimeTotal.setBounds(30, 1160, 120, 40);

        lblStep30Power.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep30Power.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep30Power.setText("-");
        lblStep30Power.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep30Power.setOpaque(true);
        add(lblStep30Power);
        lblStep30Power.setBounds(150, 1160, 120, 40);

        edtStep30MaxPressure.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        edtStep30MaxPressure.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtStep30MaxPressure.setNextFocusableComponent(spnStep30MaxPressureExp);
        add(edtStep30MaxPressure);
        edtStep30MaxPressure.setBounds(270, 1160, 90, 40);

        lblStep30_10.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep30_10.setText(" · 10");
        lblStep30_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblStep30_10);
        lblStep30_10.setBounds(360, 1160, 60, 40);

        spnStep30MaxPressureExp.setModel(new javax.swing.SpinnerNumberModel(-5, -6, -4, 1));
        spnStep30MaxPressureExp.setNextFocusableComponent(edtStep31MaxPressure);
        add(spnStep30MaxPressureExp);
        spnStep30MaxPressureExp.setBounds(420, 1160, 50, 26);

        lblStep31Icon.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep31Icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep31Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep31Icon.setOpaque(true);
        add(lblStep31Icon);
        lblStep31Icon.setBounds(0, 1200, 30, 40);

        lblStep31TimeTotal.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep31TimeTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep31TimeTotal.setText("-");
        lblStep31TimeTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep31TimeTotal.setOpaque(true);
        add(lblStep31TimeTotal);
        lblStep31TimeTotal.setBounds(30, 1200, 120, 40);

        lblStep31Power.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep31Power.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep31Power.setText("-");
        lblStep31Power.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep31Power.setOpaque(true);
        add(lblStep31Power);
        lblStep31Power.setBounds(150, 1200, 120, 40);

        edtStep31MaxPressure.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        edtStep31MaxPressure.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtStep31MaxPressure.setNextFocusableComponent(spnStep31MaxPressureExp);
        add(edtStep31MaxPressure);
        edtStep31MaxPressure.setBounds(270, 1200, 90, 40);

        lblStep31_10.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep31_10.setText(" · 10");
        lblStep31_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblStep31_10);
        lblStep31_10.setBounds(360, 1200, 60, 40);

        spnStep31MaxPressureExp.setModel(new javax.swing.SpinnerNumberModel(-5, -6, -4, 1));
        spnStep31MaxPressureExp.setNextFocusableComponent(edtStep32MaxPressure);
        add(spnStep31MaxPressureExp);
        spnStep31MaxPressureExp.setBounds(420, 1200, 50, 26);

        lblStep32Icon.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep32Icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep32Icon.setText("x");
        lblStep32Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep32Icon.setOpaque(true);
        add(lblStep32Icon);
        lblStep32Icon.setBounds(0, 1240, 30, 40);

        lblStep32TimeTotal.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep32TimeTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep32TimeTotal.setText("-");
        lblStep32TimeTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep32TimeTotal.setOpaque(true);
        add(lblStep32TimeTotal);
        lblStep32TimeTotal.setBounds(30, 1240, 120, 40);

        lblStep32Power.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep32Power.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep32Power.setText("-");
        lblStep32Power.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblStep32Power.setOpaque(true);
        add(lblStep32Power);
        lblStep32Power.setBounds(150, 1240, 120, 40);

        edtStep32MaxPressure.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        edtStep32MaxPressure.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtStep32MaxPressure.setNextFocusableComponent(spnStep32MaxPressureExp);
        add(edtStep32MaxPressure);
        edtStep32MaxPressure.setBounds(270, 1240, 90, 40);

        lblStep32_10.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblStep32_10.setText(" · 10");
        lblStep32_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblStep32_10);
        lblStep32_10.setBounds(360, 1240, 60, 40);

        spnStep32MaxPressureExp.setModel(new javax.swing.SpinnerNumberModel(-5, -6, -4, 1));
        add(spnStep32MaxPressureExp);
        spnStep32MaxPressureExp.setBounds(420, 1240, 50, 26);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddStepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddStepActionPerformed
        int nDuration = 0;
        int nPower = 0;
        try {
            nDuration = Integer.parseInt( edtTrailingTime.getText());
            nPower    = Integer.parseInt( edtTrailingPower.getText());
        } catch( NumberFormatException ex) {
            logger.warn( "Caught NumberFormatException!", ex);
            return;
        }
        
        if( nDuration > 0 && nDuration < 20) {
            if( nPower > 0 && nPower < 50) {
                m_pParent.m_lstProgram.addLast( new TechProcessDegasationStepInfo( nDuration, nPower));
                SetStates();
            }
        }
        
        edtTrailingTime.setText( "");
        edtTrailingPower.setText( "");
    }//GEN-LAST:event_btnAddStepActionPerformed

    private void btnAddTrailingStepsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTrailingStepsActionPerformed
        m_bTrailingAdded = true;
        
        btnAddStep.setVisible( false);
        btnAddTrailingSteps.setVisible( false);
        edtTrailingTime.setVisible( false);
        edtTrailingPower.setVisible( false);
        
        int nProgramType = 0;
        
        if( theApp.GetProcessedDeviceType() == HVV_Admin4Constants.DEVICE_SMALL) nProgramType += 100;
        else if( theApp.GetProcessedDeviceType() == HVV_Admin4Constants.DEVICE_MEDIUM) nProgramType += 200;
        else nProgramType += 300;
        
        if( m_pParent.radGetterType1.isSelected()) nProgramType += 10;
        else nProgramType += 20;
        
        if( m_pParent.radInductorType1.isSelected()) nProgramType += 1;
        else nProgramType += 2;
        
        switch( nProgramType) {
            //SMALL
            case 111:   //small, get1, ind1    - no
                m_pParent.m_lstProgram.add( new TechProcessDegasationStepInfo( 1,  1));
                m_pParent.m_lstProgram.add( new TechProcessDegasationStepInfo( 2,  1));
            break;
                
            case 112:   //small, get1, ind2    - no
                m_pParent.m_lstProgram.add( new TechProcessDegasationStepInfo( 1,  1));
                m_pParent.m_lstProgram.add( new TechProcessDegasationStepInfo( 2,  1));
            break;
            
            case 121:   //small, get2, ind1    - no
                m_pParent.m_lstProgram.add( new TechProcessDegasationStepInfo( 1,  1));
                m_pParent.m_lstProgram.add( new TechProcessDegasationStepInfo( 2,  1));
            break;
                
            case 122:   //small, get2, ind2    - yes
                m_pParent.m_lstProgram.add( new TechProcessDegasationStepInfo( 2, 18));
                m_pParent.m_lstProgram.add( new TechProcessDegasationStepInfo( 2, 16));
                if( theApp.GetSettings().GetDebugShortenProgItems() == false) {
                    m_pParent.m_lstProgram.add( new TechProcessDegasationStepInfo( 2, 14));
                    m_pParent.m_lstProgram.add( new TechProcessDegasationStepInfo( 2, 12));
                    m_pParent.m_lstProgram.add( new TechProcessDegasationStepInfo( 2, 10));
                    m_pParent.m_lstProgram.add( new TechProcessDegasationStepInfo( 2, 8));
                    m_pParent.m_lstProgram.add( new TechProcessDegasationStepInfo( 2, 6));
                    m_pParent.m_lstProgram.add( new TechProcessDegasationStepInfo( 2, 4));
                    m_pParent.m_lstProgram.add( new TechProcessDegasationStepInfo( 2, 2));
                }
            break;
                
                
            //MEDIUM
            case 211:   //small, get1, ind1    - no
                m_pParent.m_lstProgram.add( new TechProcessDegasationStepInfo( 1,  1));
                m_pParent.m_lstProgram.add( new TechProcessDegasationStepInfo( 2,  1));
            break;
                
            case 212:   //small, get1, ind2    - no
                m_pParent.m_lstProgram.add( new TechProcessDegasationStepInfo( 1,  1));
                m_pParent.m_lstProgram.add( new TechProcessDegasationStepInfo( 2,  1));
            break;
            
            case 221:   //small, get2, ind1    - yes
                //m_pParent.m_lstProgram.add( new TechProcessDegasationStepInfo( 5, 35));
                //m_pParent.m_lstProgram.add( new TechProcessDegasationStepInfo( 5, 30));
                m_pParent.m_lstProgram.add( new TechProcessDegasationStepInfo(  5, 25));
                m_pParent.m_lstProgram.add( new TechProcessDegasationStepInfo(  5, 20));
                if( theApp.GetSettings().GetDebugShortenProgItems() == false) {                    
                    m_pParent.m_lstProgram.add( new TechProcessDegasationStepInfo(  3, 15));
                    m_pParent.m_lstProgram.add( new TechProcessDegasationStepInfo(  3, 10));
                }
            break;
                
            case 222:   //small, get2, ind2    - yes
                m_pParent.m_lstProgram.add( new TechProcessDegasationStepInfo( 2,  26));
                m_pParent.m_lstProgram.add( new TechProcessDegasationStepInfo( 2,  24));
                if( theApp.GetSettings().GetDebugShortenProgItems() == false) {
                    m_pParent.m_lstProgram.add( new TechProcessDegasationStepInfo( 2, 22));
                    m_pParent.m_lstProgram.add( new TechProcessDegasationStepInfo( 2, 20));
                    m_pParent.m_lstProgram.add( new TechProcessDegasationStepInfo( 2, 18));
                    m_pParent.m_lstProgram.add( new TechProcessDegasationStepInfo( 2, 16));
                    m_pParent.m_lstProgram.add( new TechProcessDegasationStepInfo( 2, 14));
                    m_pParent.m_lstProgram.add( new TechProcessDegasationStepInfo( 2, 12));
                    m_pParent.m_lstProgram.add( new TechProcessDegasationStepInfo( 2, 10));
                    m_pParent.m_lstProgram.add( new TechProcessDegasationStepInfo( 2, 8));
                    m_pParent.m_lstProgram.add( new TechProcessDegasationStepInfo( 2, 6));
                    m_pParent.m_lstProgram.add( new TechProcessDegasationStepInfo( 2, 4));
                    m_pParent.m_lstProgram.add( new TechProcessDegasationStepInfo( 2, 2));
                }
            break;
                
                
            //BIG
            case 311:   //small, get1, ind1    - no
                m_pParent.m_lstProgram.add( new TechProcessDegasationStepInfo( 1,  1));
                m_pParent.m_lstProgram.add( new TechProcessDegasationStepInfo( 2,  1));
            break;
                
            case 312:   //small, get1, ind2    - no
                m_pParent.m_lstProgram.add( new TechProcessDegasationStepInfo( 1,  1));
                m_pParent.m_lstProgram.add( new TechProcessDegasationStepInfo( 2,  1));
            break;
            
            case 321:   //small, get2, ind1    - no
                m_pParent.m_lstProgram.add( new TechProcessDegasationStepInfo( 1,  1));
                m_pParent.m_lstProgram.add( new TechProcessDegasationStepInfo( 2,  1));
            break;
                
            case 322:   //small, get2, ind2    - no
                m_pParent.m_lstProgram.add( new TechProcessDegasationStepInfo( 1,  1));
                m_pParent.m_lstProgram.add( new TechProcessDegasationStepInfo( 2,  1));
            break;
        }
    }//GEN-LAST:event_btnAddTrailingStepsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAddStep;
    public javax.swing.JButton btnAddTrailingSteps;
    public javax.swing.JTextField edtStep10MaxPressure;
    public javax.swing.JTextField edtStep11MaxPressure;
    public javax.swing.JTextField edtStep12MaxPressure;
    public javax.swing.JTextField edtStep13MaxPressure;
    public javax.swing.JTextField edtStep14MaxPressure;
    public javax.swing.JTextField edtStep15MaxPressure;
    public javax.swing.JTextField edtStep16MaxPressure;
    public javax.swing.JTextField edtStep17MaxPressure;
    public javax.swing.JTextField edtStep18MaxPressure;
    public javax.swing.JTextField edtStep19MaxPressure;
    public javax.swing.JTextField edtStep1MaxPressure;
    public javax.swing.JTextField edtStep20MaxPressure;
    public javax.swing.JTextField edtStep21MaxPressure;
    public javax.swing.JTextField edtStep22MaxPressure;
    public javax.swing.JTextField edtStep23MaxPressure;
    public javax.swing.JTextField edtStep24MaxPressure;
    public javax.swing.JTextField edtStep25MaxPressure;
    public javax.swing.JTextField edtStep26MaxPressure;
    public javax.swing.JTextField edtStep27MaxPressure;
    public javax.swing.JTextField edtStep28MaxPressure;
    public javax.swing.JTextField edtStep29MaxPressure;
    public javax.swing.JTextField edtStep2MaxPressure;
    public javax.swing.JTextField edtStep30MaxPressure;
    public javax.swing.JTextField edtStep31MaxPressure;
    public javax.swing.JTextField edtStep32MaxPressure;
    public javax.swing.JTextField edtStep3MaxPressure;
    public javax.swing.JTextField edtStep4MaxPressure;
    public javax.swing.JTextField edtStep5MaxPressure;
    public javax.swing.JTextField edtStep6MaxPressure;
    public javax.swing.JTextField edtStep7MaxPressure;
    public javax.swing.JTextField edtStep8MaxPressure;
    public javax.swing.JTextField edtStep9MaxPressure;
    public javax.swing.JTextField edtTrailingPower;
    public javax.swing.JTextField edtTrailingTime;
    private javax.swing.JLabel lblStep10Icon;
    public javax.swing.JLabel lblStep10Power;
    public javax.swing.JLabel lblStep10TimeTotal;
    private javax.swing.JLabel lblStep10_10;
    private javax.swing.JLabel lblStep11Icon;
    public javax.swing.JLabel lblStep11Power;
    public javax.swing.JLabel lblStep11TimeTotal;
    private javax.swing.JLabel lblStep11_10;
    private javax.swing.JLabel lblStep12Icon;
    public javax.swing.JLabel lblStep12Power;
    public javax.swing.JLabel lblStep12TimeTotal;
    private javax.swing.JLabel lblStep12_10;
    private javax.swing.JLabel lblStep13Icon;
    public javax.swing.JLabel lblStep13Power;
    public javax.swing.JLabel lblStep13TimeTotal;
    private javax.swing.JLabel lblStep13_10;
    private javax.swing.JLabel lblStep14Icon;
    public javax.swing.JLabel lblStep14Power;
    public javax.swing.JLabel lblStep14TimeTotal;
    private javax.swing.JLabel lblStep14_10;
    private javax.swing.JLabel lblStep15Icon;
    public javax.swing.JLabel lblStep15Power;
    public javax.swing.JLabel lblStep15TimeTotal;
    private javax.swing.JLabel lblStep15_10;
    private javax.swing.JLabel lblStep16Icon;
    public javax.swing.JLabel lblStep16Power;
    public javax.swing.JLabel lblStep16TimeTotal;
    private javax.swing.JLabel lblStep16_10;
    private javax.swing.JLabel lblStep17Icon;
    public javax.swing.JLabel lblStep17Power;
    public javax.swing.JLabel lblStep17TimeTotal;
    private javax.swing.JLabel lblStep17_10;
    private javax.swing.JLabel lblStep18Icon;
    public javax.swing.JLabel lblStep18Power;
    public javax.swing.JLabel lblStep18TimeTotal;
    private javax.swing.JLabel lblStep18_10;
    private javax.swing.JLabel lblStep19Icon;
    public javax.swing.JLabel lblStep19Power;
    public javax.swing.JLabel lblStep19TimeTotal;
    private javax.swing.JLabel lblStep19_10;
    private javax.swing.JLabel lblStep1Icon;
    public javax.swing.JLabel lblStep1Power;
    public javax.swing.JLabel lblStep1TimeTotal;
    private javax.swing.JLabel lblStep1_10;
    private javax.swing.JLabel lblStep20Icon;
    public javax.swing.JLabel lblStep20Power;
    public javax.swing.JLabel lblStep20TimeTotal;
    private javax.swing.JLabel lblStep20_10;
    private javax.swing.JLabel lblStep21Icon;
    public javax.swing.JLabel lblStep21Power;
    public javax.swing.JLabel lblStep21TimeTotal;
    private javax.swing.JLabel lblStep21_10;
    private javax.swing.JLabel lblStep22Icon;
    public javax.swing.JLabel lblStep22Power;
    public javax.swing.JLabel lblStep22TimeTotal;
    private javax.swing.JLabel lblStep22_10;
    private javax.swing.JLabel lblStep23Icon;
    public javax.swing.JLabel lblStep23Power;
    public javax.swing.JLabel lblStep23TimeTotal;
    private javax.swing.JLabel lblStep23_10;
    private javax.swing.JLabel lblStep24Icon;
    public javax.swing.JLabel lblStep24Power;
    public javax.swing.JLabel lblStep24TimeTotal;
    private javax.swing.JLabel lblStep24_10;
    private javax.swing.JLabel lblStep25Icon;
    public javax.swing.JLabel lblStep25Power;
    public javax.swing.JLabel lblStep25TimeTotal;
    private javax.swing.JLabel lblStep25_10;
    private javax.swing.JLabel lblStep26Icon;
    public javax.swing.JLabel lblStep26Power;
    public javax.swing.JLabel lblStep26TimeTotal;
    private javax.swing.JLabel lblStep26_10;
    private javax.swing.JLabel lblStep27Icon;
    public javax.swing.JLabel lblStep27Power;
    public javax.swing.JLabel lblStep27TimeTotal;
    private javax.swing.JLabel lblStep27_10;
    private javax.swing.JLabel lblStep28Icon;
    public javax.swing.JLabel lblStep28Power;
    public javax.swing.JLabel lblStep28TimeTotal;
    private javax.swing.JLabel lblStep28_10;
    private javax.swing.JLabel lblStep29Icon;
    public javax.swing.JLabel lblStep29Power;
    public javax.swing.JLabel lblStep29TimeTotal;
    private javax.swing.JLabel lblStep29_10;
    private javax.swing.JLabel lblStep2Icon;
    public javax.swing.JLabel lblStep2Power;
    public javax.swing.JLabel lblStep2TimeTotal;
    private javax.swing.JLabel lblStep2_10;
    private javax.swing.JLabel lblStep30Icon;
    public javax.swing.JLabel lblStep30Power;
    public javax.swing.JLabel lblStep30TimeTotal;
    private javax.swing.JLabel lblStep30_10;
    private javax.swing.JLabel lblStep31Icon;
    public javax.swing.JLabel lblStep31Power;
    public javax.swing.JLabel lblStep31TimeTotal;
    private javax.swing.JLabel lblStep31_10;
    private javax.swing.JLabel lblStep32Icon;
    public javax.swing.JLabel lblStep32Power;
    public javax.swing.JLabel lblStep32TimeTotal;
    private javax.swing.JLabel lblStep32_10;
    private javax.swing.JLabel lblStep3Icon;
    public javax.swing.JLabel lblStep3Power;
    public javax.swing.JLabel lblStep3TimeTotal;
    private javax.swing.JLabel lblStep3_10;
    private javax.swing.JLabel lblStep4Icon;
    public javax.swing.JLabel lblStep4Power;
    public javax.swing.JLabel lblStep4TimeTotal;
    private javax.swing.JLabel lblStep4_10;
    private javax.swing.JLabel lblStep5Icon;
    public javax.swing.JLabel lblStep5Power;
    public javax.swing.JLabel lblStep5TimeTotal;
    private javax.swing.JLabel lblStep5_10;
    private javax.swing.JLabel lblStep6Icon;
    public javax.swing.JLabel lblStep6Power;
    public javax.swing.JLabel lblStep6TimeTotal;
    private javax.swing.JLabel lblStep6_10;
    private javax.swing.JLabel lblStep7Icon;
    public javax.swing.JLabel lblStep7Power;
    public javax.swing.JLabel lblStep7TimeTotal;
    private javax.swing.JLabel lblStep7_10;
    private javax.swing.JLabel lblStep8Icon;
    public javax.swing.JLabel lblStep8Power;
    public javax.swing.JLabel lblStep8TimeTotal;
    private javax.swing.JLabel lblStep8_10;
    private javax.swing.JLabel lblStep9Icon;
    public javax.swing.JLabel lblStep9Power;
    public javax.swing.JLabel lblStep9TimeTotal;
    private javax.swing.JLabel lblStep9_10;
    public javax.swing.JSpinner spnStep10MaxPressureExp;
    public javax.swing.JSpinner spnStep11MaxPressureExp;
    public javax.swing.JSpinner spnStep12MaxPressureExp;
    public javax.swing.JSpinner spnStep13MaxPressureExp;
    public javax.swing.JSpinner spnStep14MaxPressureExp;
    public javax.swing.JSpinner spnStep15MaxPressureExp;
    public javax.swing.JSpinner spnStep16MaxPressureExp;
    public javax.swing.JSpinner spnStep17MaxPressureExp;
    public javax.swing.JSpinner spnStep18MaxPressureExp;
    public javax.swing.JSpinner spnStep19MaxPressureExp;
    public javax.swing.JSpinner spnStep1MaxPressureExp;
    public javax.swing.JSpinner spnStep20MaxPressureExp;
    public javax.swing.JSpinner spnStep21MaxPressureExp;
    public javax.swing.JSpinner spnStep22MaxPressureExp;
    public javax.swing.JSpinner spnStep23MaxPressureExp;
    public javax.swing.JSpinner spnStep24MaxPressureExp;
    public javax.swing.JSpinner spnStep25MaxPressureExp;
    public javax.swing.JSpinner spnStep26MaxPressureExp;
    public javax.swing.JSpinner spnStep27MaxPressureExp;
    public javax.swing.JSpinner spnStep28MaxPressureExp;
    public javax.swing.JSpinner spnStep29MaxPressureExp;
    public javax.swing.JSpinner spnStep2MaxPressureExp;
    public javax.swing.JSpinner spnStep30MaxPressureExp;
    public javax.swing.JSpinner spnStep31MaxPressureExp;
    public javax.swing.JSpinner spnStep32MaxPressureExp;
    public javax.swing.JSpinner spnStep3MaxPressureExp;
    public javax.swing.JSpinner spnStep4MaxPressureExp;
    public javax.swing.JSpinner spnStep5MaxPressureExp;
    public javax.swing.JSpinner spnStep6MaxPressureExp;
    public javax.swing.JSpinner spnStep7MaxPressureExp;
    public javax.swing.JSpinner spnStep8MaxPressureExp;
    public javax.swing.JSpinner spnStep9MaxPressureExp;
    // End of variables declaration//GEN-END:variables
}
