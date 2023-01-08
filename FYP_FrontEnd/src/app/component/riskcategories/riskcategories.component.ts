import { Component, OnInit } from '@angular/core';
import { DataModel } from 'src/app/models/data.model';
import { EchartService } from 'src/app/services/linechart/elinechart.service';
import { DataService } from '../../services/dataservice/data.service'

@Component({
  selector: 'app-riskcategories',
  templateUrl: './riskcategories.component.html',
  styleUrls: ['./riskcategories.component.css'],
  providers: [DataService, EchartService]
})
export class RiskcategoriesComponent implements OnInit{

  public data: DataModel[] = [];

  constructor(private dataService: DataService){
      
  }


    ngOnInit(): void {
      this.data= this.dataService.getData();
      console.log(this.data)
    }
}
