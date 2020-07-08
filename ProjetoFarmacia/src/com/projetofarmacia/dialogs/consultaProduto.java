/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetofarmacia.dialogs;

import com.projetofarmacia.interfaces.ConsultarProduto;
import com.sun.glass.events.KeyEvent;
import javax.swing.JDialog;

/**
 *
 * @author Ádrian Rabelo
 */
public class consultaProduto extends javax.swing.JDialog {

    /**
     * Creates new form dadosCadastradosSucces
     */
    public consultaProduto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.getRootPane().setDefaultButton(jButton1);
        lblNome.setText(ConsultarProduto.tabelaProdutos.getValueAt(ConsultarProduto.tabelaProdutos.getSelectedRow(), 1).toString());
        lblFornecedor.setText(ConsultarProduto.tabelaProdutos.getValueAt(ConsultarProduto.tabelaProdutos.getSelectedRow(), 2).toString());
        lblQuantidade.setText(ConsultarProduto.tabelaProdutos.getValueAt(ConsultarProduto.tabelaProdutos.getSelectedRow(), 3).toString());
        lblTarja.setText(ConsultarProduto.tabelaProdutos.getValueAt(ConsultarProduto.tabelaProdutos.getSelectedRow(), 4).toString());
        lblPreço.setText(ConsultarProduto.tabelaProdutos.getValueAt(ConsultarProduto.tabelaProdutos.getSelectedRow(), 5).toString());
        lblValidade.setText(ConsultarProduto.tabelaProdutos.getValueAt(ConsultarProduto.tabelaProdutos.getSelectedRow(), 6).toString());
        lblFabricacao.setText(ConsultarProduto.tabelaProdutos.getValueAt(ConsultarProduto.tabelaProdutos.getSelectedRow(), 7).toString());
        // farmácia
        lblLote.setText(ConsultarProduto.tabelaProdutos.getValueAt(ConsultarProduto.tabelaProdutos.getSelectedRow(), 9).toString());
        lblTipo.setText(ConsultarProduto.tabelaProdutos.getValueAt(ConsultarProduto.tabelaProdutos.getSelectedRow(), 11).toString());
        lblCodBar.setText(ConsultarProduto.tabelaProdutos.getValueAt(ConsultarProduto.tabelaProdutos.getSelectedRow(), 12).toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblQuantidade = new javax.swing.JLabel();
        lblFornecedor = new javax.swing.JLabel();
        lblTarja = new javax.swing.JLabel();
        lblPreço = new javax.swing.JLabel();
        lblValidade = new javax.swing.JLabel();
        lblFabricacao = new javax.swing.JLabel();
        lblLote = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        lblCodBar = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(52, 152, 219));
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPanel1KeyReleased(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Dados do produto");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 11, -1, -1));

        jButton1.setBackground(new java.awt.Color(52, 152, 219));
        jButton1.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 540, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nome");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 70, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Quantidade");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 167, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Fornecedor");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 211, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tarja");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 260, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Preço");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 114, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Tipo de produto");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 436, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Data de fabricação");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 348, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Lote");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 392, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Data de validade");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 304, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Código de barras");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 480, -1, -1));

        lblNome.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        lblNome.setForeground(new java.awt.Color(255, 255, 255));
        lblNome.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblNome.setText("...........");
        jPanel1.add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 430, -1));

        lblQuantidade.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        lblQuantidade.setForeground(new java.awt.Color(255, 255, 255));
        lblQuantidade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQuantidade.setText("...........");
        jPanel1.add(lblQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(456, 167, 151, -1));

        lblFornecedor.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        lblFornecedor.setForeground(new java.awt.Color(255, 255, 255));
        lblFornecedor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFornecedor.setText("...........");
        jPanel1.add(lblFornecedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(456, 216, 151, -1));

        lblTarja.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        lblTarja.setForeground(new java.awt.Color(255, 255, 255));
        lblTarja.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblTarja.setText("...........");
        jPanel1.add(lblTarja, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 430, 50));

        lblPreço.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        lblPreço.setForeground(new java.awt.Color(255, 255, 255));
        lblPreço.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPreço.setText("...........");
        jPanel1.add(lblPreço, new org.netbeans.lib.awtextra.AbsoluteConstraints(456, 114, 151, -1));

        lblValidade.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        lblValidade.setForeground(new java.awt.Color(255, 255, 255));
        lblValidade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblValidade.setText("...........");
        jPanel1.add(lblValidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(456, 304, 151, -1));

        lblFabricacao.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        lblFabricacao.setForeground(new java.awt.Color(255, 255, 255));
        lblFabricacao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFabricacao.setText("...........");
        jPanel1.add(lblFabricacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(456, 348, 151, -1));

        lblLote.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        lblLote.setForeground(new java.awt.Color(255, 255, 255));
        lblLote.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLote.setText("...........");
        jPanel1.add(lblLote, new org.netbeans.lib.awtextra.AbsoluteConstraints(456, 392, 151, -1));

        lblTipo.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        lblTipo.setForeground(new java.awt.Color(255, 255, 255));
        lblTipo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTipo.setText("...........");
        jPanel1.add(lblTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(456, 436, 151, -1));

        lblCodBar.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        lblCodBar.setForeground(new java.awt.Color(255, 255, 255));
        lblCodBar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCodBar.setText("...........");
        jPanel1.add(lblCodBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(456, 480, 151, -1));

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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPanel1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyReleased
       
    }//GEN-LAST:event_jPanel1KeyReleased

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
    }//GEN-LAST:event_formKeyReleased

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
            java.util.logging.Logger.getLogger(consultaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(consultaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(consultaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(consultaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            consultaProduto dialog = new consultaProduto(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCodBar;
    private javax.swing.JLabel lblFabricacao;
    private javax.swing.JLabel lblFornecedor;
    private javax.swing.JLabel lblLote;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPreço;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JLabel lblTarja;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblValidade;
    // End of variables declaration//GEN-END:variables
}