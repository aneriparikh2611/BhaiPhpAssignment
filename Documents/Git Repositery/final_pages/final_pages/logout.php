<?php /*

Subject Code and Section = INT322A (Section A)
Student Name = PARTH PARIKH
Assignment 2
Date Submitted = 7th April 2014

Student Declaration

I/we declare that the attached assignment is my/our own work in accordance with Seneca Academic Policy. 
No part of this assignment has been copied manually or electronically ,
from any other source (including web sites) or distributed to other students.

Name =    PARTH PARIKH 

Student ID = 011-195-138


*/ ?>



<?php

	session_start();
	// convert http to https.	
	if(!isset($_SERVER['HTTPS']) || $_SERVER['HTTPS'] == "")
	{
		 $convert = "https://".$_SERVER['HTTP_HOST'].$_SERVER['REQUEST_URI'];
		header("Location: $convert");
	} 
       
	//If user is logged in then destroy the session
	if($_SESSION['username'])
	{
		session_destroy();
		session_unset();
		setcookie (session_id(), "", time() - 1);  
		header('Location:login.php');
		exit;
	}
	//If user is not logged in then redirects user to login.php
	else
	{
		header('Location:login.php');
		exit;
	}
?>

