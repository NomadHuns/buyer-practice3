package shop.mtcoding.buyer2.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import shop.mtcoding.buyer2.dto.PurchaseAllDto;

@Mapper
public interface PurchaseRepository {
    public List<Purchase> findAll();

    public Purchase findById(int id);

    public int insert(@Param("userId") int userId, @Param("productId") int productId, @Param("count") int count);

    public int updateById(@Param("userId") int userId, @Param("productId") int productId, @Param("count") int count,
            @Param("id") int id);

    public int deleteByIdAndUserId(@Param("id") int id, @Param("userId") int userId);

    public List<PurchaseAllDto> findByUserId(int userId);
}
