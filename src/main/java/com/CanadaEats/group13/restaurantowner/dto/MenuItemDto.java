package com.CanadaEats.group13.restaurantowner.dto;

public class MenuItemDto {
    private String menuId;
    private String menuItemId;
    private String name;
    private String description;
    private int price;

    public MenuItemDto() {
    }

    public MenuItemDto(String menuId, String menuItemId, String name, String description, int price) {
        this.menuId = menuId;
        this.menuItemId = menuItemId;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(String menuItemId) {
        this.menuItemId = menuItemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
