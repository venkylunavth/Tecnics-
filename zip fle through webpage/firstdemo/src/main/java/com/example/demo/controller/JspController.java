package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*import javax.servlet.MultipartConfigElement;
import javax.servlet.annotation.MultipartConfig;*/

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@javax.servlet.annotation.MultipartConfig
@Configuration
@Controller
public class JspController {
	
	private static String UPLOAD_FOLDER = "C:\\Users\\swetha_ketha\\Desktop\\zip folder";
	
	
    @RequestMapping( "/home")
	public ModelAndView home() {
		ModelAndView mv=new ModelAndView("home");
		return mv;
	
	}
    @PostMapping("/uploadfile")
    public String uploadfile(@RequestParam("file")MultipartFile file,RedirectAttributes redirectAttributes)
   throws IOException {
     if(file.isEmpty()) {
     redirectAttributes.addFlashAttribute("errorMessage","Please select file to upload.");
     return "home";
     }
     Path path =Paths.get("C:\\Users\\swetha_ketha\\Desktop\\zip folder",file.getOriginalFilename());
     Files.write(path,file.getBytes());
     redirectAttributes.addFlashAttribute("successMessage","file upload success,filename:"+file.getOriginalFilename());
     return "home";

     }
 }
	/*
	 * @PostMapping("/upload") public ModelAndView fileUpload(@RequestParam("file")
	 * MultipartFile file, RedirectAttributes redirectAttributes) {
	 * 
	 * if (file.isEmpty()) { return new ModelAndView("status", "message",
	 * "Please select a file and try again"); }
	 * 
	 * try { // read and write the file to the selected location- byte[] bytes =
	 * file.getBytes(); Path path = Paths.get(UPLOAD_FOLDER +
	 * file.getOriginalFilename()); Files.write(path, bytes);
	 * 
	 * } catch (IOException e) { e.printStackTrace(); }
	 * 
	 * return new ModelAndView("status", "message", "File Uploaded sucessfully"); }
	 */

    
    
    
    
    
	/*
	 * @PostMapping("/submit") public ResponseEntity<?>
	 * handleFileUpload( @RequestParam("file") MultipartFile file ) {
	 * 
	 * String fileName = file.getOriginalFilename(); try { file.transferTo( new
	 * File("C:\\Users\\swetha_ketha\\Desktop")); } catch (Exception e) { return
	 * ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); } return
	 * ResponseEntity.ok("File uploaded successfully."); }
	 */
	/*
	 * @Bean(name = "MultipartFile") public CommonsMultipartResolver
	 * multipartResolver() { CommonsMultipartResolver resolver = new
	 * CommonsMultipartResolver(); resolver.setDefaultEncoding("utf-8");
	 * resolver.setMaxUploadSize(215); return resolver; }
	 */
    

 