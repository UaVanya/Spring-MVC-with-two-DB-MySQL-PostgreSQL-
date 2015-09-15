<html>
<head>
    <meta charset="UTF-8">
    <title>index</title>
</head>
<body bgcolor="#fafad2">
<form action="/saveuser" method="post" name="formLogin">
    <table align="center">
        <tr>
            <td style="color:#ff0000">${invalidData}</td>
        </tr>
    </table>
    <table align="center" border=0>
        <tr>
            <th>Add User:</th>
        </tr>
        <tr>
            <td><input type="text" name="name" maxlength="45" required placeholder="Name"/></td>
        </tr>
        <tr>
            <td><input type="email" name="email" maxlength="45" required placeholder="E-mail"><span></span></td>
        </tr>
        <tr>
            <td>Select area: <input type="radio" name="area" id="area1" value="0"><label for="area1">Area1</label>
                <input type="radio" name="area" id="area2" value="1"><label for="area2">Area2</label>
                <input type="radio" name="area" id="area3" value="2"><label for="area3">Area3</label></td>
        </tr>
        <tr>
            <td><input type="submit" name="enter" value="Add"/></td>
        </tr>
    </table>
</form>
</body>
</html>