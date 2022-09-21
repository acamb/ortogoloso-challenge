import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DettaglioViewComponent } from './dettaglio-view.component';

describe('DettaglioViewComponent', () => {
  let component: DettaglioViewComponent;
  let fixture: ComponentFixture<DettaglioViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DettaglioViewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DettaglioViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
