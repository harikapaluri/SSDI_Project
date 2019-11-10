<?php 
$data = json_decode(file_get_contents("php://input"));
$name = mysql_real_escape_string($data->name);
$cardno = mysql_real_escape_string($data->cardno);
$validdate = mysql_real_escape_string($data->validdate);

mysql_connect("localhost", "root", "Mission!1234"); 
mysql_select_db("bookandgo");
mysql_query("INSERT INTO dummy_payment_details VALUES('".$name."','".$cardno."','".$validdate."')");
?>