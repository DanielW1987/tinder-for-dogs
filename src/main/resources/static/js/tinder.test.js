import {flushPromises, mount, shallowMount} from '@vue/test-utils'
import Tinder from './tinder.js';
global.fetch = require('node-fetch');

global.fetch = jest.fn(() =>
  Promise.resolve({
    ok: true,
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

test('should load data from random dog response', async () => {
  const wrapper = shallowMount(Tinder);
  await flushPromises();
  const dogNameHeading = wrapper.find('#dog-name');
  expect(dogNameHeading.text()).toBe('Rex');
})
