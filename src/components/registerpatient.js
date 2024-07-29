import './registerpatient.css';

import React from "react";
function RegisterPatient() {
    return (
      <>
        <div class="reg">
      <div class="container">
    <h2>Patient Information</h2>
    <form action="/register-patient" method="post">
        <div class="row">
            <input type="text" name="patient_id" placeholder="patient ID" required/>
        </div>

        <div class="row">
            <input type="text" name="full_name" placeholder="Full Name" required/>
        </div>

        <div class="row">
            <input type="email" name="email" placeholder="Email" required/>
        </div>

        <div class="row">
            <input type="tel" name="mobile_no" placeholder="Mobile No" required/>
        </div>

        <div class="row">
            <input type="text" name="username" placeholder="Username" required/>
        </div>

        <div class="row">
            <input type="password" name="password" placeholder="Password" required/>
        </div>

        <div class="row">
            <select name="gender" required>
                <option value="">Select Gender</option>
                <option value="male">Male</option>
                <option value="female">Female</option>
                <option value="other">Other</option>
            </select>
        </div>

        <div class="row">
            <input type="date" name="date" placeholder="date of birth" required/>
        </div>

        <div class="row">
            <textarea name="address" placeholder="Address" rows="4" required></textarea>
        </div>
        <div class="row">
            <input type="number" name="pincode" placeholder="pincode" required/>
        </div>
        <div class="row">
            <input type="submit" value="Register" onclick=''/> 
        </div>
        {/* <script>
            function fun(){
                alert("Registered Successfully!!!!")
            }
        </script> */}
        <a href='/doctorregister'>register as a doctor?</a><br/>
        <a href='/pharmacistregister'>register as a pharmacist?</a><br/>
        <a href='/pathlabregister'>register your pathlab?</a><br/>
        </form>
</div></div>
      </>
    );
  }
  export default RegisterPatient;