package com.CanadaEats.group13.restaurant.business;

public interface IOperationsFactory {
    public IRestaurantState createDeleteErrorOperation();

    public IRestaurantState createDeleteSuccessOperation();

    public IRestaurantState createInsertErrorOperation();

    public IRestaurantState createInsertSuccessOperation();

    public IRestaurantState createUpdateErrorOperation();

    public IRestaurantState createUpdateSuccessOperation();
}
