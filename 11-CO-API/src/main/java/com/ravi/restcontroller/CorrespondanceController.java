package com.ravi.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ravi.binding.CorrespondenceInfo;
import com.ravi.service.CorrespondenceService;

@RestController
public class CorrespondanceController {

	@Autowired
	private CorrespondenceService correspondenceService;
	
	@GetMapping(value = "/notices/{caseNumber}/{planStatus}", produces = "application/json")
	public ResponseEntity<List<CorrespondenceInfo>> getNotices(@PathVariable Integer caseNumber, @PathVariable String planStatus){
		List<CorrespondenceInfo> notices = correspondenceService.getNotices(caseNumber, planStatus);
		return new ResponseEntity<>(notices,HttpStatus.OK);
	}
	
	@GetMapping(value = "/print-notice/{noticeId}", produces = "text/plain")
	public ResponseEntity<String> printNotice(@PathVariable Integer noticeId){
		boolean status = correspondenceService.printNotice(noticeId);
		if(status) {
			return new ResponseEntity<>("Notice Printed!!",HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Notice Not Printed!!",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
