import { Component, OnInit} from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { Router } from '@angular/router';
import { MessageService } from './../services/message.service';
import { AuthService } from '../services/auth.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  
})
export class LoginComponent implements OnInit {

  username: string;
  password: string;
  loading: string;
  
  
constructor(private authsvc : AuthService,private router: Router,private messageService: MessageService) {}
  
ngOnInit() {}

  //User login method with username and password as input
  loginUser() {
    this.authsvc.login(this.username,this.password).
    then(obj=>
    {
      if(obj["token"]){
        this.authsvc.setToken(obj["token"]);
        this.authsvc.setUsername(this.username);
        console.log("user name::"+this.username);

        this.messageService.success("Welcome to your Activity Stream space!");
        this.router.navigate(['/message']);
        window.location.reload();        
      }
      else{
        console.log("No token found");
        this.messageService.error("Invalid Credentials! Please provide right credentials.");
        this.router.navigate(['/login']);
      }
    });
  }
}

      