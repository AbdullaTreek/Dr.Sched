<template>
  <div class="main">
      <h5>Review by {{ firstName}} {{ lastName }}</h5>

      <div class="stars">
          <img 
            src='../assets/GoldStar.png'
            v-for='n in rating' 
            v-bind:key = 'n'
          />
      </div>

      <p>{{ review }}</p>
  </div>
</template>

<script>
export default {
data(){
        return{
            firstName: 'Yousef',
            lastName: 'Khudair',
            review: 'Great experience the staff is very nice and office very clean',
            rating: 3
        }
    }

}
</script>
    
<style scoped>
div.main {
  margin: 1rem 0;
  
}

h5{
  margin-right: auto;
}
img{
  display: inline-block;
  height: 2rem;
  margin: 0 0.5rem;
  object-position: right top;
}

</style>
