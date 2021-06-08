/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modules;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Novi
 */
public class Sell extends javax.swing.JInternalFrame {

    /**
     * Creates new form Sell
     */
    int count;
    int unitCost;
    String sql;
    double tam=0;
    
    private void setUnitCost()
    {
        if(count>0)
        {
            String type=cmbType.getSelectedItem().toString();
            if(type.equals("NORMAL"))
            {
                String compo=(String) cmbCompo.getSelectedItem();
                try
                {         
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","");

                    String sql="select `Normal` from price where Type='"+compo+"' ";

                    PreparedStatement pst=con.prepareStatement(sql);
                    ResultSet rs=pst.executeQuery();
                    if(rs.next())
                    {
                        unitCost=rs.getInt("Normal");
                        String unitCost1 = Integer.toString(unitCost);
                        txtUnitCost.setText(unitCost1);

                    }

                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
            }
            else if(type.equals("EXCHANGE"))
            {
                String compo=(String) cmbCompo.getSelectedItem();
                try
                {         
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","");

                    String sql="select `Exchange` from price where Type='"+compo+"' ";

                    PreparedStatement pst=con.prepareStatement(sql);
                    ResultSet rs=pst.executeQuery();
                    if(rs.next())
                    {
                        unitCost=rs.getInt("Exchange");
                        String unitCost1 = Integer.toString(unitCost);
                        txtUnitCost.setText(unitCost1);

                    }

                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
            }
        }
    }
    
    private void checkAvail()
    {
        if(cmbGrp.getSelectedIndex()==0 || cmbCompo.getSelectedIndex()==0)
        {
            JOptionPane.showMessageDialog(this, "PLEASE SELECT THE BLOOD GROUP AND COMPONENT ");
        }
        else
        {
            String group=(String) cmbGrp.getSelectedItem();
        int index=cmbCompo.getSelectedIndex();
        switch (index) {
            case 1:
                sql="SELECT count(`Blood Group`) as cnt from wholeblood where `Blood Group`='"+group+"' and `Status`='Active'";
                break;
            case 2:
                sql="SELECT count(`Blood Group`) as cnt from rbc where `Blood Group`='"+group+"' and `Status`='Active'";
                break;
            case 3:
                sql="SELECT count(`Blood Group`) as cnt from plasma where `Blood Group`='"+group+"' and `Status`='Active'";
                break;
            default: JOptionPane.showMessageDialog(null, "PLEASE SELECT COMPONENT");
                break;
        }
        try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","");

                PreparedStatement pst=con.prepareStatement(sql);
            
                ResultSet rs=pst.executeQuery();
            
                while(rs.next())
                {
                    count=Integer.parseInt(rs.getString("cnt"));
                }
                if(count>=1)
                {
                        lblCount.setText(count+" UNITS AVAILABLE");
                        cmbUnits.setEnabled(true);
                        
                        for(int i=1;i<=count;i++)
                        {
                            cmbUnits.addItem(Integer.toString(i));
                        }
                }
                else
                {
                        lblCount.setText("NO UNITS AVAILABLE");
                        cmbUnits.setEnabled(false);
                        
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
        
    }
    
    
    public Sell() {
        initComponents();
        this.setBorder(null);
        BasicInternalFrameUI bui=(BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
        
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();
        txtDate.setText(df.format(date));
     
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        cmbCompo = new javax.swing.JComboBox<>();
        cmbGrp = new javax.swing.JComboBox<>();
        txtAdminName = new javax.swing.JTextField();
        btnAvail = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        btnAvail1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblCount = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtAmount = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtUnitCost = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cmbUnits = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        cmbType = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        txtService = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        txtPatient = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtDOB = new com.toedter.calendar.JDateChooser();
        cmbGender = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtPatientAddress = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtDoctorName = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtHospitalName = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtHospitalAddress = new javax.swing.JTextArea();

        jPanel3.setBackground(new java.awt.Color(255, 51, 51));
        jPanel3.setPreferredSize(new java.awt.Dimension(1446, 1500));

        jPanel2.setBackground(new java.awt.Color(153, 255, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 13), "SELL BLOOD BAG", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 24))); // NOI18N

        cmbCompo.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        cmbCompo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--SELECT COMPONENT--", "WHOLE BLOOD", "RBC", "PLASMA" }));
        cmbCompo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        cmbCompo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbCompo.setOpaque(false);
        cmbCompo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmbCompoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmbCompoFocusLost(evt);
            }
        });
        cmbCompo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCompoActionPerformed(evt);
            }
        });

        cmbGrp.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        cmbGrp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--SELECT GROUP--", "A +", "A -", "B +", "B -", "AB +", "AB -", "O +", "O -" }));
        cmbGrp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        cmbGrp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbGrp.setOpaque(false);
        cmbGrp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmbGrpFocusGained(evt);
            }
        });
        cmbGrp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbGrpActionPerformed(evt);
            }
        });

        txtAdminName.setEditable(false);
        txtAdminName.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N

        btnAvail.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        btnAvail.setText("SUBMIT");
        btnAvail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        btnAvail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvailActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("BLOOD GROUP :");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("COMPONENT :");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("ADMIN :");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setText("DATE :");

        txtDate.setEditable(false);
        txtDate.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N

        btnAvail1.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        btnAvail1.setText("CLICK HERE TO CHECK FOR AVAILABILTY");
        btnAvail1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        btnAvail1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvail1ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel1MouseExited(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCount.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCount.setForeground(new java.awt.Color(255, 0, 0));
        lblCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 430, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("COST PER UNIT :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, 150, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("SERVICE CHARGE PER UNIT :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 250, -1));

        txtAmount.setEditable(false);
        txtAmount.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        txtAmount.setText("0");
        jPanel1.add(txtAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 240, 200, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("TYPE OF REQUEST :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 170, -1));

        txtUnitCost.setEditable(false);
        txtUnitCost.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        txtUnitCost.setText("0");
        jPanel1.add(txtUnitCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 110, 130, 30));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("(Incl. Of All Charges)");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 110, 170, 30));

        cmbUnits.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        cmbUnits.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        cmbUnits.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        cmbUnits.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmbUnitsFocusLost(evt);
            }
        });
        cmbUnits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbUnitsActionPerformed(evt);
            }
        });
        jPanel1.add(cmbUnits, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 110, 30));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setText("SELECT NO. OF UNIT :");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 190, -1));

        cmbType.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        cmbType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "NORMAL", "EXCHANGE" }));
        cmbType.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        cmbType.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmbTypeFocusGained(evt);
            }
        });
        jPanel1.add(cmbType, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, 150, 30));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setText("TOTAL AMOUNT :");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 240, 160, -1));

        txtService.setEditable(false);
        txtService.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        txtService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtServiceActionPerformed(evt);
            }
        });
        jPanel1.add(txtService, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 170, 180, 30));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5), "PATIENT DETAILS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 1, 21))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPatient.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jPanel4.add(txtPatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 270, 30));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setText("DATE OF BIRTH :");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 50, 150, 30));

        txtDOB.setDateFormatString("yyyy-MM-dd");
        txtDOB.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jPanel4.add(txtDOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 50, 220, 30));

        cmbGender.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        cmbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--SELECT--", "MALE", "FEMALE", "OTHERS" }));
        cmbGender.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        cmbGender.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbGender.setOpaque(false);
        cmbGender.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmbGenderFocusGained(evt);
            }
        });
        cmbGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbGenderActionPerformed(evt);
            }
        });
        jPanel4.add(cmbGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, 130, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("GENDER :");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 90, 30));

        txtPatientAddress.setColumns(20);
        txtPatientAddress.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtPatientAddress.setRows(5);
        jScrollPane2.setViewportView(txtPatientAddress);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 150, 330, 120));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("PATIENT ADDRESS :");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 150, 180, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("PATIENT NAME :");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 150, 30));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5), "PATIENT DETAILS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 1, 21))); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setText("DOCTOR NAME :");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 150, -1));

        txtDoctorName.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jPanel5.add(txtDoctorName, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 230, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setText("HOSPITAL NAME :");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 160, -1));

        txtHospitalName.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jPanel5.add(txtHospitalName, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 40, 230, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("HOSPITAL ADDRESS :");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 190, -1));

        txtHospitalAddress.setColumns(20);
        txtHospitalAddress.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtHospitalAddress.setRows(5);
        jScrollPane3.setViewportView(txtHospitalAddress);

        jPanel5.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 330, 120));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(413, 413, 413)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(cmbGrp, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(423, 423, 423)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(cmbCompo, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(463, 463, 463)
                        .addComponent(btnAvail1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(453, 453, 453)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(txtAdminName, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(463, 463, 463)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 1149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1149, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(42, 42, 42))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(btnAvail, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(460, 460, 460))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(cmbGrp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(cmbCompo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(btnAvail1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(txtAdminName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(btnAvail, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(103, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane4.setViewportView(jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1469, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 923, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAvailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvailActionPerformed

       int x=JOptionPane.showConfirmDialog(this, "CONFIRM TO PERFORM THIS TRANSACTION", "CONFIRM", JOptionPane.YES_NO_OPTION);
       if(x==0)
       {
           submit();
       }
        

    }//GEN-LAST:event_btnAvailActionPerformed

    private void cmbGrpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbGrpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbGrpActionPerformed

    private void cmbGrpFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbGrpFocusGained

        
        lblCount.setText("");
        txtUnitCost.setText("");
        txtAmount.setText("");
        cmbUnits.setEnabled(false);

    }//GEN-LAST:event_cmbGrpFocusGained

    private void cmbCompoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCompoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCompoActionPerformed

    private void cmbCompoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbCompoFocusLost

    }//GEN-LAST:event_cmbCompoFocusLost

    private void cmbCompoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbCompoFocusGained

       
        lblCount.setText("");
        txtUnitCost.setText("");
        txtAmount.setText("");
        cmbUnits.setEnabled(false);

    }//GEN-LAST:event_cmbCompoFocusGained

    private void btnAvail1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvail1ActionPerformed
        checkAvail();
        
        
        
        
    }//GEN-LAST:event_btnAvail1ActionPerformed

    private void cmbGenderFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbGenderFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbGenderFocusGained

    private void cmbGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbGenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbGenderActionPerformed

    private void jPanel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseExited
       
    
        
    }//GEN-LAST:event_jPanel1MouseExited

    private void cmbUnitsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbUnitsFocusLost
        
        
    }//GEN-LAST:event_cmbUnitsFocusLost

    private void cmbUnitsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbUnitsActionPerformed

        setUnitCost();
        String unit=(String) cmbUnits.getSelectedItem();
        if(unit.equals("SELECT"))
        {
            txtAmount.setText("");
        }
        else
        {
            double serviceCharge=getService();
            txtService.setText(Double.toString(serviceCharge));
            double units=Double.parseDouble(unit);
            String cost=txtUnitCost.getText();
            double costs=Double.parseDouble(cost);
            double tservice=units*serviceCharge;
            tam=units*costs;
            double sum=tservice+tam;
            txtAmount.setText(Double.toString(sum));
        }
        
    }//GEN-LAST:event_cmbUnitsActionPerformed

    private void cmbTypeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbTypeFocusGained
       
        txtUnitCost.setText("");
        txtAmount.setText("");
        
    }//GEN-LAST:event_cmbTypeFocusGained

    private void txtServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtServiceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtServiceActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAvail;
    private javax.swing.JButton btnAvail1;
    private javax.swing.JComboBox<String> cmbCompo;
    private javax.swing.JComboBox<String> cmbGender;
    private javax.swing.JComboBox<String> cmbGrp;
    private javax.swing.JComboBox<String> cmbType;
    private javax.swing.JComboBox<String> cmbUnits;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblCount;
    public javax.swing.JTextField txtAdminName;
    private javax.swing.JTextField txtAmount;
    private com.toedter.calendar.JDateChooser txtDOB;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtDoctorName;
    private javax.swing.JTextArea txtHospitalAddress;
    private javax.swing.JTextField txtHospitalName;
    private javax.swing.JTextField txtPatient;
    private javax.swing.JTextArea txtPatientAddress;
    private javax.swing.JTextField txtService;
    private javax.swing.JTextField txtUnitCost;
    // End of variables declaration//GEN-END:variables

public void submit()
{
    String bloodgrp=(String) cmbGrp.getSelectedItem();
    String compo=(String) cmbCompo.getSelectedItem();
    String u= (String) cmbUnits.getSelectedItem();
    Double units=Double.parseDouble(u);
    Double perunitCost=Double.parseDouble(txtUnitCost.getText());
    Double totalAmount=Double.parseDouble(txtAmount.getText());
    
    //Patient details
    String pname=txtPatient.getText();
    Date dob=txtDOB.getDate();
    DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
    String dob1=df.format(dob);
    String gender=(String) cmbGender.getSelectedItem();
    String paddress=txtPatientAddress.getText();
    
    //Hospital details
    String dname=txtDoctorName.getText();
    String hname=txtHospitalName.getText();
    String haddress=txtHospitalAddress.getText();
    
    String adminName=txtAdminName.getText();
    String date=txtDate.getText();
 
    
    if(cmbType.getSelectedIndex()==0 ||cmbGrp.getSelectedIndex()==0 ||  cmbCompo.getSelectedIndex()==0 || cmbUnits.getSelectedIndex()==0 || perunitCost==0 || totalAmount==0 || pname.equals("") || dob1.equals("") || cmbGender.getSelectedIndex()==0 || paddress.equals("") || dname.equals("") || hname.equals("") || haddress.equals("") || adminName.equals("") || date.equals(""))    
    {
        JOptionPane.showMessageDialog(this, "ALL FIELDS ARE MANDATORY");
    }
    else
    {
        int choice=cmbCompo.getSelectedIndex();
        String sql1 = null;
        switch(choice)
        {
            case 1: sql1="UPDATE `wholeblood` set Status='SOLD' WHERE Status='ACTIVE' ORDER BY `Expiry Date` LIMIT 1;";
                    break;
            case 2: sql1="UPDATE `rbc` set Status='SOLD' WHERE Status='ACTIVE' ORDER BY `Expiry Date` LIMIT 1;";
                    break;
            case 3: sql1="UPDATE `plasma` set Status='SOLD' WHERE Status='ACTIVE' ORDER BY `Expiry Date` LIMIT 1;";
            
        }
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","");
            for(int i=1;i<=units;i++)
            {
                Statement st=con.createStatement();
                st.executeUpdate(sql1);
                st.close();   
            }
            String sql2="INSERT INTO `sales`(`Patient Name`, `Blood Group`, `Component Name`, `No. Of Units`, `Per Unit Cost`, `Total Amount`, `DOB`, `Gender`, `Patient Address`, `Doctor Name`, `Hospital Name`, `Hospital Address`, `Added By`, `Date of sale`,`Type`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement pst=con.prepareStatement(sql2);
                pst.setString(1, pname);
                pst.setString(2, bloodgrp);
                pst.setString(3, compo);
                pst.setString(4, u);
                pst.setString(5, txtUnitCost.getText());
                pst.setString(6, txtAmount.getText());
                pst.setString(7, dob1);
                pst.setString(8, gender);
                pst.setString(9, paddress);
                pst.setString(10, dname);
                pst.setString(11, hname);
                pst.setString(12, haddress);
                pst.setString(13, adminName);
                pst.setString(14, date);
                pst.setString(15, cmbType.getSelectedItem().toString());
                
                pst.executeUpdate();
                pst.close();
            JOptionPane.showMessageDialog(this, "TRANSACTION SUCCESSFUL");
            int y= JOptionPane.showConfirmDialog(this, "DO YOU LIKE TO PRINT RECEIPT", "CONFIRM", JOptionPane.YES_NO_OPTION);
            if(y==0)
            {
                Checkout c=new Checkout(null, true);
                c.lblName.setText(txtPatient.getText());
                c.lblDOB.setText(dob1);
                c.lblDoc.setText(txtDoctorName.getText());
                c.lblType.setText(cmbType.getSelectedItem().toString());
                c.lblDate.setText(txtDate.getText());
                c.lblCompo.setText(cmbCompo.getSelectedItem().toString());
                c.lblGrp.setText(cmbGrp.getSelectedItem().toString());
                c.lblUnits.setText(txtUnitCost.getText());
                c.lblperUnit.setText(txtUnitCost.getText());
                c.lblAmount.setText(Double.toString(tam));
                c.lblService.setText(txtService.getText());
                c.lblTotal1.setText(txtAmount.getText());
                c.show();
            }
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, e);
        }
     
    }
            
    
}

public double getService()
{
    double service=0;
    String comp=cmbCompo.getSelectedItem().toString();
    try
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","");

        String sql="SELECT Service from price where type='"+comp+"'";
        PreparedStatement pst=con.prepareStatement(sql);
            
        ResultSet rs=pst.executeQuery();
            
        while(rs.next())
        {
            service =Double.parseDouble(rs.getString("Service"));
        }
    }
    catch(Exception e)
    {
        JOptionPane.showMessageDialog(this, e);
    }
    
    return(service);
}
}




