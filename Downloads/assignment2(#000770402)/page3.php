<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<!-- Author Name: Aneri Parikh-->
<!--Student ID: 000770402-->
<?php
session_start();
?>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Display all informations</title>
        <style type="text/css">
            body{
                background-color: bisque; 
                text-align: center;
            }
            #left {
                border-radius: 5px;
                background-color: #ccc;
                padding: 20px;
                height: 50vh;
                width: 50vh;
                margin-left: 15%;
                text-align: center;
                float: left;
            }
            #right{
                border-radius: 5px;
                background-color: #ccc;
                padding: 20px;
                height: 50vh;
                width: 50vh;
                margin-left: 55%;
                margin-top: 10%;
                text-align: center;
            }

            h1{
                margin-top: 0px;
                font-family: "Times New Roman", Times, serif;
                font-size: 3em;
            }

            table{
                margin-left: 150px;
               
            }
        </style>
    </head>
    <body
        <header>
            <h1>Summary</h1>
        </header>
        <div class="main">
            <div id="left">
                <!--display store details-->
                <?php
                echo "<h1><u>Store Details</u></h1><br>";
                echo "<h3>Store Name:{$_SESSION["StoreName"]} </h3><br>";
                echo "<h3>Store Address : {$_SESSION["Address"]} </h3><br>";
                echo "<h3>City: {$_SESSION["City"]}</h3> <br>";
                echo "<h3>Posal Code : {$_SESSION["PostalCode"]}</h3><br>";
                ?>
            </div>
            <div id="right">

                <!--display shopping list-->
                <h1><u> Your Shopping List</u></h1>
                <table>
                    <?php
                     for ($i = 0; $i < count($_SESSION['entries']); $i++) {
                            echo "<tr><td id='rightitem'>(" . ($i + 1) . ")</td><td>{$_SESSION['entries'][$i]}</td></tr>";
                        }
                    ?>
                </table>         
            </div>
        </div>

    </body>
</html>
