package com.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.app.dto.ApiResponse;
import com.app.dto.ExperianceDto;
import com.app.dto.SkillDto;
import com.app.service.SkillService;

@CrossOrigin
@RestController
@RequestMapping("user")
public class SkillController {

    @Autowired
    private SkillService skillService;
    

	@PostMapping("addSkills")
	public ResponseEntity<?> addSkillsDetails(@RequestBody SkillDto dto){
	    System.out.println("Received SkillDto: " + dto);
		System.out.println("inskill controller");
		 return ResponseEntity.status(HttpStatus.CREATED)
		            .contentType(MediaType.APPLICATION_JSON)
		            .body(skillService.addSkills(dto));
		
	}
	
	@GetMapping("getSkills/{userId}")
	public ResponseEntity<?> getSkillsDetails(@PathVariable Long userId){
		
		return ResponseEntity.ok(skillService.getSkills(userId)); 
	}

    @PutMapping("updateSkills/{skillId}")
    public ResponseEntity<?> updateSkillsDetails(@PathVariable Long skillId, @RequestBody SkillDto dto){
        return ResponseEntity.ok(skillService.updateSkills(skillId, dto));
    }
    
    @DeleteMapping("deleteSkills/{skillId}")
    public ResponseEntity<?>deleteSkillsDetails(@PathVariable Long skillId){
    	
    	return ResponseEntity.ok(skillService.deleteSkills(skillId));
    }

}
