<template>
  <div class="loginpage">
    <span id="loginlogo">DrSched</span>

    <login id="login"></login>

  </div>
</template>

<script>
import login from '../components/Login.vue';

export default {
  name: "loginpage",
  components: {
    login,
  },
}
</script>
<style scoped>

.loginpage {

    display: flex;
    height: 100vh;
    width: 100vw;
    background-image: url("../assets/Loginbackground.png");
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;

}

#login {

  display: flex;
    align-items: center;
    justify-content: right;
    margin-right: 12rem;
    width: 100%;
}

#loginlogo {

  display: flex;
  color:#07329E;
  font-size: 4em;
  font-family: 'Open Sans', sans-serif;
  font-weight: 800;
  margin-bottom: 5rem;
  margin-top: 1rem;
  margin-left: 1rem;
  margin-right: 1rem;
}

</style>