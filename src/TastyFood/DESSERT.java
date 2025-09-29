/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TastyFood;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.Timer;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author H PC
 */
public class DESSERT extends javax.swing.JFrame {

    /**
     * Creates new form DESSERT
     */
    public DESSERT() {
        initComponents();
    ScaleImage4();
        dt();
        times();
        DesRegNo();
        TableLoad();
        ScaleImage3();
    }
    
    public void TableLoad() {
        
        try {
            
            TableModel tm = jTable1.getModel();
            DefaultTableModel dtm = (DefaultTableModel) tm;
            dtm.setRowCount(0);
            
            ResultSet rs = DBMS.search("SELECT * FROM dessert");
            
            while (rs.next()) {
                
                String des_reg = rs.getString("des_reg");
                String name = rs.getString("name");
                String type = rs.getString("type");
                String unit_price = rs.getString("unit_price");
                String count = rs.getString("count");
                String description = rs.getString("description");
                String reg_date = rs.getString("reg_date");
                
                Vector ve = new Vector();
                ve.add(des_reg);
                ve.add(name);
                ve.add(type);
                ve.add(unit_price);
                ve.add(count);
                ve.add(description);
                ve.add(reg_date);
                dtm.addRow(ve);
                
            }
            
        } catch (Exception e) {
            System.out.println(e);
            
        }
        
    }
    
