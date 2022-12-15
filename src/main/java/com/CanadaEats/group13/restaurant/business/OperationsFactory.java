package com.CanadaEats.group13.restaurant.business;

public class OperationsFactory implements IOperationsFactory {

    private static IOperationsFactory instance = null;

    private OperationsFactory() {

    }

    public static IOperationsFactory getInstance() {
        if (instance == null) {
            instance = new OperationsFactory();
        }
        return instance;
    }

    @Override
    public IRestaurantState createDeleteErrorOperation() {
        return new DeleteErrorOperation();
    }

    @Override
    public IRestaurantState createDeleteSuccessOperation() {

        return new DeleteSuccessOperation();
    }

    @Override
    public IRestaurantState createInsertErrorOperation() {

        return new InsertErrorOperation();
    }

    @Override
    public IRestaurantState createInsertSuccessOperation() {

        return new InsertSucessOperation();
    }

    @Override
    public IRestaurantState createUpdateErrorOperation() {

        return new UpdateErrorOperation();
    }

    @Override
    public IRestaurantState createUpdateSuccessOperation() {

        return new UpdateSucessOperation();
    }

}
