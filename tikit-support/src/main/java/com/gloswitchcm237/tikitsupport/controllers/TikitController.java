package com.gloswitchcm237.tikitsupport.controllers;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gloswitchcm237.tikitsupport.models.Talk;
import com.gloswitchcm237.tikitsupport.models.Tikit;
import com.gloswitchcm237.tikitsupport.repositories.TalkRepositoy;
import com.gloswitchcm237.tikitsupport.repositories.TikitRepository;

@RestController
public class TikitController {
	@Autowired
	private TikitRepository tikitRepository;
	
	@Autowired
	private TalkRepositoy talkRepository;
	
	//get all tikits
		@GetMapping("/get_tikits")
	    public HashMap<String, Object> getTikits(){
	        HashMap<String, Object> map = new HashMap<>();
	        Iterable<Tikit> tikits = tikitRepository.findAll();
	        map.put("msg","Data Get Successfully");
	        map.put("data", tikits);
	        map.put("success",true);
	        map.put("error",false);
	        return map;
	    }
	
	//get tikit by id
	@GetMapping("/get_tikits/{id}")
    public HashMap<String, Object> getTikit(@PathVariable("id") int id){
        HashMap<String, Object> map = new HashMap<>();
        Tikit tikit = tikitRepository.findById(id).get();
        map.put("msg","Data Get Successfully");
        map.put("data", tikit);
        map.put("success",true);
        map.put("error",false);
        return map;
    }
	
	@GetMapping("/tikits_by_user/{id}")
    public HashMap<String, Object> tikitByUser(@PathVariable("id") int idUser){
        HashMap<String, Object> map = new HashMap<>();
        List<Tikit> tikits = tikitRepository.TikitByUserId(idUser);

        map.put("msg","Data Get Successfully");
        map.put("data",tikits);
        map.put("success",true);
        map.put("error",false);
        return map;
    }

    @GetMapping("/tikits_by_status/{status}")
    public HashMap<String, Object> tikitByStatus(@PathVariable("status") String status){
        HashMap<String, Object> map = new HashMap<>();
        List<Tikit> tikits = tikitRepository.TikitByUserStatus(status);

        map.put("msg","Data Get Successfully");
        map.put("data",tikits);
        map.put("success",true);
        map.put("error",false);
        return map;
    }
	
	//add tikit
	@PostMapping("add_tikit")
    public HashMap<String, Object> addTikit(@RequestBody Map<String,String> requestBody){
        HashMap<String, Object> map = new HashMap<>();

        Tikit newTikit = new Tikit();
        newTikit.setUserId(Integer.parseInt(requestBody.get("userId")));
        newTikit.setAttach(requestBody.get("attach"));
        newTikit.setSubject(requestBody.get("subject"));
        newTikit.setBody(requestBody.get("body"));
        newTikit.setStatus("pending");
        newTikit.setCreated_at(LocalDateTime.now());

        tikitRepository.save(newTikit);

        map.put("msg","Tikit Add Successfully");
        map.put("success",true);
        map.put("error",false);
        return map;
    }

    @PostMapping("add_talk/{id}")
    public HashMap<String, Object> addTalk(@PathVariable("id") int id ,@RequestBody Map<String,String> requestBody){
        HashMap<String, Object> map = new HashMap<>();

        Tikit newTikit = tikitRepository.findById(id).get();
        Talk talk = new Talk();
        talk.setUserId(Integer.parseInt(requestBody.get("userId")));
        talk.setText(requestBody.get("text"));
        talk.setTikit(newTikit);
        talk.setSend_at(LocalDateTime.now());

        talkRepository.save(talk);

        map.put("msg","Talk Add Successfully");
        map.put("success",true);
        map.put("error",false);
        return map;
    }
	
	@GetMapping(value = "/talks")
	public HashMap<String, Object> getTalks() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("msg", "Get data");
		map.put("data", talkRepository.findAll());
		return map;
	}
}
