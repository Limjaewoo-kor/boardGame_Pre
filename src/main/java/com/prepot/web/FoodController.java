package com.prepot.web;


import com.prepot.SessionConst;
import com.prepot.domain.Food;
import com.prepot.domain.Member;
import com.prepot.repository.food.FoodSearchCond;
import com.prepot.repository.food.FoodUpdateDto;
import com.prepot.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/foods")
@RequiredArgsConstructor
public class FoodController {

    private final FoodService foodService;

    @GetMapping
    public String foods(@ModelAttribute("foodSearch") FoodSearchCond foodSearchCond, Model model) {
        List<Food> foods = foodService.findFoods(foodSearchCond);
        model.addAttribute("foods", foods);
        return "food/foodList";
    }

    @GetMapping("/user")
    public String foodsUser(@ModelAttribute("foodSearch") FoodSearchCond foodSearchCond, Model model) {
        List<Food> foods = foodService.findFoods(foodSearchCond);
        model.addAttribute("foods", foods);
        return "food/foodListUser";
    }

    @GetMapping("/add")
    public String addForm() {
        return "food/addFoodForm";
    }


    @PostMapping("/add")
    public String foodAdd(Food food){
        Food save = foodService.save(food);
        System.out.println(save.getFoodName());
        return "redirect:/foods";
    }

    @GetMapping("/{foodName}")
    public String food(@PathVariable String foodName, Model model) {
        Food food = foodService.findById(foodName).get();
        model.addAttribute("food", food);
        return "food/food";
    }

    @GetMapping("/start/{foodName}")
    public String foodStart(@PathVariable String foodName, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Member member = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER);
        String userId = member.getUserId();

        String OldGameName = foodService.playFoodCheck(foodName,userId);

        if(null != OldGameName || !OldGameName.equals("") ){
            if(!OldGameName.equals(foodName)){
                foodService.endTimeUpdate(OldGameName,userId);
                foodService.playFood(foodName,userId);
            }
        }else {
            foodService.playFood(foodName,userId);
        }

        return "redirect:/foods/user";
    }

    @GetMapping("/end")
    public String foodEnd(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Member member = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER);
        String userId = member.getUserId();

        foodService.endFood(userId);

        return "redirect:/foods/user";
    }




    @GetMapping("/{foodName}/edit")
    public String editForm(@PathVariable String foodName, Model model) {
        Food food = foodService.findById(foodName).get();
        model.addAttribute("food", food);
        return "food/editFoodForm";
    }


    @GetMapping("/{foodName}/delete")
    public String deleteFood(@PathVariable String foodName, Model model) {
        foodService.deleteFood(foodName);
        return "redirect:/foods";
    }

    @PostMapping("/{foodName}/edit")
    public String edit(@PathVariable String foodName, @ModelAttribute FoodUpdateDto updateParam) {
        foodService.update(foodName, updateParam);
        return "redirect:/foods/{foodName}";
    }

}
