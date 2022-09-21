import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FattureListComponent } from './fatture-list.component';

describe('FattureListComponent', () => {
  let component: FattureListComponent;
  let fixture: ComponentFixture<FattureListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FattureListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FattureListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
