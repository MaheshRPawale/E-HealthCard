import './login.css';
import React from "react";
function Login() {
    return (
      <div className="login1">
        <h1 class="title">E-Health Card</h1>
  <image src='login page.jpeg'/>
  <div class="login-container">
      <div class="login-form">
          <h2>Login</h2>
          <form action="/patient-login" method="post">
              <input type="text" name="username" placeholder="Username" required/><br/><br/>
              <input type="password" name="password" placeholder="Password" required/><br/><br/>
              <input type="submit" value="Login" onclick=''/>
          </form>
          <div>
              <a href="/registerpatient">Register</a> | <a href="/forgotpwd">Forgot Password</a>
          </div>
          </div>
          </div>
      </div>
    );
  }
  export default Login;