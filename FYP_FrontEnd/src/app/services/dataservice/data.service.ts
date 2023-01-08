import { Injectable } from '@angular/core';
import { DataModel } from '../../models/data.model';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor() { }

  public getData(): DataModel[]{
    return [
      {
        "id":1,
        "title": "Ang1",
        "price": {
          "currency": "PKR",
          "value": 199
        }
      },
      {
        "id":2,
        "title": "Ang2",
        "price": {
          "currency": "PKR",
          "value": 299
        }
      },
      {
        "id":3,
        "title": "Ang3",
        "price": {
          "currency": "PKR",
          "value": 399
        }
      }
    ]
  } 

}
