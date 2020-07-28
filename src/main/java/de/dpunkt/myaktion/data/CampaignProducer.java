package de.dpunkt.myaktion.data;

import de.dpunkt.myaktion.model.Campaign;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@SessionScoped
@Named
public class CampaignProducer implements Serializable {

    private static final long serialVersionUID = -1828660647917534556L;

    @SessionScoped
    private enum Mode {
        EDIT, ADD
    }

    private Campaign campaign;
    private Mode mode;


    // Methode gibt Mode-Wert zurück für Titel des editCampaign.xhtml
    public String getMode() {
        return mode.toString();
    }

    public Campaign getSelectedCampaign() {
        return campaign;
    }

    public void setSelectedCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    // gelöscht, da Ansprache über Named auf Klassen-Ebene:
    /*
     * @SessionScoped
     * @Produces
     * @Named
     */
    public Boolean isAddMode() {
        return mode == Mode.ADD;
    }

    public void prepareAddCampaign() {
        this.campaign = new Campaign();
        this.mode = Mode.ADD;
    }

    public void prepareEditCampaign(Campaign campaign) {
        this.campaign = campaign;
        this.mode = Mode.EDIT;
    }

}
