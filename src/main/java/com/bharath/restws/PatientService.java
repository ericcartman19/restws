package com.bharath.restws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.bharath.restws.model.Patient;

@Consumes("application/xml,application/json")
@Produces("application/xml, application/json")
@Path("/patientservice")	// este es el realative url que el cliente utilizar'a
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
	
	@Path("/patients")
	@PUT
	Response updatePatien(Patient patient);
	
	@Path("/patients/{id}")
	@DELETE
	Response deletePatien(@PathParam("id") Long id);
}
