<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login Page</title>
<style>
  /* Style the form container */
  .container {
    width: 300px;
    margin: 0 auto;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
  }

  /* Style the input fields */
  input[type=text], input[type=password] {
    width: 100%;
    padding: 10px;
    margin: 5px 0 20px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
  }

  /* Style the login button */
  button {
    background-color: #4CAF50;
    color: white;
    padding: 10px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    width: 100%;
  }

  /* Add a hover effect for buttons */
  button:hover {
    background-color: #45a049;
  }
</style>
</head>
<body>

<div class="container">
  <h2>Login</h2>
  <form id="loginForm">
    <label for="uname"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="uname" id="uname" required>

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="psw" id="psw" required>

    <button type="button" onclick="login()">Login</button>
  </form>
</div>

<script>
function login() {
    var username = document.getElementById("uname").value;
    var password = document.getElementById("psw").value;

    // Make a POST request to your API endpoint for user authentication
    fetch('https://yourapi.com/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            username: username,
            password: password
        })
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json();
    })
    .then(data => {
        // Handle successful authentication response
        // For example, redirect to a success page
        window.location.href = "success.jsp";
    })
    .catch(error => {
        // Handle error
        console.error('There was a problem with the login:', error);
        // Optionally, display an error message to the user
        alert('Invalid username or password. Please try again.');
    });
}
</script>

</body>
</html>
