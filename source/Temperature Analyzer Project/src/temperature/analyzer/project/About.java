/*//GEN-FIRST:event_sensorButtonActionPerformed
 * To change this license header, choose License Headers in Project Properties.//GEN-LAST:event_sensorButtonActionPerformed
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temperature.analyzer.project;

import static temperature.analyzer.project.TemperatureAnalyzerProject.sessionData;

/**
 *
 * @author rcatlett
 * @author Quinntero
 */
public class About extends javax.swing.JFrame {

    /**
     * Creates new form to build SQL search queries
     */
    public About() {
        initComponents();
        if (!sessionData){
            viewDataButton.setVisible(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
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

        jLabel1.setText("<html>  <p align=\"center\">This software was developed by the legendary TAP Team: </p>  <div align=\"center\">      <p> </p>     <p>Ruth Catlett</p>   <p> </p>   <p>Kris Hooks</p>   <p> </p>    <p>Yireda Jilili</p>    <p> </p>   <p>James Murphy </p>  <p> </p>  </div>  <p align=\"center\">   This project was the TAP Team's final assignment for </p>  <p align=\"center\">Dr. Polack's    CPSC 430 class in Spring 2016 at the </p>  <p align=\"center\">University of Mary Washington. </p> </html>  </html>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(topBanner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(439, 439, 439))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(topBanner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(391, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        new Home().setVisible(true);
        this.setVisible(false);
    }                                          

    private void uploadfileButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
        new Upload().setVisible(true);
        this.setVisible(false);
    }                                                

    private void searchdbButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
        new Search().setVisible(true);
        this.setVisible(false);
    }                                              

    private void aboutButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        new About().setVisible(true);
        this.setVisible(false);
    }                                           

    private void sensorButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        new Sensor().setVisible(true);
        this.setVisible(false);
    }                                            

    private void viewDataButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
        new SearchOutput().setVisible(true);
        this.setVisible(false);
    }                                              

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
        } catch (ClassNotFoundException | InstantiationException
                | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(About.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new About().setVisible(true);
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton aboutButton;
    private javax.swing.JButton homeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JButton searchdbButton;
    private javax.swing.JButton sensorButton;
    private javax.swing.JLabel taplogoLabel;
    private javax.swing.JLayeredPane topBanner;
    private javax.swing.JButton uploadfileButton;
    private javax.swing.JButton viewDataButton;
    private javax.swing.JLabel worldmapLabel;
    // End of variables declaration                   
}
