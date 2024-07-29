import './pharmareg.css';
import React from "react";
function Pharmareg() {
    return (
        <div class="regpharm">
    <div class="container">
    <h2>Pharmacist Information</h2>
    <form action="/register-pharmacist" method="post">
        <div class="row">
            <input type="text" name="pharmacist_id" placeholder="Pharmacist ID" required/>
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
            <input type="text" name="medical_name" placeholder="Medical Name" required/>
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
            <input type="text" name="qualification" placeholder="Qualification" required/>
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
            <input type="text" name="licence_no" placeholder="Licence No" required/>
        </div>

        <div class="row">
            <input type="submit" value="Register" onclick=''/> 
        </div>
    </form>
</div> 
</div>
    );
  }
  export default Pharmareg;