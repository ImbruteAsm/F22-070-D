import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DashboardComponent } from './component/dashboard/dashboard.component';

import { MatGridListModule } from '@angular/material/grid-list'
import { MatCardModule } from '@angular/material/card'
import { MatSidenavModule } from '@angular/material/sidenav'
import { MatIconModule } from '@angular/material/icon'
import { MatButtonModule } from '@angular/material/button'
import { MatToolbarModule } from '@angular/material/toolbar';
import { SidebarComponent } from './component/sidebar/sidebar.component';
import { RiskcategoriesComponent } from './component/riskcategories/riskcategories.component';
import { PerformanceComponent } from './component/performance/performance.component';
import { ElinechartComponent } from './component/riskcategories/charts/elinechart/elinechart.component';
import { NgxEchartsModule } from 'ngx-echarts';
import { InputpageComponent } from './inputpage/inputpage.component'

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    SidebarComponent,
    RiskcategoriesComponent,
    PerformanceComponent,
    ElinechartComponent,
    InputpageComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatSidenavModule,
    MatIconModule,
    MatButtonModule,
    MatToolbarModule,
    MatCardModule,
    MatGridListModule,
    MatGridListModule,
    NgxEchartsModule.forRoot(
      { echarts: () => import('echarts') }
    )
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
