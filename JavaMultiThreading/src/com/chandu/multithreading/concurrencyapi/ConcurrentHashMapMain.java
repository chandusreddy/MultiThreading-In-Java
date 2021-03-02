package com.chandu.multithreading.concurrencyapi;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapMain {

	public static void main(String[] args) {
		Employee st = new Employee("Sachin", 500000);
		Employee sh = new Employee("Shewag", 200000);
		Employee gn = new Employee("Ganguly", 200000);

		ConcurrentHashMap<Employee, String> EmployeesalMap = new ConcurrentHashMap<Employee, String>();
		EmployeesalMap.put(st, "Mumbai Indians");
		EmployeesalMap.put(sh, "Delhi DareDevils");
		EmployeesalMap.put(gn, "Royal Challengers");

		Iterator employeeitr = EmployeesalMap.keySet().iterator();// put debug point at this line
		while (employeeitr.hasNext()) {
			Employee empobj = (Employee) employeeitr.next();
			String team = EmployeesalMap.get(empobj);
			System.out.println(empobj.getName() + "----" + team);
		}
	}
}
