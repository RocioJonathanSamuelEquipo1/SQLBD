package concrete;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Criteria.Criteria;
/**
 *
 * @author omarp
 */
import entidad.Person;
import java.util.ArrayList;
import java.util.List;

public class CriteriaFemale implements Criteria
{
 
 // Return the List of Persons who are female
 @Override
 public List<Person> meetCriteria( List<Person> persons )
 {
 List<Person> femalePersons = new ArrayList<Person>(); 
      
      for (Person person : persons) {
         if(person.getGender().equalsIgnoreCase("FEMALE")){
            femalePersons.add(person);
         }
      }
      return femalePersons;
 }
}
