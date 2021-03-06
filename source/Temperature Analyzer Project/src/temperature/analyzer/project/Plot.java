/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temperature.analyzer.project;

import static temperature.analyzer.project.TemperatureAnalyzerProject.presentation;
import static temperature.analyzer.project.TemperatureAnalyzerProject.sessionData;

/**
 *
 * @author ruth
 */
public class Plot extends javax.swing.JFrame {

    /**
     * Creates new form Plot
     */
    public Plot() {
        initComponents();
        if (!sessionData) {
            viewDataButton.setVisible(false);
        }
        graphedCalc.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        calculationType = new javax.swing.ButtonGroup();
        timeType = new javax.swing.ButtonGroup();
        backButton = new javax.swing.JButton();
        graphedCalc = new javax.swing.JLabel();
        highCalc = new javax.swing.JRadioButton();
        avgCalc = new javax.swing.JRadioButton();
        lowCalc = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        yrlyTime = new javax.swing.JRadioButton();
        monthTime = new javax.swing.JRadioButton();
        dailyTime = new javax.swing.JRadioButton();
        graphButton = new javax.swing.JButton();
        topBanner = new javax.swing.JLayeredPane();
        worldmapLabel = new javax.swing.JLabel();
        menuPanel = new javax.swing.JPanel();
        homeButton = new javax.swing.JButton();
        uploadfileButton = new javax.swing.JButton();
        aboutButton = new javax.swing.JButton();
        searchdbButton = new javax.swing.JButton();
        sensorButton = new javax.swing.JButton();
        viewDataButton = new javax.swing.JButton();
        taplogoLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backButton.setText("Back to Data");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        graphedCalc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/temperature/analyzer/project/images/tap_plot.png"))); // NOI18N

        calculationType.add(highCalc);
        highCalc.setText("High");

        calculationType.add(avgCalc);
        avgCalc.setText("Average");

        calculationType.add(lowCalc);
        lowCalc.setText("Low");

        jLabel2.setText("Select a Calculation Type:");

        jLabel3.setText("Select a Time Frame:");

        timeType.add(yrlyTime);
        yrlyTime.setText("Yearly");
        yrlyTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yrlyTimeActionPerformed(evt);
            }
        });

        timeType.add(monthTime);
        monthTime.setText("Monthly");
        monthTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthTimeActionPerformed(evt);
            }
        });

        timeType.add(dailyTime);
        dailyTime.setText("Daily");
        dailyTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dailyTimeActionPerformed(evt);
            }
        });

        graphButton.setText("Plot");
        graphButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graphButtonActionPerformed(evt);
            }
        });

        worldmapLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/temperature/analyzer/project/images/world_map.png"))); // NOI18N

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

        taplogoLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/temperature/analyzer/project/images/small_tap_logo.png"))); // NOI18N
        taplogoLabel1.setText("jLabel2");

        topBanner.setLayer(worldmapLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        topBanner.setLayer(menuPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        topBanner.setLayer(taplogoLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout topBannerLayout = new javax.swing.GroupLayout(topBanner);
        topBanner.setLayout(topBannerLayout);
        topBannerLayout.setHorizontalGroup(
            topBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topBannerLayout.createSequentialGroup()
                .addComponent(worldmapLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 903, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(taplogoLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, Short.MAX_VALUE))
            .addGroup(topBannerLayout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        topBannerLayout.setVerticalGroup(
            topBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topBannerLayout.createSequentialGroup()
                .addGroup(topBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(worldmapLabel)
                    .addComponent(taplogoLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(highCalc)
                    .addComponent(avgCalc)
                    .addComponent(jLabel2)
                    .addComponent(lowCalc)
                    .addComponent(jLabel3)
                    .addComponent(yrlyTime)
                    .addComponent(monthTime)
                    .addComponent(dailyTime)
                    .addComponent(graphButton)
                    .addComponent(backButton))
                .addGap(47, 47, 47)
                .addComponent(graphedCalc)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(topBanner)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(topBanner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(backButton)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(highCalc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(avgCalc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lowCalc)
                        .addGap(42, 42, 42)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(yrlyTime)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(monthTime)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dailyTime)
                        .addGap(26, 26, 26)
                        .addComponent(graphButton)
                        .addGap(44, 44, 44))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(graphedCalc)
                        .addContainerGap(24, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        if (presentation) {
            new SearchOutput().setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_backButtonActionPerformed

    private void yrlyTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yrlyTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yrlyTimeActionPerformed

    private void monthTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_monthTimeActionPerformed

    private void dailyTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dailyTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dailyTimeActionPerformed

    private void graphButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graphButtonActionPerformed
        // TODO add your handling code here:
        graphedCalc.setVisible(true);
    }//GEN-LAST:event_graphButtonActionPerformed

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_homeButtonActionPerformed

    private void uploadfileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadfileButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uploadfileButtonActionPerformed

    private void aboutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aboutButtonActionPerformed

    private void searchdbButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchdbButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchdbButtonActionPerformed

    private void sensorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sensorButtonActionPerformed

    }//GEN-LAST:event_sensorButtonActionPerformed

    private void viewDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewDataButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewDataButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Plot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Plot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Plot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Plot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Plot().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aboutButton;
    private javax.swing.JRadioButton avgCalc;
    private javax.swing.JButton backButton;
    private javax.swing.ButtonGroup calculationType;
    private javax.swing.JRadioButton dailyTime;
    private javax.swing.JButton graphButton;
    private javax.swing.JLabel graphedCalc;
    private javax.swing.JRadioButton highCalc;
    private javax.swing.JButton homeButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton lowCalc;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JRadioButton monthTime;
    private javax.swing.JButton searchdbButton;
    private javax.swing.JButton sensorButton;
    private javax.swing.JLabel taplogoLabel1;
    private javax.swing.ButtonGroup timeType;
    private javax.swing.JLayeredPane topBanner;
    private javax.swing.JButton uploadfileButton;
    private javax.swing.JButton viewDataButton;
    private javax.swing.JLabel worldmapLabel;
    private javax.swing.JRadioButton yrlyTime;
    // End of variables declaration//GEN-END:variables
}
