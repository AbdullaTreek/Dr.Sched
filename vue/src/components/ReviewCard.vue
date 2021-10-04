<template>
<div class= "container-review">
    <body>
        <h2>Reviews</h2>
      

        <ReviewForm @review-submitted="addReview" class="review-form"></ReviewForm>
      
        <ReviewList></ReviewList>
    </body>
</div>
</template>

<script>
import ReviewForm from '../components/ReviewForm.vue'
import ReviewList from '../components/ReviewList.vue'

export default {

    name:'ReviewCard',
    components:{
        ReviewForm,
        ReviewList
    }

}
</script>


<style>


.container-review{
    display: flex;
    justify-content: space-around;
    padding: 10px;    
}

body > h2{
    margin: 0;
    

}

.review-form{
    display: block;
    width: 100%;
}
 
</style>