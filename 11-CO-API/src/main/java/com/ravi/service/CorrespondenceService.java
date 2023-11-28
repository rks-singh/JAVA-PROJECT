package com.ravi.service;

import java.util.List;

import com.ravi.binding.CorrespondenceInfo;

public interface CorrespondenceService {

	public List<CorrespondenceInfo> getNotices(Integer caseNumber, String planStatus);

	public boolean printNotice(Integer noticeId);
}
