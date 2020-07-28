package de.dpunkt.myaktion.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@NamedQueries({
    @NamedQuery(name = Campaign.findAll, query = "SELECT c FROM Campaign c ORDER BY c.name"),
    @NamedQuery(name = Campaign.getAmountDonatedSoFar, query = "SELECT SUM(d.amount) FROM Donation d WHERE d.campaign = :campaign")
    })

@Entity
public class Campaign {

    public static final String findAll = "Campaign.findAll";
    public static final String getAmountDonatedSoFar = "Campaign.getAmountDonatedSoFar";
    
    private String name;
    private Double targetAmount;
    private Double donationMinimum;
    @Transient
    private Double amountDonatedSoFar;
    //Attribute von Account hinzugefügt
    private String accountName;
    private String nameOfBank;
    private String iban;

  
    @GeneratedValue
    @Id
    private Long id;

    @OneToMany(mappedBy = "campaign", cascade = CascadeType.REMOVE)
    private List<Donation> donations;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(Double targetAmount) {
        this.targetAmount = targetAmount;
    }

    public Double getDonationMinimum() {
        return donationMinimum;
    }

    public void setDonationMinimum(Double donationMinimum) {
        this.donationMinimum = donationMinimum;
    }

    public Double getAmountDonatedSoFar() {
        return amountDonatedSoFar;
    }

    public void setAmountDonatedSoFar(Double amountDonatedSoFar) {
        this.amountDonatedSoFar = amountDonatedSoFar;
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
    
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public List<Donation> getDonations() {
        return donations;
    }

    public void setDonations(List<Donation> donations) {
        this.donations = donations;
    }

}
