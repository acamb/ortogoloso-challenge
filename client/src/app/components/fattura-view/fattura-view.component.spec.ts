import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FatturaViewComponent } from './fattura-view.component';

describe('FatturaViewComponent', () => {
  let component: FatturaViewComponent;
  let fixture: ComponentFixture<FatturaViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FatturaViewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FatturaViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
