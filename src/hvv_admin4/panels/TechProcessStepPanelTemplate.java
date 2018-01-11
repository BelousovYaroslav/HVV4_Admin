/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hvv_admin4.panels;

import hvv_admin4.HVV_Admin4;
import hvv_admin4.steps.info.TechProcessStepCommon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.Timer;
import org.apache.log4j.Logger;

/**
 *
 * @author yaroslav
 */
public abstract class TechProcessStepPanelTemplate extends javax.swing.JPanel {
    public HVV_Admin4 theApp;
    public boolean m_bCollapsed;
    public int m_nPageNumber;
    
    public boolean m_bFirstOfDoubleClickHeaderDateTime;
    
    private Timer m_tmDoubleClick;
    
    public void CollapseClick( int nPanel) {
        if( theApp.GetCurrentStep() / 20 == nPanel) return;
        m_bCollapsed ^= true;
        theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.SetStates();
        theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.Reposition();
    }
    
    public void FillHeaderStepDates( String strStepFirst, JLabel lbDtStart, JLabel lbTmStart, String strStepLast, JLabel lbDtStop, JLabel lbTmStop) {
        boolean bStart = false;
        if( theApp.IsStepMapContainsKey( strStepFirst)) {
            TechProcessStepCommon info = theApp.GetCommonStep( strStepFirst);
            
            if( info.GetStartDate() != null) {
                lbDtStart.setText( theApp.strFormatDate( info.GetStartDate()));
                lbTmStart.setText( theApp.strFormatTime( info.GetStartDate()));
                bStart = true;
            }
        }
        
        if( bStart == false) {
            lbDtStart.setText( "-");
            lbTmStart.setText( "-");
        }
        
        
        boolean bStop = false;
        if( theApp.IsStepMapContainsKey( strStepLast)) {
            TechProcessStepCommon info = theApp.GetCommonStep( strStepLast);
            
            if( info.GetStopDate() != null) {
                lbDtStop.setText( theApp.strFormatDate( info.GetStopDate()));
                lbTmStop.setText( theApp.strFormatTime( info.GetStopDate()));
                bStop = true;
            }
        }
        
        if( bStop == false) {
            lbDtStop.setText( "-");
            lbTmStop.setText( "-");
        }
    }
    
    public void FillStepDates( String strStep, JLabel lbDtStart, JLabel lbTmStart, JLabel lbDtStop, JLabel lbTmStop) {
        boolean bStart = false;
        boolean bStop = false;
        
        if( theApp.IsStepMapContainsKey( strStep)) {
            TechProcessStepCommon info = theApp.GetCommonStep( strStep);
            
            if( info.GetStartDate() != null) {
                lbDtStart.setText( theApp.strFormatDate( info.GetStartDate()));
                lbTmStart.setText( theApp.strFormatTime( info.GetStartDate()));
                bStart = true;
            }
            
            
            if( info.GetStopDate() != null) {
                lbDtStop.setText( theApp.strFormatDate( info.GetStopDate()));
                lbTmStop.setText( theApp.strFormatTime( info.GetStopDate()));
                bStop = true;
            }
        }
        
        if( bStart == false) {
            lbDtStart.setText( "-");
            lbTmStart.setText( "-");
        }
        
        if( bStop == false) {
            lbDtStop.setText( "-");
            lbTmStop.setText( "-");
        }
    }
    
    public void FillAutoExecutedSubStep( int nStepId,
                                        JLabel lblDtStart, JLabel lblTmStart,
                                        JButton btnStart, JLabel lblDtTitle, JCheckBox chkAuto, JButton btnNext,
                                        JLabel lblDtStop, JLabel lblTmStop) {
        
        String strStepId = String.format( "%03d", nStepId);
        FillStepDates( strStepId, lblDtStart, lblTmStart, lblDtStop, lblTmStop);

        lblDtTitle.setFont( theApp.GetCurrentStep() == nStepId ? theApp.GetBoldFont() : theApp.GetUsualFont());
        lblDtTitle.setEnabled( theApp.GetCurrentStep() <= nStepId);

        if( chkAuto != null)
            chkAuto.setEnabled( theApp.GetCurrentStep() < nStepId);
            

        //АВТО-POSSIBLE ПОДЭТАП
        if( theApp.GetCurrentStep() == nStepId) {
            btnStart.setVisible( !theApp.IsCurrentStepInProgress());
            btnNext.setVisible( theApp.IsCurrentStepInProgress());
        }
        else {
            btnStart.setVisible( false);
            btnNext.setVisible( false);
        }
    }
    
