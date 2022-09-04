package com.mindtree.doctorservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.mindtree.doctorservice.entity.DoctorEntity;
import com.mindtree.doctorservice.pojo.Doctor;
import com.mindtree.doctorservice.pojo.Patient;
import com.mindtree.doctorservice.repository.DoctorRepository;

@Service
public class DoctorService {
	
	@Autowired
	private DoctorRepository repository;
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	public void saveDoctor(DoctorEntity doctor) {
		repository.save(doctor);
	}
	
	public List<Doctor> getAllDoctors(){
		List<DoctorEntity> doctorEntities = repository.findAll();
		List<Doctor> doctors = new ArrayList<>();
		for(DoctorEntity doc: doctorEntities) {
			Doctor newDoc = new Doctor();
			newDoc.setId(doc.getId());
			newDoc.setName(doc.getName());
			newDoc.setGender(doc.getGender());
			newDoc.setAge(doc.getAge());
			newDoc.setSpecialised(doc.getSpecialised());
			doctors.add(newDoc);
		}
		for(Doctor doc: doctors) {
			List<Patient> ls = webClientBuilder.build().get()
					.uri("http://localhost:8020/PATIENT-SERVICE/getPatientList/"+doc.getId())
					.retrieve()
					.bodyToMono(new ParameterizedTypeReference<List<Patient>>() {})
					.block();
			doc.setNoOfPatientVisited(ls.size());
		}
		return doctors;
	}
	
	public DoctorEntity getDoctor(int id) {
		Optional<DoctorEntity> docOptional =repository.findById(id);
		return docOptional.get();
	}
}
