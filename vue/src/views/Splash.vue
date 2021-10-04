<template>
  <div class="splash">
    <div class="title"><span id="logo">DrSched</span>
      
    <span id="header2">We make booking with your doctor easy.</span>
    <span id="header3">Find your doctor and book today.</span>
      <!-- <router-link v-bind:to="{ name: 'home' }" v-if="$store.state.token != ''">Home</router-link>&nbsp; &nbsp; -->
      
    </div>
    
    <registration id="registration"></registration>
    <!-- <router-link v-bind:to="{ name: 'login' }" v-if="$store.state.token = ''">Login</router-link>
    <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link> -->

  </div>

</template>

<style scoped>

    .title {

      display: flex;
      flex-direction: column;
      margin-top: 1rem;
      margin-left: 1rem;
      margin-right: 1rem;
      height: 90%;
      justify-content: flex-start;
      align-items: left;
      gap: 3rem;
    }

    .splash {

    display: flex;
    height: 100vh;
    width: 100vw;
    background-image: url("../assets/SplashBackground.png");
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
    
    
    }
    
    #registration {

    display: flex;
    align-items: center;
    justify-content: center;
    width: 40%;
    
      
    }

    #header2 {


      display: flex;
      justify-content: flex-start;
      align-items: center;
      height: 20%;
      font-weight: 800;
      font-size: 3em;
      color:#07329E;
      width: 40%;

    }

    #header3 {

      display: flex;
      justify-content: flex-start;
      align-items: center;
      height: 5%;
      font-weight: 800;
      font-size: 1.5em;
      color:#07329E;
      margin-top: 1rem;

    }

    #logo {

    color:#07329E;
    font-size: 4em;
    font-family: 'Open Sans', sans-serif;
    font-weight: 800;
    margin-bottom: 5rem;
  }


</style>

<script>
import registration from '../components/Registration.vue';
// import splashslogan from '../components/SplashSlogan.vue';

export default {
  name: "splash",
  components: {
    registration,
    // splashslogan,
  },
}

</script>