package de.dpunkt.myaktion.util;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class Resources {

    @Produces
    @PersistenceContext
    @SessionScoped
    EntityManager em;
}