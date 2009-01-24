/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.smartitengineering.user.rest.client;
import com.smartitengineering.user.domain.Person;
import com.smartitengineering.user.filter.PersonFilter;
import com.smartitengineering.user.service.PersonService;
import com.smartitengineering.user.ws.element.PersonElement;
import com.smartitengineering.user.ws.element.PersonElements;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import java.util.Collection;
import javax.ws.rs.core.MultivaluedMap;

/**
 *
 * @author modhu7
 */
public class PersonServiceClientImpl extends AbstractClientImpl implements PersonService{

    public void create(Person person) {
        PersonElement personElement = new PersonElement();
        personElement.setPerson(person);
        final Builder type = getWebResource().path("person").type("application/xml");
        type.post(personElement);
    }

    public void update(Person person) {
        PersonElement personElement = new PersonElement();
        personElement.setPerson(person);
        final Builder type = getWebResource().path("person").type("application/xml");
        type.put(personElement);
    }

    public void delete(Person person) {
        PersonElement personElement = new PersonElement();
        personElement.setPerson(person);
        final Builder type = getWebResource().path("person").type("application/xml");
        type.post();
    }

    public Collection<Person> search(PersonFilter filter) {
        MultivaluedMap<String, String> map = new MultivaluedMapImpl();
        map.add("email", filter.getEmail());
        map.add("firstName", filter.getName().getFirstName());
        map.add("lastName", filter.getName().getLastName());
        map.add("middleInitial", filter.getName().getMiddleInitial());
        WebResource resource = getWebResource().path("person").queryParams(map);
        final PersonElements personElements = resource.get(PersonElements.class);
        return personElements.getPersons();
    }

    public Person getPersonByEmail(String email) {
        WebResource resource = getWebResource().path("person/" + email);        
        final PersonElement element = resource.get(PersonElement.class);
        final Person person = element.getPerson();        
        return person;
    }

    public Collection<Person> getAllPerson() {
        WebResource resource = getWebResource().path("person/allperson");        
        final PersonElements personElements = resource.get(PersonElements.class);
        return personElements.getPersons(); 
    }


}
