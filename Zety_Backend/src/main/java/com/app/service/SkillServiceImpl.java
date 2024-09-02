package com.app.service;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.app.custum_exception.RersourseNotFoundException;
import com.app.dao.BesicDetailsDao;
import com.app.dao.SkillDao;
import com.app.dto.ApiResponse;
import com.app.dto.SkillDto;
import com.app.entity.BasicDetails;
import com.app.entity.Skill;

@Service
@Transactional
public class SkillServiceImpl implements SkillService {

	@Autowired
	private SkillDao dao;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	BesicDetailsDao basicDetailsDao;

	@Override
	public ApiResponse addSkills(SkillDto dto) {
		Skill skills = new Skill(dto.getSkills(), dto.getSkillType(), dto.getLanguages());
		BasicDetails details = basicDetailsDao.findById(dto.getUserId())
				.orElseThrow(() -> new RersourseNotFoundException("User not found"));

		details.addSkill(skills);
		dao.save(skills);
		return new ApiResponse("Skills added successfully");
	}

	@Override
	public List<SkillDto> getSkills(Long userId) {
		BasicDetails b = basicDetailsDao.findById(userId)
				.orElseThrow(() -> new RersourseNotFoundException("User Not Found"));

//		List<Skill> skills = b.getSkills();
//		System.out.println("Fetched Skills: " + skills);

		return b.getSkills().stream().map(skill -> {
			SkillDto dto = mapper.map(skill, SkillDto.class);
			dto.setSkills(skill.getSkills());
			dto.setSkillType(skill.getSkillType());
			dto.setUserId(userId);
			return dto;
		}).collect(Collectors.toList());
	}

	@Override
	public ApiResponse updateSkills(Long skillId, SkillDto dto) {
		Skill skill = dao.findById(skillId).orElseThrow(() -> new RersourseNotFoundException("Skill not found"));

		skill.setSkills(dto.getSkills());
		skill.setSkillType(dto.getSkillType());
		skill.setLanguages(dto.getLanguages());

		dao.save(skill); // Save the updated skill
		return new ApiResponse("Skills updated successfully");
	}

	@Override
	public ApiResponse deleteSkills(Long id) {

		Skill skill = dao.findById(id).orElseThrow(() -> new RersourseNotFoundException("Skill not found"));

		BasicDetails b = basicDetailsDao.findById(skill.getDetailsSkill().getId())
				.orElseThrow(() -> new RersourseNotFoundException("User Cannot be found"));

		dao.delete(skill);
		b.removeSkill(skill);
		return new ApiResponse("skills details deleted succsessfully");
	}

}
