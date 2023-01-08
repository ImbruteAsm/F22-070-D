import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { EChartsOption } from 'echarts';
import { EchartService } from './../../../../services/linechart/elinechart.service';
import { BasicEchartLineModel } from './../../../../models/elinechart.model';


@Component({
  selector: 'app-elinechart',
  templateUrl: './elinechart.component.html',
  styleUrls: ['./elinechart.component.css'],
  providers:[EchartService]
})
export class ElinechartComponent  implements OnInit, OnDestroy {
  _chartOption!: EChartsOption;
  subscription!: Subscription;
  isDarkMode: boolean = false;
  _theme!: string;
  constructor(private echartService: EchartService) { }

  ngOnInit(): void {
    this.subscription = this.echartService.getbasicLineEchartData().subscribe(data => {
      this._initBasicLineEchart(data);
    });
  }
    ngOnDestroy() {
      if (this.subscription) {
        this.subscription.unsubscribe();
      }
    }
  
    private _initBasicLineEchart(chartData: BasicEchartLineModel[]) {

      this._theme = this.isDarkMode ? 'dark' : '';
  
      this._chartOption = {
        tooltip: {
          show: true
        },
        // background: 'transparent',
        xAxis: {
          type: 'category',
          data: chartData.map(m => ({
            value: m.name
          }))
        },
        yAxis: {
          type: 'value'
        },
        series: [{
          data: chartData.map(m => ({
            value: m.value
          })),
          type: 'line'
        }]
      };
    }

}
