import { Component, OnInit } from '@angular/core';
import { Circle } from '../models/Circle';
import { CircleService } from '../services/circle.service';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-circle',
  templateUrl: './circle.component.html',
  styleUrls: ['./circle.component.css']
})
export class CircleComponent implements OnInit {

  circles: string[];

  constructor(circleService: CircleService, private authService: AuthService) {
    circleService.getAllSubscribedCircles(authService.getUsername()).then
    (obj=>{
      if(obj){
        this.circles = obj.json();
      }
    });
  }
  ngOnInit() {
  }
}
