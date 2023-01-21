package shop.mtcoding.buyer2.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.buyer2.model.Product;
import shop.mtcoding.buyer2.model.ProductRepository;
import shop.mtcoding.buyer2.model.User;

@Controller
public class PurchaseController {

    @Autowired
    HttpSession session;

    @Autowired
    ProductRepository productRepository;

    @PostMapping("/purchase/buy")
    public String buy(int productId, int count) {
        User principal = (User) session.getAttribute("principal");
        if (principal == null) {
            return "redirect:/missing";
        }
        Product product = productRepository.findById(productId);
        if (product == null) {
            return "redirect:/missing";
        }
        if (product.getQty() < count) {
            return "redirect:/missing";
        }
        int result = productRepository.updateById(product.getName(), product.getPrice(), product.getQty() - count,
                product.getId());
        if (result != 1) {
            return "redirect:/missing";
        }
        return "redirect:/product/" + productId;
    }
}