    public void DesRegNo() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/tasty_burger?useSSL=false", "root", "1234");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(des_reg) from dessert");
            rs.next();
            
            rs.getString("MAX(des_reg)");
            
            if (rs.getString("MAX(des_reg)") == null) {
                jTextField9.setText("D000001");
                
            } else {
                long id = Long.parseLong(rs.getString("MAX(des_reg)").substring(2, rs.getString("MAX(des_reg)").length()));
                id++;
                jTextField9.setText("D" + String.format("%06d", id));
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    public void dt() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd EEEE");
        
        String dd = sdf.format(d);
        jLabel26.setText(dd);
        
    }
    Timer t;
    SimpleDateFormat st;
    
    public void times() {
        
        t = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                Date dt = new Date();
                st = new SimpleDateFormat("hh:mm:ss a");
                
                String tt = st.format(dt);
                jLabel25.setText(tt);
                
            }
        });
        t.start();
    }
    
    public void Search(String str) {
        TableModel tm = jTable1.getModel();
        DefaultTableModel dtm = (DefaultTableModel) tm;
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(dtm);
        jTable1.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str));
        
    }
    
    public void ScaleImage3() {
        ImageIcon icon = new ImageIcon("src//Images//B6.png");
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        jLabel2.setIcon(scaledIcon);
        
    }

    public void ScaleImage4() {
        ImageIcon icon = new ImageIcon("src//Images//B1.png");
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(jLabel14.getWidth(), jLabel14.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        jLabel14.setIcon(scaledIcon);
        
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
        jPanel2 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jTextField7 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204), 5));
        jPanel1.setPreferredSize(new java.awt.Dimension(1800, 1000));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setPreferredSize(new java.awt.Dimension(1800, 150));

        jLabel17.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 80)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 0));
        jLabel17.setText(" Tasty Burger");
        jLabel17.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 3, true));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 962, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, -1, -1));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204), 3), "Manage Desserts", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic UI Semilight", 1, 36), new java.awt.Color(0, 204, 204))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setBackground(new java.awt.Color(0, 204, 204));
        jButton3.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        jButton3.setText("Clear All");
        jButton3.setContentAreaFilled(false);
        jButton3.setOpaque(true);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 610, 400, 40));

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        jLabel12.setText("Register No");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 140, 40));

        jTextField9.setEditable(false);
        jTextField9.setBackground(new java.awt.Color(230, 250, 245));
        jTextField9.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        jTextField9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });
        jTextField9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField9KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField9KeyTyped(evt);
            }
        });
        jPanel3.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 350, 40));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        jLabel6.setText("Name");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 130, 40));

        jTextField1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        jTextField1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        jPanel3.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 350, 40));

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        jLabel10.setText("Type");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 160, 40));

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        jLabel11.setText("Unit Price");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 160, 40));

        jTextField5.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        jTextField5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField5KeyTyped(evt);
            }
        });
        jPanel3.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 350, 40));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        jLabel4.setText("Description");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 160, 40));

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextArea1KeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 350, 150));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        jLabel5.setText("Image");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 100, 130, 40));

        jDateChooser2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jDateChooser2.setDateFormatString("yyyy - MM - dd");
        jDateChooser2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jPanel3.add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 490, 350, 40));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Register Number", "Name", "Type", "Unit Price", "Count", "Description", "Register Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(28);
        jTable1.setSelectionBackground(new java.awt.Color(0, 153, 153));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 340, 760, 290));

        jButton4.setBackground(new java.awt.Color(0, 204, 204));
        jButton4.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        jButton4.setText("Back");
        jButton4.setContentAreaFilled(false);
        jButton4.setOpaque(true);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 650, 300, 40));

        jButton5.setBackground(new java.awt.Color(0, 204, 204));
        jButton5.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        jButton5.setText("Save");
        jButton5.setContentAreaFilled(false);
        jButton5.setOpaque(true);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, 400, 40));

        jButton6.setBackground(new java.awt.Color(0, 204, 204));
        jButton6.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        jButton6.setText("Update");
        jButton6.setContentAreaFilled(false);
        jButton6.setOpaque(true);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 560, 400, 40));

        jButton7.setBackground(new java.awt.Color(0, 204, 204));
        jButton7.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        jButton7.setText("Delete");
        jButton7.setContentAreaFilled(false);
        jButton7.setOpaque(true);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 610, 400, 40));

        jTextField7.setBackground(new java.awt.Color(238, 252, 249));
        jTextField7.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jTextField7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
        jTextField7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField7MouseClicked(evt);
            }
        });
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField7KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField7KeyTyped(evt);
            }
        });
        jPanel3.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 240, 350, 40));

        jButton8.setBackground(new java.awt.Color(0, 204, 204));
        jButton8.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        jButton8.setText("Search");
        jButton8.setContentAreaFilled(false);
        jButton8.setOpaque(true);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 280, 300, 40));

        jLabel1.setText(" ");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 140, 270, 310));

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        jLabel7.setText("Register Date");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 160, 40));

        jButton9.setBackground(new java.awt.Color(0, 204, 204));
        jButton9.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        jButton9.setText("Add Image");
        jButton9.setContentAreaFilled(false);
        jButton9.setOpaque(true);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 460, 270, 40));

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        jLabel13.setText("Count");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 160, 40));

        jTextField6.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        jTextField6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField6KeyTyped(evt);
            }
        });
        jPanel3.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 350, 40));

        jComboBox1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "~Select~", "Cakes", "Confection", "Custards", "Deep-fried", "Frozen", "Gelatin", "Pastries" }));
        jComboBox1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 350, 40));

        jLabel2.setText(" ");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 50, 460, 280));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 199, 1690, 720));

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 204, 204));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setOpaque(true);
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(1490, 920, 300, 30));

        jLabel26.setBackground(new java.awt.Color(255, 255, 255));
        jLabel26.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 204, 204));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel26.setOpaque(true);
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(1490, 960, 300, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        jTextField9.setText("");
        jTextField1.setText("");
        jComboBox1.setSelectedItem(null);
        jTextField5.setText("");
        jTextField6.setText("");
        jTextArea1.setText("");
        jDateChooser2.setDate(null);
        jLabel1.setIcon(null);
        TableLoad();
        DesRegNo();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jTextField9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9KeyReleased

    private void jTextField9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9KeyTyped

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        // TODO add your handling code here:

        Color c = new Color(0, 0, 0);
        LineBorder l = new LineBorder(c);
        jTextField1.setBorder(l);
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyTyped
        // TODO add your handling code here:
        Color c = new Color(0, 0, 0);
        LineBorder l = new LineBorder(c);
        jTextField5.setBorder(l);
    }//GEN-LAST:event_jTextField5KeyTyped

    private void jTextArea1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyTyped
        // TODO add your handling code here:
        Color c = new Color(0, 0, 0);
        LineBorder l = new LineBorder(c);
        jTextArea1.setBorder(l);
    }//GEN-LAST:event_jTextArea1KeyTyped

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        try {

            TableModel tm = jTable1.getModel();
            DefaultTableModel dtm = (DefaultTableModel) tm;

            String des_reg = dtm.getValueAt(jTable1.getSelectedRow(), 0).toString();
            String name = dtm.getValueAt(jTable1.getSelectedRow(), 1).toString();
            String type = dtm.getValueAt(jTable1.getSelectedRow(), 2).toString();
            String unit_price = dtm.getValueAt(jTable1.getSelectedRow(), 3).toString();
            String count = dtm.getValueAt(jTable1.getSelectedRow(), 4).toString();
            String description = dtm.getValueAt(jTable1.getSelectedRow(), 5).toString();
            Date reg_date = new SimpleDateFormat("yyyy-MM-dd").parse((String) dtm.getValueAt(jTable1.getSelectedRow(), 6));

            jTextField9.setText(des_reg);
            jTextField1.setText(name);
            jComboBox1.setSelectedItem(type);
            jTextField5.setText(unit_price);
            jTextField6.setText(count);
            jTextArea1.setText(description);

            jDateChooser2.setDate(reg_date);

        } catch (ParseException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new MAIN_MENU().setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        if (jTextField1.getText().isEmpty()) {
            Color c = new Color(255, 0, 0);
            LineBorder l = new LineBorder(c);
            jTextField1.setBorder(l);
            JOptionPane.showMessageDialog(this, "Please Enter Name!", "Error", JOptionPane.ERROR_MESSAGE);
            jTextField1.grabFocus();
        } else if (jTextField5.getText().isEmpty()) {
            Color c = new Color(255, 0, 0);
            LineBorder l = new LineBorder(c);
            jTextField5.setBorder(l);
            JOptionPane.showMessageDialog(this, "Please Enter Unit Price!", "Error", JOptionPane.ERROR_MESSAGE);
            jTextField5.grabFocus();
        } else if (jTextField6.getText().isEmpty()) {
            Color c = new Color(255, 0, 0);
            LineBorder l = new LineBorder(c);
            jTextField6.setBorder(l);
            JOptionPane.showMessageDialog(this, "Please Enter Count!", "Error", JOptionPane.ERROR_MESSAGE);
            jTextField6.grabFocus();
        } else if (jTextArea1.getText().isEmpty()) {
            Color c = new Color(255, 0, 0);
            LineBorder l = new LineBorder(c);
            jTextArea1.setBorder(l);
            JOptionPane.showMessageDialog(this, "Please Enter Description!", "Error", JOptionPane.ERROR_MESSAGE);
            jTextArea1.grabFocus();
        } else if (jDateChooser2.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Please Enter Register Date!", "Error", JOptionPane.ERROR_MESSAGE);
            jDateChooser2.grabFocus();

        } else {

            String des_reg = jTextField9.getText();
            String name = jTextField1.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String type = (String) jComboBox1.getSelectedItem();
            String unit_price = jTextField5.getText();
            String count = jTextField6.getText();
            String description = jTextArea1.getText();
            String reg_date = sdf.format(jDateChooser2.getDate());
            Icon image = jLabel1.getIcon();
            try {
                DBMS.iud("INSERT INTO dessert (`des_reg`,`name`,`type`,`unit_price`,`count`,`description`,`reg_date`,`image`)VALUES ('" + des_reg + "','" + name + "','" + type + "','" + unit_price + "','" + count + "','" + description + "','" + reg_date + "','" + image + "')");
                JOptionPane.showMessageDialog(this, "Dessert Added Successfully !!!", "Success", JOptionPane.INFORMATION_MESSAGE);

                jTextField9.setText("");
                jTextField1.setText("");
                jComboBox1.setSelectedItem(null);
                jTextField5.setText("");
                jTextField6.setText("");
                jTextArea1.setText("");
                jDateChooser2.setDate(null);
                jLabel1.setIcon(null);
                TableLoad();
                DesRegNo();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Dessert Added not Success!!!", "Error", JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        TableModel tm = jTable1.getModel();
        DefaultTableModel dtm = (DefaultTableModel) tm;

        if (jTable1.getSelectedRowCount() == 1) {

            String des_reg = jTextField9.getText();
            String name = jTextField1.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String type = (String) jComboBox1.getSelectedItem();
            String unit_price = jTextField5.getText();
            String count = jTextField6.getText();
            String description = jTextArea1.getText();
            String reg_date = sdf.format(jDateChooser2.getDate());

            dtm.setValueAt(des_reg, jTable1.getSelectedRow(), 0);
            dtm.setValueAt(name, jTable1.getSelectedRow(), 1);
            dtm.setValueAt(type, jTable1.getSelectedRow(), 2);
            dtm.setValueAt(unit_price, jTable1.getSelectedRow(), 3);
            dtm.setValueAt(count, jTable1.getSelectedRow(), 4);
            dtm.setValueAt(description, jTable1.getSelectedRow(), 5);
            dtm.setValueAt(reg_date, jTable1.getSelectedRow(), 6);

            try {

                DBMS.iud("UPDATE dessert SET `name`='" + name + "',`type`='" + type + "',`unit_price`='" + unit_price + "',`count`='" + count + "',`description`='" + description + "',`reg_date`='" + reg_date + "' WHERE `des_reg`='" + des_reg + "' ");
                JOptionPane.showMessageDialog(this, "Dessert Updated Successfully !!!", "Success", JOptionPane.INFORMATION_MESSAGE);

                jTextField9.setText("");
                jTextField1.setText("");
                jComboBox1.setSelectedItem(null);
                jTextField5.setText("");
                jTextField6.setText("");
                jTextArea1.setText("");
                jDateChooser2.setDate(null);
                jLabel1.setIcon(null);
                TableLoad();
                DesRegNo();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Dessert Updated not Success!!!", "Error", JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println(e);
            }

        } else {
            if (jTable1.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Table is Empty!!!", "Error", JOptionPane.ERROR_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(this, "Please Select Single Row for Update!!!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        TableModel tm = jTable1.getModel();
        DefaultTableModel dtm = (DefaultTableModel) tm;

        if (jTable1.getSelectedRowCount() == 1) {

            String des_reg = jTextField9.getText();

            dtm.setValueAt(des_reg, jTable1.getSelectedRow(), 0);

            try {

                DBMS.iud("DELETE FROM dessert WHERE `des_reg`='" + des_reg + "' ");
                JOptionPane.showMessageDialog(this, "Dessert Deleted Successfully !!!", "Success", JOptionPane.INFORMATION_MESSAGE);

                jTextField9.setText("");
                jTextField1.setText("");
                jComboBox1.setSelectedItem(null);
                jTextField5.setText("");
                jTextField6.setText("");
                jTextArea1.setText("");
                jDateChooser2.setDate(null);
                jLabel1.setIcon(null);

                DesRegNo();

                TableLoad();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Dessert Delete not Success!!!", "Error", JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println(e);
            }

        } else {
            if (jTable1.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Table is Empty!!!", "Error", JOptionPane.ERROR_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(this, "Please Select Single Row for Delete!!!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTextField7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField7MouseClicked
        // TODO add your handling code here:
        jTextField9.setText("");
        jTextField1.setText("");
        jComboBox1.setSelectedItem(null);
        jTextField5.setText("");
        jTextField6.setText("");
        jTextArea1.setText("");
        jDateChooser2.setDate(null);
        jLabel1.setIcon(null);

        jTextField7.setText("");
        TableLoad();
    }//GEN-LAST:event_jTextField7MouseClicked

    private void jTextField7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyReleased
        // TODO add your handling code here:
        String searchString = jTextField7.getText();
        Search(searchString);

        jTextField9.setText("");
        jTextField1.setText("");
        jComboBox1.setSelectedItem(null);
        jTextField5.setText("");
        jTextField6.setText("");
        jTextArea1.setText("");
        jDateChooser2.setDate(null);
        jLabel1.setIcon(null);
    }//GEN-LAST:event_jTextField7KeyReleased

    private void jTextField7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyTyped
        // TODO add your handling code here:

        jTextField9.setText("");
        jTextField1.setText("");
        jComboBox1.setSelectedItem(null);
        jTextField5.setText("");
        jTextField6.setText("");
        jTextArea1.setText("");
        jDateChooser2.setDate(null);
        jLabel1.setIcon(null);

        Color c = new Color(0, 0, 0);
        LineBorder l = new LineBorder(c);
        jTextField7.setBorder(l);
    }//GEN-LAST:event_jTextField7KeyTyped

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        if (jTextField7.getText().isEmpty()) {
            Color c = new Color(255, 0, 0);
            LineBorder l = new LineBorder(c);
            jTextField7.setBorder(l);

            JOptionPane.showMessageDialog(this, "Please Enter Dessert Register Number!", "Error", JOptionPane.ERROR_MESSAGE);
            jTextField7.grabFocus();

        } else {
            String des_reg = jTextField7.getText();
            String sql = "SELECT * FROM dessert WHERE des_reg = '" + des_reg + "' ";
            try {
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/tasty_burger?useSSL=false", "root", "1234");
                PreparedStatement pst = conn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    jTextField9.setText(rs.getString(2));
                    jTextField1.setText(rs.getString(3));
                    jComboBox1.setSelectedItem(rs.getString(4));
                    jTextField5.setText(rs.getString(5));
                    jTextField6.setText(rs.getString(6));
                    jTextArea1.setText(rs.getString(7));
                    jDateChooser2.setDate(rs.getDate(8));

                    rs.close();
                    pst.close();

                } else {
                    JOptionPane.showMessageDialog(this, "Incorrect Dessert Register Number!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String filename = f.getAbsolutePath();
        Image getAbsolutePath = null;
        ImageIcon icon = new ImageIcon(filename);
        Image image = icon.getImage().getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon icon2 = new ImageIcon(image);
        jLabel1.setIcon(icon2);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jTextField6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6KeyTyped

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DESSERT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DESSERT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DESSERT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DESSERT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DESSERT().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
