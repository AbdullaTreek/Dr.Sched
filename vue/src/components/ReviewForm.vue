<template>
    <div>
        <button
      id="show-form-button"
      href="#"
      v-if="showForm === false"
      v-on:click.prevent="showForm = true"
      >Open Review Form</button>

        <form class="reviewForm" @submit.prevent="OnSubmit" v-if="showForm === true">

                <label>Submit Review</label>
                <input type="text" required v-model = "review"> 
                <label>Rating</label>
                <select id ="rating" v-model.number="rating">
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
                <option>5</option>  
                </select>
                <button class="submit-button">Submit</button>
                <button id="unshow-form-button" href="#" v-if="showForm === true" v-on:click.prevent="showForm = false">Close Form</button>
              
        </form>
    </div> 
</template>

<script>
export default {

data(){
    return{
        showForm:false,
        review: null,
        rating: null
    }
},

    method:{
        OnSubmit(){
            let UserReview = {
                review: this.review,
                rating: this.rating
            }
            
            console.log(UserReview);

            // TODO: call axios webservice method
            // that will process the post, include
            // the object UserReview above on the request.



            this.review = null
            this.rating = null
        },

        addReview(UserReview){
            this.reviews.push(UserReview)
            this.resetForm();
        },
        resetForm() {
        this.showForm = false;
        this.newReview = {};
        }

    }
}
</script>

<style scoped>

    *{
        background: white;
        text-align: left;
        border-radius: 10px ;
    }

    label{
        color: #aaa;
        display: inline-block;
        margin: 25px 0 15px;
        font-size: 0.6em;
        text-transform: uppercase;
        letter-spacing: 1px;
        font-weight: bold;        
    }

    input{
        display: block;
        padding: 10px 6px;
        width: 100%;
        box-sizing: border-box;
        border: none;
        border-bottom: 1px solid #ddd;
        color: #555;
    }

    .submit-button{
        margin-left: 25px;
        padding: 5px 30px;
    }

    button{
       margin: 1%;
       background-color: #0019a8; 
       border: none;
       color: white;
       padding: 5px 10px;
    }



</style>