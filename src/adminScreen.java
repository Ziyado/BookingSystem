
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
 
/**
 * An interface class for the system, the admin can view all guests on the system
 * and edit their details if it is required while also being able to add new guests
 * on the system.
 *
 * 
 */
public final class adminScreen extends javax.swing.JFrame {

    databaseConnect connection;
        
        
    ResultSet rs;       
    int curRow = 0;     
    String guestID;     
    
    /**
     *`creates a new database connection, which gets all guests on the system, 
     * and load up the components of the form.
     * 
     * @param tempID stores the current guest ID, to be saved to the class
     * @throws SQLException will identify an SQL error if/when one occurs
     */
    public adminScreen(String tempID) throws SQLException {

        if (connection == null){
            connection = new databaseConnect(); 
        }
        
        ResultSet rs;
        
        guestID = tempID;

        initComponents();

        DoConnect();

    }

    /**
     * Runs the selected SQL statement on the database, which in this case, the
     * table will get all guests from the guest table, and stop when it has found
     * the current guest.
     *
     * @throws SQLException will identify an SQL error if/when one occurs
     */
    @SuppressWarnings("empty-statement")
    public void DoConnect() throws SQLException {

        connection.getUsersN();
        //This will access the table
        
        rs = connection.getRS();

        while (rs.next()) {      //Loop while there is data to search

            if (rs.getString("ID").equals(guestID)) {     // If the id is equal to the guest ID

                //Get the guests details from the database
                String id = rs.getString("ID");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("second_name");
                String setAuthorisation = rs.getString("edit_authorisation");

                // Puts all guest details into interface text boxes
                textID.setText(id);
                textFirstName.setText(first_name);
                textLastName.setText(last_name);
                textAuthorisation.setText(setAuthorisation);

            }
        }
    }

