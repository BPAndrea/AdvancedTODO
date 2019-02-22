package com.greenfox.myprogram.controller;

import java.io.*;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;


@Controller
public class DownloadPdfController {

    @GetMapping(value = "/download")
    public StreamingResponseBody getSteamingFile(HttpServletResponse response) {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"DemoFile.pdf\"");
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File("D:\\Download\\DemoFile.pdf"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        InputStream finalInputStream = inputStream;
        return outputStream -> {
            int nRead;
            byte[] data = new byte[1024];
            while ((nRead = finalInputStream.read(data, 0, data.length)) != -1) {
                outputStream.write(data, 0, nRead);
            }
        };
    }
}

