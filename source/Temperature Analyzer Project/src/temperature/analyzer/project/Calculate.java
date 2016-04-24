/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temperature.analyzer.project;
import static temperature.analyzer.project.TemperatureAnalyzerProject.dataForSession;
import static temperature.analyzer.project.TemperatureAnalyzerProject.debug;
import java.util.ArrayList;
import java.math.BigDecimal;

/**
 *
 * @author James
 */
public class Calculate extends javax.swing.JFrame {
    
    private double rangeHigh;
    private double rangeLow;
    private double rangeAverage;
    private double[] monthlyHighs;
    private double[] monthlyLows;
    private double[] monthlyAverages;
    private ArrayList<BigDecimal> data;
    
    /**
     * Creates new form to build SQL search queries
     * @param data A ResultSet passed in from SearchOutput.
     */
    public Calculate(ArrayList<BigDecimal> data) {
        initComponents();
        this.data = data;
        if (dataForSession == null) {
            viewDataButton.setVisible(false);
        }
    }
    
    /**
     * Creates new form to build SQL search queries
     */
    public Calculate() {
        initComponents();
        if (dataForSession == null) {
            viewDataButton.setVisible(false);
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

        topBanner = new javax.swing.JLayeredPane();
        worldmapLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        taplogoLabel = new javax.swing.JLabel();
        menuPanel = new javax.swing.JPanel();
        uploadfileButton = new javax.swing.JButton();
        aboutButton = new javax.swing.JButton();
        searchdbButton = new javax.swing.JButton();
        sensorButton = new javax.swing.JButton();
        viewDataButton = new javax.swing.JButton();
        homeButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        rangeHighTemp = new javax.swing.JCheckBox();
        rangeAverageTemp = new javax.swing.JCheckBox();
        rangeLowTemp = new javax.swing.JCheckBox();
        monthlyAverageTemps = new javax.swing.JCheckBox();
        monthlyLowTemps = new javax.swing.JCheckBox();
        monthlyHighTemps = new javax.swing.JCheckBox();
        runBatchButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        topBanner.setPreferredSize(new java.awt.Dimension(1067, 207));

        worldmapLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/temperature/analyzer/project/images/world_map.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 189, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 158, Short.MAX_VALUE)
        );

        taplogoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/temperature/analyzer/project/images/small_tap_logo.png"))); // NOI18N
        taplogoLabel.setText("jLabel2");

