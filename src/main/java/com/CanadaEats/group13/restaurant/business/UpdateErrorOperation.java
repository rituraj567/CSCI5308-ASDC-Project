package com.CanadaEats.group13.restaurant.business;

import java.util.HashMap;
import java.util.Map;

import com.CanadaEats.group13.restaurant.config.RestaurantConstants;

public class UpdateErrorOperation implements IRestaurantState {

    @Override
    public Map<String, String> setMessage() {

        HashMap<String, String> map = new HashMap<>();

        map.put(RestaurantConstants.getErrorMessage(), RestaurantConstants.getUpdateFailure());
        return map;
    }

}
