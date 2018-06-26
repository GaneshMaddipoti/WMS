package web.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.data.VolunteerRepository;
import web.data.model.Volunteer;

@Service
public class VolunteerService {
	
	@Autowired
	private VolunteerRepository volunteerRepository;
	
	public Map<String, List<Volunteer>>  listVolunteers() {
		Map<String, List<Volunteer>> resultMap = new HashMap<String, List<Volunteer>>();             

		for (Volunteer volunteer : volunteerRepository.findAll()) {
			if (resultMap.get(volunteer.getType()) == null) {
				List<Volunteer> volunteers = new ArrayList<Volunteer>();
				volunteers.add(volunteer);
				resultMap.put(volunteer.getType(), volunteers);
			} else {
				List<Volunteer> volunteers = resultMap.get(volunteer.getType());
				volunteers.add(volunteer);
			}
		}
		return resultMap;
	}

}
