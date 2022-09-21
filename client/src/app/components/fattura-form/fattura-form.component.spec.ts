import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FatturaFormComponent } from './fattura-form.component';

describe('FatturaFormComponent', () => {
  let component: FatturaFormComponent;
  let fixture: ComponentFixture<FatturaFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FatturaFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FatturaFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
