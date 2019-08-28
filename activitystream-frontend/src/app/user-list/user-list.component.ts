import { Component, OnInit, OnChanges } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { Router } from '@angular/router';

import { User } from '../models/User';
import { UserService } from '../services/user.service';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit{

 public users: any[] = [];
 public user: User;
 constructor(private userService: UserService, private authService: AuthService, router: Router) { }

 ngOnInit() {
   this.userService.getAllUsers().then(res => {
     if (res) {
       this.users = res;
       //to delete current user
       this.deleteUserFromList(this.authService.getUsername());
     }
   });
   console.log("ng feed  init")
 }

 ngOnChanges() {
   this.userService.getAllUsers().then(res => {
     if (res) {
       this.users = res;
       this.deleteUserFromList(this.authService.getUsername());
     }
   });
 }

 //Method to delete current user from users list
 deleteUserFromList(username: string){
  const index: number = this.users.map(e=>e.username).indexOf(username);
  if(index !==-1){
    this.users.splice(index, 1);
  }
 }
}

