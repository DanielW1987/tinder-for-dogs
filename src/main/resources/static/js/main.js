import Tinder from './tinder.js';

const app = Vue.createApp({});
app.component('random-dog', Tinder);
app.mount('#tinder-app');
