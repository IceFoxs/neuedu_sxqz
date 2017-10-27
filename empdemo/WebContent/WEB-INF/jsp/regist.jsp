<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>regist</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="css/style2.css" />
	<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
	<script type="text/javascript">
		function checkUsername(){
			var username = $("#username").val();
			var reg = new RegExp(/^[a-zA-Z]{1}[0-9a-zA-Z]{5,11}$/);
			var boo = reg.test(username);
			if (boo) {
				location.href = "register.do";
			}else{
				$("#checkUsername").html("首字母必须是英文,长度为6~12位");
				$("#checkUsername").css("color","red");
			}
		}
	</script>
</head>
<body>
		<div id="wrap">
			<div id="top_content">
					<div id="header">
						<div id="rightheader">
							<p>
								${now}
								<br />
							</p>
						</div>
						<div id="topheader">
							<h1 id="title">
								<a href="#">main</a>
							</h1>
						</div>
						<div id="navigation">
						</div>
					</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						注册
					</h1>
					<form action="login.html" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									用户名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="username" id="username" onblur="checkUsername();"/>
									<span id="checkUsername"></span>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									真实姓名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="name" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									密码:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="pwd" />
								</td>
							</tr><tr>
								<td valign="middle" align="right">
									确认密码:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="pwd2" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									性别:
								</td>
								<td valign="middle" align="left">
									男
									<input type="radio" class="inputgri" name="sex" value="m" checked="checked"/>
									女
									<input type="radio" class="inputgri" name="sex" value="f"/>
								</td>
							</tr>
							
							<tr>
								<td valign="middle" align="right">
									验证码:
									<img id="num" src="image" />
									<a href="javascript:;" onclick="document.getElementById('num').src = 'image?'+(new Date()).getTime()">换一张</a>
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="number" />
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="Submit &raquo;" disabled="disabled"/>
						</p>
					</form>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
				ABC@126.com
				</div>
			</div>
		</div>
	</body>
</html>