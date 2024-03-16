package com.saku.onlineprototype.controller;

import com.saku.onlineprototype.dto.ActivityRequest;
import com.saku.onlineprototype.dto.ActivityResponse;
import com.saku.onlineprototype.dto.UserResponse;
import com.saku.onlineprototype.repository.ActivityRepository;
import com.saku.onlineprototype.service.ActivityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;

@RestController
@Slf4j
@RequestMapping("/api/activity")
@RequiredArgsConstructor
public class ActivityController {
    private final ActivityService activityService;
    @PostMapping("")
    public ResponseEntity<ActivityResponse> createActivity(@RequestBody ActivityRequest request) throws InvocationTargetException, IllegalAccessException {
        ActivityResponse response = activityService.createActivity(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @GetMapping("/{activityID}")
    public ResponseEntity<ActivityResponse> getActivity(@PathVariable String activityID){
        ActivityResponse response = activityService.getActivity(activityID);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @PutMapping("/{activityID}")
    public ResponseEntity<ActivityResponse> updateActivity(@PathVariable String activityID,@RequestBody ActivityRequest request){
        ActivityResponse response = activityService.updateActivity(activityID, request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
