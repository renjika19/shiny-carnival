import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PolkamanDbComponent } from './polkaman-db.component';

describe('PolkamanDbComponent', () => {
  let component: PolkamanDbComponent;
  let fixture: ComponentFixture<PolkamanDbComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PolkamanDbComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PolkamanDbComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
