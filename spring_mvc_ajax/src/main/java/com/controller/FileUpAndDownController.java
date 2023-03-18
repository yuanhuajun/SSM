package com.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.UUID;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/2/1 9:55
 * @Description
 *  ResponseEntity：可以作为控制器方法的返回值；是响应到浏览器的完整响应报文
 */

@Controller
public class FileUpAndDownController {
    @RequestMapping("/test/down")
    //ResponseEntity可以不写@ResponseBody注解，写了也没有关系。简单的说,@ResponseBody可以直接返回Json结果
    //如果不设置返回值，会返回名为“/test/down”的逻辑视图
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        ServletContext servletContext = session.getServletContext();
        //获取服务器中文件的真实路径
        String realPath = servletContext.getRealPath("img");//不知道用”/"还是“\”拼接，使用 File.separator 自动拼接
        realPath = realPath + File.separator+"生活.jpg";
        InputStream is =  new FileInputStream(realPath);
        byte[] bytes = new byte[is.available()];
        is.read(bytes);
        UUID uuid = UUID.randomUUID();
        MultiValueMap<String,String> headers = new HttpHeaders();
        headers.add("Content-Disposition","attachment;filename="+uuid+".jpg");
        HttpStatus status = HttpStatus.OK;
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes,headers,status);
        is.close();
        return responseEntity;
    }

    //文件上传的表单enctype必须="multipart/form-data"
    //将上传的文件封装成MultipartFile了
    //需要在SpringMVC中配置文件上传解析器
    @RequestMapping("/test/up")
    public String testUp(HttpSession session, MultipartFile photo) throws IOException {
        String originalFilename = photo.getOriginalFilename();
        //获取文件的后缀名
        String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
        //获取uuid
        String uuid = UUID.randomUUID().toString();
        //拼接出一个新的文件名
        originalFilename = uuid+substring;
        ServletContext servletContext = session.getServletContext();
        String photoPath = servletContext.getRealPath("photo");
        System.out.println("************");
        System.out.println(photoPath);
        File file = new File(photoPath);
        if(!file.exists()){
            file.mkdir();
        }
        String finalPath = photoPath+File.separator+originalFilename;
        //transferTo方法进行上传
        photo.transferTo(new File(finalPath));
        System.out.println(originalFilename);
        return "success";
    }
}
