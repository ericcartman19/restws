package com.bharath.restws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.bharath.restws.model.Patient;

@Path("/patientservice")	// este es el realtive url que el cliente utilizar'a
public interface PatientService {

	@Path("/patients")
	@GET
	List<Patient> getPatients();
	
}
