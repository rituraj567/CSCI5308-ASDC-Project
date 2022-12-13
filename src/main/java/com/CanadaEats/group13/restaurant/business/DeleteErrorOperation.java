package com.CanadaEats.group13.restaurant.business;

import java.util.HashMap;
import java.util.Map;

import com.CanadaEats.group13.utils.StatePatternConstants;

public class DeleteErrorOperation implements IRestaurantState {

    @Override
    public Map<String, String> setMessage() {
        HashMap<String, String> map = new HashMap<>();

        map.put(StatePatternConstants.getErrorMessage(), StatePatternConstants.getDeleteFailure());
        return map;
    }

}
