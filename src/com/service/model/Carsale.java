package com.service.model;
// Generated Mar 31, 2018 2:39:19 AM by Hibernate Tools 5.2.8.Final


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Carsale generated by hbm2java
 */
@Entity
@Table(name="carsale"
    ,catalog="ITMD_515"
)
public class Carsale  implements java.io.Serializable {


     private String sid;
     private String csid;
     private String dsId;
     private String VId;
     private String price;
     private String orderDate;
     private String delivaryDate;
     private String status;

    public Carsale() {
    }

	
    public Carsale(String sid, String csid, String dsId, String VId) {
        this.sid = sid;
        this.csid = csid;
        this.dsId = dsId;
        this.VId = VId;
    }
    public Carsale(String sid, String csid, String dsId, String VId, String price, String orderDate, String delivaryDate, String status) {
       this.sid = sid;
       this.csid = csid;
       this.dsId = dsId;
       this.VId = VId;
       this.price = price;
       this.orderDate = orderDate;
       this.delivaryDate = delivaryDate;
       this.status = status;
    }
   
     @Id 

    
    @Column(name="SID", unique=true, nullable=false, length=45)
    public String getSid() {
        return this.sid;
    }
    
    public void setSid(String sid) {
        this.sid = sid;
    }

    
    @Column(name="CSID", nullable=false, length=45)
    public String getCsid() {
        return this.csid;
    }
    
    public void setCsid(String csid) {
        this.csid = csid;
    }

    
    @Column(name="DS_ID", nullable=false, length=45)
    public String getDsId() {
        return this.dsId;
    }
    
    public void setDsId(String dsId) {
        this.dsId = dsId;
    }

    
    @Column(name="V_ID", nullable=false, length=45)
    public String getVId() {
        return this.VId;
    }
    
    public void setVId(String VId) {
        this.VId = VId;
    }

    
    @Column(name="price", length=45)
    public String getPrice() {
        return this.price;
    }
    
    public void setPrice(String price) {
        this.price = price;
    }

    
    @Column(name="OrderDate", length=45)
    public String getOrderDate() {
        return this.orderDate;
    }
    
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    
    @Column(name="DelivaryDate", length=45)
    public String getDelivaryDate() {
        return this.delivaryDate;
    }
    
    public void setDelivaryDate(String delivaryDate) {
        this.delivaryDate = delivaryDate;
    }

    
    @Column(name="status", length=45)
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }




}


