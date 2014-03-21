package se.fidde.angular.util;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import se.fidde.angular.service.PersonService;

public class MockDataFiller implements
        ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private PersonService personService;
    private Logger log = Logger.getLogger(MockDataFiller.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {
        log.debug("adding mockdata");
        personService.addPerson(MockTools.getMockPerson());
    }

}
