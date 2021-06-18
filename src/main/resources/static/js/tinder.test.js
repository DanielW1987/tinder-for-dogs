import { mount } from '@vue/test-utils'
import Tinder from './tinder.js';
global.fetch = require('node-fetch');

global.fetch = jest.fn(() =>
  Promise.resolve({
    json: () => Promise.resolve({
      name: "Rex",
      imageUrl: "https://image-url.com",
      id: 1
    }),
  })
);

test('shows heading', () => {
  const wrapper = mount(Tinder, {
    props: {
      title: 'Do you like him/her?'
    }
  });

  expect(wrapper.text()).toContain('Do you like him/her?');
})
