<!DOCTYPE html>
<html>
<head>
    <title>Book Form</title>
</head>
<body>

<h2>Enter Book Details</h2>

<form action="books" method="post">

    <label for="bookId">Book ID:</label><br>
    <input type="text" id="bookId" name="bookId" required>
    <br><br>

    <label for="bookName">Book Name:</label><br>
    <input type="text" id="bookName" name="bookName" required>
    <br><br>

    <label for="price">Price:</label><br>
    <input type="number" id="price" name="price" step="0.01" required>
    <br><br>

    <button type="submit">Submit</button>

</form>

</body>
</html>