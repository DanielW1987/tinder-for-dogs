import { mount } from '@vue/test-utils'
import Tinder from './tinder.js';
global.fetch = require('node-fetch');

global.fetch = {
  fetch() { return Promise.resolve({ data: [] }) },
}

test('shows heading', () => {
  const wrapper = mount(Tinder, {
    props: {
      title: 'Do you like him/her?'
    }
  });

  expect(wrapper.text()).toContain('Do you like him/her?');
})
