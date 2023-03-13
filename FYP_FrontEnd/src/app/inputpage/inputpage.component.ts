import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable, timer } from 'rxjs';
import { Domain } from 'src/app/Domain';
import { DataService } from 'src/app/services/dataservice/data.service';
import { DomainService } from 'src/app/services/domain/domain.service';

@Component({
  selector: 'app-inputpage',
  templateUrl: './inputpage.component.html',
  styleUrls: ['./inputpage.component.css']
})
export class InputpageComponent{
public pic1: string="assets/images/InputPicture.jpeg";
constructor(private regDom: DomainService, private dataservice: DataService){}

value=""
getVal(val: any){
  console.warn(val)
  this.value= val
  const urlvariable="http://localhost:9901/scan?target=";
  this.value= urlvariable + this.value;
  this.dataservice.InputData(this.value);
}

  }


