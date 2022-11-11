package com.tarasenko.shop.controller;

import com.tarasenko.shop.dto.FoodDto;
import com.tarasenko.shop.dto.NotFoodDto;
import com.tarasenko.shop.entity.BucketItem;
import com.tarasenko.shop.entity.Product;
import com.tarasenko.shop.service.BucketService;
import com.tarasenko.shop.service.FoodService;
import com.tarasenko.shop.service.NotFoodService;
import com.tarasenko.shop.service.OrderService;
import com.tarasenko.shop.service.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final FoodService foodService;
    private final NotFoodService notFoodService;
    private final BucketService bucketService;
    private final WarehouseService warehouseService;

    private final OrderService orderService;


    private void processCatalogAction(HttpServletRequest request, Model model) {
        String productType = request.getParameter("product_type");
        if (productType != null) {
            if (productType.equalsIgnoreCase("food")) {
                List<FoodDto> allFood = foodService.getAllFood();
                model.addAttribute("allFood", allFood);

            }

            if (productType.equalsIgnoreCase("notfood")) {
                List<NotFoodDto> allNotFood = notFoodService.getAllNotFood();
                model.addAttribute("allNotFood", allNotFood);
            }
        }
    }

    private void processBucketAction(Model model) {
        List<BucketItem> bucketItems = bucketService.getBucketItems();
        model.addAttribute("bucketItems", bucketItems);

        int totalCost = bucketService.getTotalCost();
        model.addAttribute("totalCost", totalCost);
    }

    private void processLogoutAction(Model model) {

    }

    private void processOrderAction(Model model) {

    }


    @RequestMapping("/")
    public String indexView(HttpServletRequest request, Model model) {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "catalog" -> processCatalogAction(request, model);
                case "bucket" -> processBucketAction(model);
                case "logout" -> processLogoutAction(model);
                case "order" -> processOrderAction(model);
            }
        }

        return "index";
    }

    @RequestMapping("/addToBucket")
    public String addToBucket(@RequestParam("productId") int productId) {
        Optional<Product> productOptional = warehouseService.findProductById(productId);

        productOptional.ifPresent(product -> bucketService.addProduct(product, 1));

        return "redirect:/";
    }

    @RequestMapping("/createOrder")
    public String Order(@RequestParam("deliveryAddress") String deliveryAddress) {
        orderService.createOrder(deliveryAddress);

        return "redirect:/";
    }
}
