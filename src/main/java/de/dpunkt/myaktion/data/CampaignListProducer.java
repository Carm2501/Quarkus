package de.dpunkt.myaktion.data;

import de.dpunkt.myaktion.model.Campaign;
import de.dpunkt.myaktion.services.CampaignService;
import de.dpunkt.myaktion.util.Events.Added;
import de.dpunkt.myaktion.util.Events.Deleted;
import de.dpunkt.myaktion.util.Events.Updated;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@RequestScoped
@Named
public class CampaignListProducer {

    
    private List<Campaign> campaigns;

    
    @Inject
    //hinzugefügt:
    @RequestScoped
    CampaignService campaignService;

    
    @PostConstruct
    public void init() {
        campaigns = campaignService.getAllCampaigns();
    }

    //entfernt und Named auf Klassen-Ebene hinzugefügt:
    /*
    @RequestScoped
    @Produces
    @Named
    */
        public List<Campaign> getCampaigns() {
        return campaigns;
    }
    
    
    public void onCampaignAdded(@Observes @Added Campaign campaign) {
        campaignService.addCampaign(campaign);
        init();
    }
    
    public void onCampaignUpdated(@Observes @Updated Campaign campaign) {
        campaignService.updateCampaign(campaign);
        init();
        }
    
    public void onCampaignDeleted(@Observes @Deleted Campaign campaign) {
        campaignService.deleteCampaign(campaign);
        init();
    }

}
