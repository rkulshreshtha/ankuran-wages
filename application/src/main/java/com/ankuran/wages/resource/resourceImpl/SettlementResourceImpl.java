package com.ankuran.wages.resource.resourceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.ankuran.wages.HelperUtil;
import com.ankuran.wages.model.response.SettlementDTO;
import com.ankuran.wages.model.response.SettlementsDTO;
import com.ankuran.wages.provider.SettlementProvider;
import com.ankuran.wages.resource.SettlementResource;

@Component
public class SettlementResourceImpl implements SettlementResource {
	
	@Autowired
	SettlementProvider settlementProvider;

	@Override
	public ResponseEntity<SettlementsDTO> addSettlement(Long centreId, SettlementDTO settlementDTO) {
		settlementDTO.setCentreId(centreId);
		SettlementDTO savedSettlement = settlementProvider.addSettlement(settlementDTO);
		if (savedSettlement != null && savedSettlement.getId() != null && savedSettlement.getId() > 0) {
			return new ResponseEntity<SettlementsDTO>(new SettlementsDTO(new ArrayList<>(Arrays.asList(savedSettlement))), HttpStatus.CREATED);
		} else if (savedSettlement != null && savedSettlement.getId() != null && savedSettlement.getId() == 0) {
			return new ResponseEntity<SettlementsDTO>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<SettlementsDTO>(HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<SettlementsDTO> getSettlements(Long centreId, String lowerTimeCreated,
			String upperTimeCreated) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Pair<Date, Date> timeRange = HelperUtil.getTimeRange(sdf.parse(lowerTimeCreated), sdf.parse(upperTimeCreated));
		List<SettlementDTO> settlements = settlementProvider.getSettlements(centreId, timeRange.getLeft(), timeRange.getRight());
		return new ResponseEntity<SettlementsDTO>(new SettlementsDTO(settlements), HttpStatus.OK);
	}
	

}
