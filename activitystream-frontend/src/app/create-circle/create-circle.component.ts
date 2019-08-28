import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { Router } from '@angular/router';
import { MessageService } from './../services/message.service';
import { CircleService } from '../services/circle.service';
import { AuthService } from '../services/auth.service';
import { Circle } from '../models/Circle';
import { AuthGuard } from '../guards/index';

@Component({
  selector: 'app-create-circle',
  templateUrl: './create-circle.component.html',
  styleUrls: ['./create-circle.component.css'],
  
})
export class CreateCircleComponent implements OnInit {
 
  circleName: string;
  subscribeCircleName: string;
  unSubscribeCircleName: string;
  creatorId: string;
  userCircleUsername: string;
  userCircleCircleName: string;
  circleList:any [] =[];
  subscribedCircles: string[];
  toBeSubscribedCircles: Circle[];
  
  constructor(private circleSrv:CircleService, private authService: AuthService, private router: Router,private messageService: MessageService ) {
    this.creatorId = authService.getUsername();
    this.userCircleUsername = this.creatorId;
  }
  
  public ngOnInit() {
    this.messageService.clear();
    this.getCircleList();
  }
  
  circle=new Circle();
   createCircle() {
    this.circleSrv.createCircle(this.circleName, this.creatorId).then
      (obj=>{
        if(obj){
          this.router.navigate(['/message']);
        }
        // else{
        //   this.messageService.error("not able to create circle");
        // }
      });  
  }

    //Method to add user from circle(subscribe)
  createUserCircle() {
    this.circleSrv.addUserToCircle(this.subscribeCircleName, this.userCircleUsername).then
      (obj=>{
        if(obj){
          this.router.navigate(['/message']);
        }
        // else{
        //    this.messageService.error("not able to add user to circle");
        // }
      });      
  }

  //Method to remove user from circle(unsubscribe)
  removeUserCircle() {
    this.circleSrv.removeUserFromCircle(this.unSubscribeCircleName, this.userCircleUsername).then
      (obj=>{
        if(obj){
          this.router.navigate(['/message']);
        }
        else{
          this.messageService.error("Not able to remove user from circle");
        }
      });      
  }

  //Method to get all circles avaiable for subscription
  getCircleList(){  
     this.circleSrv.getAllSubscribedCircles(this.userCircleUsername).then
    (obj=>{
      if(obj){
        this.subscribedCircles = obj.json();
      }
    });
    this.circleSrv.getCircleList().then
    (obj=>{
      if(obj){
        this.toBeSubscribedCircles = obj.json();
        if(this.subscribedCircles !== null && this.subscribedCircles.length !=0) {
          for(let circle of this.subscribedCircles){
           this.deleteCircleFromList(circle);
          }        
        }
      }
    });   
  }

  deleteCircleFromList(circleName: string){
    const index: number = this.toBeSubscribedCircles.map(e=>e.circleName).indexOf(circleName);
    if(index !==-1){
      this.toBeSubscribedCircles.splice(index, 1);
    }
   }
}