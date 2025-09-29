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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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
public class CUSTOMERS extends javax.swing.JFrame {

    /**
     * Creates new form EMPLOYEE
     */
    public CUSTOMERS() {
        initComponents();
        dt();
        times();
        CusRegNo();
        TableLoad();
        ScaleImage4();
        ScaleImage3();
    }

    public void ScaleImage4() {
        ImageIcon icon = new ImageIcon("src//Images//B1.png");
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(jLabel14.getWidth(), jLabel14.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        jLabel14.setIcon(scaledIcon);

    }
      public void ScaleImage3() {
        ImageIcon icon = new ImageIcon("src//Images//C.png");
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        jLabel1.setIcon(scaledIcon);

    }

    public void TableLoad() {

        try {

            TableModel tm = jTable1.getModel();
            DefaultTableModel dtm = (DefaultTableModel) tm;
            dtm.setRowCount(0);

            ResultSet rs = DBMS.search("SELECT * FROM customer");

            while (rs.next()) {

                String cus_reg = rs.getString("cus_reg");
                String name = rs.getString("name");
                String nic_no = rs.getString("nic_no");
                String contact_no = rs.getString("contact_no");
                String address = rs.getString("address");
                String gender = rs.getString("gender");
                String reg_date = rs.getString("reg_date");

                Vector ve = new Vector();
                ve.add(cus_reg);
                ve.add(name);
                ve.add(nic_no);
                ve.add(contact_no);
                ve.add(address);
                ve.add(gender);
                ve.add(reg_date);
                dtm.addRow(ve);

            }

        } catch (Exception e) {
            System.out.println(e);

        }

    }

    public void CusRegNo() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/tasty_burger?useSSL=false", "root", "1234");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(cus_reg) from customer");
            rs.next();

            rs.getString("MAX(cus_reg)");

