import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RiskcategoriesComponent } from './riskcategories.component';

describe('RiskcategoriesComponent', () => {
  let component: RiskcategoriesComponent;
  let fixture: ComponentFixture<RiskcategoriesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RiskcategoriesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RiskcategoriesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
