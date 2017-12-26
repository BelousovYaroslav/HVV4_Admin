/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hvv_admin4.panels;

import hvv_admin4.HVV_Admin4;
import hvv_admin4.HVV_Admin4Constants;
import hvv_admin4.steps.info.TechProcessGetterInfo;
import hvv_admin4.steps.info.TechProcessStepCommon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JTextField;
import javax.swing.Timer;
import org.apache.log4j.Logger;

/**
 *
 * @author yaroslav
 */
public class PanelEnterGetterInfo extends javax.swing.JPanel {
    final HVV_Admin4 theApp;
    static Logger logger = Logger.getLogger(PanelEnterGetterInfo.class);
    
    private GregorianCalendar m_gdtmDate4vEffusion;
    private GregorianCalendar m_gdtmDate9vEffusion;
    private GregorianCalendar m_gdtmDate9vTurnOff;
    
    private Timer m_pRestDownTickTimer;
    private long m_lRestDownTickTimer;
    
    /**
     * Creates new form PanelProcess
     */
    public PanelEnterGetterInfo( HVV_Admin4 app) {
        theApp = app;
        initComponents();
        
        //lblHour9vTurnOff.setVisible( false);
        //lblMinutes9vTurnOff.setVisible( false);
        
        spn4vHours.setVisible( false);
        spn4vMinutes.setVisible( false);
        spn9vHours.setVisible( false);
        spn9vMinutes.setVisible( false);
        spn9vOffHours.setVisible( false);
        spn9vOffMinutes.setVisible( false);
    }

