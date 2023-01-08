import { Component } from '@angular/core';
import { Resolve } from '@angular/router';
import { Observable, timer } from 'rxjs';

@Component({
  selector: 'app-inputpage',
  templateUrl: './inputpage.component.html',
  styleUrls: ['./inputpage.component.css']
})
export class InputpageComponent {
  public resolve(): Observable<number> {
    return timer(7000);
   }
}
