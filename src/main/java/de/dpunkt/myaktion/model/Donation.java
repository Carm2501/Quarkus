package de.dpunkt.myaktion.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Donation {

    @GeneratedValue
    @Id
    private Long id;
    private Double amount;
    private String donorName;
    private Boolean receiptRequested;
    private Status status;
    //Attribute von Account hinzugefügt
    private String accountName;
    private String nameOfBank;
    private String iban;

    @ManyToOne
    private Campaign campaign;

    public enum Status {
        TRANSFERRED, IN_PROCESS;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public Boolean getReceiptRequested() {
        return receiptRequested;
    }

    public void setReceiptRequested(Boolean receiptRequested) {
        this.receiptRequested = receiptRequested;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getNameOfBank() {
        return nameOfBank;
    }

    public void setNameOfBank(String nameOfBank) {
        this.nameOfBank = nameOfBank;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }
}
