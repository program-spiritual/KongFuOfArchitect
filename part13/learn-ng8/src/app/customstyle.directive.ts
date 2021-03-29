import {Directive, ElementRef} from '@angular/core';

@Directive({
  selector: '[appCustomstyle]'
})
export class CustomstyleDirective {

  constructor(el: ElementRef) {
    el.nativeElement.style.fontSize = '24px';
  }

}
