export default {
  template: `
       <div class="row text-center">
          <h2>{{ title }}</h2>
       </div>
        <div class="row">
            <img v-bind:src="imageUrl" class="rounded mx-auto d-block dog-photo" alt="Dog photo">
        </div>
        <div class="row">
            <h2 class="text-center" id="dog-name">{{ dogName }}</h2>
        </div>
        <div class="row">
            <div class="col-6 text-end">
                <button type="button" class="btn btn-danger .btn-lg" @click="dislike()">Dislike</button>
            </div>
            <div class="col-6">
                <button type="button" class="btn btn-success .btn-lg" @click="like()">Like</button>
            </div>
        </div>
  `,
  data() {
    return {
      dogId: '',
      dogName: '',
      imageUrl: '',
    };
  },
  props: ['title'],
  methods: {
    loadRandomDog() {
      fetch('/dogs').then((response) => {
        if (response.ok) {
          return response.json();
        }
      }).then((data) => {
        this.dogName = data.name;
        this.imageUrl = data.imageUrl;
        this.dogId = data.id;
      });
    },
    like() {
      fetch('/dogs/likes', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({
          id: this.dogId
        }),
      }).then((response) => {
        if (response.ok) {
          this.loadRandomDog();
        }
        else {
          throw new Error('Could not like dog!');
        }
      }).catch((error) => {
        console.log(error);
      });
    },
    dislike() {
      fetch('/dogs/dislikes', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({
          id: this.dogId
        }),
      }).then((response) => {
        if (response.ok) {
          this.loadRandomDog();
        }
        else {
          throw new Error('Could not dislike dog!');
        }
      }).catch((error) => {
        console.log(error);
      });
    },
  },
  mounted: function() {
    this.loadRandomDog();
  }
};
