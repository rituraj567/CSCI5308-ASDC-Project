package com.CanadaEats.group13.utils;

public class ApplicationConstants {
    public static final String ADMIN_ROLEID = "0ab745f3-4d0b-472c-9050-986412813900";
    public static final String RESTAURANT_OWNER_ROLEID = "086ba4a8-694c-4da0-8932-5998bc8c43cb";
    public static final String CUSTOMER_ROLEID = "407b779e-dc99-4607-83e9-6f3a1716b3ca";
    public static final String DELIVERY_PERSON_ROLEID = "5941532b-da1d-427a-85d0-18cb44bd2932";
    public static final int ACTIVE_STATUS = 1;
    public static final String FILTER_NAME_COLUMN = "Name";
    public static final String FILTER_ISACTIVE_COLUMN = "IsActive";
    public static final String USER_PASSWORD_COLUMN = "Password";
    public static final String USER_ROLEID_COLUMN = "Role_RoleId";
    public static final String USER_USERNAME_COLUMN = "UserName";
    public static final String USER_USERID_COLUMN = "UserId";
    public static final String MENU_MENUID_COLUMN = "MenuId";
    public static final String MENU_MENUNAME_COLUMN = "Name";

    public static final String MENUITEM_MENUITEMID_COLUMN = "MenuItemId";
    public static final String MENUITEM_NAME_COLUMN = "Name";
    public static final String MENUITEM_DESCRIPTION_COLUMN = "Description";
    public static final String MENUITEM_PRICE_COLUMN = "Price";
    public static final String MENUITEM_MENUID_COLUMN = "Menu_MenuId";

    public static final String MENUITEM_RESTAURANTID_COLUMN = "Restaurant_RestaurantId";

    public static final String RESTAURANT_RESTAURANTID_COLUMN = "RestaurantId";
    public static final String RESTAURANT_RESTAURANTNAME_COLUMN = "RestaurantName";

    public static final String COOKIE_USERNAME = "username";
    public static final String COOKIE_ROLEID = "roleid";

    public static final String COOKIE_USERID = "userid";
    public static final String COOKIE_ROLENAME = "rolename";
    public static final String COOKIE_RESTAURANTID = "restaurantid";

    public static final String ADMIN_ROLE = "Admin";

    public static final String CUSTOMER_ROLE = "Customer";

    public static final String RESTAURANT_OWNER_ROLE = "RestaurantOwner";

    public static final String DELIVERY_PERSON_ROLE = "DeliveryPerson";
    public static final String COOKIE_EMPTY_STRING = "";
    public static final int COOKIE_MAX_AGE = 0;
    public static final String COOKIE_ROOT_PATH = "/";
    public static final String CREDIT_CARD = "b340b7b1-465e-439a-9a06-a6ee7785b7fb";
    public static final String DEBIT_CARD = "7b655d6c-b4f8-4839-be8d-76e58ae9835b";
    public static final String CASH = "e1f1b8e7-1c25-4918-b4f2-5ec0811e43cc";
    public static final String RESTAURANT_ID = "Id";
    public static final String RESTAURANT_UUID = "RestaurantId";
    public static final String RESTAURANT_NAME = "Name";
    public static final String RESTAURANT_ADDRESS = "Address";
    public static final String RESTAURANT_CITY = "City";
    public static final String RESTAURANT_PROVINCE = "Province";
    public static final String RESTAURANT_COUNTRY = "Province";
    public static final String RESTAURANT_POSTAL_CODE = "PostalCode";
    public static final String RESTAURANT_PHONE_NUMBER = "PhoneNumber";
    public static final String RESTAURANT_STATUS = "Status";
    public static final String RESTAURANT_USER_ID = "User_UserId";
    public static final String ENCRYPTION_KEY = "ThisIsGroup13EncryptionKey";

    public static final String URL_AUTHENTICATION_REGISTERUSER = "authentication/registerUser";
    public static final String URL_AUTHENTICATION_USERLOGINPAGE = "redirect:/userloginpage";
    public static final String URL_AUTHENTICATION_REGISTERUSERERROR = "authentication/registerUserError";
    public static final String URL_AUTHENTICATION_LOGINUSER = "authentication/loginUser";
    public static final String URL_AUTHENTICATION_ADMINUSERHOMEPAGE = "redirect:/adminuserhomepage";
    public static final String URL_AUTHENTICATION_RESTAURANTOWNERHOMEPAGE = "redirect:/restaurantownerhomepage";
    public static final String URL_AUTHENTICATION_USERHOMEPAGE = "redirect:/userHomePage";
    public static final String URL_AUTHENTICATION_ORDER = "redirect:/order";
    public static final String URL_AUTHENTICATION_USERLOGINERRORPAGE = "redirect:/userloginerrorpage";
    public static final String URL_AUTHENTICATION_LOGINUSERERROR = "authentication/loginUserError";
    public static final String URL_AUTHENTICATION_USERVIEWPROFILE = "common/userViewProfile";
    public static final String URL_AUTHENTICATION_EDITPROFILE = "common/editProfile";
    public static final String URL_AUTHENTICATION_VIEWPROFILE = "redirect:/viewProfile";
    public static final String URL_AUTHENTICATION_ADMINHOMEPAGE = "utils/adminuserhomepage";
    public static final String URL_AUTHENTICATION_USERREGISTRATIONERRORPAGE = "redirect:/userregistrationerrorpage";

    public static final String URL_RESTAURANT_SUCCESS = "/restaurants/restaurant";
    public static final String URL_RESTAURANT_CREATION = "restaurants/newRestuarant";

