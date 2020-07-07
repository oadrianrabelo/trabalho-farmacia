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
public class confirmarPagamentoCartao extends javax.swing.JDialog {
    private static final long serialVersionUID = 1L;

    /**
     * Creates new form confirmarPagamentoDinheiro
     * @param parent
     * @param modal
     */
    public confirmarPagamentoCartao(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        campoNumCartao = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        campoValidade = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        campoCVV = new javax.swing.JTextField();
        btnFinalizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(52, 152, 219));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Insira o número do cartão:");

        campoNumCartao.setBackground(new java.awt.Color(52, 152, 219));
        campoNumCartao.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        campoNumCartao.setForeground(new java.awt.Color(255, 255, 255));
        campoNumCartao.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        campoNumCartao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoNumCartaoKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Insira o nome completo:");

        campoNome.setBackground(new java.awt.Color(52, 152, 219));
        campoNome.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        campoNome.setForeground(new java.awt.Color(255, 255, 255));
        campoNome.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        campoNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoNomeKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Insira a data de validade:");

        campoValidade.setBackground(new java.awt.Color(52, 152, 219));
        campoValidade.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        campoValidade.setForeground(new java.awt.Color(255, 255, 255));
        try {
            campoValidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoValidade.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Insira o CVV:");

        campoCVV.setBackground(new java.awt.Color(52, 152, 219));
        campoCVV.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        campoCVV.setForeground(new java.awt.Color(255, 255, 255));
        campoCVV.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        campoCVV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoCVVKeyReleased(evt);
            }
        });

        btnFinalizar.setBackground(new java.awt.Color(52, 152, 219));
        btnFinalizar.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnFinalizar.setForeground(new java.awt.Color(255, 255, 255));
        btnFinalizar.setText("Finalizar");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(campoCVV)
                    .addComponent(campoNumCartao)
                    .addComponent(jLabel2)
                    .addComponent(campoNome)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(campoValidade, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(109, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFinalizar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoNumCartao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campoValidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoCVV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFinalizar)
                .addContainerGap(28, Short.MAX_VALUE))
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void campoNumCartaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNumCartaoKeyReleased
       
    }//GEN-LAST:event_campoNumCartaoKeyReleased

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        if (campoNome.getText().equals("") || campoNumCartao.getText().equals("")
            || campoValidade.getText().equals("") || campoCVV.getText().equals("")) {
            new camposVazios(null, true).setVisible(true);
        } else {
            Venda obj = new Venda();
            VendaDAO dao = new VendaDAO();
            Produto p = new Produto();
            ProdutoDAO pdao = new ProdutoDAO();
            Farmacia f = new Farmacia();
            f.setIdFarmacia(TelaLogin.idFar);
            obj.setFarmacia(f);
            for (int i = 0; i < TelaCaixa.tabelaProduto.getRowCount(); i++) {
                p.setIdProduto(Integer.parseInt(TelaCaixa.tabelaProduto.getValueAt(i, 6).toString()));
                obj.setTotal(Double.parseDouble(TelaCaixa.campoTotal.getText()));
                obj.setIdVenda(Integer.parseInt(TelaCaixa.tabelaProduto.getValueAt(i, 7).toString()));
                obj.setStatus("FINALIZADO");
                pdao.removeQuantidade(p);
                dao.finalizarVenda(obj);
            }
            TelaCaixa.total = 0;
            TelaCaixa.campoTotal.setText("");
            limparTabela(TelaCaixa.tabelaProduto);
            this.dispose();
        }
        
        
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void limparTabela(JTable table) {
        DefaultTableModel tabela = (DefaultTableModel) table.getModel();
        for (int i = tabela.getRowCount() -1; i >= 0 ; i--) {
            tabela.removeRow(i);
        }
    }
    private void campoNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNomeKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNomeKeyReleased

    private void campoCVVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoCVVKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_campoCVVKeyReleased

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
            java.util.logging.Logger.getLogger(confirmarPagamentoCartao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(confirmarPagamentoCartao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(confirmarPagamentoCartao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(confirmarPagamentoCartao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                confirmarPagamentoCartao dialog = new confirmarPagamentoCartao(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField campoCVV;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoNumCartao;
    private javax.swing.JFormattedTextField campoValidade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
