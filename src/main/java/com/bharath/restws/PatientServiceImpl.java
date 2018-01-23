package com.bharath.restws;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.bharath.restws.model.Patient;

@Service	// con esta annotation garantizamos que Spring va a tener en cuenta este bean at runtime
public class PatientServiceImpl implements PatientService {

	Map<Long, Patient> patients = new HashMap<>();
	long currentId = 123;
	
	public PatientServiceImpl() {
		init();
	}

	/**
	 * Simulamos informacion que normalmente tendremos en la base de datos
	 */
	private void init() {
		Patient patient = new Patient();
		patient.setId(currentId);
		patient.setName("Lincoln");
		patients.put(patient.getId(), patient);
	}
	
}
