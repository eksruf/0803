package com.care.file.controller;

import java.io.File;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.file.service.FileService;

@Controller
public class FileController {
	@Autowired FileService fs;
	@GetMapping("form")
	public String form() {
		return "uploadForm";
	}
	
	@PostMapping("upload")
	/* 개별로 받아줄 때 사용
	 public String upload(@RequestParam String id, @RequestParam String name, @RequestParam MultipartFile f)
	 
	 */
	public String upload(MultipartHttpServletRequest mul){
		fs.fileProcess( mul );
		
	return "redirect:form";	
	}
	
	@GetMapping("views")
	public String views(Model model) {
		fs.getData(model);
		return "result";
	}
	
	@GetMapping("download")
	public void download(String file, HttpServletResponse response) throws Exception {
		System.out.println("file: "+file );
		response.addHeader("Content-disposition", "attachment; fileName="+file);
		//Content-disposition : 다운로드 방식 	  attachment; fileName=  : 다운로드 받는 파일의 이름 지정
		File f = new File(FileService.IMAGE_REPO+"/"+file);
		FileInputStream in = new FileInputStream(f);
		FileCopyUtils.copy(in, response.getOutputStream());
		in.close();
	}
	
	@GetMapping("delete")
	public String delete(String file, String id) {
		fs.delete(file, id);
		return "redirect:views";
	}
	
	@GetMapping("modify")
	public String modify(String file, String id,Model model) {
		fs.modify(id, model);
		
		return "modify";
	}
	
	@PostMapping("modifySet")
	public String modifySet(MultipartHttpServletRequest mul) {
		System.out.println(mul.getParameter("id"));
		System.out.println(mul.getParameter("name"));
		System.out.println(mul.getParameter("imgName"));
		System.out.println("22");
		
		return "";
	}
}
