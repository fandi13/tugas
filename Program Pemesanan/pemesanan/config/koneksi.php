<?php
// koneksi ke mysql
$dbHost = "localhost";
$dbUser = "root";
$dbPass = "";
$dbName = "toko";
mysql_connect($dbHost, $dbUser, $dbPass);
mysql_select_db($dbName);

error_reporting(0);
?>