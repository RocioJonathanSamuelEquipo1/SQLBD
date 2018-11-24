/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejecutor;

import Conexion.DaoArticulo;
import static Conexion.DaoArticulo.printPersons;
import Criteria.Criteria;
import entidad.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author omarp
 */
public class Filter extends javax.swing.JFrame {

    /**
     * Creates new form Filter
     */
    public Filter() {
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

        jLabel1 = new javax.swing.JLabel();
        btnMales = new javax.swing.JButton();
        btnFemales = new javax.swing.JButton();
        btnSingleMales = new javax.swing.JButton();
        btnSingleFemales = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("FILTERPATTERN");

        btnMales.setText("Males");
        btnMales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMalesActionPerformed(evt);
            }
        });

        btnFemales.setText("Females");
        btnFemales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFemalesActionPerformed(evt);
            }
        });

        btnSingleMales.setText("Single Males");
        btnSingleMales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSingleMalesActionPerformed(evt);
            }
        });

        btnSingleFemales.setText("Single Females");
        btnSingleFemales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSingleFemalesActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Filtrar por:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMales, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSingleMales))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFemales, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSingleFemales))
                .addGap(86, 86, 86))
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMales)
                    .addComponent(btnFemales))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSingleFemales)
                    .addComponent(btnSingleMales))
                .addGap(69, 69, 69))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMalesActionPerformed
        try {
            // TODO add your handling code here:
            List<Person> persons= new ArrayList<Person>();
            DaoArticulo nda = new DaoArticulo();
            persons=nda.buscarArticulos();

            Criteria male = new CriteriaMale();

            System.out.println("Males: ");
            printPersons(male.meetCriteria(persons));

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Filter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnMalesActionPerformed

    private void btnFemalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFemalesActionPerformed
        // TODO add your handling code here:
          try {
            // TODO add your handling code here:
            List<Person> persons= new ArrayList<Person>();
            DaoArticulo nda = new DaoArticulo();
            persons=nda.buscarArticulos();

                Criteria female = new CriteriaFemale();

          System.out.println("\nFemales: ");
      printPersons(female.meetCriteria(persons));

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Filter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnFemalesActionPerformed

    private void btnSingleMalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSingleMalesActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            List<Person> persons= new ArrayList<Person>();
            DaoArticulo nda = new DaoArticulo();
            persons=nda.buscarArticulos();

           Criteria singleMale = new AndCriteria(single, male);

         System.out.println("\nSingle Males: ");
      printPersons(singleMale.meetCriteria(persons));

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Filter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSingleMalesActionPerformed

    private void btnSingleFemalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSingleFemalesActionPerformed
        // TODO add your handling code here:
        
        try {
            // TODO add your handling code here:
            List<Person> persons= new ArrayList<Person>();
            DaoArticulo nda = new DaoArticulo();
            persons=nda.buscarArticulos();

           Criteria singleOrFemale = new OrCriteria(single, female);

        System.out.println("\nSingle Or Females: ");
      printPersons(singleOrFemale.meetCriteria(persons));

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Filter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSingleFemalesActionPerformed

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
            java.util.logging.Logger.getLogger(Filter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Filter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Filter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Filter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Filter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFemales;
    private javax.swing.JButton btnMales;
    private javax.swing.JButton btnSingleFemales;
    private javax.swing.JButton btnSingleMales;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}