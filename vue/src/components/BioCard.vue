<template>
<div class="container-bio">
    <body>
      <h2>Dr. Smith</h2>  
      <OfficeInfo></OfficeInfo>
      <DoctorBio></DoctorBio>
    </body>
    
</div>
</template>

<script>
import OfficeInfo from '../components/OfficeInfo.vue'
import DoctorBio from '../components/DoctorBio.vue'
export default {
name:'ReviewCard',
    components:{
        OfficeInfo,
        DoctorBio
      }
}
</script>

<style>
body > h2{
    margin: 0;
}

.container-bio{
    display: flex;
    flex-direction: column;
    justify-content: space-around;
    padding: 10px;
}


</style>