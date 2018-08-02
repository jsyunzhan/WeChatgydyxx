package domain.home.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
public class NoticeEntity extends AbstractEntity{

    //公告标题
    private String title;

    private byte[] noticeDetailsByte;

    //公告内容
    private String details;

    //图片地址
    private String picturePath;

    @Override
    public String toString() {
        return "NoticeEntity{" +
                "title='" + title + '\'' +
                ", noticeDetailsByte=" + Arrays.toString(noticeDetailsByte) +
                ", details='" + details + '\'' +
                ", picturePath='" + picturePath + '\'' +
                '}';
    }
}
