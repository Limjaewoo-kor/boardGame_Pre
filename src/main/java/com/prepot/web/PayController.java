package com.prepot.web;


import com.prepot.SessionConst;
import com.prepot.domain.FoodOrder;
import com.prepot.domain.Member;
import com.prepot.domain.Pay;
import com.prepot.repository.food.FoodSearchCond;
import com.prepot.repository.pay.PayUpdateDto;
import com.prepot.service.FoodService;
import com.prepot.service.PayService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/pays")
@RequiredArgsConstructor
public class PayController {

    private final FoodService foodService;
    private final PayService payService;

    @GetMapping("/user/order")
    public String foodOrders(@ModelAttribute("foodSearchCond") FoodSearchCond foodSearchCond, Model model,HttpServletRequest request) {
        HttpSession session = request.getSession();
        Member member = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER);
        String userId = member.getUserId();

        List<FoodOrder> foodOrders = foodService.findFoodOrders(foodSearchCond,userId);

        int totalPrice = 0;

        for (int i = 0; i < foodOrders.size(); i++) {
            totalPrice = totalPrice + (Integer.parseInt(foodOrders.get(i).getFoodPrice()) * Integer.parseInt(foodOrders.get(i).getFoodCnt()));
        }

        model.addAttribute("foodOrders", foodOrders);
        model.addAttribute("userId", userId);
        model.addAttribute("totalPrice", totalPrice);
        return "pay/payOrderListUser";
    }


    @GetMapping("/room")
    public String editForm(Model model) {
        Pay pay = payService.findById().get();
        model.addAttribute("pay", pay);
        return "pay/roomPay";
    }

    @PostMapping("/room")
    public String edit(@ModelAttribute PayUpdateDto updateParam) {
        payService.update(updateParam);
        return "redirect:/";
    }

}
