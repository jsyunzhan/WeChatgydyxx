package domain.home;

import domain.home.entity.NoticeEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static domain.home.HomeWebURLMapping.NOTICE_MANAGEMENT_PICTURE_SHOW;

@Controller
public class PictureUtil {

    /**
     * 根据图片地址查询图片
     * @param noticeEntity
     * @return
     * @throws IOException
     */
    @RequestMapping(value = NOTICE_MANAGEMENT_PICTURE_SHOW)
    @ResponseBody
    public String[] getPictureByte(@RequestBody NoticeEntity noticeEntity) throws IOException {

        //获取图片路径
        final String path = noticeEntity.getPicturePath();
        //获取图片路径地址
        final String[] pathArr=path.split(",");
        //需要返回的base64数组
        String[] base64Array = new String[pathArr.length];

        for (int i=0;i<pathArr.length;i++){
            //图片地址
            String pahtStr = pathArr[i];
            //获取数组
            byte[] imageByte = Files.readAllBytes(Paths.get(pahtStr));
            //转码
            String base64String= java.util.Base64.getEncoder().encodeToString(imageByte);
            //添加到64数组
            base64Array[i] = base64String;
        }
        return base64Array;
    }

}
