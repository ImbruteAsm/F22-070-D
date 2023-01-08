import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './component/dashboard/dashboard.component';
import { PerformanceComponent } from './component/performance/performance.component';
import { RiskcategoriesComponent } from './component/riskcategories/riskcategories.component';
import { InputpageComponent } from './inputpage/inputpage.component';

const routes: Routes = [
  { 
    path:'', 
    component: InputpageComponent
  },
  { 
    path:'dashboard', 
    component: DashboardComponent 
  },
  {
    path:'riskcategories',
    component: RiskcategoriesComponent,
  },
  {
    path:'performance',
    component: PerformanceComponent,
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
