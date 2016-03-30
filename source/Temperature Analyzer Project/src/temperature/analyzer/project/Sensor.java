/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temperature.analyzer.project;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import static temperature.analyzer.project.TemperatureAnalyzerProject.sessionData;
/**
 *
 * @author Quinntero
 * @author james
 */
public class Sensor extends javax.swing.JFrame {

    ArrayList<String> locations;
    ArrayList<String> codes;
    ArrayList<Integer> sensors;
    LocationListModel llm;
    SensorListModel slm;
    
    String locCode;
    String locName;
    
    /**
     * Creates new form Home
     */
    public Sensor () {
        locations = Filter.getLocations();
        
        // store three-letter codes separately
        codes = new ArrayList<>();
        for (String loc : locations) {
            codes.add(loc.split(" ")[0]);
        }
        
        locCode = locName = "";
        llm = new LocationListModel(locations);
        
        sensors = Filter.getSensors();
        slm = new SensorListModel(sensors);
        
        initComponents();
        if (!sessionData) {
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
        sensorListPane = new javax.swing.JScrollPane();
        sensorList = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        newSerialButton = new javax.swing.JButton();
        editLocButton = new javax.swing.JButton();
        addLocButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        serialListPane = new javax.swing.JScrollPane();
        serialList = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        newSerial = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        newCode = new javax.swing.JTextField();
        newLocation = new javax.swing.JTextField();
        removeSerialButton = new javax.swing.JButton();
        removeLocButton = new javax.swing.JButton();

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
                .addContainerGap(9, Short.MAX_VALUE))
            .addGroup(topBannerLayout.createSequentialGroup()
                .addComponent(taplogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(topBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(topBannerLayout.createSequentialGroup()
                    .addComponent(worldmapLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 7, Short.MAX_VALUE)))
        );

        sensorList.setModel(llm);
        sensorList.setToolTipText("<html>Click to select or deselect.<br>\nUse CTRL + click or SHIFT + click  to select multiple sensors.\n</html>");
        sensorListPane.setViewportView(sensorList);

        jLabel1.setText("Sensor Locations");

        newSerialButton.setText("Add Serial Number");
        newSerialButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newSerialButtonActionPerformed(evt);
            }
        });

        editLocButton.setText("Edit Sensor Location");
        editLocButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editLocButtonActionPerformed(evt);
            }
        });

        addLocButton.setText("Add Location");
        addLocButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addLocButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Sensor Serial:");

        serialList.setModel(slm);
        serialList.setToolTipText("<html>Click to select or deselect.<br>\nUse CTRL + click or SHIFT + click  to select multiple serial numbers.\n</html");
        serialListPane.setViewportView(serialList);

        jLabel3.setText("Serial Numbers:");

        newSerial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newSerialActionPerformed(evt);
            }
        });

        jLabel4.setText("Sensor Location:");

        newCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newCodeActionPerformed(evt);
            }
        });

        newLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newLocationActionPerformed(evt);
            }
        });

        removeSerialButton.setText("Remove Sensor");

        removeLocButton.setText("Remove Location");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(topBanner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(335, 335, 335)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(newCode, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(newLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(removeSerialButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(newSerialButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(newSerial, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addComponent(addLocButton, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(removeLocButton))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(serialListPane, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(sensorListPane, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(161, 161, 161)
                                .addComponent(editLocButton)))))
                .addContainerGap(549, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(topBanner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(serialListPane, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                            .addComponent(sensorListPane))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editLocButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newSerial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newSerialButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeSerialButton)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(newCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addLocButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeLocButton)))
                .addContainerGap(80, Short.MAX_VALUE))
        );

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

    private void newSerialButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newSerialButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newSerialButtonActionPerformed

    private void editLocButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editLocButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editLocButtonActionPerformed

    private void newSerialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newSerialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newSerialActionPerformed

    private void newCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newCodeActionPerformed
        
    }//GEN-LAST:event_newCodeActionPerformed

    private void newLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newLocationActionPerformed
        
    }//GEN-LAST:event_newLocationActionPerformed

    private void viewDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewDataButtonActionPerformed
        // TODO add your handling code here:
        new SearchOutput().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_viewDataButtonActionPerformed

    private void addLocButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addLocButtonActionPerformed
        String location = "";
        locName = newLocation.getText();
        locCode = newCode.getText();
        // Location code must be alphanumeric and three characters long
        if (!locCode.matches("^[a-zA-Z0-9]*$") || locCode.length() != 3) {
            MessageDialogs.InputError("Invalid location code: " + locCode);
            return;
        }
        
        // Location name cannot be blank or whitespace-only
        if (!Filter.isEmptyOrWhitespace(locName)) {
            MessageDialogs.InputError("Invalid location name: " + locName);
            return;
        }
        
        // Guard against accidental SQL injections by escaping quotes
        // (replace with call to mogrify() ?)
        locName = locName.replace("'", "\\'");
        locName = locName.replace("\"", "\\\"");
        
        // Update location list
        location = locCode + " " + locName;
        if (locations.contains(location)) {
            MessageDialogs.InputError("Location already exists.");
            return;
        }
        locations.add(location);
        llm = new LocationListModel(locations);
    }//GEN-LAST:event_addLocButtonActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aboutButton;
    private javax.swing.JButton addLocButton;
    private javax.swing.JButton editLocButton;
    private javax.swing.JButton homeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JTextField newCode;
    private javax.swing.JTextField newLocation;
    private javax.swing.JTextField newSerial;
    private javax.swing.JButton newSerialButton;
    private javax.swing.JButton removeLocButton;
    private javax.swing.JButton removeSerialButton;
    private javax.swing.JButton searchdbButton;
    private javax.swing.JButton sensorButton;
    private javax.swing.JList<String> sensorList;
    private javax.swing.JScrollPane sensorListPane;
    private javax.swing.JList<Integer> serialList;
    private javax.swing.JScrollPane serialListPane;
    private javax.swing.JLabel taplogoLabel;
    private javax.swing.JLayeredPane topBanner;
    private javax.swing.JButton uploadfileButton;
    private javax.swing.JButton viewDataButton;
    private javax.swing.JLabel worldmapLabel;
    // End of variables declaration//GEN-END:variables
}
