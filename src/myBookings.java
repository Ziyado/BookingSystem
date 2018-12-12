
import java.sql.*;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * An interface class for the system, this class contains the booking screen for
 * the system, so that the system will search for rooms and allow the guest to
 * book a room.
 *
 *
 */
public class myBookings extends javax.swing.JFrame {

    /**
     * Creates new form myBookings
     */
    databaseConnect connection;
    ResultSet rs;
    int curRow = 0;
    String ID;
    String auth;

    /**
     *
     * @param guestID temporarily holds guest ID until moved to a global
     * variable
     * @param authorisation temporarily holds guest authorization until moved to
     * a global variable
     * @throws SQLException will identify an SQL error if/when one occurs
     */
    public myBookings(String guestID, String authorisation) throws SQLException {

        if (connection == null) {
            connection = new databaseConnect();
        }

        ID = guestID;
        auth = authorisation;

        initComponents();

        DoConnect();
    }

    /**
     *
     * @throws SQLException will identify an SQL error if/when one occurs
     */
    public void DoConnect() throws SQLException {

        boolean boolID = false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        back = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Booking system");

        back.setBackground(new java.awt.Color(0, 102, 255));
        back.setText("Back to menu");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Room", "Guest", "Date", "Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Get Bookings");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 417, Short.MAX_VALUE)
                        .addComponent(back))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(215, 215, 215))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(back)
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed

        this.dispose();

        if (auth.equals("a")) {
            try {
                new mainMenuAdmin(ID).setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(myBookings.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                new mainMenu(ID).setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(bookingScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_backActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        try {
            connection.getBookingbyGuestID(ID);
        } catch (SQLException ex) {
            Logger.getLogger(myBookings.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        ResultSet rs = connection.getRS();
        try {
            while (rs.next()) {
                String ID = rs.getString("ID");
                String room_name = rs.getString("room_name");
                String guest = rs.getString("first_name");
                String date = rs.getString("date");
                String time = rs.getString("time");
                model.addRow(new Object[]{ID, room_name, guest, date, time});
            }
        } catch (SQLException ex) {
            Logger.getLogger(myBookings.class.getName()).log(Level.SEVERE, null, ex);
        }    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

//    private void getRecordDetails() throws SQLException {
//
//        int id_room = rs.getInt("roomID");
//        Date date = rs.getDate("date");
//        Time time = rs.getTime("time");
//        int capacity = rs.getInt("capacity");
//        boolean projector = rs.getBoolean("projector");
//        String type = rs.getString("type");
//
//        String idRoom = Integer.toString(id_room);
//
//        textType.setText(type);
//        roomID.setText(idRoom);
//        spnCap.setValue(capacity);
//        Format formatter = new SimpleDateFormat("yyyy-MM-dd");
//        String bookingDate = formatter.format(date);
//        formatter = new SimpleDateFormat("HH:mm:ss");
//        String bookingTime = formatter.format(time);
//        textDate.setText(bookingDate);
//        textTime.setText(bookingTime);
//
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
