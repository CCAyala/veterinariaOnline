import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnalisislistaComponent } from './analisislista.component';

describe('AnalisislistaComponent', () => {
  let component: AnalisislistaComponent;
  let fixture: ComponentFixture<AnalisislistaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AnalisislistaComponent]
    });
    fixture = TestBed.createComponent(AnalisislistaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
