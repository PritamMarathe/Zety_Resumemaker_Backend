package com.app.service;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.custum_exception.RersourseNotFoundException;
import com.app.dao.BesicDetailsDao;
import com.app.dao.ExperianceDao;
import com.app.dto.ApiResponse;
import com.app.dto.ExperianceDto;
import com.app.entity.BasicDetails;
import com.app.entity.Experiance;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ExperianceServiceImpl implements ExperianceService {
	@Autowired
    private ExperianceDao experiancedao;

    @Autowired
    private BesicDetailsDao besicDetailsdao;

    @Autowired
    private ModelMapper mapper;

    @Override
    public ApiResponse addExperiance(ExperianceDto dto) {
        Experiance e = mapper.map(dto, Experiance.class);
        BasicDetails b = besicDetailsdao.findById(dto.getUserId()).orElseThrow(() -> new RersourseNotFoundException("User not found"));
        e.setDetailsExperiance(b);
        experiancedao.save(e);
        return new ApiResponse("Experience Details added Successfully");
    }

    @Override
    public List<ExperianceDto> getExperiance(Long userId) {
        BasicDetails b = besicDetailsdao.findById(userId)
                .orElseThrow(() -> new RersourseNotFoundException("User Not Found"));

        return b.getExperiance().stream()
                .map(exp -> {
                    ExperianceDto dto = mapper.map(exp, ExperianceDto.class);
                    dto.setUserId(b.getId()); // Set userId from BesicDetails entity
                    return dto;
                })
                .collect(Collectors.toList());
    }

	@Override
	public ApiResponse updateExperience(Long id, ExperianceDto dto) {
		Experiance existingExperience=experiancedao.findById(id)
				.orElseThrow(()->new RersourseNotFoundException("Expereince not found"));
		mapper.map(dto,existingExperience );
		experiancedao.save(existingExperience);
		return new ApiResponse("experience details updated successfully");
	}

	@Override
	public ApiResponse deleteExperiance(Long id) {
		Experiance e = experiancedao.findById(id).orElseThrow(()->new RersourseNotFoundException("experiance cannot be found"));
		
		BasicDetails b = besicDetailsdao.findById(e.getDetailsExperiance().getId()).orElseThrow(()->new RersourseNotFoundException("user cannot be found"));
		
		experiancedao.delete(e);
		
		b.removeExperiance(e);
		
		return new ApiResponse("experiance details removed");
	}
}