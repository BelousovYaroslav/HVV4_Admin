/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hvv_admin4.planner;

import hvv_admin4.HVV_Admin4;
import hvv_admin4.dialogs.DlgTechProcessPlanner;
import hvv_admin4.steps.info.TechProcessStepCommon;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import org.apache.log4j.Logger;

/**
 *
 * @author yaroslav
 */
public class HVV_AdminPlanner {
    final HVV_Admin4 theApp;
    final public LinkedList m_lstSteps;
    static Logger logger = Logger.getLogger(HVV_AdminPlanner.class);
    
    public HVV_AdminPlanner( HVV_Admin4 app) {
        theApp = app;
        
        m_lstSteps = new LinkedList();

        //1. Подготовка (0.5 часа)... Но это у нас якорь
        PlannerItem item = new PlannerItem( ( long) ( 3600 * 0.5));
        
        Date dtNow = theApp.GetLocalDate();
        dtNow = new Date( dtNow.getTime() + 5 * 60 * 1000);
        item.SetupAsAbsolute( dtNow);
        m_lstSteps.add( item);
        
        //2. Установка приборов (длительность 1 этапа = 0.5 часа)
        item = new PlannerItem( ( long) ( 3600 * 0.5));
        item.SetupAsRelative( ( long) ( 3600 * 0.5));
        m_lstSteps.add( item);

        //3. Обработка в среде кислорода (длительность 2 этапа = 2.5 часа)
        item = new PlannerItem( ( long) ( 3600 * 2.5));
        item.SetupAsRelative( ( long) ( 3600 * 2.5));
        m_lstSteps.add( item);
        
        //4. Обработка в среде кислород-неона (длительность 3 этапа = 2.5 часа)
        item = new PlannerItem( ( long) ( 3600 * 2.5));
        item.SetupAsRelative( ( long) ( 3600 * 2.5));
        m_lstSteps.add( item);
        
        //5. Термообезгаживание (длительность 4 этапа = 4 часа)
        item = new PlannerItem( ( long) ( 3600 * 4));
        item.SetupAsRelative( ( long) ( 3600 * 4));
        m_lstSteps.add( item);
        
        //6. Предварительная оценка параметров приборов (длительность 5 этапа = 40 часов)
        item = new PlannerItem( ( long) ( 3600 * 40));
        item.SetupAsRelative( ( long) ( 3600 * 40));
        m_lstSteps.add( item);
        
        //7. Тренировка катода (11 часов) (длительность 6 этапа = 1.5 часа)
        item = new PlannerItem( ( long) ( 3600 * 1.5));
        item.SetupAsRelative( ( long) ( 3600 * 1.5));
        m_lstSteps.add( item);
        
        //8. Обезгаживание рабочих геттеров (длительность 7 этапа = 11 часов)
        item = new PlannerItem( ( long) ( 3600 * 11));
        item.SetupAsRelative( ( long) ( 3600 * 11));
        m_lstSteps.add( item);
        
        //9. Тренировка в тренировочной смеси (длительность 8 этапа = 2,5 часа)
        item = new PlannerItem( ( long) ( 3600 * 2.5));
        item.SetupAsRelative( ( long) ( 3600 * 2.5));
        m_lstSteps.add( item);
        
        //10. Активация рабочих геттеров (длительность 9 этапа = 24 часа)
        item = new PlannerItem( ( long) ( 3600 * 24));
        item.SetupAsRelative( ( long) ( 3600 * 24));
        m_lstSteps.add( item);
        
        //11. Выходная оценка параметров приборов (длительность 10 этапа = 5 часов)
        item = new PlannerItem( ( long) ( 3600 * 5));
        item.SetupAsRelative( ( long) ( 3600 * 5));
        m_lstSteps.add( item);
        
        //12. Снятие непрошедших приборов (опционально) (длительность 11 этапа = 2 часа)
        item = new PlannerItem( ( long) ( 3600 * 2));
        item.SetupAsRelative( ( long) ( 3600 * 2));
        m_lstSteps.add( item);
        
        //13. Завершение технологического процесса (длительность 12 этапа = 1 час)
        item = new PlannerItem( ( long) ( 3600 * 1));
        item.SetupAsRelative( ( long) ( 3600 * 1));
        m_lstSteps.add( item);
        
    }
    
