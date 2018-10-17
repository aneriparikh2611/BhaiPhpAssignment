<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<!-- Author Name: Aneri Parikh-->
<!--Student ID: 000770402-->
<!--session starts-->
<?php
session_start();
?>
<html>
    <head>
        <meta charset="UTF-8">
        <title>validation page</title>
        <style type="text/css">
            body{
                background-color: bisque;
            }
            table, tr ,td{
                border: 1px solid black;
            }

            table {
                border-collapse: collapse;
                width: 50%;
                margin: 0px auto;
                text-align: center;

            }

            tr {
                height: 50px;
                font-size: 20px;
                background-color: appworkspace;
            }
            input[type=submit] {
                background-color: #4CAF50;
                color: white;
                padding: 12px 20px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                width: 100%;


            }

        </style>
    </head>
    <body>
        <div class="main">
            <table>
                <!--Validation as per conditions-->
                <?php
                $StoreName = filter_input(INPUT_POST, "StoreName", FILTER_SANITIZE_STRING);
                if ($StoreName !== null) {
                    if (preg_match('/^[A-Z][a-z]+[\s][0-9]+[\s][A-z][a-z]+[\s][A-Z]?[a-z]+?$/', $StoreName) == 0) {
                        echo "<tr><td>Not valied store name</td><tr>";
                    } else {
                        //store a value in session from post perameter
                        $_SESSION["StoreName"] = $_POST["StoreName"];
                        echo "<tr><td>Store name  is ok.</td><tr>";
                    }
                } else {
                    echo "<tr><td>Store name missing</td><tr>";
                }

                $Address = filter_input(INPUT_POST, "Address", FILTER_SANITIZE_STRING);
                if ($Address !== null) {
                    if (preg_match('/^[0-9]+[\s][A-Z][a-z]+[\s](st|rd|ave|blvd)[\.]$/', $Address) == 0) {
                        echo "<tr><td>Not valied Address</td><tr>";
                    } else {
                        //store a value in session from post perameter
                        $_SESSION["Address"] = $_POST["Address"];
                        echo "<tr><td>Address is ok.</td><tr>";
                    }
                } else {
                    echo "<tr><td>Address is missing</td><tr>";
                }

                $City = filter_input(INPUT_POST, "City", FILTER_SANITIZE_STRING);
                if ($City !== null) {
                    if (preg_match('/^[A-z][a-z]+$/', $City) == 0) {
                        echo "<tr><td>Not valied City</td><tr>";
                    } else {
                        //store a value in session from post perameter
                        $_SESSION["City"] = $_POST["City"];
                        echo "<tr><td>City is ok.</td><tr>";
                    }
                } else {
                    echo "<tr><td>City name missing</td><tr>";
                }

                $PostalCode = filter_input(INPUT_POST, "PostalCode", FILTER_SANITIZE_STRING);
                if ($PostalCode !== null) {
                    if (preg_match('/^[A-z][0-9][A-Z][\s][0-9][A-Z][0-9]$/', $PostalCode) == 0) {
                        echo "<tr><td>Not valied Postal Code</td><tr>";
                    } else {
                        //store a value in session from post perameter
                        $_SESSION["PostalCode"] = $_POST["PostalCode"];
                        echo "<tr><td>Postal Code is ok.</td><tr>";
                    }
                } else {
                    echo "<tr><td>Postal code is  missing</td><tr>";
                }
                //If all validations are right then redirect next page
                if ((isset($_SESSION["StoreName"])) && isset($_SESSION["Address"]) && isset($_SESSION["City"]) && isset($_SESSION["PostalCode"])) {
                    echo"     <tr><td><a href='page2.php'>Build your shopping list</a></td></tr>      ";
                }
                ?>
                <!--link for last page-->
                <tr><td><a href="index.html"><input type="submit" value="Go Back!!"></a></td></tr>


            </table>
        </div>
    </body>
</html>
