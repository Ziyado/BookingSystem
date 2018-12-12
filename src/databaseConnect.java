
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;

/**
 *
 *
 *
 */
public class databaseConnect {

    private final String host;
    private final String uName;
    private final String uPass;
    Connection con;
    Statement stmt;
    ResultSet rs;

    /**
     * This class will handle all the database SQL queries between the database
     * and the system, holding how to connect onto the database
     *
     * @throws SQLException will identify an SQL error if/when one occurs
     */
    public databaseConnect() throws SQLException {

        host = "jdbc:sqlserver://uniprojects.database.windows.net:1433;database=HomeReservation;guest=noobs@uniprojects;password=Sboons2018!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
        uName = "noobs";
        uPass = "test!2018";

        con = DriverManager.getConnection(host, uName, uPass);
    }

    public void getRooms() throws SQLException {
        //Runs SQL statement on the database
        stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
        String SQL = "SELECT * FROM room";
        rs = stmt.executeQuery(SQL);
        //This will access the table
    }

    public void getRoomsN() throws SQLException {
        //Runs SQL statement on the database
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String SQL = "SELECT * FROM room";
        rs = stmt.executeQuery(SQL);
        //This will access the table
    }

    public void getUnBookedRooms() throws SQLException {

        stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
        String SQL = "SELECT * FROM room WHERE ID NOT IN (SELECT roomID FROM booking)";
        rs = stmt.executeQuery(SQL);
    }

    /**
     * gets all bookings which match the entered fields into the bookings form
     *
     * @param capacity minimum room size
     * @param time time room is needed
     * @param date date room is needed
     * @throws SQLException will identify an SQL error if/when one occurs
     */
    public void searchBookings(int capacity, String time, String date) throws SQLException {

        int roomCap = capacity;
        String bookTime = "\"" + time + "\"";
        String bookDate = "\"" + date + "\"";

        stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
        String SQL;
        SQL = String.format("SELECT * FROM room JOIN booking ON booking.roomID = room.id WHERE (room.projector = " + " AND room.capacity >= " + roomCap + " AND (booking.date <> " + bookDate + " AND booking.time <> " + bookTime + "))");
        //Need way to check if room us taken at time

        /*
                SELECT * FROM room
                JOIN bookings
                ON bookings.roomID = room.id	
                WHERE room.capacity <= 20
                AND !(bookings.date = "2016-11-16" AND bookings.time = "10:00:00")
         */
        rs = stmt.executeQuery(SQL);
    }

    /**
     *
     * @param bookID holds bookingID which is current being searched for
     * @throws SQLException will identify an SQL error if/when one occurs
     */
    public void getSpecificBooking(int bookID) throws SQLException {

        stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
        String SQL = "SELECT * FROM booking where ID = " + bookID;
        rs = stmt.executeQuery(SQL);
    }

    /**
     * Will select all bookings from table booking, and store this as a result
     * set
     *
     * @throws SQLException will identify an SQL error if/when one occurs
     */
    public void getAllBookings() throws SQLException {

        Statement stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
        String SQL = "SELECT * FROM booking";
        rs = stmt.executeQuery(SQL);
    }

    public void getBookingbyGuestID(String ID) throws SQLException {
        Statement stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
        String SQL = "SELECT * FROM booking LEFT JOIN room ON booking.roomID = room.ID LEFT JOIN guest ON booking.guestID = guest.ID WHERE booking.guestID = " + ID;
        rs = stmt.executeQuery(SQL);
    }

    /**
     * Gets all the bookings todays date, where guest ID = current guest, and
     * stores this as a result set
     *
     * @param ID takes ID for the SQL statement
     * @throws SQLException will identify an SQL error if/when one occurs
     */
    public void getMyBookings(String ID) throws SQLException {

        ID = "\"" + ID + "\"";

        stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
        String SQL = "SELECT * FROM booking join room on booking.roomID = room.id WHERE date >= GETDATE() and guestID = " + ID;

        rs = stmt.executeQuery(SQL);

    }

    /**
     * Gets all guests from the guest table and stores this as a resultset
     *
     * @throws SQLException will identify an SQL error if/when one occurs
     */
    public void getUsers() throws SQLException {

        stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
        String SQL = "SELECT * FROM guest";
        rs = stmt.executeQuery(SQL);
        //This will access the table  
    }

    public void getUsersN() throws SQLException {

        stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String SQL = "SELECT * FROM guest";
        rs = stmt.executeQuery(SQL);
        //This will access the table  
    }

    /**
     * takes a guest ID, converting it to a SQL string format, which is then
     * used in a query to ensure that it is unique
     *
     * @param ID holds the unique ID of the guest
     * @return returns if the ID is unique
     * @throws SQLException will identify an SQL error if/when one occurs
     */
    public void Delete(String ID) throws SQLException {
        stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
        String SQL = "DELETE from booking WHERE ID = "+ID;
        stmt.execute(SQL);
    }

    public ResultSet getRS() {

        return rs;

    }

    /**
     * Closes the current connection to the database
     *
     * @throws SQLException will identify an SQL error if/when one occurs
     */
    public void closeConnection() throws SQLException {

        stmt.close();
        rs.close();

    }

}
