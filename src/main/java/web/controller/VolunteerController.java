package web.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;

import web.data.VolunteerRepository;
import web.data.model.Field;
import web.data.model.Volunteer;
import web.service.VolunteerService;
import web.util.FieldUtil;

@Controller
@RequestMapping(value = "/volunteer")
public class VolunteerController extends AbstractController {

	@Autowired
	private VolunteerService volunteerService;
	
	@Autowired
	private VolunteerRepository volunteerRepository;

	@RequestMapping(method = RequestMethod.GET, value = "/listvolunteer")
	public ModelAndView listVolunteer() throws InterruptedException {
		ModelAndView model = new ModelAndView();
		
		model.addObject("resultMap", volunteerService.listVolunteers());
		model.setViewName("listvolunteer");
		return model;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/addvolunteer")
	public ModelAndView addVolunteer() throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		ModelAndView model = new ModelAndView();
		model.addObject("volunteer", new Volunteer());
		model.setViewName("addvolunteer");
		return model;
	}

	@RequestMapping(value = "/volunteerdetails/{id}", method = RequestMethod.GET)
	public ModelAndView volunteerDetails(@PathVariable Integer id)
			throws JsonParseException, JsonMappingException, IOException {
		Volunteer volunteer = volunteerRepository.findOne(id);
		
		return new ModelAndView("viewvolunteer", "volunteer", volunteer);
	}

	@RequestMapping(value = "/modifyvolunteer/{id}", method = RequestMethod.GET)
	public ModelAndView volunteerdetail(@PathVariable Integer id)
			throws JsonParseException, JsonMappingException, IOException {
		Volunteer volunteer = volunteerRepository.findOne(id);
		
		return new ModelAndView("addvolunteer", "volunteer", volunteer);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/savevolunteer")
	public ModelAndView saveVolunteer(@ModelAttribute Volunteer t, BindingResult result, ModelMap modelMap)
			throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		String jsonStr = getMapper().writeValueAsString(t);
		Volunteer volunteer = getMapper().readValue(jsonStr, Volunteer.class);
		//volunteer.setDetails(getMapper().writeValueAsString(FieldUtil.filterFields(volunteer.getFields())));

		volunteerRepository.save(volunteer);
		return listVolunteer();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/deletevolunteer")
	public ModelAndView deleteVolunteer(@ModelAttribute("id") Integer id) {
		volunteerRepository.delete(id);
		ModelAndView model = new ModelAndView();
		model.addObject("list", volunteerRepository.findAll());
		model.setViewName("listvolunteer");
		return model;
	}
	
	@RequestMapping(value = "/searchVolunteer/{name}", method = RequestMethod.GET)
	public ModelAndView volunteerdetail(@PathVariable String name)
			throws JsonParseException, JsonMappingException, IOException {
		//List<Volunteer> volunteers = volunteerRepository.findByVolunteerName(name);
		
		return new ModelAndView("viewvolunteer", "volunteers", null);
	}

}
