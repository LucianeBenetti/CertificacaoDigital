/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocertificadodigital;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import projetocertificadodigital.dao.DAO;
import projetocertificadodigital.vo.Certificado;

public class AssinaturaDigital extends javax.swing.JFrame {
    
    Certificado certificado = new Certificado();

    public static final String ALGORITHM = "RSA";
    public static final String PATH_CHAVE_PRIVADA = "C:/CertificadoDigital/private.key";
    public static final String PATH_CHAVE_PUBLICA = "C:/CertificadoDigital/public.key";
    
    byte[] arquivoCriptografado = null;

    public AssinaturaDigital() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCriptografar = new javax.swing.JButton();
        btnDecriptografar = new javax.swing.JButton();
        btnGerarChave = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblEmail = new javax.swing.JLabel();
        txtEmailCadastro = new javax.swing.JTextField();
        btnHash = new javax.swing.JButton();
        lblEmail1 = new javax.swing.JLabel();
        txtEmailBusca = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lblCaminho = new javax.swing.JLabel();
        txtCaminhoBusca = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        lblCaminho1 = new javax.swing.JLabel();
        txtCaminhoCadastro = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        txtArquivo = new javax.swing.JTextField();
        txtHashOriginal = new javax.swing.JTextField();
        txtHashVerificado = new javax.swing.JTextField();
        lblHashOriginal = new javax.swing.JLabel();
        lblHashVerificado = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCriptografar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCriptografar.setText("Assinar Documento");
        btnCriptografar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriptografarActionPerformed(evt);
            }
        });

        btnDecriptografar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnDecriptografar.setText("Validar Documento");
        btnDecriptografar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDecriptografarActionPerformed(evt);
            }
        });

        btnGerarChave.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnGerarChave.setText("Gerar Chaves Publica e Privada");
        btnGerarChave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarChaveActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblEmail.setText("e-mail Usuario");

        txtEmailCadastro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnHash.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnHash.setText("Gerar Hash");
        btnHash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHashActionPerformed(evt);
            }
        });

        lblEmail1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblEmail1.setText("e-mail Usuario");

        txtEmailBusca.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Comparar Hash");

        lblCaminho.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblCaminho.setText("Endereço Cadastro");

        txtCaminhoBusca.setEditable(false);
        txtCaminhoBusca.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnBuscar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        lblCaminho1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblCaminho1.setText("Endereço Busca");

        txtCaminhoCadastro.setEditable(false);
        txtCaminhoCadastro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCaminhoCadastro.setText("C:\\CertificadoDigital");

        btnCadastrar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        txtArquivo.setEditable(false);
        txtArquivo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtHashOriginal.setEditable(false);
        txtHashOriginal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtHashVerificado.setEditable(false);
        txtHashVerificado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblHashOriginal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblHashOriginal.setText("Hash Original");

        lblHashVerificado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblHashVerificado.setText("Hash Verificado");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Digite o e-mail do usuário e clique em cadastrar");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Digite o e-mail do usuário e clique em buscar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnHash)
                        .addGap(50, 50, 50)
                        .addComponent(txtArquivo)
                        .addGap(148, 148, 148))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGerarChave, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCriptografar)
                            .addComponent(lblEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDecriptografar)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCaminho1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCaminhoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtEmailBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(37, 37, 37)
                                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel3)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblHashVerificado)
                                    .addComponent(lblHashOriginal))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtHashOriginal, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtHashVerificado, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(21, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCaminho, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtCaminhoCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 176, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtEmailCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(46, 46, 46))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmailCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastrar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCaminho, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCaminhoCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnGerarChave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHash, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnCriptografar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmailBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCaminhoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCaminho1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(btnDecriptografar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHashOriginal, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHashOriginal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHashVerificado, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHashVerificado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnCriptografarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriptografarActionPerformed
        String caminho = "";
        String extensao = "";
        String nome=txtEmailCadastro.getText();
        try {
            // Verifica se já existe um par de chaves, caso contrário gera-se as chaves..
            if (!verificaSeExisteChavesNoSO()) {
                // Método responsável por gerar um par de chaves usando o algoritmo RSA e
                // armazena as chaves nos seus respectivos arquivos.
                JOptionPane.showMessageDialog(null, "Clique no botão Gerar para gerar a chave");

            } else {

                ObjectInputStream inputStream = null;
                //Aqui seria a parte de cifrar o texto, algo como cifraTexto(textoCifrado);
                JFileChooser arquivo = new JFileChooser();
                int retorno = arquivo.showSaveDialog(null);

                if (retorno == JFileChooser.APPROVE_OPTION) {
                    caminho = arquivo.getSelectedFile().getAbsolutePath();
                    extensao = caminho + ".assinado";

                    // Criptografa a Mensagem usando a Chave Pública
                    inputStream = new ObjectInputStream(new FileInputStream(PATH_CHAVE_PRIVADA + nome));
                    PrivateKey chaveprivada = null;
                    chaveprivada = (PrivateKey) inputStream.readObject();

                    FileInputStream fin;
                    fin = new FileInputStream(arquivo.getSelectedFile());
                    DataInputStream dis = new DataInputStream(fin);
                    byte[] conteudoArquivo = new byte[dis.available()];
                    dis.readFully(conteudoArquivo);
                    final String msgOriginal = new String(conteudoArquivo);

                    arquivoCriptografado = criptografa(msgOriginal, chaveprivada);

                    File f = new File(extensao);
                    FileOutputStream fout = new FileOutputStream(f);
                    DataOutputStream dout = new DataOutputStream(fout);
                    dout.write(arquivoCriptografado);
                    dout.close();
                    fout.close();
                    // Imprime o texto original, o texto criptografado e 
                    // o texto descriptografado.
                    System.out.println("Mensagem Original: " + msgOriginal);
                    System.out.println("Mensagem Criptografada: " + new String(arquivoCriptografado));

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnCriptografarActionPerformed

    private void btnDecriptografarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDecriptografarActionPerformed

        String caminho = "";
        String extensao = "";
        String nome=txtEmailCadastro.getText();

        try {

            // Verifica se já existe um par de chaves, caso contrário gera-se as chaves..
            if (!verificaSeExisteChavesNoSO()) {
                // Método responsável por gerar um par de chaves usando o algoritmo RSA e
                // armazena as chaves nos seus respectivos arquivos.
                JOptionPane.showMessageDialog(null, "Clique no botão Gerar para gerar a chave");
            } else {

                ObjectInputStream inputStream = null;
                //buscar arquivo criptografado e indicar a extensão do arquivo decriptografado
                JFileChooser arquivo = new JFileChooser();
                int retorno = arquivo.showSaveDialog(null);
                if (retorno == JFileChooser.APPROVE_OPTION) {
                    caminho = arquivo.getSelectedFile().getAbsolutePath();
                    extensao = caminho + ".conferido";
                }

                final String msgOriginal = arquivoCriptografado.toString();

                // Decriptografa a Mensagem usando a Chave Pirvada
                inputStream = new ObjectInputStream(new FileInputStream(PATH_CHAVE_PUBLICA + nome));
                final PublicKey chavePublica = (PublicKey) inputStream.readObject();
                final String textoPuro = decriptografa(arquivoCriptografado, chavePublica);

                File f = new File(extensao);
                FileOutputStream fout = new FileOutputStream(f);
                DataOutputStream dout = new DataOutputStream(fout);
                dout.writeBytes(textoPuro);
                dout.close();
                fout.close();
                // Imprime o texto original, o texto criptografado e 
                // o texto descriptografado.
                System.out.println("Mensagem Original: " + msgOriginal);
                System.out.println("Mensagem Decriptografada: " + textoPuro);
                txtHashVerificado.setText(textoPuro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnDecriptografarActionPerformed

    private void btnGerarChaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarChaveActionPerformed
        this.geraChave();

    }//GEN-LAST:event_btnGerarChaveActionPerformed
    public  boolean verificaSeExisteChavesNoSO() {

        String nome=txtEmailCadastro.getText();
        File chavePrivada = new File(PATH_CHAVE_PRIVADA + nome);
        File chavePublica = new File(PATH_CHAVE_PUBLICA + nome);

        if (chavePrivada.exists() && chavePublica.exists()) {
            return true;
        }

        return false;
    }

    public void geraChave() {

        
        String nome=txtEmailCadastro.getText();
     
     
       try {
            final KeyPairGenerator keyGen = KeyPairGenerator.getInstance(ALGORITHM);
            keyGen.initialize(1024);
            final KeyPair key = keyGen.generateKeyPair();

            File chavePrivadaFile = new File(PATH_CHAVE_PRIVADA + nome);
            File chavePublicaFile = new File(PATH_CHAVE_PUBLICA + nome);
            
         
            // Cria os arquivos para armazenar a chave Privada e a chave Publica
            if (chavePrivadaFile.getParentFile() != null) {
           
                chavePrivadaFile.getParentFile().mkdirs();
              }

            chavePrivadaFile.createNewFile();

            if (chavePublicaFile.getParentFile() != null) {
                chavePublicaFile.getParentFile().mkdirs();
            }

            chavePublicaFile.createNewFile();

            // Salva a Chave Pública no arquivo
            ObjectOutputStream chavePublicaOS = new ObjectOutputStream(
            new FileOutputStream(chavePublicaFile));
            chavePublicaOS.writeObject(key.getPublic());
            chavePublicaOS.close();

            // Salva a Chave Privada no arquivo
            ObjectOutputStream chavePrivadaOS = new ObjectOutputStream(
            new FileOutputStream(chavePrivadaFile));
            chavePrivadaOS.writeObject(key.getPrivate());
            chavePrivadaOS.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        DAO dao = new DAO();

        certificado = dao.consultarICP(txtEmailBusca.getText());
        txtCaminhoBusca.setText(certificado.getEndereco());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnHashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHashActionPerformed
        String extensao = null;
        String hash = null;
        String nome=txtEmailCadastro.getText();

        if (evt.getSource() == btnHash) {
            JFileChooser arq1 = new JFileChooser();
            // seleciona qualquer tipo de arquivo
            arq1.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            int caminho1 = arq1.showOpenDialog(null);

            if (caminho1 == JFileChooser.APPROVE_OPTION) {
                File arquivo1 = arq1.getSelectedFile();
                extensao = arquivo1 + ".hash" + nome;

                txtArquivo.setText(arquivo1.getAbsolutePath());

                try {
                    //Chama a classe "HashMaker.java", passando como parâmetro o endereço do arquivo
                    hash = GeraMD5.geraHash(arquivo1);
                    txtHashOriginal.setText(hash);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(AssinaturaDigital.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(AssinaturaDigital.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Você não selecionou nenhum diretório.");
            }
            File f = new File(extensao);
            FileOutputStream fout = null;
            try {
                fout = new FileOutputStream(f);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AssinaturaDigital.class.getName()).log(Level.SEVERE, null, ex);
            }
            DataOutputStream dout = new DataOutputStream(fout);
            try {
                dout.writeBytes(hash);
            } catch (IOException ex) {
                Logger.getLogger(AssinaturaDigital.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                dout.close();
            } catch (IOException ex) {
                Logger.getLogger(AssinaturaDigital.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                fout.close();
            } catch (IOException ex) {
                Logger.getLogger(AssinaturaDigital.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btnHashActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        DAO dao = new DAO();
        Certificado certificado = construirCertificado();
        dao.cadastrarICP(certificado);
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private Certificado construirCertificado() {
        certificado.setEmail(txtEmailCadastro.getText());
        certificado.setEndereco(txtCaminhoCadastro.getText());
        return certificado;
    }

    public static byte[] criptografa(String texto, PrivateKey chave) {
        byte[] cipherText = null;

        try {
            final Cipher cipher = Cipher.getInstance(ALGORITHM);
            // Criptografa o texto puro usando a chave Púlica
            cipher.init(Cipher.ENCRYPT_MODE, chave);
            cipherText = cipher.doFinal(texto.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cipherText;
    }

    /**
     * Decriptografa o texto puro usando chave privada.
     */
    public static String decriptografa(byte[] texto, PublicKey chave) {
        byte[] dectyptedText = null;

        try {
            final Cipher cipher = Cipher.getInstance(ALGORITHM);
            // Decriptografa o texto puro usando a chave Privada
            cipher.init(Cipher.DECRYPT_MODE, chave);
            dectyptedText = cipher.doFinal(texto);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return new String(dectyptedText);
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
            java.util.logging.Logger.getLogger(AssinaturaDigital.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AssinaturaDigital.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AssinaturaDigital.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AssinaturaDigital.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AssinaturaDigital().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCriptografar;
    private javax.swing.JButton btnDecriptografar;
    private javax.swing.JButton btnGerarChave;
    private javax.swing.JButton btnHash;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblCaminho;
    private javax.swing.JLabel lblCaminho1;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEmail1;
    private javax.swing.JLabel lblHashOriginal;
    private javax.swing.JLabel lblHashVerificado;
    private javax.swing.JTextField txtArquivo;
    private javax.swing.JTextField txtCaminhoBusca;
    private javax.swing.JTextField txtCaminhoCadastro;
    private javax.swing.JTextField txtEmailBusca;
    private javax.swing.JTextField txtEmailCadastro;
    private javax.swing.JTextField txtHashOriginal;
    private javax.swing.JTextField txtHashVerificado;
    // End of variables declaration//GEN-END:variables

}
