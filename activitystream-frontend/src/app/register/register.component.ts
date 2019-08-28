import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { Router } from '@angular/router';
import { MessageService } from './../services/message.service';
import { AuthService } from '../services/auth.service';
import { User } from '../models/User';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
  
})
export class RegisterComponent implements OnInit {
 
  firstName: string;
  lastName: string;
  username: string;
  password: string;
  
  constructor(private authsvc:AuthService, private router: Router,private messageService: MessageService ) {}
  
  public ngOnInit() {}
  
  user=new User();
   registerUser() {
    this.authsvc.registerUser(this.username,this.password,this.firstName,this.lastName).then
      (obj=>{
        if(obj){
          this.router.navigate(['/login']);
        }
        else{
          console.log("no token found");
        }
      });
      
  }
}