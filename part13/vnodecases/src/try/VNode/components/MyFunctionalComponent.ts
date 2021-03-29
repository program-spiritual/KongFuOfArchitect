import {VNodeFlags} from "@/enum/VNodeFlags";

export class MyFunctionalComponent {
  render() {
    return {
      tag:VNodeFlags.COMPONENT_FUNCTIONAL
    }
  }
}
