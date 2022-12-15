package com.CanadaEats.group13.utils;

public class StatePatternConstants {
    private static final String SUCCESS = "SUCCESS";
    private static final String ERROR = "ERROR";
    private static final String INSERT_SUCCESS = "Data inserted successfully";
    private static final String INSERT_ERROR = "Duplicate records error";
    private static final String UPDATE_SUCESS = "Update data success";
    private static final String UPDATE_FAILURE = "Update failed";
    private static final String DELETE_SUCCESS = "Delete Success";
    private static final String DELETE_FAILURE = "Delete Failure";

    public static String getSuccessMessage() {
        return SUCCESS;
    }

    public static String getErrorMessage() {
        return ERROR;
    }

    public static String getInsertSuccess() {
        return INSERT_SUCCESS;
    }

    public static String getInsertError() {
        return INSERT_ERROR;
    }

    public static String getUpdateSuccess() {
        return UPDATE_SUCESS;
    }

    public static String getUpdateFailure() {
        return UPDATE_FAILURE;
    }

    public static String getDeleteSuccess() {
        return DELETE_SUCCESS;
    }

    public static String getDeleteFailure() {
        return DELETE_FAILURE;
    }
}
