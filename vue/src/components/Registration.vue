<template>

    <div id="register">
<form class="form-register" @submit.prevent="register">
      <span id="registerbtn">Register</span>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      />
      
      <div class="doctor-box"><input type="checkbox" id="doctor-box" class="form-control" v-model="isDoctor"> <label for="doctor-box">Are you a doctor?</label></div>
      <button class="btn btn-lg btn-primary btn-block" type="submit">
        Submit
      </button>

      <!-- <router-link :to="{ name: 'login' }">Already registered?</router-link> -->
</form>
     </div>
  
</template>

<style scoped>

    .form-register {
      display: flex;
      flex-direction: column;
      align-items: center;
      gap: 5px;
      background: #272b4a;
      border-radius: 1rem;
      padding: 2rem;
        
    }

    .btn {
  margin: 3px;
  background: #6b89c6;
	border-radius: 1rem;
	font-family: 'Open Sans', sans-serif;
	cursor: pointer;
  font-size: 1.25em;
  color: white;
  width: 140px;
  height: 35px;
  font-weight: 600;
  padding-left: 5px;
  }

  #registerbtn {

  font-size: 1.25em;
  color: white;
  font-family: 'Open Sans', sans-serif;
  font-weight: 600;
  text-decoration: underline;
  margin-bottom: 1rem;
  }

  .sr-only {

    font-weight: 600;
    margin-right: 5.5rem;
    align-items: left;
    color: white;
  }

  .doctor-box {

    margin-right: 1rem;
    color: white;
  }

  #register {

    
  }

  .form-control {


  }

  .alert {

      color: white;
  }
    

</style>

<script>
import authService from '../services/AuthService';

export default {
  name: "registration",
data() {
    return {
    isDoctor: false,
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } 
      
      else if(this.isDoctor === true) {
          this.user.role = "doctor";
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
      
      else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>