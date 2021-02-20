<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<html>
<head>
	<title>Join</title>
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript">
		function checkPass() {
			var msg = "불일치";
			if(match()) {
				msg = "일치";
			}
			writeMsg(msg);
		}
		function join() {
			if(!match()) {
				$('#m_pass').focus();
				writeMsg("비밀번호가 틀립니다");
			} else if(!checkId()){
				$('#m_id').focus();
				writeMsg("아이디 4~20자 사이로 맞추세요");
			} else if(!availability()) {
				$('#m_pass').focus();
				writeMsg("비밀번호 8~16자 사이로 맞추세요");
			} else {
				submit("join");
			}
		}
		function match(a, b) { // 비밀번호와 재확인이 일치하는지
			return $('#m_pass').val() === $('#m_re').val();
		}
		function submit(a) { // 이동
			let obj = document.joinForm;
			obj.method = "post";
			obj.action = a;
			obj.submit();
		}
		function availability() { // 비밀번호 길이 8~16 사이로 맞추기 
			return !($('#m_pass').val().trim().length < 8 || $('#m_pass').val().length > 16);
		}
		function checkId() { // 아이디 4~20 사이로 맞추기
			return !($('#m_id').val().trim().length < 4 || $('#m_id').val().trim().length > 20);
		}
		function writeMsg(msg) {
			$('#msg').text(msg);
		}
	</script>
</head>
<body>
	<form name="joinForm" method="post">
		<input type="text" name="m_id" id="m_id" placeholder="아이디"><br>
		<input type="password" name="m_pass" id="m_pass" placeholder="비밀번호" onkeyup="checkPass()"><br>
		<input type="password" name="m_re" id="m_re" placeholder="비밀번호 확인" onkeyup="checkPass()"><br>
		<div id="msg"></div><br>
		<input type="button" value="회원가입" onclick="join();"><br>
		
		
	</form>
</body>
</html>
