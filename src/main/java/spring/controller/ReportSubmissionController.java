package spring.controller;

import java.io.File;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import spring.model.FileInfo;
import spring.service.FileDAO;

@Controller
public class ReportSubmissionController {
	
	@Autowired
	private FileDAO fileDao;
	
	public void setFileDao(FileDAO fileDao) {
		this.fileDao = fileDao;
	}

	@RequestMapping(value = "/report/submission.do", method = RequestMethod.GET)
	public String form() {
		return "report/submissionForm";
	}
	
	@RequestMapping(value = "/report/submitReport1.do", method = RequestMethod.POST)
	public String submitReport1(@RequestParam("studentNumber") String studentNumber, @RequestParam("report") MultipartFile report) {
		printInfo(studentNumber, report);
		upload(report);
		return "report/submissionComplete";
	}
	
	@RequestMapping(value = "/report/submitReport2.do", method = RequestMethod.POST)
	public String submitReport2(MultipartHttpServletRequest request) {
		String studentNumber = request.getParameter("studentNumber");
		MultipartFile report = request.getFile("report");
		printInfo(studentNumber, report);
		upload(report);
		return "report/submissionComplete";
	}
	
	@RequestMapping(value = "/report/submitReport3.do", method = RequestMethod.POST)
	public String submitReport3(ReportCommand reportCommand) {
		printInfo(reportCommand.getStudentNumber(), reportCommand.getReport());
		upload(reportCommand.getReport());
		return "report/submissionComplete";
	}
	
	private void printInfo(String studentNumber, MultipartFile report) {
		System.out.println(studentNumber + "가 업로드 한 파일 : " + report.getOriginalFilename());
	}
	
	public void upload(MultipartFile report) {
		long now = System.currentTimeMillis();
		Random r = new Random();
		int i = r.nextInt(50);
		String name = now + "_" + i;
		String o_name = report.getOriginalFilename();
		File new_file = new File("f://upload//" + name + "_" + o_name);
		
		try {
			report.transferTo(new_file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		FileInfo f = new FileInfo(report.getOriginalFilename(), new_file.getPath(), report.getSize());
		int insertcount = fileDao.insertFile(f);
		if(insertcount == 1) {
			System.out.println("inser OK");
		}
	}
	
}