    /**
     * Will get the guest details, and add them to the onscreen boxes
     *
     * @throws SQLException
     */
    private void getRecordDetails() throws SQLException {

        //Get the  recordsets details
        String id = rs.getString("ID");
        String first_name = rs.getString("First_Name");
        String last_name = rs.getString("Second_Name");
        String setAuthorisation = rs.getString("edit_authorisation");

        //Put the first recordsets details on the screens
        textID.setText(id);
        textFirstName.setText(first_name);
        textLastName.setText(last_name);
        textAuthorisation.setText(setAuthorisation);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        btnFirst = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        btnUpdateRecord = new javax.swing.JButton();
        btnDeleteRecord = new javax.swing.JButton();
        btnNewRecord = new javax.swing.JButton();
        btnSaveRecord = new javax.swing.JButton();
        btnCancelRecord = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        textFirstName = new javax.swing.JTextField();
        textID = new javax.swing.JTextField();
        textLastName = new javax.swing.JTextField();
        jPassword = new javax.swing.JPasswordField();
        lblPassword = new javax.swing.JLabel();
        lblPassword1 = new javax.swing.JLabel();
        textAuthorisation = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Booking system");

        btnFirst.setBackground(new java.awt.Color(0, 102, 255));
        btnFirst.setText("First");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnNext.setBackground(new java.awt.Color(0, 102, 255));
        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setBackground(new java.awt.Color(0, 102, 255));
        btnLast.setText("Last");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        btnPrevious.setBackground(new java.awt.Color(0, 102, 255));
        btnPrevious.setText("Previous");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        btnUpdateRecord.setBackground(new java.awt.Color(0, 102, 255));
        btnUpdateRecord.setText("Update");
        btnUpdateRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateRecordActionPerformed(evt);
            }
        });

        btnDeleteRecord.setBackground(new java.awt.Color(0, 102, 255));
        btnDeleteRecord.setText("Delete");
        btnDeleteRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteRecordActionPerformed(evt);
            }
        });

        btnNewRecord.setBackground(new java.awt.Color(0, 102, 255));
        btnNewRecord.setText("New Record");
        btnNewRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewRecordActionPerformed(evt);
            }
        });

        btnSaveRecord.setBackground(new java.awt.Color(0, 102, 255));
        btnSaveRecord.setText("Save new record");
        btnSaveRecord.setEnabled(false);
        btnSaveRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveRecordActionPerformed(evt);
            }
        });

        btnCancelRecord.setBackground(new java.awt.Color(0, 102, 255));
        btnCancelRecord.setText("Cancel new record");
        btnCancelRecord.setEnabled(false);
        btnCancelRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelRecordActionPerformed(evt);
            }
        });

        back.setBackground(new java.awt.Color(0, 102, 255));
        back.setText("Back to menu");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "View users", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        textFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFirstNameActionPerformed(evt);
            }
        });

        textID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textIDActionPerformed(evt);
            }
        });

        lblPassword.setText("Password");

        lblPassword1.setText("Authorisation");

        textAuthorisation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textAuthorisationActionPerformed(evt);
            }
        });

        jLabel1.setText("ID");

        jLabel2.setText("First Name");

        jLabel3.setText("Last Name");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblPassword1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textAuthorisation, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblPassword)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblPassword1)
                        .addComponent(textAuthorisation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPassword))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(back))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnUpdateRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnDeleteRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnNewRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSaveRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(btnCancelRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(back)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNext)
                    .addComponent(btnPrevious)
                    .addComponent(btnFirst)
                    .addComponent(btnLast))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdateRecord)
                    .addComponent(btnDeleteRecord)
                    .addComponent(btnNewRecord))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveRecord)
                    .addComponent(btnCancelRecord))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFirstNameActionPerformed

    /**
     * When btnFirst is clicked, the system will move to the first record on the
     * record set of all guests on the system
     *
     * @param evt - when the "first" button is pressed do this.
     */
    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed

        try {

            rs.first();     // Go to the first record in recordset 

            getRecordDetails();  // Gets guest details

        } catch (SQLException err) {        //Catch any SQL errors, and keep the system running

            JOptionPane.showMessageDialog(adminScreen.this, err.getMessage());

        }

    }//GEN-LAST:event_btnFirstActionPerformed

    /**
     * When btnNext is clicked, the system will move to the next data on
     * the record set of all guests
     *
     * @param evt - when the "next" button is pressed do this.
     */
    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed

        try {

            if (rs.next()) {        //If there is another record after the current record

                getRecordDetails();

            } else {
                //Go back to the current record and display message to the screen
                rs.previous();
                JOptionPane.showMessageDialog(adminScreen.this, "End of database");
            }

        } catch (SQLException err) {        //Catch any SQL errors, and keep the system running

            JOptionPane.showMessageDialog(adminScreen.this, err.getMessage());

        }

    }//GEN-LAST:event_btnNextActionPerformed

    /**
     * When btnPrevious is clicked, the system will move to the previous data
     * on the record set of all guests
     * 
     * @param evt - when the "previous" button is pressed do this.
     */
    
    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed

        try {

            if (rs.previous()) {        //If there is another record before the current record

                getRecordDetails();

            } else {
                rs.next();
                JOptionPane.showMessageDialog(adminScreen.this, "Start of database");
            }

        } catch (SQLException err) {

            JOptionPane.showMessageDialog(adminScreen.this, err.getMessage());

        }

    }//GEN-LAST:event_btnPreviousActionPerformed

    /**
     * When btnLast is clicked, the system will move to the last data
     * on the record set of all guests
     * 
     * @param evt - when the "last" button is pressed, do this
     */
    
    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed

        try {

            rs.last();      // Go to the last record in the table

            getRecordDetails();

        } catch (SQLException err) {

            JOptionPane.showMessageDialog(adminScreen.this, err.getMessage());

        }

    }//GEN-LAST:event_btnLastActionPerformed

    /**
     * When btnUpdate is clicked, the system will update the guest being viewed,
     * with the new data from this form.
     * 
     * @param evt waits for the "update" button click
     */
    
    private void btnUpdateRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateRecordActionPerformed

        //Temporary Strings to hold the updated guest details
        String first = textFirstName.getText();
        String last = textLastName.getText();
        String ID = textID.getText();
        String setAuthorisation = textAuthorisation.getText();
        
        try {
            //Update the recordset in the database
            rs.updateString("ID", ID);
            rs.updateString("First_Name", first);
            rs.updateString("last_Name", last);
            rs.updateString("edit_authorisation", setAuthorisation);
            rs.updateRow();
            JOptionPane.showMessageDialog(adminScreen.this, "Updated");
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }

    }//GEN-LAST:event_btnUpdateRecordActionPerformed

    /**
     * When btnDelete is clicked, the system will delete the current guest being
     * viewed from the database
     * 
     * @param evt waits for the delete button to be clicked
     */    
    private void btnDeleteRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteRecordActionPerformed

        try {

            rs.deleteRow();     //Delete the current row

            //Close the database
            connection.closeConnection();

            //Reopen the database
            connection.getUsersN();
            rs = connection.getRS();
            //This will access the table

            // Get record set details
            rs.next();
            String id = rs.getString("ID");
            String first_name = rs.getString("first_name");
            String last_name = rs.getString("last_name");
            String setAuthorisation = rs.getString("edit_authorisation");

            // Put recordset details to the screen
            textID.setText(id);
            textFirstName.setText(first_name);
            textLastName.setText(last_name);
            textAuthorisation.setText(setAuthorisation);

            //Set the buttons relevant clickable
            btnFirst.setEnabled(true);
            btnPrevious.setEnabled(true);
            btnNext.setEnabled(true);
            btnLast.setEnabled(true);
            btnUpdateRecord.setEnabled(true);
            btnDeleteRecord.setEnabled(true);
            btnNewRecord.setEnabled(true);

            // Cancels saved record
            btnSaveRecord.setEnabled(false);
            btnCancelRecord.setEnabled(false);

            JOptionPane.showMessageDialog(this, "Record Deleted");

        } catch (SQLException ex) {
            Logger.getLogger(adminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnDeleteRecordActionPerformed
  
    /**
     * When the btnNewRecord button is clicked, the form will remove all data
     * and show a blank form, for there to be a new guest added
     * 
     * @param evt waits for the "new Record" button to be clicked
     */
    private void btnNewRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewRecordActionPerformed

        // Make relevant buttons clickable
        btnFirst.setEnabled(false);
        btnPrevious.setEnabled(false);
        btnNext.setEnabled(false);
        btnLast.setEnabled(false);
        btnUpdateRecord.setEnabled(false);
        btnDeleteRecord.setEnabled(false);
        btnNewRecord.setEnabled(false);

        btnSaveRecord.setEnabled(true);
        btnCancelRecord.setEnabled(true);

        try {

            curRow = rs.getRow();       //Set the current row to the row moved to
            textFirstName.setText("");      //Set the text of first name
            textLastName.setText("");       //Set the text of last name
            textAuthorisation.setText("");  //Authorises text inputed
        } catch (SQLException ex) {
            Logger.getLogger(adminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnNewRecordActionPerformed

    /**
     *
     * When the btnCancelRecord is clicked, the system will remove data from the forms
     * and display the last view data from the record set
     *
     * @param evt - when the "cancel record" button is pressed.
     */
    private void btnCancelRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelRecordActionPerformed

        //Set relevant buttons to clickable
        btnFirst.setEnabled(true);
        btnPrevious.setEnabled(true);
        btnNext.setEnabled(true);
        btnLast.setEnabled(true);
        btnUpdateRecord.setEnabled(true);
        btnDeleteRecord.setEnabled(true);
        btnNewRecord.setEnabled(true);

        btnSaveRecord.setEnabled(false);
        btnCancelRecord.setEnabled(false);

        try {
            //Go back to the last viewed record and show the details of last viewed record
            rs.absolute(curRow);
            textFirstName.setText(rs.getString("First_Name"));
            textLastName.setText(rs.getString("Last_Name"));
            textID.setText(rs.getString("ID"));
            textAuthorisation.setText(rs.getString("edit_authorisation"));
        } catch (SQLException ex) {

        }

    }//GEN-LAST:event_btnCancelRecordActionPerformed

     /**
     * When the btnBack button is clicked, the system will go back to the main menu
     * 
     * @param evt waits for the "back" button to be clicked
     */
    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed

        try {
            this.dispose();     //Close the current screen
            new mainMenuAdmin(guestID).setVisible(true);     //Open the main menu
        } catch (SQLException ex) {
            Logger.getLogger(adminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_backActionPerformed

    private void textAuthorisationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textAuthorisationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textAuthorisationActionPerformed

    /**
     * When the btnSaveRecord button is clicked, the system will take the data
     * from the form, and add this onto the end of the database, in the guests
     * table
     * 
     * @param evt waits for the "save record" button to be clicked
     */
    private void btnSaveRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveRecordActionPerformed

        // Store all entered data into temporary varialbes
        String first = textFirstName.getText();
        String last = textLastName.getText();
        String ID = textID.getText();
        String password = jPassword.getText();
        String setAuthorisation = textAuthorisation.getText();

        try {

            rs.moveToInsertRow();   //Move to the end of record set

            //Update recordset with the new record
            rs.updateString("first_Name", first);
            rs.updateString("second_Name", last);
            rs.updateString("password", password);
            rs.updateString("edit_authorisation", setAuthorisation);
            rs.insertRow();

            //Close the database
            connection.closeConnection();

            //Reconnect to the database
            connection.getUsersN();
            rs = connection.getRS();
            //This will access the table

            //Get recordset details
            rs.next();
            int id_col = rs.getInt("ID");
            String id = Integer.toString(id_col);
            String first_name2 = rs.getString("first_name");
            String last_name2 = rs.getString("second_name");
            String setAuthorisation2 = rs.getString("edit_authorisation");

            //Put recordset details to the screen
            textID.setText(id);
            textFirstName.setText(first_name2);
            textLastName.setText(last_name2);

            //Set necessary buttons to clickable
            btnFirst.setEnabled(true);
            btnPrevious.setEnabled(true);
            btnNext.setEnabled(true);
            btnLast.setEnabled(true);
            btnUpdateRecord.setEnabled(true);
            btnDeleteRecord.setEnabled(true);
            btnNewRecord.setEnabled(true);

            btnSaveRecord.setEnabled(false);
            btnCancelRecord.setEnabled(false);

            JOptionPane.showMessageDialog(this, "Record Saved");

        } catch (SQLException ex) {     //Catch any SQL errors and keep running
            Logger.getLogger(adminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnSaveRecordActionPerformed

    private void textIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textIDActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton btnCancelRecord;
    private javax.swing.JButton btnDeleteRecord;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNewRecord;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnSaveRecord;
    private javax.swing.JButton btnUpdateRecord;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPassword1;
    private javax.swing.JTextField textAuthorisation;
    private javax.swing.JTextField textFirstName;
    private javax.swing.JTextField textID;
    private javax.swing.JTextField textLastName;
    // End of variables declaration//GEN-END:variables
}
