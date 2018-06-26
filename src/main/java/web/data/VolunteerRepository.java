package web.data;

import org.springframework.data.repository.CrudRepository;

import web.data.model.Volunteer;

public interface VolunteerRepository extends CrudRepository<Volunteer, Integer> {

}
