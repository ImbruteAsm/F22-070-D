import { Component } from '@angular/core';
import { EChartsOption } from 'echarts';

@Component({
  selector: 'app-performance',
  templateUrl: './performance.component.html',
  styleUrls: ['./performance.component.css']
})
export class PerformanceComponent {

  performance: EChartsOption = {
    legend: {},
    tooltip: {},
    dataset: {
      source: [
        ['product', 'Connection Avg', 'Your Company'],
        ['Endpt Sec', 50, 70,],
        ['DB Server', 100, 100],
        ['Cyber Attacks', 90,100 ],
        ['Malware', 95, 78],
        ['DNS', 90, 100],
        ['Network Sec', 78, 100],
        ['SSL/TLS', 90, 78]
      ]
    },
    xAxis: { type: 'category' },
    yAxis: {},
    // Declare several bar series, each will be mapped
    // to a column of dataset.source by default.
    series: [{ type: 'bar' }, { type: 'bar' }]
  };
  
  

}
