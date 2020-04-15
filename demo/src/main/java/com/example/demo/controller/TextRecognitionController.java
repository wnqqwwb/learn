package com.example.demo.controller;


import com.baidu.aip.ocr.AipOcr;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author fanls
 */
@RestController
public class TextRecognitionController {

    //设置APPID/AK/SK
    public static final String APP_ID = "19233461";
    public static final String API_KEY = "fWG1jyxyn7FCVG2HfUn1Od5D";
    public static final String SECRET_KEY = "9iOb4cNqtcVfrQpquNXUhKzHCigiCjya";

    public static AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

    public static HashMap<String, String> options = new HashMap<>(2);
    static {
        /*
            是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:
            - true：检测朝向；
            - false：不检测朝向。
         */
        options.put("detect_direction", "true");
    }

    @RequestMapping("/carLicense")
    public String carLicense() {
        // 参数为本地图片路径
        String image = "C:\\Users\\fanls\\Desktop\\d833c895d143ad4bc702bf7988025aafa40f065e.jpg";
        JSONObject res = client.vehicleLicense(image, options);
        return res.toString(2);
    }

    @RequestMapping("/webPicture")
    public String webPicture() {
        String url = "https://test-devpublicmeeu.oss-cn-hangzhou.aliyuncs.com/proof/school/PropOwnerCertOCR1.jpg";
        // 通用文字识别, 图片参数为远程url图片
        JSONObject res = client.basicGeneralUrl(url, options);
        return res.toString(2);
    }
    /**
     *
     *
     *萨顶顶多多多多多多多多多多多多多多多多多多多多多
     *1221332
     *11111121
     * 增加注释
     *
     *
     */
    @RequestMapping("/hk")
    public String hk() {
        String image = "C:\\Users\\fanls\\Desktop\\timg.jpg";
        // 通用文字识别, 图片参数为远程url图片
        JSONObject res = client.HKMacauExitentrypermit(image, options);
        return res.toString(2);
    }
}
