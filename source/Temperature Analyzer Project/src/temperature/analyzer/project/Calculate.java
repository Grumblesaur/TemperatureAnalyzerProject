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
        menuPanel = new javax.swing.JPanel();
        homeButton = new javax.swing.JButton();
        uploadfileButton = new javax.swing.JButton();
        aboutButton = new javax.swing.JButton();
        searchdbButton = new javax.swing.JButton();
        sensorButton = new javax.swing.JButton();
        viewDataButton = new javax.swing.JButton();
        taplogoLabel = new javax.swing.JLabel();
        worldmapLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        rangeHighTemp = new javax.swing.JCheckBox();
        rangeAverageTemp = new javax.swing.JCheckBox();
        rangeLowTemp = new javax.swing.JCheckBox();
        monthlyAverageTemps = new javax.swing.JCheckBox();
        monthlyLowTemps = new javax.swing.JCheckBox();
        monthlyHighTemps = new javax.swing.JCheckBox();
        runBatchButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        homeButton.setText("Home");
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap()
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
                .addComponent(aboutButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aboutButton)
                    .addComponent(uploadfileButton)
                    .addComponent(homeButton)
                    .addComponent(searchdbButton)
                    .addComponent(sensorButton)
                    .addComponent(viewDataButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        taplogoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/temperature/analyzer/project/images/small_tap_logo.png"))); // NOI18N
        taplogoLabel.setText("jLabel2");

        worldmapLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/temperature/analyzer/project/images/world_map.png"))); // NOI18N

        topBanner.setLayer(menuPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        topBanner.setLayer(taplogoLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        topBanner.setLayer(worldmapLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout topBannerLayout = new javax.swing.GroupLayout(topBanner);
        topBanner.setLayout(topBannerLayout);
        topBannerLayout.setHorizontalGroup(
            topBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topBannerLayout.createSequentialGroup()
                .addContainerGap(349, Short.MAX_VALUE)
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(170, 170, 170)
                .addComponent(taplogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(topBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(topBannerLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(worldmapLabel)
                    .addContainerGap(42, Short.MAX_VALUE)))
        );
        topBannerLayout.setVerticalGroup(
            topBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topBannerLayout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(topBannerLayout.createSequentialGroup()
                .addComponent(taplogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(topBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(topBannerLayout.createSequentialGroup()
                    .addComponent(worldmapLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 7, Short.MAX_VALUE)))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(rangeHighTemp)
                            .addGap(156, 156, 156)
                            .addComponent(monthlyHighTemps))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(77, 77, 77)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rangeAverageTemp)
                            .addComponent(rangeLowTemp))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(monthlyLowTemps)
                            .addComponent(monthlyAverageTemps))))
                .addGap(439, 439, 439))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(topBanner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(548, 548, 548)
                        .addComponent(runBatchButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(topBanner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
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
                .addGap(80, 80, 80)
                .addComponent(runBatchButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(206, 206, 206))
        );

        rangeAverageTemp.getAccessibleContext().setAccessibleDescription("");
        monthlyHighTemps.getAccessibleContext().setAccessibleName("Monthly High Temps");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        // TODO add your handling code here:
        new Home().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_homeButtonActionPerformed

    private void uploadfileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadfileButtonActionPerformed
        // TODO add your handling code here:
        new Upload().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_uploadfileButtonActionPerformed

    private void searchdbButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchdbButtonActionPerformed
        // TODO add your handling code here:
        new Search().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_searchdbButtonActionPerformed

    private void aboutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutButtonActionPerformed
        // TODO add your handling code here:
        new About().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_aboutButtonActionPerformed

    private void sensorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sensorButtonActionPerformed
        // TODO add your handling code here:
        new Sensor().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_sensorButtonActionPerformed

    private void viewDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewDataButtonActionPerformed
        // TODO add your handling code here:
        new SearchOutput().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_viewDataButtonActionPerformed

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
            rangeLow = Calculation.recordLow(this.data);
        }
        if (rangeAverageTemp.isSelected()) {
            rangeAverage = Calculation.average(this.data);
        }
        MessageDialogs.DEBUG(Double.toString(rangeHigh), true);
    }//GEN-LAST:event_runBatchButtonActionPerformed

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
