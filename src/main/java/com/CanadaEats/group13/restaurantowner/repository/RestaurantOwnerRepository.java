package com.CanadaEats.group13.restaurantowner.repository;


import com.CanadaEats.group13.database.IDatabaseConnection;
import com.CanadaEats.group13.restaurantowner.dto.RestaurantOwnerDto;
import com.CanadaEats.group13.utils.ApplicationConstants;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RestaurantOwnerRepository implements IRestaurantOwnerRepository {

    IDatabaseConnection databaseConnection;
    Connection connection;
    Statement statement;
    ResultSet result;
    public RestaurantOwnerRepository(IDatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public List<RestaurantOwnerDto> getAllMenus(String restaurantId){
        List<RestaurantOwnerDto> response =  new ArrayList<>();
        try
        {
            connection = databaseConnection.getDatabaseConnection();
            statement = connection.createStatement();
            String getMenus = "SELECT m.MenuId,m.Name, r.RestaurantId, r.Name as RestaurantName FROM CSCI5308_13_DEVINT.Menu as m join CSCI5308_13_DEVINT.Restaurant as r on m.Restaurant_RestaurantId = r.RestaurantId where m.Restaurant_RestaurantId = '" + restaurantId + "'";
            result = statement.executeQuery(getMenus);

            try
            {
                while (result.next()) {
                    RestaurantOwnerDto restaurantOwnerDto = new RestaurantOwnerDto();
                    restaurantOwnerDto.setMenuId(result.getString(ApplicationConstants.MENU_MENUID_COLUMN));
                    restaurantOwnerDto.setName(result.getString(ApplicationConstants.MENU_MENUNAME_COLUMN));
                    restaurantOwnerDto.setRestaurantId(result.getString(ApplicationConstants.RESTAURANT_RESTAURANTID_COLUMN));
                    restaurantOwnerDto.setRestaurantName(result.getString(ApplicationConstants.RESTAURANT_RESTAURANTNAME_COLUMN));
                    response.add(restaurantOwnerDto);
                }
            }
            catch (Exception ex)
            {
                System.out.println(ex);
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
        return response;
    }
}
