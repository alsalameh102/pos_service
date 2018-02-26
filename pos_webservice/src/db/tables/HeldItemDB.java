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
public class HeldItemDB {
    
   
    public static final String HELDID = "held_id";
    public static final String ITEMCODE = "item_code";
    public static final String QTY = "qty";
    public static final String CREATEDAT = "created_at";
    public static final String STATUS = "status";
    
    
    //queries
    public static final String INSERT_HELD_ITEM = "INSERT INTO hold_items ( held_id, item_code, qty, status) VALUES (?,?,?,?)";
    public static final String GET_ALL_HELD_ITEM = "SELECT * FROM hold_items";
    public static final String GET_HELD_ITEM = "SELECT * FROM hold_items where held_id = ? and date(created_at) = CURDATE()";
    public static final String CANCEL_HELD_ITEM = "UPDATE hold_items SET status = 'cancelled' where held_id = ?";
    public static final String SET_TO_PENDING_ITEM = "UPDATE hold_items SET status = 'open' where held_id = ?";
    public static final String SET_TO_CLOSED_ITEM = "UPDATE hold_items SET status = 'closed' where held_id = ?";
    
}
