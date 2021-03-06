package com.example.sweater.Controller;

import com.example.sweater.domain.Servey.TableExcel;
import com.example.sweater.domain.User.User;
import com.example.sweater.repos.MessageRepoTODELETE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
public class MainController {

    @Autowired
    private MessageRepoTODELETE messageRepo;

    @Value("${upload.path}")
    private String uploadPath;


    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Model model) {

        return "main";
    }

    @PostMapping("/main")
    public String addFile(
            @AuthenticationPrincipal User userAuthor,
            @RequestParam("file") MultipartFile file,
            Map<String, Object> model) throws IOException {

        if (file != null) {
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists())
                uploadDir.mkdir();

            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFileName));

            TableExcel uploadedTable = new TableExcel(resultFileName, userAuthor);
        }

        return "main";
    }

}