package shop.mtcoding.buyer2.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.buyer2.dto.PurchaseAllDto;
import shop.mtcoding.buyer2.model.PurchaseRepository;
import shop.mtcoding.buyer2.model.User;
import shop.mtcoding.buyer2.service.PurchaseService;

@Controller
public class PurchaseController {

    @Autowired
    HttpSession session;

    @Autowired
    PurchaseRepository purchaseRepository;

    @Autowired
    PurchaseService purchaseService;

    @PostMapping("/purchase/buy")
    public String buy(int productId, int count) {
        User principal = (User) session.getAttribute("principal");
        if (principal == null) {
            return "redirect:/missing";
        }
        int result = purchaseService.buyTransaction(productId, count, principal.getId());
        if (result == -1) {
            return "redirect:/missing";
        }
        return "redirect:/product/" + productId;
    }

    @GetMapping("/purchase/list")
    public String list(Model model) {
        User principal = (User) session.getAttribute("principal");
        if (principal == null) {
            return "redirect:/missing";
        }
        List<PurchaseAllDto> purchaseAllDtoList = purchaseRepository.findByUserId(principal.getId());
        model.addAttribute("purchaseAllDtoList", purchaseAllDtoList);
        return "purchase/list";
    }

    @PostMapping("/purchase/{id}/delete")
    public String delete(@PathVariable("id") int id) {
        User principal = (User) session.getAttribute("principal");
        if (principal == null) {
            return "redirect:/missing";
        }
        int result = purchaseService.deleteTranscation(principal.getId(), id);
        if (result == -1) {
            return "redirect:/missing";
        }
        return "redirect:/purchase/list";
    }
}
