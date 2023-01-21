package shop.mtcoding.buyer2.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import shop.mtcoding.buyer2.dto.PurchaseAllDto;

@Mapper
public interface PurchaseRepository {
    public List<Purchase> findAll();

    public Purchase findById();

    public int insert(@Param("userId") int userId, @Param("productId") int productId, @Param("count") int count);

    public int updateById(@Param("userId") int userId, @Param("productId") int productId, @Param("count") int count,
            @Param("id") int id);

    public int deleteById(int id);

    public List<PurchaseAllDto> findByUserId(int userId);
}
