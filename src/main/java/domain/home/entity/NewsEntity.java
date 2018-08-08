package domain.home.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewsEntity extends AbstractEntity{

    //新闻标题
    private String title;

    //新闻内容
    private String details;

    //点击次数
    private Long clickCount;

    //图片地址
    private String picturePath;

    private Long mainFlag;

    private Long changeFlag;

    private Long changeCount;

    @Override
    public String toString() {
        return "NewsEntity{" +
                "title='" + title + '\'' +
                ", details='" + details + '\'' +
                ", picturePath='" + picturePath + '\'' +
                ", mainFlag=" + mainFlag +
                ", changeFlag=" + changeFlag +
                ", changeCount=" + changeCount +
                '}';
    }
}
