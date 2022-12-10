package com.CanadaEats.group13.MenuItems.repository;

import java.util.List;

import com.CanadaEats.group13.MenuItems.dto.MenuItemDTO;

public interface IMenuItemRepository {
    public List<MenuItemDTO> getMenuItems();
}
