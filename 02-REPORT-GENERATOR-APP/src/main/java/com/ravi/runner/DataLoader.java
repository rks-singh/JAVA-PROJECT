package com.ravi.runner;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.ravi.entity.CitizenPlan;
import com.ravi.repository.CitizenPlanRepository;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private CitizenPlanRepository citizenPlanRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		// Deleting all record before inserting all record in DB table.
		citizenPlanRepository.deleteAll();

		CitizenPlan p1 = new CitizenPlan("Jhon", "jhon@in.com", "Male", 1234l, 123445l, "Cash", "Approved",
				LocalDate.now(), LocalDate.now().plusMonths(6));

		CitizenPlan p2 = new CitizenPlan("Smith", "smith@in.com", "Male", 1214l, 163445l, "Cash", "Denied", null, null);

		CitizenPlan p3 = new CitizenPlan("Cathy", "cathy@in.com", "Female", 12346l, 523445l, "Food", "Approved",
				LocalDate.now(), LocalDate.now().plusMonths(6));

		CitizenPlan p4 = new CitizenPlan("Johny", "jhon@in.com", "Male", 1284l, 123445l, "Food", "Denied", null, null);

		CitizenPlan p5 = new CitizenPlan("Raghu", "raghu@gmail.com", "Male", 9234l, 173445l, "Medical", "Approved",
				LocalDate.now(), LocalDate.now().plusMonths(6));

		CitizenPlan p6 = new CitizenPlan("Shital", "shital@gmail.com", "Female", 1834l, 363445l, "Employment",
				"Approved", LocalDate.now(), LocalDate.now().plusMonths(6));

		CitizenPlan p7 = new CitizenPlan("Ashok", "ashok@in.com", "Male", 12384l, 12445l, "Medical", "Denied", null,
				null);

		CitizenPlan p8 = new CitizenPlan("Rohan", "rohan@in.com", "Male", 54234l, 193445l, "Employment", "Terminated",
				LocalDate.now(), LocalDate.now().plusMonths(3));

		// Inserting all record in DB table.
		citizenPlanRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8));

	}

}
