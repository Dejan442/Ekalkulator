<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trougao-Zvezda</title>
    <style>
    
     body {
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-image: url('slika2.jpg'); 
            background-size: cover;
            background-position: center;
            font-family: Arial, sans-serif;
        }

        .container {
            text-align: center;
            background: rgba(255, 255, 255, 0.8);
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.3);
        }

        h1 {
            font-size: 2.5em;
            color: #333;
            text-shadow: 2px 2px 5px rgba(0, 0, 0, 0.3);
            animation: glow 1.5s infinite alternate;
        }
        h2{
        font-size: 1.2em;
            color: #333;
            text-shadow: 2px 2px 5px rgba(0, 0, 0, 0.3);
            animation: glow 1.5s infinite alternate;
        
        
        }

        @keyframes glow {
            from {
                text-shadow: 2px 2px 5px rgba(0, 0, 0, 0.3), 0 0 10px #6e6ef8;
            }
            to {
                text-shadow: 2px 2px 5px rgba(0, 0, 0, 0.3), 0 0 20px #a4a4f9;
            }
        }

        form {
            margin-top: 20px;
        }

        input[type="text"] {
            width: 80%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 1em;
        }

        input[type="submit"] {
            padding: 10px 20px;
            font-size: 1em;
            color: #fff;
            background-color: #6e6ef8;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #4e4ec8;
        }
    
       
    </style>
</head>
<body>
    <div class="container">
        <h1>Impedanse za vrednosti koje ste uneli</h1>
        <form action="servlet-url" method="post">
            <label for="value1">Z1:</label>
            <input type="text" id="Z1" name="value1" value="${calculatedValue}" readonly><h2>[oma]</h2><br>

            <label for="value2">Z2:</label>
            <input type="text" id="value2" name="value2" value="${calculatedValue2}" readonly><h2>[oma]</h2><br>

            <label for="value3">Z3:</label>
            <input type="text" id="value3" name="value3" value="${calculatedValue3}" readonly><h2>[oma]</h2><br>

            
        </form>
    </div>
</body>
</html>