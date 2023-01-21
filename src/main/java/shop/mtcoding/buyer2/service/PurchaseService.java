package shop.mtcoding.buyer2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mtcoding.buyer2.model.Product;
import shop.mtcoding.buyer2.model.ProductRepository;
import shop.mtcoding.buyer2.model.Purchase;
import shop.mtcoding.buyer2.model.PurchaseRepository;

@Service
public class PurchaseService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    PurchaseRepository purchaseRepository;

    @Transactional
    public int buyTransaction(int productId, int count, int principalId) {
        Product product = productRepository.findById(productId);
        if (product == null) {
            return -1;
        }
        if (product.getQty() < count) {
            return -1;
        }
        int result = productRepository.updateById(product.getName(), product.getPrice(), product.getQty() - count,
                product.getId());
        if (result != 1) {
            return -1;
        }
        result = purchaseRepository.insert(principalId, product.getId(), count);
        if (result != 1) {
            return -1;
        }
        return 1;
    }

    @Transactional
    public int deleteTranscation(int principalId, int id) {
        Purchase purchase = (Purchase) purchaseRepository.findById(id);
        if (purchase == null) {
            return -1;
        }
        Product product = productRepository.findById(purchase.getProductId());
        if (product == null) {
            return -1;
        }
        int result = purchaseRepository.deleteByIdAndUserId(purchase.getId(), principalId);
        if (result != 1) {
            return -1;
        }
        result = productRepository.updateById(product.getName(), product.getPrice(),
                product.getQty() + purchase.getCount(), product.getId());
        if (result != 1) {
            return -1;
        }
        return 1;
    }
}
