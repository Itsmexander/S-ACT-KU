package com.saku.onlineprototype.service;

import com.saku.onlineprototype.dto.ActivityRequest;
import com.saku.onlineprototype.dto.ActivityResponse;
import com.saku.onlineprototype.entity.Activity;
import com.saku.onlineprototype.repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;

import static org.apache.commons.beanutils.BeanUtils.copyProperties;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private final ActivityRepository activityRepository;
    @Override
    public Activity saveActivity(Activity activity) {
        log.info("Saving new Activity {} to the database.",activity.getActivityID());
        return activityRepository.save(activity);
    }

    @Override
    public ActivityResponse createActivity(ActivityRequest request) throws InvocationTargetException, IllegalAccessException {
        Activity activity = new Activity();
        copyProperties(request,activity);
        return ActivityResponse.from(activity);
    }

    @Override
    public ActivityResponse getActivity(String activityID) {
        Activity activity = activityRepository.findById(activityID).orElseThrow();
        return ActivityResponse.from(activity);
    }

    @Override
    public ActivityResponse updateActivity(String activityID, ActivityRequest request) {
        Activity activity = activityRepository.findById(activityID).orElseThrow();
        activity.setProjNameTH(request.getProjNameTH());
        activity.setProjNameEN(request.getProjNameEN());
        activity.setActivityStartDateTime(request.getActivityStartDateTime());
        activity.setActivityEndDateTime(request.getActivityEndDateTime());
        activity.setActivityID(request.getActivityLocation());
        activity.setActivityDescription(request.getActivityDescription());
        activity.setAllocatedMoneyFY(request.getAllocatedMoneyFY());
        activity.setAllocatedMoneyAddition(request.getAllocatedMoneyAddition());
        activity.setAllocatedMoneyEx(request.getAllocatedMoneyEx());
        activity.setUsedAllocate(request.getUsedAllocate());
        activity.setStaffTargetNum(request.getStaffTargetNum());
        activity.setAttendTargetNum(request.getAttendTargetNum());
        activity.setStaffAttendedNum(request.getStaffAttendedNum());
        activity.setAttendedNum(request.getAttendedNum());
        activity.setStaffAttendedPerc(request.getStaffAttendedPerc());
        activity.setAttendedPerc(request.getAttendedPerc());
        activity.setStaffApproveRate(request.getStaffApproveRate());
        activity.setAttendedApproveRate(request.getAttendedApproveRate());
        activity.setActivityHour(request.getActivityHour());
        activity.setTqfType(request.getTqfType());
        activity.setSdgTypes(request.getSdgTypes());
        activity.setKingPhilosophyType(request.getKingPhilosophyType());
        return null;
    }
}
