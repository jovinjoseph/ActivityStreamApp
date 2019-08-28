import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MessageCircleComponent } from './message-circle.component';

describe('MessageCircleComponent', () => {
  let component: MessageCircleComponent;
  let fixture: ComponentFixture<MessageCircleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MessageCircleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MessageCircleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