    public void ShowSetup( int nGreatStep) { //, Date dtScreenThisStep, Date dtScreenPrevStep) {
        if( nGreatStep > m_lstSteps.size()) return;
        
        PlannerItem item;
        Date dtPrev = null, dtCurr = null;
        
        
        //FIRST
        /*
        if( theApp.GetMapSteps().containsKey( "001")) {
            TechProcessStepInfo info = ( TechProcessStepInfo) theApp.GetMapSteps().get( "001");
            if( info.GetStartDate() != null) {
                dtCurr = info.GetStartDate();
            }
            else
                dtCurr = theApp.GetLocalDate();
        }
        else {
            dtCurr = theApp.GetLocalDate();
        }
        */
        item = ( PlannerItem) theApp.GetPlanner().m_lstSteps.get( 0);
        dtCurr = item.ProcessIncrement( dtCurr);
        
        //RUN
        for( int i=1; i<nGreatStep; i++) {
            if( theApp.GetCurrentStep() >= i * 20) {
                String strStep = String.format( "%03d", i * 20 + 1);
                if( theApp.IsStepMapContainsKey( strStep)) {
                    TechProcessStepCommon info = ( TechProcessStepCommon) theApp.GetStepInfo( strStep);
                    if( info.GetStartDate() != null) {
                        dtPrev = dtCurr;
                        dtCurr = info.GetStartDate();
                    }
                }        
            }
            else {

                item = ( PlannerItem) theApp.GetPlanner().m_lstSteps.get( i);

                dtPrev = dtCurr;
                dtCurr = item.ProcessIncrement( dtCurr);
            }
        }
        
        
        logger.fatal( "Prev: " + dtPrev);
        logger.fatal( "Curr:" + dtCurr);
        item = ( PlannerItem) m_lstSteps.get( nGreatStep - 1);
        
        DlgTechProcessPlanner dlg;
        switch( nGreatStep) {
            case  2: dlg = new DlgTechProcessPlanner( theApp, theApp.m_pMainWnd, true, "2. Установка приборов", 2); break;
            case  3: dlg = new DlgTechProcessPlanner( theApp, theApp.m_pMainWnd, true, "3. Обработка в среде кислорода", 3); break;
            case  4: dlg = new DlgTechProcessPlanner( theApp, theApp.m_pMainWnd, true, "4. Обработка в среде кислород-неона", 4); break;
            case  5: dlg = new DlgTechProcessPlanner( theApp, theApp.m_pMainWnd, true, "5. Термообезгаживание", 5); break;
            case  6: dlg = new DlgTechProcessPlanner( theApp, theApp.m_pMainWnd, true, "6. Предварительная оценка параметров приборов", 6); break;
            case  7: dlg = new DlgTechProcessPlanner( theApp, theApp.m_pMainWnd, true, "7. Тренировка катода", 7); break;
            case  8: dlg = new DlgTechProcessPlanner( theApp, theApp.m_pMainWnd, true, "8. Обезгаживание рабочих геттеров", 8); break;
            case  9: dlg = new DlgTechProcessPlanner( theApp, theApp.m_pMainWnd, true, "9. Тренировка в тренировочной смеси", 9); break;
            case 10: dlg = new DlgTechProcessPlanner( theApp, theApp.m_pMainWnd, true, "10. Активация рабочих геттеров", 10); break;
            case 11: dlg = new DlgTechProcessPlanner( theApp, theApp.m_pMainWnd, true, "11. Выходная оценка параметров приборов", 11); break;
            case 12: dlg = new DlgTechProcessPlanner( theApp, theApp.m_pMainWnd, true, "12. Снятие непрошедших приборов", 12); break;
            case 13: dlg = new DlgTechProcessPlanner( theApp, theApp.m_pMainWnd, true, "13. Завершение технологического процесса", 13); break;
            default: dlg = new DlgTechProcessPlanner( theApp, theApp.m_pMainWnd, true, "1. Подготовка", 1); break;
        }
        
        if( item.GetType() == PlannerItem.PLANNER_ABSOLUTE_TIME) {
            dlg.radAbsolute.setSelected( true);
            dlg.SetControls( true);
            
            //MAIN
            dlg.m_gdtmDate.setTime( item.m_dtStepAbsoluteDt);
            
            //ADD
            dlg.m_lRelativeMinutes = (dtCurr.getTime() - dtPrev.getTime()) / 1000 / 60;
        }
        else if( item.GetType() == PlannerItem.PLANNER_RELATIVE_TIME) {
            dlg.radRelative.setSelected( true);
            dlg.SetControls( false);
            
            //MAIN
            dlg.m_lRelativeMinutes = item.m_lStepRelativedDurationSecs / 60;
            
            //ADD
            dlg.m_gdtmDate = new GregorianCalendar();
            dlg.m_gdtmDate.setTime( dtCurr);
        }
        else
            return;
        
        dlg.setVisible( true);
        if( dlg.m_bOk) {        
            if( dlg.radAbsolute.isSelected()) {
                item.SetupAsAbsolute( dlg.m_gdtmDate.getTime());
            }
            else if( dlg.radRelative.isSelected()) {
                item.SetupAsRelative( dlg.m_lRelativeMinutes * 60);
            }
            
            theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.SetStates();
            
        }
    }
}
