package ajax.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;

@Controller
public class CityController {

	@Autowired
	private CityService service;

	public void setService(CityService service) {
		this.service = service;
	}
	
	@RequestMapping(value="/city/city.do")
	public String city() throws Exception {
		return "ajax/city";
	}
	
	@RequestMapping(value="/city/sidoList.do", method=RequestMethod.POST)
	public void sidoList(HttpServletResponse response) throws Exception {
		
		List<String> list = service.listSido();
		
		JSONObject jso = new JSONObject();
		
		jso.put("data", list);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jso.toString());
		
	}
	
	@RequestMapping(value="/city/cityList.do", method=RequestMethod.POST, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String cityList(HttpServletResponse response, @RequestParam("snum") String city) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		
		List<String> list = service.listCity(city);
		
		JSONObject jso = new JSONObject();
		
		jso.put("data1", list);
		
		return jso.toString();
	}
	
}
