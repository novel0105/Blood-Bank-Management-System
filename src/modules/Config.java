/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modules;

import com.mysql.jdbc.PreparedStatement;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author Novi
 */
public class Config extends javax.swing.JInternalFrame {

    /**
     * Creates new form Config
     */
 
    private void changePassword()
    {
        String admin1=txtAdmin1.getText();
        String pass=txtPass1.getText();        
        String newPass1=txtNewPass1.getText();
        String repass1=txtRePass.getText();
        if(pass.equals("") || newPass1.equals("") || repass1.equals("") )
        {
            JOptionPane.showMessageDialog(null, "ALL FIELDS ARE MANDATORY");
            txtAdmin1.setText("");
            txtNewPass1.setText("");            
            txtRePass.setText("");        
        }
        else
        {
            if(newPass1.equals(repass1))
            {
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","");
                    Statement st=con.createStatement();
					
                    String sql= "select * from Admins where Username= '"+admin1+"' and Password='"+pass+"'";
                    ResultSet rs=st.executeQuery(sql);
                    if(rs.next())
                    {
                        rs.close();
                        con.close();
                        try
                        {
                                Class.forName("com.mysql.jdbc.Driver");
                                Connection con1= DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","");
                                
                                String sql1="UPDATE `admins` SET `Password`='"+repass1+"' WHERE `Username`='"+admin1+"'";
                                
                                Statement st1=con1.createStatement();
                                st1.executeUpdate(sql1);
                                
                                
    
                                JOptionPane.showMessageDialog(null, "PASSWORD CHANGED SUCCESSFULLY");
                                st1.close();
                                con1.close();
                                txtNewUser.setText("");
                                txtnewPass.setText("");            
                                txtrepass.setText("");
                                txtPass.setText("");
                        }
                        catch(Exception ee)
                        {
                                System.out.println(ee);
                        }
                            
                            
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "INCORRECT CURRENT ADMIN PASSWORD");
                    }
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
                }
                
            
            else
            {
                JOptionPane.showMessageDialog(null, "New Admin Passwords Do Not Match");           
                txtPass1.setText("");
                txtNewPass1.setText("");            
                txtRePass.setText("");  
            }
        }
            
    }
    
    
    public void addAdmin()
    {
        String newAdmin=txtNewUser.getText();
        String newPass=txtnewPass.getText();
        String repass=txtrepass.getText();
        String presAdmin=txtAdmin.getText();
        String adminPass=txtPass.getText();
        
        if(newAdmin.equals("") || newPass.equals("") || repass.equals("") || presAdmin.equals("") || adminPass.equals("") )
        {
            JOptionPane.showMessageDialog(null, "ALL FIELDS ARE MANDATORY");
            txtNewUser.setText("");
            txtnewPass.setText("");            
            txtrepass.setText("");
            txtPass.setText("");
        }
        else
        {
            if(newPass.equals(repass))
            {
            try
            {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","");
		Statement st=con.createStatement();
					
		String sql= "select * from Admins where Username= '"+presAdmin+"' and Password='"+adminPass+"'";
			
		ResultSet rs=st.executeQuery(sql);
		if(rs.next())
		{
                    rs.close();
                    con.close();
                    try
                    {
                                Class.forName("com.mysql.jdbc.Driver");
                                Connection con1= DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","");
                                
                                String sql1="INSERT INTO Admins(`Username`,`Password`) VALUES ('"+newAdmin+"','"+repass+"')";
                                
                                Statement st1=con1.createStatement();
                                st1.executeUpdate(sql1);
                                
                                st1.close();
                                con1.close();
    
                                JOptionPane.showMessageDialog(null, "NEW ADMIN "+newAdmin+" ADDED SUCCESSFULLY");
                                txtNewUser.setText("");
                                txtnewPass.setText("");            
                                txtrepass.setText("");
                                txtPass.setText("");
                     }
                     catch(Exception ee)
                     {
                                System.out.println(ee);
                     }
                            
                            
			}
			else
			{
                            JOptionPane.showMessageDialog(null, "INCORRECT PRESENT ADMIN PASSWORD");
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
        }
        else
        {
            JOptionPane.showMessageDialog(null, "New Admin Passwords Do Not Match");           
            txtnewPass.setText("");
            txtrepass.setText("");            
            txtPass.setText("");  
        }
        }
        
        
    }
    
    public Config() {
        initComponents();
        this.setBorder(null);
        BasicInternalFrameUI bui=(BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
   
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
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainPanel = new javax.swing.JPanel();
        addAdmin = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNewUser = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtAdmin = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        txtnewPass = new javax.swing.JPasswordField();
        txtrepass = new javax.swing.JPasswordField();
        jButton3 = new javax.swing.JButton();
        changePassword = new javax.swing.JPanel();
        txtAdmin1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtPass1 = new javax.swing.JPasswordField();
        txtRePass = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtNewPass1 = new javax.swing.JPasswordField();
        changePrice = new javax.swing.JPanel();
        cmbCompo = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cmbType = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtPresentPrice = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtNewPrice = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        kGradientPanel1.setkBorderRadius(0);
        kGradientPanel1.setkEndColor(new java.awt.Color(204, 255, 204));
        kGradientPanel1.setkStartColor(new java.awt.Color(102, 102, 102));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("CHANGE PASSWORD");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        kGradientPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 110, 220, 41));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("ADD ADMIN");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        kGradientPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, 153, 41));

        mainPanel.setLayout(new java.awt.CardLayout());

        addAdmin.setBackground(new java.awt.Color(153, 255, 153));
        addAdmin.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 8), "ADD ADMIN", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 32), new java.awt.Color(102, 0, 102))); // NOI18N
        addAdmin.setPreferredSize(new java.awt.Dimension(1265, 665));
        addAdmin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel1.setText("CURRENT ADMIN PASSWORD:");
        addAdmin.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 410, 320, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel2.setText("NEW ADMIN USERNAME :");
        addAdmin.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 280, 40));

        txtNewUser.setFont(new java.awt.Font("Verdana", 0, 19)); // NOI18N
        txtNewUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNewUserFocusLost(evt);
            }
        });
        addAdmin.add(txtNewUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, 260, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel3.setText("RE-ENTER PASSWORD :");
        addAdmin.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, 250, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel4.setText("CURRENT ADMIN:");
        addAdmin.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 350, 190, 40));

        txtAdmin.setEditable(false);
        txtAdmin.setFont(new java.awt.Font("Verdana", 0, 19)); // NOI18N
        addAdmin.add(txtAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 350, 260, 40));
        addAdmin.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 410, 260, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel5.setText("NEW ADMIN PASSWORD :");
        addAdmin.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 280, 40));
        addAdmin.add(txtnewPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 180, 260, 40));
        addAdmin.add(txtrepass, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 240, 260, 40));

        jButton3.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jButton3.setText("SUBMIT");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        addAdmin.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 510, 170, 50));

        mainPanel.add(addAdmin, "card2");

        changePassword.setBackground(new java.awt.Color(153, 153, 255));
        changePassword.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 8), "CHANGE ADMIN PASSWORD", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 32), new java.awt.Color(102, 0, 102))); // NOI18N
        changePassword.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtAdmin1.setEditable(false);
        txtAdmin1.setFont(new java.awt.Font("Verdana", 0, 19)); // NOI18N
        txtAdmin1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAdmin1FocusLost(evt);
            }
        });
        changePassword.add(txtAdmin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 120, 260, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel6.setText("USERNAME :");
        changePassword.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 150, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel7.setText("CURRENT PASSWORD :");
        changePassword.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, 240, 40));
        changePassword.add(txtPass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, 260, 40));
        changePassword.add(txtRePass, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 330, 260, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel8.setText("RE-ENTER NEW PASSWORD :");
        changePassword.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, -1, 40));

        jButton4.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jButton4.setText("SUBMIT");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        changePassword.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 430, 170, 50));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel9.setText("NEW PASSWORD :");
        changePassword.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, 200, 40));
        changePassword.add(txtNewPass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 270, 260, 40));

        mainPanel.add(changePassword, "card3");

        changePrice.setBackground(new java.awt.Color(204, 255, 255));
        changePrice.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 8), "CHANGE PRICE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 32))); // NOI18N

        cmbCompo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        cmbCompo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--SELECT--", "Whole Blood", "RBC", "Plasma" }));
        cmbCompo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        cmbCompo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbCompoMouseClicked(evt);
            }
        });
        cmbCompo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCompoActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("TYPE :");

        cmbType.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        cmbType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--SELECT--", "NORMAL", "EXCHANGE" }));
        cmbType.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("COMPONENT :");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("PRESENT PRICE :");

        txtPresentPrice.setEditable(false);
        txtPresentPrice.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("NEW PRICE :");

        txtNewPrice.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N

        jButton6.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jButton6.setText("SUBMIT");
        jButton6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout changePriceLayout = new javax.swing.GroupLayout(changePrice);
        changePrice.setLayout(changePriceLayout);
        changePriceLayout.setHorizontalGroup(
            changePriceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(changePriceLayout.createSequentialGroup()
                .addGroup(changePriceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(changePriceLayout.createSequentialGroup()
                        .addGap(424, 424, 424)
                        .addGroup(changePriceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(changePriceLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(49, 49, 49)
                                .addComponent(txtNewPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(changePriceLayout.createSequentialGroup()
                                .addGroup(changePriceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel10))
                                .addGap(49, 49, 49)
                                .addGroup(changePriceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbType, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbCompo, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPresentPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(changePriceLayout.createSequentialGroup()
                        .addGap(560, 560, 560)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(443, Short.MAX_VALUE))
        );
        changePriceLayout.setVerticalGroup(
            changePriceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(changePriceLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(changePriceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cmbType, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(changePriceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCompo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(30, 30, 30)
                .addGroup(changePriceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(txtPresentPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(changePriceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(txtNewPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(253, Short.MAX_VALUE))
        );

        mainPanel.add(changePrice, "card4");

        jScrollPane1.setViewportView(mainPanel);

        kGradientPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 1270, 670));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton5.setText("CHANGE COMPONENT PRICE");
        jButton5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        kGradientPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 110, 280, 41));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1517, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 939, Short.MAX_VALUE)
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        mainPanel.add(changePassword);
        mainPanel.repaint();
        mainPanel.revalidate();    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        mainPanel.add(addAdmin);
        mainPanel.repaint();
        mainPanel.revalidate();  
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
       
     
    }//GEN-LAST:event_formInternalFrameActivated

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
        addAdmin();
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtNewUserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNewUserFocusLost
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","");
            Statement st=con.createStatement();
					
            String sql= "select * from Admins where Username= '"+txtNewUser.getText()+"' ";
			
            ResultSet rs=st.executeQuery(sql);
            if(rs.next())
            {
                JOptionPane.showMessageDialog(null, "This Username Already Been Taken");
                txtNewUser.setText("");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }//GEN-LAST:event_txtNewUserFocusLost

    private void txtAdmin1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAdmin1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdmin1FocusLost

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        changePassword();
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        mainPanel.add(changePrice);
        mainPanel.repaint();
        mainPanel.revalidate();  
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void cmbCompoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbCompoMouseClicked
        
 
        
        
    }//GEN-LAST:event_cmbCompoMouseClicked

    private void cmbCompoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCompoActionPerformed
        
        String type=(String) cmbType.getSelectedItem();
        String compo=(String) cmbCompo.getSelectedItem();
        if(type.equals("--SELECT--") || compo.equals("--SELECT--"))
        {
            txtPresentPrice.setText("");
        }
        else
        {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","");
            
            String sql="SELECT `"+type+"` from Price where type='"+compo+"'";
            PreparedStatement pst=(PreparedStatement) con.prepareStatement(sql);
           
            ResultSet rs=pst.executeQuery();
            if(rs.next())
            {
                String price=rs.getString(type);
                txtPresentPrice.setText(price);
            }
            rs.close();
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        }
        
    }//GEN-LAST:event_cmbCompoActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       
        String type=(String) cmbType.getSelectedItem();
        String compo=(String) cmbCompo.getSelectedItem();
        String presentPrice=txtPresentPrice.getText();
        String newPrice=txtNewPrice.getText();
        if(type.equals("--SELECT--") || compo.equals("--SELECT--") || newPrice.equals(""))
        {
            JOptionPane.showMessageDialog(this, "ALL FIELDS ARE MANDATORY", "WARNING", JOptionPane.WARNING_MESSAGE);
            txtPresentPrice.setText("");
            txtNewPrice.setText("");
        }
        else
        {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","");
                
                String sql="UPDATE Price SET "+type+"='"+newPrice+"' WHERE Type='"+compo+"'";
                
                Statement st=con.createStatement();
                
                
                int i= JOptionPane.showConfirmDialog(this, "CONFIRM IS OPERATION", "CONFIRMATION", JOptionPane.YES_NO_OPTION);
                if(i==0)       
                {
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(this, "PRICE CHANGED SUCCESSFULLY");
                    st.close();
                }
               
                con.close();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(this, e,"ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }//GEN-LAST:event_jButton6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel addAdmin;
    private javax.swing.JPanel changePassword;
    private javax.swing.JPanel changePrice;
    private javax.swing.JComboBox<String> cmbCompo;
    private javax.swing.JComboBox<String> cmbType;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JPanel mainPanel;
    public javax.swing.JTextField txtAdmin;
    public javax.swing.JTextField txtAdmin1;
    private javax.swing.JPasswordField txtNewPass1;
    private javax.swing.JTextField txtNewPrice;
    private javax.swing.JTextField txtNewUser;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JPasswordField txtPass1;
    private javax.swing.JTextField txtPresentPrice;
    private javax.swing.JPasswordField txtRePass;
    private javax.swing.JPasswordField txtnewPass;
    private javax.swing.JPasswordField txtrepass;
    // End of variables declaration//GEN-END:variables
}
