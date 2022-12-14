package com.CanadaEats.group13.delivery_person.controller;

import com.CanadaEats.group13.database.DatabaseConnection;
import com.CanadaEats.group13.delivery_person.business.DeliverPersonBusiness;
import com.CanadaEats.group13.delivery_person.business.IDeliveryPersonBusiness;
import com.CanadaEats.group13.delivery_person.repository.DeliverRepository;
import com.CanadaEats.group13.order.dto.OrderDTO;
import com.CanadaEats.group13.utils.APIAccessAuthorization;
import com.CanadaEats.group13.utils.ApplicationConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DeliveryPersonController {
    IDeliveryPersonBusiness deliveryPersonBusiness;

    public DeliveryPersonController() {
        this.deliveryPersonBusiness = new DeliverPersonBusiness(new DeliverRepository(DatabaseConnection.getInstance()));
    }

    @GetMapping("/orders/{orderId}")
    public String showOrders(Model model, @PathVariable("orderId") int orderId, HttpServletRequest request) {
        boolean isAPIAccessible = APIAccessAuthorization.getInstance().getAPIAccess(request);
        if (isAPIAccessible) {
            OrderDTO orderDisplayDTO = deliveryPersonBusiness.displayOrders(orderId);
            model.addAttribute("order", orderDisplayDTO);
            return ApplicationConstants.URL_CUSTOMER_ORDERPAGE;
        }
        return ApplicationConstants.URL_AUTHENTICATION_USERLOGINPAGE;
    }

    @GetMapping("/delivery/{orderId}/{orderStatus}/")
    public String updateOrderStatus(@PathVariable("orderId") String orderId, @PathVariable("orderStatus") int orderStatus, HttpServletRequest request) {
        boolean isAPIAccessible = APIAccessAuthorization.getInstance().getAPIAccess(request);
        if (isAPIAccessible) {
            deliveryPersonBusiness.updateOrderStatus(orderId, orderStatus);
            return ApplicationConstants.URL_CUSTOMER_ORDER;
        }
        return ApplicationConstants.URL_AUTHENTICATION_USERLOGINPAGE;
    }
}
