package com.CanadaEats.group13.filter.repository;

import com.CanadaEats.group13.database.DatabaseConnection;
import com.CanadaEats.group13.database.IDatabaseConnection;
import com.CanadaEats.group13.filter.dto.FilterDto;
import com.CanadaEats.group13.utils.ApplicationConstants;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FilterRepository implements IFilterRepository {
    IDatabaseConnection databaseConnection;
    Connection connection;
    Statement statement;
    ResultSet filterResult;

    public FilterRepository(IDatabaseConnection databaseConnection){
        this.databaseConnection = databaseConnection;
    }
    @Override
    public List<FilterDto> getAllFilters() {
        List<FilterDto> filtersDtoList = new ArrayList<>();

        try {
            databaseConnection = DatabaseConnection.getInstance();
            connection = databaseConnection.getDatabaseConnection();
            statement = connection.createStatement();
            String getfilters = "select * from Filter";
            filterResult = statement.executeQuery(getfilters);

            while (filterResult.next()) {
                String filterName = filterResult.getString(ApplicationConstants.FILTER_NAME_COLUMN);
                int filterIsActive = Integer.parseInt(filterResult.getString(ApplicationConstants.FILTER_ISACTIVE_COLUMN));
                filtersDtoList.add(new FilterDto(filterName, filterIsActive));
            }

            System.out.println("Filters: ");
            for (FilterDto filter : filtersDtoList) {
                System.out.println(filter.getFilterName() + filter.getIsActive());
            }
        }
        catch (Exception ex)
        {
            System.out.println("Exception : FilterRepository - getAllFilters()");
            System.out.println(ex);
            System.out.println(ex.getMessage());
        }
        finally
        {
            try{
                connection.close();
                statement.close();
                filterResult.close();
            }
            catch (Exception ex){
                System.out.println("Exception : FilerRepository - Closing database connection in getAllFilters()");
            }
        }
        return filtersDtoList;
    }

    public List<FilterDto> updateFilters(List<FilterDto> filterDtos)
    {
        try {
            databaseConnection = DatabaseConnection.getInstance();
            connection = databaseConnection.getDatabaseConnection();
            statement = connection.createStatement();
            String getfilters = "select * from Filter";
            filterResult = statement.executeQuery(getfilters);

            while (filterResult.next())
            {
                String currFilterName = filterResult.getString(ApplicationConstants.FILTER_NAME_COLUMN);
                int currFilterActive = Integer.parseInt(filterResult.getString(ApplicationConstants.FILTER_ISACTIVE_COLUMN));

                FilterDto currFilter = filterDtos.stream()
                        .filter(x -> currFilterName.equals(x.getFilterName()))
                        .findAny()
                        .orElse(null);

                String filterName = currFilter.getFilterName();
                int isActive = currFilter.getIsActive();

                System.out.println("OldFilterName : " + currFilterName);
                System.out.println("OldFilterIsActive : " + currFilterActive);

                System.out.println("NewFilterName : " + filterName);
                System.out.println("NewFilterIsActive : " + isActive);
                System.out.println("---------------------------------");
                filterResult.updateString("Name", filterName);
                filterResult.updateInt("IsActive", isActive);

                filterResult.updateRow();
            }
        }
        catch (Exception ex)
        {
            System.out.println("Exception : FilterRepository - updateFilters()");
            System.out.println(ex);
            System.out.println(ex.getMessage());
        }
        finally{
            try{
                connection.close();
                statement.close();
                filterResult.close();
            }
            catch (Exception ex){
                System.out.println("Exception : FilerRepository - Closing database connection in updateFilters()");
            }
        }
        return filterDtos;
    }
}
