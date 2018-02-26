/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.util.Date;

/**
 *
 * @author ETDelacruz
 */
public class HoldTransactionOBJ {
    
    private int id;
    private String userid;
    private String heldID;
    private String invoiceNum;
    private String loggedBy;
    private Date createdAt;
    private Date closedAt;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getheldID() {
        return heldID;
    }

    public void setheldID(String heldID) {
        this.heldID = heldID;
    }
    
    public String getInvoice() {
        return invoiceNum;
    }

    public void setInvoice(String invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public String getLoggedBy() {
        return loggedBy;
    }

    public void setLoggedBy(String loggedBy) {
        this.loggedBy = loggedBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getClosedAt() {
        return closedAt;
    }

    public void setClosedAt(Date closedAt) {
        this.closedAt = closedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
