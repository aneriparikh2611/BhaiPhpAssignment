<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<!-- Author Name: Aneri Parikh-->
<!--Student ID: 000770402-->

<!--session starts-->
<!-- check/init session -->
<?php
session_start();
// check parameters
if (!isset($_SESSION['entries'])) {
    $_SESSION['entries'] = Array();
}

if (isset($_POST['add'])) {
    $product = $_POST['add'];
    if (!(in_array($product, $_SESSION['entries']))) {
        $_SESSION['entries'][count($_SESSION['entries'])] = $product;
    }
}
?>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Add items</title>
        <style type="text/css">
            body{
                background-color: bisque;     
            }
            .main{
                height: 95vh;
                width: 190vh;
            }
            .left {
                border-radius: 5px;
                background-color: #ccc;
                padding: 20px;
                height: 50vh;
                width: 50vh;
                margin-left: 15%;

                float: left;
            }
            .right{
                border-radius: 5px;
                background-color: #ccc;
                padding: 20px;
                height: 50vh;
                width: 50vh;
                margin-left: 55%;
                margin-top: 10%;
                text-align: center;

            }

            h1 {
                padding-top: 5%;
                text-align: center;
            }
            input[type=text], select, textarea {
                width: 100%;
                padding: 12px;
                border: 1px solid #ccc;
                border-radius: 4px;
                resize: vertical;
                margin-top: 10%;
                margin-left: 0px;
            }
            input[type=submit] {
                background-color: #4CAF50;
                color: white;
                padding: 12px 20px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                width: 60%;
                margin-top: 20%;
                margin-left: 50px;

            }
            input[type=submit1] {
                background-color: #4CAF50;
                color: white;
                padding: 12px 20px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                width: 40%;
                margin-top: 10%;
                margin-left: 100px;
                text-align: center;


            }
            #table1{
                background-color: pink;
                border: 1px solid black;
            }
            #rightitem{

                text-align: center;
            }

            table{
                margin: 0px auto;
            }

            td{
                align: center;
            }
        </style>
    </head>
    <body>
        <div calss="main">
            <div class="left">
                <h1>Enter an item</h1>
                <form action="page2.php" method="Post">
                    <table>
                        <tr>
                            <td>
                                <input type="text" name="add" placeholder="Insert an item"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input type="submit" value="Add" />
                            </td>
                        <tr>

                        <tr>
                            <td>

                            </td>
                        </tr>
                    </table>
                </form>
                <a href="page3.php"><input type="submit1"  value="Finish" /></a>
            </div>
            <div class="right">
                <h1>Your Shopping List</h1>
                <table>
                    <tr>
                        <td>    #    </td>
                        <td>Item</td>
                    </tr>
                    <!-- create output variables-->
                    <?php
                    if (isset($_SESSION['entries'])) {
                        for ($i = 0; $i < count($_SESSION['entries']); $i++) {
                            echo "<tr><td id='rightitem'>(" . ($i + 1) . ")</td><td>{$_SESSION['entries'][$i]}</td></tr>";
                        }
                    }
                    ?>

                </table>
            </div>
        </div>
    </body>
</html>
