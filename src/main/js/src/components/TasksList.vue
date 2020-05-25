<template>
  <div id="tasksList">
    <ol>
      <li v-for="task in tasks" :key="task.text">
        {{ task.text }}
      </li>
    </ol>
    {{ info }}
  </div>
</template>

<script>

import axios from 'axios'

export default {
  name: 'TasksList',
  data () {
    return {
      tasks: [
        {text: 'Изучить JavaScript'},
        {text: 'Изучить Vue'},
        {text: 'Создать что-нибудь классное'}
      ],
      info: null
    }
  },
  mounted () {
    axios
      .get('http://localhost:8080/tasks')
      .then(response => (this.info = response.data._embedded.tasks))
  }
}
</script>

<style scoped>

</style>
