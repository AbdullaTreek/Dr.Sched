<template>
<div class="profile">
  <p>Dr Sched</p>
    <div class ="cards">
    <div class="bio-card">
        <BioCard></BioCard>
      </div>

      <div class="review-card">
         <ReviewList/>
      </div>
    </div>
    <div class="footer">
      <p>Footer</p>
  </div>
</div>

</template>

<script>

import ReviewList from '../components/ReviewList.vue'

import BioCard from '../components/BioCard.vue'

export default {
  
    name: 'review',
    components:{
    BioCard,
    ReviewList
       
  }

}
</script>

<style>

.profile{
  display: flex;
  flex-direction: column;
  background-color:#69d6f7;
  height: 100vh;
}

.cards{
  display: flex;
  height: 50%;
  border-radius: 25px;
    
}

.bio-card{
  background-color:#fcfcfc;
  flex-grow: 2;
  margin: 10px 5px 10px 20px;
  border-radius: 15px;
}

.review-card{
  background-color:#fcfcfc;
  flex-grow: 1;
  margin: 10px 20px 10px 5px;
  border-radius: 15px;
}

</style>