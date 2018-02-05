/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.jcsistemas.apresentacao;
import br.edu.ifnmg.jcsistemas.aplicacao.Endereco;
import br.edu.ifnmg.jcsistemas.aplicacao.EnderecoRepositorio;
import br.edu.ifnmg.jcsistemas.aplicacao.Cliente;
import br.edu.ifnmg.jcsistemas.aplicacao.RepositorioBuilder;
import br.edu.ifnmg.jcsistemas.aplicacao.ViolacaoRegraNegocioException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import jcsistemas.persistencia.BD;


/**
 *
 * @author victor
 */
public class TelaEditarCliente extends FormBuscar<Cliente> {
    EnderecoRepositorio endereco = RepositorioBuilder.getEnderecoRepositorio();
    Endereco a = new Endereco();
    /**
     * Creates new form TelaEditarCliente
     */
    public TelaEditarCliente() {
        initComponents();
        setEditar(new TelaCadastrarCliente());
        setRepositorio(RepositorioBuilder.getClienteRepositorio());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabResultado = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnNovo = new javax.swing.JButton();
        txtCpf = new javax.swing.JFormattedTextField();

        setClosable(true);
        setMaximizable(true);

        tabResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabResultado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabResultadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabResultado);

        jLabel1.setText("Nome : ");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        jLabel3.setText("CPF : ");

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        txtCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCpfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(358, Short.MAX_VALUE)
                .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(189, 189, 189))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnBuscar)
                                    .addGap(141, 141, 141)
                                    .addComponent(btnCancelar)
                                    .addGap(157, 157, 157)
                                    .addComponent(btnNovo))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel3)
                                    .addGap(214, 214, 214)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE))
                        .addComponent(jScrollPane1))
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(365, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancelar)
                        .addComponent(btnNovo)
                        .addComponent(btnBuscar))
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false); 
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        TelaCadastrarCliente tela = new TelaCadastrarCliente();
        this.getParent().add(tela);
        tela.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscar();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCpfActionPerformed

    private void tabResultadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabResultadoMouseClicked
       int linha = tabResultado.getSelectedRow();
        
        long id = Long.parseLong(tabResultado.getValueAt(linha, 0).toString() );
        
        editar(id);
    }//GEN-LAST:event_tabResultadoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabResultado;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables

    @Override
    protected void preencherTabela(List<Cliente> dados) {
        DefaultTableModel modelo = new DefaultTableModel();
            
        modelo.addColumn("ID");
        modelo.addColumn("Nome");
        modelo.addColumn("CPF");
        modelo.addColumn("RG");
        modelo.addColumn("Nascimento");
        modelo.addColumn("Email");
        modelo.addColumn("Telefone");
        modelo.addColumn("IDEndereco");
        modelo.addColumn("Cidade");
        modelo.addColumn("Rua");
        modelo.addColumn("Complemento");
        modelo.addColumn("Numero");
        modelo.addColumn("Bairro");
        modelo.addColumn("Estado");
        modelo.addColumn("Cep");
        for(Cliente c : dados){
            Vector valores = new Vector();
            valores.add(c.getId());
            valores.add(c.getNome());
            valores.add(c.getCpf());
            valores.add(c.getRg());
            valores.add(c.getNascimento());
            valores.add(c.getEmail());
            valores.add(c.getTelefone());
            valores.add(c.getEndereco());        
            Endereco obj1 = RepositorioBuilder.getEnderecoRepositorio().Abrir(c.getEndereco());
            valores.add(obj1.getCidade()); 
            valores.add(obj1.getRua()); 
            valores.add(obj1.getComplemento()); 
            valores.add(obj1.getNumero()); 
            valores.add(obj1.getBairro()); 
             String uf=""; 
            try {  
                    PreparedStatement consulta;
                    consulta = BD.getConexao().prepareStatement("SELECT nomeUf FROM uf where idUf = ?");
                    consulta.setLong(1, obj1.getEstado());
                    ResultSet r = consulta.executeQuery();
                    r.next();
                    uf = r.getString(1);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaEditarFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
                }
            valores.add(uf);
            valores.add(obj1.getCep());

            modelo.addRow(valores);
        }

        tabResultado.setModel(modelo);
    }

    @Override
    protected Cliente carregaFiltro() {
         try {
            Cliente filtro = new Cliente();
            
            if(!txtNome.getText().isEmpty())
                filtro.setNome(txtNome.getText());
            if(txtCpf.getValue() != null)
                filtro.setCpf(txtCpf.getText());
            return filtro;
        } catch (ViolacaoRegraNegocioException ex) {
            Logger.getLogger(TelaEditarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    protected Cliente novaEntidade() {
        return new Cliente();
    }
   
}