    public static final String URL_RESTAURANT_EDIT_SUCCESS = "restaurants/editRestaurant";
    public static final String URL_RESTAURANTS_DELETE_SUCCESS = "redirect:/restaurants";

    public static final String URL_RESTAURANTS_VIEW_SUCCESS = "restaurants/viewRestaurant";
    public static final String URL_RESTAURANTS_SEARCH_SUCCESS = "restaurants/restaurant";
    public static final String URL_RESTAURANT_POST_CREATION = "redirect:/restaurants";
    public static final String URL_RESTAURANT_CUSTOMER_HOME_PAGE = "customer/customerHomePage";
    public static final String URL_RESTAURANT_RESTAURANT_DISPLAY = "customer/restaurantDisplayPage";
    public static final String URL_RESTAURANT_CHECKOUT = "customer/checkoutPage";

    public static final String URL_FILTER_DISPLAYFILTERS = "/filter/displayFilters";
    public static final String URL_FILTER_FILTERS = "redirect:/filters";
    public static final String URL_RESTAURANTOWNER_RESTAURANTOWNERHOMEPAGE = "restaurantowner/restaurantOwnerHomePage";
    public static final String URL_RESTAURANTOWNER_NEWMENUPAGE = "restaurantowner/newMenuPage";
    public static final String URL_RESTAURANTOWNER_RESTOWNERHOMEPAGE = "redirect:/restaurantownerhomepage";
    public static final String URL_RESTAURANTOWNER_ADDMENUERROR = "restaurantowner/addMenuError";
    public static final String URL_RESTAURANTOWNER_NEWMENUITEMPAGE = "restaurantowner/newMenuItemPage";
    public static final String URL_RESTAURANTOWNER_MENUITEMS = "restaurantowner/menuItems";

    public static final String URL_RESTAURANTOWNERADMIN_HOMEPAGE = "restaurantOwnersAdmin/restaurantOwnerAdmin";
    public static final String URL_RESTAURANTOWNERADMIN_NEW = "restaurantOwnersAdmin/newRestaurantOwnerAdmin";
    public static final String URL_RESTAURANTOWNERADMIN_EDIT = "restaurantOwnersAdmin/editRestaurantOwner";
    public static final String URL_RESTAURANTOWNERADMIN_POST_SUCCESS = "redirect:/restaurantOwners";
    public static final String URL_RESTAURANTOWNERADMIN_DELETE_SUCCESS = "redirect:/restaurantOwners";
    public static final String URL_RESTAURANTOWNERADMIN_VIEW = "restaurantOwnersAdmin/viewRestaurantOwnerAdmin";
    public static final String URL_RESTAURANTOWNERADMIN_BIND = "redirect:/restaurantOwners";

    public static final String ORDER_ID = "Id";
    public static final String ORDER_ORDER_ID = "OrderId";
    public static final String ORDER_USER_ID = "UserId";
    public static final String ORDER_RESTUARANT_ID = "RestaurantId";
    public static final String ORDER_DELIVERY_PERSON_ID = "DeliveryPersonId";
    public static final String ORDER_TOTAL_AMOUNT_ID = "Total_Amount";
    public static final String ORDER_STATUS_ID = "OrderStatusId";
    public static final String ORDER_PAYMENT_OPTION_ID = "PaymentOptionId";
    public static final String DATE_OF_ORDER = "Date_of_order";
    public static final String DATE_FORMAT = "yyyy-mm-dd";

    public static final String USER_ID_COLUMN = "Id";
    public static final String USER_FIRSTNAME_COLUMN = "FirstName";
    public static final String USER_LASTNAME_COLUMN = "LastName";
    public static final String USER_EMAILID_COLUMN = "EmailId";
    public static final String USER_GENDER_COLUMN = "Gender";
    public static final String USER_BIRTHDATE_COLUMN = "BirthDate";
    public static final String USER_ADDRESS_COLUMN = "Address";
    public static final String USER_CITY_COLUMN = "City";
    public static final String USER_PROVINCE_COLUMN = "Province";
    public static final String USER_COUNTRY_COLUMN = "Country";
    public static final String USER_POSTALCODE_COLUMN = "PostalCode";
    public static final String USER_STATUS_COLUMN = "Status";
    public static final String USER_ROLE_ROLEID_COLUMN = "Role_RoleId";
    public static final String USER_MOBILENUMBER_COLUMN = "MobileNumber";
    public static final String PROPERTY_PATH = "./src/main/resources/application.properties";
    public static final String JDBC_DRIVER = "JDBCDriver";
    public static final String DATASOURCE_URL = "spring.datasource.url";
    public static final String SPRING_USERNAME = "spring.username";
    public static final String DATASOURCE_PASSWORD = "spring.datasource.password";
    public static final int ORDER_STATUS_PENDING = 2;
    public static final String URL_CUSTOMER_PAYMENT_PAYMENT = "payment/payment";
    public static final String URL_CUSTOMER_PAYMENT_SUCCESSPAYMENT = "payment/successPayment";
    public static final String URL_CUSTOMER_USERRATING = "customer/userRatingPage";
    public static final String URL_CUSTOMER_ORDERPAGE = "order/orderPage";
    public static final String URL_CUSTOMER_ORDER = "redirect:/order";
    public static final String ORDER_PICKED_UP = "Picked Up";
    public static final String ORDER_DELIVERED = "Delivered";
    public static final String ORDER_ORDERSTATUSID = "OrderStatusId";
    public static final String URL_ORDER_VIEWORDER = "/order/viewOrder";

}
