/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.tables;

/**
 *
 * @author ETDelacruz
 */
public class HoldDB {
    
    
    public static final String ID = "id";
    public static final String USERID = "userid";
    public static final String HELDID = "held_id";
    public static final String INVOICE = "invoice";
    public static final String LOGGED = "logged_by";
    public static final String CREATEDAT = "created_at";
    public static final String UPDATEDAT = "updated_at";
    public static final String STATUS = "status";
    
    
    //queries
    public static final String INSERT_HELD = "INSERT INTO hold ( userid, invoice, held_id, logged_by, status) VALUES (?,?,?,?,?)";
    public static final String GET_ALL_HELD_TODAY = "SELECT * FROM hold where status = 'open' and created_at >= CURDATE() AND created_at < CURDATE() + INTERVAL 1 DAY ORDER BY created_at";
    public static final String GET_HELD = "SELECT * FROM hold where held_id = ?";
    public static final String CANCEL_HELD = "UPDATE hold SET status = 'cancelled' where held_id = ?";
    public static final String SET_TO_PENDING = "UPDATE hold SET status = 'open' where held_id = ?";
    public static final String SET_TO_CLOSED = "UPDATE hold SET status = 'closed' where held_id = ?";
    
}