    public abstract void SetState();
    
    public void DefaultStartButtonProcessing( String strCurrentStep, String strCurrentStepStartTitle, String strCurrentStepStopTitle,
                                                String strNextStep, String strNextStepStartTitle,
                                                JCheckBox chkNextStep, Logger logger, boolean bLastSubStep) {
        
        //мы начинаем процесс
        TechProcessStepCommon info = new TechProcessStepCommon();
        info.SetStartDateAsCurrent( theApp.GetSettings().GetTimeZoneShift());
        info.SetStartReportTitle( strCurrentStepStartTitle);

        theApp.SaveStepInfo( strCurrentStep, info, true);

        theApp.m_ReportGenerator.Generate();

        //theApp.m_pMainWnd.m_EmuTimer.start();
        theApp.SetCurrentStepInProgress( true);

        SetState();
    }
    
    public void DefaultNextButtonProcessing( String strCurrentStep, String strCurrentStepStartTitle, String strCurrentStepStopTitle,
                                                String strNextStep, String strNextStepStartTitle,
                                                JCheckBox chkNextStep, Logger logger, boolean bLastSubStep) {
        
        //мы в процессе исполнения подэтапа XXX, переходим к следующему подэтапу XXX+1
        //theApp.m_pMainWnd.m_EmuTimer.stop();
        if( theApp.IsStepMapContainsKey( strCurrentStep)) {
            TechProcessStepCommon info = theApp.GetCommonStep( strCurrentStep);

            info.SetStopDateAsCurrent( theApp.GetSettings().GetTimeZoneShift());
            info.SetStopReportTitle( strCurrentStepStopTitle);

            theApp.NextCurrentStep();

            if( chkNextStep != null && chkNextStep.isSelected()) {
                info = new TechProcessStepCommon();
                
                info.SetStartDateAsCurrent( theApp.GetSettings().GetTimeZoneShift());
                info.SetStartReportTitle( strNextStepStartTitle);

                theApp.SaveStepInfo( strNextStep, info, true);

                theApp.SetCurrentStepInProgress( true);
            }

            if( bLastSubStep)
                theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.SetStates();
            else
                SetState();

            theApp.m_ReportGenerator.Generate();
            
            theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.Reposition();
            theApp.m_pMainWnd.m_pnlMain.ScrollActiveStepToCenter();
        }
        else {
            logger.fatal( "Мы заканчиваем этап " + strCurrentStep + ", а инфы на него до сих пор нет!");
        }
    }
    
    public void ProcessHeaderDateTimeClick( int nGreatStep) { //, Date dtScreenThisStep, Date dtScreenPrevStep) {
        if( ( m_tmDoubleClick != null && m_tmDoubleClick.isRunning()) || m_bFirstOfDoubleClickHeaderDateTime == true) {
            m_tmDoubleClick.stop();
            m_bFirstOfDoubleClickHeaderDateTime = false;
            theApp.GetPlanner().ShowSetup( nGreatStep);//, dtScreenThisStep, dtScreenPrevStep);
        }
        else {
            m_bFirstOfDoubleClickHeaderDateTime = true;
            m_tmDoubleClick = new Timer( 500, new ActionListener() {
                

                @Override
                public void actionPerformed(ActionEvent e) {
                    m_bFirstOfDoubleClickHeaderDateTime = false;
                }
                
            });
            m_tmDoubleClick.setRepeats( false);
            m_tmDoubleClick.start();
        }
    }
}
