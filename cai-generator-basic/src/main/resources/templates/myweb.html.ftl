<!DOCTYPE html>
<html>
<head>
    <title>
        CG官网
    </title>
</head>
<body>
<h1>欢迎来到 CG 官网</h1>
<ul>
    <#list menuItems as item>
        <li><a href="${item.url}">${item.label}</a></li>
    </#list>
</ul>
<footer>
    ${currentYear} CG 官网，All rights reserved.
</footer>
</body>
</html>