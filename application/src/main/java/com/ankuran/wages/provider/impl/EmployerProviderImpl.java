package com.ankuran.wages.provider.impl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ankuran.wages.mapper.EmployeeMapper;
import com.ankuran.wages.model.EmployeeDao;
import com.ankuran.wages.model.response.EmployeeResponseDTO;
import com.ankuran.wages.provider.EmployeeProvider;
import com.ankuran.wages.repository.EmployeeRepository;


@Component
public class EmployerProviderImpl implements EmployeeProvider {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public EmployeeResponseDTO fetchEmployeeByCentreIDAndFullName(Long centreId, String fullName) {
        EmployeeDao employeeDao =  employeeRepository.findByCentreIdAndAndFullName(centreId, fullName);
        EmployeeResponseDTO employeeResponseDTO = employeeMapper.mapEmployeeDaoToDTO(employeeDao);
        return employeeResponseDTO;
    }
    
    @Override
    public EmployeeResponseDTO fetchEmployeeByCentreIDAndEmployeeId(Long centreId, Long employeeId) {
        EmployeeDao employeeDao =  employeeRepository.findByCentreIdAndId(centreId, employeeId);
        EmployeeResponseDTO employeeResponseDTO = employeeMapper.mapEmployeeDaoToDTO(employeeDao);
        return employeeResponseDTO;
    }

	@Override
	public List<EmployeeResponseDTO> fetchEmployeesByCentreID(Long centreId) {
		List<EmployeeDao> employeeDaoList = employeeRepository.findAllByCentreId(centreId);
		List<EmployeeResponseDTO> employeeResponseDTOs = employeeDaoList.stream().filter(Objects::nonNull).map(x -> employeeMapper.mapEmployeeDaoToDTO(x)).collect(Collectors.toList());
		return employeeResponseDTOs;
	}

}