
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * An interface class for the system, this class contains the view for all rooms
 * which are on the database, allowing edit add and view controls to the viewer.
 *
 *
 */
public final class roomsScreen extends javax.swing.JFrame {

    databaseConnect connection;
    ResultSet rs;       // A resultSet which stores the results of a run query
    int curRow = 0;     // An integer to store the row the guest is currently in
    String guestID;     //An interger to store the guests ID         

    /**
     * creates a new database connection and shows form components
     *
     * @param tempID temporarily stores the variable until moved to a global
     * variable
     * @throws SQLException will identify an SQL error if/when one occurs
     */
    public roomsScreen(String tempID) throws SQLException {

        // Connecting to a set database and storing that connection in connection con for reference.
        if (connection == null) {
            connection = new databaseConnect();
        }

        // Storing guestID for reference
        guestID = tempID;

        // Making the interface visible to guests
        initComponents();

        //Connecting the system to the database, collecting all the guest data through the query
    }

    /**
     * access the rooms table in the database to display the query results
     *
     * @throws SQLException will identify an SQL error if/when one occurs
     */
    @SuppressWarnings("empty-statement")


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        btnLoginScreen = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Booking system");

        btnLoginScreen.setBackground(new java.awt.Color(0, 102, 255));
        btnLoginScreen.setText("Back to menu");
        btnLoginScreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginScreenActionPerformed(evt);
            }
        });

        jLabel1.setText("Room Name");

        jLabel2.setText("Type");

        jLabel3.setText("Capacity");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        jButton1.setText("Add Room");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLoginScreen)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                                .addComponent(jTextField1))
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(77, 185, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(btnLoginScreen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * will go back to the main menu
     *
     * @param evt waits for the "back" button click
     */
    private void btnLoginScreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginScreenActionPerformed

        try {
            this.dispose();     //Close the current screen
            new mainMenuAdmin(guestID).setVisible(true);     //Open the main menu

        } catch (SQLException ex) {
            Logger.getLogger(adminScreen.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnLoginScreenActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String name = jTextField1.getText();
        String type = jTextField2.getText();
        String capacity = jComboBox1.getSelectedItem().toString();

        try {
            connection.getRooms();
        } catch (SQLException ex) {
            Logger.getLogger(roomsScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet res = connection.getRS();
        try {
            res.moveToInsertRow();
            res.updateString("type", type);
            res.updateString("room_name", name);
            res.updateString("capacity", capacity);
            res.insertRow();

            JOptionPane.showMessageDialog(this, ("Room Added"));

        } catch (SQLException ex) {
            Logger.getLogger(roomsScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            connection.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(roomsScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.dispose();
        try {
            new roomsScreen(guestID).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(roomsScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoginScreen;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
