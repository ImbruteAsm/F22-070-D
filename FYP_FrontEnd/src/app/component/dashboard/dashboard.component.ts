import { Component } from '@angular/core';
import { EChartsOption } from 'echarts';
import tabledatas from './../../tabledata.json'


interface tabledata{
  Severity:String;
  Category: String;
  Notice: String;
  Hosts: String;
}

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent {
  students: tabledata[] = tabledatas;

  constructor(){}


   gaugeData = [
    {
      value: 70,
      name: 'Rx Score',
      title: {
        offsetCenter: ['0%', '-20%']
      },
      detail: {
        valueAnimation: true,
        offsetCenter: ['0%', '20%']
      }
    },]
  
  option1: EChartsOption = {
    title: {
      text: 'My Score'
    },
    series: [
      {
        type: 'gauge',
        startAngle: 90,
        endAngle: -360,
        pointer: {
          show: false
        },
        progress: {
          show: true,
          overlap: false,
          roundCap: true,
          clip: false,
          itemStyle: {
            borderWidth: 1,
            borderColor: '#464646'
          }
        },
        axisLine: {
          lineStyle: {
            width: 40
          }
        },
        splitLine: {
          show: false,
          distance: 0,
          length: 10
        },
        axisTick: {
          show: false
        },
        axisLabel: {
          show: false,
          distance: 50
        },
        data: this.gaugeData,
        title: {
          fontSize: 14
        },
        detail: {
          width: 50,
          height: 14,
          fontSize: 14,
          color: 'auto',
          borderColor: 'auto',
          borderRadius: 20,
          borderWidth: 1,
          formatter: '{value}%'
        }
      }
    ]
}

option2: EChartsOption = {
  title: {
    text: 'Performance'
  },
  tooltip: {
    trigger: 'axis'
  },
  legend: {
    data: ['Company Score', 'Technology Avg']
  },
  toolbox: {
    feature: {
      saveAsImage: {}
    }
  },
  xAxis: {
    name: 'Technology Avg',
    type: 'category',
    boundaryGap: false,
    data: ['31 Jul', '14 Aug', '28 Aug', '11 Sep', '25 Sep', '09 Oct', '23 Oct']
  },
  yAxis: {
    type: 'value'
  },
  series: [
    {
      name: 'Technology Avg',
      type: 'line',
      stack: 'Total',
      data: [750, 752, 750, 752, 760, 750, 750]
    },
    {
      name: 'Company Score',
      type: 'line',
      stack: 'Total',
      data: [50, 52, 51, 51, 50, 50, 50]
    },
  ]
};









}