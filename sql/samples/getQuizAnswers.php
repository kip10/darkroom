<?php
require_once 'constants.php';

try {
	$dbConn = new PDO(host,user,pass);
	$dbConn->setAttribute(PDO::ATTR_EMULATE_PREPARES, false);
	$dbConn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
	//echo '<html><h1>IT WORKED</h1></html>';
} catch(PDOException $e){
	echo '<h1>An error has ocurred.</h1><pre>', $e->getMessage(), '</pre>';
}

try{
	$name = mysql_real_escape_string($_POST['username']);

	$query = $dbConn->prepare('SELECT response, assessmentName FROM assessmentresponses WHERE username = :name ORDER BY answerTime ASC');
	$query->execute(array('name' => $name));
	
	$data = $query->fetchAll();
	
	foreach($data as $i => $row){
		echo $row['response'] . ',' . $row['assessmentName'] . '.';
	}
	
} catch (PDOException $e){
	echo '<h1>An error has ocurred.</h1><pre>', $e->getMessage(), '</pre>';
}
?>