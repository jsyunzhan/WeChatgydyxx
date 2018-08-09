package domain.home.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BannerEntity extends AbstractEntity{

    //轮播图标题
    private String title;

    //轮播图内容
    private String details;

    //轮播图图片地址
    private String picturePath;

    //状态id
    private Long statueId;

    //点击次数
    private Long clickCount;

    private Long statueCount;

    @Override
    public String toString() {
        return "BannerEntity{" +
                "title='" + title + '\'' +
                ", details='" + details + '\'' +
                ", picturePath='" + picturePath + '\'' +
                ", statueId=" + statueId +
                ", statueCount=" + statueCount +
                '}';
    }
}
