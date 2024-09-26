package com.example.springboot.controller.request;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import com.example.springboot.common.Result;
import com.example.springboot.controller.request.UserPageRequest;
import com.example.springboot.entity.User;
import com.example.springboot.service.IUserService;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;

    private static final String BASE_FILE_PATH = System.getProperty("user.dir") + "/files/";
    @PostMapping("/file/upload")
    public Result uploadfile(MultipartFile file) throws IOException {
        String originalFilename=file.getOriginalFilename();
        long flag=System.currentTimeMillis();
        String filePath=BASE_FILE_PATH+ flag+"_"+originalFilename;
        FileUtil.mkParentDirs(filePath);
        file.transferTo(FileUtil.file(filePath));
        return Result.success("http://localhost:9090/user/file/download/"+flag);
    }
    @GetMapping("/file/download/{flag}")
    public void downloadfile(@PathVariable String flag, @RequestParam(required = false) String play, HttpServletResponse response){
        OutputStream os;
        List<String> fileNames=FileUtil.listFileNames(BASE_FILE_PATH);
        String fileName=fileNames.stream().filter(name ->name.contains(flag)).findAny().orElse("");
        try {
            if(StrUtil.isNotEmpty(fileName)){
                String realName = fileName.substring(fileName.indexOf("_")+1);
                if("1".equals(play)){
                    response.addHeader("Content-Dispostion","inline;filename=" + URLEncoder.encode(realName,"UTF-8"));
                }
                else {
                    response.addHeader("Content-Dispostion","attachement;filename=" + URLEncoder.encode(realName,"UTF-8"));

                }

            }

            byte[] bytes=FileUtil.readBytes(BASE_FILE_PATH+fileName);
            os=response.getOutputStream();
            os.write(bytes);
            os.flush();
            os.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/list")
    public Result list() {
        List<User> users = userService.list();
        return Result.success(users);
    }
    @PostMapping("/save")
    public Result save(@RequestBody User user){
        userService.save(user);
        return Result.success();

    }
    @GetMapping("/page")
    public Result page(UserPageRequest userPageRequest) {
        return Result.success(userService.page(userPageRequest));

}
}
