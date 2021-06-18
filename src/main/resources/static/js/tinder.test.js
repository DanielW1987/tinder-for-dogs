import { mount } from '@vue/test-utils'
import Tinder from './tinder.js';
global.fetch = require("node-fetch");

test("shows heading", () => {
  const wrapper = mount(Tinder);

  expect(wrapper.text()).toContain("Do you like him/her?");
})
