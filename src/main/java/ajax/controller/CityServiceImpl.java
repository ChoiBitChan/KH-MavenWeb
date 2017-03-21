package ajax.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class CityServiceImpl implements CityService {

	@Autowired
	private CityDAO dao;
	
	public void setDao(CityDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<String> listSido() {
		
		List<String> list = null;
		
		try {
			list = dao.getListData("city.listSido");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return list;
	}

	@Override
	public List<String> listCity(String city) {
		
		List<String> list = null;
		
		try {
			list = dao.getListData("city.listCity", city);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return list;
	}

}
