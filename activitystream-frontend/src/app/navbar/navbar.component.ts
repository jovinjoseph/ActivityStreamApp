import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { Observable } from 'rxjs/Observable';
import {User } from '../models/User';
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
	public title = "Activity Stream";
  user: Observable<User>;
  username: string;
  public isUserLoggedIn = false; 

  constructor(private authService: AuthService) { }

  ngOnInit() {
    this.username = this.authService.getUsername();
    this.isUserLoggedIn = localStorage.getItem("jwt_token") === null ? false : true;
  }
}
