/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modules;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.DriverManager;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Novi
 */
public class Records extends javax.swing.JInternalFrame {

    /**
     * Creates new form Records
     */
    public void showPanel(String type,JPanel panel,JTable table )
    {

        try
        {
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","");
            
            String sql="SELECT * FROM "+type+"";
            PreparedStatement pst=con.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            rs.close();
            pst.close();
            con.close();
            
            mainPanel.removeAll();
            mainPanel.repaint();
            mainPanel.revalidate();
            mainPanel.add(panel);
            mainPanel.repaint();
            mainPanel.revalidate();  
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
     public void exportToExcels(JTable table) throws IOException 
     {
        TableModel model = table.getModel();
        JFileChooser excelExportChooser = new JFileChooser();
        excelExportChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        excelExportChooser.setDialogTitle("Save Excel File");
        //filter the file
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel Files", "*.xls", "xls", "xlsx", "xlsn");
        excelExportChooser.addChoosableFileFilter(filter);
        excelExportChooser.setFileFilter(filter);
        int excelchooser = excelExportChooser.showSaveDialog(null);

        if (excelchooser == JFileChooser.APPROVE_OPTION) {
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("SalesReturnsDetails");

            Row row;
            Cell cell;

            try {
                // write the column headers
                row = sheet.createRow(0);
                for (int j = 0; j < model.getColumnCount(); j++) {
                    cell = row.createCell(j);
                    cell.setCellValue(model.getColumnName(j));
                }

                for (int i = 0; i < model.getRowCount(); i++) {

                    row = sheet.createRow(i + 1);

                    for (int j = 0; j < model.getColumnCount(); j++) {
                        cell = row.createCell(j);
                        cell.setCellValue(model.getValueAt(i, j).toString());

                    }

                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

            FileOutputStream excelFIS;

            try {
                excelFIS = new FileOutputStream(excelExportChooser.getSelectedFile() + ".xlsx");
                workbook.write(excelFIS);

                workbook.close();
            } catch (FileNotFoundException ex) {
        //        Logger.getLogger(NewWorker.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
           //     Logger.getLogger(NewWorker.class.getName()).log(Level.SEVERE, null, ex);
            }

        } 

    }


    
    public void theader()
    {
        JTableHeader thead=salestable.getTableHeader();
        thead.setForeground(Color.red);
        thead.setBackground(Color.ORANGE);
        thead.setFont(new Font("Tahome",Font.BOLD,18));
        
        JTableHeader thead1=WBtable.getTableHeader();
        thead1.setForeground(Color.red);
        thead1.setBackground(Color.YELLOW);
        thead1.setFont(new Font("Tahome",Font.BOLD,18));
        
        JTableHeader thead2=rbctable.getTableHeader();
        thead2.setForeground(Color.red);
        thead2.setBackground(Color.YELLOW);
        thead2.setFont(new Font("Tahome",Font.BOLD,18));
        
        JTableHeader thead3=plasmaTable.getTableHeader();
        thead3.setForeground(Color.red);
        thead3.setBackground(Color.YELLOW);
        thead3.setFont(new Font("Tahome",Font.BOLD,18));
        
      
    }
    
    
    public Records() {
        initComponents();
        this.setBorder(null);
        BasicInternalFrameUI bui=(BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
        
        salestable.setDefaultEditor(Object.class, null);
        WBtable.setDefaultEditor(Object.class, null);
        rbctable.setDefaultEditor(Object.class, null);
        theader();
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
        btnAvail4 = new javax.swing.JButton();
        btnAvail5 = new javax.swing.JButton();
        btnAvail6 = new javax.swing.JButton();
        btnAvail7 = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();
        emptyPanel = new javax.swing.JPanel();
        salesPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        salestable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        wholeblood = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        WBtable = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        RBCPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        rbctable = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        plasmaPanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        plasmaTable = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAvail4.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btnAvail4.setText("SALES");
        btnAvail4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        btnAvail4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvail4ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAvail4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 173, 44));

        btnAvail5.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btnAvail5.setText("WHOLEBLOOD");
        btnAvail5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        btnAvail5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvail5ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAvail5, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 60, 173, 44));

        btnAvail6.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btnAvail6.setText("RBC");
        btnAvail6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        btnAvail6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvail6ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAvail6, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 60, 173, 44));

