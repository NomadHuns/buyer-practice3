package shop.mtcoding.buyer2.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProductRepository {
    public List<Product> findAll();

    public Product findById(int id);

    public int insert(@Param("name") String name, @Param("price") int price,
            @Param("qty") int qty);

    public int updateById(@Param("name") String name, @Param("price") int price,
            @Param("qty") int qty, @Param("id") int id);

    public int deleteById(int id);
}
