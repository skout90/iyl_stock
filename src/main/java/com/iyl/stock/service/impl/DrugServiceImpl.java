package com.iyl.stock.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iyl.stock.dto.DrugDto;
import com.iyl.stock.mapper.DrugMapper;

@Service("drugService")
public class DrugServiceImpl  {

	@Autowired(required = false)
	DrugMapper drugMapper;

	public ArrayList<DrugDto> selectDrug() {

		ArrayList<DrugDto> drugResult = drugMapper.selectDrugInfo();

		return drugResult;

	}

}
