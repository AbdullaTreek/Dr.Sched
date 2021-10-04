<template>
  <div class="registerDoctor">
    <h1 id="title1">DrSched</h1>
    <h2 id="title2">We make booking with your doctor easy.</h2>
    <p id="title3">Find your doctor and book today.</p>


    <div id="register" class="text-center">
<form class="form-register" @submit.prevent="register">
      <h1 class="h3 mb-3 font-weight-normal">New Doctor Registration</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <label for="username" class="sr-only">Username</label><br>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      /><br>
      <label for="password" class="sr-only">Password</label><br>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      /><br>
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      /><br>
      <button class="btn btn-lg btn-primary btn-block" type="submit">
        Create Account
      </button><br><br>

      <router-link :to="{ name: 'login' }">Already registered?</router-link>
</form>
     </div>

  </div>

  
  
</template>

<style scoped>

    .form-control {

        margin: 3px;
    }

    .btn {
        margin: 3px;
    }

     #register {
    text-align: right;
    /* margin-right: 4rem; */
    display: grid;
    grid-area: register2;
    justify-content: center;
    align-content: center;
  }

    .registerDoctor {

        display: grid;
    grid-template-columns: 1fr 1fr 1fr;
    /* align-items: right; */
    grid-template-areas: 
    "text empty register"
    "text2 empty2 register2"
    "text3 empty3 register3";
    }

    #title1 {
        display: grid;
        grid-area: text;
        justify-content: center;
    }

     #title2 {
        display: grid;
        grid-area: text2;
        align-content: center;
        margin-left: 1rem;
    }
     #title3 {
        display: grid;
        grid-area: text3;
        margin-left: 1rem;
    }

</style>

<script>
import authService from '../services/AuthService';

export default {
  name: "splash",
data() {
    return {
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
      } else {
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