        btnAvail7.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btnAvail7.setText("PLASMA");
        btnAvail7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        btnAvail7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvail7ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAvail7, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 60, 173, 44));

        mainPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        mainPanel.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout emptyPanelLayout = new javax.swing.GroupLayout(emptyPanel);
        emptyPanel.setLayout(emptyPanelLayout);
        emptyPanelLayout.setHorizontalGroup(
            emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1446, Short.MAX_VALUE)
        );
        emptyPanelLayout.setVerticalGroup(
            emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 736, Short.MAX_VALUE)
        );

        mainPanel.add(emptyPanel, "card3");

        salesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 10), "SALES REPORT", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 26))); // NOI18N

        salestable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        salestable.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        salestable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        salestable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        salestable.setRowHeight(40);
        salestable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(salestable);

        jButton1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButton1.setText("EXPORT TO EXCEL FILE");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButton2.setText("PRINT RECEIPT ");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout salesPanelLayout = new javax.swing.GroupLayout(salesPanel);
        salesPanel.setLayout(salesPanelLayout);
        salesPanelLayout.setHorizontalGroup(
            salesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salesPanelLayout.createSequentialGroup()
                .addGroup(salesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(salesPanelLayout.createSequentialGroup()
                        .addGap(459, 459, 459)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(salesPanelLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1325, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        salesPanelLayout.setVerticalGroup(
            salesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salesPanelLayout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(salesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        mainPanel.add(salesPanel, "card2");

        wholeblood.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 10), "WHOLEBLOOD STOCK", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 26))); // NOI18N

        WBtable.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        WBtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        WBtable.setRowHeight(40);
        jScrollPane2.setViewportView(WBtable);

        jButton4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButton4.setText("EXPORT TO EXCEL FILE");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout wholebloodLayout = new javax.swing.GroupLayout(wholeblood);
        wholeblood.setLayout(wholebloodLayout);
        wholebloodLayout.setHorizontalGroup(
            wholebloodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, wholebloodLayout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
            .addGroup(wholebloodLayout.createSequentialGroup()
                .addGap(569, 569, 569)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        wholebloodLayout.setVerticalGroup(
            wholebloodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wholebloodLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        mainPanel.add(wholeblood, "card4");

        RBCPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 10), "RBC STOCK", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 26))); // NOI18N

        rbctable.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        rbctable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        rbctable.setRowHeight(40);
        jScrollPane3.setViewportView(rbctable);

        jButton7.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButton7.setText("EXPORT TO EXCEL FILE");
        jButton7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RBCPanelLayout = new javax.swing.GroupLayout(RBCPanel);
        RBCPanel.setLayout(RBCPanelLayout);
        RBCPanelLayout.setHorizontalGroup(
            RBCPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RBCPanelLayout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
            .addGroup(RBCPanelLayout.createSequentialGroup()
                .addGap(553, 553, 553)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        RBCPanelLayout.setVerticalGroup(
            RBCPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RBCPanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        mainPanel.add(RBCPanel, "card5");

        plasmaPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 10), "PLASMA STOCK", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 26))); // NOI18N

        plasmaTable.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        plasmaTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        plasmaTable.setRowHeight(40);
        jScrollPane4.setViewportView(plasmaTable);

        jButton5.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButton5.setText("EXPORT TO EXCEL FILE");
        jButton5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout plasmaPanelLayout = new javax.swing.GroupLayout(plasmaPanel);
        plasmaPanel.setLayout(plasmaPanelLayout);
        plasmaPanelLayout.setHorizontalGroup(
            plasmaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plasmaPanelLayout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(plasmaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plasmaPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1321, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plasmaPanelLayout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(577, 577, 577))))
        );
        plasmaPanelLayout.setVerticalGroup(
            plasmaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plasmaPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        mainPanel.add(plasmaPanel, "card6");

        jPanel1.add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 1450, 740));

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

    private void btnAvail4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvail4ActionPerformed
       
        showPanel("sales", salesPanel, salestable);
        
      
        
    }//GEN-LAST:event_btnAvail4ActionPerformed

    private void btnAvail5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvail5ActionPerformed
       
        showPanel("Wholeblood", wholeblood, WBtable);
    }//GEN-LAST:event_btnAvail5ActionPerformed

    private void btnAvail6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvail6ActionPerformed
        
        showPanel("rbc", RBCPanel, rbctable);
        
    }//GEN-LAST:event_btnAvail6ActionPerformed

    private void btnAvail7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvail7ActionPerformed
      
        showPanel("plasma", plasmaPanel, plasmaTable);
    }//GEN-LAST:event_btnAvail7ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         try {
             // TODO add your handling code here:
             exportToExcels(salestable);
         } catch (IOException ex) {
             java.util.logging.Logger.getLogger(Records.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        
        try {
            exportToExcels(rbctable);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Records.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       
        try {
            exportToExcels(plasmaTable);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Records.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        try {
            exportToExcels(WBtable);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Records.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel RBCPanel;
    private javax.swing.JTable WBtable;
    private javax.swing.JButton btnAvail4;
    private javax.swing.JButton btnAvail5;
    private javax.swing.JButton btnAvail6;
    private javax.swing.JButton btnAvail7;
    private javax.swing.JPanel emptyPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel plasmaPanel;
    private javax.swing.JTable plasmaTable;
    private javax.swing.JTable rbctable;
    private javax.swing.JPanel salesPanel;
    private javax.swing.JTable salestable;
    private javax.swing.JPanel wholeblood;
    // End of variables declaration//GEN-END:variables
}