        uploadfileButton.setText("Upload File");
        uploadfileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadfileButtonActionPerformed(evt);
            }
        });

        aboutButton.setText("About");
        aboutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutButtonActionPerformed(evt);
            }
        });

        searchdbButton.setText("Search Database");
        searchdbButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchdbButtonActionPerformed(evt);
            }
        });

        sensorButton.setText("Edit Sensors");
        sensorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sensorButtonActionPerformed(evt);
            }
        });

        viewDataButton.setText("View Data");
        viewDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewDataButtonActionPerformed(evt);
            }
        });

        homeButton.setText("Home");
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addComponent(homeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(uploadfileButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchdbButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewDataButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sensorButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aboutButton))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(homeButton)
                    .addComponent(uploadfileButton)
                    .addComponent(searchdbButton)
                    .addComponent(viewDataButton)
                    .addComponent(sensorButton)
                    .addComponent(aboutButton))
                .addGap(37, 37, 37))
        );

        topBanner.setLayer(worldmapLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        topBanner.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        topBanner.setLayer(taplogoLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        topBanner.setLayer(menuPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout topBannerLayout = new javax.swing.GroupLayout(topBanner);
        topBanner.setLayout(topBannerLayout);
        topBannerLayout.setHorizontalGroup(
            topBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topBannerLayout.createSequentialGroup()
                .addComponent(worldmapLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 903, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(taplogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(topBannerLayout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        topBannerLayout.setVerticalGroup(
            topBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topBannerLayout.createSequentialGroup()
                .addGroup(topBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(worldmapLabel)
                    .addComponent(taplogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        rangeHighTemp.setText("High Temperature");
        rangeHighTemp.setToolTipText("The highest temperature in the entire date range.");
        rangeHighTemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rangeHighTempActionPerformed(evt);
            }
        });

        rangeAverageTemp.setText("Average Temperature");
        rangeAverageTemp.setToolTipText("The average temperature for the entire date range.");
        rangeAverageTemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rangeAverageTempActionPerformed(evt);
            }
        });

        rangeLowTemp.setText("Low Temperature");
        rangeLowTemp.setToolTipText("The lowest temperature in the date range.");
        rangeLowTemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rangeLowTempActionPerformed(evt);
            }
        });

        monthlyAverageTemps.setText("Monthly Average Temperatures");
        monthlyAverageTemps.setToolTipText("The average temperatures for each month in the entire date range.");
        monthlyAverageTemps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthlyAverageTempsActionPerformed(evt);
            }
        });

        monthlyLowTemps.setText("Monthly Low Temperatures");
        monthlyLowTemps.setToolTipText("The lowest temperatures for each month in the entire date range.");
        monthlyLowTemps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthlyLowTempsActionPerformed(evt);
            }
        });

        monthlyHighTemps.setToolTipText("The highest temperatures for each month in the entire date range.");
        monthlyHighTemps.setLabel("Monthly High Temperatures");
        monthlyHighTemps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthlyHighTempsActionPerformed(evt);
            }
        });

        runBatchButton.setText("Run Batch");
        runBatchButton.setToolTipText("");
        runBatchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runBatchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(267, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rangeAverageTemp)
                                    .addComponent(rangeLowTemp))
                                .addGap(114, 114, 114))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rangeHighTemp)
                                .addGap(135, 135, 135)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(monthlyHighTemps)
                            .addComponent(monthlyLowTemps)
                            .addComponent(monthlyAverageTemps))))
                .addGap(314, 314, 314))
            .addGroup(layout.createSequentialGroup()
                .addGap(428, 428, 428)
                .addComponent(runBatchButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(topBanner, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(topBanner, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rangeHighTemp)
                    .addComponent(monthlyHighTemps, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rangeAverageTemp)
                    .addComponent(monthlyAverageTemps))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(monthlyLowTemps, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rangeLowTemp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(48, 48, 48)
                .addComponent(runBatchButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        rangeAverageTemp.getAccessibleContext().setAccessibleDescription("");
        monthlyHighTemps.getAccessibleContext().setAccessibleName("Monthly High Temps");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rangeHighTempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rangeHighTempActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rangeHighTempActionPerformed

    private void rangeAverageTempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rangeAverageTempActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rangeAverageTempActionPerformed

    private void rangeLowTempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rangeLowTempActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rangeLowTempActionPerformed

    private void monthlyAverageTempsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthlyAverageTempsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_monthlyAverageTempsActionPerformed

    private void monthlyLowTempsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthlyLowTempsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_monthlyLowTempsActionPerformed

    private void monthlyHighTempsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthlyHighTempsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_monthlyHighTempsActionPerformed

    private void runBatchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runBatchButtonActionPerformed

        
        if (rangeHighTemp.isSelected()) {
            rangeHigh = Calculation.recordHigh(this.data);
        }
        if (rangeLowTemp.isSelected()) {
           // rangeLow = Calculation.recordLow(dataForSession);
        }
        if (rangeAverageTemp.isSelected()) {
            //rangeAverage = Calculation.average(dataForSession);
        }
        
        if (monthlyHighTemps.isSelected()) {
            monthlyHighs = Calculation.monthlyHighs(dataForSession);
        }
        if (monthlyLowTemps.isSelected()) {
            monthlyLows = Calculation.monthlyLows(dataForSession);
        }
        if (monthlyAverageTemps.isSelected()) {
            monthlyAverages = Calculation.monthlyLows(dataForSession);
        }
        
        MessageDialogs.DEBUG(Double.toString(rangeHigh), true);
    }//GEN-LAST:event_runBatchButtonActionPerformed

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_homeButtonActionPerformed

    private void viewDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewDataButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewDataButtonActionPerformed

    private void sensorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sensorButtonActionPerformed

    }//GEN-LAST:event_sensorButtonActionPerformed

    private void searchdbButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchdbButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchdbButtonActionPerformed

    private void aboutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aboutButtonActionPerformed

    private void uploadfileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadfileButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uploadfileButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */                                                                               // Find out why this is grabbing Nimbus theme???
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {                                                                   //  Find out why this is grabbing Nimbus theme???
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException |
                IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calculate.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Calculate().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aboutButton;
    private javax.swing.JButton homeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JCheckBox monthlyAverageTemps;
    private javax.swing.JCheckBox monthlyHighTemps;
    private javax.swing.JCheckBox monthlyLowTemps;
    private javax.swing.JCheckBox rangeAverageTemp;
    private javax.swing.JCheckBox rangeHighTemp;
    private javax.swing.JCheckBox rangeLowTemp;
    private javax.swing.JButton runBatchButton;
    private javax.swing.JButton searchdbButton;
    private javax.swing.JButton sensorButton;
    private javax.swing.JLabel taplogoLabel;
    private javax.swing.JLayeredPane topBanner;
    private javax.swing.JButton uploadfileButton;
    private javax.swing.JButton viewDataButton;
    private javax.swing.JLabel worldmapLabel;
    // End of variables declaration//GEN-END:variables
}
