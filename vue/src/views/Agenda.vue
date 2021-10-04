<template>
  <div id="agenda" class="agenda">
  <DxScheduler
    time-zone="America/Los_Angeles"
    :data-source="dataSource"
    :current-date="currentDate"
    :views="views"
    :height="600"
    :start-day-hour="9"
    current-view="agenda"
  >
    <DxResource
      :data-source="doctors"
      :use-color-as-default="true"
      :allow-multiple="true"
      field-expr="doctorId"
      label="Doctor"
    />
    <DxResource
      :data-source="priorities"
      field-expr="priorityId"
      label="Priority"
    />
  </DxScheduler>
  </div>
</template>
<script>
import DxScheduler, { DxResource } from 'devextreme-vue/scheduler';

import { data, doctors, priorities } from '../data.js';

export default {
  components: {
    DxScheduler,
    DxResource
  },
  data() {
    return {
      views: ['agenda'],
      currentDate: new Date(2021, 4, 11),
      dataSource: data,
      doctors: doctors,
      priorities: priorities,
    };
  },
  // Stubbed out lifecycle hook - we will call appropriate agenda data here upon component creation.
  // created() {
  //           apiService.list().then( (response) => {
  //               this.users = response.data;
  //           });
  //       }
};
</script>
<style scoped>

  .agenda {

    display: flex;
  }

</style>
