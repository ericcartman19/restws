package com.bharath.restws;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.bharath.restws.exceptions.PatientBusinessException;
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

	@Override
	public List<Patient> getPatients() {
		Collection<Patient> results = patients.values();
		List<Patient> response = new ArrayList<>(results);
		return response;
	}

	@Override
	public Patient getPatient(Long id) {
		if(Objects.isNull(patients.get(id))) {
			throw new WebApplicationException(Response.Status.FORBIDDEN);
		}
		return patients.get(id);
	}

	@Override
	public Response createPatient(Patient patient) {
		patient.setId(++currentId);
		patients.put(patient.getId(), patient);
		return Response.ok(patient).build();	// devuelve un codigo 200 = OK
	}

	@Override
	public Response updatePatient(Patient patient) {
		
		Patient currentPatient = patients.get(patient.getId());
		
		Response response;
		if(Objects.nonNull(currentPatient)) {
			patients.put(patient.getId(), patient);
			response = Response.ok().build();	// no es obligatorio enciar el objeto serializable
		}else {
			// response = Response.notModified().build();
			throw new PatientBusinessException();
		}
		return response;
	}

	@Override
	public Response deletePatient(Long id) {
		
		Patient currentPatient = patients.get(id);
		
		Response response;
		if(Objects.nonNull(currentPatient)) {
			patients.remove(id);
			response = Response.ok().build();	// no es obligatorio enciar el objeto serializable
		}else {
			 response = Response.notModified().build();	
		}
		return response;
	}
	
}
