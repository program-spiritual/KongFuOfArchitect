import {default as Greeter} from './Greeter'
import {BugReport} from "./BugReport";

function main() {
    const greeter =  new Greeter("jacks james!")
    greeter.greet()
}

main();

const bug  = new  BugReport("bug report content")

console.log('bug report ::',bug)
