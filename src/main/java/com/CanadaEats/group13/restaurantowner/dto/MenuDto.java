package com.CanadaEats.group13.restaurantowner.dto;

public class MenuDto {
    private String menuId;
    private String menuName;

    public MenuDto() {
    }

    public MenuDto(String menuId, String menuName) {
        this.menuId = menuId;
        this.menuName = menuName;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
}
