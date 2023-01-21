package shop.mtcoding.buyer2.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import shop.mtcoding.buyer2.util.DateUtil;

@Getter
@Setter
public class PurchaseAllDto {
    private Integer id;
    private String username;
    private String name;
    private Integer count;
    private Timestamp createdAt;

    public String getCreatedAtToString() {
        return DateUtil.format(createdAt);
    }
}
