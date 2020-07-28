package de.dpunkt.myaktion.services;

import de.dpunkt.myaktion.model.Campaign;
import de.dpunkt.myaktion.model.Donation;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import java.util.List;

@RequestScoped
@Transactional
public class DonationServiceBean implements DonationService {

    @Inject
    @RequestScoped
    EntityManager entityManager;

    @Override
    public List<Donation> getDonationList(Long campaignId) {
        Campaign managedCampaign = entityManager.find(Campaign.class, campaignId);
        List<Donation> donations = managedCampaign.getDonations();
        donations.size();
        return donations;
    }

    @Override
    public void addDonation(Long campaignId, Donation donation) {
        Campaign managedCampaign = entityManager.find(Campaign.class, campaignId);
        donation.setCampaign(managedCampaign);
        entityManager.persist(donation);
    }
}