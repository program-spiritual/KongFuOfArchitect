import {StringValidator} from "./StringValidator";

export const numberRegexp = /^[0-9]+$/;

 class ZipCodeValidator implements StringValidator  {
  isAcceptable(s: string): boolean {
    return s.length === 5 && numberRegexp.test(s);
  }

}
export {ZipCodeValidator}
export {ZipCodeValidator as mainValidator}
