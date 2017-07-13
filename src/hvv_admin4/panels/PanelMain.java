/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hvv_admin4.panels;

import hvv_admin4.HVV_Admin4;

/**
 *
 * @author yaroslav
 */
public class PanelMain extends javax.swing.JPanel {
    final public PanelProcess m_pnlProcess;
    
    final HVV_Admin4 theApp;
    /**
     * Creates new form PanelMain
     */
    public PanelMain( HVV_Admin4 app) {
        theApp = app;
        initComponents();
        
        m_pnlProcess = new PanelProcess( app);
        
        jPanel1.add( m_pnlProcess);
        m_pnlProcess.setVisible( true);
        m_pnlProcess.setBounds( 2, 2, 586, 430);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        m_scrollBar = new javax.swing.JScrollBar();

        setMaximumSize(new java.awt.Dimension(640, 460));
        setMinimumSize(new java.awt.Dimension(640, 460));
        setPreferredSize(new java.awt.Dimension(640, 460));
        addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                formMouseWheelMoved(evt);
            }
        });
        setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 0, 0)));
        jPanel1.setMaximumSize(new java.awt.Dimension(590, 440));
        jPanel1.setPreferredSize(new java.awt.Dimension(590, 440));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 588, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 438, Short.MAX_VALUE)
        );

        add(jPanel1);
        jPanel1.setBounds(10, 10, 590, 440);

        m_scrollBar.setPreferredSize(new java.awt.Dimension(25, 440));
        m_scrollBar.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
            public void adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
                m_scrollBarAdjustmentValueChanged(evt);
            }
        });
        add(m_scrollBar);
        m_scrollBar.setBounds(610, 10, 25, 440);
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_formMouseWheelMoved
        if( m_scrollBar.isEnabled()) {
            int nMin = m_scrollBar.getMinimum();
            int nMax = m_scrollBar.getMaximum();
            int nPos = m_scrollBar.getValue();
            int nStep1 = m_scrollBar.getBlockIncrement();
            int nStep2 = m_scrollBar.getUnitIncrement();

            int nNextPos = nPos + evt.getWheelRotation() * nStep1;

            if( nNextPos < nMin) nNextPos = nMin;
            if( nNextPos > nMax) nNextPos = nMax;
            m_scrollBar.setValue( nNextPos);
        }
    }//GEN-LAST:event_formMouseWheelMoved

    private void m_scrollBarAdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {//GEN-FIRST:event_m_scrollBarAdjustmentValueChanged
        if( m_pnlProcess != null)
            m_pnlProcess.setBounds( 2, 2 - m_scrollBar.getValue(), 586, 436 + m_scrollBar.getValue());
    }//GEN-LAST:event_m_scrollBarAdjustmentValueChanged

    public void ScrollActiveStepToCenter() {                                                   
        int nCurrentStepY = 0;
        switch( theApp.GetCurrentStep()) {
            case 1:  nCurrentStepY = theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep01.getY() + 
                                        theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep01.btn_01_01_Start.getY(); break;
                
            case 21:  nCurrentStepY = theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep02.getY() + 
                                        theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep02.btn_02_01_Start.getY(); break;
            case 22:  nCurrentStepY = theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep02.getY() + 
                                        theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep02.btn_02_02_Start.getY(); break;            
                
            case 41:  nCurrentStepY = theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep03.getY() + 
                                        theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep03.btn_03_01_Start.getY(); break;
            case 42:  nCurrentStepY = theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep03.getY() + 
                                        theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep03.btn_03_02_Start.getY(); break;
            case 43:  nCurrentStepY = theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep03.getY() + 
                                        theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep03.btn_03_03_Start.getY(); break;
            case 44:  nCurrentStepY = theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep03.getY() + 
                                        theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep03.btn_03_04_Start.getY(); break;
                
            case 61:  nCurrentStepY = theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep04.getY() + 
                                        theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep04.btn_04_01_Start.getY(); break;
            case 62:  nCurrentStepY = theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep04.getY() + 
                                        theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep04.btn_04_02_Start.getY(); break;
            case 63:  nCurrentStepY = theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep04.getY() + 
                                        theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep04.btn_04_03_Start.getY(); break;
            case 64:  nCurrentStepY = theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep04.getY() + 
                                        theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep04.btn_04_04_Start.getY(); break;
                
            case 81:  nCurrentStepY = theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep05.getY() + 
                                        theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep05.btn_05_01_Start.getY(); break;
            case 82:  nCurrentStepY = theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep05.getY() + 
                                        theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep05.btn_05_02_Start.getY(); break;
                
            case 101:  nCurrentStepY = theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep06.getY() + 
                                        theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep06.btn_06_01_Start.getY(); break;
            case 102:  nCurrentStepY = theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep06.getY() + 
                                        theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep06.btn_06_02_Start.getY(); break;
            case 103:  nCurrentStepY = theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep06.getY() + 
                                        theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep06.btn_06_03_Start.getY(); break;
            case 104:  nCurrentStepY = theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep06.getY() + 
                                        theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep06.btn_06_04_Start.getY(); break;
            case 105:  nCurrentStepY = theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep06.getY() + 
                                        theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep06.btn_06_05_Start.getY(); break;
            case 106:  nCurrentStepY = theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep06.getY() + 
                                        theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep06.btn_06_06_Start.getY(); break;

            case 121:  nCurrentStepY = theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep07.getY() + 
                                        theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep07.btn_07_01_Start.getY(); break;
            case 122:  nCurrentStepY = theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep07.getY() + 
                                        theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep07.btn_07_02_Start.getY(); break;
                
            case 141:  nCurrentStepY = theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep08.getY() + 
                                        theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep08.btn_08_01_Start.getY(); break;
            case 142:  nCurrentStepY = theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep08.getY() + 
                                        theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep08.btn_08_02_Start.getY(); break;
            case 143:  nCurrentStepY = theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep08.getY() + 
                                        theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep08.btn_08_03_Start.getY(); break;
            case 144:  nCurrentStepY = theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep08.getY() + 
                                        theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep08.btn_08_04_Start.getY(); break;
            case 145:  nCurrentStepY = theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep08.getY() + 
                                        theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep08.btn_08_05_Start.getY(); break;
            case 146:  nCurrentStepY = theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep08.getY() + 
                                        theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep08.btn_08_06_Start.getY(); break;
                
            case 161:  nCurrentStepY = theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep09.getY() + 
                                        theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep09.btn_09_01_Start.getY(); break;
            case 162:  nCurrentStepY = theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep09.getY() + 
                                        theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep09.btn_09_02_Start.getY(); break;
                
            case 181:  nCurrentStepY = theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep10.getY() + 
                                        theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep10.btn_10_01_Start.getY(); break;
            case 182:  nCurrentStepY = theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep10.getY() + 
                                        theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep10.btn_10_02_Start.getY(); break;
            case 183:  nCurrentStepY = theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep10.getY() + 
                                        theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep10.btn_10_03_Start.getY(); break;
            case 184:  nCurrentStepY = theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep10.getY() + 
                                        theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep10.btn_10_04_Start.getY(); break;
        }
        
        nCurrentStepY = nCurrentStepY - 440 + 220;

        if( nCurrentStepY < 0)
            nCurrentStepY = 0;
        
        if( nCurrentStepY > m_scrollBar.getMaximum())
            nCurrentStepY = m_scrollBar.getMaximum();
        
        m_scrollBar.setValue( nCurrentStepY);
        /*if( m_pnlProcess != null)
            m_pnlProcess.setBounds( 2, 2 - m_scrollBar.getValue(), 586, 436 + m_scrollBar.getValue());*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    public javax.swing.JScrollBar m_scrollBar;
    // End of variables declaration//GEN-END:variables
}
