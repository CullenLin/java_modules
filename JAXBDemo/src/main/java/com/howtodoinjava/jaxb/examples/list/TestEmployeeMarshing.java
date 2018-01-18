package com.howtodoinjava.jaxb.examples.list;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class TestEmployeeMarshing 
{
	static Employees employees = new Employees();
	static 
	{
		employees.setEmployees(new ArrayList<Employee>());
		
		Employee emp1 = new Employee();
		emp1.setId(1);
		emp1.setFirstName("Lokesh");
		emp1.setLastName("Gupta");
		emp1.setIncome(100.0);
		
		Employee emp2 = new Employee();
		emp2.setId(2);
		emp2.setFirstName("John");
		emp2.setLastName("Mclane");
		emp2.setIncome(200.0);
		
		employees.getEmployees().add(emp1);
		employees.getEmployees().add(emp2);
	}
	
	public static void main(String[] args) throws JAXBException 
	{
		marshalingExample();
		System.out.println("************************************************");
		unMarshalingExample();
	}

	private static void unMarshalingExample() throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Employees emps = (Employees) jaxbUnmarshaller.unmarshal( new File("employees.xml") );
		
		for(Employee emp : emps.getEmployees())
		{
			System.out.println(emp.getId());
			System.out.println(emp.getFirstName());
		}
	}

	private static void marshalingExample() throws JAXBException
	{
		JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
 
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
 
		jaxbMarshaller.marshal(employees, System.out);
		jaxbMarshaller.marshal(employees, new File("employees.xml"));
	}
}
