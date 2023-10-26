import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DiagnosticolistaComponent } from './diagnosticolista.component';

describe('DiagnosticolistaComponent', () => {
  let component: DiagnosticolistaComponent;
  let fixture: ComponentFixture<DiagnosticolistaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DiagnosticolistaComponent]
    });
    fixture = TestBed.createComponent(DiagnosticolistaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
