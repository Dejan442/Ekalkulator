<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Transformator</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: 'Roboto', sans-serif;
            background: url('trafo3.jpg') no-repeat center center fixed;
            background-size: cover;
            color: #333;
        }
        .form-container {
            background-color: rgba(255, 255, 255, 0.95);
            max-width: 300px; 
            margin: 30px auto; 
            padding: 15px; 
            border-radius: 6px; 
            box-shadow: 0 3px 10px rgba(0, 0, 0, 0.1);
            color: #333;
        }
        .form-container h2 {
            text-align: center;
            margin-bottom: 10px; 
            font-size: 18px; 
            color: #555;
        }
        .form-container label {
            display: block;
            margin-bottom: 4px; 
            font-weight: 600;
            font-size: 12px; 
            color: #555;
        }
        .form-container input[type="text"] {
            width: 100%;
            padding: 6px; 
            margin-bottom: 8px; 
            border: 1px solid #ddd;
            border-radius: 3px; 
            background-color: #f9f9f9;
            color: #333;
            font-size: 12px; 
        }
        .form-container input[type="text"]:focus {
            outline: none;
            border-color: #007BFF;
            background-color: #fff;
        }
        .form-container button {
            display: block;
            width: 100%;
            padding: 8px; 
            background-color: #007BFF;
            color: white;
            border: none;
            border-radius: 3px; 
            font-size: 12px; 
            font-weight: bold;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        .form-container button:hover {
            background-color: #0056b3;
        }
        .form-container h2 + h2 {
            display: inline;
            font-size: 10px; 
            color: #777;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Prikaz Rezultata</h2>
        <form action="izvestaj1.rptlibrary" method="post">
            
              <label for="value1">Up:</label>
            <input type="text"  name="value1" value="${calculatedValue1}" readonly><h2>[v]</h2><br>
            
              <label for="value1">Us:</label>
            <input type="text"  name="value1" value="${calculatedValue2}" readonly><h2>[v]</h2><br>
            
              <label for="value1">Np:</label>
            <input type="text"  name="value1" value="${calculatedValue3}" readonly><h2>[br]</h2><br>
            
              <label for="value1">Ns:</label>
            <input type="text"  name="value1" value="${calculatedValue4}" readonly><h2>[br]</h2><br>
            
              <label for="value1">Is:</label>
            <input type="text"  name="value1" value="${calculatedValue5}" readonly><h2>[A]</h2><br>
            
              <label for="value1">Ip:</label>
            <input type="text"  name="value1" value="${calculatedValue6}" readonly><h2>[A]</h2><br>

            <button type="submit">Predhodni rezultati</button>
        </form>
    </div>
</body>
</html>

