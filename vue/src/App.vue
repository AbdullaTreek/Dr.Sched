<template>
  <div id="app">
    
      <router-link v-bind:to="{ name: 'home' }" v-if="$store.state.token != ''">Home</router-link>&nbsp; &nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
     
    
    <router-view />
  </div>
</template>

<script>



export default {
  name: 'App',
  components:{
    
  }
  
}
</script>
<style>

  #app {

    font-family: 'Open Sans', sans-serif;
    height: 100%;
    width: 100%;
  }

  #nav {

    display: flex;
    flex-direction: row;
    height: 5%;
  }

</style>

<script>

export default {
  name: "app",
  
};

</script>