            if (rs.getString("MAX(cus_reg)") == null) {
                jTextField9.setText("C000001");

            } else {
                long id = Long.parseLong(rs.getString("MAX(cus_reg)").substring(2, rs.getString("MAX(cus_reg)").length()));
                id++;
                jTextField9.setText("C" + String.format("%06d", id));
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
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
        jTextField4 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
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

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204), 3), "Manage Customers", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic UI Semilight", 1, 36), new java.awt.Color(0, 204, 204))); // NOI18N
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
        jLabel10.setText("NIC No");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 160, 40));

        jTextField4.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        jTextField4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField4KeyTyped(evt);
            }
        });
        jPanel3.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 350, 40));

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        jLabel11.setText("Contact No");
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
        jLabel4.setText("Address");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 160, 40));

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

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 347, 110));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        jLabel2.setText("Gender");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 160, 40));

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        jRadioButton1.setText("Male");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jRadioButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jRadioButton1KeyTyped(evt);
            }
        });
        jPanel3.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, 100, 40));

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        jRadioButton2.setText("Female");
        jRadioButton2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jRadioButton2KeyTyped(evt);
            }
        });
        jPanel3.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 390, -1, 40));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        jLabel5.setText("Register Date");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 160, 40));

        jDateChooser2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jDateChooser2.setDateFormatString("yyyy - MM - dd");
        jDateChooser2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jPanel3.add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 440, 350, 40));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Register Number", "Name", "NIC No", "Contact No", "Address", "Gender", "Register Date"
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

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 140, 760, 490));

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
        jPanel3.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 650, 300, 40));

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
        jPanel3.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 50, 610, 40));

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
        jPanel3.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 90, 300, 40));

        jLabel1.setText(" ");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, 340, 450));

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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        jTextField9.setText("");
        jTextField1.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextArea1.setText("");
        jDateChooser2.setDate(null);
        buttonGroup1.clearSelection();
        TableLoad();
        CusRegNo();


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

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyTyped
        // TODO add your handling code here:
        Color c = new Color(0, 0, 0);
        LineBorder l = new LineBorder(c);
        jTextField4.setBorder(l);
        if (jTextField4.getText().length() == 12) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField4KeyTyped

    private void jTextField5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyTyped
        // TODO add your handling code here:
        Color c = new Color(0, 0, 0);
        LineBorder l = new LineBorder(c);
        jTextField5.setBorder(l);

        char x = evt.getKeyChar();
        boolean b = Character.isDigit(x);

        if (!b) {
            evt.consume();
        }
        if (jTextField5.getText().length() == 10) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField5KeyTyped

    private void jTextArea1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyTyped
        // TODO add your handling code here:
        Color c = new Color(0, 0, 0);
        LineBorder l = new LineBorder(c);
        jTextArea1.setBorder(l);
    }//GEN-LAST:event_jTextArea1KeyTyped

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jRadioButton1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1KeyTyped

    private void jRadioButton2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jRadioButton2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2KeyTyped

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
        } else if (jTextField4.getText().isEmpty()) {
            Color c = new Color(255, 0, 0);
            LineBorder l = new LineBorder(c);
            jTextField4.setBorder(l);
            JOptionPane.showMessageDialog(this, "Please Enter NIC Number!", "Error", JOptionPane.ERROR_MESSAGE);
            jTextField4.grabFocus();
        } else if (jTextField5.getText().isEmpty()) {
            Color c = new Color(255, 0, 0);
            LineBorder l = new LineBorder(c);
            jTextField5.setBorder(l);
            JOptionPane.showMessageDialog(this, "Please Enter Contact Number!", "Error", JOptionPane.ERROR_MESSAGE);
            jTextField5.grabFocus();
        } else if (jTextArea1.getText().isEmpty()) {
            Color c = new Color(255, 0, 0);
            LineBorder l = new LineBorder(c);
            jTextArea1.setBorder(l);
            JOptionPane.showMessageDialog(this, "Please Enter Customer Address!", "Error", JOptionPane.ERROR_MESSAGE);
            jTextArea1.grabFocus();
        } else if (jDateChooser2.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Please Enter Register Date!", "Error", JOptionPane.ERROR_MESSAGE);
            jDateChooser2.grabFocus();

        } else {

            String cus_reg = jTextField9.getText();
            String name = jTextField1.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String nic_no = jTextField4.getText();
            String contact_no = jTextField5.getText();
            String address = jTextArea1.getText();
            String gender = "";
            String reg_date = sdf.format(jDateChooser2.getDate());

            if (jRadioButton1.isSelected()) {
                gender = "Male";
            } else {
                gender = "Female";
            }

            try {
                DBMS.iud("INSERT INTO customer (`cus_reg`,`name`,`nic_no`,`contact_no`,`address`,`gender`,`reg_date`)VALUES ('" + cus_reg + "','" + name + "','" + nic_no + "','" + contact_no + "','" + address + "','" + gender + "','" + reg_date + "')");
                JOptionPane.showMessageDialog(this, "Customer Registered Successfully !!!", "Success", JOptionPane.INFORMATION_MESSAGE);

                jTextField9.setText("");
                jTextField1.setText("");
                jTextField4.setText("");
                jTextField5.setText("");
                jTextArea1.setText("");
                jDateChooser2.setDate(null);
                buttonGroup1.clearSelection();

                TableLoad();
                CusRegNo();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Customer Registerd not Success!!!", "Error", JOptionPane.ERROR_MESSAGE);
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

            String cus_reg = jTextField9.getText();
            String name = jTextField1.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String nic_no = jTextField4.getText();
            String contact_no = jTextField5.getText();
            String address = jTextArea1.getText();
            String gender = "";
            String reg_date = sdf.format(jDateChooser2.getDate());

            if (jRadioButton1.isSelected()) {
                gender = "Male";
            } else {
                gender = "Female";
            }

            dtm.setValueAt(cus_reg, jTable1.getSelectedRow(), 0);
            dtm.setValueAt(name, jTable1.getSelectedRow(), 1);
            dtm.setValueAt(nic_no, jTable1.getSelectedRow(), 2);
            dtm.setValueAt(contact_no, jTable1.getSelectedRow(), 3);
            dtm.setValueAt(address, jTable1.getSelectedRow(), 4);
            dtm.setValueAt(gender, jTable1.getSelectedRow(), 5);
            dtm.setValueAt(reg_date, jTable1.getSelectedRow(), 6);

            try {

                DBMS.iud("UPDATE customer SET `name`='" + name + "',`nic_no`='" + nic_no + "',`contact_no`='" + contact_no + "',`address`='" + address + "',`gender`='" + gender + "',`reg_date`='" + reg_date + "' WHERE `cus_reg`='" + cus_reg + "' ");
                JOptionPane.showMessageDialog(this, "Customer Updated Successfully !!!", "Success", JOptionPane.INFORMATION_MESSAGE);

                jTextField9.setText("");
                jTextField1.setText("");
                jTextField4.setText("");
                jTextField5.setText("");
                jTextArea1.setText("");
                jRadioButton1.setSelected(false);
                jRadioButton2.setSelected(false);
                jDateChooser2.setDate(null);
                buttonGroup1.clearSelection();
                TableLoad();
                CusRegNo();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Customer Updated not Success!!!", "Error", JOptionPane.ERROR_MESSAGE);
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

            String cus_reg = jTextField9.getText();

            dtm.setValueAt(cus_reg, jTable1.getSelectedRow(), 0);

            try {

                DBMS.iud("DELETE FROM customer WHERE `cus_reg`='" + cus_reg + "' ");
                JOptionPane.showMessageDialog(this, "Customer Deleted Successfully !!!", "Success", JOptionPane.INFORMATION_MESSAGE);

                jTextField9.setText("");
                jTextField1.setText("");
                jTextField4.setText("");
                jTextField5.setText("");
                jTextArea1.setText("");
                buttonGroup1.clearSelection();
                jDateChooser2.setDate(null);
                buttonGroup1.clearSelection();

                CusRegNo();

                TableLoad();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Customer Delete not Success!!!", "Error", JOptionPane.ERROR_MESSAGE);
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

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        try {

            TableModel tm = jTable1.getModel();
            DefaultTableModel dtm = (DefaultTableModel) tm;

            String cus_reg = dtm.getValueAt(jTable1.getSelectedRow(), 0).toString();
            String name = dtm.getValueAt(jTable1.getSelectedRow(), 1).toString();
            String nic_no = dtm.getValueAt(jTable1.getSelectedRow(), 2).toString();
            String contact_no = dtm.getValueAt(jTable1.getSelectedRow(), 3).toString();
            String address = dtm.getValueAt(jTable1.getSelectedRow(), 4).toString();
            String gender = dtm.getValueAt(jTable1.getSelectedRow(), 5).toString();
            Date reg_date = new SimpleDateFormat("yyyy-MM-dd").parse((String) dtm.getValueAt(jTable1.getSelectedRow(), 6));

            jTextField9.setText(cus_reg);
            jTextField1.setText(name);
            jTextField4.setText(nic_no);
            jTextField5.setText(contact_no);
            jTextArea1.setText(address);
            if (gender.equals("Male")) {
                jRadioButton1.setSelected(true);
                jRadioButton2.setSelected(false);
            } else {
                jRadioButton1.setSelected(false);
                jRadioButton2.setSelected(true);
            }
            jDateChooser2.setDate(reg_date);

        } catch (ParseException ex) {
            System.out.println(ex);
        }

    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField7MouseClicked
        // TODO add your handling code here:
        jTextField9.setText("");
        jTextField1.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextArea1.setText("");
        buttonGroup1.clearSelection();
        jDateChooser2.setDate(null);

        jTextField7.setText("");
        TableLoad();
    }//GEN-LAST:event_jTextField7MouseClicked

    private void jTextField7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyReleased
        // TODO add your handling code here:
        String searchString = jTextField7.getText();
        Search(searchString);

        jTextField9.setText("");
        jTextField1.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextArea1.setText("");
        buttonGroup1.clearSelection();
        jDateChooser2.setDate(null);

    }//GEN-LAST:event_jTextField7KeyReleased

    private void jTextField7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyTyped
        // TODO add your handling code here:

        jTextField9.setText("");
        jTextField1.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextArea1.setText("");
        buttonGroup1.clearSelection();
        jDateChooser2.setDate(null);

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

            JOptionPane.showMessageDialog(this, "Please Enter Customer Register Number!", "Error", JOptionPane.ERROR_MESSAGE);
            jTextField7.grabFocus();

        } else {
            String cus_reg = jTextField7.getText();
            String sql = "SELECT * FROM customer WHERE cus_reg = '" + cus_reg + "' ";
            try {
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/tasty_burger?useSSL=false", "root", "1234");
                PreparedStatement pst = conn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    jTextField9.setText(rs.getString(2));
                    jTextField1.setText(rs.getString(3));
                    jTextField4.setText(rs.getString(4));
                    jTextField5.setText(rs.getString(5));
                    jTextArea1.setText(rs.getString(6));
                    if (rs.getString(7).equals("Male")) {
                        jRadioButton1.setSelected(true);
                        jRadioButton2.setSelected(false);
                    } else {
                        jRadioButton1.setSelected(false);
                        jRadioButton2.setSelected(true);
                    }
                    jDateChooser2.setDate(rs.getDate(8));

                    rs.close();
                    pst.close();

                } else {
                    JOptionPane.showMessageDialog(this, "Incorrect Customer Register Number!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_jButton8ActionPerformed

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
            java.util.logging.Logger.getLogger(CUSTOMERS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CUSTOMERS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CUSTOMERS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CUSTOMERS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CUSTOMERS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
