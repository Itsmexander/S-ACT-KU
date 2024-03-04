package com.saku.onlineprototype.service;

import com.saku.onlineprototype.dto.ActivityRequest;
import com.saku.onlineprototype.dto.ActivityResponse;
import com.saku.onlineprototype.entity.Activity;

import java.lang.reflect.InvocationTargetException;

public interface ActivityService {

    Activity saveActivity(Activity activity);
    ActivityResponse createActivity(ActivityRequest request) throws InvocationTargetException, IllegalAccessException;
    ActivityResponse getActivity(String activityID);
    ActivityResponse updateActivity(String activityID, ActivityRequest request);
}
