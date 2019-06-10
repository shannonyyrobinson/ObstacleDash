/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obstacledash;

import java.awt.Color;

/**
 *
 * @author shann
 */
public class StartScreenGUI extends javax.swing.JFrame {

    /**
     * Creates new form StartScreenGUI
     */
    public static boolean play;
    public static Color color;
    public String colorString;
    
    public StartScreenGUI() {
        initComponents();
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
        Start = new javax.swing.JButton();
        ObstacleDashLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        InstructionsLabel = new javax.swing.JTextArea();
        ColorLabel = new javax.swing.JLabel();
        ColorBox = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        Start.setBackground(new java.awt.Color(0, 255, 0));
        Start.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 36)); // NOI18N
        Start.setText("LET'S DASH!");
        Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartActionPerformed(evt);
            }
        });

        ObstacleDashLabel.setBackground(new java.awt.Color(0, 0, 0));
        ObstacleDashLabel.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 48)); // NOI18N
        ObstacleDashLabel.setForeground(new java.awt.Color(0, 255, 0));
        ObstacleDashLabel.setText("OBSTACLE DASH");

        InstructionsLabel.setEditable(false);
        InstructionsLabel.setBackground(new java.awt.Color(0, 0, 0));
        InstructionsLabel.setColumns(20);
        InstructionsLabel.setForeground(new java.awt.Color(255, 255, 255));
        InstructionsLabel.setRows(5);
        InstructionsLabel.setText("Instructions:\nUse the space bar to hop over obstacles\nHopping over obstacles increases your score\nHop over as many obstacles as you can to beat your high score\nPress Enter to start the game again\nPress p to pause the game");
        InstructionsLabel.setBorder(null);
        jScrollPane1.setViewportView(InstructionsLabel);

        ColorLabel.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        ColorLabel.setForeground(new java.awt.Color(255, 255, 255));
        ColorLabel.setText("Choose Player Color:");

        ColorBox.setBackground(new java.awt.Color(0, 255, 0));
        ColorBox.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        ColorBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "BLACK", "RED", "ORANGE", "YELLOW", "GREEN", "BLUE", "PURPLE" }));
        ColorBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColorBoxActionPerformed(evt);
            }
        });

        jTextArea1.setBackground(new java.awt.Color(0, 0, 0));
        jTextArea1.setColumns(20);
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setRows(5);
        jTextArea1.setText("Chloe Zhong\nShannon Robinson\nMichael Chen\nLynne Dillman");
        jScrollPane3.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(207, Short.MAX_VALUE)
                .addComponent(ObstacleDashLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(183, 183, 183))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addComponent(Start))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(ColorLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ColorBox, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(ObstacleDashLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ColorLabel)
                    .addComponent(ColorBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(Start)
                .addGap(45, 45, 45)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void StartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartActionPerformed
        // TODO add your handling code here:
        play = true;
    }//GEN-LAST:event_StartActionPerformed

    private void ColorBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColorBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ColorBoxActionPerformed

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
            java.util.logging.Logger.getLogger(StartScreenGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartScreenGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartScreenGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartScreenGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartScreenGUI().setVisible(true);
            }
        });
        */
        color = Color.BLACK;
        StartScreenGUI screen = new StartScreenGUI();
        //new StartScreenGUI().setVisible(true);
        while (play == false){
            screen.setVisible(true);
        }
        
        
        /*if (((String)ColorBox.getSelectedItem()).equals("BLACK"))
        {
            color = Color.BLACK;
        }*/
        Game ObstacleDash = new Game();
        screen.setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ColorBox;
    private javax.swing.JLabel ColorLabel;
    private javax.swing.JTextArea InstructionsLabel;
    private javax.swing.JLabel ObstacleDashLabel;
    private javax.swing.JButton Start;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
