package shop.mtcoding.buyer2.model;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import shop.mtcoding.buyer2.util.DateUtil;

@Getter
@Setter
public class Purchase {
    private Integer id;
    private Integer userId;
    private Integer productId;
    private Integer count;
    private Timestamp createdAt;

    public String getCreatedAtToString() {
        return DateUtil.format(createdAt);
    }
}
