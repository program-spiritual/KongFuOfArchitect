import {VNodeFlags} from "@/enum/VNodeFlags";

export class MyStatefulComponent {
  render() {
    return {
      tag:VNodeFlags.COMPONENT_STATEFUL
    }
  }
}
