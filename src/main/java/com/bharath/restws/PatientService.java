package com.bharath.restws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.bharath.restws.model.Patient;

@Path("/patientservice")	// este es el realtive url que el cliente utilizar'a
public interface PatientService {

	@Path("/patients")
	@GET
	List<Patient> getPatients();
	
	@Path("/patients/{id}")
	@GET
	Patient getPatient(@PathParam(value = "id") Long id);	// @PathParam bind the method parameter to he path variable
	
	@Path("/patients")
	@POST
	Response createPatient(Patient patient);
	
	
}
