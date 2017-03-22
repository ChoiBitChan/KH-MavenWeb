<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<body>
<h2>Hello World!</h2>

	<a href="hello.do">/hello.do</a><br/>
	<br/>
	<a href="article/newArticle.do">/article/newArticle.do</a><br/>
	<br/>
	<a href="order/order.do">/order/order.do</a><br/>
	<br/>
	RequestParam<br/>
	<a href="search/internal.do?query=abc&p=10">RequestParam1</a><br/>
	<a href="search/external.do">RequestParam2</a><br/>
	<br/>
	쿠키<br/>
	<a href="cookie/make.do">/cookie/make.do</a><br/>
	<a href="cookie/view.do">/cookie/view.do</a><br/>
	<a href="header/check.do">/header/check.do</a><br/>
	<br/>
	<a href="search/main.do">/search/main.do</a><br/>
	<br/>
	유효성 검사<br/>
	<a href="account/create.do">/account/create.do</a><br/>
	<br/>
	RESTful [템플릿 변수]<br/>
	<a href="game/users/chan/characters/1234">/game/users/chan/characters/1234</a><br/>
	<br/>
	Valid [어노테이션]<br/>
	<a href="login/login.do">/login/login.do</a><br/>
	<br/>
	Date 형변환<br/>
	<a href="log/query.do">/log/query.do</a><br/>
	<br/>
	FileUpload<br/>
	<a href="report/submission.do">/report/submission.do</a><br/>
	<br/>
	Interceptor<br/>
	<a href="event/list.do">/event/list.do</a><br/>
	<br/>
	Exception [예외처리]<br/>
	<a href="math/divide.do?op1=10&op2=0">/math/divide.do?op1=10&op2=0</a><br/>
	<br/>
	RequestBody & ResponseBody<br/>
	<a href="test/simpleTest.do">/test/simpleTest.do</a><br/>
	<a href="test/simpleTest1.do">/test/simpleTest1.do</a><br/>
	<a href="test/simpleTest2.do">/test/simpleTest2.do</a><br/>
	<br/>
	City<br/>
	<a href="city/city.do">/city/city.do</a><br/>
	<br/>
	View [Login]<br/>
	<a href="jsp/login/login.do">/jsp/login/login.do</a><br/>
	<br/>
	View [Member]<br/>
	<a href="jsp/member/regist.do">/jsp/member/regist.do</a><br/>
	<br/>
	changeLanguage [Interceptor 이용]<br/>
	<a href="jsp/login/login.do?language=ko">/jsp/login/login.do?language=ko</a><br/>
	<a href="jsp/login/login.do?language=en">/jsp/login/login.do?language=en</a><br/>
	<br/>
	changeLanguage [localeResolver 이용]<br/>
	<a href="jsp/changeLanguage?lang=ko">/jsp/changeLanguage?lang=ko</a><br/>
	<a href="jsp/changeLanguage?lang=en">/jsp/changeLanguage?lang=en</a><br/>
	<br/>
	changeLanguage [RequestContextUtils 이용]<br/>
	<a href="jsp/changeLanguage2?lang=ko">/jsp/changeLanguage2?lang=ko</a><br/>
	<a href="jsp/changeLanguage2?lang=en">/jsp/changeLanguage2?lang=en</a><br/>
	<br/>
	Tiles [Login]<br/>
	<a href="tiles/login/login.do">/tiles/login/login.do</a><br/>
	
</body>
</html>
