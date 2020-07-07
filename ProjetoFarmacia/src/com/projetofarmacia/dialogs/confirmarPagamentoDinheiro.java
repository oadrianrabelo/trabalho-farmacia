/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetofarmacia.dialogs;

import com.projetofarmacia.DAO.ProdutoDAO;
import com.projetofarmacia.DAO.VendaDAO;
import com.projetofarmacia.interfaces.TelaCaixa;
import com.projetofarmacia.interfaces.TelaLogin;
import com.projetofarmacia.javabeans.Farmacia;
import com.projetofarmacia.javabeans.Produto;
import com.projetofarmacia.javabeans.Venda;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ádrian Rabelo
 */
public class confirmarPagamentoDinheiro extends javax.swing.JDialog {
    private static final long serialVersionUID = 1L;
    
    /**
     * Creates new form confirmarPagamentoDinheiro
     * @param parent
     */
    public confirmarPagamentoDinheiro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        lblInsuficiente.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnFinalizar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        campoTroco = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lblTroco = new javax.swing.JLabel();
        lblInsuficiente = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(52, 152, 219));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnFinalizar.setBackground(new java.awt.Color(52, 152, 219));
        btnFinalizar.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnFinalizar.setForeground(new java.awt.Color(255, 255, 255));
        btnFinalizar.setText("Finalizar");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnFinalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Troco R$:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 109, -1, -1));

        campoTroco.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        campoTroco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoTrocoKeyReleased(evt);
            }
        });
        jPanel1.add(campoTroco, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 187, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Valor dado pelo cliente:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 29, -1, -1));

        lblTroco.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        lblTroco.setForeground(new java.awt.Color(255, 255, 255));
        lblTroco.setText("0.00");
        jPanel1.add(lblTroco, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 109, -1, -1));

        lblInsuficiente.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        lblInsuficiente.setForeground(new java.awt.Color(204, 0, 0));
        lblInsuficiente.setText("Valor insuficiente");
        jPanel1.add(lblInsuficiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 141, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void campoTrocoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoTrocoKeyReleased
        if (!campoTroco.getText().equals("")) {
            mudaTroco(Double.parseDouble(campoTroco.getText().replaceAll(" ", "")), TelaCaixa.total);
//            mudaTroco(Double.parseDouble(campoTroco.getText().replaceAll(" ", "")));
        } else {
            mudaTroco(0, 15);
        }
    }//GEN-LAST:event_campoTrocoKeyReleased

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        Venda obj = new Venda();
        VendaDAO dao = new VendaDAO();
        Produto p = new Produto();
        ProdutoDAO pdao = new ProdutoDAO();
        Farmacia f = new Farmacia();
        f.setIdFarmacia(TelaLogin.idFar);
        obj.setFarmacia(f);
        for (int i = 0; i < TelaCaixa.tabelaProduto.getRowCount(); i++) {
            p.setIdProduto(Integer.parseInt(TelaCaixa.tabelaProduto.getValueAt(i, 6).toString()));
            obj.setIdVenda(Integer.parseInt(TelaCaixa.tabelaProduto.getValueAt(i, 7).toString()));
            obj.setTotal(Double.parseDouble(TelaCaixa.campoTotal.getText()));
            obj.setStatus("FINALIZADO");
            pdao.removeQuantidade(p);
            dao.finalizarVenda(obj);
        }
        TelaCaixa.total = 0;
        TelaCaixa.campoTotal.setText("");
        limparTabela(TelaCaixa.tabelaProduto);
        this.dispose();
        
    }//GEN-LAST:event_btnFinalizarActionPerformed
    private void mudaTroco(double dinheiro, double preco) {
        double troco = dinheiro - preco;
        if (troco > 0 || troco >= TelaCaixa.total) {
            lblInsuficiente.setVisible(false);
            lblTroco.setText(String.valueOf(troco));
            btnFinalizar.setEnabled(true);
        } else {
            lblTroco.setText("0.00");
            lblInsuficiente.setVisible(true);
            btnFinalizar.setEnabled(false);
        }
    }
    
    private void limparTabela(JTable table) {
        DefaultTableModel tabela = (DefaultTableModel) table.getModel();
        for (int i = tabela.getRowCount() -1; i >= 0 ; i--) {
            tabela.removeRow(i);
        }
    }
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
            java.util.logging.Logger.getLogger(confirmarPagamentoDinheiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(confirmarPagamentoDinheiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(confirmarPagamentoDinheiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(confirmarPagamentoDinheiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                confirmarPagamentoDinheiro dialog = new confirmarPagamentoDinheiro(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnFinalizar;
    private javax.swing.JTextField campoTroco;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblInsuficiente;
    private javax.swing.JLabel lblTroco;
    // End of variables declaration//GEN-END:variables
}
