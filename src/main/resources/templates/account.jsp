<%@ page contentType="text/html;language="java"  charset=UTF-8"
	pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウント登録</title>
</head>
<body>
<form action="/example/UserController" method = "post">

    <label for="custid">ID</label>
 <br><br>
 <input type="text" name="custid">
<br>
</br>

<label for="custname">ユーザー名</label>
 <br><br>
 <input type="text" name="custname" id="custname">
<br>
</br>

<label for="orgname">組織名</label>
 <br><br>
 <input type="text" name="orgname" id="orgname">
<br>
</br>

<label for="password">Password</label>
 <br><br>
 <input type="password" name="password" id="password">
<br><br>

<input type="button" value="登録">

</form>
</body>
</html>
