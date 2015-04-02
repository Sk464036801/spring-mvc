package com.app.mvn.example.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;

import javax.servlet.http.Part;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/upload")
public class FileUploadController {
	
	private static final Log logger = LogFactory.getLog(FileUploadController.class);
	
	@RequestMapping(value = "/form", method = RequestMethod.POST)
    public String handleFormUpload(@RequestParam("name") String name,
            @RequestParam("file") MultipartFile file) {

        if (!file.isEmpty()) {
            try {
				byte[] bytes = file.getBytes();
			} catch (IOException e) {
				logger.error(" handleFormUpload error:", e);
			}
            // store the bytes somewhere
            return "redirect:/succ.html";
        }

        return "redirect:/fail.html";
    }
	
	@RequestMapping(value = "/form2", method = RequestMethod.POST)
    public String handleFormUpload(@RequestParam("name") String name,
            @RequestParam("file") Part file) {

        try {
			InputStream inputStream = file.getInputStream();
		} catch (IOException e) {
			logger.error(" handleFormUpload error:", e);
		}
        // store bytes from uploaded file somewhere

        return "redirect:/succ.html";
    }
	
	/**
	 * 异步请求处理
	 * @param file
	 * @return
	 */
	@RequestMapping(value = "/multipartFile", method=RequestMethod.POST)
	public Callable<String> processUpload(final MultipartFile file) {

	    return new Callable<String>() {
	        public String call() throws Exception {
	            
	            return "home";
	        }
	    };

	}

}