    public void InitOnStart_43( Date dt, long lSecondsLeft) {
        lblTitle.setText( "<html><u>4.3 Ввод данных о выбросах с геттера.</u></thml>");
        
        m_gdtmDate4vEffusion = new GregorianCalendar();
        m_gdtmDate4vEffusion.setTime( dt);
        switch( theApp.GetSelectedArm()) {
            case HVV_Admin4Constants.ARM1:
            case HVV_Admin4Constants.ARM2:
                m_gdtmDate4vEffusion.add( Calendar.HOUR, -1);
            break;
                
            case HVV_Admin4Constants.ARM3:
            case HVV_Admin4Constants.ARM4:
                m_gdtmDate4vEffusion.add( Calendar.MINUTE, -40);
            break;
        }
        
        m_gdtmDate9vEffusion = new GregorianCalendar();
        m_gdtmDate9vEffusion.setTime( dt);
        switch( theApp.GetSelectedArm()) {
            case HVV_Admin4Constants.ARM1:
            case HVV_Admin4Constants.ARM2:
                m_gdtmDate9vEffusion.add( Calendar.MINUTE, -50);
            break;
                
            case HVV_Admin4Constants.ARM3:
            case HVV_Admin4Constants.ARM4:
                m_gdtmDate9vEffusion.add( Calendar.MINUTE, -30);
            break;
        }
        m_gdtmDate9vTurnOff = new GregorianCalendar();
        m_gdtmDate9vTurnOff.setTime( dt);
        m_gdtmDate9vTurnOff.add( Calendar.MINUTE, -5);
        
        m_lRestDownTickTimer = lSecondsLeft;
        m_pRestDownTickTimer = new Timer( 1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                m_lRestDownTickTimer--;
                
                int nHou = ( int) ( m_lRestDownTickTimer / 3600);
                int nMin = ( int) ( ( m_lRestDownTickTimer % 3600) / 60);
                int nSec = ( int) ( m_lRestDownTickTimer % 60);
                lblStopWatch.setText( String.format( "%02d:%02d:%02d", nHou, nMin, nSec));
                    
                if( m_lRestDownTickTimer == 0) {
                    m_pRestDownTickTimer.stop();
                    btnNext.setEnabled( true);
                }
            }
        });
        m_pRestDownTickTimer.start();
    }
    
    public void InitOnStart_71( Date dt) {
        lblTitle.setText( "<html><u>7.1 Подготовка технологического геттера.</u></thml>");
        
        m_gdtmDate4vEffusion = new GregorianCalendar();
        m_gdtmDate4vEffusion.setTime( dt);
        
        m_gdtmDate9vEffusion = new GregorianCalendar();
        m_gdtmDate9vEffusion.setTime( dt);
        m_gdtmDate9vEffusion.add( Calendar.MINUTE, 3);
        
        m_gdtmDate9vTurnOff = new GregorianCalendar();
        m_gdtmDate9vTurnOff.setTime( dt);
    }
    
    public void InitOnStart_91( Date dt) {
        lblTitle.setText( "<html><u>9.1 Подготовка технологического геттера.</u></thml>");
        
        m_gdtmDate4vEffusion = new GregorianCalendar();
        m_gdtmDate4vEffusion.setTime( dt);
        
        m_gdtmDate9vEffusion = new GregorianCalendar();
        m_gdtmDate9vEffusion.setTime( dt);
        m_gdtmDate9vEffusion.add( Calendar.MINUTE, 3);
        
        m_gdtmDate9vTurnOff = new GregorianCalendar();
        m_gdtmDate9vTurnOff.setTime( dt);
    }
    
    public void InitOnStart( Date dt, long lSecondsLeft) {
        if( theApp.GetCurrentStep() == 63) {
            InitOnStart_43( dt, lSecondsLeft);
        }
        else
            lblStopWatch.setText( "");
        
        if( theApp.GetCurrentStep() == 121) {
            /*lblTitle4vEffusion.setVisible( false);
            
            spn4vHours.setVisible( false);
            lblSeparator4vEffusion.setVisible( false);            
            spn4vMinutes.setVisible( false);
            
            edt4vEffusionPmax.setVisible( false);
            lbl4vEffusionPow10.setVisible( false);
            spn4vEffusionExponent.setVisible( false);
            
            lblTitle9vEffusion.setLocation(
                            lblTitle9vEffusion.getLocation().x,
                            lblTitle9vEffusion.getLocation().y - lblTitle9vEffusion.getHeight() / 2);
            
            spn9vHours.setLocation( spn9vHours.getLocation().x, lblTitle9vEffusion.getY());
            lblSeparator9vEffusion.setLocation( lblSeparator9vEffusion.getLocation().x, lblTitle9vEffusion.getY());
            spn9vMinutes.setLocation( spn9vMinutes.getLocation().x, lblTitle9vEffusion.getY());
            
            edt9vEffusionPmax.setLocation( edt9vEffusionPmax.getX(), lblTitle9vEffusion.getY());
            lbl9vEffusionPow10.setLocation( lbl9vEffusionPow10.getX(), lblTitle9vEffusion.getY());
            spn9vEffusionExponent.setLocation( spn9vEffusionExponent.getX(), lblTitle9vEffusion.getY());
            
                    
            lblTitle9vTurnOffTime.setLocation(
                    lblTitle9vTurnOffTime.getLocation().x,
                    lblTitle9vTurnOffTime.getLocation().y - lblTitle9vTurnOffTime.getHeight() / 2);
            
            spn9vOffHours.setLocation( spn9vOffHours.getX(), lblTitle9vTurnOffTime.getY());
            lblSeparator9vTurnOff.setLocation( lblSeparator9vTurnOff.getLocation().x, lblTitle9vTurnOffTime.getY());
            spn9vOffMinutes.setLocation( spn9vOffMinutes.getLocation().x, lblTitle9vTurnOffTime.getY());
            */
            
            lblTitle9vTurnOffTime.setVisible( false);
            
            spn9vOffHours.setVisible( false);
            lbl9vTurnOffHour.setVisible( false);
            
            lblSeparator9vTurnOff.setVisible( false);            
            
            spn9vOffMinutes.setVisible( false);
            lbl9vTurnOffMinutes.setVisible( false);
            
            InitOnStart_71(dt);
        }
        
        if( theApp.GetCurrentStep() == 161) {
            
            lblTitle9vTurnOffTime.setVisible( false);
            
            spn9vOffHours.setVisible( false);
            lbl9vTurnOffHour.setVisible( false);
            
            lblSeparator9vTurnOff.setVisible( false);            
            
            spn9vOffMinutes.setVisible( false);
            lbl9vTurnOffMinutes.setVisible( false);
            
            InitOnStart_91(dt);
        }
        
        btnNext.setEnabled( false);
        if( theApp.GetCurrentStep() == 63) {
            if( theApp.GetSettings().GetDebugShortenThermoProcessing()) {
                new  Timer( 1000 * 5, new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        (( Timer) e.getSource()).stop();
                        btnNext.setEnabled( true);
                    }
                }).start();
            }
            else {
                new  Timer( 1000 * 60 * 90, new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        (( Timer) e.getSource()).stop();
                        btnNext.setEnabled( true);
                    }
                }).start();
            }
        }
        else {
            new  Timer( 1000, new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    (( Timer) e.getSource()).stop();
                    btnNext.setEnabled( true);
                }
            }).start();
        }
        
        edt4vEffusionPmax.setText( "1.00");
        edt9vEffusionPmax.setText( "1.00");
        
        updateData();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblTitleTime = new javax.swing.JLabel();
        lblTitlePmax = new javax.swing.JLabel();
        lblTitle4vEffusion = new javax.swing.JLabel();
        lbl4vEffusionHour = new javax.swing.JLabel();
        spn4vHours = new javax.swing.JSpinner();
        lblSeparator4vEffusion = new javax.swing.JLabel();
        lbl4vEffusionMinutes = new javax.swing.JLabel();
        spn4vMinutes = new javax.swing.JSpinner();
        edt4vEffusionPmax = new javax.swing.JTextField();
        lbl4vEffusionPow10 = new javax.swing.JLabel();
        spn4vEffusionExponent = new javax.swing.JSpinner();
        lblTitle9vEffusion = new javax.swing.JLabel();
        lbl9vEffusionHour = new javax.swing.JLabel();
        spn9vHours = new javax.swing.JSpinner();
        lblSeparator9vEffusion = new javax.swing.JLabel();
        lbl9vEffusionMinutes = new javax.swing.JLabel();
        spn9vMinutes = new javax.swing.JSpinner();
        edt9vEffusionPmax = new javax.swing.JTextField();
        lbl9vEffusionPow10 = new javax.swing.JLabel();
        spn9vEffusionExponent = new javax.swing.JSpinner();
        lblTitle9vTurnOffTime = new javax.swing.JLabel();
        lbl9vTurnOffHour = new javax.swing.JLabel();
        spn9vOffHours = new javax.swing.JSpinner();
        lblSeparator9vTurnOff = new javax.swing.JLabel();
        lbl9vTurnOffMinutes = new javax.swing.JLabel();
        spn9vOffMinutes = new javax.swing.JSpinner();
        btnNext = new javax.swing.JButton();
        lblStopWatch = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 200)));
        setMaximumSize(new java.awt.Dimension(640, 440));
        setMinimumSize(new java.awt.Dimension(640, 440));
        setPreferredSize(new java.awt.Dimension(640, 440));
        setLayout(null);

        lblTitle.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitle.setText("<html><u>4.3 Ввод данных о выбросах с геттера.</u></thml>");
        lblTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTitle);
        lblTitle.setBounds(10, 10, 620, 40);

        lblTitleTime.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        lblTitleTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleTime.setText("Время");
        lblTitleTime.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTitleTime);
        lblTitleTime.setBounds(210, 60, 200, 40);

        lblTitlePmax.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        lblTitlePmax.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitlePmax.setText("Max давление");
        lblTitlePmax.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTitlePmax);
        lblTitlePmax.setBounds(420, 60, 210, 40);

        lblTitle4vEffusion.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        lblTitle4vEffusion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle4vEffusion.setText("<html>Выброс 4V</html>");
        lblTitle4vEffusion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTitle4vEffusion);
        lblTitle4vEffusion.setBounds(10, 110, 190, 80);

        lbl4vEffusionHour.setFont(new java.awt.Font("Cantarell", 0, 48)); // NOI18N
        lbl4vEffusionHour.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl4vEffusionHour.setText("10");
        lbl4vEffusionHour.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lbl4vEffusionHour.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                lbl4vEffusionHourMouseWheelMoved(evt);
            }
        });
        add(lbl4vEffusionHour);
        lbl4vEffusionHour.setBounds(210, 110, 90, 80);

        spn4vHours.setFont(new java.awt.Font("Cantarell", 0, 36)); // NOI18N
        spn4vHours.setModel(new javax.swing.SpinnerNumberModel(23, 0, 23, 1));
        add(spn4vHours);
        spn4vHours.setBounds(440, 280, 90, 80);

        lblSeparator4vEffusion.setFont(new java.awt.Font("Cantarell", 0, 48)); // NOI18N
        lblSeparator4vEffusion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSeparator4vEffusion.setText(":");
        lblSeparator4vEffusion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblSeparator4vEffusion);
        lblSeparator4vEffusion.setBounds(300, 110, 20, 80);

        lbl4vEffusionMinutes.setFont(new java.awt.Font("Cantarell", 0, 48)); // NOI18N
        lbl4vEffusionMinutes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl4vEffusionMinutes.setText("40");
        lbl4vEffusionMinutes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lbl4vEffusionMinutes.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                lbl4vEffusionMinutesMouseWheelMoved(evt);
            }
        });
        add(lbl4vEffusionMinutes);
        lbl4vEffusionMinutes.setBounds(320, 110, 90, 80);

        spn4vMinutes.setFont(new java.awt.Font("Cantarell", 0, 36)); // NOI18N
        spn4vMinutes.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));
        add(spn4vMinutes);
        spn4vMinutes.setBounds(540, 280, 90, 80);

        edt4vEffusionPmax.setFont(new java.awt.Font("Cantarell", 0, 36)); // NOI18N
        edt4vEffusionPmax.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edt4vEffusionPmax.setText("5.60");
        edt4vEffusionPmax.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                edtFocusGained(evt);
            }
        });
        add(edt4vEffusionPmax);
        edt4vEffusionPmax.setBounds(420, 110, 100, 80);

        lbl4vEffusionPow10.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lbl4vEffusionPow10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl4vEffusionPow10.setText("× 10");
        lbl4vEffusionPow10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lbl4vEffusionPow10);
        lbl4vEffusionPow10.setBounds(520, 110, 60, 80);

        spn4vEffusionExponent.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        spn4vEffusionExponent.setModel(new javax.swing.SpinnerNumberModel(-5, -6, -4, 1));
        add(spn4vEffusionExponent);
        spn4vEffusionExponent.setBounds(580, 110, 50, 40);

        lblTitle9vEffusion.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        lblTitle9vEffusion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle9vEffusion.setText("<html>Выброс 9V</html>");
        lblTitle9vEffusion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTitle9vEffusion);
        lblTitle9vEffusion.setBounds(10, 200, 190, 80);

        lbl9vEffusionHour.setFont(new java.awt.Font("Cantarell", 0, 48)); // NOI18N
        lbl9vEffusionHour.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl9vEffusionHour.setText("10");
        lbl9vEffusionHour.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lbl9vEffusionHour.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                lbl9vEffusionHourMouseWheelMoved(evt);
            }
        });
        add(lbl9vEffusionHour);
        lbl9vEffusionHour.setBounds(210, 200, 90, 80);

        spn9vHours.setFont(new java.awt.Font("Cantarell", 0, 36)); // NOI18N
        spn9vHours.setModel(new javax.swing.SpinnerNumberModel(23, 0, 23, 1));
        add(spn9vHours);
        spn9vHours.setBounds(440, 290, 90, 80);

        lblSeparator9vEffusion.setFont(new java.awt.Font("Cantarell", 0, 48)); // NOI18N
        lblSeparator9vEffusion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSeparator9vEffusion.setText(":");
        lblSeparator9vEffusion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblSeparator9vEffusion);
        lblSeparator9vEffusion.setBounds(300, 200, 20, 80);

        lbl9vEffusionMinutes.setFont(new java.awt.Font("Cantarell", 0, 48)); // NOI18N
        lbl9vEffusionMinutes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl9vEffusionMinutes.setText("40");
        lbl9vEffusionMinutes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lbl9vEffusionMinutes.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                lbl9vEffusionMinutesMouseWheelMoved(evt);
            }
        });
        add(lbl9vEffusionMinutes);
        lbl9vEffusionMinutes.setBounds(320, 200, 90, 80);

        spn9vMinutes.setFont(new java.awt.Font("Cantarell", 0, 36)); // NOI18N
        spn9vMinutes.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));
        add(spn9vMinutes);
        spn9vMinutes.setBounds(540, 290, 90, 80);

        edt9vEffusionPmax.setFont(new java.awt.Font("Cantarell", 0, 36)); // NOI18N
        edt9vEffusionPmax.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edt9vEffusionPmax.setText("5.37");
        edt9vEffusionPmax.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                edtFocusGained(evt);
            }
        });
        add(edt9vEffusionPmax);
        edt9vEffusionPmax.setBounds(420, 200, 100, 80);

        lbl9vEffusionPow10.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lbl9vEffusionPow10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl9vEffusionPow10.setText("× 10");
        lbl9vEffusionPow10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lbl9vEffusionPow10);
        lbl9vEffusionPow10.setBounds(520, 200, 60, 80);

        spn9vEffusionExponent.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        spn9vEffusionExponent.setModel(new javax.swing.SpinnerNumberModel(-5, -6, -4, 1));
        add(spn9vEffusionExponent);
        spn9vEffusionExponent.setBounds(580, 200, 50, 40);

        lblTitle9vTurnOffTime.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        lblTitle9vTurnOffTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle9vTurnOffTime.setText("Время отключения 9V");
        lblTitle9vTurnOffTime.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTitle9vTurnOffTime);
        lblTitle9vTurnOffTime.setBounds(10, 290, 190, 80);

        lbl9vTurnOffHour.setFont(new java.awt.Font("Cantarell", 0, 48)); // NOI18N
        lbl9vTurnOffHour.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl9vTurnOffHour.setText("10");
        lbl9vTurnOffHour.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lbl9vTurnOffHour.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                lbl9vTurnOffHourMouseWheelMoved(evt);
            }
        });
        add(lbl9vTurnOffHour);
        lbl9vTurnOffHour.setBounds(210, 290, 90, 80);

        spn9vOffHours.setFont(new java.awt.Font("Cantarell", 0, 36)); // NOI18N
        spn9vOffHours.setModel(new javax.swing.SpinnerNumberModel(23, 0, 23, 1));
        add(spn9vOffHours);
        spn9vOffHours.setBounds(440, 300, 90, 80);

        lblSeparator9vTurnOff.setFont(new java.awt.Font("Cantarell", 0, 48)); // NOI18N
        lblSeparator9vTurnOff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSeparator9vTurnOff.setText(":");
        lblSeparator9vTurnOff.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblSeparator9vTurnOff);
        lblSeparator9vTurnOff.setBounds(300, 290, 20, 80);

        lbl9vTurnOffMinutes.setFont(new java.awt.Font("Cantarell", 0, 48)); // NOI18N
        lbl9vTurnOffMinutes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl9vTurnOffMinutes.setText("40");
        lbl9vTurnOffMinutes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lbl9vTurnOffMinutes.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                lbl9vTurnOffMinutesMouseWheelMoved(evt);
            }
        });
        add(lbl9vTurnOffMinutes);
        lbl9vTurnOffMinutes.setBounds(320, 290, 90, 80);

        spn9vOffMinutes.setFont(new java.awt.Font("Cantarell", 0, 36)); // NOI18N
        spn9vOffMinutes.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));
        add(spn9vOffMinutes);
        spn9vOffMinutes.setBounds(540, 300, 90, 80);

        btnNext.setText("Далее");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        add(btnNext);
        btnNext.setBounds(10, 380, 620, 50);

        lblStopWatch.setFont(new java.awt.Font("Cantarell", 0, 36)); // NOI18N
        lblStopWatch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStopWatch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblStopWatch);
        lblStopWatch.setBounds(10, 60, 190, 40);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        
        TechProcessGetterInfo info = ( TechProcessGetterInfo) theApp.GetCommonStepInfo( String.format( "%03d", theApp.GetCurrentStep()));
        info.SetStopDateAsCurrent();
        
        //4. Термообезгаживание
        if( theApp.GetCurrentStep() == 63) {    
            info.SetStopReportTitle( "");

            theApp.SetCurrentStep( 64);
            theApp.SetCurrentStepInProgress( false);

            //Выброс 4V
            m_gdtmDate4vEffusion.set( Calendar.HOUR_OF_DAY, Integer.parseInt( lbl4vEffusionHour.getText())); //int) spn4vHours.getValue());
            m_gdtmDate4vEffusion.set( Calendar.MINUTE, Integer.parseInt( lbl4vEffusionMinutes.getText()));
            info.SetDtEffusion4v( m_gdtmDate4vEffusion.getTime());
            String str = edt4vEffusionPmax.getText();
            str = str.replace( ',', '.');
            double d = 1.;
            try {
                d = new Double( str);
            }
            catch( NumberFormatException ex) {
                logger.warn( "NumberFormatException caught при обработке 4v выброса на этапе 063", ex);
            }
            info.SetDblEffusion4v( d * Math.pow( 10, ( int) spn4vEffusionExponent.getValue()));
            
            //Выброс 9V
            m_gdtmDate9vEffusion.set( Calendar.HOUR_OF_DAY, Integer.parseInt( lbl9vEffusionHour.getText())); //( int) spn9vHours.getValue());
            m_gdtmDate9vEffusion.set( Calendar.MINUTE, Integer.parseInt( lbl9vEffusionMinutes.getText()));
            info.SetDtEffusion9v( m_gdtmDate9vEffusion.getTime());
            str = edt9vEffusionPmax.getText();
            str = str.replace( ',', '.');
            d = 1.;
            try {
                d = new Double( str);
            }
            catch( NumberFormatException ex) {
                logger.warn( "NumberFormatException caught при обработке 9v выброса на этапе 063", ex);
            }
            info.SetDblEffusion9v( d * Math.pow( 10, ( int) spn9vEffusionExponent.getValue()));
            
            //Выключение 9V
            m_gdtmDate9vTurnOff.set( Calendar.HOUR_OF_DAY, Integer.parseInt( lbl9vTurnOffHour.getText()));//( int) spn9vOffHours.getValue());
            m_gdtmDate9vTurnOff.set( Calendar.MINUTE, Integer.parseInt( lbl9vTurnOffMinutes.getText()));//( int) spn9vOffMinutes.getValue());
            info.SetDtTurnOff9v( m_gdtmDate9vTurnOff.getTime());
            
            theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.Reposition();
            theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.SetStates();
            theApp.m_pMainWnd.m_pnlMain.ScrollActiveStepToCenter();
            theApp.m_pMainWnd.m_pnlMain.setVisible( true);
        }
        
        //7. Обезгаживание рабочих геттеров
        if( theApp.GetCurrentStep() == 121) {
            
            //Выброс 4V
            m_gdtmDate4vEffusion.set( Calendar.HOUR_OF_DAY, Integer.parseInt( lbl4vEffusionHour.getText()));        //spn4vHours.getValue());
            m_gdtmDate4vEffusion.set( Calendar.MINUTE, Integer.parseInt( lbl4vEffusionMinutes.getText()));          //( int) spn4vMinutes.getValue());
            info.SetDtEffusion4v( m_gdtmDate4vEffusion.getTime());
            String str = edt4vEffusionPmax.getText();
            str = str.replace( ',', '.');
            double d = 1.;
            try {
                d = new Double( str);
            }
            catch( NumberFormatException ex) {
                logger.warn( "NumberFormatException caught при обработке 4v выброса на этапе 121", ex);
            }
            info.SetDblEffusion4v( d * Math.pow( 10, ( int) spn4vEffusionExponent.getValue()));
            
            //Выброс 9V
            m_gdtmDate9vEffusion.set( Calendar.HOUR_OF_DAY, Integer.parseInt( lbl9vEffusionHour.getText()));        //( int) spn9vHours.getValue());
            m_gdtmDate9vEffusion.set( Calendar.MINUTE, Integer.parseInt( lbl9vEffusionMinutes.getText()));          //( int) spn9vMinutes.getValue());
            info.SetDtEffusion9v( m_gdtmDate9vEffusion.getTime());
            str = edt9vEffusionPmax.getText();
            str = str.replace( ',', '.');
            d = 1.;
            try {
                d = new Double( str);
            }
            catch( NumberFormatException ex) {
                logger.warn( "NumberFormatException caught при обработке 9v выброса на этапе 063", ex);
            }
            info.SetDblEffusion9v( d * Math.pow( 10, ( int) spn9vEffusionExponent.getValue()));
            
            
            theApp.SetCurrentStep( 122);
            theApp.SetCurrentStepInProgress( true);
            
            theApp.m_pMainWnd.m_pnlDegasation.Init();
            theApp.m_pMainWnd.m_pnlDegasation.m_pnlProgress.SetStates();
            theApp.m_pMainWnd.m_pnlDegasation.m_pnlProgress.StartRefreshTimer();
            theApp.m_pMainWnd.m_pnlDegasation.setVisible( true);
            
            theApp.m_pMainWnd.m_pnlDegasation.m_dlgBigStopWatch.setVisible( true);
        }
        
        //9. Активация геттеров
        if( theApp.GetCurrentStep() == 161) {
            
            //Выброс 4V
            m_gdtmDate4vEffusion.set( Calendar.HOUR_OF_DAY, Integer.parseInt( lbl4vEffusionHour.getText()));        //spn4vHours.getValue());
            m_gdtmDate4vEffusion.set( Calendar.MINUTE, Integer.parseInt( lbl4vEffusionMinutes.getText()));          //( int) spn9vMinutes.getValue());
            info.SetDtEffusion4v( m_gdtmDate4vEffusion.getTime());
            String str = edt4vEffusionPmax.getText();
            str = str.replace( ',', '.');
            double d = 1.;
            try {
                d = new Double( str);
            }
            catch( NumberFormatException ex) {
                logger.warn( "NumberFormatException caught при обработке 4v выброса на этапе 121", ex);
            }
            info.SetDblEffusion4v( d * Math.pow( 10, ( int) spn4vEffusionExponent.getValue()));
            
            //Выброс 9V
            m_gdtmDate9vEffusion.set( Calendar.HOUR_OF_DAY, Integer.parseInt( lbl9vEffusionHour.getText()));        //spn4vHours.getValue());
            m_gdtmDate9vEffusion.set( Calendar.MINUTE, Integer.parseInt( lbl9vEffusionMinutes.getText()));          //( int) spn9vMinutes.getValue());
            info.SetDtEffusion9v( m_gdtmDate9vEffusion.getTime());
            str = edt9vEffusionPmax.getText();
            str = str.replace( ',', '.');
            d = 1.;
            try {
                d = new Double( str);
            }
            catch( NumberFormatException ex) {
                logger.warn( "NumberFormatException caught при обработке 9v выброса на этапе 063", ex);
            }
            info.SetDblEffusion9v( d * Math.pow( 10, ( int) spn9vEffusionExponent.getValue()));

            theApp.SetCurrentStep( 162);
            theApp.SetCurrentStepInProgress( true);
            
            theApp.m_pMainWnd.m_pnlActivation.Init();
            theApp.m_pMainWnd.m_pnlActivation.m_pnlProgress.SetStates();
            theApp.m_pMainWnd.m_pnlActivation.m_pnlProgress.StartRefreshTimer();
            theApp.m_pMainWnd.m_pnlActivation.setVisible( true);
            
            theApp.m_pMainWnd.m_pnlActivation.m_dlgBigStopWatch.setVisible( true);
        }
        
        theApp.m_ReportGenerator.Generate();
        
        theApp.m_pMainWnd.m_pnlEnterGetterInfo.setVisible( false);
    }//GEN-LAST:event_btnNextActionPerformed

    private void edtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_edtFocusGained
        JTextField edt = ( JTextField) evt.getSource();
        edt.setSelectionStart( 0);
        edt.setSelectionEnd(edt.getText().length());
    }//GEN-LAST:event_edtFocusGained

    private void lbl9vTurnOffHourMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_lbl9vTurnOffHourMouseWheelMoved
        m_gdtmDate9vTurnOff.add( Calendar.HOUR, -1 * evt.getWheelRotation());
        updateData();
    }//GEN-LAST:event_lbl9vTurnOffHourMouseWheelMoved

    private void lbl9vTurnOffMinutesMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_lbl9vTurnOffMinutesMouseWheelMoved
        m_gdtmDate9vTurnOff.add( Calendar.MINUTE, -1 * evt.getWheelRotation());
        updateData();
    }//GEN-LAST:event_lbl9vTurnOffMinutesMouseWheelMoved

    private void lbl9vEffusionHourMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_lbl9vEffusionHourMouseWheelMoved
        m_gdtmDate9vEffusion.add( Calendar.HOUR, -1 * evt.getWheelRotation());
        updateData();
    }//GEN-LAST:event_lbl9vEffusionHourMouseWheelMoved

    private void lbl4vEffusionHourMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_lbl4vEffusionHourMouseWheelMoved
        m_gdtmDate4vEffusion.add( Calendar.HOUR, -1 * evt.getWheelRotation());
        updateData();
    }//GEN-LAST:event_lbl4vEffusionHourMouseWheelMoved

    private void lbl9vEffusionMinutesMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_lbl9vEffusionMinutesMouseWheelMoved
        m_gdtmDate9vEffusion.add( Calendar.MINUTE, -1 * evt.getWheelRotation());
        updateData();
    }//GEN-LAST:event_lbl9vEffusionMinutesMouseWheelMoved

    private void lbl4vEffusionMinutesMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_lbl4vEffusionMinutesMouseWheelMoved
        m_gdtmDate4vEffusion.add( Calendar.MINUTE, -1 * evt.getWheelRotation());
        updateData();
    }//GEN-LAST:event_lbl4vEffusionMinutesMouseWheelMoved

    public void updateData() {
        lbl4vEffusionHour.setText( ( m_gdtmDate4vEffusion.get( Calendar.HOUR_OF_DAY) < 10 ? "0" : "") +
                                     m_gdtmDate4vEffusion.get( Calendar.HOUR_OF_DAY));
        
        lbl4vEffusionMinutes.setText( ( m_gdtmDate4vEffusion.get( Calendar.MINUTE) < 10 ? "0" : "") +
                                        m_gdtmDate4vEffusion.get( Calendar.MINUTE));
        
        //spn4vHours.setValue( m_gdtmDate4vEffusion.get( Calendar.HOUR_OF_DAY));
        //spn4vMinutes.setValue( m_gdtmDate4vEffusion.get( Calendar.MINUTE));
        
        
        lbl9vEffusionHour.setText( ( m_gdtmDate9vEffusion.get( Calendar.HOUR_OF_DAY) < 10 ? "0" : "") +
                                     m_gdtmDate9vEffusion.get( Calendar.HOUR_OF_DAY));
        
        lbl9vEffusionMinutes.setText( ( m_gdtmDate9vEffusion.get( Calendar.MINUTE) < 10 ? "0" : "") +
                                        m_gdtmDate9vEffusion.get( Calendar.MINUTE));
        
        //spn9vHours.setValue( m_gdtmDate9vEffusion.get( Calendar.HOUR_OF_DAY));
        //spn9vMinutes.setValue( m_gdtmDate9vEffusion.get( Calendar.MINUTE));
        
        
        
        lbl9vTurnOffHour.setText( ( m_gdtmDate9vTurnOff.get( Calendar.HOUR_OF_DAY) < 10 ? "0" : "") +
                                    m_gdtmDate9vTurnOff.get( Calendar.HOUR_OF_DAY));
        
        lbl9vTurnOffMinutes.setText( ( m_gdtmDate9vTurnOff.get( Calendar.MINUTE) < 10 ? "0" : "") +
                                       m_gdtmDate9vTurnOff.get( Calendar.MINUTE));
        
        //spn9vOffHours.setValue( m_gdtmDate9vTurnOff.get( Calendar.HOUR_OF_DAY));
        //spn9vOffMinutes.setValue( m_gdtmDate9vTurnOff.get(  Calendar.MINUTE));
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNext;
    public javax.swing.JTextField edt4vEffusionPmax;
    public javax.swing.JTextField edt9vEffusionPmax;
    private javax.swing.JLabel lbl4vEffusionHour;
    private javax.swing.JLabel lbl4vEffusionMinutes;
    private javax.swing.JLabel lbl4vEffusionPow10;
    private javax.swing.JLabel lbl9vEffusionHour;
    private javax.swing.JLabel lbl9vEffusionMinutes;
    private javax.swing.JLabel lbl9vEffusionPow10;
    private javax.swing.JLabel lbl9vTurnOffHour;
    private javax.swing.JLabel lbl9vTurnOffMinutes;
    private javax.swing.JLabel lblSeparator4vEffusion;
    private javax.swing.JLabel lblSeparator9vEffusion;
    private javax.swing.JLabel lblSeparator9vTurnOff;
    private javax.swing.JLabel lblStopWatch;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitle4vEffusion;
    private javax.swing.JLabel lblTitle9vEffusion;
    private javax.swing.JLabel lblTitle9vTurnOffTime;
    private javax.swing.JLabel lblTitlePmax;
    private javax.swing.JLabel lblTitleTime;
    private javax.swing.JSpinner spn4vEffusionExponent;
    private javax.swing.JSpinner spn4vHours;
    private javax.swing.JSpinner spn4vMinutes;
    private javax.swing.JSpinner spn9vEffusionExponent;
    private javax.swing.JSpinner spn9vHours;
    private javax.swing.JSpinner spn9vMinutes;
    private javax.swing.JSpinner spn9vOffHours;
    private javax.swing.JSpinner spn9vOffMinutes;
    // End of variables declaration//GEN-END:variables
}
